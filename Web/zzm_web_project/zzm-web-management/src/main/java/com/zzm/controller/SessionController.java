package com.zzm.controller;

import com.zzm.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cookie, HttpSession演示
 *
 * 优点:
 *  HTTP协议中支持的技术
 * 缺点:
 *  移动端APP无法使用
 *  Cookie不安全，用户可以自己禁用cookie
 *  Cookie不能跨域
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
}
