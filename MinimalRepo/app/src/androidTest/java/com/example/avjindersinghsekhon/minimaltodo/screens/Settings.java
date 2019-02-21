package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;


public class Settings extends ScreenBase {

    private final static String SETTINGS = "Settings";
    private final static String NIGHT_MODE = "Night Mode";

    public void checkCurrentScreen() {
        onView(getMatcherWithText(NIGHT_MODE, android.R.id.title)).check(matches(isCompletelyDisplayed()));
    }

    public void navigateTo() {
        // open menu pop-up
        openMenupopUp();
        onView(getMatcherWithText(SETTINGS)).perform(click());
    }
}
