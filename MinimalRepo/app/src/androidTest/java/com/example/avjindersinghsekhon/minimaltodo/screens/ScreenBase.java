package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.view.View;
import android.widget.ImageView;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public abstract class ScreenBase {
    private static final String MORE_OPTIONS = "More options";

    abstract public void checkCurrentScreen();

    abstract public void navigateTo();

    public void openMenuPopup() {
        onView(allOf(withContentDescription(MORE_OPTIONS), is(instanceOf(ImageView.class)))).check(matches(isDisplayed())).perform(click());
    }

    public Matcher<View> getMatcherWithText(String text, int resourceid) {
        return allOf(withId(resourceid), withText(text));
    }

    public Matcher<View> getMatcherWithText(String text) {
        return getMatcherWithText(text, R.id.title);
    }
}
