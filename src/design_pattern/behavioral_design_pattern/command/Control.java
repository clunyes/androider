package design_pattern.behavioral_design_pattern.command;

public class Control {

    private CommandOn mCommandOn;
    private CommandOff mCommandOff;
    private CommandChange mCommandChange;

    public Control(CommandOn commandOn, CommandOff commandOff, CommandChange commandChange) {
        this.mCommandChange = commandChange;
        this.mCommandOff = commandOff;
        this.mCommandOn = commandOn;
    }

    public void turnOn() {
        mCommandOn.excute();
    }

    public void turnOff() {
        mCommandOff.excute();
    }

    public void changeChannel() {
        mCommandChange.excute();
    }
}
