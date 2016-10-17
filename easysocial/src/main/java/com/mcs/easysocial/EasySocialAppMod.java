package com.mcs.easysocial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;


import static com.mcs.easysocial.EasyAppMod.AppVersion;
import static com.mcs.easysocial.EasyAppMod.FACEBOOK_APP;
import static com.mcs.easysocial.EasyAppMod.GOOGLE_PLUS_APP;
import static com.mcs.easysocial.EasyAppMod.IfAppIsInstalled;
import static com.mcs.easysocial.EasyAppMod.TWITTER_APP;
import static com.mcs.easysocial.EasyAppMod.YOUTUBE_APP;
import static com.mcs.easysocial.EasyNetworkMod.isOnline;
import static com.mcs.easysocial.EasyStringMod.containsDigit;
import static com.mcs.easysocial.EasyStringMod.stringToInt;
import static com.mcs.easysocial.EasyViewMod.toast;

public class EasySocialAppMod {

    private static final String LATEST_FB_PAGE_URL = "fb://facewebmodal/f?href=https://www.facebook.com/";
    private static final String LEGACY_FB_PAGE_URL = "fb://page/";
    private static final String LATEST_FB_PROFILE_URL = "fb://facewebmodal/f?href=https://www.facebook.com/profile.php?id=";
    private static final String LEGACY_FB_PROFILE_URL = "https://www.facebook.com/";
    private static final String FB_VERSION = "11.0.0.11.23";
    private static final String TWITTER_URL = "twitter://user?screen_name=";
    private static final String GOOGLE_PLUS_COMMUNITY_URL = "https://plus.google.com/communities/";
    private static final String GOOGLE_PLUS_PROFILE_URL = "https://plus.google.com/";
    private static final String YOUTUBE_URL = "vnd.youtube:";


    public static boolean openFacebookPage(Context context, String fbPage, boolean showMessage, String AppNotInstalled, String noConnection) {
        boolean facebook = false;
        if(isNetWorkAvailable(context)) {
            if (IfAppIsInstalled(context, FACEBOOK_APP)) {
                String facebookScheme = null;
                String version = AppVersion(context, FACEBOOK_APP);
                String version2 = version.replaceAll("[.]", "");
                String fb = FB_VERSION.replaceAll("[.]", "");//11.0.0.11.23 to 11001123
                try {
                    if (stringToInt(version2) >= stringToInt(fb))
                    {
                        facebookScheme = LATEST_FB_PAGE_URL + fbPage;
                    } else {
                        facebookScheme = LEGACY_FB_PAGE_URL + fbPage;
                    }
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookScheme));
                context.startActivity(facebookIntent);
                return facebook = true;
            }
            else{
                if(showMessage) {
                    myToast(context, AppNotInstalled);
                }
                return facebook = false;
            }
        }
        else {
            if(showMessage) {
                myToast(context, noConnection);
            }
        }
        return facebook;
    }
    public static boolean openFacebookProfile(Context context, String fbProfile, boolean showMessage, String AppNotInstalled, String noConnection) {
        boolean facebook = false;
        if(isNetWorkAvailable(context)) {
            if (IfAppIsInstalled(context, FACEBOOK_APP)) {
                String facebookScheme = null;
                String version = AppVersion(context, FACEBOOK_APP);
                String version2 = version.replaceAll("[.]", "");
                String fb = FB_VERSION.replaceAll("[.]", "");
                try {

                    if (stringToInt(version2) >= stringToInt(fb))//11.0.0.11.23 to 11001123
                    {
                        if(containsDigit(fbProfile)) {
                            facebookScheme = LATEST_FB_PROFILE_URL + fbProfile;
                        }
                        else{
                            facebookScheme = LATEST_FB_PAGE_URL + fbProfile;
                        }
                    } else {
                        facebookScheme = LEGACY_FB_PROFILE_URL + fbProfile;
                    }
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookScheme));
                context.startActivity(facebookIntent);
                return facebook = true;
            }
            else{
                if(showMessage) {
                    myToast(context, AppNotInstalled);
                }
                return facebook = false;
            }
        }
        else {
            if(showMessage){
                myToast(context, noConnection);
            }
        }
        return facebook;
    }

    public static boolean openTwitterProfile(Context context, String twitprofile, boolean showMessage, String AppNotInstalled, String noConnection) {
        boolean twitter = false;
        if(isNetWorkAvailable(context)) {
            if (IfAppIsInstalled(context, TWITTER_APP)) {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(TWITTER_URL + twitprofile)));
                return twitter = true;
            }
            else{
                if(showMessage) {
                    myToast(context, AppNotInstalled);
                }
                return twitter = false;
            }
        }
        else{
            if(showMessage) {
                myToast(context, noConnection);
            }
        }
        return twitter;
    }

    public static boolean openGooglePlusCommunity(Context context, String id, boolean showMessage, String AppNotInstalled, String noConnection) {
        boolean gplus = false;
        if(isNetWorkAvailable(context)) {
            if (IfAppIsInstalled(context, GOOGLE_PLUS_APP)) {
                final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(GOOGLE_PLUS_COMMUNITY_URL + id));
                intent.setPackage(GOOGLE_PLUS_APP);
                //if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                //}
                return gplus = true;
            }
            else{
                if(showMessage) {
                    myToast(context, AppNotInstalled);
                }
                return gplus = false;
            }
        }
        else{
            if(showMessage) {
                myToast(context, noConnection);
            }
        }
        return gplus;
    }
    public static boolean openGooglePlusProfile(Context context, String id, boolean showMessage, String AppNotInstalled, String noConnection) {
        boolean gplus = false;
        if(isNetWorkAvailable(context)) {
            if (IfAppIsInstalled(context, GOOGLE_PLUS_APP)) {
                final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(GOOGLE_PLUS_PROFILE_URL + id));
                intent.setPackage(GOOGLE_PLUS_APP);
                //if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                //}
                return gplus = true;
            }
            else{
                if(showMessage) {
                    myToast(context, AppNotInstalled);
                }
                return gplus = false;
            }
        }
        else{
            if(showMessage) {
                myToast(context, noConnection);
            }
        }
        return gplus;
    }

    public static boolean openYouTubeVideo(Context context, String video, boolean showMessage, String AppNotInstalled, String noConnection) {
        boolean youtube = false;
        if(isNetWorkAvailable(context)) {
            if (IfAppIsInstalled(context, YOUTUBE_APP)) {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_URL + video)));
                return youtube = true;
            }
            else{
                if(showMessage) {
                    myToast(context, AppNotInstalled);
                }
                return youtube = false;
            }
        }
        else{
            if(showMessage) {
                myToast(context, noConnection);
            }
        }
        return youtube;
    }

    private static boolean isNetWorkAvailable(Context context){
        return isOnline(context);
    }

    private static Toast myToast(Context context, String message){
        return toast(context, message, Toast.LENGTH_LONG);
    }

}
