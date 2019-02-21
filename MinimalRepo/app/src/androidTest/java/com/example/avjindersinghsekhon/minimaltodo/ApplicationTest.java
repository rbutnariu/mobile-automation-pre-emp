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

public class ApplicationTest {
    About aboutScreenInstance;
    Settings settingsScreenInstance;
    AddToDo addToDoScreenInstance;
    MainMinimalToDo mainMinimalToDoScreenInstance;
    WaitHelper waitHelper;
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void test() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
       aboutScreenInstance = new About();
        aboutScreenInstance.navigateTo();
        aboutScreenInstance.checkCurrentScreen();

    }

    @Test
    public void test2() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
       settingsScreenInstance = new Settings();
        settingsScreenInstance.navigateTo();
        settingsScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test3() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        addToDoScreenInstance = new AddToDo();
        addToDoScreenInstance.navigateTo();
        addToDoScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test4() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        mainMinimalToDoScreenInstance = new MainMinimalToDo();
        mainMinimalToDoScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test5() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        waitHelper = new WaitHelper();
        waitHelper.waitedFor(waitHelper.elementToBeFound(onView(withId(R.id.addToDoItemFAB))),20000, 100);
        mainMinimalToDoScreenInstance = new MainMinimalToDo();
        addToDoScreenInstance = new AddToDo();
        addToDoScreenInstance.navigateTo();
        addToDoScreenInstance.insertTitle("Reminder2");
        addToDoScreenInstance.insertDescription("This is reminder2.");
        addToDoScreenInstance.switchRemindMeButton("ON");
        addToDoScreenInstance.clickSubmit();
        mainMinimalToDoScreenInstance.checkCurrentScreen();
    }

}