package indi.aljet.mvpdemotest.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import indi.aljet.mvpdemotest.R;
import indi.aljet.mvpdemotest.bean.WeatherData;
import indi.aljet.mvpdemotest.view.WeatherView;

/**
 * Created by PC-LJL on 2017/9/8.
 */

public class WeatherActivity extends AppCompatActivity implements
        WeatherView{




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
