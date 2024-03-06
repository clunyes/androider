package design_pattern.behavioral_design_pattern.chainOfResponsibility;

/**
 * html 过滤
 */
public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String reqStr = request.getRequestStr();
        reqStr = reqStr.replace('<', '[').replace('>', ']') +
                //后面添加的是便于我们观察代码执行步骤的字符串
                "----HTMLFilter()";
        request.setRequestStr(reqStr);
        chain.doFilter(request, response, chain);
        String respStr = response.getResponseStr();
        respStr += "---HTMLFilter()";
        response.setResponseStr(respStr);
    }
}
