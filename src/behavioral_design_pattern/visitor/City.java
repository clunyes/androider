package behavioral_design_pattern.visitor;

import java.util.ArrayList;

public class City implements Element {
    private ArrayList<Element> places = new ArrayList<>();

    public City() {
        places.add(new Park());
        places.add(new Museum());
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("City is accepting visitor.");
        visitor.visit(this);

        for (Element e : places) {
            e.accept(visitor);
        }
    }
}
