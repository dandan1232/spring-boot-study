package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: 蛋宝
 * @date: 2021/3/9 11:34
 * @description:
 */
@Data
@Component
public class Family {
    @Value("${family.family-name}")
    private String familyName;
    @Resource
    private Father father;
    @Resource
    private Mother mother;
    @Resource
    private Child child;
}
