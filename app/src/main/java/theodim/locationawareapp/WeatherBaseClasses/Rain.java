package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by dj_di_000 on 4/6/2016.
 */
public class Rain {
    private String time;
    private float ammount;

    public Rain(String time, float ammount) {
        this.time = time;
        this.ammount = ammount;
    }

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
