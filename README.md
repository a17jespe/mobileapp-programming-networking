
# Rapport

**Skriv din rapport här!**


##### 1 - Listview

I added a listview which I would later fill with stuff!

![](Listview.png)



##### 2 - ArrayList & ArrayAdapter

Afterwards I added an arraylist and arrayadapter which were connected to both my listview and my second class, Mountain.

```
public class MainActivity extends AppCompatActivity {

    private ArrayList<Mountain> mountainArrayList = new ArrayList<>();
    private ArrayAdapter<Mountain> mountainArrayAdapter;

        protected void onCreate(Bundle savedInstanceState) {


        mountainArrayList = new ArrayList<>();
        mountainArrayAdapter = new ArrayAdapter<>(this, R.layout.layout_list_mountains,R.id.layouttextview , mountainArrayList);

        ListView thelistview = (ListView) findViewById(R.id.my_listview);
        thelistview.setAdapter(mountainArrayAdapter);
        }
}
```

With this particular aspect I had a lot of issues. This was primarily caused by a confusion of how I were to retrieve a specific value from the Mountain Class.
I had missed the part where I had to @Override the toString functionality in Mountain and return a value. I had attempted to return values with functions but I had been unsuccessful in my attempts until I found that particular section of an older instruction.

```
        @Override
        public String toString(){
                return mountainName;
        }
```


##### 3 - JSON Task

I'll be excluding the network code as it's handed to us.

The onPostExecute part added every mountain to the Mountain class per 'for loop'. 

```

for (int i=0; i < jsonArray.length(); i++) // Goes through i in array based on array length.
                {
                    JSONObject oneObject = jsonArray.getJSONObject(i); //Assigns object to variable based on current object in the array jsonArray.
                            String name = oneObject.getString("name");
                            String location = oneObject.getString("location");
                            Integer height = oneObject.getInt("size");
                    mountainArrayList.add(new Mountain(name, location, height)); //Adds a new mountain in arraylist with name, location and height (int) values.

                }
```

Previously I added every value from the JSON parse to the Mountain class but as I ran into some trouble with getting values from Mountain into the list, I started to reduce the variety of values to minimize potential issues.

After the values has been parsed, the list is updated through the following line of code:

```
                mountainArrayAdapter.notifyDataSetChanged();
```

##### 4 - Results

And here are the results, with toast message included, implemented through a listener.

```

        thelistview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String name = mountainArrayList.get(position).getmountain("name");
                String height = mountainArrayList.get(position).getmountain("height");
                String location = mountainArrayList.get(position).getmountain("location");
                String message = "The mountain " +  name + " exists in " + location + " and has a height of " + height + "m.";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

```



![](App.png)



_Du kan ta bort all text som finns sedan tidigare_.

## Följande grundsyn gäller dugga-svar:

- Ett kortfattat svar är att föredra. Svar som är längre än en sida text (skärmdumpar och programkod exkluderat) är onödigt långt.
- Svaret skall ha minst en snutt programkod.
- Svaret skall inkludera en kort övergripande förklarande text som redogör för vad respektive snutt programkod gör eller som svarar på annan teorifråga.
- Svaret skall ha minst en skärmdump. Skärmdumpar skall illustrera exekvering av relevant programkod. Eventuell text i skärmdumpar måste vara läsbar.
- I de fall detta efterfrågas, dela upp delar av ditt svar i för- och nackdelar. Dina för- respektive nackdelar skall vara i form av punktlistor med kortare stycken (3-4 meningar).

Programkod ska se ut som exemplet nedan. Koden måste vara korrekt indenterad då den blir lättare att läsa vilket gör det lättare att hitta syntaktiska fel.

```
function errorCallback(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            // Geolocation API stöds inte, gör något
            break;
        case error.POSITION_UNAVAILABLE:
            // Misslyckat positionsanrop, gör något
            break;
        case error.UNKNOWN_ERROR:
            // Okänt fel, gör något
            break;
    }
}
```

Bilder läggs i samma mapp som markdown-filen.

![](android.png)

Läs gärna:

- Boulos, M.N.K., Warren, J., Gong, J. & Yue, P. (2010) Web GIS in practice VIII: HTML5 and the canvas element for interactive online mapping. International journal of health geographics 9, 14. Shin, Y. &
- Wunsche, B.C. (2013) A smartphone-based golf simulation exercise game for supporting arthritis patients. 2013 28th International Conference of Image and Vision Computing New Zealand (IVCNZ), IEEE, pp. 459–464.
- Wohlin, C., Runeson, P., Höst, M., Ohlsson, M.C., Regnell, B., Wesslén, A. (2012) Experimentation in Software Engineering, Berlin, Heidelberg: Springer Berlin Heidelberg.
