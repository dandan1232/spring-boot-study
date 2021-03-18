package top.danbao.boot.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.danbao.boot.basic.entity.Book2;

import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 16:55
 * @description:
 */
public interface BookRepository extends JpaRepository<Book2,Integer> {

}