package indi.aljet.mvpdemotest.app;

import android.app.Application;

import indi.aljet.mvpdemotest.api.ApiManager;
import indi.aljet.mvpdemotest.api.ApiManagerService;

/**
 * Created by PC-LJL on 2017/9/11.
 */

public interface AppComponent {

    Application getApplication();


    ApiManagerService getService();

}
