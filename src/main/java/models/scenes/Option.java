package models.scenes;


import lombok.Getter;
import lombok.Setter;

//Класс вариантов ответов
//их айди и айди результата(Dialog) этих ответов
@Getter
@Setter
public class Option {


    private int id;

    private String text;

    private int result;

    private String nextScene;

    private boolean isDecreasedHp;

    public Option(int id, String text, int result) {
        this.id = id;
        this.text = text;
        this.result = result;
    }

    public Option(int id, String text, int result, String nextScene) {
        this.id = id;
        this.text = text;
        this.result = result;
        this.nextScene = nextScene;
    }
    public Option(int id, String text, int result, boolean isDecreasedHp) {
        this.id = id;
        this.text = text;
        this.result = result;
        this.isDecreasedHp = isDecreasedHp;
    }

    @Override
    public String toString() {
        return text + " " + nextScene;
    }
}
