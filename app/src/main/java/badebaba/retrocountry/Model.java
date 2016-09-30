package badebaba.retrocountry;

import com.google.gson.annotations.SerializedName;

/**
 * Created by badebaba on 9/29/2016.
 */

public class Model {

    @SerializedName("name")
    String name;
    @SerializedName("area")
    Double area;

    public Model(String name, Double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}

