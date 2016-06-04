package theodim.locationawareapp.openweathermap;

/**
 * Created by dj_di_000 on 16/5/2016.
 * The forecast5 request returns this type of weather objects
 */
public class ThreeHourPeriodWeather  {
    private String period;//Ex 12:00 - 3:00 AM
    private Weather weather;

    /*Theo_ Constructors
    * 2 Constructors availiable*/
    public ThreeHourPeriodWeather(){
        /*Theo_ Empty Constructor*/
    }

    public ThreeHourPeriodWeather(String period,Weather weather){
        this.period=period;
        this.weather=weather;
    }
    /*Theo_ EndOfConstructors*/


    /*Theo_ Setters & Getters*/
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
    /*Theo_ Empty Constructor*/
}
