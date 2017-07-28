package com.example.administrator.llab.Network.retrofit;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Location {
    public String id;
    public String name;
    public String country;
    public String path;
    public String timezone;
    public String timezone_offset;

    @Override
    public String toString() {
        return "name:"+name+"\n country:"+country+"\n";
    }
}
