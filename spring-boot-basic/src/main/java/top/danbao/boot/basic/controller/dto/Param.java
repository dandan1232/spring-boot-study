package top.danbao.boot.basic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 蛋宝
 * @date: 2021/3/4 16:42
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Param {
    private Integer id;
    private  String title;
}