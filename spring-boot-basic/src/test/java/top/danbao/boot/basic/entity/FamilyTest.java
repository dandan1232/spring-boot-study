package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author:
 * @date: 2021/3/9 11:39
 * @description:
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class FamilyTest {
    @Resource
    private Family family;

    @Test
//    配置文件属性绑定的Family对象
    void testFamily() {
        log.info("family: " + family);
        log.info("family: " + family.getFather());
        log.info("family: " + family.getMother());
        log.info("family: " + family.getChild());

        Father father = Father.builder().name("tom").age(30).build();
        String[] alias = new String[]{"lovely","alice"};
        Mother mother = Mother.builder().name("rose").alias(Arrays.asList(alias)).build();
        Friend[] friends = {Friend.builder().hobby("football").gender("male").build(),Friend.builder().hobby("sing").gender("female").build()};
        List<Friend> friendList = Arrays.asList(friends);
//        List<Map<String, Object>> friendList = Arrays.asList(friends);
        Child child = Child.builder().name("jack").age(6).friends(friendList).build();
        Family expectedFamily = Family.builder().familyName("happy family").father(father).mother(mother).child(child).build();


        //测试family对象，断言，判断object对象是否相等
        assertEquals(expectedFamily,family);

    }

//    @Test
//    void getFamilyName(){
//        String familyName= family.getFamilyName();
//        log.info(familyName);
//        assertEquals("happy family",familyName);
//    }

}