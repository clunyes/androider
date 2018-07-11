package design_pattern.creational_design_pattern.prototype;

public class ConcretePrototype2 implements Prototype {
    private String name;

    @Override
    public Object clone() {
        Prototype prototype = new ConcretePrototype2();
        prototype.setName(this.name);
        return prototype;
    }

    public String toString() {
        return "Now in Prototype2 , name = " + this.name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
