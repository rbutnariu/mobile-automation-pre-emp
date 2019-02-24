package com.example.avjindersinghsekhon.minimaltodo.screens;


import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class About extends ScreenBase {
    private final String ABOUT = "About";

    public void checkCurrentScreen() {
        Assert.assertTrue("About Image View is not displayed", isAboutImageViewDisplayed());
    }

    public void navigateTo() {
        //open menu popup
        openMenuPopup();
        onView(getMatcherWithText(ABOUT)).perform(click());
    }

    public boolean isAboutImageViewDisplayed() {
        boolean flag = true;
        try {
            onView(withId(R.id.aboutImageView)).check(matches(isDisplayed()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
