package design_pattern.structural_design_pattern.composite;

public abstract class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void addCompany(Company company);

    abstract void removeCompany(Company company);

    abstract void display(int depth);
}
