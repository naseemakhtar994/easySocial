# easySocial <a href='https://bintray.com/xstar97/Xstar97/easysocial/_latestVersion'><img src='https://api.bintray.com/packages/xstar97/Xstar97/easysocial/images/download.svg'></a>

easily launch any social app with your page/profile/etc.


Have you ever found it difficult to add social media integration into any of your apps?

-I am not just talking about "logging" in/out or even signing up, but allowing your users to visit all of your social media pages/profiles/etc inside each respective social media app.

I spent hours trying to do just that...however when one method did work...but ONLY upto a certain SDK or even app version(facebook was a huge d*ck about that!)

But, I still faced huge problems:

-app installed, not enabled

-no internet connection

-version/sdk specific method

-something bullshit you probably faced here!

So I did even more research (GOOGLE!) & came up with a great solution & even wrapped it in a simple "API" for your social media needs.

At The Moment I Only Support: "ATMIOS"

-Facebook

-twitter

-google plus

-youtube

-rate app dialog

library now on jcenter!

optional: to use this library please add this to your project level build gradle like this!
    
    allprojects {
    repositories {
        ...
        
        //this is my repo for now..waiting to add my library to jcenter!
        
        maven {url = "https://dl.bintray.com/xstar97/Xstar97/" }
        
        ...
    }}

To use this library please add this to your app level build gradle!
      
    compile 'com.mcs.easysocial:easysocial:1.1.3'

Now that we got all that out of the way...lets see that magical code I keep talking about!

I have the following public static strings:

1. FACEBOOK_APP
2. GOOGLE_PLUS_APP
3. TWITTER_APP
4. YOUTUBE_APP


Example:

FACEBOOK_APP equals "app.id.here"

(this way you dont have to worry about the social app id's)

Only 3 lines of codes gets you up & running!

1. must delare getActivity() OR activityName.this

2. boolean is to show toast message(if online/app not installed)

3. provide your own strings for the toast to use(if boolean is set to false you can set both strings as "" or leave them as is)


this is for facebook PAGE only! so do NOT use ID's for this one!
    
                        if(!openFacebookPage(getActivity(), "millercreativestudio", true, "not installed!", "no connection!")){
                        //app not installed...execute something here!
                        }
                        
this is for a facebook PROFILE only! it can accept number id's & "normal" user names!

                        if(!openFacebookProfile(getActivity(), "100004301467504", true, "not installed!", "no connection!")){
                        //app not installed...execute something here!
                        }
                        
this is for a twitter PROFILE only!

                        if(!openTwitterProfile(getActivity(), "xstar97", true, "not installed!", "no connection!")){
                        //app not installed...execute something here!
                        }
                        
this is for a Google Plus Community only!
                        
                        if(!openGooglePlusCommunity(getActivity(), "101286674025561115431", true, "not installed!", "no connection!")){
                        //app not installed...execute something here!
                        }

this is for a Google Plus PROFILE only!

                        if(!openGooglePlusProfile(getActivity(), "115214989786701484331", true, "not installed!", "no connection!")){                           //app not installed...execute something here!
                        }

this is for a YouTube Video only!

                        if(!openYouTubeVideo(getActivity(), "dQw4w9WgXcQ", true, "not installed!", "no connection!")){
                        //app not installed...execute something here!
                        }
                        
you may be asking what happens throughout the code...well this is what is going on:

1. checks for internet internet access
2. checks if the app is installed. 

If both return true then it launches the social media app with your page/profile/community/etc....however if any return false a toast message will show stating either no internet access or app not installed...
if the app is not installed then you can add a webview or offer to launch google play or something! in the false clause of the boolean!

###Dialogs!

   Create your own dialog and use the following: use this in the positive onClick if you are creating your own dialog
    
       rateApp(Context context);

    or

    Use my own custom dialog:
    
https://github.com/Xstar97/easySocial/blob/master/app/src/main/java/com/mcs/easysocialsample/RateDialog.java
   
1. add your own style
2. add your own title
3. add your own rate message
4. add your own no internet message
5. add your own positive onclick title
6. add your own negative onclick title
7. add your own neutral onclick title


       FragmentManager fm = MainActivity.this.getSupportFragmentManager();
                RateDialog rateDialog = RateDialog.newInstance(
                        R.style.AppCompatAlertDialogStyle,
                        "My title!",
                        "Please rate my app on google play!",
                        "no internet connection...bummer.",
                        "Okay",
                        "NO!",
                        "dismiss"
                );
                rateDialog.show(fm, "rateDialog!");
                
###Drawables (NEW FEATURE)
you can now easily grab a drawable from any app by using the following code:

getAppIcon(Context context, String pkgID, Drawable appNotInstalled);

the above code checks for the app is installed & grabs the app's icon for you to use!
However if the app is not installed you can display your own custom icon(its better than showing no image!)

###Booleans

    IsAppInstalled(Context context, "APP_ID_HERE");

    isEmpty(String s);
    isNotEmpty(String s);//redundant forgot to remove it
    containsDigit(String s);

###Strings

    appPackageName(Context context);
    intToString(int number);
    AppVersion(Context context, "APP_ID_HERE"); returns "1.0"
    AppVersionCode(Context context, "APP_ID_HERE"); returns 1

###Int

    stringToInt(String string);

###Others

    I also made the following static methods public too:
    
    //views
    //NOT void methods but actual snack, toast & progressDialog implementation! to use these declare them like this!

    private SnackBar sn;
    private Toast to;
    private ProgressDialog pd;

    sn = snackbar(View view, String string, int LENGTH);

    to = toast(Context context, String string, int LENGTH);

    pd = progressDialog(final Context context, int style, String message, boolean setIndeterminate, boolean setCancelable);


    why? well so you could use them better since now you can call:
    pd.show();
    pd.hide();
    pd.cancel();
    pd.dismiss();
    
    just like if you implemented yourself!
