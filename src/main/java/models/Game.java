package models;

import jakarta.servlet.http.HttpServletRequest;
import models.scenes.*;

import java.util.List;

//Класс хранящий состояние игры, сцены и на котором я окончательно запутался
public class Game {
    private int id;

    private CaveScene caveScene;

    private InterviewScene interviewScene;

    private ForestScene forestScene;

    private Player player;

    private String currentSceneId;

    public Game() {
        this.player = new Player();
        this.caveScene = new CaveScene(player);
        this.currentSceneId = player.getCurrentSceneId();
        this.player.setCurrentSceneId(currentSceneId);
    }

    public CaveScene getCaveScene() {
        return caveScene;
    }

    public void setCaveScene(CaveScene caveScene) {
        this.caveScene = caveScene;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dialog getCurrentDialog() {
        if (currentSceneId.equals("Cave")) {
            return this.caveScene.getDialogs().get(player.getCurrentDialogId());
        } else if (currentSceneId.equals("Interview")) {
            return this.interviewScene.getDialogs().get(player.getCurrentDialogId());
        } else if (currentSceneId.equals("Forest")) {
            return this.forestScene.getDialogs().get(player.getCurrentDialogId());
        } else return null;
    }

    public List<Option> getCurrentDialogOptions() {
            return getCurrentDialog().getOptions();
    }



    public void doChoice(Option option, HttpServletRequest req) {
        if(option.isDecreasedHp()) {
            decreaseHealth(player);
            req.setAttribute("healthDecreased", true);
        }
        player.setCurrentDialogId(option.getResult());

    }

    public void decreaseHealth(Player player) {
        if (player.getHp() > 0) {
            player.setHp(player.getHp() - 1);
        }
    }

    public String getCurrentSceneId() {
        return currentSceneId;
    }

    public void setCurrentSceneId(String currentSceneId) {
        this.currentSceneId = currentSceneId;
    }

    public void increaseHealth(Player player) {
        if (player.getHp() < 3) {
            player.setHp(player.getHp() + 1);
        }
    }

    public Option getOptionByResult(int result) {          //тот же геморрой только в классе а не сервлете, пока так
        return getCurrentDialogOptions().stream().filter(a -> a.getResult() == result).findFirst().get();
    }

    public void setNewScene(String newSceneId) {
        if (!currentSceneId.equals(newSceneId)) {
            if (newSceneId.equals("Interview")) {
                interviewScene = new InterviewScene(player);
                currentSceneId = newSceneId;
                getPlayer().setCurrentSceneId(newSceneId);
            } else if (newSceneId.equals("Forest")) {
                forestScene = new ForestScene(player);
                currentSceneId = newSceneId;
                getPlayer().setCurrentSceneId(newSceneId);
            }
        }
    }
}
