package top.danbao.boot.basic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: 蛋宝
 * @date: 2021/3/11 14:40
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("班级卡片")
public class Listsoft1921 {
    @ApiModelProperty("编号")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("github昵称")
    private String github_name;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("籍贯")
    private String hometown;
    @ApiModelProperty("生日")
    private String birthday;
    @ApiModelProperty("星座")
    private String constellation;
    @ApiModelProperty("电话")
    private String mobile;
    @ApiModelProperty("qq")
    private String qq;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("github地址")
    private String github;
    @ApiModelProperty("爱好")
    private String hobby;
    @ApiModelProperty("格言")
    private String signature;
    @ApiModelProperty("颜色")
    private String color;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;
    @ApiModelProperty("修改时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;
    @ApiModelProperty("是否删除")
    private Integer deleted;
}