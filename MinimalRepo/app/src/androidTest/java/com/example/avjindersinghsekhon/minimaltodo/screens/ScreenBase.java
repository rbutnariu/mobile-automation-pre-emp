package com.example.avjindersinghsekhon.minimaltodo.screens;

import android.view.View;
import android.widget.ImageView;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public abstract class ScreenBase {
    abstract public void checkCurrentScreen();
    abstract public void navigateTo();

    private static final String MORE_OPTIONS = "More options";

    public void openMenupopUp(){
        onView(allOf(withContentDescription(MORE_OPTIONS), is(instanceOf(ImageView.class)))).check(matches(isDisplayed())).perform(click());
    }

    public static Matcher<View> getMatcherWithText(String text){
        return getMatcherWithText(text, R.id.title);
    }

    public static Matcher<View> getMatcherWithText(String text, int resourceId){
        return allOf(withId(resourceId), withText(text));
    }


    public boolean hasToDoItems(){
        boolean flag = true;
        try {
            onView(withId(R.id.toDoRecyclerView)).check(matches(isDisplayed()));
        } catch (Error e){
            flag = false;
        }
        return flag;
    }

    public void removeAllToDoSwipe(){

        while  ( hasToDoItems()) {
            onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        }
    }
}
