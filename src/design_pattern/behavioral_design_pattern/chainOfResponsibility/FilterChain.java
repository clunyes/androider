package design_pattern.behavioral_design_pattern.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();
    private int index;

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (filters.size() == index) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, chain);
    }
}
