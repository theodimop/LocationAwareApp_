package theodim.locationawareapp.openweathermap;


import theodim.locationawareapp.WeatherBaseClasses.*;

/**
 * Created by dj_di_000 on 15/5/2016.
 *Theo Dimopoulos Copyright dimopoulosth.td@gmail.com
 */
public class Weather {


    private Location location;
    private CurrentCondition currentCondition;
    private Temperature temperature;
    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Clouds clouds;
    private WeatherDate weatherDate;
    private byte[] iconData;

    /*Theo_ Constructors*/
    public  Weather(){}

    public Weather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Rain rain, Snow snow, Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.rain = rain;
        this.snow = snow;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }

    public Weather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Rain rain, Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }

    public Weather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }

    public Weather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Snow snow, Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.snow = snow;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }

    /*Copy Constructor*/
    public Weather(Weather w){
        this.location=w.getLocation();
        this.currentCondition=w.getCurrentCondition();
        this.temperature=w.getTemperature();
        this.wind=w.getWind();
        this.rain=w.getRain();
        this.snow=w.getSnow();
        this.weatherDate=w.getWeatherDate();
        this.clouds=w.getClouds();
        this.iconData=w.getIconData();
    }
    /*Theo_ EndOfConstructors*/



    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentCondition getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(CurrentCondition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public WeatherDate getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(WeatherDate weatherDate) {
        this.weatherDate = weatherDate;
    }

    public byte[] getIconData() {
        return iconData;
    }

    public void setIconData(byte[] iconData) {
        this.iconData = iconData;
    }
}

