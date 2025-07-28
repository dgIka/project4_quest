import models.Game;
import models.Player;
import models.scenes.Dialog;
import models.scenes.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    private Player player;
    private Dialog dialog;

    @BeforeEach
    void setUp() {
        game = new Game();
        player = game.getPlayer();
        dialog = game.getCurrentDialog();
    }

    @Test
    void shouldReturnInitializedData() {
        assertAll(
                () -> assertEquals("Cave", game.getCurrentSceneId()),
                () -> assertNotNull(game.getCaveScene()),
                () -> assertNull(game.getInterviewScene()),
                () -> assertNull(game.getForestScene()),
                () -> assertNotNull(game.getPlayer())
        );
    }

    @Test
    void shouldReturnPlayerData() {
        assertAll(
                () -> assertEquals(3, player.getHp()),
                () -> assertEquals("Cave", player.getCurrentSceneId()),
                () -> assertEquals(1, player.getCurrentDialogId())
        );
    }

    @Test
    void shouldDecreasePlayerHp() {
        game.decreaseHealth(player);
        assertEquals(2, player.getHp());
    }

    @Test
    void shouldReturnOption() {
        Option option  = dialog.getOptions().get(0);

        assertAll(
                () -> assertEquals(1, option.getId()),
                () -> assertEquals(2, option.getResult()),
                () -> assertNull(option.getNextScene()),
                () -> assertEquals("Взять факел.", option.getText()),
                () -> assertFalse(option.isDecreasedHp())
        );

    }

    @Test
    void shouldChangeDialogByChoice() {
        Option option  = dialog.getOptions().get(0);
        game.getPlayer().setCurrentDialogId(option.getResult());

        assertAll(
                () -> assertEquals(2, game.getPlayer().getCurrentDialogId()),
                () -> assertEquals(2, game.getCurrentDialogOptions().size()),
                () -> assertEquals("Ты протягиваешь руку в сторону факела."
                        , game.getCaveScene().getDialogs().get(2).getText())
        );

    }

    @Test
    void shouldChangeScene() {
        game.setNewScene("Interview");
        assertEquals("Interview", game.getCurrentSceneId());
        game.setNewScene("Forest");
        assertEquals("Forest", game.getCurrentSceneId());
    }

    @Test
    void shouldReturnOptionByResult() {
        Option option = game.getOptionByResult(2);
        assertAll(
                () -> assertEquals(1, option.getId()),
                () -> assertEquals("Взять факел.", option.getText()),
                () -> assertFalse(option.isDecreasedHp()),
                () -> assertEquals(2, option.getResult()),
                () -> assertNull(option.getNextScene())
        );
    }



}
