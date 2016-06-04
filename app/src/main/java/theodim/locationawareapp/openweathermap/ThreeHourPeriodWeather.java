package theodim.locationawareapp.openweathermap;

import theodim.locationawareapp.WeatherBaseClasses.Cloud;
import theodim.locationawareapp.WeatherBaseClasses.CurrentCondition;
import theodim.locationawareapp.WeatherBaseClasses.Location;
import theodim.locationawareapp.WeatherBaseClasses.Rain;
import theodim.locationawareapp.WeatherBaseClasses.Snow;
import theodim.locationawareapp.WeatherBaseClasses.Temperature;
import theodim.locationawareapp.WeatherBaseClasses.WeatherDate;
import theodim.locationawareapp.WeatherBaseClasses.Wind;

/**
 * Created by dj_di_000 on 16/5/2016.
 * The forecast5 request returns this type of weather objects
 */
public class ThreeHourPeriodWeather  extends Weather{
    private String period;//Ex 12:00 - 3:00 AM

    public ThreeHourPeriodWeather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Rain rain, Snow snow, Cloud cloud, WeatherDate weatherDate, String period, Weather weather) {
        super(location, currentCondition, temperature, wind, rain, snow, cloud, weatherDate);
        this.period = period;
    }

    public ThreeHourPeriodWeather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Rain rain, Cloud cloud, WeatherDate weatherDate, String period, Weather weather) {
        super(location, currentCondition, temperature, wind, rain, cloud, weatherDate);
        this.period = period;
    }

    public ThreeHourPeriodWeather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Cloud cloud, WeatherDate weatherDate, String period, Weather weather) {
        super(location, currentCondition, temperature, wind, cloud, weatherDate);
        this.period = period;
    }

    public ThreeHourPeriodWeather(Location location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Snow snow, Cloud cloud, WeatherDate weatherDate, String period, Weather weather) {
        super(location, currentCondition, temperature, wind, snow, cloud, weatherDate);
        this.period = period;
    }

    public ThreeHourPeriodWeather(Weather w, String period) {
        super(w);
        this.period = period;
    }
    /*Theo_ Setters & Getters*/

    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }

}
