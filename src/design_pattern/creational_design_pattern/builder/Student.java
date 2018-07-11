package design_pattern.creational_design_pattern.builder;

public class Student {

    private String name;
    private int height;
    private int age;
    private int sex;
    //年级编号
    private int gradeNo;
    private String schoolName;
    //专业
    private String profession;
    //扩展信息
    private final String idCard;//身份证号
    private final String stuNo;//学号
    private final String labName;//实验室名称
    private final String dormitoryAddress;//宿舍地址

    public Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.sex = builder.sex;

        this.schoolName = builder.schoolName;
        this.profession = builder.profession;
        this.gradeNo = builder.gradeNo;

        this.idCard = builder.idCard;
        this.stuNo = builder.stuNo;
        this.labName = builder.labName;
        this.dormitoryAddress = builder.dormitoryAddress;
    }

    public static class Builder {
        private String name;
        private int height;
        private int age;
        private int sex;
        //年级编号
        private int gradeNo;
        private String schoolName;
        //专业
        private String profession;
        //身份证号
        private String idCard;
        //学号
        private String stuNo;
        //实验室名字
        private String labName;
        private String dormitoryAddress;//宿舍地址

        public Builder(String name, int age, int height, int sex) {
            super();
            this.name = name;
            this.age = age;
            this.height = height;
            this.sex = sex;
        }

        public Builder setSchoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }

        public Builder setProfession(String profession) {
            this.profession = profession;
            return this;
        }

        public Builder setGradeNo(int gradeNo) {
            this.gradeNo = gradeNo;
            return this;
        }


        public Builder setIdCard(String idCard) {
            this.idCard = idCard;
            return this;
        }

        public Builder setStuNo(String stuNo) {
            this.stuNo = stuNo;
            return this;
        }

        public Builder setLabName(String labName) {
            this.labName = labName;
            return this;
        }

        public Builder setDormitoryAddress(String dormitoryAddress) {
            this.dormitoryAddress = dormitoryAddress;
            return this;
        }

        //构造器入口
        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Students [name=" + name + ", age=" + age + ", height=" + height
                + ", sex=" + sex + ", schoolName=" + schoolName
                + ", profession=" + profession + ", gradeNo=" + gradeNo + "]";
    }
}
