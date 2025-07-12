package models.scenes;

import java.util.List;


//Класс диалоговых кейсв
//содержит так же варианты ответов(Option)
public class Dialog {
//    private int id;
    private String text;
    private List<Option> options;

    public Dialog(String text, List<Option> options) {
//        this.id = id;
        this.text = text;
        this.options = options;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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
}
