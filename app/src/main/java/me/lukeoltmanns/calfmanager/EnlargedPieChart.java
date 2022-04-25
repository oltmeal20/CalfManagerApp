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

public class EnlargedPieChart extends AppCompatActivity {
    // Local variables
    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();

    int levelOne ;
    int levelTwo ;
    int levelThree ;
    int noMilk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarged_pie_chart);

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
        pieEntryList.add(new PieEntry(levelOne,"2.0 Liters"));
        pieEntryList.add(new PieEntry(levelTwo,"2.5 Liters"));
        pieEntryList.add(new PieEntry(levelThree,"3.0 Liters"));
        pieEntryList.add(new PieEntry(noMilk,"No Milk"));
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"");
        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(25f);
        pieChart.setData(pieData);
        pieChart.getDescription().setText("Milk Amount");
        pieChart.getDescription().setTextSize(20f);
        pieChart.invalidate();
    }

    public void onEnlargedPieChartBackButtonClicked(View view){
        // activity_main_menu starts when enlargedPieChartBackButton is selected
        startActivity(new Intent(EnlargedPieChart.this, MainMenu.class));
    }
}