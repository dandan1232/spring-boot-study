package top.danbao.boot.basic.service;

import top.danbao.boot.basic.entity.Book2;

import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 17:02
 * @description:
 */
public interface Book2Service {
    Book2 save(Book2 book2);

    List<Book2> getAll();
}
