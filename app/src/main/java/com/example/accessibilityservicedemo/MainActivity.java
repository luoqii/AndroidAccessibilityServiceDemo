package com.example.accessibilityservicedemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        openAccessibilityServiceSetting(this);
//        openAccessibilityServiceDetailSetting(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotiChannel();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void createNotiChannel() {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = MyAccessibilityService.CHANNEL_ID;
        CharSequence channelName = "channel name";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        notificationManager.createNotificationChannel(notificationChannel);
    }

    void openAccessibilityServiceSetting(Activity act){
        Intent settingsIntent = new Intent(
                Settings.ACTION_ACCESSIBILITY_SETTINGS);
        act.startActivity(settingsIntent);
    }

    void openAccessibilityServiceDetailSetting(Activity act){
        ComponentName component = new ComponentName(act, MyAccessibilityService.class);
        Intent settingsIntent = new Intent(
                AccessibilityServiceUtil.ACTION_ACCESSIBILITY_DETAILS_SETTINGS);
        settingsIntent.putExtra(AccessibilityServiceUtil.EXTRA_COMPONENT_NAME, component);
        act.startActivity(settingsIntent);
    }

    public void enable_access(View view) {
        openAccessibilityServiceSetting(this);
    }

    public void nrf(View view) {
        startActivity(new Intent(this, nRfConnectActivity.class));
    }
}