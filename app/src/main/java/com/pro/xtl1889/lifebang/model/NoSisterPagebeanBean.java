package com.pro.xtl1889.lifebang.model;

import java.util.List;

/**
 * Created by lianbinbo on 2017/1/13.
 */
public class NoSisterPagebeanBean {

    private int allPages;
    private int currentPage;
    private int allNum;
    private int maxResult;
    private List<NoSisterContentlistBean> contentlist;

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public List<NoSisterContentlistBean> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<NoSisterContentlistBean> contentlist) {
        this.contentlist = contentlist;
    }
}
