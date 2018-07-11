package design_pattern.behavioral_design_pattern.command;

public class CommandOn implements Command {
    private Tv mTv;

    public CommandOn(Tv tv) {
        mTv = tv;
    }

    @Override
    public void excute() {
        mTv.turnOn();
    }
}
