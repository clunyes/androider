package behavioral_design_pattern.mediator.interf;

public abstract class Colleage {
    private Mediator mediator;//每个租户有他的租户信息

    public Colleage(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void change() {
        mediator.colleageChange(this);
    }
}
