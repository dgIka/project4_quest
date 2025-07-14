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






}
