package indi.aljet.mvpdemotest.api;

import indi.aljet.mvpdemotest.bean.DreamData;
import indi.aljet.mvpdemotest.bean.WeatherData;
import indi.aljet.mvpdemotest.bean.WinXinData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public interface ApiManagerService {

    @GET("/weather/index")
    Observable<WeatherData> getWeatherData(@Query("format") String
                                           format, @Query("cityname")
                                           String cityname, @Query("key")
                                           String key);


    @GET("/dream/category")
    Observable<DreamData> getDreamData(@Query("key")
                                       String key);


    @POST("/weixin/query")
    Observable<WinXinData> getWinXinNewData(@Query("pno") int pno,
                                            @Query("ps") String ps,
                                            @Query("key") String key)
        throws  Exception;
}
