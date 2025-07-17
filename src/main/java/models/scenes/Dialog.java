package models.scenes;

import java.util.List;


//Класс диалоговых кейсв
//содержит так же варианты ответов(Option)
public class Dialog {

    private String text;
    private List<Option> options;

    public Dialog(String text, List<Option> options) {

        this.text = text;
        this.options = options;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return text;
    }
}
