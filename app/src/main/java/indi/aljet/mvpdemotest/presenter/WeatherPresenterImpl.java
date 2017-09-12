package indi.aljet.mvpdemotest.presenter;

import android.util.Log;

import indi.aljet.mvpdemotest.bean.WeatherData;
import indi.aljet.mvpdemotest.model.WeatherModel;
import indi.aljet.mvpdemotest.model.WeatherModelImp;
import indi.aljet.mvpdemotest.view.WeatherView;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class WeatherPresenterImpl extends WeatherPresenter
implements WeatherModelImp.WeatherOnListener{

    private WeatherModel mWeatherModel;
    private WeatherView mWeatherView;

    public WeatherPresenterImpl(WeatherView mWeatherView) {
        mWeatherModel = new WeatherModelImp(this);
        this.mWeatherView = mWeatherView;
    }

    @Override
    public void onSuccess(WeatherData s) {
        mWeatherView.loadWeather(s);
        mWeatherView.hideProgress();

    }

    @Override
    public void onFailure(Throwable e) {
        mWeatherView.hideProgress();
        Log.d("--------","onFailure" + e.getMessage());
    }

    @Override
    public void getWeather(String format, String city) {
        mWeatherView.showProgress();

    }
}
