
package alirezasobhani.example.com.cba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable{

    @SerializedName("lat")
    @Expose
    private float lat;
    @SerializedName("lng")
    @Expose
    private float lng;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

}
