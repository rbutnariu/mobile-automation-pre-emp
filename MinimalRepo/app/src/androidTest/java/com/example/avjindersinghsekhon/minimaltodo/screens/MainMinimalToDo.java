package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainMinimalToDo extends ScreenBase {

    private final static String MORE_OPTIONS = "More options";

    public void checkCurrentScreen() {
        onView(withContentDescription(MORE_OPTIONS)).check(matches(isCompletelyDisplayed()));
    }

    public void navigateTo() {
        // N/A
    }

    public boolean hasToDoItems() {
        try {
            onView(withId(R.id.toDoRecyclerView)).check(matches(isDisplayed()));
        } catch (Error e) {
            return false;
        }
        return true;
    }

    public void removeToDoItem() {
        onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
    }

    public void removeAllToDoItems() {
        while (hasToDoItems()) {
            removeToDoItem();
        }
    }


}
