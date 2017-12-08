package behavioral_design_pattern.iterator;

public class ConcreteList implements List {
    private Object[] list;
    private int index = 0;
    private int size = 0;

    public ConcreteList() {
        index = 0;
        size = 0;
        list = new Object[100];
    }

    @Override
    public void add(Object object) {
        list[index++] = object;
        size++;
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public int size() {
        return size;
    }
}
