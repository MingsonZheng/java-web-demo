package com.zzm.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.zzm.pojo.Result;
import com.zzm.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器(Interceptor)
 * 概念: 是一种动态拦截方法调用的机制，类似于过滤器。Spring框架中提供的，用来动态拦截控制器方法的执行。
 * 作用: 拦截请求，在指定的方法调用前后，根据业务需要执行预先设定的代码。
 *
 * Filter与Interceptor
 * 接口规范不同: 过滤器需要实现Filter接口，而拦截器需要实现HandlerInterceptor接口。
 * 拦截范围不同: 过滤器Filter会拦截所有的资源，而Interceptor只会拦截Spring环境中的资源。
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源方法运行前运行，返回true: 放行，放回false，不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//        System.out.println("preHandle...");

        // 1.获取请求url。
        String url = req.getRequestURL().toString();
        log.info("请求的url：{}", url);

        // 2.判断请求ur1中是否包含login，如果包含，说明是登录操作，放行。
        if (url.contains("login")) {
            log.info("登录操作，放行...");
            return true;
        }

        // 3.获取请求头中的令牌(token)。
        String jwt = req.getHeader("token");

        // 4.判断令牌是否存在，如果不存在，返回错误结果(未登录)。
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        // 5.解析token，如果解析失败，返回错误结果(未登录)。
        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) { //jwt解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        // 6.放行。
        log.info("令牌合法，放行");
        return true;
    }

    @Override //目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle...");
    }

    @Override //视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("afterCompletion...");
    }
}
