package com.coursoid.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

/**
 * An abstract class for main screen's activities
 * @author Phi-Van
 *
 */
public abstract class BaseListActivity extends SherlockActivity implements OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		configureActionBar();
		
//		getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getSupportMenuInflater();
		menuInflater.inflate(R.menu.activity_home, menu);
		
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case android.R.id.home:
			startActivity(Home.class);
			break;

		case R.id.menu_apropos:
			startActivity(AProposActivity.class);
			break;
			
		case R.id.menu_logout:
			startActivity(LoginActivity.class);
			break;
		case R.id.menu_quit:
			quitApp(true);
			break;
		//
		// case R.id.menu_settings:
		// msg = Toast.makeText(Home.this, "Menu setting", Toast.LENGTH_LONG);
		// msg.show();
		// break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * 
	 */
	protected void configureActionBar() {
		Context context = getSupportActionBar().getThemedContext();
		ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(
				context, R.array.mainscreens,
				(android.R.layout.simple_list_item_1));
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		getSupportActionBar().setListNavigationCallbacks(list, this);
	}

	/**
	 * 
	 */
	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		Class<? extends SherlockActivity> clazz;
		switch (itemPosition) {
		case 0:
			clazz = Home.class;
					startActivity(clazz);
			break;
			
		case 1:
			clazz = SearchActivity.class;
				startActivity(clazz);
			break;
		
		case 2:
			clazz = RecettesActivity.class;
				startActivity(clazz);
			break;
		
		case 3:
			clazz = PlacardActivity.class;
				startActivity(clazz);
			break;

		default:
			break;
		}
		
		return true;
	}
	
	protected boolean isActivityToStartIsTheSame(Class<? extends SherlockActivity> clazz){
		if(this.getClass().equals(clazz)) 
			return true;
		return false;
	}

	/**
	 * 
	 * @param activityToStart
	 */
	protected abstract void startActivity(Class<? extends SherlockActivity> activityToStart);

	/**
	 * 
	 * @param showCheckDialog
	 */
	
	protected void startActivity(Context c, Class<? extends SherlockActivity> activityToStart){
		if(isActivityToStartIsTheSame(activityToStart))
			return;
		
		Intent i = new Intent(c, activityToStart);
		startActivity(i);
	}

	
	protected void quitApp(boolean showCheckDialog) {
		System.exit(0);
	}
}
