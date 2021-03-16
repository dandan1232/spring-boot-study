package top.danbao.boot.basic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.danbao.boot.basic.dao.ArticleDAO;
import top.danbao.boot.basic.entity.Article;
import top.danbao.boot.basic.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/16 14:29
 * @description:
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDAO articleDAO;


    @Override
    public boolean postArticle(Article article){
        Article saveArticle = articleDAO.save(article);
//        int [][] array = {{1,2,3},{1,4}};
//        System.out.println(array[1][2]);
        return saveArticle !=null;
    }


    @Override
    public boolean deleteArticle(int id) {
        int row = articleDAO.deletById(id);
        return row != 0;
    }

    @Override
    public boolean updateArticle(Article article) {
        int row=articleDAO.update(article);
        return row != 0;
    }

    @Override
    public Article getById(int id) {
        return articleDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleDAO.findAll();
    }
}