package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by dj_di_000 on 4/6/2016.
 */
public class Wind {
    private float speed;
    private float deg;

    public Wind(float speed, float deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Wind() {

    }

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
