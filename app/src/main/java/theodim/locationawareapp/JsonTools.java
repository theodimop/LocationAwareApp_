package theodim.locationawareapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dj_di_000 on 4/6/2016.
 * JSONTools class offers auxiliary methods to handle JSON objects
 */
public class JSONTools {

    public static final float NO_FLOAT_VALUE = -654637f;
    public static final int NO_INT_VALUE = -6546321;
    public static final long NO_LONG_VALUE = -654687L;
    public static final String NO_STRING_VALUE = "NaN";

    public static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {

        if(jObj.has(tagName)){
            return  jObj.getJSONObject(tagName);
        }else
            return null;

    }
    public static String getString(String tagName, JSONObject jObj) throws JSONException {
        if(jObj.has(tagName))
            return jObj.getString(tagName);
        else
           return NO_STRING_VALUE;
    }
    public static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        if(jObj.has(tagName))
            return (float) jObj.getDouble(tagName);
        else
            return NO_FLOAT_VALUE;


    }
    public static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        if(jObj.has(tagName))
            return jObj.getInt(tagName);
        else
            return NO_INT_VALUE;
    }
    public static long  getLong(String tagName, JSONObject jObj) throws JSONException {
            if(jObj.has(tagName))
                return jObj.getLong(tagName);
            else
                return NO_LONG_VALUE;

    }
}
