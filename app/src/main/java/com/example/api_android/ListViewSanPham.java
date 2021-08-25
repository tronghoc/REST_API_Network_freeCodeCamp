package com.example.api_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ListViewSanPham extends AppCompatActivity {
    ListView lv;
    ArrayList<SanPham> mang;
    EditText editText;
    Button btnTimKiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_san_pham);
        lv = (ListView) findViewById(R.id.lvSanPham);
        editText = (EditText) findViewById(R.id.editSearch);
        btnTimKiem = (Button) findViewById(R.id.btnTimKiem);
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mang = new ArrayList<SanPham>();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new docJSON().execute("https://khoapham.vn/download/json/vd3.php");
                    }
                });
            }
        });

    }
    class docJSON extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray mangJson = new JSONArray(s);
                for (int i = 0; i< mangJson.length();i++){
                    JSONObject sp = mangJson.getJSONObject(i);
                    mang.add(new SanPham(
                            sp.getString("tensp"),
                            sp.getInt("gia"),
                            sp.getString("hinh")
                    ));
                }
                ListAdapter adapter = new ListAdapter(
                     getApplicationContext(),R.layout.dong_san_pham,mang
                );
                lv.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }
    }
    private static String docNoiDung_Tu_URL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}