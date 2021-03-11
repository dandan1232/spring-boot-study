package top.danbao.boot.basic.conf;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: 蛋宝
 * @date: 2021/3/11 14:31
 * @description:多种类型属性源配置工厂
 */
public class MixPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (sourceName != null && (sourceName.endsWith(".yml") || sourceName.endsWith(".yaml"))) {
            Properties propertiesFormYaml = loadYml(resource);
//            将yml配置转成properties之后，在用PropertiespPropertySource绑定
            return new PropertiesPropertySource(sourceName, propertiesFormYaml);
        } else {
            return super.createPropertySource(name, resource);
        }
    }

    //        将yml格式的配置转换成properties配置
    private Properties loadYml(EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}