package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {

//    private ArrayList<Mountain> ;

//    public class ArrayList<Mountain> {
//
//        private String ID;
//        private String name;
//        private String type;
//        private String location;
//        private String category;
//        private Integer size;
//        private Integer cost;
//        private String img;
//        private String aux;
//
//    }




//    @SuppressLint("StaticFieldLeak")
//    private class JsonTask extends AsyncTask<String, String, String> {
//
//        private HttpURLConnection connection = null;
//        private BufferedReader reader = null;
//
//        protected String doInBackground(String... params) {
//            try {
//                URL url = new URL(params[0]);
//                connection = (HttpURLConnection) url.openConnection();
//                connection.connect();
//
//                InputStream stream = connection.getInputStream();
//                reader = new BufferedReader(new InputStreamReader(stream));
//
//                StringBuilder builder = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null && !isCancelled()) {
//                    builder.append(line).append("\n");
//                }
//                return builder.toString();
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (connection != null) {
//                    connection.disconnect();
//                }
//                try {
//                    if (reader != null) {
//                        reader.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String json) {
//            Log.d("TAG", json);
//
//        }
//    }


    private String[] MountainNames = {"Ettan","Tvåan","Trean"};
    private String[] MountainLocations = {"Norrut","Söderut","Västerut"};
    private int[] MountainSizes = {90,270,360};
    private ArrayList<String> listData = new ArrayList<>(Arrays.asList(MountainNames));


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ArrayAdapter<String> mountainAdapter =
                new ArrayAdapter<String>(this, R.layout.layout_list_mountains, listData);

        ListView thelistview = (ListView) findViewById(R.id.my_listview);

//        String TAG = "Testing:";
//
//        for (int i = 0;i < 2; i++){
//            Log.e(TAG, listData.get(i));
//        }

//        thelistview.setAdapter(mountainAdapter);

//        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener());{
//            @override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
//            }
//        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button_execute);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=brom");
            }
        });

    }


}
