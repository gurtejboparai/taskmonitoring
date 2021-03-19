package com.example.myapplication.presentation;
import android.app.Activity;
import android.app.AlertDialog;

public class Messages {

    public static void warning(Activity owner, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(owner).create();

        alertDialog.setTitle("warning");
        alertDialog.setMessage(message);

        alertDialog.show();
    }
}
