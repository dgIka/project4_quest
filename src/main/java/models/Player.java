package models;

import java.util.Objects;


//Класс хранящий состояние игрока
public class Player {
    private int hp;

    private String currentSceneId;

    private int currentDialogId;

    public Player() {
        this.hp = 3;
        this.currentDialogId = 1;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return hp == player.hp;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hp);
    }

    public int getCurrentDialogId() {
        return currentDialogId;
    }

    public void setCurrentDialogId(int currentDialogId) {
        this.currentDialogId = currentDialogId;
    }

    public String getCurrentSceneId() {
        return currentSceneId;
    }

    public void setCurrentSceneId(String currentSceneId) {
        this.currentSceneId = currentSceneId;
    }
}
