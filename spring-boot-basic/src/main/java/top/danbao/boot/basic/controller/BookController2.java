package top.danbao.boot.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.danbao.boot.basic.entity.Book2;
import top.danbao.boot.basic.service.Book2Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 17:17
 * @description:
 */
@Controller
@RequestMapping(value = "/")
public class BookController2 {
    @Resource
    private Book2Service book2Service;

    @GetMapping()
    public String bookPage(Model model){
        model.addAttribute("message","Hello SpringBoot");
        List<Book2> book2List =book2Service.getAll();
        model.addAttribute("book2List",book2List);
        return "book2";
    }
}