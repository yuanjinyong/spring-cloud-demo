/**
 * 
 */
package com.demo.service.gateway.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

/**
 * @author 袁进勇
 *
 */
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        // pre：路由之前
        // routing：路由之时
        // post： 路由之后
        // error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
        return true;
    }

    @Override
    public Object run() {
        // 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
        return null;
    }

}
