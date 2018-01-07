package sunyandong.bawei.com.sunyandong20180106;

import retrofit2.http.GET;
import rx.Observable;
import sunyandong.bawei.com.sunyandong20180106.Bean.ShopBean;

/**
 * Created by 悻 on 2018/1/6.
 */

public interface Inters {
    @GET("product/getCarts?uid=100")
    Observable<ShopBean> Zuo();
}
