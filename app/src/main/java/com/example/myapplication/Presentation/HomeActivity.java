package com.example.myapplication.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.myapplication.R;

public class HomeActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    protected void onDestroy(){
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void buttonAddTaskOnClick(View v){
        Intent newTaskIntent = new Intent(HomeActivity.this, TaskActivity.class);
        HomeActivity.this.startActivity(newTaskIntent);
    }


}
