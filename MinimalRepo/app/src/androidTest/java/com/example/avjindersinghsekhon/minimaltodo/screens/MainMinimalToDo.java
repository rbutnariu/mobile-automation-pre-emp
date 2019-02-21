package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainMinimalToDo extends ScreenBase{
    public void checkCurrentScreen() {
        onView(withId(R.id.toDoRecyclerView)).check(matches(isDisplayed()));
    }

    public void navigateTo() {
        openAddToWindow();
    }
}
