package sunyandong.bawei.com.sunyandong20180106.View;

import sunyandong.bawei.com.sunyandong20180106.Bean.ShopBean;

/**
 * Created by 悻 on 2018/1/6.
 */

public interface MyViewLister {

    void success(ShopBean shopBean);

    public void failure(Exception e);


}