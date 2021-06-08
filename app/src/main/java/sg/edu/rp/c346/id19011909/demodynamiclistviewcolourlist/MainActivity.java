package sg.edu.rp.c346.id19011909.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creating Variable,
    EditText etElement;
    Button btnAdd;
    Button btnDel;
    Button btnUp;
    ListView lvColour;
    EditText etIndexElement;

    ArrayList<String> alColours;
    String Data = "";
    int pos = 0;
    String colour = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking Variable,
        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnUp = findViewById(R.id.buttonUpdateItem);
        btnDel = findViewById(R.id.buttonRemoveItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        //Setting Action {ArrayList},
        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        //Linking ArrayAdapter,
        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        //Button Action {Adding},
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data = etElement.getText().toString();
                pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, Data);
                aaColour.notifyDataSetChanged();
            }
        });

        //Button Action {Remove},
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        //Button Action {Update},
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data = etElement.getText().toString();
                pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, Data);
                aaColour.notifyDataSetChanged();
            }
        });

        //ItemList Action,
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();

            }
        });

    }

}