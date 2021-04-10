package com.example.networking;

import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Mountain {

        public static Object getmountain;
        //        private String mountainID;
//        private String mountainType;
//        private String category;
//        private Integer cost;
//        private String img;
//        private String aux;
        private String mountainName;
        private String mountainLocation;
        private Integer mountainHeight;

        public Mountain (String name, String location, Integer height){

                mountainName = name;
                mountainLocation = location;
                mountainHeight = height;
                Log.e("MOUNTAIN NAME: ", String.valueOf(mountainName));



        }




        public String getmountains(){
                String str = mountainName;
                str+=" has a height of ";
                str+=mountainHeight;
                str+=" and is located in ";
                str+=mountainLocation;
                return str;
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

