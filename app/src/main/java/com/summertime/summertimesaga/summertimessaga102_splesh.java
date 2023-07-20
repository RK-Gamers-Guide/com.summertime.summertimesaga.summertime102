package com.summertime.summertimesaga;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class summertimessaga102_splesh extends AppCompatActivity {

    public String Splash = String.valueOf(getClass());
    public String TAG = String.valueOf(getClass());
    public static InterstitialAd interstitialAd1;
    public static NativeBannerAd nativeBannerAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summertimessaga102_activity_splash);
        loadFullscreenad();
        loadNativeBanner();
        NextScreen();
        datafromlink();

    }


    private void NextScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                summertimessaga102_splesh.this.startActivity(new Intent(summertimessaga102_splesh.this, summertimessaga102_page.class));

            }
        }, 5000);
    }


    public void loadFullscreenad() {
        interstitialAd1 = new com.facebook.ads.InterstitialAd(this, getString(R.string.fbfull));
        Log.e(TAG, "fbfull1 " + getString(R.string.fbfull));
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.e("1", "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.e(Splash, "Interstitial ad dismissed.");
                interstitialAd1.loadAd();
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e(Splash, "fbfull 1 " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d(Splash, "Interstitial ad is loaded and ready to be displayed!");

            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d(Splash, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d(Splash, "Interstitial ad impression logged!");
            }

        };
        interstitialAd1.loadAd(
                interstitialAd1.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
///////////////


    }

    public void loadNativeBanner() {
        nativeBannerAd = new NativeBannerAd(this, getString(R.string.fbnativeban));
        Log.e(TAG, "fbnativebanner16 " + getString(R.string.fbnativeban));
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e(Splash, "fbnativebanner 16 " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e(Splash, "Native ad is loaded and ready to be displayed!");
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

    void datafromlink(){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                String dataUrl = "https://adstxt.dev/69a34d0834/ads.txt";

                try {
                    URL url = new URL(dataUrl);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuilder buffer = new StringBuilder();

                    if (inputStream == null) {
                        return null;
                    }

                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        buffer.append(line).append("\n");
                    }

                    if (buffer.length() == 0) {
                        return null;
                    }

                    return buffer.toString();
                } catch (IOException e) {
                    Log.e(TAG, "Error ", e);
                    return null;
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e(TAG, "Error closing stream", e);
                        }
                    }
                }
            }

            @Override
            protected void onPostExecute(String data) {
                super.onPostExecute(data);

                if (data != null) {
                    char secondcharacter = data.charAt(1);
                    char thirdCharacter = data.charAt(2);
                    String customUrl = data.substring(3, data.length() - 14);
                    Log.d(TAG, "Custom URL: " + customUrl);
                    saveDataToSharedPreferences1(customUrl);

                    saveDataToSharedPreferences2(String.valueOf(secondcharacter));



                    if (thirdCharacter == '1') {
                        // Perform actions for 'if' condition
                        Log.d(TAG, "Third character is '1'");

                        saveDataToSharedPreferences(String.valueOf(thirdCharacter));
                    } else {
                        // Perform actions for 'else' condition
                        Log.d(TAG, "Third character is not '1'");
                    }

                }
                else {

                }
            }
        }.execute();
    }

    public static void inflateAd(NativeAd nativeAd, View adView, final Context context) {
        MediaView nativeAdIcon = (MediaView) adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = (TextView) adView.findViewById(R.id.native_ad_title);
        TextView nativeAdBody = (TextView) adView.findViewById(R.id.native_ad_body);
        MediaView nativeAdMedia = (MediaView) adView.findViewById(R.id.native_ad_media);
        TextView sponsoredLabel = (TextView) adView.findViewById(R.id.native_ad_sponsored_label);

        nativeAdMedia.setListener(new MediaViewListener() {
            @Override
            public void onVolumeChange(MediaView mediaView, float volume) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: Volume " + volume);
            }

            @Override
            public void onPause(MediaView mediaView) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: Paused");
            }

            @Override
            public void onPlay(MediaView mediaView) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: Play");
            }

            @Override
            public void onFullscreenBackground(MediaView mediaView) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: FullscreenBackground");
            }

            @Override
            public void onFullscreenForeground(MediaView mediaView) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: FullscreenForeground");
            }

            @Override
            public void onExitFullscreen(MediaView mediaView) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: ExitFullscreen");
            }

            @Override
            public void onEnterFullscreen(MediaView mediaView) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: EnterFullscreen");
            }

            @Override
            public void onComplete(MediaView mediaView) {
                Log.e(summertimessaga102_detail1.class.toString(), "MediaViewEvent: Completed");
            }
        });

        TextView nativeAdSocialContext = (TextView) adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdCallToAction = (TextView) adView.findViewById(R.id.native_ad_call_to_action);
        LinearLayout L1 = (LinearLayout) adView.findViewById(R.id.L1);
        L1.setVisibility(View.VISIBLE);

        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        List< View > clickableViews = new ArrayList<>();
        
        clickableViews.add(L1);
        clickableViews.add(nativeAdCallToAction);
        nativeAd.registerViewForInteraction(adView, nativeAdMedia, nativeAdIcon, clickableViews);

        NativeAdBase.NativeComponentTag.tagView(nativeAdIcon, NativeAdBase.NativeComponentTag.AD_ICON);
        NativeAdBase.NativeComponentTag.tagView(nativeAdTitle, NativeAdBase.NativeComponentTag.AD_TITLE);
        NativeAdBase.NativeComponentTag.tagView(nativeAdBody, NativeAdBase.NativeComponentTag.AD_BODY);
        NativeAdBase.NativeComponentTag.tagView(nativeAdSocialContext, NativeAdBase.NativeComponentTag.AD_SOCIAL_CONTEXT);
        NativeAdBase.NativeComponentTag.tagView(nativeAdCallToAction, NativeAdBase.NativeComponentTag.AD_CALL_TO_ACTION);
    }

    private void saveDataToSharedPreferences2(String secondcharacter) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("secondcharacter", secondcharacter);
        editor.apply();
    }
    private void saveDataToSharedPreferences(String thirdCharacter) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("data", thirdCharacter);
        editor.apply();
    }

    private void saveDataToSharedPreferences1(String customUrl) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("data1", customUrl);
        editor.apply();


    }

    public static void url_passing(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedData = sharedPreferences.getString("secondcharacter", null);
        if (savedData != null && savedData.charAt(0) == '1') {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Bundle bundle = new Bundle();
            bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            intent.putExtras(bundle);
            intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, true);
            intent.setPackage("com.android.chrome");
            intent.setData(Uri.parse("https://play2062.atmegame.com/"));
            context.startActivity(intent, null);
        }
    }

    public static void url_passing1(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedData = sharedPreferences.getString("secondcharacter", null);
        if (savedData != null && savedData.charAt(0) == '1') {
            Intent intent = new Intent("android.intent.action.VIEW");
            Bundle bundle = new Bundle();
            bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            intent.putExtras(bundle);
            intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, true);
            intent.setPackage("com.android.chrome");
            intent.setData(Uri.parse("https://play2062.atmequiz.com/"));
            context.startActivity(intent, (Bundle) null);

        }
    }
}