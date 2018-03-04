package demo.asmaa.demo.Data.Repository;

import android.support.v7.util.SortedList;
import android.util.Log;

import java.util.ArrayList;

import demo.asmaa.demo.API.ApiEndpointInterface;
import demo.asmaa.demo.Data.Model.Data;
import demo.asmaa.demo.Data.Model.Worldpopulation;
import demo.asmaa.demo.Listener.OnHomeResult;
import demo.asmaa.demo.Singleton.ApiUtilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by asmaa on 02/27/2018.
 */

/**
 * repository class to request api and get data
 */
public class NetworkHomeRepository implements HomeRepository {

    private ApiEndpointInterface mApi = ApiUtilities.getInstance().getApi();
    private ArrayList<Worldpopulation>data;

    @Override
    public void getHomeData(final OnHomeResult onHomeResult) {
        Call<Data> call;


        call = mApi.getCountries();

        call.clone().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                data = new ArrayList<>();
                if (response.body()!=null){
                    for (int i =0; i<response.body().getWorldpopulation().size();i++){
                        data.add(response.body().getWorldpopulation().get(i));

                    }
                    onHomeResult.onSuccess(data);
                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

                Log.e("error: ",t.getMessage());
                onHomeResult.onFailure();
            }
        });



    }
}
