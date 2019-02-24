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

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testNavigateToAboutPage() {
        About aboutScreenInstance = new About();
        aboutScreenInstance.navigateTo();
        aboutScreenInstance.checkCurrentScreen();
    }

    @Test
    public void testNavigateToSettingsPage() {
        Settings settingsScreenInstance = new Settings();
        settingsScreenInstance.navigateTo();
        settingsScreenInstance.checkCurrentScreen();
    }

    @Test
    public void testRemoveAllReminders() {
        MainMinimalToDo mainPage = new MainMinimalToDo();
        mainPage.removeAllReminders();
        mainPage.checkIfListIsEmpty();
    }

    @Test
    public void testAddNewReminder() {
        AddToDo newReminder = new AddToDo();
        newReminder.navigateTo();
        newReminder.checkCurrentScreen();
        newReminder.addReminder("New Reminder");

        MainMinimalToDo mainPage = new MainMinimalToDo();
        mainPage.checkCurrentScreen();
        mainPage.checkIfReminderExists();
    }

}