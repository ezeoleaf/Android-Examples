package com.example.android_examples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	String classes[] = {"SobreMi","Calculadora", "WeightSum","Camara","Form","BundleSender","GFX","GFXSurface"};
			
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

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.sobreMi:
			Intent i = new Intent("com.example.android_examples.ABOUT");
			startActivity(i);
			break;
		case R.id.preferencias:
			Intent e = new Intent("com.example.android_examples.PREFS");
			startActivity(e); 
			break;
		case R.id.exit:
			finish();
			break;	
		}
		return false;
	}
	
	
}
