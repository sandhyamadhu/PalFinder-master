package com.ench.sandhya2117.gps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
//        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//
//                    double lattitude=location.getLatitude();
//                    double logitude=location.getLongitude();
////                    double logitude=location.getLongitude();
////                    double lattitude=location.getLatitude();
//                    LatLng latLng=new LatLng(lattitude,logitude);
//                    Geocoder geocoder=new Geocoder(getApplicationContext());
//
//                    try {
//                        List<Address> addressList=geocoder.getFromLocation(lattitude,logitude,1);
//                        String str=addressList.get(0).getLocality()+" ";
//                        str+=addressList.get(0).getCountryName();
//                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
//                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10.2f));
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                @Override
//                public void onStatusChanged(String provider, int status, Bundle extras) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String provider) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String provider) {
//
//                }
//            });
//        }
//
//else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//     locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
//         @Override
//         public void onLocationChanged(Location location) {
//              double logitude=location.getLongitude();
//              double lattitude=location.getLatitude();
//             LatLng latLng=new LatLng(lattitude,logitude);
//             Geocoder geocoder=new Geocoder(getApplicationContext());
//             try {
//                 List<Address> addressList=geocoder.getFromLocation(lattitude,logitude,1);
//                 String str=addressList.get(0).getLocality()+" ";
//                 str+=addressList.get(0).getCountryName();
//                 mMap.addMarker(new MarkerOptions().position(latLng).title(str));
//                 mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10.2f));
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//
//         @Override
//         public void onStatusChanged(String provider, int status, Bundle extras) {
//
//         }
//
//         @Override
//         public void onProviderEnabled(String provider) {
//
//         }
//
//         @Override
//         public void onProviderDisabled(String provider) {
//
//         }
//     });
//        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
       mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng hyderabad = new LatLng(17.387140, 78.491684
        );




        mMap.addMarker(new MarkerOptions().position(hyderabad).title("Marker in hyderabad"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hyderabad,10.2f));
        LatLng kurnool = new LatLng(15.834536, 78.029366);
        mMap.addMarker(new MarkerOptions().position(kurnool).title("Marker in kurnool"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kurnool,10.2f));
        LatLng banglore = new LatLng(12.972442, 77.580643);
        mMap.addMarker(new MarkerOptions().position(banglore).title("Marker in banglore"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(banglore,10.2f));
        LatLng chennai = new LatLng(13.067439, 80.237617);
        mMap.addMarker(new MarkerOptions().position(chennai).title("Marker in chennai"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chennai));
        LatLng delhi = new LatLng(28.644800, 77.216721);
        mMap.addMarker(new MarkerOptions().position(delhi).title("Marker in delhi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));

    }
}
