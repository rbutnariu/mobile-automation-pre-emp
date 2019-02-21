package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainMinimalToDo extends ScreenBase {

    public void checkCurrentScreen() {
        Assert.assertTrue("Toolbar is not displayed, we are not on the main screen!", isMatcherDisplayed(R.id.toolbar));
    }

    public void navigateTo() {
    }

    public void removeAllReminders() {
        boolean flag = removeReminder(0);
        while (flag) {
            flag = removeReminder(0);
        }
    }

    public boolean removeReminder(int index) {
        boolean flag = true;
        try {
            onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(index, swipeRight()));
        } catch (Exception e) {
            flag = false;

        }
        return flag;
    }

    public void checkIfReminderExists() {
        Assert.assertTrue("No reminders found", isMatcherDisplayed(R.id.listItemLinearLayout));
    }


    public void checkIfListIsEmpty() {
        Assert.assertTrue("No reminders found", isMatcherDisplayed(R.id.toDoEmptyView));
    }

}
