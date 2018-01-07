package sunyandong.bawei.com.sunyandong20180106.Persenter;

/**
 * Created by 悻 on 2018/1/6.
 */


import sunyandong.bawei.com.sunyandong20180106.Bean.ShopBean;
import sunyandong.bawei.com.sunyandong20180106.Modle.IModel;
import sunyandong.bawei.com.sunyandong20180106.Modle.MyModelCallBack;
import sunyandong.bawei.com.sunyandong20180106.View.MyViewLister;

/**
 * Created by Lenovo on 2017/11/21.
 */
public class MyPresenter{
    MyViewLister myViewLister;
    IModel iModel;
    public MyPresenter(MyViewLister myViewLister) {
        this.myViewLister=myViewLister;
        this.iModel=new IModel();



    }

    public void getData() {
        iModel.getData(new MyModelCallBack() {
            @Override
            public void success(ShopBean shopBean) {
                if (myViewLister!=null){
                    myViewLister.success(shopBean);
                }
            }

            @Override
            public void failure(Exception e) {
                if (myViewLister!=null){
                    myViewLister.failure(e);
                }

            }
        });


    }
    /**
     * 防止内存泄漏
     */
    public void detach(){
        myViewLister=null;
    }
}