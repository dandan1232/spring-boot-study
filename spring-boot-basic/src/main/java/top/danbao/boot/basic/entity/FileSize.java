package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: 蛋宝
 * @date: 2021/3/9 11:12
 * @description: 文件大小的配置获取类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FileSize {

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxSize;
}