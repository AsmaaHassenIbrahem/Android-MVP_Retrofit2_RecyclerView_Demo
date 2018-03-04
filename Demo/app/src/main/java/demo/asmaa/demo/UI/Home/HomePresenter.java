package demo.asmaa.demo.UI.Home;

/**
 * Created by asmaa on 02/26/2018.
 */

import android.util.Log;

import java.util.ArrayList;

import demo.asmaa.demo.Data.Model.Worldpopulation;
import demo.asmaa.demo.Data.Repository.HomeRepository;
import demo.asmaa.demo.Listener.OnHomeResult;

/**
 * presenter class to get data from repository class and handle show this data in view
 */

public class HomePresenter {

    private ArrayList<Worldpopulation> data = new ArrayList<>();

    private HomeRepository homeRepository;
    HomeView view;

    public HomePresenter( HomeRepository homeRepository){
        this.homeRepository =homeRepository;
    }

    public void setView(HomeView view) {
        this.view =view;

        Log.i("here ","here");
        if (data.size()== 0) {
            getHomeData();
            Log.i("here ","here2");

        } else {
            view.setData(data);
            Log.i("here ","here3");

        }
    }

    public void getHomeData(){
        homeRepository.getHomeData(new OnHomeResult() {
            @Override
            public void onSuccess(ArrayList<Worldpopulation> worldpopulations) {

                Log.i("presenter:==== ",""+worldpopulations.size());
                data.addAll(worldpopulations);
                view.setData(data);
            }

            @Override
            public void onFailure() {


            }
        });

    }

    public interface HomeView{
        void setData(ArrayList<Worldpopulation> worldpopulations);


    }
}
