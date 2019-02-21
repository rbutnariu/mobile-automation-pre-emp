package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

public class About extends ScreenBase {
    private final static String ABOUT = "About";

    public void checkCurrentScreen() {
        Assert.assertTrue("About Image View is not displayed", isMatcherDisplayed(R.id.aboutImageView));
    }

    public void navigateTo() {
        // open menu  pop-up
        openMenuPopup();

        // click on About button
        onView(getMatcher(ABOUT)).perform(click());
    }

}
