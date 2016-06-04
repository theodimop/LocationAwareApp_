package theodim.locationawareapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dj_di_000 on 15/5/2016.
 */
public class OpenWeatherMapHttpClient {
    private static String REQUEST_TYPE="forecast";
    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/"+REQUEST_TYPE+"?q=";
    private static String IMG_URL = "http://openweathermap.org/img/w/";
    private static final String API_KEY="&appid=2475bfaf42fefa968adc693e5cf60572";


    //The uv index request must be with integer coordinates to secure and accepted response
    @NonNull
    public String getUV_IndexData(int iLatitude,int iLongitude){
        String sURL="http://api.openweathermap.org/v3/uvi/"+iLatitude+","+iLongitude+"/current.json?appid=2475bfaf42fefa968adc693e5cf60572";
        Message.logMessage(sURL);

        String data=getData(sURL);
        return data;
    }
    @NonNull
    public String getForecast5DataByCityName(String location){
        REQUEST_TYPE="forecast";
        String sURL = BASE_URL+location+API_KEY;

        String data=getData(sURL);
        return data;
    }
    @NonNull
    public String getWeatherDataByCityName(String location) {
        REQUEST_TYPE="weather";
        String sURL = BASE_URL+location+API_KEY;

        String data=getData(sURL);
        return data;
    }
    //TODO
    public byte[] getImage(String code) {
        HttpURLConnection con = null ;
        InputStream is = null;
        try {
            con = (HttpURLConnection) ( new URL(IMG_URL + code)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ( is.read(buffer) != -1)
                baos.write(buffer);

            return baos.toByteArray();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }

        return null;

    }

    @NonNull
    private String getData(String sURL){
        HttpURLConnection connection = null ;
        InputStream inputStream = null;

        try {

            connection = (HttpURLConnection) ( new URL(sURL)).openConnection();

            connection.setRequestMethod("GET");
            connection.setDoInput(true);
           // connection.setDoOutput(true);
            //Enforce connection to use POST method and UV serve does not support that
            connection.connect();



            // Let's read the response
            StringBuffer buffer = new StringBuffer();

            inputStream = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while (  (line = br.readLine()) != null ) {
                buffer.append(line + "\n");
            }
            inputStream.close();
            connection.disconnect();

            return buffer.toString();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { inputStream.close(); } catch(Throwable t) {}
            try { connection.disconnect(); } catch(Throwable t) {}
        }

        return null;
    }
}
