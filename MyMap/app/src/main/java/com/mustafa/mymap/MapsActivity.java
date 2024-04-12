package com.mustafa.mymap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/*

Das ist eine Google Maps-Anwendung mit 5 Orten in der Duisburger Innenstadt
(Sparkasse_Duisburg , Königstraße , Bauernmarkt , Duisburger_Innenstadt , König_Heinrich_Platz)

 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    //Breiten- und Längengrad Linien für Sparkasse_Duisburg
    private LatLng Sparkasse_Duisburg = new LatLng(51.43256370550697, 6.769685093722243);

    //Breiten- und Längengrad Linien für Königstraße
    private LatLng Königstraße = new LatLng(51.432964, 6.768892);

    //Breiten- und Längengrad Linien für Bauernmarkt
    private LatLng Bauernmarkt = new LatLng(51.43317011674925, 6.768253977083163);

    //Breiten- und Längengrad Linien für Duisburger_Innenstadt
    private LatLng Duisburger_Innenstadt = new LatLng(51.43307181072014, 6.768131897349764);

    //Breiten- und Längengrad Linien für König_Heinrich_Platz
    private LatLng König_Heinrich_Platz = new LatLng(51.4330918947648, 6.767935213334845);


    // Marker für jeder Standort  (Marker = Ortssymbol)
    private Marker mSparkasse_Duisburg;
    private Marker mKönigstraße;
    private Marker mBauernmarkt;
    private Marker mDuisburger_Innenstadt;
    private Marker mKönig_Heinrich_Platz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map); //MapFragment mit UI-id verknüpfen
        mapFragment.getMapAsync(this);
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


    //initialisieren von map
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this) ;


        List<Marker> markerList = new ArrayList<>(); // erstellen von Marker-arrayList

        /*
        Achtung : jeder Ort Symbol auf der Karte hat verschiedene Farbe beim darauftippen
         */

        mSparkasse_Duisburg = mMap.addMarker(new MarkerOptions().position(Sparkasse_Duisburg)
                .title("SparKasse Duisburg")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // Hinfügen von Titel, Position und Symbolfarbe beim drauftippen
        mSparkasse_Duisburg.setTag(0);
        markerList.add(mSparkasse_Duisburg); // mSparkasse_Duisburg in der marker-liste hinfügen
        //_____________________________

        mBauernmarkt = mMap.addMarker(new MarkerOptions().position(Bauernmarkt)
                .title("Bauern Markt")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))); //Hinfügen von Titel, Position und Symbolfarbe beim drauftippen
        mBauernmarkt.setTag(0);
        markerList.add(mBauernmarkt); // mBauernmarkt in der marker-liste hinfügen
        //_____________________________

        mDuisburger_Innenstadt = mMap.addMarker(new MarkerOptions().position(Duisburger_Innenstadt)
        .title("Duisburger Innenstadt")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))); //Hinfügen von Titel, Position und Symbolfarbe beim drauftippen
        mDuisburger_Innenstadt.setTag(0);
        markerList.add(mDuisburger_Innenstadt); // mDuisburger_Innenstadt in der marker-liste hinfügen
        //_____________________________

        mKönig_Heinrich_Platz = mMap.addMarker(new MarkerOptions().position(König_Heinrich_Platz)
        .title("König Heinrig Platz")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));  //Hinfügen von Titel, Position und Symbolfarbe beim drauftippen
        mKönig_Heinrich_Platz.setTag(0);
        markerList.add(mKönig_Heinrich_Platz);// mKönig_Heinrich_Platz in der marker-liste hinfügen
        //_____________________________

        mKönigstraße = mMap.addMarker(new MarkerOptions().position(Königstraße)
        .title("König Straße")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))); //Hinfügen von Titel, Position und Symbolfarbe beim drauftippen
        mKönigstraße.setTag(0);
        markerList.add(mKönigstraße); // mKönigstraße in der marker-liste hinfügen


        // foreach Schleife
        for (Marker m:markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude); // initialisieren von Breiten- und Längengrad Linien
            mMap.addMarker(new MarkerOptions().position(latLng)); // Map wird die initialisieren von Breiten- und Längengrad Linien enthalten
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10)); // Zoomoption hinzufügen
        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Toast.makeText(this,marker.getTitle(),Toast.LENGTH_LONG).show(); // beim Ort Symbol darauf tippen der titel wird in einer Toast Nachricht angezeigt
        return false;
    }
}