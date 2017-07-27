package com.example.administrator.llab.Network.retrofit;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Result {

    String id,name,country,path,timezone,timezone_offset;

    Result(String id,String name,String country,String path,String timezone,String timezone_offset)
    {
        this.id = id;
        this.name = name;
        this.country = country;
        this.timezone = timezone;
        this.path = path;
        this.timezone_offset = timezone_offset;
    }

    @Override
    public String toString() {
        return "id:"+id+"\n"+"name:"+name+"\n"+"country:"+country+"\n"+"timezone:"+timezone+"\n"+"path:"+path+"\n";
    }
}
