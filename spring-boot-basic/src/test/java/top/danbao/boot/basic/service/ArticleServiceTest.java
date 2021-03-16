package top.danbao.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.danbao.boot.basic.entity.Article;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 14:46
 * @description:
 */
@SpringBootTest
@Slf4j
class ArticleServiceTest {

    @Resource
    private ArticleService articleService;

    @Test
    void postArticle() {
        Article article = Article.builder()
                .title("12222")
                .content("想干饭了")
                .author("林丹丹111")
                .build();
        log.info("article:" + article);
        boolean flag = articleService.postArticle(article);
        log.info("flag:" + flag);
        assertTrue(flag);
    }

    @Test
    void selectAll() {
        List<Article> articles = articleService.getAll();
        assertEquals(2, articles.size());
//        articles.forEach(System.out::println);
        articles.forEach(article -> {
            log.info("author:" + article.getAuthor());
            log.info("title:" + article.getTitle());
        });
    }

    @Test
    void testPostArticle() {
    }

    @Test
    void delete() {
        boolean flag = articleService.deleteArticle(2);
        assertTrue(flag);
    }

    @Test
    void update() {
        Article article = Article.builder()
                .id(1)
                .author("ldd111")
                .title("java")
                .content("javall")
                .updateTime(new Date())
                .build();
        boolean flag = articleService.updateArticle(article);
        assertTrue(flag);

    }

    @Test
    void getById() {
        Article realArticle = articleService.getById(1);
        Article expectedArticle = Article.builder()
                .author("ldd")
                .title("test")
                .content("test")
                .build();
        log.info("expectedArticle------" + expectedArticle);
        assertEquals(expectedArticle, realArticle);
    }


    @Test
    void getAll() {
    }
}