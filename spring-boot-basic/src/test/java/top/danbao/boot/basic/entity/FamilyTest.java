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

import java.util.List;

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
    void testFamily() {
        log.info("family:"+ family);
    }

//    @Test
//    void getFamilyName(){
//        String familyName= family.getFamilyName();
//        log.info(familyName);
//        assertEquals("happy family",familyName);
//    }

}