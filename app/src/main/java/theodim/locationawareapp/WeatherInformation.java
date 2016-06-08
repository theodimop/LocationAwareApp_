package theodim.locationawareapp;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import theodim.locationawareapp.openweathermap.Forecast5;
import theodim.locationawareapp.openweathermap.UV_Index;
import theodim.locationawareapp.openweathermap.Weather;

/**
 * Created by dj_di_000 on 15/5/2016.
 */
public class WeatherInformation {


    private JSONWeatherTask weatherTask;
    private TextView textView;

    String data;
    OpenWeatherMapHttpClient openWeatherMapHttpClient = new OpenWeatherMapHttpClient();

    public WeatherInformation(TextView textView){

       // weatherTask=new JSONWeatherTask();
       // weatherTask.execute(new String[]{"London,UK"});
        this.textView=textView;
       // data = openWeatherMapHttpClient.getWeatherDataByCityName("Thessaloniki,gr");

      //  data = openWeatherMapHttpClient.getUV_IndexData(41,23);
        data=openWeatherMapHttpClient.getForecast5DataByCityName("Thessaloniki");
        //Log.d("THEO",data);

        textView.setText(data);

        try {

          //  UV_Index uv_index= OpenWeatherResponseJSONParser.getUV_Index(data);
          //  textView.setText(String.valueOf(uv_index.getuV_Index())+" "+uv_index.getLocation().getLatitude());
            Forecast5 forecast5 = OpenWeatherResponseJSONParser.getForecast5(data);
            DataAnalysis.analyzeForecast5(forecast5);
       //    textView.setText(forecast5.getThreeHourPeriodWeatherByIndex(15).getWeather().currentCondition.getCondition());
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    private class JSONWeatherTask extends AsyncTask<String, Void, Forecast5> {
        OpenWeatherMapHttpClient weatherMapHttpClient = new OpenWeatherMapHttpClient();

        @Override
        protected Forecast5 doInBackground(String... params) {
            Weather weather = new Weather();
            Forecast5 forecast5=new Forecast5();

            data = weatherMapHttpClient.getWeatherDataByCityName("Thessaloniki,gr");
            //Message.logMessage("JSON RESPONSE: \n"+data);
            try {
                weather = OpenWeatherResponseJSONParser.getWeather(data);


                // Let's retrieve the icon
              //  weather.iconData = ( (new OpenWeatherMapHttpClient()).getImage(weather.currentCondition.getIcon()));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return forecast5;

        }




        @Override
        protected void onPostExecute(Forecast5 forecast5) {
            super.onPostExecute(forecast5);



            /*textView.setText(weather.location.getCity() + "," + weather.location.getCountry()+"\n"+
                    weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescription() + ")"+"\n"
                    +weather.weatherDate.getFullDateAndTime()+"\n");*/




            /*
           if (weather.iconData != null && weather.iconData.length > 0) {
                Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
                imgView.setImageBitmap(img);
            }

            cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
            condDescr.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescription() + ")");
            temp.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + "�C");
            hum.setText("" + weather.currentCondition.getHumidity() + "%");
            press.setText("" + weather.currentCondition.getPressure() + " hPa");
            windSpeed.setText("" + weather.wind.getSpeed() + " mps");
            windDeg.setText("" + weather.wind.getDeg() + "�");
            */

        }
    }

}


