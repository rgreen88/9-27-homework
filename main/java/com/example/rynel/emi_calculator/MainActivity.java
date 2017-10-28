package com.example.rynel.emi_calculator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    double ratePerYear, numOfYearlyInstallments, loanAmount, loanAmountConfig, total;
    String result = Double.toString(total);
    private EditText etLoanAmount;
    private TextView tvResult;
    private Button btnCalc;
    private EditText etAmountOfYears;
    private EditText etRateOfInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoanAmount = (EditText) findViewById(R.id.etLoanAmount);
        etRateOfInterest = (EditText) findViewById(R.id.etRateOfInterest);
        etAmountOfYears = (EditText) findViewById(R.id.etAmountOfYears);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void calcEMI(View view) {

        //display order: Loan Amount (et1), Rate of Interest(et2), Amount of Years(et3),
        //Button, Result (calculations)
        try {
            double loanAmount = Double.valueOf(etLoanAmount.getText().toString());
            double interestRate = Double.valueOf(etRateOfInterest.getText().toString());
            double timeInYears = Double.valueOf(etAmountOfYears.getText().toString());

            interestRate = interestRate / (12 * 100);
            timeInYears *= 12;

            double emi = (loanAmount * interestRate * Math.pow(1 + interestRate, timeInYears)) /
                    (Math.pow(1 + interestRate, timeInYears) - 1);

            String answer = String.valueOf(emi);
            tvResult.setText(answer);

        } catch (java.lang.NumberFormatException e ) {
            tvResult.setText( "Invalid input." );
        }
    }
}

