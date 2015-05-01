package bohac.matej.temperatureconverter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText _text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _text = (EditText)findViewById(R.id.editText1);
    }

    public void onClickCalculate(View view){
        switch (view.getId()){
            case R.id.button1:
                RadioButton radioButton1 = (RadioButton)findViewById(R.id.radio0);
                RadioButton radioButton2 = (RadioButton)findViewById(R.id.radio1);
                ImageView imageView = (ImageView) findViewById(R.id.myIcon);

                if(_text.getText().length() == 0){
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                    return;
                }

                float inputValue = Float.parseFloat(_text.getText().toString());
                if(radioButton1.isChecked()){
                    _text.setText(String.valueOf(ConvertUtil.convertCelsiusToFahrenheit(inputValue)));
                    radioButton1.setChecked(false);
                    radioButton2.setChecked(true);
                    imageView.setImageResource(R.drawable.assigned);
                }
                else{
                    _text.setText(String.valueOf(ConvertUtil.convertFahrenheitToCelsius(inputValue)));
                    radioButton2.setChecked(false);
                    radioButton1.setChecked(true);
                    imageView.setImageResource(R.drawable.initial);
                }
                break;
            case R.id.button2:
                Intent intent = new Intent(this, ScrollActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
