package theodim.locationawareapp.openweathermap;

import java.util.ArrayList;
import java.util.List;

import theodim.locationawareapp.WeatherBaseClasses.Location;

/**
 * Created by dj_di_000 on 16/5/2016.
 * This class is represents an unity 5 days forecast
 * Forecast5 has same structure with a weather request.
 * The difference is that the query returns 40 threeHourPeriodWeather json objects
 */

public class Forecast5 {

    private List<ThreeHourPeriodWeather> threeHourPeriodWeathers ;
    private Location location;

    /*Theo_ Constructors
    * 2 Constructors availiable*/

    public Forecast5(){
        threeHourPeriodWeathers=new ArrayList<>();
    }
    public Forecast5(Location location){
        this.location = location;
        threeHourPeriodWeathers=new ArrayList<>();
    }
    /*Theo_ EndOfConstructors
     */


    public void addThreeHourPeriodWeather(ThreeHourPeriodWeather threeHourPeriodWeather){
        threeHourPeriodWeathers.add(threeHourPeriodWeather);
    }
    public ThreeHourPeriodWeather getThreeHourPeriodWeatherByIndex(int index){
        return threeHourPeriodWeathers.get(index);
    }

    /*Theo_ Setters & Getters*/
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ThreeHourPeriodWeather> getThreeHourPeriodWeathers() {
        return threeHourPeriodWeathers;
    }
    public void setThreeHourPeriodWeathers(List<ThreeHourPeriodWeather> threeHourPeriodWeathers) {
        this.threeHourPeriodWeathers = threeHourPeriodWeathers;
    }
    /*Theo_ EndOfSetters & Getters*/
}
