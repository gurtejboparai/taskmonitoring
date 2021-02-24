package com.example.myapplication.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setcontentView(R.layout.activity_home);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void buttonAddTaskOnClick(View v){
        Intent newTaskIntent = new Intent(HomeActivity.this, TaskActivity.class);
        HomeActivity.this.startActivity(newTaskIntent);
    }


}