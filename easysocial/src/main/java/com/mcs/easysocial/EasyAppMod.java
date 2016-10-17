package com.mcs.easysocial;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import static com.mcs.easysocial.EasyStringMod.intToString;

public class EasyAppMod {

    private static final String NAME_NOT_FOUND_EXCEPTION = "Name Not Found Exception";

    public static final String FACEBOOK_APP = "com.facebook.katana";
    public static final String GOOGLE_PLUS_APP = "com.google.android.apps.plus";
    public static final String TWITTER_APP = "com.twitter.android";
    public static final String YOUTUBE_APP = "com.google.android.youtube";

    public static boolean IfAppIsInstalled(Context context, String pkg) {
        return IsAppInstalled(context, pkg) && IsAppEnabled(context, pkg);
    }

    private static boolean IsAppInstalled(Context context, String pkg) {
        PackageManager app = context.getPackageManager();
        try {
            app.getPackageInfo(pkg, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static boolean IsAppEnabled(Context context, String pkg) {
        //PackageManager app = context.getPackageManager();
        try {
            ApplicationInfo ai =  context.getPackageManager().getApplicationInfo(pkg, 0);
            return ai.enabled;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static String AppVersion( Context context, String pkg) {
        PackageManager app = context.getPackageManager();
        try {
            app.getPackageInfo(pkg, 0);
            PackageInfo pinfo;
            try {
                pinfo = context.getPackageManager().getPackageInfo(pkg, 0);
                return pinfo.versionName;
            } catch (Exception e) {
                e.printStackTrace();
                return NAME_NOT_FOUND_EXCEPTION;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return NAME_NOT_FOUND_EXCEPTION;
        }
    }
    public static String AppVersionCode( Context context, String pkg) {
        PackageManager app = context.getPackageManager();
        try {
            app.getPackageInfo(pkg, 0);
            PackageInfo pinfo;
            try {
                pinfo = context.getPackageManager().getPackageInfo(pkg, 0);
                int version = pinfo.versionCode;
                return intToString(version);
            } catch (Exception e) {
                e.printStackTrace();
                return NAME_NOT_FOUND_EXCEPTION;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return NAME_NOT_FOUND_EXCEPTION;
        }
    }
}