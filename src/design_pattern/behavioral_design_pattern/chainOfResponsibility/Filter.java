package design_pattern.behavioral_design_pattern.chainOfResponsibility;

public interface Filter {

    void doFilter(Request request, Response response, FilterChain chain);
}
