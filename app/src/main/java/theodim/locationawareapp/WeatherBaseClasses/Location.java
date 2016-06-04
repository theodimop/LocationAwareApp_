package theodim.locationawareapp.WeatherBaseClasses;

import java.io.Serializable;

/**
 * Created by dj_di_000 on 15/5/2016.
 */
public class Location{

    private float longitude;
    private float latitude;
    private long sunset;
    private long sunrise;
    private String country;
    private String city;



    /*Theo_ Constructors
    * 3 Constructor availiable*/


    public Location(){
        /*Theo_ Empty Constructor*/
    }

    public Location(float longitude, float latitude, long sunrise, long sunset, String country, String city){
        this.longitude=longitude;
        this.latitude=latitude;
        this.sunset=sunset;
        this.sunrise=sunrise;
        this.country=country;
        this.city=city;
    }
    public Location(float longitude, float latitude, String country, String city)    {
        this.longitude=longitude;
        this.latitude=latitude;
        this.country=country;
        this.city=city;
    }
    public Location(float longitude, float latitude)    {
        this.longitude=longitude;
        this.latitude=latitude;
    }

    /*Theo_ EndOfConstructors*/

    /*Theo_ Setters & Getters*/
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public long getSunset() {
        return sunset;
    }
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
    public long getSunrise() {
        return sunrise;
    }
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
   /*Theo_ EndOfSetters & Getters*/



}
