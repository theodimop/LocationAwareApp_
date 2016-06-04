package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by Theo on 4/6/2016.
 */
public class Clouds {

    private int percentage;

    /**
     * @param percentage This is the percentage of the sky coverage by cloud
     */
    public Clouds(int percentage)
    {
        this.percentage=percentage;
    }

    public int getPerc() {
        return percentage;
    }
    public void setPerc(int percentage) {
        this.percentage = percentage;
    }
}
