package com.pro.xtl1889.lifebang.model;

import java.util.List;

/**
 * Created by xtl1889 on 16-8-3.
 */
public class Cs {


    /**
     * defaultt : 1000
     * openAd : [{"Interval1":"","contid":"","extend1":"","lback":"","url":"","img":"","title":""}]
     */

    private int defaultt;
    /**
     * Interval1 :
     * contid :
     * extend1 :
     * lback :
     * url :
     * img :
     * title :
     */

    private List<OpenAdBean> openAd;

    public int getDefaultt() {
        return defaultt;
    }

    public void setDefaultt(int defaultt) {
        this.defaultt = defaultt;
    }

    public List<OpenAdBean> getOpenAd() {
        return openAd;
    }

    public void setOpenAd(List<OpenAdBean> openAd) {
        this.openAd = openAd;
    }

    public static class OpenAdBean {
        private String Interval1;
        private String contid;
        private String extend1;
        private String lback;
        private String url;
        private String img;
        private String title;

        public String getInterval1() {
            return Interval1;
        }

        public void setInterval1(String Interval1) {
            this.Interval1 = Interval1;
        }

        public String getContid() {
            return contid;
        }

        public void setContid(String contid) {
            this.contid = contid;
        }

        public String getExtend1() {
            return extend1;
        }

        public void setExtend1(String extend1) {
            this.extend1 = extend1;
        }

        public String getLback() {
            return lback;
        }

        public void setLback(String lback) {
            this.lback = lback;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
