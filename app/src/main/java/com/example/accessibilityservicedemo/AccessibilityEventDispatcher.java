package com.example.accessibilityservicedemo;

import android.view.accessibility.AccessibilityEvent;

import org.bbs.android.log.Log;

import java.util.ArrayList;
import java.util.List;

public class AccessibilityEventDispatcher {

    private static final String TAG = AccessibilityEventDispatcher.class.getSimpleName();
    private static AccessibilityEventDispatcher sInstance = new AccessibilityEventDispatcher();
    private List<EventListener> mCallbacks;

    public static AccessibilityEventDispatcher getInstance() {
        return sInstance;
    }

    private AccessibilityEventDispatcher(){
        mCallbacks = new ArrayList<>();
    }

    public void dispatchAccessibilityEvent(AccessibilityEvent event){
        Log.d(TAG, "dispatchAccessibilityEvent event:" + event);
        // todo
        List<EventListener> copy = mCallbacks;

        for (EventListener l : copy) {
            l.onAccessibilityEvent(event);
        }
    }

    public void addEventListener(EventListener listener) {
        Log.d(TAG, "addEventListener listener:" + listener);
        if (!mCallbacks.contains(listener)) {
            mCallbacks.add(listener);
        }
    }

    public void removeEventListener(EventListener listener) {
        Log.d(TAG, "removeEventListener listener:" + listener);
        mCallbacks.remove(listener);
    }

    interface EventListener{
        void onAccessibilityEvent(AccessibilityEvent event);
    }

}
