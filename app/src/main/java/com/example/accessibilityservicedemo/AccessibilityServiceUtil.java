package com.example.accessibilityservicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

public class AccessibilityServiceUtil {
    /**
     * Activity Action: Show detail settings of a particular accessibility service.
     * <p>
     * In some cases, a matching Activity may not exist, so ensure you safeguard against this.
     * <p>
     * Input: {@link Intent#EXTRA_COMPONENT_NAME} must specify the accessibility service component
     * name to be shown.
     * <p>
     * Output: Nothing.
     * @hide
     **/
    public static final String ACTION_ACCESSIBILITY_DETAILS_SETTINGS =
            "android.settings.ACCESSIBILITY_DETAILS_SETTINGS";

    /**
     * Intent extra: A {@link ComponentName} value.
     * <p>
     * Type: String
     * </p>
     */
    public static final String EXTRA_COMPONENT_NAME = "android.intent.extra.COMPONENT_NAME";

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

    public static void dump_TYPE_WINDOW_STATE_CHANGED(StringBuilder builder, AccessibilityEvent event){
        dump_CommonType(builder, event);
        builder.append("\n");
        int recordCount =  event.getRecordCount();
        for (int i = 0; i < recordCount; i++) {
            AccessibilityRecord record = event.getRecord(i);
            builder.append("\n");
            builder.append("#" + i );
            builder.append("\n");
            builder.append("text:" + record.getText());
        }
    }

    public static void dump_TYPE_WINDOW_CONTENT_CHANGED(StringBuilder builder, AccessibilityEvent event){
        dump_CommonType(builder, event);
        int recordCount =  event.getRecordCount();
        for (int i = 0; i < recordCount; i++) {
            AccessibilityRecord record = event.getRecord(i);
            builder.append("\n");
            builder.append("#" + i );
            builder.append("\n");
            builder.append("source:" + record.getSource());
            builder.append("\n");
            builder.append("className:" + record.getClassName());
            builder.append("\n");
            builder.append("text:" + record.getText());
            builder.append("\n");
            builder.append("fromIndex:" + record.getFromIndex());
            builder.append("\n");
            builder.append("toIndex:" + record.getToIndex());
        }
    }

    public static void dump_TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY(StringBuilder builder, AccessibilityEvent event){
        dump_CommonType(builder, event);
        builder.append("granularity:" + event.getMovementGranularity());
    }

    public static void dump_CommonType(StringBuilder builder, AccessibilityEvent event){
        builder.append("\n");
        builder.append("eventType:" + event.getEventType());
        builder.append("\n");
        builder.append("packageName:" + event.getPackageName());
        builder.append("\n");
        builder.append("eventTime:" + event.getEventTime());
        int recordCount =  event.getRecordCount();
        for (int i = 0; i < recordCount; i++) {
            AccessibilityRecord record = event.getRecord(i);
            builder.append("\n");
            builder.append("#" + i );
            builder.append("\n");
            builder.append("source:" + record.getSource());
            builder.append("\n");
            builder.append("className:" + record.getClassName());
        }
    }
}
