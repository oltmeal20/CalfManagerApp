/*************************************************************************************************
 *  Title:          Calf Manger
 *
 *  Creator:        Luke Oltmanns
 *  Class:          Comp Sci 292
 *  Date:           12/9/2020
 *  Objective:      Final Project
 *  Description:    This is a mobile application that manages calves in an organized matter
 *                  This application allows the user to add, edit, and view calf information
 *
 *************************************************************************************************/
package me.lukeoltmanns.calfmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

import static me.lukeoltmanns.calfmanager.AddCalf.milkAmount;

public class MainMenu extends AppCompatActivity {
    // Local variables
    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();

    int levelOne;
    int levelTwo;
    int levelThree;
    int noMilk;

    int numberOfCalves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Instantiation of milk levels derived from MilkAmount object
        levelOne = milkAmount.getLevelOne();
        levelTwo = milkAmount.getLevelTwo();
        levelThree = milkAmount.getLevelThree();
        noMilk = milkAmount.getNoMilk();

        // Pie Chart to view MilkAmount object
        pieChart = findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(false);
        Legend legend = pieChart.getLegend();
        legend.setTextSize(19f);
        pieEntryList = new ArrayList<>();
        pieEntryList.add(new PieEntry(levelOne));
        pieEntryList.add(new PieEntry(levelTwo));
        pieEntryList.add(new PieEntry(levelThree));
        pieEntryList.add(new PieEntry(noMilk));
        PieDataSet pieDataSet = new PieDataSet(pieEntryList, "");
        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(20f);
        pieChart.setData(pieData);
        pieChart.getDescription().setText("Milk Amount");
        pieChart.getDescription().setTextSize(15f);
        pieChart.invalidate();

        // editMainMenuButton, infoListMainMenuButton, and enlargeButton be enabled
        // as long as at least one calf is added from activity_add_calf
        numberOfCalves = levelOne + levelTwo + levelThree + noMilk;

        if(numberOfCalves > 0){
            findViewById(R.id.editMainMenuButton).setEnabled(true);
            findViewById(R.id.listMainMenuButton).setEnabled(true);
            findViewById(R.id.enlargeButton).setEnabled(true);
        } else {
            findViewById(R.id.editMainMenuButton).setEnabled(false);
            findViewById(R.id.listMainMenuButton).setEnabled(false);
            findViewById(R.id.enlargeButton).setEnabled(false);
        }
    }

    public void onInfoListActivityClicked(View view){
        // activity_info_list starts when infoListButton is selected
        Intent intent = (new Intent(MainMenu.this, InfoList.class));
        intent = AddCalf.passIntent(intent);
        intent = EditCalf.passCalfMilkIntent(intent);
        startActivity(intent);
    }

    public void onEditCalfActivityClicked(View view){
        // activity_edit_calf starts when editCalfButton is selected
        Intent intent = new Intent(MainMenu.this, EditCalf.class);
        intent = AddCalf.passCalfIntent(intent);
        startActivity(intent);
    }

    public void onAddCalfActivityClicked(View view){
        // activity_add_calf starts when addCalfButton is selected
        startActivity(new Intent(MainMenu.this, AddCalf.class));
    }

    public void onEnlargedPieChartActivityClicked(View view){
        // activity_enlarged_pie_chart starts when enlargedPieChartButton is selected
        startActivity(new Intent(MainMenu.this, EnlargedPieChart.class));
    }
}