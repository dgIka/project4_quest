package models;

import models.scenes.CaveScene;
import models.scenes.Dialog;
import models.scenes.Option;

import java.util.List;

//Класс хранящий состояние игры, сцены и на котором я окончательно запутался
public class Game {
    private int id;

    private boolean gameActive;

    private boolean gameOver;

    private CaveScene caveScene;

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

    public boolean isGameActive() {
        return gameActive;
    }

    public void setGameActive(boolean gameActive) {
        this.gameActive = gameActive;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dialog getCurrentDialog() {
        return this.caveScene.getDialogs().get(player.getCurrentDialogId());
    }
    public List<Option> getCurrentDialogOptions() {
        if (currentSceneId.equals("Cave")) {
            return getCurrentDialog().getOptions();
        } else return null;
    }



    public void doChoice(int choice) {
        if (player.getCurrentDialogId() == 2 && choice == 2) {
            decreaseHealth(player);
        }
        player.setCurrentDialogId(choice);

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
}
