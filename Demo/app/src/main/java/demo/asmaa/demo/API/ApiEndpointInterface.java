package demo.asmaa.demo.API;

/**
 * Created by asmaa on 02/27/2018.
 */


import demo.asmaa.demo.Data.Model.Data;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * interface to all retrofit requests , type of method request and parameters or request body
 * and handle this with model classes to parse json response to pojo classes
 */
public interface ApiEndpointInterface {

    @GET(APIUrls.TEST)
    Call<Data> getCountries();

}
