package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by dj_di_000 on 4/6/2016.
 */
public class Rain {
    private String time;
    private float amount;

    public Rain(String time, float amount) {
        this.time = time;
        this.amount = amount;
    }

    public Rain() {

    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
