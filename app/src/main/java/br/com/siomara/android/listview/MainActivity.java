package br.com.siomara.android.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lstViewCountry;

    /*
    Prefer to populate the list with the countries declared in the strings file, as shown below.
    private String[] countries = {
            "Afghanistan", "Albania", "Algeria", "Andorra", "Bahamas", "Bahrain", "Bangladesh",
            "Barbados", "Cambodia", "Canada", "Chile", "China", "Denmark", "Djibouti", "Ecuador",
            "Egypt", "Estonia", "Ethiopia", "Finland", "France", "Georgia", "Germany", "Greece"
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstViewCountry = findViewById(R.id.listViewCountry);

        // Fills the list with countries stored on string-array of strings.xml file.
        // To fill the list with countries stored on the array above, comment out the
        // line below and uncomment the lines that define the array countries above.
        String[] countries = getResources().getStringArray(R.array.countriesOnStrings);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                countries
        );

        // The next lines add a header and a footer to the list. If not desired just remove them.
        LayoutInflater layoutInflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) layoutInflater.inflate(R.layout.listview_header, lstViewCountry, false);
        lstViewCountry.addHeaderView(header);
        ViewGroup footer = (ViewGroup) layoutInflater.inflate(R.layout.listview_footer, lstViewCountry, false);
        lstViewCountry.addFooterView(footer);

        lstViewCountry.setAdapter(arrayAdapter);

        lstViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) lstViewCountry.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
