package top.danbao.boot.basic.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 蛋宝
 * @date 2021/3/4 15:03
 * @description AjaxResponse统一响应结果封装
 **/
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ApiModel("统⼀响应结果")
public class AjaxResponse {
    /**
     * 请求响应状态码（200、400、500）
     */
    @ApiModelProperty("请求响应状态码")
    private Integer code;
    /**
     * 请求结果描述信息
     */
    @ApiModelProperty("请求结果描述信息")
    private String meaasge;
    /**
     * 请求返回数据
     */
    @ApiModelProperty("请求返回数据")
    private Object data;

    private AjaxResponse() {

    }

    /**
     * 请求成功的响应，不带查询数据（⽤于删除、修改、新增接⼝）
     *
     * @return AjaxResponse
     */
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMeaasge("请求成功");
        return ajaxResponse;

    }

    /**
     * 请求成功的响应，带有查询数据（⽤于数据查询接⼝）
     *
     * @param obj obj
     * @return AjaxResponse
     */
    public static AjaxResponse success(Object obj) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMeaasge("请求成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带有查询数据（⽤于数据查询接⼝）
     *
     * @param obj     obj
     * @param message message
     * @return AjaxResponse
     */
    public static AjaxResponse success(Object obj, String
            message) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMeaasge(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    public static AjaxResponse failure(String meaasge) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(5001);
        ajaxResponse.setMeaasge(meaasge);
        return ajaxResponse;
    }
}