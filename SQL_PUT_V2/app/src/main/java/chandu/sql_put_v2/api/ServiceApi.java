package chandu.sql_put_v2.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;

/**
 * Created by Chandu on 1/17/2018.
 */

public interface ServiceApi {
    @FormUrlEncoded
    @PUT("/edit.php")
    Call<ResponseBody> editProduct(@Field("pname") String name );
}
