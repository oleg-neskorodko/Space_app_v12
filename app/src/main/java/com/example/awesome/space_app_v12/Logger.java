package com.example.awesome.space_app_v12;

import android.util.Log;

public class Logger {
    /**
     * Log debug level
     *
     * @param tag
     * @param log - message
     */
    public static void d(String tag, String log) {
        Log.d(tag, log);
    }

    /**
     * Log error level
     *
     * @param tag
     * @param log - message (method name)
     * @param e   - throwable (exception)
     */
    public static void error(String tag, String log, Throwable e) {
        Log.e(tag, log + ": " + e.toString());
    }

    /**
     * Log error level
     *
     * @param tag
     * @param error - message error
     */
    public static void error(String tag, String error) {
        Log.e(tag, error);
    }
}