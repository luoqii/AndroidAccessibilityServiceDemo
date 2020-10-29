package com.example.accessibilityservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openAccessibilityServiceSetting(this);
//        openAccessibilityServiceDetailSetting(this);
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
}