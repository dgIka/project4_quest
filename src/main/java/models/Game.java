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
        this.currentSceneId = caveScene.getId();
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



    void doChoice(int choice, Player player) {
        Option option = getCurrentDialog(player).getOptions().get(choice);
        if (choice == 2) {
            decreaseHealth(player);
        }
        player.setCurrentDialogId(option.getResult());
    }
}
