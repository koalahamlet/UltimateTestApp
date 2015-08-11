package mikecancode.ultimatetestapp.SlidingTabStrip;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mikecancode.ultimatetestapp.R;

public class PagerSlidingTabStripActivity extends AppCompatActivity implements ItemFragment.OnFragmentInteractionListener, BlankFragment.OnFragmentInteractionListener {

	List<Fragment> mFragments;

	MyPagerAdapter mAdapter;

	@Bind(R.id.tabs)
	PagerSlidingTabStrip mTabs;

	@Bind(R.id.pager)
	ViewPager mPager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pager_sliding_tab_strip);
		ButterKnife.bind(this);

		mFragments = new ArrayList<>();
		mFragments.add(BlankFragment.newInstance("", ""));
		mFragments.add(ItemFragment.newInstance("", ""));
		mFragments.add(BlankFragment.newInstance("", ""));
		mFragments.add(ItemFragment.newInstance("", ""));

		LayoutInflater li = this.getLayoutInflater();
		mAdapter = new MyPagerAdapter(getSupportFragmentManager(), li);

		mPager.setAdapter(mAdapter);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				4,
				getResources().getDisplayMetrics());
		mPager.setPageMargin(pageMargin);

		mTabs.setDividerPadding(22);
		mTabs.setViewPager(mPager);

		if (getSupportActionBar() != null){
			getSupportActionBar().setCustomView(mTabs);
		}

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	public void onFragmentInteraction(String id) {

	}

	@Override
	public void onFragmentInteraction(Uri uri) {

	}

	public class MyPagerAdapter extends FragmentPagerAdapter
			implements PagerSlidingTabStrip.ViewTabProvider {

		private View[] TABS;

		public MyPagerAdapter(FragmentManager fm, LayoutInflater li) {
			super(fm);

			//Here is where you set the number of tabs you want to display
			TABS = new View[4];

			TABS[0] = li.inflate(R.layout.tab_1, null);
			TABS[1] = li.inflate(R.layout.tab_2, null);
			TABS[2] = li.inflate(R.layout.tab_3, null);
			TABS[3] = li.inflate(R.layout.tab_4, null);
		}

		@Override
		public int getCount() {
			return TABS.length;
		}

		@Override
		public android.support.v4.app.Fragment getItem(int position) {
			return mFragments.get(position);
		}

		@Override public View getPageView(int position) {
			return TABS[position];
		}
	}

}
