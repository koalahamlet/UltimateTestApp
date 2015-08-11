package mikecancode.ultimatetestapp.ListViewPager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Vector;

import mikecancode.ultimatetestapp.R;

public class ListViewPagerActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_pager);
		/** Called when the activity is first created. */
		mContext = this;
		ListView listview1 = new ListView(mContext);
		ListView listview2 = new ListView(mContext);
		ListView listview3 = new ListView(mContext);

		Vector<View> pages = new Vector<View>();

		pages.add(listview1);
		pages.add(listview2);
		pages.add(listview3);

		ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
		CustomListPagerAdapter adapter = new CustomListPagerAdapter(mContext, pages);
		vp.setAdapter(adapter);

		listview1.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, new String[]{"A1", "B1", "C1", "D1"}));
		listview2.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, new String[]{"A2", "B2", "C2", "D2"}));
		listview3.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, new String[]{"A3", "B3", "C3", "D3"}));

	}
}