package indi.aljet.mvpdemotest.app;

import android.app.Application;
import android.content.Context;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class Tapplication extends Application {
    private static final String TAG = "AndFix";
    private static AppComponent appComponent;
    private Tapplication sTApplication;
    private static CompositeSubscription compositeSubscription ;

    public static AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(compositeSubscription == null){
            compositeSubscription = new CompositeSubscription();
        }
    }


    public static CompositeSubscription getCompositeSubscription() {
        return compositeSubscription;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
