package theodim.locationawareapp.WeatherBaseClasses;

/**
 * Created by Theo on 4/6/2016.
 */
public class Cloud {

    private int percentage;

    /**
     * @param percentage This is the percentage of the sky coverage by cloud
     */
    public Cloud(int percentage)
    {
        this.percentage=percentage;
    }

    public Cloud() {

    }

    public int getPerc() {
        return percentage;
    }
    public void setPerc(int percentage) {
        this.percentage = percentage;
    }
}
