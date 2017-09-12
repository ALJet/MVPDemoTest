package indi.aljet.mvpdemotest.view;

import java.util.List;

import indi.aljet.mvpdemotest.bean.DreamData;

/**
 * Created by PC-LJL on 2017/9/8.
 */

public interface DreamView {
    void showProgress();
    void hideProgress();
    void loadDreamBean(List<DreamData
                .ResultBean> s);
}
