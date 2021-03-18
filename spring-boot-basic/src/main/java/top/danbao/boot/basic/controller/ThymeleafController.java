package top.danbao.boot.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 14:21
 * @description:
 */
@Controller
public class ThymeleafController {
    @GetMapping("/su")
    public String success() {
        return "success";
        //  相当于访问 classpath:/templates/success.html
    }
}