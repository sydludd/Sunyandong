package sunyandong.bawei.com.sunyandong78987.Model;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sunyandong.bawei.com.sunyandong78987.Bean.Bean;
import sunyandong.bawei.com.sunyandong78987.Utils.API;
import sunyandong.bawei.com.sunyandong78987.Utils.RetrofitUnitl;
import sunyandong.bawei.com.sunyandong78987.Utils.URL;

/**
 * Created by 悻 on 2018/1/4.
 */

public class FenModle {

    ScuMod scuMod;

    public void setScuMod(ScuMod scuMod) {
        this.scuMod = scuMod;
    }

    public void ZuoChen(){
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance(URL.URL_FIST,ok)
                .setCreate(API.class)
                .Zuo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        scuMod.ZOU(bean);
                    }
                });
    }

    public interface ScuMod{
        void ZOU(Bean bean);
    }
}
