package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainMinimalToDo extends ScreenBase {
    @Override
    public void checkCurrentScreen() {
        Assert.assertTrue("Main Minimal view is not displayed ", (isAddButton()));
    }

    @Override
    public void navigateTo() {
    }

    public boolean isAddButton() {
        boolean flag = true;
        try {
            onView(withId(R.id.addToDoItemFAB)).check(matches(isDisplayed()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean recyclerViewExists() {
        boolean flag = true;
        try {
            onView(withId(R.id.toDoRecyclerView)).check(matches(isDisplayed()));
        } catch (Error e) {
            flag = false;
        }
        return flag;
    }

    public void remove() {
        onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
    }

    public void deleteAllReminders() {
        while (recyclerViewExists()) {
            remove();
        }
    }
}
