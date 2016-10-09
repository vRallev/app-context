package net.vrallev.android.context;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author rwondratschek
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class AppContext {

    private static final String TAG = "AppContext";

    @SuppressLint("StaticFieldLeak")
    private static volatile Application application;

    /**
     * @return The global application context.
     */
    @NonNull
    public static Context get() {
        return getApplication();
    }

    /**
     * @return The global application object.
     */
    @NonNull
    public static Application getApplication() {
        if (application == null) {
            synchronized (AppContext.class) {
                if (application == null) {
                    initApplication();
                }
            }
        }
        return application;
    }

    private static void initApplication() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            // getInitialApplication only works on the main thread

            final CountDownLatch latch = new CountDownLatch(1); // safe to block background thread

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    initApplication();
                    latch.countDown();
                }
            });

            try {
                latch.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Log.e(TAG, "Interruption", e);
            }

            return;
        }

        try {
            Method method = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication");
            application = (Application) method.invoke(null);
        } catch (Exception e) {
            Log.e(TAG, "Loading the application failed terribly", e);
        }
    }

    /**
     * Manually set the application object. That's usually not necessary.
     *
     * @param context Any context.
     */
    public static void setApplication(@NonNull Context context) {
        AppContext.application = (Application) context.getApplicationContext();
    }

    private AppContext() {
        // no op
    }
}
