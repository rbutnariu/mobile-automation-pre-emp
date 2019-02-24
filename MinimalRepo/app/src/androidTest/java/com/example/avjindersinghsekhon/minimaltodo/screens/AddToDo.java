package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.widget.Button;
import android.widget.EditText;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class AddToDo extends ScreenBase {
    private String text = "Reminder5";
    private String description = "This is Reminder5";

    public void checkCurrentScreen() {
        onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isCompletelyDisplayed()));
    }

    public void navigateTo() {
        onView(withId(R.id.addToDoItemFAB)).perform(click());
    }

    public void clickOk() {
        onView(allOf(withId(R.id.ok), is(instanceOf(Button.class)))).perform(click());
    }

    public void clickOnViewWithId(int id) {
        onView(withId(id)).perform(click());
    }

    public void typeTextInFields(String text, int resourceId) {
        onView(allOf(withId(resourceId), is(instanceOf(EditText.class)))).perform(click(), typeText(text)).check(matches(isDisplayed()));
    }


    public void addReminder() {
        typeTextInFields(text, R.id.userToDoEditText);
        typeTextInFields(description, R.id.userToDoDescription);
        clickOnViewWithId(R.id.toDoHasDateSwitchCompat);
      /*clickOnViewWithId(R.id.newTodoDateEditText);
        clickOk();
        clickOnViewWithId(R.id.newTodoTimeEditText);
        clickOk();*/
        clickOnViewWithId(R.id.makeToDoFloatingActionButton);
    }


}
