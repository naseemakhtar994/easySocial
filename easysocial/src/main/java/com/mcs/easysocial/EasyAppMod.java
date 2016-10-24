package com.mcs.easysocial;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

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

    public static Drawable getAppIcon(Context context, String pkgID, Drawable appNotInstalled){
        if(IfAppIsInstalled(context, pkgID)){
            return appIcon(context, pkgID);
        }
        else{
            return appNotInstalled;
        }
    }

    @Nullable
    private static Drawable appIcon(Context context, String pkgID) {
        PackageManager pm = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
        {
            try
            {
                PackageInfo pi = pm.getPackageInfo(pkgID, 0);
                Context otherAppCtx = context.createPackageContext(pkgID, Context.CONTEXT_IGNORE_SECURITY);

                int displayMetrics[] = {DisplayMetrics.DENSITY_XHIGH, DisplayMetrics.DENSITY_HIGH, DisplayMetrics.DENSITY_TV};

                for (int displayMetric : displayMetrics)
                {
                    try
                    {
                        Drawable d = otherAppCtx.getResources().getDrawableForDensity(pi.applicationInfo.icon, displayMetric);
                        if (d != null)
                        {
                            return d;
                        }
                    }
                    catch (Resources.NotFoundException e)
                    {
//                      Log.d(TAG, "NameNotFound for" + packageName + " @ density: " + displayMetric);
                        continue;
                    }
                }

            }
            catch (Exception e)
            {
                // Handle Error here
            }
        }

        ApplicationInfo appInfo = null;
        try
        {
            appInfo = pm.getApplicationInfo(pkgID, PackageManager.GET_META_DATA);
        }
        catch (PackageManager.NameNotFoundException e)
        {
            return null;
        }

        return appInfo.loadIcon(pm);
    }

    public static String appPackageName(Context context){
        return context.getApplicationContext().getPackageName();
    }
}