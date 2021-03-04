package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 蛋宝
 * @date 2021/3/4 14:55
 * @description BookReader
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookReader {
    private String name;
    private Integer age;

}