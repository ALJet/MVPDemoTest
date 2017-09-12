package indi.aljet.mvpdemotest.api;

import android.os.Environment;

import indi.aljet.mvpdemotest.bean.DreamData;
import indi.aljet.mvpdemotest.bean.WeatherData;
import indi.aljet.mvpdemotest.bean.WinXinData;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class ApiManager {

    private static final String ENDPOINT = "http://v.juhe.cn";

    private static final Retrofit sRetrofit = new
            Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory
            .create())
            .build();

    private static  final ApiManagerService apiManager =
            sRetrofit.create(ApiManagerService
            .class);

    public static Observable<WeatherData> getWeatherData(
            String format,String city){
        Observable<WeatherData> ss = apiManager
                .getWeatherData(format,city,
                        "ad1d20bebafe0668502c8eea5ddd0333");
        return ss;
    }


    public static Observable<DreamData> getDreamData(String key){
        Observable<DreamData> ss = apiManager
                .getDreamData(key);
        return ss;
    }


    public static Observable<WinXinData> getWeiXinData(int pno
    ,String ps,String key)throws Exception{
        Observable<WinXinData> ss = apiManager
                .getWinXinNewData(pno,
                        ps,key);
        return ss;
    }

}
