package chandu.sql_get_v2.api;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Chandu on 1/17/2018.
 */

public interface ServiceApi {

    @GET("/start.php")
    Call<List> getProduct();

}
