package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.view.View;
import android.widget.ImageView;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public abstract class ScreenBase {
    abstract public void checkCurrentScreen();
    abstract  public void  navigateTo();


    private final static String MORE_OPTIONS="More options";
    public void openMenuPopUp(){
        onView(allOf(withContentDescription(MORE_OPTIONS),is (instanceOf(ImageView.class)))).check(matches(isDisplayed())).perform(click());
    }
    public Matcher<View> getMatcherWithText(String text){
        return getMatcherWithText(text,R.id.title);
    }
    public Matcher<View> getMatcherWithText(String text, int resourceId){
        return allOf(withId(resourceId),withText(text));
    }
    public void openAddToWindow(){
        onView(withId(R.id.toDoRecyclerView)).check(matches(isDisplayed())).perform(click());

    }

    public void addToDo(){
        addTitle();
        addDescription();
        setReminder();
    }


    public void addTitle(){
        onView(withId(R.id.userToDoEditText)).check(matches(isDisplayed())).perform(click()).perform(typeText("Action1"));
    }
    public void addDescription(){
        onView(withId(R.id.userToDoDescription)).check(matches(isDisplayed())).perform(click()).perform(typeText("Description TO DO"));
    }
    public void setReminder(){
        onView(withId(R.id.toDoHasDateSwitchCompat)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.makeToDoFloatingActionButton)).check(matches(isDisplayed())).perform(click());

    }

    public boolean removeAllReminders(){
        boolean flag = true;

        do {
            try {
                onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));

            } catch (Exception e) {
                flag = false;

            }
        }
        while(flag==true);
        return flag;
    }
}

