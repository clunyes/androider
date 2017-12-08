package behavioral_design_pattern.iterator;

public class ConcreteIterator implements Iterator {
    private List list;
    private int index;

    public ConcreteIterator(List list) {
        super();
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (list.size() > index) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object object = list.get(index);
        index++;
        return object;
    }
}
