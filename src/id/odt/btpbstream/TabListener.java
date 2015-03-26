package id.odt.btpbstream;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class TabListener implements ActionBar.TabListener {
	Fragment FRAGMENT;
	Context CONTEXT;

	public TabListener(Fragment fragment, Context context) {
		// TODO Auto-generated constructor stub
		FRAGMENT = fragment;
		CONTEXT = context;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.add(R.id.fragment_container, FRAGMENT);
		// ft.replace(R.id.fragment_container, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.remove(FRAGMENT);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
}
