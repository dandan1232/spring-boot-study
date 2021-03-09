package top.danbao.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: 蛋宝
 * @date: 2021/3/9 11:18
 * @description:
 */
@Slf4j
//@RunWith(SpringRunner.class) junit4的写法
    @ExtendWith(SpringExtension.class) //junt5的写法
    @SpringBootTest
    class FileSizeTest {
    @Resource
    private FileSize fileSize;

    @Test
    void getMaxSize() {
//        log.info("fileSize:"+fileSize.getMaxSize());
        String maxSize = fileSize.getMaxSize();
        log.info(maxSize);

        assertEquals("300MB",maxSize);

    }
}