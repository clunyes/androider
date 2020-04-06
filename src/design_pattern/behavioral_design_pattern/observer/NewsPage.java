package design_pattern.behavioral_design_pattern.observer;

public class NewsPage extends Subject {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyObservers();
    }
}
