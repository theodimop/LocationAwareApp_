package theodim.locationawareapp.WeatherBaseClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dj_di_000 on 4/6/2016.
 */
public class WeatherDate {
    private Date date ;
    private DateFormat dateFormat;

    public WeatherDate(Date date) {
        this.date = date;
    }
    public WeatherDate(Long date){
        this.date=new Date(date);
    }

    public void setDate(Long date){
        this.date =new Date(date);
    }

    public String getFullDateAndTime(){
        dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.US);
        return dateFormat.format(date);
    }

    public String getTime(){
        dateFormat = new SimpleDateFormat("hh:mm:ss",Locale.US);
        return dateFormat.format(date);
    }

    public String getDate(){
        dateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
        return dateFormat.format(date);
    }
}
