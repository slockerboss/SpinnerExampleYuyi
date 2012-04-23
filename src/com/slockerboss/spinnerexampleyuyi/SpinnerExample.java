package com.slockerboss.spinnerexampleyuyi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerExample extends Activity {

	private Button btnEnviarForm, btnMostrar;
	private TextView textViewPruebaBorrar;
	private EditText editTextNombre;

	private Spinner spinnerPlanetas, spinnerOperaciones;
	String []operaciones={"Sumar","Restar","Multiplicar","Dividir"};
	private ArrayAdapter<CharSequence> adapter1, adapter2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);

		textViewPruebaBorrar = (TextView) findViewById(R.id.TextViewPrueba);

		spinnerPlanetas = (Spinner) findViewById(R.id.SpinnerPlanetas);
		
		

		adapter1 = ArrayAdapter.createFromResource(this, R.array.planets_array,
				android.R.layout.simple_spinner_item);
		
		//Style
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//Spinner necesita un adapter, aqui se lo das
		spinnerPlanetas.setAdapter(adapter1);
		
		
		spinnerOperaciones = (Spinner) findViewById(R.id.SpinnerOperaciones);
		adapter2 = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, operaciones);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerOperaciones.setAdapter(adapter2);
		
		btnMostrar = (Button) findViewById(R.id.BotonMostrar);
		btnMostrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				textViewPruebaBorrar.setText("");
				textViewPruebaBorrar.append(spinnerPlanetas.getSelectedItem()
						.toString()+"\n");
				textViewPruebaBorrar.append(spinnerOperaciones.getSelectedItem()
						.toString());

			}
		});
	}

}