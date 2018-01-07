package sunyandong.bawei.com.sunyandong20180106.Utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 悻 on 2018/1/6.
 */

public class Applicon extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
