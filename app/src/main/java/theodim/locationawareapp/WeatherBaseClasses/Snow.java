package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by dj_di_000 on 4/6/2016.
 */
public class Snow {
    private String time;
    private float amount;

    /*
    * @param time
    * @param amount
    */
    public Snow(String time,float amount)
    {
        this.time=time;
        this.amount=amount;
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
