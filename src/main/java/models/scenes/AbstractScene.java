package models.scenes;

import models.Player;

import java.util.List;
import java.util.Map;

//Общий класс для разных сцен
//так же содержит логику общих действий для всех сцен
public abstract class AbstractScene {

    int id;

    Map<Integer, Dialog> dialogs;

    int currentDialogId;


    public abstract String getId();

    public abstract Dialog getCurrentDialogId(Player player);

    public abstract List<Option> getOptions(Player player);


    public void decreaseHealth(Player player) {
        if (player.getHp() > 0) {
            player.setHp(player.getHp() - 1);
        }
    }
    public void increaseHealth(Player player) {
        if (player.getHp() < 3) {
            player.setHp(player.getHp() + 1);
        }
    }

    abstract void doChoice(int choice, Player player);
}
