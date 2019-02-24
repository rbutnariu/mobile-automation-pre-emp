package com.example.avjindersinghsekhon.minimaltodo;

import android.support.test.rule.ActivityTestRule;

import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;
import com.example.avjindersinghsekhon.minimaltodo.screens.About;
import com.example.avjindersinghsekhon.minimaltodo.screens.AddToDo;
import com.example.avjindersinghsekhon.minimaltodo.screens.MainMinimalToDo;
import com.example.avjindersinghsekhon.minimaltodo.screens.Settings;
import com.example.avjindersinghsekhon.minimaltodo.wait.WaitHelper;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void test() {
        // onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        About aboutScreenInstance = new About();
        aboutScreenInstance.navigateTo();
        aboutScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test2() {
        // onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        Settings settingsScreenInstance = new Settings();
        settingsScreenInstance.navigateTo();
        settingsScreenInstance.checkCurrentScreen();
    }

    @Test
    public void addToDo() {
        AddToDo addToDo = new AddToDo();
        addToDo.navigateTo();
        addToDo.checkCurrentScreen();
        addToDo.addReminder();
    }

    @Test
    public void mainMinimalToDo() {
        MainMinimalToDo mainMinimalToDo = new MainMinimalToDo();
        mainMinimalToDo.checkCurrentScreen();
        mainMinimalToDo.removeAllReminder();
    }

    @Test
    public void test3() {
        WaitHelper waitHelper = new WaitHelper();
        waitHelper.waitedFor(WaitHelper.elementToBeFound( onView(allOf(withId(R.id.toolbar)))),WaitHelper.kWaitTime200000,WaitHelper.kWaitTime100);
    }
}