package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author: 蛋宝
 * @date: 2021/3/11 13:39
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Friend {
    private String hobby;
    private String gender;
//    private String age;
}