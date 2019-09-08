package com.louis.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lu
 * @create 2019-09-08 18:30
 */
@Slf4j
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器的类型 这里用pre，代表会再请求被路由之前执行
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否要被执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体执行逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String accessToken = request.getParameter("accessToken");
        log.info(request.getRequestURL().toString()+" 请求访问");

        if(accessToken == null){
            log.error("accessToken为空！");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("{\"result\":\"accessToken is empty!\"}");
            return null;
        }

        //  token判断逻辑
        log.info(request.getRequestURL().toString()+" 请求成功");
        return null;
    }
}
