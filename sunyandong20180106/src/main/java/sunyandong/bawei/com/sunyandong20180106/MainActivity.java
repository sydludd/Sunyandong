package sunyandong.bawei.com.sunyandong20180106;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sunyandong.bawei.com.sunyandong20180106.Adapter.ShopAdapter;
import sunyandong.bawei.com.sunyandong20180106.Bean.ShopBean;
import sunyandong.bawei.com.sunyandong20180106.Persenter.MyPresenter;
import sunyandong.bawei.com.sunyandong20180106.View.MyViewLister;

public class MainActivity extends AppCompatActivity implements MyViewLister {

    @Bind(R.id.third_recyclerView)
    RecyclerView thirdRecyclerView;
    @Bind(R.id.third_allselect)
    CheckBox thirdAllselect;
    @Bind(R.id.third_totalprice)
    TextView thirdTotalprice;
    @Bind(R.id.third_totalnum)
    TextView thirdTotalnum;
    @Bind(R.id.third_submit)
    TextView thirdSubmit;
    @Bind(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private MyPresenter presenter;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MyPresenter(this);
        presenter.getData();
        adapter = new ShopAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        thirdRecyclerView.setLayoutManager(manager);
        thirdRecyclerView.setAdapter(adapter);


        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                thirdAllselect.setChecked(allCheck);
                thirdTotalnum.setText("共"+num+"件商品");
                thirdTotalprice.setText("总价"+total);
            }
        });
    }

    public void success(ShopBean shopBean) {
        adapter.add(shopBean);
    }

    @Override
    public void failure(Exception e) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {
        adapter.selectAll(thirdAllselect.isChecked());
    }
}