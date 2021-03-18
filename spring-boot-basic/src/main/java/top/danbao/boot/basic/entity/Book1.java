package top.danbao.boot.basic.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 14:27
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@ApiModel("书本基本信息")
public class Book1 {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("书名")
    private String name;
    @ApiModelProperty("作者")
    private String author;
}