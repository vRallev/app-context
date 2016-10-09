package net.vrallev.android.context;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * @author rwondratschek
 */
@RunWith(AndroidJUnit4.class)
public class AppContextTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void testScheduleAndCancel() {
        assertTrue(AppContext.get() != null);
    }
}
