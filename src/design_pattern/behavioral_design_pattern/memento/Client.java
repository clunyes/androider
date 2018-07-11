package design_pattern.behavioral_design_pattern.memento;

public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker caretaker = new CareTaker();
        //改变发起人对象的状态
        originator.setState("On");
        //创建备忘录对象，并将发起人对象的状态存储起来
        caretaker.saveMemento(originator.createMemento());
        //修改发起人对象的状态
        originator.setState("Off");
        //恢复发起人对象的状态
        originator.restoreMemento(caretaker.getMemento());

        //发起人对象的状态
        System.out.println("发起人对象的当前状态为：" + originator.getState());
    }
}
