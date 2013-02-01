package com.coursoid.main;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.view.Menu;

public class SearchActivity extends BaseListActivity implements OnNavigationListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		return true;
	}
	
	@Override
	protected void configureActionBar() {
		super.configureActionBar();
		
		getSupportActionBar().setSelectedNavigationItem(1);
	}
	
	@Override
	protected void startActivity(
			Class<? extends SherlockActivity> activityToStart) {
		super.startActivity(SearchActivity.this, activityToStart);		
	}
}
