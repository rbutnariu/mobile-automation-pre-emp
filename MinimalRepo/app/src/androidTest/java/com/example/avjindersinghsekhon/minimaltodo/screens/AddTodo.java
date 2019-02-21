package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.view.View;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AddTodo extends ScreenBase {


    public void navigateTo() {
        onView(withId(R.id.addToDoItemFAB)).check(matches(isDisplayed())).perform(click());
    }

    public void checkCurrentScreen() {
    onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isCompletelyDisplayed()));
    }

    public void addTitle(String text) {
        onView(withId(R.id.userToDoEditText)).perform(typeText(text)).check(matches(isDisplayed()));
    }

    public void addDescription(String description) {
        onView(withId(R.id.userToDoDescription)).perform(typeText(description)).check(matches(isDisplayed()));
    }

    public void setReminder() {
        onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isDisplayed())).perform(click());
    }

    public void addReminder(String title, String description) {
        addTitle(title);
        addDescription(description);
        setReminder();
    }

}
