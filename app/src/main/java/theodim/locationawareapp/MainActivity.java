package theodim.locationawareapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import theodim.locationawareapp.openweathermap.Weather;

import static theodim.locationawareapp.Message.logMessage;
import static theodim.locationawareapp.Message.toastMessage;

public class MainActivity extends AppCompatActivity// implements ConnectionCallbacks, OnConnectionFailedListener {
{
  //  GoogleApiClient mGoogleApiClient;
  //  Location mDeviceLastLocation;


    private TextView textView,textViewWeatherInfo;
    private Weather weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        /*
        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
*/
        textView= (TextView) findViewById(R.id.textView);
        textViewWeatherInfo= (TextView) findViewById(R.id.textView2);

        WeatherInfomation weatherInfomation=new WeatherInfomation(textViewWeatherInfo);

    }
/*
    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        double latitude,longitude=0;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mDeviceLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if(mDeviceLastLocation!=null) {

            latitude = mDeviceLastLocation.getLatitude();
            longitude= mDeviceLastLocation.getLongitude();

            if(mDeviceLastLocation.hasAltitude())
            {
                logMessage(mDeviceLastLocation.getAltitude() + " ");
                toastMessage(this, "Altitude: " + mDeviceLastLocation.getAltitude());
            }
            else
            {
                logMessage("Altitude is not supported");
            }

            logMessage("Longitude: " + longitude);
            toastMessage(this, "Longitude: " + longitude);
            logMessage("Latitude: " +latitude);
            toastMessage(this, "Latitude: " +latitude);
            textView.setText("Longitude: "+longitude+"\nLatitude: "+latitude);

        }



    }

    @Override
    public void onConnectionSuspended(int i) {
        logMessage("ConnectionSuspended");
        toastMessage(this,"Connection Suspended");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        logMessage("Connection Failed");
        toastMessage(this,"Connection Failed");
    }



    public void updateLocation(View view) {
        mGoogleApiClient.reconnect();

    }
    */
}
