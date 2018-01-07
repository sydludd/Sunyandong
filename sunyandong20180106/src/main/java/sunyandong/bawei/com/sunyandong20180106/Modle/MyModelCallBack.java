package sunyandong.bawei.com.sunyandong20180106.Modle;

/**
 * Created by 悻 on 2018/1/6.
 */


import sunyandong.bawei.com.sunyandong20180106.Bean.ShopBean;

/**
 * Created by Lenovo on 2017/11/21.
 */
public interface MyModelCallBack {
    public void success(ShopBean shopBean);
    public void failure(Exception e);
}