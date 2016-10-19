package com.mcs.easysocial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class EasyRateMod {

    public static void rateApp(Context context){
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName(context))));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName(context))));
        }
    }

    private static String appPackageName(Context context){
        return context.getApplicationContext().getPackageName();
    }
}
