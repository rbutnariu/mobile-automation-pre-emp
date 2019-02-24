
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
import static com.example.avjindersinghsekhon.minimaltodo.wait.WaitHelper.waitedFor;

public class ApplicationTest {
    AddToDo setup;
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void test() {
        About aboutScreenInstance = new About();
        aboutScreenInstance.navigateTo();
        aboutScreenInstance.checkCurrentScreen();


    }

    @Test
    public void testSettings() {
        Settings settingsInstance = new Settings();
        settingsInstance.navigateTo();
        settingsInstance.checkCurrentScreen();


    }

    @Test
    public void testToDo() {
        AddToDo todo = new AddToDo();
        todo.checkCurrentScreen();
        todo.navigateTo();

    }

    @Test
    public void checkToAddScreen() {
        setup = new AddToDo();
        setup.navigateTo();
        setup.checkToDoScreen();
    }

    @Test()
    public void completToDo() {
        setup = new AddToDo();
        setup.navigateTo();
        setup.checkToDoScreen();
        setup.complete();


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


}