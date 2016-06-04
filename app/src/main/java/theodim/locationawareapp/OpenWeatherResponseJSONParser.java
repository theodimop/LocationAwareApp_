package theodim.locationawareapp;

import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import theodim.locationawareapp.openweathermap.Forecast5;
import theodim.locationawareapp.WeatherBaseClasses.Location;
import theodim.locationawareapp.openweathermap.ThreeHourPeriodWeather;
import theodim.locationawareapp.openweathermap.UV_Index;
import theodim.locationawareapp.openweathermap.Weather;

/**
 * Created by dj_di_000 on 16/5/2016.
 */
public class OpenWeatherResponseJSONParser {

    /*Theo_ Parse UV Index response methods*/
    @Nullable
    public static UV_Index getUV_Index(String data)throws JSONException{
        Location location;

        // We create out JSONObject from the data
        JSONObject jObj = new JSONObject(data);

        location =getLocationUV_indexGIS(jObj);
        String sDate = getString("time",jObj);
        Float uv_indexValue=getFloat("data",jObj);

        //Check if null
        if(location !=null && sDate!=null )
            return new UV_Index(location,uv_indexValue,sDate);
        else {
            Message.logMessage("RETURNED NULL");
            return null;
        }
    }
    private static Location getLocationUV_indexGIS(JSONObject jObj) throws JSONException {

        JSONObject locationObj = getObject("location",jObj);

        Float latitude=getFloat("latitude",locationObj);
        Float longitude=getFloat("longitude",locationObj);

        return new Location(longitude,latitude);
    }
    /*Theo_ Parse UV Index response methods END*/

    /*Theo_ Parse Forecast5 response methods*/
    public static Forecast5 getForecast5(String data) throws JSONException{
        Forecast5 forecast5=new Forecast5();
        ArrayList<ThreeHourPeriodWeather> threeHourPeriodWeatherList = new ArrayList<>();
        ThreeHourPeriodWeather threeHourPeriodWeather;

        int numOfjsonObjects;

        // We create out JSONObject from the data
        JSONObject jObj = new JSONObject(data);


        //We set the location of our forecast
        forecast5.setLocation(getLocationForecastGIS(jObj));
        //We get the number of lines
        numOfjsonObjects=getInt("cnt",jObj);
        JSONArray jsonArray= jObj.getJSONArray("list");

        //For every 3-hour forecast store the attributes
        for(int i=0;i<numOfjsonObjects-1;i++)
        {


            JSONObject JSONWeather = jsonArray.getJSONObject(i);

            threeHourPeriodWeather= new ThreeHourPeriodWeather(getWeatherAttibutes(JSONWeather),getString("dt_txt",JSONWeather));
            threeHourPeriodWeatherList.add(threeHourPeriodWeather);
        }

        //Set the list to the forecast
        forecast5.setThreeHourPeriodWeathers(threeHourPeriodWeatherList);

        return forecast5;
    }
    private static Location getLocationForecastGIS(JSONObject jObj) throws JSONException {
        Location loc=new Location();

        JSONObject cityObj = getObject("city", jObj);
        loc.setCity(getString("name", cityObj));
        loc.setCountry(getString("country", cityObj));

        JSONObject coordObj = getObject("coord",cityObj);
        loc.setLatitude(getFloat("lat", coordObj));
        loc.setLongitude(getFloat("lon", coordObj));


        return loc;
    }
    /*Theo_ Parse Forecast5 response methods END*/

    /*Theo_ Parse weather response methods*/
    public static Weather getWeather(String data) throws JSONException {
        Weather weather = new Weather();

        // We create out JSONObject from the data
        JSONObject jObj = new JSONObject(data);
        //Theo_ We get the information about the location
        // We start extracting the info
        Location loc = new Location();

        JSONObject coordObj = getObject("coord", jObj);
        loc.setLatitude(getFloat("lat", coordObj));
        loc.setLongitude(getFloat("lon", coordObj));

        JSONObject sysObj = getObject("sys", jObj);
        loc.setCountry(getString("country", sysObj));
        loc.setSunrise(getInt("sunrise", sysObj));
        loc.setSunset(getInt("sunset", sysObj));
        loc.setCity(getString("name", jObj));

        weather.setLocation(loc);
        //Theo_ We get the information about the weather
        weather=getWeatherAttibutes(jObj);


        return weather;
    }
    private static Weather getWeatherAttibutes (JSONObject jObj) throws JSONException{
        Weather weather=new Weather();

        //Theo_ We get the current date & time
        int temp= getInt("dt",jObj);
        weather.getWeatherDate().setDate(temp*1000L);


        // We get weather info (This is an array)
        JSONArray jArr = jObj.getJSONArray("weather");

        // We use only the first value
        JSONObject JSONWeather = jArr.getJSONObject(0);
        weather.getCurrentCondition().setWeatherId(getInt("id", JSONWeather));
        weather.getCurrentCondition().setDescription(getString("description", JSONWeather));
        weather.getCurrentCondition().setCondition(getString("main", JSONWeather));
        weather.getCurrentCondition().setIcon(getString("icon", JSONWeather));

        JSONObject mainObj = getObject("main", jObj);
        weather.getCurrentCondition().setHumidity(getInt("humidity", mainObj));
        weather.getCurrentCondition().setPressure(getInt("pressure", mainObj));
        weather.getTemperature().setMaxTemp(getFloat("temp_max", mainObj));
        weather.getTemperature().setMinTemp(getFloat("temp_min", mainObj));
        weather.getTemperature().setTemp(getFloat("temp", mainObj));

        // Wind
        JSONObject wObj = getObject("wind", jObj);
        weather.getWind().setSpeed(getFloat("speed", wObj));
        weather.getWind().setDeg(getFloat("deg", wObj));

        // Clouds
        JSONObject cObj = getObject("clouds", jObj);
        weather.getClouds().setPerc(getInt("all", cObj));

        //TODO: Rain & Snow IF EXIST!

        // We download the icon to show

        return weather;

    }
    /*Theo_ Parse Weather response methods END*/

    /*Theo_ Auxiliary JSON methods*/
    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }
    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }
    private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }
    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }
    /*Theo_ Auxiliary JSON methods END*/
}
