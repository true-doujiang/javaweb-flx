package cn.itcast.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport {

    private String site;
    private String page;

    public void setSite(String site) {
        this.site = site;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public void doTag() throws JspException, IOException {
        //看来访问者是从哪个页面来的
        PageContext pageContext = (PageContext) this.getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        //1、得到来防止的referer
        String referer = request.getHeader("referer");  //http://www.sina.com/index.html

        //2、判断
        if (referer == null || !referer.startsWith(site)) {
            String webroot = request.getContextPath();  //day11_example
            //这里主要是判断page从接收过来的路径的3种情况
            if (page.startsWith(webroot)) {    //   day11_example/index.jsp
                response.sendRedirect(page);
            } else if (page.startsWith("/")) { //   /index.jsp
                response.sendRedirect(webroot + page);
            } else {                            //   index.jsp
                response.sendRedirect(webroot + "/" + page);
            }
            //重定向后，控制保护的页面不要执行
            throw new SkipPageException();
        }

        //不是倒链者直接放过去
    }
}
