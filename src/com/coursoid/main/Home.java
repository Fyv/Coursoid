package com.coursoid.main;

import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class Home extends BaseListActivity implements OnNavigationListener {

	private TextView hello;
	private String[] activities;

	/**
	 * 
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hello = ((TextView) findViewById(R.id.hello));
		activities = getResources().getStringArray(R.array.mainscreens);
	}

	/**
	 * 
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		return true;
	}


	/**
	 * 
	 * @param activityToStart
	 */
	protected void startActivity(Class<? extends SherlockActivity> activityToStart) {
		super.startActivity(Home.this, activityToStart);
	}
	

}
