package behavioral_design_pattern.ChainOfResponsibility;

/**
 * 过滤表情
 */
public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String reqStr = request.getRequestStr();
//将字符串中出现的":):"转换成"^V^";
        reqStr = reqStr.replace(":):", "^V^")
                //后面添加的是便于我们观察代码执行步骤的字符串
                + "----FaceFilter()";
        request.setRequestStr(reqStr);
        chain.doFilter(request, response, chain);
        String respStr = response.getResponseStr();
        respStr += "---FaceFilter()";
        response.setResponseStr(respStr);
    }
}
