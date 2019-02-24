package com.example.avjindersinghsekhon.minimaltodo;

import android.support.test.rule.ActivityTestRule;

import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;
import com.example.avjindersinghsekhon.minimaltodo.screens.About;
import com.example.avjindersinghsekhon.minimaltodo.screens.AddToDo;
import com.example.avjindersinghsekhon.minimaltodo.screens.MainMinimalToDo;
import com.example.avjindersinghsekhon.minimaltodo.screens.Settings;
import com.example.avjindersinghsekhon.minimaltodo.wait.WaitHelper;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testAbout() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        About about = new About();
        about.navigateTo();
        about.checkCurrentScreen();
    }

    @Test
    public void testSettings() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        Settings settings = new Settings();
        settings.navigateTo();
        settings.checkCurrentScreen();
        settings.clickNightMode();
    }

    @Test
    public void testAddToDo() {
        AddToDo add = new AddToDo();
        add.navigateTo();
        add.checkCurrentScreen();
        add.clickCompact();
        add.addTitle();
        add.addDescription();
        add.clickFloatingAdd();
    }

    @Test
    public void testMinimal() {
        MainMinimalToDo main = new MainMinimalToDo();
        main.checkCurrentScreen();
        main.deleteAllReminders();
    }

    @Test
    public void waitedForElement(){
        //Assert.assertTrue(WaitHelper.waitedFor(WaitHelper.elementToBeFound(onView(withId(R.id.toDoEmptyView))),20000,100));
        Assert.assertTrue(WaitHelper.waitedFor(WaitHelper.elementToBeFound(onView(withText("ddsadsa"))),20000,100));

    }
}