package top.danbao.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author: 蛋宝
 * @date: 2021/3/7 20:10
 * @description:
 */

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookControllerTest {
//mock对象
    @Resource
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
//    private static MockMvc mockMvc;

//    @BeforeAll
//    static void Setup(){
//        Object[] controllers;
//        mockMvc=MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }


    @Test
    void saveBook() throws Exception{
        String article= "{\n" +
                "  \"id\":1,\n" +
                "  \"author\": \"ldd\",\n" +
                "  \"title\": \"SpringBoot从入门到精通\",\n" +
                "  \"content\": \"入门\",\n" +
                "  \"createTime\": \"2021-03-08 12:10:45\",\n" +
                "  \"readers\": [{\"name\": \"aaa\",\"age\": 12},{\"name\": \"bbb\",\"age\": 20}]\n" +
                "}";


        MvcResult result=mockMvc.perform(
                MockMvcRequestBuilders
                .request(HttpMethod.POST,"/api/v1/books")
                .contentType("application/json")
                .content(article)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("ldd"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(12))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }


}