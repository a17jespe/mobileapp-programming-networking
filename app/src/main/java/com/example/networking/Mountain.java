package com.example.networking;

import android.util.Log;

public class Mountain {

        private String mountainID;
        private String mountainType;
        private String category;
        private Integer cost;
        private String img;
        private String aux;
        private String mountainName;
        private String mountainLocation;
        private Integer mountainHeight;


        public Mountain (String name, String location, Integer height){
//                mountainID,mountainName,mountainLocation,mountainHeight



//                mountainID = ID;
                mountainName = name;
                mountainLocation = location;
                mountainHeight = height;
                Log.e("MOUNTAIN NAME: ", String.valueOf(mountainName));
//                mountainType = Type;



        }


        public String getmountain(String which){

                if (which.equals("name")) {
                        return mountainName;
                }

                else if (which.equals("height")) {
                        return String.valueOf(mountainHeight);
                }

                else if (which.equals("location")) {
                        return mountainLocation;
                }

                else{
                        return "Well shit";
                }
        }


}
