package incorporate.games.avon.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;



public class MainActivity extends AppCompatActivity {

    Button calcButton;
    EditText wInput;
    EditText hInput;
    TextView result;
    TextView flav;
    String low;
    String good;
    String over;
    String high;
    String error1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcButton = (Button) findViewById(R.id.calc);
        wInput = (EditText) findViewById(R.id.wInp);
        hInput = (EditText) findViewById(R.id.hInp);
        result = (TextView) findViewById(R.id.result);
        flav = (TextView) findViewById(R.id.flavour);

        low = getResources().getString(R.string.low);
        good = getResources().getString(R.string.good);
        over = getResources().getString(R.string.over);
        high = getResources().getString(R.string.high);
        error1 = getResources().getString(R.string.error1);

        calcButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {

                        if (!hInput.getText().toString().equals("") || !wInput.getText().toString().equals("")) {

                            double height = parseDouble(hInput.getText().toString());
                            double weight = parseDouble(wInput.getText().toString());

                            double res = weight / (height * height);

                            if (res < 18.5) {
                                flav.setText(low);
                            } else if (res >= 18.5 && res < 25) {
                                flav.setText(good);
                            } else if (res >= 25 && res < 30) {
                                flav.setText(over);
                            } else {
                                flav.setText(high);
                            }
                            result.setText(Double.toString(res));

                        } else {
                            flav.setText(error1);
                            result.setText("0");
                        }
                    }
                }
        );
    }
}
