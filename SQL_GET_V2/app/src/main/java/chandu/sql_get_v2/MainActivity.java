package chandu.sql_get_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import chandu.sql_get_v2.api.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.10.132")
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        ServiceApi serviceApi=retrofit.create(ServiceApi.class);

        Call<List> call=serviceApi.getProduct();

        call.enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
               // Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
                ArrayList<String> list2=new ArrayList<String>();
                try {
                    JSONArray jsonArray=new JSONArray(response.body().toString());
                    for(int i=0;i<response.body().size();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        list2.add(jsonObject.getString("name"));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list2);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List> call, Throwable t) {

            }
        });
    }
}
