package demo.asmaa.demo.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import demo.asmaa.demo.Data.Model.Worldpopulation;
import demo.asmaa.demo.Listener.HomeListener;
import demo.asmaa.demo.R;


/**
 * Created by asmaa on 02/26/2018.
 */

public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private HomeListener homeListener;
    private View itemView;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private ImageView img;
    private Worldpopulation homeModel;

    public HomeViewHolder(View itemView , HomeListener homeListener,Context context) {
        super(itemView);
        this.context=context;
        this.homeListener=homeListener;
        this.itemView= itemView;
        itemView.setOnClickListener(this);
        initializeViews();

    }

    private void initializeViews() {
        txt1 = itemView.findViewById(R.id.tv1);
        txt2 = itemView.findViewById(R.id.tv2);
        txt3 = itemView.findViewById(R.id.tv3);

        img = itemView.findViewById(R.id.img);
    }


    public void setData(Worldpopulation data){
        this.homeModel=data;
        txt1.setText(String.valueOf(homeModel.getRank()));
        txt2.setText(homeModel.getPopulation());
        txt3.setText(homeModel.getCountry());
        Glide.with(context).load(homeModel.getFlag()).into(img);
    }

    @Override
    public void onClick(View view) {
        homeListener.onItemClicked(homeModel);

    }
}
