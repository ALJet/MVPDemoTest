package indi.aljet.mvpdemotest.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class BasePresenter {

    protected CompositeSubscription
    mCompositeSubscription;

    public void onUnsubscribe(){
        if(mCompositeSubscription != null &&
                mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Subscription subscription){
        if(mCompositeSubscription == null){
            mCompositeSubscription = new
                    CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }
}
