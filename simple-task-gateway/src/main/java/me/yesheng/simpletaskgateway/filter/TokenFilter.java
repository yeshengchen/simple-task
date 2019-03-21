package me.yesheng.simpletaskgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Chenys
 */
@Component
public class TokenFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);


    @Override
    public String filterType() {
        // 支持 pre,routing,post,error
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 可以实现具体逻辑判断是否要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("{} >>> url:{}", request.getMethod(), request.getRequestURL().toString());
        logger.info("{} >>> uri:{}", request.getMethod(), request.getRequestURI().toString());

        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                logger.info("response write exception. msg:{}", e.getMessage(), e);
            }
            return null;
        }
        logger.info("token verify success!");
        return null;
    }
}
