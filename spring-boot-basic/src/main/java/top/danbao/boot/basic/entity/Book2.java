package top.danbao.boot.basic.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: 蛋宝
 * @date: 2021/3/18 16:45
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_book")
@ApiModel("书本基本信息")
public class Book2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("书名")
    private String name;
    @ApiModelProperty("封面")
    private String cover;
}