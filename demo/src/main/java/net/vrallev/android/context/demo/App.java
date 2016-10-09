package net.vrallev.android.context.demo;

import android.app.Application;
import android.content.Context;

import net.vrallev.android.context.AppContext;

/**
 * @author rwondratschek
 */
@SuppressWarnings("ConstantConditions")
public class App extends Application {

    public static void assertNotNull() {
        if (AppContext.get() == null) {
            throw new IllegalStateException();
        }
    }

    public App() {
        Context context = AppContext.get();
        assert context == null; // constructor didn't finish, must be null
    }

    @Override
    public void onCreate() {
        assertNotNull();
        super.onCreate();
    }
}
