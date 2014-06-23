package com.example.android_examples;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
	
	String classes[] = {"Calculadora", "Item1","Item2","Item3","Item4","Item5","Item6"};
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selClass = classes[position];
		try{
			Class ourClass = Class.forName("com.example.android_examples." + selClass);
			Intent ourIntent = new Intent(MainActivity.this, ourClass);
			startActivity(ourIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
}
