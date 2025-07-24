package models.scenes;

import models.Player;

import java.util.HashMap;
import java.util.Map;

public class InterviewScene extends AbstractScene {

    private String id = "Interview";

    private Map<Integer, Dialog> dialogs;

    public InterviewScene(Player player) {
        this.currentDialogId = player.getCurrentDialogId();
        player.setCurrentSceneId(this.id);

        this.dialogs = new HashMap<>();

        this.dialogs.put(1, new Dialog("Вы видите перед собой молодую девушку в очках. " +
                "Она пристально смотрит на вас. Ну ", List.of(new Option(, "",))));


//        this.dialogs.put(, new Dialog("", List.of(new Option(, "",))));
//        , new Option(, "",)
    }

    @Override
    public String getId() {
        return id;
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
