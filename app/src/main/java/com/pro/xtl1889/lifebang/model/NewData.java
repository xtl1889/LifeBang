package com.pro.xtl1889.lifebang.model;

import java.util.List;

/**
 * Created by xtl1889 on 16-8-22.
 */
public class NewData {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-08-23 11:23","title":"安徽太和文字马赛克嫌犯受审 因抢女童被抓","description":"网易社会","picUrl":"","url":"http://news.163.com/16/0823/11/BV5B5NND00011229.html#f=slist"},{"ctime":"2016-08-23 11:26","title":"印度6旬女子被百条流浪狗活吃 儿子在旁束手无策","description":"网易社会","picUrl":"","url":"http://news.163.com/16/0823/11/BV5BB37500014JB5.html#f=slist"},{"ctime":"2016-08-23 11:33","title":"湖南男子为还赌债残杀情人 抢走3万手术费","description":"网易社会","picUrl":"","url":"http://news.163.com/16/0823/11/BV5BN3UK00014AEE.html#f=slist"},{"ctime":"2016-08-23 11:48","title":"赴美留学天天吃不饱  未成年留学生诉学校赢官司","description":"网易社会","picUrl":"","url":"http://news.163.com/16/0823/11/BV5CJSD800014SEH.html#f=slist"},{"ctime":"2016-08-23 11:48","title":"河北最牛女村主任获刑20年 曾公然殴打记者","description":"网易社会","picUrl":"","url":"http://news.163.com/16/0823/11/BV5CJTCO0001124J.html#f=slist"},{"ctime":"2016-08-23 11:57","title":"河南一男子病房掐死流产住院妻子：被指长期家暴，一审","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/3/30/30D125A357EAF404FA819B06CAB9B766.jpg.119x83.jpg","url":"http://news.163.com/16/0823/11/BV5D404V00014SEH.html#f=slist"},{"ctime":"2016-08-23 12:03","title":"上海一机场大巴在中环线高架撞上护栏，已致2人死亡","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/F/F8/F8725DAC5FDDE52B2768E70BB1F193C6.jpg.119x83.jpg","url":"http://news.163.com/16/0823/12/BV5DFC2A00014SEH.html#f=slist"},{"ctime":"2016-08-23 12:50","title":"男子拍城管执法引纠纷回家后身亡 城管称没打人","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/7/7F/7FD0F68FA619CD0B6F59ED6D75559850.jpg.119x83.jpg","url":"http://news.163.com/16/0823/12/BV5G4T0L00014SEH.html#f=slist"},{"ctime":"2016-08-23 12:53","title":"打工妹因出租房内没空调太热裸睡 没锁门遭强奸","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/5/5C/5C287C2291A77B2F39D2AD53402800F0.jpg.119x83.jpg","url":"http://news.163.com/16/0823/12/BV5GB63U00011229.html#f=slist"},{"ctime":"2016-08-23 13:03","title":"两家人因迁坟闹矛盾 一方将坟修到另一家门口","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/9/94/94313ADED8C641448E72687AF395BBE1.jpg.119x83.jpg","url":"http://news.163.com/16/0823/13/BV5GTDIJ00011229.html#f=slist"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-08-23 11:23
     * title : 安徽太和文字马赛克嫌犯受审 因抢女童被抓
     * description : 网易社会
     * picUrl :
     * url : http://news.163.com/16/0823/11/BV5B5NND00011229.html#f=slist
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

}
