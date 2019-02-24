package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Settings extends ScreenBase {
    private final String SETTINGS = "Settings";

    @Override
    public void checkCurrentScreen() {
        Assert.assertTrue("Night mode is not displayed ", isNightModeVisible());
    }

    @Override
    public void navigateTo() {
        openMenuPopup();
        onView(getMatcherWithText(SETTINGS)).perform(click());
    }

    public boolean isNightModeVisible() {
        boolean flag = true;
        try {
            onView(withId(R.id.title)).check(matches(isDisplayed()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void clickNightMode(){
        onView(withId(R.id.checkbox)).perform(click());
    }
}
