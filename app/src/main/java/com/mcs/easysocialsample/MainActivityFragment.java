package com.mcs.easysocialsample;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.sax.RootElement;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.rohit.recycleritemclicksupport.RecyclerItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.mcs.easysocial.EasyAppMod.AppVersion;
import static com.mcs.easysocial.EasyAppMod.AppVersionCode;
import static com.mcs.easysocial.EasyAppMod.FACEBOOK_APP;
import static com.mcs.easysocial.EasyAppMod.GOOGLE_PLUS_APP;
import static com.mcs.easysocial.EasyAppMod.IfAppIsInstalled;
import static com.mcs.easysocial.EasyAppMod.TWITTER_APP;
import static com.mcs.easysocial.EasyAppMod.YOUTUBE_APP;
import static com.mcs.easysocial.EasyAppMod.appPackageName;
import static com.mcs.easysocial.EasyAppMod.getAppIcon;
import static com.mcs.easysocial.EasyNetworkMod.isOnline;
import static com.mcs.easysocial.EasySocialAppMod.openFacebookPage;
import static com.mcs.easysocial.EasySocialAppMod.openFacebookProfile;
import static com.mcs.easysocial.EasySocialAppMod.openGooglePlusCommunity;
import static com.mcs.easysocial.EasySocialAppMod.openGooglePlusProfile;
import static com.mcs.easysocial.EasySocialAppMod.openTwitterProfile;
import static com.mcs.easysocial.EasySocialAppMod.openYouTubeVideo;
import static com.mcs.easysocial.EasyViewMod.progressDialog;

public class MainActivityFragment extends Fragment {

    private Unbinder unbinder;
    private List<SocialApp> socialList = new ArrayList<>();
    private SocialAppAdapter socialdapter;
    private ProgressDialog mProgressDialog;

    @BindView(R.id.social_apps_list) RecyclerView social_apps_list;
    @BindDrawable(R.drawable.ic_facebook) Drawable Social_Facebook;
    @BindDrawable(R.drawable.ic_twitter) Drawable Social_Twitter;
    @BindDrawable(R.drawable.ic_google_plus) Drawable Social_Google_Plus;
    @BindDrawable(R.drawable.ic_youtube) Drawable Social_YouTube;
    @BindDrawable(R.drawable.ic_review) Drawable Social_Rate;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mProgressDialog = progressDialog(getActivity(), ProgressDialog.STYLE_SPINNER, "loading", true, true);

        socialdapter = new SocialAppAdapter(getActivity(), socialList);
        social_apps_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        social_apps_list.setItemAnimator(new DefaultItemAnimator());
        social_apps_list.setAdapter(socialdapter);
        socialappList();

