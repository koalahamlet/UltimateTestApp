package mikecancode.ultimatetestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import mikecancode.ultimatetestapp.ImageViewPager.ImageViewPagerActivity;
import mikecancode.ultimatetestapp.ListViewPager.ListViewPagerActivity;
import mikecancode.ultimatetestapp.SlidingTabStrip.PagerSlidingTabStripActivity;

public class IntroActivity extends AppCompatActivity {

	@Bind(R.id.listview)
	ListView listView;
	private ExampleItemAdapter adapter;
	private List<ExampleItem> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		ButterKnife.bind(this);

		list = new ArrayList<ExampleItem>();

		list.add(new ExampleItem("Image Viewpager example", new ImageViewPagerActivity()));
		list.add(new ExampleItem("List Viewpager example", new ListViewPagerActivity()));
		list.add(new ExampleItem("Sliding TabStrip example", new PagerSlidingTabStripActivity()));


		adapter = new ExampleItemAdapter(this, R.layout.test_item_layout, list);
		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_intro, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}


	@OnItemClick(R.id.listview)
	void onItemClick(int position){
		ExampleItem item = adapter.getItem(position);
		Intent i = new Intent(this, item.getActivity().getClass());
		startActivity(i);
	}

}
