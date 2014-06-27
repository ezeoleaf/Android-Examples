package com.maxwell.android_examples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BundleSender extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView tvMessage = new TextView(this);
		//REVISAR POR QUE NO APARECE ESTE TEXTO
		tvMessage.setText("Esto es una Activity que contiene un Bundle!");
		setContentView(tvMessage);
		
		Bundle datos = new Bundle();
		datos.putString("data_1", "esto es un string");
		datos.putString("data_2", "esto es otro string");
		
		Intent i = new Intent(BundleSender.this,BundleReciver.class);
		i.putExtras(datos);
		startActivity(i);
	}

}
