package design_pattern.behavioral_design_pattern.templateMethod;

public class Teacher extends AbstractPerson {
    @Override
    void dressUp() {
        System.out.println("老师穿上教师服");
    }

    @Override
    void eatBreakfast() {
        System.out.println("做早饭，给孩子吃饭");
    }

    @Override
    void takeThings() {
        System.out.println("带上批改的作业，准备上班");
    }
}
