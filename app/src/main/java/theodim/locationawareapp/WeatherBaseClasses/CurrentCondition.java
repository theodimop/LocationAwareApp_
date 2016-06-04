package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by Theo on 4/6/2016.
 */
public class CurrentCondition {

    private int weatherId;
    private String condition;
    private String description;
    private String icon;
    private float pressure;
    private float humidity;

    public CurrentCondition(int weatherId, String condition, String description, String icon, float pressure, float humidity) {
        this.weatherId = weatherId;
        this.condition = condition;
        this.description = description;
        this.icon = icon;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public CurrentCondition() {

    }

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

