package badebaba.retrocountry;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by badebaba on 9/29/2016.
 */

public interface ServiceApi {

    @GET("mock/countries.json")
    Call<List<Model>> repos();
}
