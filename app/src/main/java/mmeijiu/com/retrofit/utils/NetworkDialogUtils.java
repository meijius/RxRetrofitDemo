package mmeijiu.com.retrofit.utils;

import android.content.Context;

import com.bigkoo.svprogresshud.SVProgressHUD;

import mmeijiu.com.retrofit.R;


public class NetworkDialogUtils {

    private static Context mContext;
    private static NetworkDialogUtils mInstance;
    private static SVProgressHUD svProgressHUD;
    private static boolean isShowHUD = true;

    public static NetworkDialogUtils getInstance() {
        return mInstance;
    }

    public static void init(Context ctx) {
        mInstance = new NetworkDialogUtils(ctx);
    }

    private NetworkDialogUtils(Context ctx) {
        mContext = ctx;
    }

    public void ShowNetworkDialog(){
        if(isShowHUD){
            if(svProgressHUD == null){
                svProgressHUD = new SVProgressHUD(mContext);
            }
            svProgressHUD.showWithStatus(mContext.getString(R.string.wait));
        }
    }

    public void HideNetworkDialog(){
        if(isShowHUD){
            if(svProgressHUD.isShowing()){
                svProgressHUD.dismiss();
            }
        }
    }
}
