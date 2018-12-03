package com.mycompany.giftiplinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartScreen extends AppCompatActivity {
    public final static String EXTRA_MESSAGE="com.mycompany.giftiplinear.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void sendAmount(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText)findViewById(R.id.introText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
