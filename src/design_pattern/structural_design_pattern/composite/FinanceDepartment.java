package design_pattern.structural_design_pattern.composite;

//财务部
public class FinanceDepartment extends Company {
    public FinanceDepartment() {

    }

    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    void addCompany(Company company) {

    }

    @Override
    void removeCompany(Company company) {

    }

    @Override
    void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
    }
}
