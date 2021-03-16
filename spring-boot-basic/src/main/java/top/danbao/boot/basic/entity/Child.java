package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: 蛋宝
 * @date: 2021/3/9 11:36
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
//@ConfigurationProperties(prefix = "family.child")
public class Child {
    private String name;
    private Integer age;
//    private List<Map<String, Object>> friends;
    private List<Friend> friends;
}