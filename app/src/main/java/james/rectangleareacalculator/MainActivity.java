/**
 * @author James Markham 2018
 * james.markham@spintel.net.au
 */

package james.rectangleareacalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    /**
     * Calculates the area/perimeter based off the values entered in the application
     */
    public void calculateArea(View view) {

        System.out.println("Clicked!");

        // Get field data from view
        EditText heightText = (findViewById(R.id.heightInput));
        EditText widthText = (findViewById(R.id.widthInput));
        TextView perimeterText = (findViewById(R.id.perimeterOut));
        TextView areaText = (findViewById(R.id.areaOut));

        // Assign view data to string
        String strWidth = String.valueOf(widthText.getText());
        String strHeight = String.valueOf(heightText.getText());

        System.out.println("Converted!");

        if(strWidth.isEmpty()){
            perimeterText.setText(String.valueOf("Width Missing!"));
            areaText.setText(String.valueOf("Width Missing!"));
            return;
        } else if(strHeight.isEmpty()){
            perimeterText.setText(String.valueOf("Height Missing!"));
            areaText.setText(String.valueOf("Height Missing!"));
            return;
        }

        // Convert string to int
        Double width = Double.valueOf(strWidth);
        Double height = Double.valueOf(strHeight);

        // Calculate values for program
        Double area = width * height;
        Double perimeter = (width + height) * 2;

        // Update area value11
        areaText.setText(String.valueOf(area));

        // Update perimeter value
        perimeterText.setText(String.valueOf(perimeter));

    }

}
