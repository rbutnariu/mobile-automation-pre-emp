package com.example.avjindersinghsekhon.minimaltodo;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.widget.ImageView;

import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;
import com.example.avjindersinghsekhon.minimaltodo.screens.About;
import com.example.avjindersinghsekhon.minimaltodo.screens.AddToDo;
import com.example.avjindersinghsekhon.minimaltodo.screens.MainMinimalToDo;
import com.example.avjindersinghsekhon.minimaltodo.screens.Settings;
import com.example.avjindersinghsekhon.minimaltodo.wait.WaitHelper;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.avjindersinghsekhon.minimaltodo.screens.About.aboutLabel;
import static com.example.avjindersinghsekhon.minimaltodo.screens.ScreenBase.getMatcherWithText;
import static com.example.avjindersinghsekhon.minimaltodo.wait.WaitHelper.elementToBeFound;
import static com.example.avjindersinghsekhon.minimaltodo.wait.WaitHelper.waitedFor;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class ApplicationTest {
    MainMinimalToDo mainMinimal = new MainMinimalToDo();


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void test() {

        About aboutScreenInstance = new About();
        aboutScreenInstance.navigateTo();
        aboutScreenInstance.checkCurrentScreen();
    }

    @Test
    public void test2() {
        Settings settingsScreenInstance = new Settings();
        settingsScreenInstance.navigateTo();
        settingsScreenInstance.checkCurrentScreen();
    }

    @Test
    public void addToDoTest() {
        AddToDo addToDoObject = new AddToDo();
        addToDoObject.navigateTo();
        addToDoObject.checkCurrentScreen();
        addToDoObject.addToDo();
    }

    @Test
    public void mainMinimalTest() {

        mainMinimal.checkCurrentScreen();
    }

    @Test
    public void deleteAll() {
        mainMinimal.removeAllToDoSwipe();
    }

    @Test
    public void waitTest() throws Exception {
        if (waitedFor(WaitHelper.elementToBeFound(onView(withId(434))), 1000, 1000)) {
            throw new Exception("object was not found!");
        }
    }

    @Test
    public void waitForElementToBePresent() {
        System.out.println(waitedFor(WaitHelper.elementToBeFound(onView(withId(R.id.addToDoItemFAB))), 1000, 1000));
    }
}