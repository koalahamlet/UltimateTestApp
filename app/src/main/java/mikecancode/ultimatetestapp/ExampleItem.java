package mikecancode.ultimatetestapp;

import android.app.Activity;

/**
 * Created by koalahamlet on 8/10/15.
 */
public class ExampleItem {
	String name;
//	String activity;
	Activity activity;

	public ExampleItem(String name, Activity activity) {
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
