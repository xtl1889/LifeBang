package com.pro.xtl1889.lifebang.model;

import java.util.List;

/**
 * Created by lianbinbo on 2016/12/22.
 */
public class FunsModel {
    //.系统级参数（所有接入点都会返回的参数）
    private int showapi_res_code;//0 成功   其他失败
    private String showapi_res_error;


    private FunsJsonModle showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public FunsJsonModle getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(FunsJsonModle showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }
}
