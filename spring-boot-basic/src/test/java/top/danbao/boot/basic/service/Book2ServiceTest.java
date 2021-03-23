package top.danbao.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.danbao.boot.basic.entity.Book2;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 17:12
 * @description:
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class Book2ServiceTest {

    @Resource
    private Book2Service book2Service;

//    @Test
//    void save(){
//        Book2 book2=Book2.builder()
//                .name("111")
//                .cover("111")
//                .build();
//        Book2 saveBook2 = book2Service.save(book2);
//        log.info("id:"+saveBook2.getId());
//        assertEquals("111",saveBook2.getName());
//    }

    @Test
    void getAll() {
        List<Book2> book2s = book2Service.getAll();
        log.info("books:"+book2s);
        assertEquals(3,book2s.size());
    }
}