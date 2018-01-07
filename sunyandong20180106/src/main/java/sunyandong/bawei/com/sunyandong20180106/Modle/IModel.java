package sunyandong.bawei.com.sunyandong20180106.Modle;

import sunyandong.bawei.com.sunyandong20180106.Bean.ShopBean;
import sunyandong.bawei.com.sunyandong20180106.Utils.OkhttpUtils;
import sunyandong.bawei.com.sunyandong20180106.View.AbstractUiCallBack;

/**
 * Created by 悻 on 2018/1/6.
 */

public class IModel {


    public void getData(final MyModelCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=98", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean shopBean) {
                callBack.success(shopBean);

            }

            @Override
            public void failure(Exception e) {
                callBack.failure(e);
            }
        });



    }


}