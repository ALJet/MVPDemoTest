package indi.aljet.mvpdemotest.presenter;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public abstract class WeatherPresenter extends BasePresenter {

    public abstract void getWeather(String format,
                                        String city);
}
