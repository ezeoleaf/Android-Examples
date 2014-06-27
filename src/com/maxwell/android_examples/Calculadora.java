package com.maxwell.android_examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends Activity implements View.OnClickListener{
	TextView tResult;
	Button bSumar, bRestar;
	int counter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculadora);
		
		tResult = (TextView) findViewById(R.id.tResult);
		bSumar = (Button) findViewById(R.id.bSumar);
		bRestar = (Button) findViewById(R.id.bRestar);
		counter = 0;
		
		bSumar.setOnClickListener(this);
		bRestar.setOnClickListener(this);
	}
	
	public void onClick(View v)
	{
		switch(v.getId()){
			case R.id.bSumar:
				counter++;
				break;
			case R.id.bRestar:
				counter--;
				break;
		}
		tResult.setText(String.valueOf(counter));
	}
}
