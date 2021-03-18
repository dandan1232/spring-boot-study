package top.danbao.boot.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.danbao.boot.basic.entity.Book1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 14:25
 * @description:
 */
@RestController
public class BookController1 {
    @GetMapping("/test")
    public ModelAndView test() {
        // 创建返回数据
        List<Book1> books = new ArrayList<>();
        Book1 b1 = new Book1(1, "java入门", "蛋宝");
        Book1 b2 = new Book1(2, "如何在食堂英勇干饭", "蛋蛋");
        Book1 b3 = new Book1(2, "我和小鸭子学走路", "林丹丹");
        books.add(b1);
        books.add(b2);
        books.add(b3);
        // 创建并返回 ModelAndView
        ModelAndView mv = new ModelAndView();
        // 设置返回的数据
        mv.addObject("books", books);
        //设置视图名
        mv.setViewName("index");
        return mv;
    }
}