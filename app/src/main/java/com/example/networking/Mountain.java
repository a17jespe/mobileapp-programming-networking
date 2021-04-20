package com.example.networking;

import android.util.Log;

public class Mountain {

        private String Name;
        private String Location;
        private Integer Height;

        public Mountain(String name, String location, Integer height){

                Name = name;
                Location = location;
                Height = height;

        }

        @Override
        public String toString(){
                return Name;
        }

        public String getName(){
                return Name;
        }

        public String getLocation(){
                return Location;
        }

        public String getHeight(){
                return String.valueOf(Height);
        }
}