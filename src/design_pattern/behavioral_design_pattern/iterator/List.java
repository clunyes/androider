package design_pattern.behavioral_design_pattern.iterator;


public interface List {

    void add(Object object);
    Object get(int index);
    Iterator iterator();
    int size();
}
