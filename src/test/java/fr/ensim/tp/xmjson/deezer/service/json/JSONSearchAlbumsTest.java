package fr.ensim.tp.xmjson.deezer.service.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class JSONSearchAlbumsTest
{
    public static void main(String[] args) {
        JSONObject root = new JSONObject(new JSONTokener("/data/json/albums-.json"));
    }
}
