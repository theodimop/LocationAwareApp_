package theodim.locationawareapp;

import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import theodim.locationawareapp.WeatherBaseClasses.Cloud;
import theodim.locationawareapp.WeatherBaseClasses.CurrentCondition;
import theodim.locationawareapp.WeatherBaseClasses.Rain;
import theodim.locationawareapp.WeatherBaseClasses.Temperature;
import theodim.locationawareapp.WeatherBaseClasses.WeatherDate;
import theodim.locationawareapp.WeatherBaseClasses.Wind;
import theodim.locationawareapp.openweathermap.Forecast5;
import theodim.locationawareapp.WeatherBaseClasses.Location;
import theodim.locationawareapp.openweathermap.ThreeHourPeriodWeather;
import theodim.locationawareapp.openweathermap.UV_Index;
import theodim.locationawareapp.openweathermap.Weather;

//Import JSON Tools
import static theodim.locationawareapp.JSONTools.*;

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
        List<ThreeHourPeriodWeather> threeHourPeriodWeatherList = new ArrayList<>();
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
        for(int i=0;i<numOfjsonObjects;i++)
        {
            JSONObject JSONWeather = jsonArray.getJSONObject(i);

            threeHourPeriodWeather= new ThreeHourPeriodWeather(getWeatherAttibutes(JSONWeather),getString("dt_txt",JSONWeather));
            threeHourPeriodWeatherList.add(threeHourPeriodWeather);

        }
        Log.d("Theo", String.valueOf(threeHourPeriodWeatherList.size()));
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

        //Create a an empty Weather instance
        Weather weather=new Weather();

        //start filling it step by step

        //Set WeatherDate to weather instance
        Long temp = getLong("dt", jObj);
        WeatherDate weatherDate = new WeatherDate(temp*1000L);
        weather.setWeatherDate(weatherDate);

        //Set the Current Condition
            // We get weather info (This is an array)
        JSONArray jArr = jObj.getJSONArray("weather");

            // We use only the first value
        JSONObject JSONWeather = jArr.getJSONObject(0);

        CurrentCondition currentCondition = new CurrentCondition();

        currentCondition.setWeatherId(getInt("id", JSONWeather));
        currentCondition.setDescription(getString("description", JSONWeather));
        currentCondition.setCondition(getString("main", JSONWeather));
        currentCondition.setIcon(getString("icon", JSONWeather));

        JSONObject mainObj = getObject("main", jObj);
        currentCondition.setHumidity(getInt("humidity", mainObj));
        currentCondition.setPressure(getInt("pressure", mainObj));
        //Here CurrentCondition is set
        weather.setCurrentCondition(currentCondition);

        //Set the Temperature
        Temperature temperature=new Temperature();
        temperature.setMaxTemp(getFloat("temp_max", mainObj));
        temperature.setMinTemp(getFloat("temp_min", mainObj));
        temperature.setTemp(getFloat("temp", mainObj));
        weather.setTemperature(temperature);

        //Set the Wind
        JSONObject wObj = getObject("wind", jObj);
        Wind wind = new Wind();
        wind.setSpeed(getFloat("speed", wObj));
        wind.setDeg(getFloat("deg", wObj));
        weather.setWind(wind);

        //Set the Cloud
        JSONObject cObj = getObject("clouds", jObj);
        Cloud cloud =new Cloud();
        cloud.setPerc(getInt("all", cObj));
        weather.setCloud(cloud);

        //Set The Rain
        //Check if there is empty rain bracket
        JSONObject rObj = getObject("rain", jObj);
        float f;
        if((f=getFloat("3h",rObj))!= NO_FLOAT_VALUE) {
            Rain rain =new Rain();
            rain.setAmount(f);
            weather.setRain(rain);
        }


        //TODO:  Snow IF EXIST!

        // We download the icon to show

        return weather;

    }
    /*Theo_ Parse Weather response methods END*/

}
