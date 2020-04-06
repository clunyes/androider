package design_pattern.creational_design_pattern.builder;

public class Client {

    public static void main(String[] args) {
        Student stu = new Student.Builder("icecode", 22, 178, 1)
                .setSchoolName("BUPT").setProfession("Computer Science and Technology").
                        setGradeNo(20091012).build();
        System.out.println(stu.toString());
    }
}
