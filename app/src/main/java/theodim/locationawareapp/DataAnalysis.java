package theodim.locationawareapp;

import android.util.Log;

import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import theodim.locationawareapp.WeatherBaseClasses.CurrentCondition;
import theodim.locationawareapp.openweathermap.Forecast5;
import theodim.locationawareapp.openweathermap.ThreeHourPeriodWeather;
import theodim.locationawareapp.openweathermap.Weather;
import theodim.locationawareapp.openweathermap.UV_Index;

/**
 * Created by dj_di_000 on 4/6/2016.
 * This class has static methods which return JSON object with
 * the data analysis
 */

public  class DataAnalysis {


    public static JSONObject analyzeForecast5(Forecast5 forecast5)
    {
        List<ThreeHourPeriodWeather> forecasts= forecast5.getThreeHourPeriodWeathers();
        int limit=forecasts.size();
        String condition = "";
        for (int i =0;i<limit;i++){
            ThreeHourPeriodWeather t = forecasts.get(i);
            Log.d("THEO",t.getCurrentCondition().getCondition()+" i: "+i);

            if(t.hasRain()) {
                Log.d("THEO", t.getRain().getAmount() + " i: " + i);
               // Message.logMessage("hasRain YES");
            }
        }




        
        //TODO
        /*JSON object structure
        * {"Forecast5":[
            {"day1":"Date..", "Wash":" Excellent choice, good choice,reasonable choice,bad choice, worst choice"},
            {"day2":"Date..", "Wash":"True"},
            {"day3":"Peter", "Wash":"True"},
            {"day4":"Peter", "Wash":"True"},
            {"day5":"Peter", "Wash":"True"},

        ]}
        */
        return null;
    }

    public static JSONObject analyzeUV_Index(UV_Index uv_index){
        //TODO

        return null;
    }
}
