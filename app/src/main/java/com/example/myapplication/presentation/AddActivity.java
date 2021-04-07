package com.example.myapplication.presentation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.business.AccessTask;
import com.example.myapplication.objects.Task;
import com.example.myapplication.R;
import com.example.myapplication.objects.TaskTag;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    private AccessTask accessTask;
    ImageButton calender;
    private int mDate,mMonth,mYear;
    private String titleTxt,descriptionTxt;
    private final TaskTag category = null;
    TextView title,description,date;
    Button save,cancel;
    Switch highPriority;
    Task newTask;
    Spinner dropDown;
    ArrayAdapter<CharSequence> adapter;
    int currNotification = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        accessTask = new AccessTask();

        date = findViewById(R.id.date);
        calender = findViewById(R.id.datePicker);
        title = findViewById(R.id.taskTitle);
        description = findViewById(R.id.taskDescription);
        highPriority = findViewById(R.id.highPriority);
        save = findViewById(R.id.saveButton);
        cancel = findViewById(R.id.cancelButton);
        dropDown=findViewById(R.id.dropDown);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);

        titleTxt = title.getText().toString();
        descriptionTxt = description.getText().toString();

        calender.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                mDate=calendar.get(Calendar.DATE);
                mMonth=calendar.get(Calendar.MONTH);
                mYear=calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(AddActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        date.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                },mYear,mMonth,mDate);

                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });
        findViewById(R.id.cancelButton).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveBtnOnClick(View view){
        String titleText;
        String descriptionText;
        String dateText;
        String priority = "False";
        String tasktag;

        boolean titleEmpty = this.title.getText().toString().trim().isEmpty();
        boolean descriptionEmpty = this.description.getText().toString().trim().isEmpty();
        boolean dateEmpty = this.date.getText().toString().trim().isEmpty();

        if (titleEmpty || descriptionEmpty || dateEmpty ) {
            Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
        }else{

            try{
                titleText = this.title.getText().toString().trim();
                descriptionText = this.description.getText().toString().trim();
                dateText = this.date.getText().toString().trim();
                if(highPriority.isChecked())
                    priority="True";
                tasktag=dropDown.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(), "Task Added", Toast.LENGTH_LONG).show();

                finish();
                Intent viewTasks = new Intent(AddActivity.this, ViewTaskActivity.class);
                viewTasks.putExtra("Title", titleText);
                viewTasks.putExtra("Description",descriptionText);
                viewTasks.putExtra("Date",dateText);
                viewTasks.putExtra("Priority",priority);
                viewTasks.putExtra("Tag",tasktag);
                
                if(priority.equalsIgnoreCase("True") ){
                    createNotification(titleText);
                }

                startActivity(viewTasks);
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), "Invalid fields", Toast.LENGTH_LONG).show();
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createNotification(String title){
        //open the tasks list from the notification
        Intent intent = new Intent(this, ViewTaskActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pending = PendingIntent.getActivity(this,0, intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NotificationChannel.DEFAULT_CHANNEL_ID)
                .setSmallIcon(R.drawable.p_square)
                .setContentTitle("Upcoming Task")
                .setContentText(title)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pending)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(currNotification, builder.build());
        currNotification++;
    }
}