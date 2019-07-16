package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich;
        JSONObject jsonObject= null;

        try {
            sandwich= new Sandwich();
            jsonObject = new JSONObject(json);

            sandwich.setMainName(jsonObject.getJSONObject("name").getString("mainName"));

            JSONArray alsoKnownAsJsonArray=jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs=new ArrayList<>();
            if (alsoKnownAsJsonArray != null) {
                for (int i=0;i<alsoKnownAsJsonArray.length();i++){
                    alsoKnownAs.add(alsoKnownAsJsonArray.get(i).toString());
                }
                sandwich.setAlsoKnownAs(alsoKnownAs);
            }

            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));

            sandwich.setDescription(jsonObject.getString("description"));

            sandwich.setImage(jsonObject.getString("image"));

            JSONArray ingredientsJsonArray=jsonObject.getJSONArray("ingredients");
            List<String> ingredients=new ArrayList<>();
            if (ingredientsJsonArray != null) {
                for (int i=0;i<ingredientsJsonArray.length();i++){
                    ingredients.add(ingredientsJsonArray.get(i).toString());
                }
                sandwich.setIngredients(ingredients);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            sandwich=new Sandwich();
        }


        return sandwich;

    }
}
