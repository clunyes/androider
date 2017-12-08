package behavioral_design_pattern.observer;

public class Reader implements Observer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        System.out.println(name + "收到报纸，内容是：" + ((NewsPage) subject).getContent());
    }
}
