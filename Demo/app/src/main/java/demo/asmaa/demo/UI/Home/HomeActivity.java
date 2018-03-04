package demo.asmaa.demo.UI.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import demo.asmaa.demo.Adapter.HomeAdapter;
import demo.asmaa.demo.Data.Model.Worldpopulation;
import demo.asmaa.demo.Injection.Injection;
import demo.asmaa.demo.Listener.HomeListener;
import demo.asmaa.demo.R;

public class HomeActivity extends AppCompatActivity implements HomePresenter.HomeView ,HomeListener {
    private RecyclerView recyclerView;

    private HomePresenter presenter;
    private HomeAdapter homeAdapter;
    private ArrayList<Worldpopulation> worldpopulations = new ArrayList<>();

//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView= findViewById(R.id.my_recycler_view);

        presenter = new HomePresenter(Injection.provideHomeRepository());
        presenter.setView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClicked(Worldpopulation worldpopulation) {


    }

    @Override
    public void setData(ArrayList<Worldpopulation>data) {
        Log.i("setData ====", "setD");
        worldpopulations.addAll(data);
        homeAdapter = new HomeAdapter(worldpopulations,this);
        homeAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(homeAdapter);



    }
}
