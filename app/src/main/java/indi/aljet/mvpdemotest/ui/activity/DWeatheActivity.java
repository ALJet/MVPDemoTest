package indi.aljet.mvpdemotest.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import indi.aljet.mvpdemotest.R;
import indi.aljet.mvpdemotest.bean.WeatherData;
import indi.aljet.mvpdemotest.presenter.WeatherPresenter;
import indi.aljet.mvpdemotest.presenter.WeatherPresenterImpl;
import indi.aljet.mvpdemotest.view.WeatherView;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class DWeatheActivity extends AppCompatActivity implements
        WeatherView{


    private WeatherPresenter mWeatherPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_weather);
        mWeatherPresenter = new WeatherPresenterImpl(this);
        mWeatherPresenter.getWeather("2","苏州");
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadWeather(WeatherData weatherData) {

    }
}
