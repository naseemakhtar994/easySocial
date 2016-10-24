package com.mcs.easysocial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static com.mcs.easysocial.EasyAppMod.appPackageName;

public class EasyRateMod {

    public static void rateApp(Context context){
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName(context))));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName(context))));
        }
    }
}
