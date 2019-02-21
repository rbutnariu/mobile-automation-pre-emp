package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AddToDo extends ScreenBase {
    public void checkCurrentScreen() {
        onView(withId(R.id.toDoRecyclerView)).check(matches(isDisplayed()));
    }

    public void navigateTo() {
        onView(withId(R.id.addToDoItemFAB)).check(matches(isDisplayed())).perform(click());
    }
    public void addReminders(){
        addToDo();
    }
}
