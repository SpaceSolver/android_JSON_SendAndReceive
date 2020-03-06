package com.example.json_sendandreceive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
            String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010";

            mQueue = Volley.newRequestQueue(this);
            mQueue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            // JSONObjectのパース、List、Viewへの追加等
                            DispWetherInfo(response);
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

    public void DispWetherInfo(JSONObject response)
    {
        TextView textview = findViewById(R.id.WetherInfoText);
        textview.setText("Response is: OK");
    }

    public void DispWetherInfoErr(VolleyError error)
    {
        TextView textview = findViewById(R.id.WetherInfoText);
        textview.setText("Response is: NG" + error);
    }
}
