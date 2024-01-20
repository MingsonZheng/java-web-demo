package com.zzm.controller;

import com.zzm.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cookie, HttpSession演示
 *
 * Cookie
 * 优点:
 *  HTTP协议中支持的技术
 * 缺点:
 *  移动端APP无法使用
 *  Cookie不安全，用户可以自己禁用cookie
 *  Cookie不能跨域
 *
 * HttpSession
 * 优点:
 *  存储在服务端，安全
 * 缺点:
 *  服务器集群环境下无法直接使用session
 *  Cookie的缺点
 *
 * 令牌技术
 * 优点:
 *  支持PC端、移动端
 *  解决集群环境下的认证问题
 *  减轻服务器端存储压力
 * 缺点:
 *  需要自己实现
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@RestController
public class SessionController {

    // 设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username", "zzm"));// 设置Cookie/响应Cookie
        return Result.success();
    }

    // 获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();// 获取所有的Cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_username")) {// 输出name为 login_username 的 cookie
                System.out.println("login_username: " + cookie.getValue());
            }
        }
        return Result.success();
    }

    // 往session中存储数
    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        log.info("HttpSession-s1: {}", session.hashCode());

        session.setAttribute("loginUser", "tom");// 往session中存储数
        return Result.success();
    }

    // 从HttpSession中获取值
    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());

        Object loginUser = session.getAttribute("loginUser");// 从Httpsession中获取值
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }
}
