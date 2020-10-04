package co.edu.uac.munir.calculatorApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_0,button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_mas,button_menos,button_por,button_div,button_sqrt,button_inv,button_c,button_equals;
    EditText dato;
    long acum=0;
    String operador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0 = (Button) findViewById(R.id.button_0);
        button_0.setOnClickListener(this);
        button_1= findViewById(R.id.buttton_1);
        button_1.setOnClickListener(this);
        button_2= findViewById(R.id.button_2);   button_2.setOnClickListener(this);
        button_3= findViewById(R.id.button_3);   button_3.setOnClickListener(this);
        button_4= findViewById(R.id.button_4);   button_4.setOnClickListener(this);
        button_5= findViewById(R.id.button_5);    button_5.setOnClickListener(this);
        button_6= findViewById(R.id.button_6);  button_6.setOnClickListener(this);
        button_7= findViewById(R.id.button_7);  button_7.setOnClickListener(this);
        button_8= findViewById(R.id.button_8);  button_8.setOnClickListener(this);
        button_9= findViewById(R.id.button_9);  button_9.setOnClickListener(this);
        button_mas= findViewById(R.id.button_mas);   button_mas.setOnClickListener(this);
        button_menos= findViewById(R.id.button_menos);   button_menos.setOnClickListener(this);
        button_por= findViewById(R.id.button_por);    button_por.setOnClickListener(this);
        button_div= findViewById(R.id.button_div);    button_div.setOnClickListener(this);
        button_sqrt= findViewById(R.id.button_sqrt);    button_sqrt.setOnClickListener(this);
        button_inv= findViewById(R.id.button_inv);    button_inv.setOnClickListener(this);
        button_equals= findViewById(R.id.button_equals);   button_equals.setOnClickListener(this);
        button_c= findViewById(R.id.button_c);    button_c.setOnClickListener(this);
        dato= findViewById(R.id.edtdato);
       // dato.setText("0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        String valor;
        double num=0;
          if(!TextUtils.isEmpty(dato.getText().toString())) {
              num = Double.parseDouble(dato.getText().toString());
              valor=dato.getText().toString();
          }
          else{
           valor="";
          }
            switch(v.getId()) {
                case R.id.button_0:
                    if (num != 0) {
                        valor = valor + "0";
                        dato.setText(valor);
                    }

                    break;

                case R.id.buttton_1:
                    valor = valor + "1";
                    dato.setText(valor);
                    break;

                case R.id.button_2:
                    valor = valor + "2";
                    dato.setText(valor);
                    break;

                case R.id.button_3:
                    valor = valor + "3";
                    dato.setText(valor);
                    break;

                case R.id.button_4:
                    valor = valor + "4";
                    dato.setText(valor);
                    break;

                case R.id.button_5:
                    valor = valor + "5";
                    dato.setText(valor);
                    break;

                case R.id.button_6:
                    valor = valor + "6";
                    dato.setText(valor);
                    break;

                case R.id.button_7:
                    valor = valor + "7";
                    dato.setText(valor);
                    break;

                case R.id.button_8:
                    valor = valor + "8";
                    dato.setText(valor);
                    break;

                case R.id.button_9:
                    valor = valor + "9";
                    dato.setText(valor);
                    break;


                case R.id.button_mas:

                        acum = Integer.parseInt(dato.getText().toString());
                        dato.setText("");
                        operador = button_mas.getText().toString();

                    break;


                case R.id.button_menos:

                        acum = Integer.parseInt(dato.getText().toString());
                        dato.setText("");
                        operador = button_menos.getText().toString();
                    break;

                case R.id.button_por:
                        acum = Integer.parseInt(dato.getText().toString());
                        dato.setText("");
                        operador = button_por.getText().toString();
                    break;

                case R.id.button_div:
                        acum = Integer.parseInt(dato.getText().toString());
                        dato.setText("");
                        operador = button_div.getText().toString();
                    break;

                case R.id.button_sqrt:
                    double sqrt = Math.sqrt(Double.parseDouble(dato.getText().toString()));
                    dato.setText(String.valueOf(sqrt));
                    break;

                case R.id.button_inv:

                    int numero = invertido(Integer.parseInt(dato.getText().toString()));
                    dato.setText(String.valueOf(numero));

                    break;

                case R.id.button_equals:
                    if (operador.equals("+")){
                        dato.setText(acum + Integer.parseInt(dato.getText().toString()) + "");
                    acum = acum + Integer.parseInt(dato.getText().toString());
                    }else if (operador.equals("-")){
                        dato.setText(acum - Integer.parseInt(dato.getText().toString()) + "");
                        acum = acum - Integer.parseInt(dato.getText().toString());
                    }else if (operador.equals("*")){
                        dato.setText(acum * Integer.parseInt(dato.getText().toString()) + "");
                        acum = acum * Integer.parseInt(dato.getText().toString());
                    }else if (operador.equals("/")){
                        dato.setText(acum / Integer.parseInt(dato.getText().toString()) + "");
                        acum = acum / Integer.parseInt(dato.getText().toString());
                    }
                   break;

                case R.id.button_c:
                    if (button_sqrt.equals("SQRT")){
                        acum =0;
                        dato.setText("");
                    }else {
                        operador = "";
                        acum = 0;
                        dato.setText("");
                    }
                     break;

        }
    }

    private int invertido(int n) {
        int num = 0;

        while(n > 0) {
            num = num*10 + n%10;
            n /= 10;
        }
        return num;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mnupaises:
                Intent i = new Intent(this,ListaPaises.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
