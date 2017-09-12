package indi.aljet.mvpdemotest.model;

import java.util.List;

import indi.aljet.mvpdemotest.api.ApiManager;
import indi.aljet.mvpdemotest.bean.WinXinData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class WinXinDataModelImpl implements WinXinDataModel {
    private WeiXinDataOnListener mWeixinDataOnlistener;

    public WinXinDataModelImpl(WeiXinDataOnListener mWeixinDataOnlistener) {
        this.mWeixinDataOnlistener = mWeixinDataOnlistener;
    }


    @Override
    public void getWeiXinData(int pno, String ps, String key) throws Exception {
        ApiManager.getWeiXinData(pno,ps,key)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WinXinData>() {
                    @Override
                    public void accept(WinXinData winXinData) throws Exception {
                        if(winXinData != null && "success"
                                .equals(winXinData.getReason())){
                            mWeixinDataOnlistener.onSuccess(winXinData
                            .getResult().getList());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mWeixinDataOnlistener.onFailure(throwable);
                    }
                });
    }

    public interface WeiXinDataOnListener{
        void onSuccess(List<WinXinData
                .ResultBean.ListBean> s);

        void onFailure(Throwable e);
    }
}
