package theodim.locationawareapp;

import org.json.JSONObject;

import theodim.locationawareapp.openweathermap.Forecast5;
import theodim.locationawareapp.openweathermap.UV_Index;

/**
 * Created by dj_di_000 on 4/6/2016.
 * This class has static methods which return JSON object with
 * the data analysis
 */

public  class DataAnalysis {


    public static JSONObject analyzeForecast5(Forecast5 forecast5)
    {
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
