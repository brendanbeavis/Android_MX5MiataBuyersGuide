package com.smashedpotato.miatabuyersguide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by beavi on 13/11/2016.
 */

public class MX5Content {

    public static final List<MX5Content.MXItem> ITEMS = new ArrayList<MX5Content.MXItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MX5Content.MXItem> ITEM_MAP = new HashMap<String, MX5Content.MXItem>();

    private Context context;

    String[] categories;
    public MX5Content(Context current,String packageName){
        try{
            if(ITEMS.size() <= 0) {
            this.context = current;
            Resources res = context.getResources();
            categories = res.getStringArray(R.array.Categories);

            for (int i = 0; i < categories.length; i++) {
                Log.d("MX5Content", "categories: "+categories[i]);
               // addItem(new MX5Content.MXItem(categories[i], categories[i].replace("_", " "), res.getString(res.getIdentifier(categories[i].replace(">", "_"), "string", packageName))));
                if(categories[i].contains("_XXX")){
                    addItem(new MX5Content.MXItem(categories[i], categories[i].replace("_XXX", ":").replace("_", " "), ""));
                }
                else{
                    addItem(new MX5Content.MXItem(categories[i], categories[i].replace("_YYY", "!").replace("_", " "), res.getString(res.getIdentifier(categories[i].replace(">", "_"), "string", packageName))));
                    }
                }
            }
        }
        catch(Exception e){ Log.e("",e.getMessage());}
    }

    private static void addItem(MX5Content.MXItem item) {
        try{
            ITEMS.add(item);
            ITEM_MAP.put(item.name, item);
        }
        catch(Exception e){ Log.e("",e.getMessage());}
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class MXItem {
        public final String name;
        public final String content;
        public final String details;

        public MXItem(String name, String content, String details) {
            this.name = name;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}


