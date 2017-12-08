package behavioral_design_pattern.ChainOfResponsibility;

public interface Filter {

    void doFilter(Request request, Response response, FilterChain chain);
}
