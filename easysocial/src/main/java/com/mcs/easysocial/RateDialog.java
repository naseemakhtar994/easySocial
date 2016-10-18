package com.mcs.easysocial;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import static com.mcs.easysocial.EasyNetworkMod.isOnline;

public class RateDialog extends DialogFragment
{
    public static String DIALOG_ONCLICK_POSITIVE = "positive";
    public static String DIALOG_ONCLICK_NEGATIVE = "negative";
    public static String DIALOG_ONCLICK_NEUTRAL = "neutral";
    public RateDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    public interface MyRateDialogListener {
        void handleDialogListener(String onCLick);
    }

    public static RateDialog newInstance(int style, String title, String rate_message,  String no_internet, String Positive_Button, String Negative_Button, String Neutral_Button) {
        RateDialog frag = new RateDialog();
        Bundle args = new Bundle();
        args.putInt("style", style);
        args.putString("title", title);
        args.putString("rate_message", rate_message);
        args.putString("no_internet_message", no_internet);
        args.putString("positive_button", Positive_Button);
        args.putString("negative_button", Negative_Button);
        args.putString("neutral_button", Neutral_Button);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public @NonNull
    Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), myStyle());
        setCancelable(false);
        builder.setTitle(myTitle());
        if(isNetWorkAvailable()) {
            builder.setMessage(myPosMSG());
            builder.setPositiveButton(myPosAction(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final String appPackageName = app();

                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                    MyRateDialogListener listener = (MyRateDialogListener) getActivity();
                    listener.handleDialogListener(DIALOG_ONCLICK_POSITIVE);
                }
            });
            builder.setNegativeButton(myNegAction(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MyRateDialogListener listener = (MyRateDialogListener) getActivity();
                    listener.handleDialogListener(DIALOG_ONCLICK_NEGATIVE);
                }
            });
        }
        else{
            builder.setMessage(myNegMSG());
        }
        builder.setNeutralButton(myNueAction(),  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyRateDialogListener listener = (MyRateDialogListener) getActivity();
                listener.handleDialogListener(DIALOG_ONCLICK_NEUTRAL);
                dialog.dismiss();

            }
        });
        return builder.create();
    }
    private String app(){
        return getActivity().getApplicationContext().getPackageName();
    }
    private int myStyle(){
        return getArguments().getInt("style");
    }
    private String myTitle(){
        return getArguments().getString("title");
    }
    private String myPosMSG(){
        return getArguments().getString("rate_message");
    }
    private String myNegMSG(){
        return getArguments().getString("no_internet_message");
    }
    private String myPosAction(){
        return getArguments().getString("positive_button");
    }
    private String myNegAction(){
        return getArguments().getString("negative_button");
    }
    private String myNueAction(){
        return getArguments().getString("neutral_button");
    }
    private boolean isNetWorkAvailable(){
        return isOnline(getActivity());
    }
}