package me.lukeoltmanns.calfmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class AddCalf extends AppCompatActivity {
    // Local variables
    String id;
    String name;
    String birth;
    String mother;
    String breed;
    String weight;
    String milk = "2.0";
    String health = "Healthy";

    Boolean addCalf = true;

    int incrementMilk;

    EditText idInput;
    EditText nameInput;
    EditText birthInput;
    EditText motherInput;
    EditText breedInput;
    EditText weightInput;

    static CounterStore count = new CounterStore();
    static ArrayList<Calf>stringArrayList = new ArrayList<>();
    static Calf calf[] = new Calf[100];
    static MilkAmount milkAmount = new MilkAmount();

    int counter = count.getCounter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calf);

        incrementMilk = milkAmount.getLevelOne();

        // Text from use is being read here
        idInput = (EditText) findViewById(R.id.idEditText);
        nameInput = (EditText) findViewById(R.id.nameEditText);
        birthInput = (EditText) findViewById(R.id.birthEditText);
        motherInput = (EditText) findViewById(R.id.motherEditText);
        breedInput = (EditText) findViewById(R.id.breedEditText);
        weightInput = (EditText) findViewById(R.id.weightEditText);
    }

    public void onAddCalfButtonClicked(View view){
        // Loop that accounts for all objects that have not been initialized
        // in the calf array object
        for(int i = 99; i > counter; i--){
            id = "0";
            calf[i] = new Calf();
            calf[i].setId(id);
        }

        // Local variables
        calf[counter] = new Calf();
        addCalf = true;

        // The calf object's ID is being set and validated here
        id = idInput.getText().toString();
        if (id.trim().length() > 0 && id.trim().length() <= 7 && id != null){
            calf[counter].setId(id);
        } else {
            calf[counter].setId("0");
            addCalf = false;
        }

        // The calf object's NAME is being set and validated here
        name = nameInput.getText().toString();
        if (name.trim().length() > 0 && name.trim().length() <= 20 && name != null){
            calf[counter].setName(name);
        } else {
            addCalf = false;
        }

        // The calf object's BIRTH is being set and validated here
        birth = birthInput.getText().toString();
        if (birth.trim().length() > 0 && birth.trim().length() <= 10 && birth != null){
            calf[counter].setBirth(birth);
        } else {
            addCalf = false;
        }

        // The calf object's MOTHER is being set and validated here
        mother = motherInput.getText().toString();
        if (mother.trim().length() > 0 && mother.trim().length() <= 7 && mother != null){
            calf[counter].setMother(mother);
        } else {
            addCalf = false;
        }

        // The calf object's BREED is being set and validated here
        breed = breedInput.getText().toString();
        if (breed.trim().length() > 0 && breed.trim().length() <= 30 && breed != null){
            calf[counter].setBreed(breed);
        } else {
            addCalf = false;
        }

        // The calf object's WEIGHT is being set and validated here
        weight = weightInput.getText().toString();
        if (weight.trim().length() > 0 && weight.trim().length() <= 3 && weight != null){
            calf[counter].setWeight(weight);
        } else {
            addCalf = false;
        }

        // If statement works if all of the calf object's validations are all met (true)
        // The calf object's MILK LEVEL and HEALTH STATUS are being here
        // The calf object will be added to a String Array List if If statement runs
        if(addCalf == true){
            calf[counter].setMilk(milk);
            calf[counter].setHealth(health);

            stringArrayList.add(calf[counter]);

            counter++;
            incrementMilk++;

            milkAmount.setLevelOne(incrementMilk);
            count.setCounter(counter);
        }

        // All text will be cleared
        idInput.getText().clear();
        nameInput.getText().clear();
        birthInput.getText().clear();
        motherInput.getText().clear();
        breedInput.getText().clear();
        weightInput.getText().clear();
    }

    public static Intent passCalfIntent(Intent intent){
        // calf object and milkAmount object are passed between activities
        intent.putExtra("id", calf);
        intent.putExtra("milk", milkAmount);
        return intent;
    }

    public static Intent passIntent(Intent intent){
        // stringArrayList is passed between activities
        return intent.putExtra( "stringarray",stringArrayList);
    }

    public void onAddCalfBackButtonClicked(View view){
        // activity_main_menu starts when addCalfBackButton is selected
        startActivity(new Intent(AddCalf.this, MainMenu.class));
    }
}