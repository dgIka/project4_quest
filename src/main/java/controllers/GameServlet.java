package controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Game;
import models.scenes.Option;
import models.Player;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game;
        Player player;
        if (session.getAttribute("Game") == null) {
            player = new Player();
            session.setAttribute("Player", player);
            game = new Game(player);
            session.setAttribute("Game", game);
        } else {
            player = (Player) session.getAttribute("Player");
            game = (Game) session.getAttribute("Game");
        }

        req.setAttribute("text", game.getCaveScene().getCurrentDialogId());
        req.setAttribute("options", game.getCaveScene().getOptions(player));

        req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Game game = (Game) session.getAttribute("Game");
        if (game.isGameOver()) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/end.jsp");
            dispatcher.forward(req, resp);
        }

        if (session.getAttribute("Game") == null) {}







    }

}
