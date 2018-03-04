package demo.asmaa.demo.Utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by asmaa on 02/26/2018.
 */

/**
 * shared preferences class to cache app's data
 */

public class Preferences {

    private Context context;
    private SharedPreferences sharedPreferences;

    public Preferences() {
        initialization();
    }

    private void initialization(){
        sharedPreferences = context.getSharedPreferences("preferences", 0);
    }
}
