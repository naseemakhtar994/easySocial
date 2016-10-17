package com.mcs.easysocial;

import android.content.Context;
import android.net.ConnectivityManager;

public class EasyNetworkMod {

    public static int ONE_MIN_DELAY = 60000;
    public static int ONE_SEC_DELAY = 1000;

    public static boolean isOnline(Context context){
        try {
            ConnectivityManager connManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return connManager.getActiveNetworkInfo() != null && connManager.getActiveNetworkInfo().isAvailable() && connManager.getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception e) {
            return false;
        }
    }
}
