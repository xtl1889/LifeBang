package com.pro.xtl1889.lifebang.model;

import java.util.List;

/**
 * Created by lianbinbo on 2016/12/22.
 */
public class FunsJsonModle {
    //应用级参数
    private String allNum;
    private String allPages;
    private String currentPage;
    private String maxResult;
    private List<FunsItemModel> contentlist;

    public String getAllNum() {
        return allNum;
    }

    public void setAllNum(String allNum) {
        this.allNum = allNum;
    }

    public String getAllPages() {
        return allPages;
    }

    public void setAllPages(String allPages) {
        this.allPages = allPages;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(String maxResult) {
        this.maxResult = maxResult;
    }

    public List<FunsItemModel> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<FunsItemModel> contentlist) {
        this.contentlist = contentlist;
    }

}
