package me.lukeoltmanns.calfmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class InfoList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        // calf object is gathered here and displayed as an arrayList
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ArrayList<String>arrayList = bundle.getStringArrayList("stringarray");
            ListView listView = findViewById(R.id.infoList);
            ArrayAdapter<String> items = new ArrayAdapter<>(InfoList.this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(items);
        }
    }

    public void onInfoListBackButtonClicked(View view){
        // activity_main_menu starts when infoListBackButton is selected
        startActivity(new Intent(InfoList.this, MainMenu.class));
    }
}