package com.example.administrator.llab.Network.retrofit;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class City {

    private List<Result> results;

    @Override
    public String toString() {
        return results.get(0).toString();
    }
}
