package com.example.jhonatanalvarezcaicedo.moviesfeedapp.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by jhonatanalvarezcaicedo on 8/06/17.
 */

public class Util {

   public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
