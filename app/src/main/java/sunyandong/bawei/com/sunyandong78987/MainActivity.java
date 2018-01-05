package sunyandong.bawei.com.sunyandong78987;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import sunyandong.bawei.com.sunyandong78987.Adapter.Myadpater;
import sunyandong.bawei.com.sunyandong78987.Bean.Bean;
import sunyandong.bawei.com.sunyandong78987.Persenter.FenPersenter;
import sunyandong.bawei.com.sunyandong78987.View.FenView;

public class MainActivity extends AppCompatActivity implements FenView{

    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FenPersenter fenPersenter=new FenPersenter(this);
        fenPersenter.ShawPar();

        init();
    }

    private void init() {
        rec = (RecyclerView) findViewById(R.id.rec);
    }

    @Override
    public void onZuo(Bean bean) {
        rec.setLayoutManager(new GridLayoutManager(this,2));
        rec.setAdapter(new Myadpater(bean,MainActivity.this));

    }
}
