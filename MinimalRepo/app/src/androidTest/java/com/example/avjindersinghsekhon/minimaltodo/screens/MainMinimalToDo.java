package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class MainMinimalToDo extends ScreenBase {

    public void checkCurrentScreen() {
        onView(allOf(withId(R.id.toolbar))).check(matches(isCompletelyDisplayed()));
    }

    public void navigateTo() {
        // onView(withId(R.id. makeToDoFloatingActionButton)).check(matches(isDisplayed())).perform(click());
    }

    public boolean removeOneReminder() {
        boolean flag = true;
        try {
            onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void removeAllReminder() {
        boolean flag = removeOneReminder();
        while (flag) {
            flag = removeOneReminder();
        }

    }

}
