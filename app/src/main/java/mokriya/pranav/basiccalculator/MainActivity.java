package mokriya.pranav.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//This is your main-activity this activity will be called when you launch your app. An app can contain multiple activities
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView result_tv;
    EditText et_1, et_2;
    Button add_bt, substract_bt, multiply_bt, divide_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this activity will show view present in this file
        setContentView(R.layout.activity_main);

        //finding the view by there ids and adding the functionality
        //click listener is added so that whenever user will tap on any button it will give a call onClick method with the corresponding id
        result_tv = (TextView) findViewById(R.id.result_tv);

        et_1 = (EditText) findViewById(R.id.et_1);
        et_2 = (EditText) findViewById(R.id.et_2);

        add_bt = (Button) findViewById(R.id.add_bt);
        add_bt.setOnClickListener(this);
        substract_bt = (Button) findViewById(R.id.substract_bt);
        substract_bt.setOnClickListener(this);
        multiply_bt = (Button) findViewById(R.id.multiply_bt);
        multiply_bt.setOnClickListener(this);
        divide_bt = (Button) findViewById(R.id.divide_bt);
        divide_bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        float result= 0.0f;

        switch (view.getId()){

            case R.id.add_bt:

                if(isValidNumber(et_1.getText().toString()) && isValidNumber(et_2.getText().toString())){
                    result = Float.parseFloat(et_1.getText().toString()) + Float.parseFloat(et_2.getText().toString());
                    result_tv.setText(result + "");
                }else{
                    pleaseEnterValidNumber();
                }

                break;

            case R.id.substract_bt:
                if(isValidNumber(et_1.getText().toString()) && isValidNumber(et_2.getText().toString())){
                    result = Float.parseFloat(et_1.getText().toString()) - Float.parseFloat(et_2.getText().toString());
                    result_tv.setText(result + "");
                }else{
                    pleaseEnterValidNumber();
                }

                break;

            case R.id.multiply_bt:
                if(isValidNumber(et_1.getText().toString()) && isValidNumber(et_2.getText().toString())){
                    result = Float.parseFloat(et_1.getText().toString()) * Float.parseFloat(et_2.getText().toString());
                    result_tv.setText(result + "");
                }else{
                    pleaseEnterValidNumber();
                }

                break;

            case R.id.divide_bt:

                if(isValidNumber(et_1.getText().toString()) && isValidNumber(et_2.getText().toString())){
                    result = Float.parseFloat(et_1.getText().toString()) / Float.parseFloat(et_2.getText().toString());
                    result_tv.setText(result + "");
                }else{
                    pleaseEnterValidNumber();
                }

                break;
        }
    }

    private void pleaseEnterValidNumber() {
        //Toast is a simple class which helps in showing any message
        Toast.makeText(getBaseContext(), "Please enter valid numbers", Toast.LENGTH_LONG).show();
    }


    private boolean isValidNumber(String number_string){

        try {
            Float.parseFloat(number_string);
        } catch(Exception e){
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
