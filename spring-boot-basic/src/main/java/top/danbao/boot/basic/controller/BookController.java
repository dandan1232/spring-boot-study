package top.danbao.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.danbao.boot.basic.controller.dto.AjaxResponse;
import top.danbao.boot.basic.entity.Book;
import top.danbao.boot.basic.entity.BookReader;

import java.io.Reader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 蛋宝
 * @date 2021/3/4 15:01
 * @description BookController
 **/
@RestController
@RequestMapping(value = "/api/v1/books")
@Slf4j
public class BookController {

    @GetMapping("all")
    public AjaxResponse selectBooks(){
        BookReader[] readers={
                BookReader.builder()
                        .name("ddd")
                        .age(4)
                        .build(),
                BookReader.builder()
                        .name("ggg")
                        .age(20)
                        .build(),
        };
        List<BookReader> readerList= Arrays.asList(readers);
        Book book1= Book.builder()
                .id(123)
                .author("ldd")
                .title("SringBoot")
                .content("SpringBoot从入门到入狱")
                .createTime(new Date())
                .readers(readerList)
                .build();

        Book book2= Book.builder()
                .id(123)
                .author("ldd")
                .title("Vue.js")
                .content("Vue.js从入门到入狱")
                .createTime(new Date())
                .readers(readerList)
                .build();
        Book[] books={book1,book2};
        List<Book> booklist=Arrays.asList(books);

        return AjaxResponse.success(booklist);
    }
    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id){
        Book book= Book.builder()
                .id(id)
                .author("ldd")
                .title("java")
                .content("java")
                .createTime(new Date())
                .build();
        return AjaxResponse.success(book);
    }
}