package models.scenes;


//Класс вариантов ответов
//их айди и айди результата(Dialog) этих ответов
public class Option {

    private int id;

    private String text;

    private int result;

    public Option(int id, String text, int result) {
        this.id = id;
        this.text = text;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
