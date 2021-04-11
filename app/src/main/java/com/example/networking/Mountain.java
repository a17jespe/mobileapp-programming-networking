package com.example.networking;

import android.util.Log;

public class Mountain {

        public String mountainName;
        public String mountainLocation;
        public Integer mountainHeight;

        public Mountain(String name, String location, Integer height){

                mountainName = name;
                mountainLocation = location;
                mountainHeight = height;

        }

        @Override
        public String toString(){
                return mountainName;
        }

        public String getmountain(String which){

                switch (which) {
                        case "height":
                                return String.valueOf(mountainHeight);
                        case "location":
                                return mountainLocation;
                        default:
                                return mountainName;
                }
        }
}