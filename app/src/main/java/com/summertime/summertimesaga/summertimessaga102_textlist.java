package com.summertime.summertimesaga;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import static com.summertime.summertimesaga.summertimessaga102_splesh.inflateAd;

import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;


public class summertimessaga102_textlist extends AppCompatActivity {
    LinearLayout t1, t2, t3, t4, t5, t6;
    ImageView Ad1, Ad2, Ad3, Ad4, Ad5, Ad6;
    CardView A1;
    TextView A2, A3, A4, A6;
    FrameLayout A5;
    ScrollView SV1, SV2;
    ImageView imageView, imageView1, imageView2, imageView3, imageView4, imageView5;
    FrameLayout frameLayout;
    
    private com.facebook.ads.AdView bannerAdContainer;
    LinearLayout adView1;
    FrameLayout nativeAdContainer;
    NativeAd nativeAd1;
    InterstitialAd interstitialAd;
    public String TAG = String.valueOf(getClass());
    
    
    
    ProgressDialog progressDialog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summertimessaga102_activity_textlist);

        imageView = findViewById(R.id.youtube_player_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail1.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        imageView1 = findViewById(R.id.youtube_player_view_1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail2.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        imageView2 = findViewById(R.id.youtube_player_view_2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail3.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        imageView3 = findViewById(R.id.youtube_player_view_3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail4.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        imageView4 = findViewById(R.id.youtube_player_view_4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail5.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        imageView5 = findViewById(R.id.youtube_player_view_5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail6.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        
        summertimessaga102_splesh.url_passing(summertimessaga102_textlist.this);
        summertimessaga102_splesh.url_passing1(summertimessaga102_textlist.this);


        loadfbNativeAd();
        showfbbanner();
        showfbbanner1();
        showfbbanner2();
        showfbbanner3();
        showfbbanner4();
        showfbbanner5();

        ShowFullAds();

        findViewById(R.id.fl_adplaceholder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                summertimessaga102_splesh.url_passing(summertimessaga102_textlist.this);
                summertimessaga102_splesh.url_passing1(summertimessaga102_textlist.this);

            }
        });

        findViewById(R.id.fl_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                summertimessaga102_splesh.url_passing(summertimessaga102_textlist.this);
                summertimessaga102_splesh.url_passing1(summertimessaga102_textlist.this);

            }
        });






        t1 = findViewById(R.id.img1);
        t1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail1.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        t2 = findViewById(R.id.img2);
        t2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail2.class);
                summertimessaga102_textlist.this.startActivity(intent);
            }


        });
        t3 = findViewById(R.id.img3);
        t3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail3.class);

                summertimessaga102_textlist.this.startActivity(intent);
            }

        });
        t4 = findViewById(R.id.img4);
        t4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail4.class);

                summertimessaga102_textlist.this.startActivity(intent);
            }

        });
        t5 = findViewById(R.id.img5);
        t5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail5.class);

                summertimessaga102_textlist.this.startActivity(intent);
            }

        });

        t6 = findViewById(R.id.img6);
        t6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(summertimessaga102_textlist.this.getApplicationContext(), summertimessaga102_detail6.class);

                summertimessaga102_textlist.this.startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        summertimessaga102_splesh.url_passing(summertimessaga102_textlist.this);
        summertimessaga102_splesh.url_passing1(summertimessaga102_textlist.this);
        ShowFullAds();
    }


    

    public void loadfbNativeAd() {

        Log.e(TAG, "fbnative5 " + getString(R.string.fbnative));
        nativeAdContainer = findViewById(R.id.fl_adplaceholder);
        LayoutInflater inflater = this.getLayoutInflater();
        adView1 = (LinearLayout) inflater.inflate(R.layout.summertimessaga102_native_ad_layout3, nativeAdContainer, false);
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

    private void showfbbanner() {
        Log.e(TAG, "fbban5 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban5==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban5==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban5==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }
    private void showfbbanner1() {
        Log.e(TAG, "fbban5 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b1);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban5==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban5==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban5==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }
    private void showfbbanner2() {
        Log.e(TAG, "fbban5 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b2);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban5==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban5==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban5==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }
    private void showfbbanner3() {
        Log.e(TAG, "fbban5 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b3);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban5==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban5==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban5==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }
    private void showfbbanner4() {
        Log.e(TAG, "fbban5 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b4);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban5==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban5==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban5==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }
    private void showfbbanner5() {
        Log.e(TAG, "fbban5 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b5);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban5==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban5==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban5==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
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






















