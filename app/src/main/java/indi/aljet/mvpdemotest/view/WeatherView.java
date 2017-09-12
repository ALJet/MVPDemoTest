package indi.aljet.mvpdemotest.view;

import indi.aljet.mvpdemotest.bean.WeatherData;

/**
 * Created by PC-LJL on 2017/9/8.
 */

public interface WeatherView {
    void showProgress();
    void hideProgress();
    void loadWeather(WeatherData weatherData);
}
