package me.lukeoltmanns.calfmanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Temp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        // EditCalf is passed between activities
        // activity_edit_calf starts when doneButton is selected
        Intent intent = (new Intent(Temp.this, EditCalf.class));
        intent = EditCalf.passCalfMilkIntent(intent);
        startActivity(intent);
    }
}