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
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public abstract class ScreenBase {
    abstract public void checkCurrentScreen();
    abstract public void navigateTo();

    private final static String MORE_OPTIONS= "More options";

    public void openMenuPopup() {
        onView(allOf(withContentDescription(MORE_OPTIONS),is(instanceOf(ImageView.class)))).check(matches(isDisplayed())).perform(click());
    }


    public Matcher<View> getMatcher(String text) {
        return getMatcher(text,R.id.title);
    }

    public Matcher<View> getMatcher(int resourceId) {
        return withId(resourceId);
    }

    public Matcher<View> getMatcher(String text, int resourceId) {
        return allOf(withId(resourceId),withText(text));
    }

    public boolean isMatcherDisplayed(int id) {
        boolean flag = true;
        try {
            onView(withId(id)).check(matches(isDisplayed()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
