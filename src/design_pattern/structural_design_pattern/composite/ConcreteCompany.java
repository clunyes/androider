package design_pattern.structural_design_pattern.composite;


import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company {

    private List<Company> companyList;

    public ConcreteCompany() {
        companyList = new ArrayList<>();
    }

    public ConcreteCompany(String name) {
        super(name);
        companyList = new ArrayList<>();
    }

    @Override
    void addCompany(Company company) {
        companyList.add(company);
    }

    @Override
    void removeCompany(Company company) {
        companyList.remove(company);
    }

    @Override
    void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
        for (Company company : companyList) {
            company.display(depth + 2);
        }
    }
}
