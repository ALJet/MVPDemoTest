package indi.aljet.mvpdemotest.model;

import java.util.List;

import indi.aljet.mvpdemotest.api.ApiManager;
import indi.aljet.mvpdemotest.bean.DreamData;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rx.functions.Action1;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class DreamModelImpl implements DreamModel{

    DreamOnlistener mDreamOnlistener;

    public DreamModelImpl(DreamOnlistener mDreamOnlistener) {
        this.mDreamOnlistener = mDreamOnlistener;
    }

    @Override
    public void getDreamData(String key) {
        ApiManager.getDreamData(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DreamData>() {
                    @Override
                    public void accept(DreamData dreamData) throws Exception {
                        if(dreamData != null && "successed".equals(dreamData
                        .getReason())){
                            mDreamOnlistener.onSuccess(dreamData
                            .getResult());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mDreamOnlistener.onFailuer(throwable);
                    }
                });
    }

    public interface DreamOnlistener{
        void onSuccess(List<DreamData.ResultBean> s);

        void onFailuer(Throwable e);
    }
}
