package indi.aljet.mvpdemotest.model;


import javax.xml.transform.sax.TransformerHandler;

import indi.aljet.mvpdemotest.api.ApiManager;
import indi.aljet.mvpdemotest.app.Tapplication;
import indi.aljet.mvpdemotest.bean.WeatherData;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public class WeatherModelImp implements WeatherModel {
    private WeatherOnListener mWeatherOnListener;

    public WeatherModelImp(WeatherOnListener mWeatherOnListener) {
        this.mWeatherOnListener = mWeatherOnListener;
    }

    @Override
    public DisposableObserver getWeatherData(String format, String city) {
        Observable<WeatherData> request = ApiManager
                .getWeatherData(format,city).cache();

//        request.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<WeatherData>() {
//                    @Override
//                    public void accept(WeatherData weatherData) throws Exception {
//                        mWeatherOnListener.onSuccess(weatherData);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        mWeatherOnListener.onFailure(throwable);
//                    }
//                });

        DisposableObserver<WeatherData> disposableObserver =
                new DisposableObserver<WeatherData>() {
                    @Override
                    public void onNext(@NonNull WeatherData weatherData) {
                        mWeatherOnListener.onSuccess(weatherData);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mWeatherOnListener.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                };

        request.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver);

        return disposableObserver;
    }


    public interface WeatherOnListener{
        void onSuccess(WeatherData s);
        void onFailure(Throwable e);
    }
}
