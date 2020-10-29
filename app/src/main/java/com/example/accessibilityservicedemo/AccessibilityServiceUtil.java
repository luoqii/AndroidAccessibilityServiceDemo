package com.example.accessibilityservicedemo;

import android.view.accessibility.AccessibilityEvent;

public class AccessibilityServiceUtil {

    public String dump(AccessibilityEvent event){
        String str = "";

        return str;
    }

    public int allType(){
        return  0
                |AccessibilityEvent.TYPE_ANNOUNCEMENT
                |AccessibilityEvent.TYPE_ASSIST_READING_CONTEXT
                |AccessibilityEvent.TYPE_GESTURE_DETECTION_END
                |AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED
                |AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END
                |AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START
                |AccessibilityEvent.TYPE_TOUCH_INTERACTION_END
                |AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED
                |AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED
                |AccessibilityEvent.TYPE_VIEW_CLICKED
                |AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED
                |AccessibilityEvent.TYPE_VIEW_FOCUSED
                |AccessibilityEvent.TYPE_VIEW_HOVER_ENTER
                |AccessibilityEvent.TYPE_VIEW_HOVER_EXIT
                |AccessibilityEvent.TYPE_VIEW_LONG_CLICKED
                |AccessibilityEvent.TYPE_VIEW_SCROLLED
                |AccessibilityEvent.TYPE_VIEW_SELECTED
                |AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
                |AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED
                |AccessibilityEvent.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY
                |AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
                |AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
                |AccessibilityEvent.TYPE_WINDOWS_CHANGED;
    }
}
