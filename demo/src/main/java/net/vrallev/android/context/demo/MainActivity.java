package net.vrallev.android.context.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import net.vrallev.android.context.AppContext;

/**
 * @author rwondratschek
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this, AppContext.get().toString(), Toast.LENGTH_SHORT).show();
    }
}
