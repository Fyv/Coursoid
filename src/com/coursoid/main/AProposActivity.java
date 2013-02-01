package com.coursoid.main;

import java.lang.reflect.Method;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class AProposActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apropos);
		// Show the Up button in the action bar.
		
		getSupportActionBar().setHomeButtonEnabled(true);
		
		initView();
		initListeners();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			startActivity(Home.class);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}


	private void startActivity(Class<? extends SherlockActivity> activityToStart) {
		Intent i = new Intent(AProposActivity.this, activityToStart);
		startActivity(i);
	}
	
	/**
	 * 
	 */
	private void initView() {
//		findViewById(R.id.apropos_content_1).setVisibility(View.GONE);
		
	}
	/**
	 * 
	 */
	private void initListeners() {
		final TextView title1 = (TextView) findViewById(R.id.apropos_title_1);
		final TextView title2 = (TextView) findViewById(R.id.apropos_title_2);
		final TextView title3 = (TextView) findViewById(R.id.apropos_title_3);
		final TextView title4 = (TextView) findViewById(R.id.apropos_title_4);
		final TextView title5 = (TextView) findViewById(R.id.apropos_title_5);
		final TextView title6 = (TextView) findViewById(R.id.apropos_title_6);
		final TextView title7 = (TextView) findViewById(R.id.apropos_title_7);
		
		title1.setOnClickListener(initClickListener(title1, R.id.apropos_content_1));
		title2.setOnClickListener(initClickListener(title2, R.id.apropos_content_2));
		title3.setOnClickListener(initClickListener(title3, R.id.apropos_content_3));
		title4.setOnClickListener(initClickListener(title4, R.id.apropos_content_4));
		title5.setOnClickListener(initClickListener(title5, R.id.apropos_content_5));
		title6.setOnClickListener(initClickListener(title6, R.id.apropos_content_6));
		title7.setOnClickListener(initClickListener(title7, R.id.apropos_content_7));
	}
	
	/**
	 * @param textView 
	 * @param idContent 
	 * @return 
	 * 
	 */
	private OnClickListener initClickListener(final TextView textView, final int idContent){
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Animation anim;
				if (findViewById(idContent).getVisibility() == View.GONE) {
					findViewById(idContent).setVisibility(
							View.VISIBLE);
					textView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
							R.drawable.navigation_collapse, 0);
					
//					anim = expand(findViewById(idContent), true);
				} else {
					findViewById(idContent).setVisibility(
							View.GONE);
					textView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
							R.drawable.navigation_expand, 0);
//					
//					anim = expand(findViewById(idContent), false);
				}
//				v.startAnimation(anim);
			}
		};
	}
	
//	/**
//	 * TODO correct this latter
//	 */
//	public static Animation expand(final View v, final boolean expand) {
//		try {
//			Method m = v.getClass().getDeclaredMethod("onMeasure", int.class,
//					int.class);
//			m.setAccessible(true);
//			m.invoke(v,
//					MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
//					MeasureSpec.makeMeasureSpec(
//							((View) v.getParent()).getMeasuredWidth(),
//							MeasureSpec.AT_MOST));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		final int initialHeight = v.getMeasuredHeight();
//
//		if (expand) {
//			v.getLayoutParams().height = 0;
//		} else {
//			v.getLayoutParams().height = initialHeight;
//		}
//		v.setVisibility(View.VISIBLE);
//
//		Animation a = new Animation() {
//			@Override
//			protected void applyTransformation(float interpolatedTime,
//					Transformation t) {
//				int newHeight = 0;
//				if (expand) {
//					newHeight = (int) (initialHeight * interpolatedTime);
//				} else {
//					newHeight = (int) (initialHeight * (1 - interpolatedTime));
//				}
//				v.getLayoutParams().height = newHeight;
//				v.requestLayout();
//
//				if (interpolatedTime == 1 && !expand)
//					v.setVisibility(View.GONE);
//			}
//
//			@Override
//			public boolean willChangeBounds() {
//				return true;
//			}
//		};
//		a.setDuration(100);
//		return a;
//	}

}
