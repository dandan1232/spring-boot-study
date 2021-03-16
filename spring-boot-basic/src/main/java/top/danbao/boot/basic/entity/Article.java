package top.danbao.boot.basic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author: 蛋宝
 * @date: 2021/3/6 15:33
 * @description:
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Article {
    private Integer id;
    private String author;
    private String title;
    private String  content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;


}