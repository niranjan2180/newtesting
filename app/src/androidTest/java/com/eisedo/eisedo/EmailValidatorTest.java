package com.eisedo.eisedo;

import android.content.Context;
import android.util.Log;

import com.eisedo.eisedo.data.local.EiseDoDatabase;
import com.eisedo.eisedo.data.local.entities.HomeTaskCount;
import com.eisedo.eisedo.data.local.entities.Task;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.hamcrest.Matchers.isEmptyString;


@RunWith(AndroidJUnit4.class)
public class EmailValidatorTest {

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {

        Assert.assertThat("", isEmptyString());
    }

    @Test
    public void getTasks() {

        EiseDoDatabase eiseDoDatabase = EiseDoDatabase.getInstance(context);

        eiseDoDatabase.eiseDoDao().getFolderList();

        Log.d("DataTask", eiseDoDatabase.eiseDoDao().getAllTasks().length + " ");

        int tasks = eiseDoDatabase.eiseDoDao().getAllTasks().length;

        for (int i = 0; i < tasks; i++) {
            Task task = eiseDoDatabase.eiseDoDao().getAllTasks()[i];
            Log.d("TaskDates", task.getTitle() + " " + task.getId() + " " + task.isImportance() + " " + task.getDue_date());
        }

        Assert.assertTrue(tasks > 0);
    }

    @Test
    public void getRememberDate(){
        EiseDoDatabase eiseDoDatabase = EiseDoDatabase.getInstance(context);

        List<Task> tasks = eiseDoDatabase.eiseDoDao().getListOfAlarm();

        for (int i =0; i< tasks.size(); i++){
            Log.d("TAsls", tasks.get(i).getTask_id() + " " + tasks.get(i).getDue_date());
        }

        Log.d("Tasks", tasks.size() + " ");
        Assert.assertNotNull(tasks);

    }

    @Test
    public void getTaskByDate(){
        EiseDoDatabase eiseDoDatabase = EiseDoDatabase.getInstance(context);
//        TimeZone tz = TimeZone.getTimeZone("GMT+01:00");
        Calendar calendar = Calendar.getInstance();
//        calendar.set(2018,11,6);
//        calendar.add(Calendar.DATE, 1);
//        calendar.setTimeZone(tz);
        List<Task> tasks = eiseDoDatabase.eiseDoDao().getTasksBasedOnDateLater(true,calendar.getTime());

        Log.d("TAsksSize", tasks.size() + "  "+ calendar.getTime() + " " + calendar.getTimeZone().getDisplayName());

        for (int i=0; i< tasks.size(); i++){
            Task task = tasks.get(i);
            Log.d("TaskDates", task.getTitle() + " " + task.getId() + " " + task.isImportance()  + "  " + task.getDue_date());
        }

        Assert.assertNotNull(tasks);
    }

    @Test
    public void getHomeTitleCount(){

        EiseDoDatabase eiseDoDatabase = EiseDoDatabase.getInstance(context);
//        TimeZone tz = TimeZone.getTimeZone("GMT+01:00");
        Calendar calendar = Calendar.getInstance();
//        calendar.set(2018,11,6);
//        calendar.add(Calendar.DATE, 1);
//        calendar.setTimeZone(tz);
        HomeTaskCount tasks = eiseDoDatabase.eiseDoDao().getTaskCounts(calendar.getTime());
//
        Log.d("TASKSCount",   tasks.getTrashedCount() + " " + tasks.getOverDueCount() + " " + tasks.getStarredCount() + " " + tasks.getCompletedCount() + " " + tasks.getInboxCount() + " " + tasks.getDelegateCount() );
    }

    private static final String FAKE_STRING = "HELLO_WORLD";
    private Context context = ApplicationProvider.getApplicationContext();

//    @Test
//    public void readStringFromContext_LocalizedString() {
//        // Given a Context object retrieved from Robolectric...
//        ClassUnderTest myObjectUnderTest = new ClassUnderTest(context);
//
//        // ...when the string is returned from the object under test...
//        String result = myObjectUnderTest.getHelloWorldString();
//
//        // ...then the result should be the expected one.
//        assertThat(result).isEqualTo(FAKE_STRING);
//    }
}
