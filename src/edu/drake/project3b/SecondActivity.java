package edu.drake.project3b;

import java.util.Calendar;
import java.util.Vector;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends ActionBarActivity {
	
	ImageView dailyView1,dailyView2,dailyView3,dailyView4,dailyView5,dailyView6,dailyView7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		dailyView1 = (ImageView) findViewById(R.id.imageView1);
		dailyView2 = (ImageView) findViewById(R.id.imageView2);
		dailyView3 = (ImageView) findViewById(R.id.imageView3);
		dailyView4 = (ImageView) findViewById(R.id.imageView4);
		dailyView5 = (ImageView) findViewById(R.id.imageView5);
		dailyView6 = (ImageView) findViewById(R.id.imageView6);
		dailyView7 = (ImageView) findViewById(R.id.imageView7);
		
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
		
		dailyView1.setImageResource(images[currentDayOfYear-320]);
		dailyView1.setVisibility(View.VISIBLE);
		dailyView2.setImageResource(images[currentDayOfYear-320]);
		dailyView2.setVisibility(View.VISIBLE);
		dailyView3.setImageResource(images[currentDayOfYear-320]);
		dailyView3.setVisibility(View.VISIBLE);
		dailyView4.setImageResource(images[currentDayOfYear-320]);
		dailyView4.setVisibility(View.VISIBLE);
		dailyView5.setImageResource(images[currentDayOfYear-320]);
		dailyView5.setVisibility(View.VISIBLE);
		dailyView6.setImageResource(images[currentDayOfYear-320]);
		dailyView6.setVisibility(View.VISIBLE);
		dailyView7.setImageResource(images[currentDayOfYear-320]);
		dailyView7.setVisibility(View.VISIBLE);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
