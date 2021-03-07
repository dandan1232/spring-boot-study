package top.danbao.boot.basic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import top.danbao.boot.basic.controller.dto.AjaxResponse;
import top.danbao.boot.basic.controller.dto.Param;
import top.danbao.boot.basic.entity.Article;
import top.danbao.boot.basic.entity.Book;
import top.danbao.boot.basic.entity.BookReader;

import java.io.Reader;
import java.util.*;

/**
 * @author 蛋宝
 * @date 2021/3/4 15:01
 * @description BookController
 **/

@RestController
@RequestMapping(value = "api/v1/books")
@Slf4j
@Api(tags = "图书管理接口")

public class BookController {

//    创建线程安全的Map，模拟books信息的存储
    static Map<Integer, Book> books= Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "查询所有图书",notes = "查询所有图书")
    @GetMapping("all")
    public AjaxResponse selectBooks() {
//        BookReader[] readers = {
//                BookReader.builder()
//                        .name("ddd")
//                        .age(4)
//                        .build(),
//                BookReader.builder()
//                        .name("ggg")
//                        .age(20)
//                        .build(),
//        };
//        List<BookReader> readerList = Arrays.asList(readers);
//        Book book1 = Book.builder()
//                .id(123)
//                .author("ldd")
//                .title("SringBoot")
//                .content("SpringBoot从入门到入狱")
//                .createTime(new Date())
//                .readers(readerList)
//                .build();
//
//        Book book2 = Book.builder()
//                .id(123)
//                .author("ldd")
//                .title("Vue.js")
//                .content("Vue.js从入门到入狱")
//                .createTime(new Date())
//                .readers(readerList)
//                .build();
//        Book[] books = {book1, book2};
//        List<Book> booklist = Arrays.asList(books);
        List<Book> booklist=new ArrayList<>(books.values());

        return AjaxResponse.success(booklist);
    }

    @ApiOperation(value = "路径传参，根据id获取书", notes = "路径传参，根据id获取书本")
    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id) {
//        Book book = Book.builder()
//                .id(id)
//                .author("ldd")
//                .title("java")
//                .content("java")
//                .createTime(new Date())
//                .build();
//        return AjaxResponse.success(book);
        return AjaxResponse.success(books.get(id));
    }

    //    查询文章，id为url查询参数
//    @param 图书id
//    @return AjaxResponse
    @ApiOperation("URL传参，根据id获取图书")
    @GetMapping()
    public AjaxResponse getBookByParam(@ApiParam("图书id") @RequestParam("id") int id) {
        BookReader[] readers = {
                BookReader.builder().name("aaa").age(20).build(),
                BookReader.builder().name("bbb").age(19).build()};
        List<BookReader> readerList = Arrays.asList(readers);
        Book book = Book.builder()
                .id(id)
                .author("ldd")
                .title("java")
                .content("java学习基础")
                .createTime(new Date())
                .readers(readerList)
                .build();
        log.info("book:" + book);
        return AjaxResponse.success(book);
    }

    /**
     * 增加⼀篇Article ，@RequestParam接收参数
     *
     * @param id         id
     * @param author     作者
     * @param title      标题
     * @param content    内容
     * @param createTime 创建时间
     * @return AjaxResponse
     */
    @ApiOperation("URL传参新增⽂章")
    @PostMapping("param")
    public AjaxResponse saveArticle(
            @ApiParam("⽂章id")
            @RequestParam(value = "id", defaultValue =
                    "111", required = false) int id,
            @ApiParam("作者")
            @RequestParam(value = "author", defaultValue =
                    "ldd", required = false) String author,
            @ApiParam("标题")
            @RequestParam String title,
            @ApiParam("内容")
            @RequestParam String content,
            @ApiParam("创建时间")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam(value = "createTime",
                    defaultValue = "2021-03-06 12:12:12", required = false)
                    Date createTime) {
        Book book = Book.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createTime(createTime)
                .build();
        log.info("saveArticle:" + book);
        return AjaxResponse.success(book);
    }


    /**
     * 增加⼀本BOOK @RequestParam取得表单对象序列化的字符串
     *
     * @param formData 表单对象序列化的字符串
     * @return AjaxResponse
     */
    @ApiOperation("表单请求体新增文章")
    @PostMapping("form")
    public AjaxResponse saveBookByFormData(@ApiParam("表单字符串") @RequestParam("formData") String formData) {
//    表单传递的数据为字符串、
        log.info("formData:" + formData);
        //⽤Jackson的反序列化将字符串转为Java对象
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = null;
        try {
            book = objectMapper.readValue(formData,
                    Book.class);
            log.info("book:" + book);
        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        }
        return AjaxResponse.success(book);
    }


    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book) {
        log.info("saveBook:" + book);
        return AjaxResponse.success(book);
    }

    @PutMapping()    //修改
    public AjaxResponse updateBook(@ApiParam("修改文章") @RequestParam int id, @RequestParam String title) {
        Book book = Book.builder()
                .id(id)
                .author("ldd")
                .title("java")
                .content("java")
                .createTime(new Date())
                .build();
        book.setTitle(title);
        log.info("book:" + book);
        return AjaxResponse.success(book);
    }
//    //删除
//    @DeleteMapping("{id}")
//    public  AjaxResponse deleteBook(@PathVariable int id,String title){
//        log.info("id:"+id);
//        return AjaxResponse.success();
//    }

    //    删除,表单请求
    @DeleteMapping()
    @ApiOperation(value = "删除文章",notes = "根据路径参数id来指定删除文章")
//    public  AjaxResponse deleteBook(@RequestParam int id,@RequestParam String title){
    public AjaxResponse deleteBook(@RequestParam(value = "id", defaultValue = "888", required = false) int idd,
                                   @RequestParam("title") String tit) {
        log.info("id:" + idd);
        log.info("title:" + tit);
        return AjaxResponse.success();
    }


//    @DeleteMapping() //与以下同理
//    @RequestMapping(value = "del",method = RequestMethod.DELETE)
//    public AjaxResponse deletBook(@RequestBody Param param){
//        log.info("id:"+param.getId());
//        log.info("title:"+param.getTitle());
//        return AjaxResponse.success(param);
//    }


}