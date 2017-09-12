package indi.aljet.mvpdemotest.presenter;

import java.util.List;

import indi.aljet.mvpdemotest.bean.DreamData;
import indi.aljet.mvpdemotest.model.DreamModel;
import indi.aljet.mvpdemotest.model.DreamModelImpl;
import indi.aljet.mvpdemotest.view.DreamView;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class DreamPresenterImpl implements DreamPresenter ,
        DreamModelImpl.DreamOnlistener{

    private DreamModel mDreamModel;
    private DreamView mDreamView;


    public DreamPresenterImpl( DreamView mDreamView) {
        this.mDreamModel = new DreamModelImpl(this);
        this.mDreamView = mDreamView;
    }

    @Override
    public void getDreamData(String key) {
        mDreamView.showProgress();
        mDreamModel.getDreamData(key);
    }

    @Override
    public void onFailuer(Throwable e) {
        mDreamView.hideProgress();
    }

    @Override
    public void onSuccess(List<DreamData.ResultBean> s) {
        mDreamView.loadDreamBean(s);
        mDreamView.hideProgress();
    }
}
