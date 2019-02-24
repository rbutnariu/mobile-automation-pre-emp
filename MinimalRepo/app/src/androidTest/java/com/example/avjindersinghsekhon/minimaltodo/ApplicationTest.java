package com.example.avjindersinghsekhon.minimaltodo;

import android.support.test.rule.ActivityTestRule;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;
import com.example.avjindersinghsekhon.minimaltodo.screens.About;
import com.example.avjindersinghsekhon.minimaltodo.screens.AddTodo;
import com.example.avjindersinghsekhon.minimaltodo.screens.MainMinimalToDo;
import com.example.avjindersinghsekhon.minimaltodo.screens.Settings;
import com.example.avjindersinghsekhon.minimaltodo.wait.WaitHelper;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void test() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));

        About aboutScreenInstance = new About();
        aboutScreenInstance.navigateTo();
        aboutScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test2() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));

        Settings settingsScreenInstance = new Settings();
        settingsScreenInstance.navigateTo();
        settingsScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test3() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));

       AddTodo addToDoScreenInstance = new AddTodo();
       addToDoScreenInstance.navigateTo();
       addToDoScreenInstance.checkCurrentScreen();
       addToDoScreenInstance.addReminder("Cosmina", "Wake up");
    }

    @Test
    public void test4() {
        MainMinimalToDo mainScreenInstance = new MainMinimalToDo();
        mainScreenInstance.checkCurrentScreen();
        mainScreenInstance.deleteReminders();

    }

    @Test
    public void test5() {
        System.out.println("The element exists "
                + WaitHelper.waitedFor(WaitHelper.elementToBeFound(onView(withId(R.id.addToDoItemFAB))), 20000, 100));

        System.out.println("The element exists "
                + WaitHelper.waitedFor(WaitHelper.elementToBeFound(onView(withText("empty"))), 20000, 100));
    }

}