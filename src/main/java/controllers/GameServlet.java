package controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Game;
import models.scenes.Dialog;
import models.scenes.Option;
import models.Player;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game;
        Player player;
        if (session.getAttribute("Game") == null) {
            game = new Game();
            session.setAttribute("Game", game);
        } else {
            game = (Game) session.getAttribute("Game");
        }

        req.setAttribute("sceneText", game.getCurrentDialog().getText());
        req.setAttribute("options", game.getCurrentDialogOptions());
        req.setAttribute("hp", game.getPlayer().getHp());

        for (Integer a: game.getCaveScene().getDialogs().keySet()) {
            System.out.println(a);
            System.out.println(game.getCaveScene().getDialogs().get(a));
        }

        req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = null;

        if (session.getAttribute("Game") != null) {
            game = (Game) session.getAttribute("Game");
        } else {
            RequestDispatcher dispatcherStart = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
            dispatcherStart.forward(req, resp);
        }
        if (game.isGameOver()) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/end.jsp");
            dispatcher.forward(req, resp);
        }
        System.out.println(req.getParameter("choice"));
        game.doChoice(Integer.parseInt(req.getParameter("choice")), req);

        req.setAttribute("sceneText", game.getCurrentDialog().getText());
        req.setAttribute("options", game.getCurrentDialogOptions());
        req.setAttribute("hp", game.getPlayer().getHp());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/game.jsp");
        dispatcher.forward(req, resp);



    }

}
