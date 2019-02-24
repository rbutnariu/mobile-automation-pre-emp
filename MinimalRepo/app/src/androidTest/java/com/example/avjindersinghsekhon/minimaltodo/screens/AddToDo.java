package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.widget.ImageButton;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


public class AddToDo extends ScreenBase {


    public void checkCurrentScreen() {
        onView(withId(R.id.addToDoItemFAB)).check(matches(isCompletelyDisplayed()));
    }

    public static void openAddToDo() {
        onView(allOf(withId(R.id.addToDoItemFAB), is(instanceOf(ImageButton.class)))).check(matches(isDisplayed())).perform(click());
    }

    public void completeAllFields_addToDo() {
        onView(withId(R.id.userToDoEditText)).perform(typeText("Alarm"), closeSoftKeyboard());
        onView(withId(R.id.userToDoDescription)).perform(typeText("This is my alarm!"), closeSoftKeyboard());
        onView(withId(R.id.toDoHasDateSwitchCompat)).perform(click());
        onView(withId(R.id.newTodoDateEditText)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());
    }

    public void navigateTo() {
        openAddToDo();
    }

    public void completeWithCorrectValues() {
        completeAllFields_addToDo();
    }


}
