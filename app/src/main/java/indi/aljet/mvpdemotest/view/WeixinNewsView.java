package indi.aljet.mvpdemotest.view;

import java.util.List;

import indi.aljet.mvpdemotest.bean.WinXinData;

/**
 * Created by PC-LJL on 2017/9/8.
 */

public interface WeixinNewsView {

    void loadWeiXinData(List<WinXinData
            .ResultBean.ListBean> s)
        throws Exception;
}
