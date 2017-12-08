package behavioral_design_pattern.command;

public class CommandChange implements Command {
    private Tv mTv;
    private int mChannel;

    public CommandChange(Tv tv, int channel) {
        mTv = tv;
        mChannel = channel;
    }

    @Override
    public void excute() {
        mTv.changeChannel(mChannel);
    }
}
