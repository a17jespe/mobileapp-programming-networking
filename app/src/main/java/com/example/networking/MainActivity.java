package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

//    String ID, name, location, type;
//    Integer height;
//
//    Mountain mountainClass = new Mountain(ID, name, location, height, type);

    private ArrayList<Mountain> mountainArrayList;
    private ArrayAdapter<Mountain> mountainArrayAdapter;

    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            Log.e("QUERY ANSWER: ", json);
            try {
                mountainArrayAdapter.clear();
                JSONArray jsonArray = new JSONArray(json);
                for (int i=0; i < jsonArray.length(); i++) // Goes through i in array based on array length.
                {
                    JSONObject oneObject = jsonArray.getJSONObject(i); //Assigns object to variable based on current object in the array jsonArray.
//                            String ID = oneObject.getString("ID");
                            String name = oneObject.getString("name");
                            String location = oneObject.getString("location");
//                            String type = "a17jespe"; // As requested on lenasys
                            Integer height = oneObject.getInt("size");
                    Log.e("oneObject: ", String.valueOf(oneObject));

                    mountainArrayList.add(new Mountain(name, location, height)); //Adds a new mountain in arraylist with name, location and height (int) values.

                    Log.e("mountainArrayList(i): ", String.valueOf(mountainArrayList.get(i)));
                }
                Log.e("mountainArrayAdapter: ", String.valueOf(mountainArrayAdapter));
                mountainArrayAdapter.notifyDataSetChanged();

            } catch (JSONException e) {
                Log.e("JSON Stuff: ",e.getMessage());
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mountainArrayList = new ArrayList<>();
        mountainArrayAdapter = new ArrayAdapter<>(this, R.layout.layout_list_mountains, mountainArrayList);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView thelistview = (ListView) findViewById(R.id.my_listview);
        thelistview.setAdapter(mountainArrayAdapter);


        thelistview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.e("TOAST", String.valueOf(position));
                String name = mountainArrayList.get(position).getmountain("name");
                String height = mountainArrayList.get(position).getmountain("height");
                String location = mountainArrayList.get(position).getmountain("location");
                Log.e("TOAST NAME", name+height+location);
                String message = "The mountain " +  name + " exists in the area " + location + " and has a height of " + height + "m.";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        Button button = findViewById(R.id.button_execute);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=brom");

            }
        });

    }

    // Old code

//    private String[] MountainNames = {"Ettan","Tvåan","Trean"};
//    private String[] MountainLocations = {"Norrut","Söderut","Västerut"};
//    private int[] MountainSizes = {90,270,360};
//    private ArrayList<String> listData = new ArrayList<>(Arrays.asList(MountainNames));


    // Line 100
    //
//                    Mountain MountainInfo = new Mountain (name,location,height);
//                    Log.e("MountainInfo: ", String.valueOf(MountainInfo));
//                    mountainArrayList.add(MountainInfo);




}
