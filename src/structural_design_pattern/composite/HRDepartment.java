package structural_design_pattern.composite;

//hr部门
public class HRDepartment extends Company {
    public HRDepartment() {

    }

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    protected void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
    }

    @Override
    void addCompany(Company company) {

    }

    @Override
    void removeCompany(Company company) {

    }
}
