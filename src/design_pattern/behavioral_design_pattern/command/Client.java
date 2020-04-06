package design_pattern.behavioral_design_pattern.command;

public class Client {

    public static void main(String[] args) {
        Tv tv = new Tv();

        CommandOn commandOn = new CommandOn(tv);

        CommandOff commandOff = new CommandOff(tv);

        CommandChange commandChange = new CommandChange(tv, 100);
// 命令控制对象
        Control control = new Control(commandOn, commandOff, commandChange);
        // 开机
        control.turnOn();
        // 切换频道
        control.changeChannel();
        // 关机
        control.turnOff();
    }
}
