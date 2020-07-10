package com.example.radiobuttonalertdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SingleChoiceDialog.SingleChoiceListener{

    private TextView tvDisplayChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvDisplayChoice = findViewById(R.id.tvDisplayChoice);

        Button btnSelectChoice = findViewById(R.id.btnSelectChoice);
        btnSelectChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment singleChoiceDialog = new SingleChoiceDialog();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(),"Single Choice Dialog");


            }
        });


    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        if(list[position].equals(2)){

        }
        tvDisplayChoice.setText("Selected Item = "+list[position]);
    }

    @Override
    public void onNegativeButtonClicked() {
         tvDisplayChoice.setText("dialog cancel");
    }
}
