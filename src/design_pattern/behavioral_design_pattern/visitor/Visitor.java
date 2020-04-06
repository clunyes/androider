package design_pattern.behavioral_design_pattern.visitor;


public abstract class Visitor {
    abstract void visit(City city);

    abstract void visit(Museum museum);

    abstract void visit(Park park);
}
