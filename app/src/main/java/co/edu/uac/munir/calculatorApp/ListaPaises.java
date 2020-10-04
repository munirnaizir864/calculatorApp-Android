package co.edu.uac.munir.calculatorApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class ListaPaises extends AppCompatActivity {

    ListView listapaises;
    LinkedList<String> country = new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        country.add("Usa");
        country.add("Panamá");
        country.add("Peru");
        country.add("Brasil");
        country.add("Chile");
        country.add("Colombia");
        listapaises = findViewById(R.id.lstpaises);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country);
        listapaises.setAdapter(adapter);

        listapaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Pais : " + (country.get(position)),Toast.LENGTH_LONG).show();
            }
        });

    }


}
