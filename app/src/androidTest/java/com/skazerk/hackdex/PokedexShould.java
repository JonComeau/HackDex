package com.skazerk.hackdex;

import android.os.SystemClock;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class PokedexShould {

    @Rule
    public ActivityTestRule<Main> mActivityRule = new ActivityTestRule<>(Main.class);

    @Test
    public void haveNimbleafTabs() throws Exception {
        SystemClock.sleep(100);
        onView(withText("Nimbleaf")).perform(click());
        onView(withId(R.id.poke_name)).check(matches(withText("Nimbleaf")));
        SystemClock.sleep(100);
        onView(withText("Moves")).perform(click());
        SystemClock.sleep(100);
        onView(withText("Area")).perform(click());
        SystemClock.sleep(100);
        onView(withText("Evo")).perform(click());
        SystemClock.sleep(100);
        pressBack();
    }

    @Test
    public void haveBottomSheetInfo() throws Exception {
        onView(withText("Nimbleaf")).perform(click());
        SystemClock.sleep(100);
        onView(withId(R.id.abil1)).perform(click());
        SystemClock.sleep(100);
        onView(withText("Nimbleaf")).check(matches(isDisplayed()));
        onView(withText("Parsleaf")).check(matches(isDisplayed()));
    }
}
