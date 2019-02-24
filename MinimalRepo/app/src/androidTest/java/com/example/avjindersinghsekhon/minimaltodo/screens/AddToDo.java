package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.support.test.espresso.Espresso;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;

public class AddToDo extends ScreenBase {

    public void checkCurrentScreen() {
        Assert.assertTrue("The floating action button is not displayed, we are not on the \"add a reminder\" screen!", isMatcherDisplayed(R.id.makeToDoFloatingActionButton));
    }

    public void navigateTo() {
        // click on "add a new reminder" button
        onView(getMatcher(R.id.addToDoItemFAB)).perform(click());
        Espresso.closeSoftKeyboard();
    }

    /**
     * This method adds a title then clicks on the Floating Action Button
     *
     * @param title
     */
    public void addReminder(String title) {
        enterTitleText(title);
        pressActionButton();

    }

    /**
     * This method adds a text title and a description then clicks on the Floating Action Button
     *
     * @param title
     * @param description
     */
    public void addReminder(String title, String description) {
        enterTitleText(title);
        enterDescriptionText(description);
        pressActionButton();
    }

    /**
     * Method that clicks on the Floating Action Button
     */
    public void pressActionButton() {
        onView(getMatcher(R.id.makeToDoFloatingActionButton)).perform(click());
    }

    /**
     * Method that gives a title to the reminder
     *
     * @param title
     */
    public void enterTitleText(String title) {
        onView(getMatcher(R.id.userToDoEditText)).perform(typeTextIntoFocusedView(title));

    }

    /**
     * Method that gives a description to the reminder
     *
     * @param description
     */
    public void enterDescriptionText(String description) {
        onView(getMatcher(R.id.userToDoDescription)).perform(typeTextIntoFocusedView(description));

    }

    public void setReminder() {
        onView(getMatcher(R.id.toDoHasDateSwitchCompat)).perform(click());
        setReminderDate();
    }

    public void setReminderDate() {
        onView(getMatcher(R.id.newTodoDateEditText)).perform(click());
        //onView(getMatcher(withClassName(View)));
    }

    /**
     * Method that sets time to a certain hour, minute and  meridian
     * @param hour form 1 to 12
     * @param minute from 0 to 59
     * @param meridian AM or PM
     */
    public void setReminderTime(int hour, int minute, String meridian) {
        onView(getMatcher(R.id.newTodoTimeEditText)).perform(click());
        onView(getMatcher(R.id.time_picker)).perform();

        // setting meridian
    }


    public void copyToClipboard() {
        onView(getMatcher(R.id.copyclipboard)).perform(click());
    }
}
