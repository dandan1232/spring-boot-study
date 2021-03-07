package top.danbao.boot.basic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import top.danbao.boot.basic.controller.dto.AjaxResponse;
import top.danbao.boot.basic.entity.Article;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 蛋宝
 * @date: 2021/3/6 15:30
 * @description:
 */
@RestController
@RequestMapping(value = "api/v1/articles")
@Slf4j
public class ArticleController {
    //    创建线程安全的Map，模拟articles信息的存储
    static Map<Integer, Article> articles= Collections.synchronizedMap(new HashMap<>());

//      增加⼀篇Article，使⽤POST⽅法(RequestBody⽅式接收参数)
//      @param article ⽂章实体
//      @return AjaxResponse

    @PostMapping("body")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle" + article);
        return AjaxResponse.success(article);
    }


    //      增加⼀篇Article ，@RequestParam接收参数
//     @param id id,⾮必需，默认值
//      @param author 作者,⾮必需，默认值
//      @param title 标题，必需
//      @param content 内容，必需
//      @param createTime 创建时间,⾮必需，默认值
//      @return AjaxResponse
    @PostMapping("param")
    public AjaxResponse saveArticle(
            @RequestParam(value = "id", defaultValue = "111", required = false) int id,
            @RequestParam(value = "author", defaultValue = "ldd", required = false) String author,
            @RequestParam String title,
            @RequestParam String content,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam(value = "createTime", defaultValue = "2021-03-06 15:15:15", required = false) Date createTime) {
        Article article = Article.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createTime(createTime)
                .build();
        log.info("saveArticle:" + article);

        return AjaxResponse.success(article);
    }

// 增加⼀篇Article @RequestParam取得表单对象序列化的字符串
//  @param formData 表单对象序列化的字符串
//  @re

    @PostMapping("form")
    public AjaxResponse saveArticleByForData(@RequestParam("formData") String formData) {
//        表单传递的数据微字符串
        log.info("formData:" + formData);
        //⽤Jackson的反序列化将字符串转为Java对象
        ObjectMapper objectMapper = new ObjectMapper();
        Article article = null;
        try {
            article = objectMapper.readValue(formData,
                    Article.class);
            log.info("article:" + article);
        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        }
        return AjaxResponse.success(article);
    }
/*    String str= "{\"id\": 111,\"author\": \"lddd\",\"title\":\"SpringBoot\",\"content\": \"入门\"" +
            "}";*/

}