package mmeijiu.com.retrofit;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mmeijiu.com.retrofit.net.Network;
import mmeijiu.com.retrofit.net.Rersults;
import mmeijiu.com.retrofit.net.RxObserver;
import mmeijiu.com.retrofit.utils.NetworkDialogUtils;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.email)
    AutoCompleteTextView email;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.content)
    TextView content;

    String account, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        NetworkDialogUtils.init(this);

    }

    @OnClick({R.id.email_sign_in_button})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.email_sign_in_button:
                login();
                break;
        }
    }

    Observer<Rersults> observer = new RxObserver<Rersults>() {
        @Override
        public void onSuccess(Rersults s) {
            Toast.makeText(LoginActivity.this, s.getErrmsg(), Toast.LENGTH_SHORT).show();
            content.setText(s.toString());
        }
    };

    protected Subscription subscription;

    private void login(){
        account = email.getText().toString();
        pwd = password.getText().toString();
        if(TextUtils.isEmpty(account)){
            Toast.makeText(LoginActivity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }

        subscription = Network.getZhuangbiApi()
                .login("a123456", "a123456")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

}

