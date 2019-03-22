package com.eisedo.eisedo.data.local;

import com.eisedo.eisedo.data.local.entities.CheckList;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.HomeTaskCount;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.data.local.entities.User;
import com.eisedo.eisedo.util.DateConverter;

import java.util.Date;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

@Dao
public interface EiseDoDao {

    @Insert
    long insertTask(Task task);

    @Update
    void updateTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * FROM task ORDER BY due_date")
    Task[] getAllTasks();

    @Query("SELECT * FROM task WHERE bucket = :bucketType")
    Task[] getTaskByBucket(int bucketType);

    @Query("SELECT COUNT(*) AS 'stared' FROM task WHERE star = :stared")
    int getStarCount(boolean stared);

    //TODO -- Check the query
    //get tasks Do Later or Eliminate
    @TypeConverters(DateConverter.class)
    @Query("SELECT * FROM task WHERE importance = :importance AND progress != 100 AND (due_date > :taskDate OR due_date IS NULL)")
    List<Task> getTasksBasedOnDateLater(boolean importance, Date taskDate);

    //get tasks Do Now or Delegate
    @TypeConverters(DateConverter.class)
    @Query("SELECT * FROM task WHERE importance = :importance AND due_date <= :taskDate AND progress != 100")
    List<Task> getTasksBasedOnDateNow(boolean importance, Date taskDate);

    // get Over Due Tasks
    @TypeConverters(DateConverter.class)
    @Query("SELECT * FROM `task` WHERE due_date > :date AND progress != 100 AND importance = 0 AND deleted = 0")
    List<Task> getOverDueTasks(Date date);

    // get Stared Tasks
    //TODO -- unStarred
    @Query("SELECT * FROM `task` WHERE star = 0 AND progress != 100 AND deleted = 0")
    List<Task> getStaredTasks();

    // get completed Tasks
    //TODO -- Incomplete Tasks
    @Query("SELECT * FROM task WHERE progress != 100 AND deleted = 0")
    List<Task> getCompletedTasks();

    // TODO --verify the query
    // get delegated Tasks
    @Query("SELECT * FROM task WHERE delegate_name IS NOT NULL OR delegate_name != '' AND progress != 100")
    List<Task> getDelegatedTasks();

    //Trashed Tasks
    //TODO -- not trashed Tasks
    @Query("SELECT * FROM task WHERE progress != 100 AND deleted = 1")
    List<Task> getTrashedTasks();

    //Repeat Tasks
    //TODO -- not repeat Tasks
    @Query("select * from task where task.repeat !=0 AND  progress != 100 AND deleted = 0")
    List<Task> getRepeatTasks();

    // get User
    @Query("SELECT * FROM user")
    User[] getUser();

    //insert User
    @Insert
    long insertUser(User user);

    // update User
    @Update
    void updateUser(User user);

    //clear Users Database
    @Delete
    void deleteUsers(User[] users);

    @Insert
    long insertFolder(Folder folder);

    @Query("SELECT * FROM task WHERE id = :task_id")
    Task getTaskById(long task_id);

//    @Query("SELECT user_id, name from User")
//    public List<UsersProject> loadUserAndPets();

    @Update
    void updateFolder(Folder folder);

    @Query("SELECT * FROM folder WHERE parent_folder_id = 1")
    List<Folder> getFolderList();

    @Query("SELECT * FROM task WHERE title LIKE '%' || :search || '%'")
    List<Task> searchTaskByTitle(String search);

    //Based on Progress
    @Query("SELECT * FROM task WHERE progress != 100 AND folder_id = :folder_id ORDER BY progress ASC")
    List<Task> getTasksByProgress(long folder_id);

    //Based on Title
    @Query("SELECT * FROM task WHERE progress != 100 AND folder_id = :folder_id ORDER BY title ASC")
    List<Task> getTasksByTitle(long folder_id);

    //Based on Due Date
    @Query("SELECT * FROM task WHERE progress != 100 AND folder_id = :folder_id ORDER BY due_date ASC")
    List<Task> getTasksByDueDate(long folder_id);

    @TypeConverters(DateConverter.class)
    @Query("SELECT (SELECT COUNT(*) FROM task WHERE folder_id = 0) AS inboxCount, (SELECT COUNT(*) FROM task WHERE star == 1 AND progress != 100) AS starredCount, (SELECT COUNT(*) FROM task WHERE progress == 100) AS completedCount, (SELECT COUNT(*) FROM task WHERE (due_date <= :matrixDate OR due_date IS NULL) AND progress != 100 AND importance = 0 AND deleted = 0) AS overDueCount, (SELECT COUNT(*) FROM task WHERE deleted == 1) AS trashedCount ,(SELECT COUNT(*) FROM task WHERE remainder_date == '' AND remainder_date IS NOT NULL) AS repeatCount ,(SELECT COUNT(*) FROM task WHERE  delegate_name == '' AND progress != 100) AS delegateCount")
    HomeTaskCount getTaskCounts(Date matrixDate);

//    @Query("SELECT * FROM alarm")
//    List<Alarm> getListOfAlarm();
//
//    @Insert
//    long insertAlarm(Alarm alarm);
//
//    @Update
//    void upDateAlarm(Alarm alarm);
//
//    @Delete
//    void deleteAlarm(Alarm alarm);
//
//    @Delete
//    void deleteAllAlaram(List<Alarm> alarms);

    @Query("select * from task where remainder_date IS NOT NULL")
    List<Task> getReminders();

    @Query("select * from task where folder_id = :folder_id order by task.title ASC")
    List<Task> getTasksByOrderTitle(int folder_id);

    @Query("select * from task where folder_id = :folder_id order by task.due_date ASC")
    List<Task> getTasksByOrderDueDate(int folder_id);

    @Query("select * from task WHERE folder_id = :folder_id order by task.progress ASC")
    List<Task> getTasksByOrderProgress(int folder_id);

    // Checklist operations

    @Insert
    long insertCheckList(CheckList checkList);

    @Update
    void updateCheckList(CheckList checkList);

    @Delete
    void deleteCheckList(CheckList checkList);

    @Query("select * from checklist")
    List<CheckList> getCheckLists();

//    @Insert
//    long insertCheckListItem(CheckListItem checkListItem);
//
//    @Update
//    void updateCheckListItem(CheckListItem checkListItem);
//
//    @Delete
//    void deleteCheckListItem(CheckListItem checkListItem);
//
//    @Query("select * from checkListItem")
//    List<CheckListItem> getCheckListItems();

}