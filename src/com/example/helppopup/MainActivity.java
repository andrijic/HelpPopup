package com.example.helppopup;

import hr.andrijic.uslugehr.helppopup.HelpPopup;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	HelpPopup popup;
	HelpPopup popup2;
	HelpPopup popup3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		Button button = (Button) findViewById(R.id.testId2);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				popup.setText("ccc 1").setPosition(150, 100);
				popup2.setText("ccc 2").setPosition(150, 50);
				popup3.removeAllViews();
			}
		});

		final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
		viewGroup.post(new Runnable() {
			@Override
			public void run() {
				popup = new HelpPopup(MainActivity.this)
						.attachToViewGroup(viewGroup).setText("ovo je tekst 1")
						.setColor(Color.BLUE).setTextColor(Color.RED)
						.downArrowIsVisible(false)
						.positionToBottomOfTargetView(findViewById(R.id.testId2));

				popup2 = new HelpPopup(MainActivity.this)
						.attachToViewGroup(viewGroup).setText("ovo je tekst 2")
						.setColor(Color.CYAN).setTextColor(Color.RED)
						.setPosition(100, 200).upArrowIsVisible(false);

				popup3 = new HelpPopup(MainActivity.this)
						.attachToViewGroup(viewGroup).setText("ovo je tekst 3")
						.setColor(Color.GRAY).setTextColor(Color.RED)
						.setPosition(150, 300).upArrowIsVisible(false);

			}
		});
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
