package sunyandong.bawei.com.sunyandong78987.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import sunyandong.bawei.com.sunyandong78987.Bean.Bean;
import sunyandong.bawei.com.sunyandong78987.GlideImageLoader;
import sunyandong.bawei.com.sunyandong78987.R;

/**
 * Created by 悻 on 2018/1/4.
 */

public class Myadpater extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int TYPE_PULL_IMAGE = 0;

    public static final int TYPE_RIGHT_IMAGE = 1;
    private Bean  object;
        private Context context;

    public Myadpater(Bean object, Context context) {
        this.object = object;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE_PULL_IMAGE){
            View view= LayoutInflater.from(context).inflate(R.layout.itemb,parent,false);
            sViewHodler sViewHodler=new sViewHodler(view);
            return  sViewHodler;
        }else {
            View inflat=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            sViewHodler1 sViewHodler1=new sViewHodler1(inflat);
            return sViewHodler1;
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof sViewHodler){
            List<String> list=new ArrayList<>();
            List<Bean.DataBean> list1=object.getData();
            for (int i=0;i<list1.size();i++){
                //Log.d(TAG, "onBindViewHolder: "+list1.);
                list.add(list1.get(i).getIcon());
            }
            String str=list1.get(position).getIcon();

            String[] strs=str.split("\\|");
            for (int i=0;i<strs.length;i++){
                list.add(strs[i]);
            }
            ((sViewHodler) holder).banner.setImages(list).isAutoPlay(true).setImageLoader(new GlideImageLoader()).start();
        }
        if (holder instanceof sViewHodler1){
            ((sViewHodler1) holder).img.setImageURI(object.getTuijian().getList().get(position).getImages());
            ((sViewHodler1) holder).tv1.setText(object.getTuijian().getList().get(position).getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_PULL_IMAGE;
        }else {
            return TYPE_RIGHT_IMAGE;
        }
    }
    @Override

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {

        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager=recyclerView.getLayoutManager();

        if(manager instanceof GridLayoutManager){

            final GridLayoutManager gridLayoutManager= (GridLayoutManager) manager;

            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

                @Override

                public int getSpanSize(int position) {

                    int type=getItemViewType(position);

                    switch (type){

                        case TYPE_PULL_IMAGE:

                            return 2;

                        case TYPE_RIGHT_IMAGE:

                            return 1;



                    }

                    return 0;

                }

            });

        }

    }

    @Override
    public int getItemCount() {
        return 12;
    }
    private class sViewHodler extends RecyclerView.ViewHolder{

      private   Banner banner;
        public sViewHodler(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.bannnnn);
        }
    }
    private class sViewHodler1 extends RecyclerView.ViewHolder{

        private  SimpleDraweeView img;
        private TextView tv1;


        public sViewHodler1(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
