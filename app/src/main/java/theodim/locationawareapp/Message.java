package theodim.locationawareapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by dj_di_000 on 13/5/2016.
 */
public class Message {

    public static void logMessage(String message){
        Log.e("THEO",message);
    }
    public static void toastMessage(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
