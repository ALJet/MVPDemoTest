package indi.aljet.mvpdemotest.presenter;

import java.util.List;

import indi.aljet.mvpdemotest.bean.WinXinData;
import indi.aljet.mvpdemotest.model.WinXinDataModel;
import indi.aljet.mvpdemotest.model.WinXinDataModelImpl;
import indi.aljet.mvpdemotest.view.WeixinNewsView;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class WinXinDataPresenterImpl implements WinXinDataPresnter,
        WinXinDataModelImpl.WeiXinDataOnListener{

    private WinXinDataModel mWinXinDataModel;
    private WeixinNewsView mWeixinNewsView;

    public WinXinDataPresenterImpl(WeixinNewsView mWeixinNewsView) {
        this.mWeixinNewsView = mWeixinNewsView;
        mWinXinDataModel = new WinXinDataModelImpl(this);
    }

    @Override
    public void onSuccess(List<WinXinData.ResultBean.ListBean> s) {
        try{
            mWeixinNewsView.loadWeiXinData(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void getWeiXinData(int pno, String ps, String key) throws Exception {
        mWinXinDataModel.getWeiXinData(pno,ps,key);
    }
}
