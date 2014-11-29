package edu.drake.project3b;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Images.Media;
import android.support.v7.app.ActionBarActivity;
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
	
	public void openShare(View view){
		//Bitmap icon = mBitmap;
		Intent share = new Intent(Intent.ACTION_SEND);
		share.setType("image/jpeg");

		ContentValues values = new ContentValues();
		values.put(Images.Media.TITLE, "title");
		values.put(Images.Media.MIME_TYPE, "image/jpeg");
		Uri uri = getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,
		        values);


		OutputStream outstream;
		try {
		    outstream = getContentResolver().openOutputStream(uri);
		    //icon.compress(Bitmap.CompressFormat.JPEG, 100, outstream);
		    outstream.close();
		} catch (Exception e) {
		    System.err.println(e.toString());
		}

		share.putExtra(Intent.EXTRA_STREAM, uri);
		startActivity(Intent.createChooser(share, "Share Image"));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
				// setup action bar for tabs
				ActionBar actionBar = getActionBar();
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				actionBar.setDisplayShowTitleEnabled(true);

				Tab tab = actionBar.newTab()
						.setText(R.string.action_fave)
						.setTabListener(new TabListener<FaveFragment>(
								this, "this month", FaveFragment.class));
				actionBar.addTab(tab);

				Tab tab1 = actionBar.newTab()
						.setText(R.string.action_today)
						.setTabListener(new TabListener<TodayFragment>(
								this, "today", TodayFragment.class));
				actionBar.addTab(tab1);
				
				Tab tab2 = actionBar.newTab()
						.setText(R.string.action_week)
						.setTabListener(new TabListener<WeekFragment>(
								this, "this week", WeekFragment.class));
				actionBar.addTab(tab2);
				actionBar.selectTab(tab1);
		
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
		
		
		SimpleDateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
		String date = df.format(dayOfYear.getTime());
		setTitle(date);
	}
	
	public static class TabListener<T extends Fragment> implements android.app.ActionBar.TabListener {
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;

		/** Constructor used each time a new tab is created.
		 * @param activity  The host Activity, used to instantiate the fragment
		 * @param tag  The identifier tag for the fragment
		 * @param clz  The fragment's Class, used to instantiate the fragment
		 */
		public TabListener(Activity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}

		/* The following are each of the ActionBar.TabListener callbacks */

		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Check if the fragment is already initialized
			if (mFragment == null) {
				// If not, instantiate and add it to the activity
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(mFragment);
			}
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(mFragment);
			}
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// User selected the already selected tab. Usually do nothing.
		}
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
