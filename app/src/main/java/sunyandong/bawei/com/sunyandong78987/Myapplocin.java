package sunyandong.bawei.com.sunyandong78987;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 悻 on 2018/1/4.
 */

public class Myapplocin extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
