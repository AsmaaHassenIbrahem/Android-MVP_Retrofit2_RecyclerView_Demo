package demo.asmaa.demo.Listener;

import java.util.ArrayList;

import demo.asmaa.demo.Data.Model.Worldpopulation;


/**
 * Created by asmaa on 02/27/2018.
 */

public interface OnHomeResult {
    void onSuccess(ArrayList<Worldpopulation> worldpopulations);
    void onFailure();
}
