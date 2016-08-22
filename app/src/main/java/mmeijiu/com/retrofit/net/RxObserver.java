package mmeijiu.com.retrofit.net;

import mmeijiu.com.retrofit.utils.Logger;
import mmeijiu.com.retrofit.utils.NetworkDialogUtils;
import mmeijiu.com.retrofit.utils.ToastUtils;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/8/20.
 */

public abstract class RxObserver<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
        NetworkDialogUtils.getInstance().HideNetworkDialog();
    }

    @Override
    public void onError(Throwable e) {
        NetworkDialogUtils.getInstance().HideNetworkDialog();
        Logger.e(this,e.getMessage());
        e.printStackTrace();
        //在这里做全局的错误处理
        if (e instanceof HttpException) {
             ToastUtils.getInstance().showToast(e.getMessage());
        }
        ToastUtils.getInstance().showToast(e.getMessage());

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T t);


}
