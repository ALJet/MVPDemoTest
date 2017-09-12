package indi.aljet.mvpdemotest.model;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import rx.Subscription;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public interface WeatherModel {


    /**
     * 获取天气信息
     * @param format
     * @param city
     * @return
     */
    DisposableObserver getWeatherData(String format,
                                      String city);
}
