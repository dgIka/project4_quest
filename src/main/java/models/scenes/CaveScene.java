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
                "Что произошло? Как ты тут оказался? На эти вопросы ответов у тебя нет" +
                "Что будешь делать?",
                List.of(new Option(1, "Взять факел.", 2),
                new Option(2, "Осмотреться.", 13),
                new Option(3, "Попытаться найти выход.", 5))));

        this.dialogs.put(2, new Dialog("Ты протягиваешь руку в сторону факела.",
                List.of(new Option(1, "Аккуратно нащупать основание факела.", 4),
                        new Option(2, "Взяться за тлеющую лучину.", 3, true))));

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
                List.of(new Option(1, "Все равно идти вперед", 7),
                        new Option(2, "Наверное все же стоит взять факел", 2))));

        this.dialogs.put(6, new Dialog("Петляя по темной пещере, ты доходишь до развилки. " +
                "Ветер дует слева. Куда пойдешь?", List.of(new Option(1, "Налево", 8)
                , new Option(2, "Направо", 7))));

        this.dialogs.put(7, new Dialog("Спустя недолгое время ты утыкаешься в тупик. " +
                "На стене висят 2 горящих факела. А посередине под ногами у тебя деревянный сундук. Выглядит подозрительно."
                , List.of(new Option(1, "Открыть сундук.", 9, true)
                , new Option(2, "Не трогать сундук. Вернуться к поиску выхода.", 8)
                , new Option(3, "Изучить сундук внимательно.", 10))));

        this.dialogs.put(8 , new Dialog("После недолгой прогулки по прямой, ты наконец видишь свет - выход!"
                , List.of(new Option(1 , "Скорее наружу", 1, "Forest")
                , new Option(2, "Вернуться назад", 6))));

        this.dialogs.put(9, new Dialog("Как опрометчиво. Это был мимик. " +
                "Тебе удалось ускользнуть, но зубастый сундук смог разок тебя укусить."
                , List.of(new Option(1, "Пойти к выходу от развилки.", 8))));

        this.dialogs.put(10, new Dialog("Ты видишь сбоку этого сундука цепь. " +
                "Откудато ты знаешь, что по цепи можно определить мимика." +
                "Но у этого мимика цепь правильной формы и с той стороны."
                , List.of(new Option(1, "Это не мимик. Открыть сундук.", 9, true)
                        , new Option(2, "Ну а вдруг сработает? Ударить сундук", 11)
                        , new Option(3, "Лучше не рисковать и вернуться назад.", 8))));

        this.dialogs.put(11, new Dialog("Удивительно но это дало эффект. Характерный звук, " +
                "напоминающий крик или вой. " +
                "Рассеивающаяся магическая аура. " +
                "Все это говорит о том, что на сундуке была магическая ловушка. Но теперь похоже ее нет, " +
                "однако ты все равно чувствуешь магию. Что будешь делать?"
                , List.of(new Option(1 , "Открыть сундук.", 12)
                , new Option(2, "Вернуться назад", 6))));

        this.dialogs.put(12, new Dialog("Не успеваешь ты приподнять крышку сундука, " +
                "как пространство вокруг начинает плыть перед глазами. " +
                "Голова кружится, а глаза медленно закрываются"
                , List.of(new Option(1 , "Дальше", 1, "Interview"))));

        this.dialogs.put(13, new Dialog("Куда не посмотри, везде тьма. " +
                "Идти вслепую - чистое самоубийство. Что делать?"
                , List.of(new Option(1, "Идем вслепую.", 5)
                , new Option(2, "Взять факел", 2))));

//        this.dialogs.put(, new Dialog("", List.of(new Option(, "",))));
//        , new Option(, "",)

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
