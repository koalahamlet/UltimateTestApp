package mikecancode.ultimatetestapp;

import android.app.Activity;

/**
 * Created by koalahamlet on 8/10/15.
 */
public class TestItem {
	String name;
//	String activity;
	Activity activity;

	public TestItem(String name, Activity activity) {
		this.name = name;
		this.activity = activity;
	}

	public String getName() {
		return name;
	}

	public Activity getActivity() {
		return activity;
	}

}
