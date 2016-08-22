package mmeijiu.com.retrofit.net;

import mmeijiu.com.retrofit.entity.PUser;

/**
 * Created by Administrator on 2016/8/20.
 */

public class Rersults {

    private String errno;
    private String errmsg;
    private PUser data;

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public PUser getData() {
        return data;
    }

    public void setData(PUser data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Rersults{" +
                "errno='" + errno + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
