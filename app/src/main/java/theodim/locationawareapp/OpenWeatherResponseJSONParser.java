package theodim.locationawareapp;

import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import theodim.locationawareapp.openweathermap.Forecast5;
import theodim.locationawareapp.openweathermap.LocationGIS;
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
        LocationGIS locationGIS=null;


        // We create out JSONObject from the data
        JSONObject jObj = new JSONObject(data);

        locationGIS=getLocationUV_indexGIS(jObj);
        String sDate = getString("time",jObj);
        Float uv_indexValue=getFloat("data",jObj);

        //Check if null
        if(locationGIS!=null && sDate!=null && uv_indexValue!=null)
            return new UV_Index(locationGIS,uv_indexValue,sDate);
        else {
            Message.logMessage("RETURNED NULL");
            return null;
        }
    }
    private static LocationGIS getLocationUV_indexGIS(JSONObject jObj) throws JSONException {

        JSONObject locationObj = getObject("location",jObj);

        Float latitude=getFloat("latitude",locationObj);
        Float longitude=getFloat("longitude",locationObj);

        return new LocationGIS(longitude,latitude);
    }
    /*Theo_ Parse UV Index response methods END*/

    /*Theo_ Parse Forecast5 response methods*/
    public static Forecast5 getForecast5(String data) throws JSONException{
        Forecast5 forecast5=new Forecast5();
        ArrayList<ThreeHourPeriodWeather> threeHourPeriodWeatherList = new ArrayList<>();
        ThreeHourPeriodWeather threeHourPeriodWeather=null;

        int numOfjsonObjects=0;

        // We create out JSONObject from the data
        JSONObject jObj = new JSONObject(data);


        //We set the location of our forecast
        forecast5.setLocationGIS(getLocationForecastGIS(jObj));
        //We get the number of lines
        numOfjsonObjects=getInt("cnt",jObj);
        JSONArray jsonArray= jObj.getJSONArray("list");

        //For every 3-hour forecast store the attributes
        for(int i=0;i<numOfjsonObjects-1;i++)
        {
            threeHourPeriodWeather= new ThreeHourPeriodWeather();

            JSONObject JSONWeather = jsonArray.getJSONObject(i);
            threeHourPeriodWeather.setPeriod(getString("dt_txt",JSONWeather));
            threeHourPeriodWeather.setWeather(getWeatherAttibutes(JSONWeather));

            threeHourPeriodWeatherList.add(threeHourPeriodWeather);
        }

        //Set the list to the forecast
        forecast5.setThreeHourPeriodWeathers(threeHourPeriodWeatherList);

        return forecast5;
    }
    private static LocationGIS getLocationForecastGIS(JSONObject jObj) throws JSONException {
        LocationGIS loc=new LocationGIS();

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
        LocationGIS loc = new LocationGIS();

        JSONObject coordObj = getObject("coord", jObj);
        loc.setLatitude(getFloat("lat", coordObj));
        loc.setLongitude(getFloat("lon", coordObj));

        JSONObject sysObj = getObject("sys", jObj);
        loc.setCountry(getString("country", sysObj));
        loc.setSunrise(getInt("sunrise", sysObj));
        loc.setSunset(getInt("sunset", sysObj));
        loc.setCity(getString("name", jObj));

        weather.location = loc;
        //Theo_ We get the information about the weather
        weather=getWeatherAttibutes(jObj);


        return weather;
    }
    private static Weather getWeatherAttibutes (JSONObject jObj) throws JSONException{
        Weather weather=new Weather();

        //Theo_ We get the current date & time
        int temp= getInt("dt",jObj);
        weather.weatherDate.setDate(Long.valueOf(temp)*1000L);


        // We get weather info (This is an array)
        JSONArray jArr = jObj.getJSONArray("weather");

        // We use only the first value
        JSONObject JSONWeather = jArr.getJSONObject(0);
        weather.currentCondition.setWeatherId(getInt("id", JSONWeather));
        weather.currentCondition.setDescr(getString("description", JSONWeather));
        weather.currentCondition.setCondition(getString("main", JSONWeather));
        weather.currentCondition.setIcon(getString("icon", JSONWeather));

        JSONObject mainObj = getObject("main", jObj);
        weather.currentCondition.setHumidity(getInt("humidity", mainObj));
        weather.currentCondition.setPressure(getInt("pressure", mainObj));
        weather.temperature.setMaxTemp(getFloat("temp_max", mainObj));
        weather.temperature.setMinTemp(getFloat("temp_min", mainObj));
        weather.temperature.setTemp(getFloat("temp", mainObj));

        // Wind
        JSONObject wObj = getObject("wind", jObj);
        weather.wind.setSpeed(getFloat("speed", wObj));
        weather.wind.setDeg(getFloat("deg", wObj));

        // Clouds
        JSONObject cObj = getObject("clouds", jObj);
        weather.clouds.setPerc(getInt("all", cObj));

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
