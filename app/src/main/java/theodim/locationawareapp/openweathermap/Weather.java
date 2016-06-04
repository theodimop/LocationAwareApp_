package theodim.locationawareapp.openweathermap;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dj_di_000 on 15/5/2016.
 *Theo Dimopoulos Copyright dimopoulosth.td@gmail.com
 */
public class Weather {


    public LocationGIS location;
    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();
    public Rain rain = new Rain();
    public Snow snow = new Snow()	;
    public Clouds clouds = new Clouds();
    public WeatherDate weatherDate = new WeatherDate();
    public byte[] iconData;

    /*Theo_ Constructors
    * N Constructors availiable*/
    public Weather(){
        /*Theo_ Empty Constructor*/
    }

    public Weather(LocationGIS location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Rain rain, Snow snow, Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.rain = rain;
        this.snow = snow;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }

    public Weather(LocationGIS location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Rain rain,Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }

    public Weather(LocationGIS location, CurrentCondition currentCondition, Temperature temperature, Wind wind,Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }

    public Weather(LocationGIS location, CurrentCondition currentCondition, Temperature temperature, Wind wind, Snow snow,Clouds clouds, WeatherDate weatherDate) {
        this.location = location;
        this.currentCondition = currentCondition;
        this.temperature = temperature;
        this.wind = wind;
        this.snow = snow;
        this.clouds = clouds;
        this.weatherDate = weatherDate;
    }
    /*Theo_ EndOfConstructors*/


    public  class CurrentCondition {
        private int weatherId;
        private String condition;
        private String descr;
        private String icon;


        private float pressure;
        private float humidity;

        public int getWeatherId() {
            return weatherId;
        }
        public void setWeatherId(int weatherId) {
            this.weatherId = weatherId;
        }
        public String getCondition() {
            return condition;
        }
        public void setCondition(String condition) {
            this.condition = condition;
        }
        public String getDescr() {
            return descr;
        }
        public void setDescr(String descr) {
            this.descr = descr;
        }
        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
        public float getPressure() {
            return pressure;
        }
        public void setPressure(float pressure) {
            this.pressure = pressure;
        }
        public float getHumidity() {
            return humidity;
        }
        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }

    }
    /*Theo Dimopoulos Copyright dimopoulosth.td@gmail.com*/
    public class WeatherDate {
        private Date date ;
        private DateFormat dateFormat;


        public void setDate(Long date){
            this.date =new Date(date);
        }

        public String getFullDateAndTime(){
            dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            return dateFormat.format(date);
        }

        public String getTime(){
            dateFormat = new SimpleDateFormat("hh:mm:ss");
            return dateFormat.format(date);
        }
        public String getDate(){
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(date);
        }
    }

    public  class Temperature {
        private float temp;
        private float minTemp;
        private float maxTemp;

        public float getTemp() {
            return temp;
        }
        public void setTemp(float temp) {
            this.temp = temp;
        }
        public float getMinTemp() {
            return minTemp;
        }
        public void setMinTemp(float minTemp) {
            this.minTemp = minTemp;
        }
        public float getMaxTemp() {
            return maxTemp;
        }
        public void setMaxTemp(float maxTemp) {
            this.maxTemp = maxTemp;
        }

    }

    public  class Wind {
        private float speed;
        private float deg;


        public float getSpeed() {
            return speed;
        }
        public void setSpeed(float speed) {
            this.speed = speed;
        }
        public float getDeg() {
            return deg;
        }
        public void setDeg(float deg) {
            this.deg = deg;
        }
    }

    public  class Rain {
        private String time;
        private float ammount;

        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }
        public float getAmmount() {
            return ammount;
        }
        public void setAmmount(float ammount) {
            this.ammount = ammount;
        }
    }

    public  class Snow {
        private String time;
        private float ammount;

        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }
        public float getAmmount() {
            return ammount;
        }
        public void setAmmount(float ammount) {
            this.ammount = ammount;
        }

    }

    public  class Clouds {
        private int perc;

        public int getPerc() {
            return perc;
        }
        public void setPerc(int perc) {
            this.perc = perc;
        }

    }

}

