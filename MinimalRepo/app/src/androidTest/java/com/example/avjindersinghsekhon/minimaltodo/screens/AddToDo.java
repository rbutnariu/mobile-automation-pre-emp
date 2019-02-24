package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AddToDo extends ScreenBase {

    @Override
    public void checkCurrentScreen() {
        Assert.assertTrue("Add button is not displayed ", isFloatingAddButton());
    }

    @Override
    public void navigateTo() {
        onView(withId(R.id.addToDoItemFAB)).perform(click());
    }

    public boolean isFloatingAddButton() {
        boolean flag = true;
        try {
            onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isDisplayed()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void clickCompact() {
        onView(withId(R.id.toDoHasDateSwitchCompat)).perform(click());
    }

    public void clickFloatingAdd() {
        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());
    }
    public void addTitle(){
        onView(withId(R.id.userToDoEditText)).perform(click(),typeTextIntoFocusedView("custom"));
    }
    public void addDescription(){
        onView(withId(R.id.userToDoDescription)).perform(click(),typeTextIntoFocusedView("descriere"));
    }

    public void clickDate(){
        onView(withId(R.id.newTodoDateEditText)).perform(click());
        onView(withId(R.id.ok)).perform(click());
    }

}
