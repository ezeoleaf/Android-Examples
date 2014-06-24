package com.example.android_examples;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Form extends Activity implements View.OnClickListener{
	
	EditText etUsuario, etPassword;
	Button bEnviar;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
		
		etUsuario = (EditText) findViewById(R.id.etUsuario);
		etPassword = (EditText) findViewById(R.id.etPassword);
		bEnviar = (Button) findViewById(R.id.bEnviar);
		
		bEnviar.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bEnviar:
			if(etUsuario.getText().toString().equals("max") && etPassword.getText().toString().equals("1234"))
			{
				Toast.makeText(Form.this, "Login Correcto!", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(Form.this, "Login Incorrecto, intentalo de nuevo...", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}
}
