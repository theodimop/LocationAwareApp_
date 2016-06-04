package theodim.locationawareapp.openweathermap;

import java.util.ArrayList;

/**
 * Created by dj_di_000 on 16/5/2016.
 * This class is represents an unity 5 days forecast
 * Forecast5 has same structure with a weather request.
 * The difference is that the query returns 40 threeHourPeriodWeather json objects
 */

public class Forecast5 {

    private ArrayList<ThreeHourPeriodWeather> threeHourPeriodWeathers ;
    private LocationGIS locationGIS;

    /*Theo_ Constructors
    * 2 Constructors availiable*/

    public Forecast5(){
        threeHourPeriodWeathers=new ArrayList<>();
    }
    public Forecast5(LocationGIS locationGIS){
        this.locationGIS=locationGIS;
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
    public LocationGIS getLocationGIS() {
        return locationGIS;
    }
    public void setLocationGIS(LocationGIS locationGIS) {
        this.locationGIS = locationGIS;
    }

    public ArrayList<ThreeHourPeriodWeather> getThreeHourPeriodWeathers() {
        return threeHourPeriodWeathers;
    }
    public void setThreeHourPeriodWeathers(ArrayList<ThreeHourPeriodWeather> threeHourPeriodWeathers) {
        this.threeHourPeriodWeathers = threeHourPeriodWeathers;
    }
    /*Theo_ EndOfSetters & Getters*/
}
