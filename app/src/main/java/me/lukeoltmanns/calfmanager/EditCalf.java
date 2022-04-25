package me.lukeoltmanns.calfmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static me.lukeoltmanns.calfmanager.AddCalf.calf;
import static me.lukeoltmanns.calfmanager.AddCalf.milkAmount;

public class EditCalf extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // Local variables
    Spinner idItems;
    Spinner milkItems;
    Spinner healthItems;

    int position;

    String milkText;
    String healthText;

    String levelOne = "2.0";
    String levelTwo = "2.5";
    String levelThree = "3.0";
    String noMilk = "0.0";

    int levelOneCounter = milkAmount.getLevelOne();
    int levelTwoCounter = milkAmount.getLevelTwo();
    int levelThreeCounter = milkAmount.getLevelThree();
    int noMilkCounter = milkAmount.getNoMilk();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_calf);

        // calf array object is gathered here
        Calf calf[] = (Calf[]) getIntent().getSerializableExtra("id");

        // idSpinner is created and being initialized
        // ID's from calf array object are added to the idSpinner
        // For loop runs to only add ID's the spinner and nothing more
        List<String> idSpinnerArray =  new ArrayList<>();
        idSpinnerArray.add(0,"Select Calf");
        for(int i = 0; i < calf.length; i++){
            if(calf[i].getId().equals("0")){
                break;
            } else {
                idSpinnerArray.add(calf[i].getId());
            }
        }

        // idSpinner modifications to view calf IDs
        ArrayAdapter<String> idAdapter = new ArrayAdapter<String>(EditCalf.this, android.R.layout.simple_spinner_item, idSpinnerArray);
        idAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idItems = (Spinner) findViewById(R.id.idSpinner);
        idItems.setAdapter(idAdapter);
        idItems.setOnItemSelectedListener(this);


        // milkAmountSpinner is created and being initialized
        List<String> milkSpinnerArray =  new ArrayList<String>();
        milkSpinnerArray.add(0,"Edit Milk Level");
        milkSpinnerArray.add(levelOne);
        milkSpinnerArray.add(levelTwo);
        milkSpinnerArray.add(levelThree);
        milkSpinnerArray.add(noMilk);

        // milkAmountSpinner modifications to view calf milk levels
        ArrayAdapter<String> milkAdapter = new ArrayAdapter<String>(EditCalf.this, android.R.layout.simple_spinner_item, milkSpinnerArray);
        milkAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        milkItems = (Spinner) findViewById(R.id.milkAmountSpinner);
        milkItems.setAdapter(milkAdapter);
        milkItems.setOnItemSelectedListener(this);


        // healthStatusSpinner is created and being initialized
        List<String> healthSpinnerArray =  new ArrayList<String>();
        healthSpinnerArray.add(0,"Edit Health Status");
        healthSpinnerArray.add("Healthy");
        healthSpinnerArray.add("Okay");
        healthSpinnerArray.add("Sick");

        // healthStatusSpinner modifications to view calf health status
        ArrayAdapter<String> healthAdapter = new ArrayAdapter<String>(EditCalf.this, android.R.layout.simple_spinner_item, healthSpinnerArray);
        healthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        healthItems = (Spinner) findViewById(R.id.healthStatusSpinner);
        healthItems.setAdapter(healthAdapter);
        healthItems.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // A specific position determined from the calf idSpinner is captured
        // to make milk level and health status edits to that specific calf
        if(adapterView.getId() == R.id.idSpinner){
            position = i - 1;
            // milkAmountSpinner and healthStatusSpinner are only visible ones
            // an ID from the idSpinner is selected
            if(position >= 0){
                findViewById(R.id.milkAmountSpinner).setVisibility(View.VISIBLE);
                findViewById(R.id.healthStatusSpinner).setVisibility(View.VISIBLE);
            }
        }

        // Switch statement makes sure that the proper edits are being made when
        // a certain spinner is selected
        switch(adapterView.getId()){
            case R.id.milkAmountSpinner:
                milkText = adapterView.getItemAtPosition(i).toString();
                break;
            case R.id.healthStatusSpinner:
                healthText = adapterView.getItemAtPosition(i).toString();
                break;
            default:
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    public void onDoneButtonClicked(View view){
        // if statement only works if the selection "Select Calf" is not selected
        if(idItems.equals("Select Calf")){
        }else{
            // if statement only works if the selection "Edit Milk Level" is not selected
            if(milkText.equals("Edit Milk Level")){
            } else {
                // Milk Amounts are altered accordingly depending on milkAmountSpinner selection
                if (milkText.equals(levelOne)) {
                    levelOneCounter++;
                    MilkAmountEqualizer();
                    milkAmount.setLevelOne(levelOneCounter);
                } else if (milkText.equals(levelTwo)) {
                    levelTwoCounter++;
                    MilkAmountEqualizer();
                    milkAmount.setLevelTwo(levelTwoCounter);
                } else if (milkText.equals(levelThree)) {
                    levelThreeCounter++;
                    MilkAmountEqualizer();
                    milkAmount.setLevelThree(levelThreeCounter);
                } else if (milkText.equals(noMilk)) {
                    noMilkCounter++;
                    MilkAmountEqualizer();
                    milkAmount.setNoMilk(noMilkCounter);
                }
                calf[position].setMilk(milkText);
            }
            // if statement only works if the selection "Edit Health Status" is not selected
            if(healthText.equals("Edit Health Status")){
            } else {
                calf[position].setHealth(healthText);
            }
        }
        // activity_temp starts when doneButton is selected
        startActivity(new Intent(EditCalf.this, Temp.class));
    }

    public void MilkAmountEqualizer(){
        // Milk Amounts are altered accordingly depending on milkAmountSpinner selection
        if(calf[position].getMilk().equals(levelOne)){
            levelOneCounter--;
            milkAmount.setLevelOne(levelOneCounter);
        } else if (calf[position].getMilk().equals(levelTwo)){
            levelTwoCounter--;
            milkAmount.setLevelTwo(levelTwoCounter);
        } else if (calf[position].getMilk().equals(levelThree)){
            levelThreeCounter--;
            milkAmount.setLevelThree(levelThreeCounter);
        } else if (calf[position].getMilk().equals(noMilk)){
            noMilkCounter--;
            milkAmount.setNoMilk(noMilkCounter);
        }
    }

    public static Intent passCalfMilkIntent(Intent intent){
        // calf object and milkAmount object are passed between activities
        intent.putExtra("id", calf);
        intent.putExtra("milk", milkAmount);
        return intent;
    }

    public void onEditCalfBackButtonClicked(View view){
        // activity_main_menu starts when editCalfBackButton is selected
        startActivity(new Intent(EditCalf.this, MainMenu.class));
    }
}