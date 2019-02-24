package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.widget.LinearLayout;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class MainMinimalToDo extends ScreenBase {

    public void navigateTo() {

    }

    public void checkCurrentScreen() {

        onView(withId(R.id.addToDoItemFAB)).check(matches(isDisplayed()));

    }

    public boolean deleteReminders() {
        boolean flag = true;
        do {
            try {
                onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
            } catch (Exception e) {
                flag = false;
            }
        }

        while (flag == true);
        return flag;
    }

}

