package theodim.locationawareapp.openweathermap;

import java.util.Date;

/**
 * Created by dj_di_000 on 17/5/2016.
 * This class is for the uv_index query response
 */
public class UV_Index {
    private LocationGIS locationGIS;
    private float uV_Index;
    private String sDate;


    /*Theo_ Constructors
    * 2 Constructors availiable*/
    public UV_Index(){
        /*Theo_ Empty Constructor*/
    }

    public UV_Index(LocationGIS locationGIS, float uV_Index, String sDate) {
        this.locationGIS = locationGIS;
        this.uV_Index = uV_Index;
        this.sDate = sDate;
    }
    /*Theo_ EndOfConstructors*/


    /*Theo_ Setters & Getters*/

    public float getuV_Index() {
        return uV_Index;
    }

    public void setuV_Index(float uV_Index) {
        this.uV_Index = uV_Index;
    }

    public String getDate() {
        return sDate;
    }

    public void setDate(String sDate) {
        this.sDate = sDate;
    }

    public LocationGIS getLocationGIS() {
        return locationGIS;
    }

    public void setLocationGIS(LocationGIS locationGIS) {
        this.locationGIS = locationGIS;
    }
    /*Theo_ EndOfSetters & Getters*/

}
