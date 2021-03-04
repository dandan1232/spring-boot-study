package top.danbao.boot.basic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 蛋宝
 * @date 2021/3/4 15:03
 * @description AjaxResponse统一响应结果封装
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResponse {
    private Integer code;
    private String meaasge;
    private Object data;

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMeaasge("请求成功");
        return ajaxResponse;

    }

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMeaasge("请求成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}