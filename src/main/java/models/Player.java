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
        this.currentSceneId = "Cave";
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
