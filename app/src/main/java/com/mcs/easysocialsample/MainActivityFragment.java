package com.mcs.easysocialsample;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mcs.easysocial.RateDialog;
import com.rohit.recycleritemclicksupport.RecyclerItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.mcs.easysocial.EasyNetworkMod.isOnline;
import static com.mcs.easysocial.EasySocialAppMod.openFacebookPage;
import static com.mcs.easysocial.EasySocialAppMod.openFacebookProfile;
import static com.mcs.easysocial.EasySocialAppMod.openGooglePlusCommunity;
import static com.mcs.easysocial.EasySocialAppMod.openGooglePlusProfile;
import static com.mcs.easysocial.EasySocialAppMod.openTwitterProfile;
import static com.mcs.easysocial.EasySocialAppMod.openYouTubeVideo;
import static com.mcs.easysocial.EasyViewMod.progressDialog;
import static com.mcs.easysocial.RateDialog.DIALOG_ONCLICK_NEGATIVE;
import static com.mcs.easysocial.RateDialog.DIALOG_ONCLICK_NEUTRAL;
import static com.mcs.easysocial.RateDialog.DIALOG_ONCLICK_POSITIVE;

public class MainActivityFragment extends Fragment implements RateDialog.RateDialogListener {

    private Unbinder unbinder;
    private List<SocialApp> socialList = new ArrayList<>();
    private SocialAppAdapter socialdapter;
    private ProgressDialog mProgressDialog;

    @BindView(R.id.social_apps_list) RecyclerView social_apps_list;

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
                        }
                        break;

                    case 1:
                        if(!openFacebookProfile(getActivity(), "100004301467504", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        break;

                    case 2:
                        if(!openTwitterProfile(getActivity(), "xstar97", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        break;

                    case 3:
                        if(!openGooglePlusCommunity(getActivity(), "101286674025561115431", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        break;

                    case 4:
                        if(!openGooglePlusProfile(getActivity(), "", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        break;

                    case 5:
                        if(!openYouTubeVideo(getActivity(), "dQw4w9WgXcQ", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
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

    @Override
    public void handleRateDialogListener(String onClick) {

        if(onClick.equals(DIALOG_ONCLICK_POSITIVE)){
            Log.w("rateDialog: ", "positive button was clicked!");
        }
        else if(onClick.equals(DIALOG_ONCLICK_NEGATIVE)){
            Log.w("rateDialog: ", "negative button was clicked!");
        }
        else if(onClick.equals(DIALOG_ONCLICK_NEUTRAL)){
            Log.w("rateDialog: ", "neutral button was clicked!");
        }
    }

    private boolean isNetWorkAvailable(){
        return isOnline(getActivity());
    }

    private void socialappList(){
        socialList.clear();

        SocialApp social = new SocialApp("open Facebook Page");
        socialList.add(social);
        social = new SocialApp("open Facebook Profile");
        socialList.add(social);

        social = new SocialApp("open Twitter Profile");
        socialList.add(social);

        social = new SocialApp("open Google Plus Community");
        socialList.add(social);
        social = new SocialApp("open Google Plus profile");
        socialList.add(social);

        social = new SocialApp("open YouTube Video");
        socialList.add(social);

        social = new SocialApp("rate app");
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