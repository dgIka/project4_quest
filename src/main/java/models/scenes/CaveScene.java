package models.scenes;

import models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaveScene extends AbstractScene {

    private String id = "Cave";

    private Map<Integer, Dialog> dialogs;



    public CaveScene(Player player) {
        this.currentDialogId = player.getCurrentDialogId();
        player.setCurrentSceneId(this.id);

        this.dialogs = new HashMap<>();

        this.dialogs.put(1, new Dialog("Ты приходишь в себя посреди холодной пещеры. Света нет." +
                " Вокруг тьма и только, слегка тлеющий факел, лежащий рядом, подтверждает, что глаза твои открыты. " +
                "Что будешь делать?",
                List.of(new Option(1, "Взять факел.", 2),
                new Option(2, "Осмотреться.", 1),
                new Option(3, "Попытаться найти выход.", 5))));

        this.dialogs.put(2, new Dialog("Ты протягиваешь руку в сторону факела.",
                List.of(new Option(1, "Аккуратно нащупать основание факела.", 4),
                        new Option(2, "Взяться за тлеющую лучину.", 3))));

        this.dialogs.put(3, new Dialog("Ты обжегся. Это было довольно очевидно. " +
                "Ты берешь факел как надо, разжигаешь его и осматриваешься. " +
                "Вокруг просторная пещера. Света факела едва хватает, чтобы видеть что у тебя перед носом." +
                "По колыханию огня ты понимаешь откуда дует ветер - там выход.",
                List.of(new Option(1, "Вперед.", 6))));

        this.dialogs.put(4, new Dialog("Ты берешь факел и разжигаешь его." +
                "Вокруг просторная пещера. Света факела едва хватает, чтобы видеть что у тебя перед носом." +
                "По колыханию огня ты понимаешь откуда дует ветер - там выход.",
                List.of(new Option(1, "Вперед.", 6))));


        this.dialogs.put(5, new Dialog("Встав на ноги, ты принимаешь решение идти вслепую" +
                "Инстинкт самосохранения так и сигналит, что это плохая идея.",
                List.of(new Option(1, "Все равно идти вперед", 6),
                        new Option(2, "Наверное все же стоит взять факел", 2))));

//        this.dialogs.put(, new Dialog("", List.of(new Option(, "",))));

    }



    @Override
    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, Dialog> getDialogs() {
        return dialogs;
    }

    public void setDialogs(Map<Integer, Dialog> dialogs) {
        this.dialogs = dialogs;
    }


}
