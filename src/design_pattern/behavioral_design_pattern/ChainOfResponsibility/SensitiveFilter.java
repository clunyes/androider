package design_pattern.behavioral_design_pattern.ChainOfResponsibility;

/**
 * 敏感词过滤
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String reqStr = request.getRequestStr();
        reqStr = reqStr.replace("被就业", "就业").replace("敏感", "") +
                //后面添加的是便于我们观察代码执行步骤的字符串
                " ---sensitiveFilter()";
        request.setRequestStr(reqStr);
        chain.doFilter(request, response, chain);
        String respStr = response.getResponseStr();
        respStr += "---sensitiveFilter()";
        response.setResponseStr(respStr);
    }
}
