package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.support.test.espresso.ViewInteraction;
import android.view.View;
import android.widget.FrameLayout;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class AddToDo extends ScreenBase {

    private final static String TITLE = "Kind Reminder";
    private final static String DESCRIPTION = "Please remind yourself this.";

    private static final String ADDTODOITEM = "addToDoItemFAB";
    public static final ViewInteraction addToDoItemButton = onView(getMatcherWithText(ADDTODOITEM));

    private static final String EDITTILE = "userToDoEditText";


    public void checkCurrentScreen() {
        Assert.assertTrue("To Do image view is not displayed.", addToDoButtonIsDisplayed());
    }

    public void navigateTo() {
        //addToDoItemButton.perform(click());
        onView(withId(R.id.addToDoItemFAB)).perform(click());
    }

    public void addToDo(){
        onView(withId(R.id.userToDoEditText)).perform(typeText(TITLE),
                closeSoftKeyboard());
        onView(withId(R.id.userToDoDescription)).perform(typeText(DESCRIPTION),
                closeSoftKeyboard());
        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());
    }

    public boolean addToDoButtonIsDisplayed(){
        boolean flag = true;
        try {
            onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isDisplayed()));
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }

}
