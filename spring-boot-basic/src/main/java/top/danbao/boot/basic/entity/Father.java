package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

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
public class Father {
    @NotEmpty
//    @Value("${family.father.name}")
    private String name;
    @Min(21)
    private Integer age;
}