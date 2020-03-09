package com.example.json_sendandreceive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickGetInfo(View view)
    {
        try
        {
            // 東京都の天気情報
            String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=270000";

            mQueue = Volley.newRequestQueue(this);
            mQueue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            // JSONObjectのパース、List、Viewへの追加等
                            ParseJSON(response);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override public void onErrorResponse(VolleyError error)
                        {
                            Log.e("Error", "レスポンスエラー\n");
                            DispWetherInfoErr(error);
                        }
                    }));
        }
        catch(Exception e)
        {
            Log.e("Error", "例外発生\n" + e);
        }
    }

    public void ParseJSON(JSONObject response)
    {
        try
        {
            Log.d("Debug", "Response is: OK\n");

            TextView textview = findViewById(R.id.WetherInfoText);
            String title = response.getString("title");
            textview.setText(title);

            TextView WeaterTextView = findViewById(R.id.weathertext);
            JSONArray datas = response.getJSONArray("forecasts");
            for (int i = 0; i < datas.length(); i++) {
                JSONObject data = datas.getJSONObject(i);
                String weater = data.getString("telop");
                WeaterTextView.setText(weater);
            }

            //ImageView imageView = findViewById(R.id.weatherImage);
            //JSONObject item2 = response.getJSONObject("item");
            //String weater = item2.get("url");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void DispWetherInfoErr(VolleyError error)
    {
        TextView textview = findViewById(R.id.WetherInfoText);
        textview.setText("Response is: NG\n" + error);
    }
}
