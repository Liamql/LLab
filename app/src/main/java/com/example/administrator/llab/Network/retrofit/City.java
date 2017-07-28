package com.example.administrator.llab.Network.retrofit;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class City {

    private List<Result> results;

    public class Result{
        Location location;
        Now now;
        public String last_update;

        @Override
        public String toString() {
            return location.toString()+now.toString()+last_update;
        }
    }

    public class Now{
        public String text;
        public int code;
        public float temperature;

        @Override
        public String toString() {
            return "text:"+text+"\n code:"+code+"\n"+"temperature:"+temperature+"\n";
        }
    }

    @Override
    public String toString() {
        return results.get(0).toString();
    }
}
