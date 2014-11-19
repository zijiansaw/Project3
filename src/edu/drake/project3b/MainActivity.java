package edu.drake.project3b;

import java.util.Calendar;
import java.util.Vector;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	ImageView dailyView;
	
	public void message(String message){
		Context context = getApplicationContext();
		CharSequence text = message;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	public void click(View view){
		Intent intent = new Intent(this,SecondActivity.class);
		startActivity(intent);
	}	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dailyView = (ImageView) findViewById(R.id.dailyView);
		int images[] = {getResources().getIdentifier("drawable/animal1", null, getPackageName()),
				getResources().getIdentifier("drawable/animal2", null, getPackageName()),
				getResources().getIdentifier("drawable/animal3", null, getPackageName()),
				getResources().getIdentifier("drawable/animal4", null, getPackageName()),
				getResources().getIdentifier("drawable/animal5", null, getPackageName()),
				getResources().getIdentifier("drawable/animal6", null, getPackageName()),
				getResources().getIdentifier("drawable/animal7", null, getPackageName()),
				getResources().getIdentifier("drawable/animal8", null, getPackageName()),
				getResources().getIdentifier("drawable/animal9", null, getPackageName()),
				getResources().getIdentifier("drawable/animal10", null, getPackageName()),
				getResources().getIdentifier("drawable/animal11", null, getPackageName()),
				getResources().getIdentifier("drawable/animal12", null, getPackageName()),
				getResources().getIdentifier("drawable/animal13", null, getPackageName()),
				getResources().getIdentifier("drawable/animal14", null, getPackageName())};
		
		Calendar dayOfYear = Calendar.getInstance();
		int currentDayOfYear = dayOfYear.get(Calendar.DAY_OF_YEAR);
		Toast.makeText(this, "Number of days : "+currentDayOfYear, Toast.LENGTH_SHORT).show();
		
		dailyView.setImageResource(images[currentDayOfYear-320]);
		dailyView.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
