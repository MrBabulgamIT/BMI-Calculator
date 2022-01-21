package com.babulgamit.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText feetEditText,inchesEditText,weightEditText,nameEditText,ageEditText;
    double weight,height;
    private double bmifemale = 0;
    private double name;
    private double bmi = 0;
    private double bmimale = 0;
    private double valuefeet = 0;
    private double valueinches = 0;
    private double valueweight = 0;
    private Button bmiButton,reastButton;
    private TextView textView;
    private RadioGroup gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feetEditText=findViewById(R.id.feetET_id);
        inchesEditText=findViewById(R.id.inchesET_id);
        weightEditText=findViewById(R.id.weightET_id);
        nameEditText=findViewById(R.id.nameEditText);
        ageEditText=findViewById(R.id.ageET_id);
        bmiButton=findViewById(R.id.testButton_id);
        reastButton=findViewById(R.id.restButton_id);
        textView=findViewById(R.id.resultTextView_id);

        gender=findViewById(R.id.gendergroup);


        bmiButton.setOnClickListener(this);
        reastButton.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {



        if (v.getId()==R.id.testButton_id){

            if (all_fill()){


                calculation();



            }
            else
            {
                Toast.makeText(this, "Please Fill all Information !!", Toast.LENGTH_LONG).show();

            }


        }else


        if (v.getId()==R.id.restButton_id)
        {
            nameEditText.setText("");
            feetEditText.setText("");
            inchesEditText.setText("");
            weightEditText.setText("");
            ageEditText.setText("");
            textView.setText("");
            gender.clearCheck();

        }

    }


    private void calculation(){

        valuefeet =Double.parseDouble(feetEditText.getText().toString());
        valueinches =Double.parseDouble(inchesEditText.getText().toString());
        String nametr=nameEditText.getText().toString();

        valueweight =Double.parseDouble(weightEditText.getText().toString());
        Double valueheightmeters;
        Double valueheight;



        valueheight=(((valuefeet*12)+valueinches)*2.54);  // Converting to Centimeters.
        valueheightmeters = valueheight / 100;           // Converting to meters.
        bmi = (valueweight / (valueheightmeters * valueheightmeters));
/*
        Intent intent=new Intent(this,Output.class);
        intent.putExtra("bmiResult",bmi);
        intent.putExtra("name",nametr);
        startActivity(intent);
        */

        if (bmi<18.49){

            textView.setText("Your BMI : " + String.format("%.2f", bmi) + "\nYour BMI Test Position under Wight" );

        }
        else
        if (bmi>=18.5&&bmi<24.9){

            textView.setText("Your BMI : " + String.format("%.2f", bmi) + "\nYour BMI Test Position Normal" );

        }
        else
        if (bmi>=25&&bmi<29.9){

            textView.setText("Your BMI : " + String.format("%.2f", bmi)  + "\nYour BMI Test Position Over Wight" );

        }
        else

        {
            textView.setText("Your BMI : " + String.format("%.2f", bmi)  + "\nYour BMI Test Position Obesity" );
        }

    }

    boolean all_fill() {

        if (nameEditText.getText().toString().isEmpty() || ageEditText.getText().toString().isEmpty() || feetEditText.getText().toString().isEmpty() || inchesEditText.getText().toString().isEmpty() || weightEditText.getText().toString().isEmpty() || gender.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            return true;
        }

    }


}




