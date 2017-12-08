package behavioral_design_pattern.command;

public class CommandOff implements Command {
    private Tv mTv;

    public CommandOff(Tv tv) {
        mTv = tv;
    }

    @Override
    public void excute() {
        mTv.turnOff();
    }
}
