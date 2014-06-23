package com.example.android_examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView tResult;
	Button bSumar, bRestar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tResult = (TextView) findViewById(R.id.tResult);
		bSumar = (Button) findViewById(R.id.bSumar);
		bRestar = (Button) findViewById(R.id.bRestar);
		
		tResult.setText("Probando!");
	}
}
