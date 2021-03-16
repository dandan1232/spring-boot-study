package top.danbao.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import top.danbao.boot.basic.conf.MixPropertySourceFactory;

import javax.annotation.Resource;

/**
 * @author: 蛋宝
 * @date: 2021/3/9 11:34
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Validated
@PropertySource(value = {"classpath:family.properties"})
//@PropertySource(value = {"classpath:family.yml"},factory = MixPropertySourceFactory.class)
@ConfigurationProperties(prefix = "family")
public class Family {
//    @Value("${family.family-name}")
    @Length(min =5,max = 20,message = "家庭名称长度必须位于5-20之间")
    private String familyName;
//    @Resource
    private Father father;
//    @Resource
    private Mother mother;
//    @Resource
    private Child child;
}
