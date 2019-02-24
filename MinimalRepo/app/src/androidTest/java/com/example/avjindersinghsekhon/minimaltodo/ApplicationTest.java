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
    public void removeAllReminders(){

        MainMinimalToDo mmtd=new MainMinimalToDo();
        mmtd.removeAllReminders();
    }

    @Test
    public void test() {

        About aboutScreenInstance=new About();
        aboutScreenInstance.navigateTo();
        aboutScreenInstance.checkCurrentScreen();
        aboutScreenInstance.isAboutImageViewDisplayed();
    }

    @Test
    public void test2() {
        //onView(withId(R.id.toDoRecyclerView)).perform(actionOnItemAtPosition(0, swipeRight()));
        Settings settingsScreenInstance=new Settings();
        settingsScreenInstance.navigateTo();
        settingsScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test3(){
        AddToDo addtodoScreenInstance=new AddToDo();
        addtodoScreenInstance.checkCurrentScreen();
        addtodoScreenInstance.navigateTo();
        addtodoScreenInstance.addReminders();
    }

    @Test
    public void test4(){
        MainMinimalToDo mainScreenInstance=new MainMinimalToDo();
        mainScreenInstance.checkCurrentScreen();
        mainScreenInstance.navigateTo();

    }
    @Test
    public void testWaitHelper(){
        WaitHelper wait=new WaitHelper();


    }
}