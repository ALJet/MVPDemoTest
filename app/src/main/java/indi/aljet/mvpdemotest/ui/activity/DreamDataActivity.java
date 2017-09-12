package indi.aljet.mvpdemotest.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import indi.aljet.mvpdemotest.R;
import indi.aljet.mvpdemotest.bean.DreamData;
import indi.aljet.mvpdemotest.presenter.DreamPresenter;
import indi.aljet.mvpdemotest.presenter.DreamPresenterImpl;
import indi.aljet.mvpdemotest.view.DreamView;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class DreamDataActivity extends AppCompatActivity implements DreamView {

    private DreamPresenter dreamPresenter;
    private List<DreamData.ResultBean> mData = new
            ArrayList<>();
    private ListView mLvDream;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_weather);


        dreamPresenter = new DreamPresenterImpl(this);
        dreamPresenter.getDreamData("");

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadDreamBean(List<DreamData.ResultBean> s) {

    }
}
