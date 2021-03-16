package top.danbao.boot.basic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import top.danbao.boot.basic.controller.dto.AjaxResponse;
import top.danbao.boot.basic.entity.Article;
import top.danbao.boot.basic.service.ArticleService;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author: 蛋宝
 * @date: 2021/3/6 15:30
 * @description:
 */
@RestController
@RequestMapping(value = "api/v1/articles")
@Slf4j
public class ArticleController {
    @Resource
    private ArticleService articleService;


    /**
     * 查询所有文章
     */
    @ApiOperation(value = "查询所有文章", notes = "查询所有文章")
    @GetMapping("all")
    public AjaxResponse selectArticles() {
        List<Article> articleList = articleService.getAll();
        return AjaxResponse.success(articleList);
    }

    /**
     * 增加⼀篇Article，使⽤POST⽅法(RequestBody⽅式接收参数)
     *
     * @param article ⽂章实体
     * @return AjaxResponse
     */

    @PostMapping("body")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle" + article);
        boolean flag = articleService.postArticle(article);
        return AjaxResponse.success(article);
    }

    /**
     * 获取一篇Article,使用get方法，根据id查询一篇文章
     */
    @ApiOperation(value = "查询所有文章", notes = "查询所有文章")
    @GetMapping("{id}")
    public AjaxResponse getArticleById(@PathVariable("id") int id) {
        return AjaxResponse.success(articleService.getById(id));
    }

    /**
     * 删除一篇文章Article，使用DELETE方法，参数是id
     */
    @DeleteMapping()
    @ApiOperation(value = "删除文章", notes = "根据路径参数id来指定删除文章")
    public AjaxResponse deleteArticle(@PathVariable("id") int id) {
        log.info("deleteArticle:" + id);
        articleService.deleteArticle(id);
//        articles.remove(id);
        return AjaxResponse.success();
    }

    /**
     * 更新一篇文章Article，使用put方法
     *
     * @param article 文章实体
     * @return AjaxResponse
     */
    @PutMapping("/{id}")
//    @ApiImplicitParam(paramType = "path",dataType = "Integer",name = "id",value = "文章编号",required = true);
//    @ApiOperation(value ="更新文章信息");
    public AjaxResponse updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return AjaxResponse.success(article);
    }

//    /*创建线程安全的Map，模拟articles信息的存储*/
//    static Map<Integer, Article> articles = Collections.synchronizedMap(new HashMap<>());
//
//
//    /**
//     * 增加⼀篇Article ，@RequestParam接收参数
//     *
//     * @param id      id,⾮必需，默认值
//     * @param author  作者,⾮必需，默认值
//     * @param title   标题，必需
//     * @param content 内容，必需
//     *                //*      @param createTime 创建时间,⾮必需，默认值
//     * @return AjaxResponse
//     */
//    @PostMapping("param")
//    public AjaxResponse saveArticle(
//            @RequestParam(value = "id", defaultValue = "111", required = false) int id,
//            @RequestParam(value = "author", defaultValue = "ldd", required = false) String author,
//            @RequestParam String title,
//            @RequestParam String content,
//            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//            @RequestParam(value = "updateTime", defaultValue = "2021-03-06 15:15:15", required = false) Date updateTime) {
//        Article article = Article.builder()
//                .id(id)
//                .title(title)
//                .content(content)
//                .author(author)
//                .updateTime(updateTime)
//                .build();
//        log.info("saveArticle:" + article);
//
//        return AjaxResponse.success(article);
//    }
//
//    /**
//     * 增加⼀篇Article @RequestParam取得表单对象序列化的字符串
//     *
//     * @param formData 表单对象序列化的字符串
//     * @re
//     */
//
//    @PostMapping("form")
//    public AjaxResponse saveArticleByForData(@RequestParam("formData") String formData) {
////        表单传递的数据微字符串
//        log.info("formData:" + formData);
//        //⽤Jackson的反序列化将字符串转为Java对象
//        ObjectMapper objectMapper = new ObjectMapper();
//        Article article = null;
//        try {
//            article = objectMapper.readValue(formData,
//                    Article.class);
//            log.info("article:" + article);
//        } catch (
//                JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return AjaxResponse.success(article);
//    }
/*    String str= "{\"id\": 111,\"author\": \"lddd\",\"title\":\"SpringBoot\",\"content\": \"入门\"" +
            "}";*/

}