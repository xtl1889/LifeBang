package com.pro.xtl1889.lifebang.api;

import com.pro.xtl1889.lifebang.model.Cs;
import com.pro.xtl1889.lifebang.model.NewData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by xtl1889 on 16-8-3.
 */
public interface CmsAPI {


    @GET("newdefault.json")
    Call<Cs> csDatsa();


    //测试接口
    @Headers({
            "apikey:8dd5bf2ee0ac44710cd4305097e8fb6e"
    })
    @GET("tiyu/tiyu")
    Call<ResponseBody> Cheshi(
            @Query("num") String num,
            @Query("page") String page
    );



/*
*
* ------------以下是百度api接口----------------
*
* */


//科技新闻
    @Headers({
            "apikey:8dd5bf2ee0ac44710cd4305097e8fb6e"
    })
    @GET("keji/keji")
    Call<NewData> socialNews(
            @Query("num") String num,
            @Query("page") String page
    );

    //娱乐花边
    @Headers({
            "apikey:8dd5bf2ee0ac44710cd4305097e8fb6e"
    })
    @GET("huabian/newtop")
    Call<NewData> yuleNews(
            @Query("num") String num,
            @Query("page") String page
    );

    //体育新闻
    @Headers({
            "apikey:8dd5bf2ee0ac44710cd4305097e8fb6e"
    })
    @GET("tiyu/tiyu")
    Call<NewData> tiyuNews(
            @Query("num") String num,
            @Query("page") String page
    );

    //国际新闻
    @Headers({
            "apikey:8dd5bf2ee0ac44710cd4305097e8fb6e"
    })
    @GET("world/world")
    Call<NewData> worldNews(
            @Query("num") String num,
            @Query("page") String page
    );

    //奇闻异事
    @Headers({
            "apikey:8dd5bf2ee0ac44710cd4305097e8fb6e"
    })
    @GET("qiwen/qiwen")
    Call<NewData> qiwen(
            @Query("num") String num,
            @Query("page") String page
    );



    //健康生活
    @Headers({
            "apikey:8dd5bf2ee0ac44710cd4305097e8fb6e"
    })
    @GET("health/health")
    Call<NewData> health(
            @Query("num") String num,
            @Query("page") String page
    );



/*
*
* ------------以下是易源api接口----------------
*
* */
    //qq音乐

    @GET("213-4")
    Call<NewData> qqMusic(
            @Query("num") String num,
            @Query("page") String page
    );

    //百思不得姐

    @GET("255-1")
    Call<NewData> noSister(
            @Query("num") String num,
            @Query("page") String page
    );


    /*
    * 笑话大全
    *
    *time 从这个时间以来最新的笑话.格式：yyyy-MM-dd
    * page  第几页
    *maxResult  每页最大记录数。其值为1至50
    * */
    Call<NewData> allFunes(
            @Query("time") String time,
            @Query("page") String page,
            @Query("maxResult") String maxResult
    );
}
