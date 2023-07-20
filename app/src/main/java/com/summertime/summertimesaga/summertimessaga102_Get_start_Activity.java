package com.summertime.summertimesaga;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import static com.summertime.summertimesaga.summertimessaga102_splesh.inflateAd;

import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;

public class summertimessaga102_Get_start_Activity extends AppCompatActivity {
    
    NativeBannerAd nativeBannerAd;
    FrameLayout nativeBannerContainer;
    LinearLayout adView1;
    FrameLayout nativeAdContainer;
    NativeAd nativeAd1;
    InterstitialAd interstitialAd;
    ProgressDialog progressDialog;
    public String TAG = String.valueOf(getClass());
    
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summertimessaga102_get_start);

        summertimessaga102_splesh.url_passing(summertimessaga102_Get_start_Activity.this);
        summertimessaga102_splesh.url_passing1(summertimessaga102_Get_start_Activity.this);

        findViewById(R.id.fl_adplaceholder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                summertimessaga102_splesh.url_passing(summertimessaga102_Get_start_Activity.this);
                summertimessaga102_splesh.url_passing1(summertimessaga102_Get_start_Activity.this);

            }
        });
        findViewById(R.id.fl_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                summertimessaga102_splesh.url_passing(summertimessaga102_Get_start_Activity.this);
                summertimessaga102_splesh.url_passing1(summertimessaga102_Get_start_Activity.this);

            }
        });





        loadfbNativeAd();
        showfbNativeBanner();
        ShowFullAds();


        ((ImageView) findViewById(R.id.letPlay1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent i = new Intent(summertimessaga102_Get_start_Activity.this, summertimessaga102_MainActivity2.class);
                startActivity(i);
            }

        });

        ((ImageView) findViewById(R.id.share)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                                try {
                                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                                    shareIntent.setType("text/plain");
                                    String shareMessage = getString(R.string.app_name);
                                    shareMessage = shareMessage + "   ";
                                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getPackageName();
                                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                                } catch (Exception e) {
                                }
                            }

        });

        ((ImageView) findViewById(R.id.rate)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(myAppLinkToMarket);
                } catch (ActivityNotFoundException e) {
                }



            }
        });

        /*((ImageView) findViewById(R.id.More)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Dialog dialog = new Dialog(proboofficial_Get_start_Activity.this);
                dialog.setContentView(R.layout.proboofficial_ad_progress_dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        new CountDownTimer(1500, 500) {

                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                dialog.dismiss();
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Probo+Official"));
                                startActivity(intent);
                            }
                        }.start();
                    }
                });
                dialog.show();


            }
        });*/


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        summertimessaga102_splesh.url_passing(summertimessaga102_Get_start_Activity.this);
        summertimessaga102_splesh.url_passing1(summertimessaga102_Get_start_Activity.this);


        ShowFullAds();
    }

    

    public void loadfbNativeAd() {

        Log.e(TAG, "fbnative5 " + getString(R.string.fbnative));
        nativeAdContainer = findViewById(R.id.fl_adplaceholder);
        LayoutInflater inflater = this.getLayoutInflater();
        adView1 = (LinearLayout) inflater.inflate(R.layout.summertimessaga102_native_ad_layout2, nativeAdContainer, false);
        nativeAdContainer.addView(adView1);
        nativeAd1 = new NativeAd(getApplicationContext(), getString(R.string.fbnative));
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e("fbnative5==>", "onMediaDownloaded: ");

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                //  nativeAdContainer.setVisibility(View.GONE);
                Log.e("fbnative5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbnative5==>", "onAdLoaded: ");
                if (nativeAd1 == null || nativeAd1 != ad) {

                    return;
                }
                ImageView Qreka;
                Qreka = findViewById(R.id.qreka);
                Qreka.setVisibility(View.GONE);
                inflateAd(nativeAd1, adView1, getApplicationContext());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbnative5==>", "onAdClicked: ");


            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbnative5==>", "onLoggingImpression: ");

            }
        };

        nativeAd1.loadAd(
                nativeAd1.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());


    }

    public void showfbNativeBanner() {
        View adView = NativeBannerAdView.render(this, summertimessaga102_splesh.nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
        nativeBannerContainer = (FrameLayout) findViewById(R.id.fl_b);
        // Add the Native Banner Ad View to your ad container
        nativeBannerContainer.addView(adView);

        nativeBannerAd = new NativeBannerAd(this, getString(R.string.fbnativeban));
        Log.e(TAG, "fbnativebanner1 " + getString(R.string.fbnativeban));
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "fbnativebanner 1 " + adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "Native ad is loaded and ready to be displayed!");
                View adView = NativeBannerAdView.render(getApplicationContext(), nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
                nativeBannerContainer.addView(adView);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };
        nativeBannerAd.loadAd(
                nativeBannerAd.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }

    public void ShowFullAds() {
        Log.e(TAG, "fbfull5 " + getString(R.string.fbfull));
        try {
            if (summertimessaga102_splesh.interstitialAd1 != null && summertimessaga102_splesh.interstitialAd1.isAdLoaded())
                summertimessaga102_splesh.interstitialAd1.show();
            else {
                if (!summertimessaga102_splesh.interstitialAd1.isAdLoaded())
                    summertimessaga102_splesh.interstitialAd1.loadAd();

                interstitialAd = new InterstitialAd(this, getString(R.string.fbfull));
                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        // Interstitial dismissed callback
                        Log.e(TAG, "fbfull5 " + "Interstitial ad dismissed.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        // Ad error callback
                        Log.e(TAG, "fbfull5" + adError.getErrorMessage());

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d(TAG, "fbfull5 " + "Interstitial ad is loaded and ready to be diSplash_screenlayed!");
                        if (interstitialAd != null && interstitialAd.isAdLoaded())
                            interstitialAd.show();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        // Ad clicked callback
                        Log.d(TAG, "fbfull5 " + "Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        // Ad impression logged callback
                        Log.d(TAG, "fbfull5 " + "Interstitial ad impression logged!");
                    }
                };

                interstitialAd.loadAd(
                        interstitialAd.buildLoadAdConfig()
                                .withAdListener(interstitialAdListener)
                                .build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}