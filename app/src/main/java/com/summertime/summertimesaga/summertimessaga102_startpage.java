package com.summertime.summertimesaga;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import static com.summertime.summertimesaga.summertimessaga102_splesh.url_passing;

import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;

public class summertimessaga102_startpage extends AppCompatActivity {
    ImageView start;
    
    NativeBannerAd nativeBannerAd;
    FrameLayout nativeBannerContainer;
    private SharedPreferences sharedPreferences;
    LinearLayout adView1, L1, L2;
    FrameLayout nativeAdContainer;
    FrameLayout frameLayout;
    NativeAd nativeAd1;
    InterstitialAd interstitialAd;

    public String TAG = String.valueOf(getClass());

    
    
    
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summertimessaga102_start_page);







        loadfbNativeAd();
        showfbNativeBanner();
        ShowFullAds();

        this.start = (ImageView) findViewById(R.id.start);


        findViewById(R.id.fl_adplaceholder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url_passing(summertimessaga102_startpage.this);

            }
        });
        findViewById(R.id.fl_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url_passing(summertimessaga102_startpage.this);

            }
        });


        this.start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                summertimessaga102_startpage.this.startActivity(new Intent(summertimessaga102_startpage.this, summertimessaga102_Next.class));


            }

        });


    }
    public void onBackPressed() {
        startActivity(new Intent(summertimessaga102_startpage.this, summertimessaga102_Exit.class));



    }
    public void loadfbNativeAd() {
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String nativeid = sharedPreferences.getString("nativeid", null);

        Log.e(TAG, "fbnative1 " + nativeid);
        nativeAdContainer = findViewById(R.id.fl_adplaceholder);
        LayoutInflater inflater = this.getLayoutInflater();
        adView1 = (LinearLayout) inflater.inflate(R.layout.summertimessaga102_native_ad_layout2, nativeAdContainer, false);
        nativeAdContainer.addView(adView1);
        nativeAd1 = new NativeAd(getApplicationContext(), nativeid);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e("fbnative1==>", "onMediaDownloaded: ");

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                //  nativeAdContainer.setVisibility(View.GONE);
                Log.e("fbnative1==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbnative1==>", "onAdLoaded: ");
                if (nativeAd1 == null || nativeAd1 != ad) {

                    return;
                }


                ImageView qreka = findViewById(R.id.qreka);
                qreka.setVisibility(View.GONE);
                inflateAd(nativeAd1, adView1, getApplicationContext());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbnative1==>", "onAdClicked: ");


            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbnative1==>", "onLoggingImpression: ");

            }
        };

        nativeAd1.loadAd(
                nativeAd1.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());


    }

    public void showfbNativeBanner() {
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String Bannerid = sharedPreferences.getString("Bannerid", null);
        View adView = NativeBannerAdView.render(this, summertimessaga102_splesh.nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
        nativeBannerContainer = (FrameLayout) findViewById(R.id.fl_b);
        // Add the Native Banner Ad View to your ad container
        nativeBannerContainer.addView(adView);

        nativeBannerAd = new NativeBannerAd(this, Bannerid);
        Log.e(TAG, "fbnativebanner1 " + Bannerid);
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
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String full = sharedPreferences.getString("full", null);
        Log.e(TAG, "fbfull2 " + full);
        try {
            if (summertimessaga102_splesh.interstitialAd1 != null && summertimessaga102_splesh.interstitialAd1.isAdLoaded()) {
                summertimessaga102_splesh.interstitialAd1.show();

            } else if (summertimessaga102_splesh.interstitialAd2 != null && summertimessaga102_splesh.interstitialAd2.isAdLoaded()) {
                summertimessaga102_splesh.interstitialAd2.show();
                summertimessaga102_splesh.interstitialAd1.loadAd();
            } else {

                summertimessaga102_splesh.interstitialAd1.loadAd();
                summertimessaga102_splesh.interstitialAd2.loadAd();
                interstitialAd = new InterstitialAd(this, full);
                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        // Interstitial dismissed callback
                        Log.e(TAG, "fbfull2 " + "Interstitial ad dismissed.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        // Ad error callback
                        Log.e(TAG, "fbfull2" + adError.getErrorMessage());

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d(TAG, "fbfull2 " + "Interstitial ad is loaded and ready to be diSplash_screenlayed!");
                        if (interstitialAd != null && interstitialAd.isAdLoaded())
                            interstitialAd.show();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        // Ad clicked callback
                        Log.d(TAG, "fbfull2 " + "Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        // Ad impression logged callback
                        Log.d(TAG, "fbfull2 " + "Interstitial ad impression logged!");
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
        url_passing(this);
    }



}