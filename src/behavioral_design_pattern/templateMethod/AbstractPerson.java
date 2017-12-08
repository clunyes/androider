package behavioral_design_pattern.templateMethod;

public abstract class AbstractPerson {

    abstract void dressUp();

    abstract void eatBreakfast();

    abstract void takeThings();

    public void prepareGotoSchool() {
        dressUp();
        eatBreakfast();
        takeThings();
    }
}
