package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by THEO on 4/6/2016.
 */
public class Temperature {

    private float temp;
    private float minTemp;
    private float maxTemp;

    public Temperature(float temp, float minTemp, float maxTemp) {
        this.temp = temp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public Temperature() {

    }

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
