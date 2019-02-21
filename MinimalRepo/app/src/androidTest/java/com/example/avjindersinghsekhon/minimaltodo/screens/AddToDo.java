package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.widget.ImageButton;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;

public class AddToDo extends ScreenBase {
    private final static String TITLE = "Title";
    private final static String DESCRIPTION = "This is the description";

    public void checkCurrentScreen() {
        Assert.assertTrue("Send button is not displayed", isSendButtonDisplayed());
    }

    public void navigateTo() {
        onView(withId(R.id.addToDoItemFAB)).perform(click());
    }

    public void addToDo() {
        onView(withId(R.id.userToDoEditText)).perform(typeText(TITLE),
                closeSoftKeyboard());
        onView(withId(R.id.userToDoDescription)).perform(typeText(DESCRIPTION),
                closeSoftKeyboard());
        onView(withId(R.id.toDoHasDateSwitchCompat)).perform(click());
        onView(withId(R.id.newTodoTimeEditText)).perform(click()).perform(click());
        onView(withId(R.id.newTodoDateEditText)).perform(click());
    }

    public void typeInputTitle() {
        onView(withId(R.id.userToDoEditText)).perform(typeText(TITLE),
                closeSoftKeyboard());
    }

    public void typeInputDescription() {
        onView(withId(R.id.userToDoDescription)).perform(typeText(DESCRIPTION),
                closeSoftKeyboard());
    }

    public void pressButtonReminderMe() {
        onView(withId(R.id.toDoHasDateSwitchCompat)).perform(click());
    }

    public void fixedTheTime() {
        onView(withId(R.id.newTodoTimeEditText)).perform(click()).perform(click());
    }

    public void fixedTheDate() {
        onView(withId(R.id.newTodoDateEditText)).perform(click());
    }

    public boolean isSendButtonDisplayed() {
        boolean flag = true;
        try {
            onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isDisplayed()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void cleanAllReminder() {
        boolean flag = true;

        while (flag) {
            try {
                onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));

            } catch (Exception ex) {
                flag = false;
            }
        }
    }

    }

