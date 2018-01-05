package sunyandong.bawei.com.sunyandong78987.Persenter;

import sunyandong.bawei.com.sunyandong78987.Bean.Bean;
import sunyandong.bawei.com.sunyandong78987.Model.FenModle;
import sunyandong.bawei.com.sunyandong78987.View.FenView;

/**
 * Created by 悻 on 2018/1/4.
 */

public class FenPersenter implements FenModle.ScuMod{
    FenModle  fenModle;
    FenView   fenView;

    public FenPersenter(FenView fenView) {
        this.fenView = fenView;
        fenModle =new FenModle();
        fenModle.setScuMod(this);
    }

    @Override
    public void ZOU(Bean bean) {
  fenView.onZuo(bean);
    }

    public void ShawPar(){
        fenModle.ZuoChen();
    }
}
