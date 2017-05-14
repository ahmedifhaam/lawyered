package com.mit.lawyered.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.firebase.SaveLawBrokenController;
import com.mit.lawyered.models.Law;

public class DialogActivity extends Activity {

    EditText msg;
    Law law;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button dismiss = (Button) findViewById(R.id.btnDismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button send = (Button) findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //put your code here to send the message
                msg = (EditText)findViewById(R.id.dialogMessage);
                String message = msg.getText().toString();
                process(message);
                finish();
            }
        });

        law = (Law)getIntent().getExtras().get("LAW");

    }

    private void process(String desc){
        if(law!=null){
            Toast.makeText(getApplicationContext(),"Law with id "+law.getLawId()+"has been broken ("+desc+")",Toast.LENGTH_LONG).show();
            SaveLawBrokenController contrl = new SaveLawBrokenController();
            contrl.saveLawBrokenNotification(law.getLawId(),desc);



        }

    }

}
