package top.danbao.boot.basic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.danbao.boot.basic.entity.Book2;
import top.danbao.boot.basic.repository.BookRepository;
import top.danbao.boot.basic.service.Book2Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 17:03
 * @description:
 */
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class Book2ServiceImpl implements Book2Service {
    @Resource
    private BookRepository bookRepository;

    @Override
    public Book2 save(Book2 book2) {
        return bookRepository.save(book2);
    }

    @Override
    public List<Book2> getAll() {
        return bookRepository.findAll();
    }
}