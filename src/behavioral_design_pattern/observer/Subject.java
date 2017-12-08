package behavioral_design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> readers = new ArrayList<>();

    /**
     * 增加观察者
     *
     * @param observer
     */
    public void attach(Observer observer) {
        readers.add(observer);
    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void detach(Observer observer) {
        readers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : readers) {
            observer.update(this);
        }
    }
}
