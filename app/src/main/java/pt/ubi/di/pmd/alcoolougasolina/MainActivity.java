package pt.ubi.di.pmd.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool,editGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAlcool         = findViewById(R.id.editAlcool);
        editGasolina       = findViewById(R.id.editGasolina);
        resultado          = findViewById(R.id.resultado);
    }

    public void calcular(View view){
      String precoAlcool =  editAlcool.getText().toString();
      String precoGasolina =  editGasolina.getText().toString();

      Boolean result = validarCampos(precoAlcool,precoGasolina);
      if(result){
          Double valorAlcool = Double.parseDouble(precoAlcool);
          Double valorGasolina = Double.parseDouble(precoGasolina);
          if ((valorAlcool/valorGasolina)>=0.7){
            resultado.setText("Utilize Gasolina");
          } else {
              resultado.setText("Utilize Alcool");
          }

      }else{
          resultado.setText("Preencha os campos corretamente!");
      }
    }
    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if (pAlcool == "null" || pAlcool.equals("")){
            camposValidados = false;
        }else if (pGasolina == "null" || pGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;

    }
}
