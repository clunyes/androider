package design_pattern.behavioral_design_pattern.templateMethod;

public class Student extends AbstractPerson {
    @Override
    void dressUp() {
        System.out.println("小学生穿校服");
    }

    @Override
    void eatBreakfast() {
        System.out.println("吃妈妈做的早饭");
    }

    @Override
    void takeThings() {
        System.out.println("带上作业，准备上学");
    }
}
