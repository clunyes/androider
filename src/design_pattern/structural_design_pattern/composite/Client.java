package design_pattern.structural_design_pattern.composite;

public class Client {

    public static void main(String[] args) {
        Company root = new ConcreteCompany();
        root.setName("北京总公司");
        root.addCompany(new HRDepartment("总公司人力资源部"));
        root.addCompany(new FinanceDepartment("总公司财务部"));
        Company shandongCom = new ConcreteCompany("山东分公司");
        shandongCom.addCompany(new HRDepartment("山东分公司人力资源部"));
        shandongCom.addCompany(new FinanceDepartment("山东分公司账务部"));
        Company zaozhuangCom = new ConcreteCompany("枣庄办事处");
        zaozhuangCom.addCompany(new FinanceDepartment("枣庄办事处财务部"));
        zaozhuangCom.addCompany(new HRDepartment("枣庄办事处人力资源部"));
        Company jinanCom = new ConcreteCompany("济南办事处");
        jinanCom.addCompany(new FinanceDepartment("济南办事处财务部"));
        jinanCom.addCompany(new HRDepartment("济南办事处人力资源部"));
        shandongCom.addCompany(jinanCom);
        shandongCom.addCompany(zaozhuangCom);
        Company huadongCom = new ConcreteCompany("上海华东分公司");
        huadongCom.addCompany(new HRDepartment("上海华东分公司人力资源部"));
        huadongCom.addCompany(new FinanceDepartment("上海华东分公司账务部"));
        Company hangzhouCom = new ConcreteCompany("杭州办事处");
        hangzhouCom.addCompany(new FinanceDepartment("杭州办事处财务部"));
        hangzhouCom.addCompany(new HRDepartment("杭州办事处人力资源部"));
        Company nanjingCom = new ConcreteCompany("南京办事处");
        nanjingCom.addCompany(new FinanceDepartment("南京办事处财务部"));
        nanjingCom.addCompany(new HRDepartment("南京办事处人力资源部"));
        huadongCom.addCompany(hangzhouCom);
        huadongCom.addCompany(nanjingCom);
        root.addCompany(shandongCom);
        root.addCompany(huadongCom);
        root.display(0);
    }
}
