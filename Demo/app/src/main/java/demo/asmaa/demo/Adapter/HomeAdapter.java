package demo.asmaa.demo.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import demo.asmaa.demo.Data.Model.Worldpopulation;
import demo.asmaa.demo.Listener.HomeListener;
import demo.asmaa.demo.R;
import demo.asmaa.demo.ViewHolder.HomeViewHolder;


/**
 * Created by asmaa on 02/27/2018.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>{


    private ArrayList<Worldpopulation>  data;
    private HomeListener homeListener;

    public HomeAdapter( ArrayList<Worldpopulation>  data , HomeListener homeListener){
        this.data=data;
        this.homeListener = homeListener;
    }
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_home, parent, false);
        return new HomeViewHolder(view,homeListener,parent.getContext());
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        Log.i("log:=====","log");
         holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        Log.i("sizee: ",""+data.size());
        return data.size();

    }
}
