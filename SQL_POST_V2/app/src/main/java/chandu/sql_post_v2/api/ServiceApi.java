package chandu.sql_post_v2.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Chandu on 1/17/2018.
 */

public interface ServiceApi {

    @FormUrlEncoded
    @POST("/vam.php")
    Call<ResponseBody> addProduct(@Field("pname") String name);


}
