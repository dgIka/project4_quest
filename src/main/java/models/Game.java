package models;

import models.scenes.CaveScene;

//Класс хранящий состояние игры, сцены и на котором я окончательно запутался
public class Game {
    private int id;

    private boolean gameActive;

    private boolean gameOver;

    private CaveScene caveScene;

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

    public Game(Player player) {
        this.caveScene = new CaveScene(player);
    }
}
