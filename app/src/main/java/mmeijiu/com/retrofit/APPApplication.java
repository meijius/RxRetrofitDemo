package mmeijiu.com.retrofit;

import android.app.Application;

import mmeijiu.com.retrofit.utils.ToastUtils;


public class APPApplication extends Application {

    public void onCreate() {
        super.onCreate();
        init();
    }
    
    private void init() {

        ToastUtils.init(this);

    }
    
}
