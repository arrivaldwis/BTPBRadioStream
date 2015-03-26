package id.odt.btpbstream;


import java.io.IOException;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends SherlockFragmentActivity {
	RadioFragment radio = new RadioFragment();
	VideoFragment video = new VideoFragment();
	public ActionBar ab;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ab = getSupportActionBar();
		ab.setLogo(R.drawable.ic_launcher);
		ab.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.bar));
		ab.setTitle("BTPB.co.id Stream");
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Tab tab1 = ab
				.newTab()
				.setIcon(R.drawable.ic_action_radio)
				.setTabListener(new TabListener(radio, getApplicationContext()));
		ab.addTab(tab1);
		Tab tab2 = ab
				.newTab()
				.setIcon(R.drawable.ic_action_television)
				.setTabListener(new TabListener(video, getApplicationContext()));
		ab.addTab(tab2);
	}
	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_about:
			new AlertDialog.Builder(MainActivity.this)
			.setTitle("About BTPB.co.id")
			.setIcon(R.drawable.logosplash)
			.setMessage("BTPB Stream Apps by odt\nBandung Tourism Promotion Board\nhttp://www.btpb.co.id")
			.setPositiveButton("Visit",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(
								DialogInterface dialog,
								int which) {	
							Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.btpb.co.id"));
							startActivity(browserIntent);
						}

					})
			.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(
								DialogInterface dialog,
								int which) {

						}

					}).show();
			break;
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
