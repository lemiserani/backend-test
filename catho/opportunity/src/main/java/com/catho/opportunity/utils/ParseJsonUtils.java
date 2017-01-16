package com.catho.opportunity.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public class ParseJsonUtils {

    private static final Gson gson = new Gson();

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

}
