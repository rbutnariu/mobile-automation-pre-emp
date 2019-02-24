package com.example.avjindersinghsekhon.minimaltodo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.junit.Assert;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainMinimalToDo extends ScreenBase{

    public void  checkCurrentScreen() {
        Assert.assertTrue("Add to Do button is not displayed.", addToDoDisplayed());
    }

    public void navigateTo(){
    }

    public boolean addToDoDisplayed(){
        boolean flag = true;
        try {
            onView(withId(R.id.addToDoItemFAB)).check(matches(isDisplayed()));
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }
}

