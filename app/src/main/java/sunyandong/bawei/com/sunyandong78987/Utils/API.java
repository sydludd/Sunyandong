package sunyandong.bawei.com.sunyandong78987.Utils;

import retrofit2.http.GET;
import rx.Observable;
import sunyandong.bawei.com.sunyandong78987.Bean.Bean;

/**
 * Created by 悻 on 2018/1/4.
 */

public interface API {
    @GET(URL.URL_LAST)
    Observable<Bean> Zuo();
}
