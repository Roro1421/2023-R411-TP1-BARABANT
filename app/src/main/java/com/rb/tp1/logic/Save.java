package com.rb.tp1.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Save implements IStorageTasks  {

    private SharedPreferences sharedPreferences;

    private TaskList taskList;

    private SharedPreferences.Editor ed ;

    public Save(SharedPreferences share) throws Exception {
        this.sharedPreferences = share;
        this.ed = sharedPreferences.edit();
        this.taskList = new TaskList();
        Gson gson = new Gson();
        String tmp = sharedPreferences.getString("tasks","");
        taskList = gson.fromJson(tmp, TaskList.class);
    }

    @Override
    public TaskList ReadTasks() throws Exception {
        return this.taskList;
    }

    @Override
    public void AddTask(Task task) {
        Gson gson = new Gson();
        this.taskList.AddTask(task);
        String str = gson.toJson(this.taskList);
        ed.putString("tasks",str);
        ed.apply();;
    }

    @Override
    public void UpdateTask(Task task) {
        Gson gson = new Gson();
        this.taskList.AddTask(task);
        String str = gson.toJson(this.taskList);
        ed.putString("tasks",str);
        ed.apply();
    }
}
