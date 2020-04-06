package design_pattern.behavioral_design_pattern.iterator;

public class Client {

    public static void main(String[] args) {
        List list = new ConcreteList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