        RecyclerItemClickSupport.addTo(social_apps_list).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView socialRV, int pos, View v) {
                mProgressDialog.show();
                switch (pos) {
                    case  0:

                        if(!openFacebookPage(getActivity(), "millercreativestudio", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                            FragmentManager fmWV = getActivity().getSupportFragmentManager();
                            WebViewDialog wvDialog = WebViewDialog.newInstance(
                                    "https://www.facebook.com/" + "millercreativestudio"
                            );
                            wvDialog.show(fmWV, "WVDialog!");
                        }
                        break;

                    case 1:
                        if(!openFacebookProfile(getActivity(), "100004301467504", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                            FragmentManager fmWV = getActivity().getSupportFragmentManager();
                            WebViewDialog wvDialog = WebViewDialog.newInstance(
                                    "https://www.facebook.com/profile.php?id=" + "100004301467504"
                            );
                            wvDialog.show(fmWV, "WVDialog!");
                        }
                        break;

                    case 2:
                        if(!openTwitterProfile(getActivity(), "xstar97", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                            FragmentManager fmWV = getActivity().getSupportFragmentManager();
                            WebViewDialog wvDialog = WebViewDialog.newInstance(
                                    "https://www.twitter.com/" + "xstar97"
                            );
                            wvDialog.show(fmWV, "WVDialog!");
                        }
                        break;

                    case 3:
                        if(!openGooglePlusCommunity(getActivity(), "101286674025561115431", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                            FragmentManager fmWV = getActivity().getSupportFragmentManager();
                            WebViewDialog wvDialog = WebViewDialog.newInstance(
                                    "https://plus.google.com/communities/" + "101286674025561115431"
                            );
                            wvDialog.show(fmWV, "WVDialog!");
                        }
                        break;

                    case 4:
                        if(!openGooglePlusProfile(getActivity(), "103894001615704696473", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                            FragmentManager fmWV = getActivity().getSupportFragmentManager();
                            WebViewDialog wvDialog = WebViewDialog.newInstance(
                                    "https://plus.google.com/" + "103894001615704696473"
                            );
                            wvDialog.show(fmWV, "WVDialog!");
                        }
                        break;

                    case 5:
                        if(!openYouTubeVideo(getActivity(), "dQw4w9WgXcQ", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                            FragmentManager fmWV = getActivity().getSupportFragmentManager();
                            WebViewDialog wvDialog = WebViewDialog.newInstance(
                                    "https://www.youtube.com/watch?v=" + "dQw4w9WgXcQ"
                            );
                            wvDialog.show(fmWV, "WVDialog!");
                        }
                        break;

                    case 6:
                        FragmentManager fm = getActivity().getSupportFragmentManager();
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
                        break;

                    default:
                        break;
                }
                mProgressDialog.hide();
            }
        });

    }
    private String MY_APP_NAME(){
        return appPackageName(getActivity());
    }
    private boolean isNetWorkAvailable(){
        return isOnline(getActivity());
    }
    private Drawable socialIcon(String appId, Drawable appNotInstalled){
        return getAppIcon(getActivity(), appId, appNotInstalled);
    }
    private boolean isInstalled(String app){
        return IfAppIsInstalled(getActivity(), app);
    }
    private String Version(String app){
        if(isInstalled(app))
        {
            return "version: "+ AppVersion(getActivity(), app) + "(" + AppVersionCode(getActivity(), app) + ")";
        }
        else
        {
            return "version not available!";
        }
    }

    private void socialappList(){
        socialList.clear();

        SocialApp social = new SocialApp(socialIcon(FACEBOOK_APP, Social_Facebook), "Facebook Page", "installed: " + isInstalled(FACEBOOK_APP), Version(FACEBOOK_APP));
        socialList.add(social);
        social = new SocialApp(socialIcon(FACEBOOK_APP, Social_Facebook), "facebook Profile", "installed: " + isInstalled(FACEBOOK_APP), Version(FACEBOOK_APP));
        socialList.add(social);

        social = new SocialApp(socialIcon(TWITTER_APP, Social_Twitter), "Twitter Profile", "installed: " + isInstalled(TWITTER_APP), Version(TWITTER_APP));
        socialList.add(social);

        social = new SocialApp(socialIcon(GOOGLE_PLUS_APP, Social_Google_Plus), "Google+ Community", "installed: " + isInstalled(GOOGLE_PLUS_APP), Version(GOOGLE_PLUS_APP));
        socialList.add(social);
        social = new SocialApp(socialIcon(GOOGLE_PLUS_APP, Social_Google_Plus), "Google+ profile", "installed: " + isInstalled(GOOGLE_PLUS_APP), Version(GOOGLE_PLUS_APP));
        socialList.add(social);

        social = new SocialApp(socialIcon(YOUTUBE_APP, Social_YouTube), "YouTube Video", "installed: " + isInstalled(YOUTUBE_APP), Version(YOUTUBE_APP));
        socialList.add(social);

        social = new SocialApp(Social_Rate, "rate app", "installed: " + isInstalled(MY_APP_NAME()) + " (DUH!)", Version(MY_APP_NAME()));
        socialList.add(social);

        socialdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();

        if(mProgressDialog != null){
            mProgressDialog.hide();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}