package structural_design_pattern.flyweight;

import java.util.Hashtable;

public class FlyweightFactory {
    private Hashtable<String, ConcreteFlyweight> flyWeights = new Hashtable<>();

    public FlyweightFactory() {

    }

    public ConcreteFlyweight factory(String str) {
        ConcreteFlyweight concreteFlyweight;
        concreteFlyweight = flyWeights.get(str);
        if (concreteFlyweight == null) {
            concreteFlyweight = new ConcreteFlyweight(str);
            flyWeights.put(str, concreteFlyweight);
        }
        return concreteFlyweight;
    }

    public int getFactorySize() {
        return flyWeights.size();
    }
}
