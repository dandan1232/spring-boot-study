package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/9 11:36
 * @description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "family.mother")
public class Mother {
    private String name;
    private List<String> alias;
}