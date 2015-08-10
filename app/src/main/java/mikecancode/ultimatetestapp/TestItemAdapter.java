package mikecancode.ultimatetestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by koalahamlet on 8/10/15.
 */
public class TestItemAdapter extends ArrayAdapter<TestItem>{

	Context context;


	public static class ViewHolder {
		@Bind(R.id.tvMain)
		TextView textView;

		@Bind(R.id.llMain)
		LinearLayout linearLayout;

		public ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}

	/**
	 * Constructor
	 *
	 * @param context  The current context.
	 * @param resource The resource ID for a layout file containing a TextView to use when
	 *                 instantiating views.
	 * @param objects  The objects to represent in the ListView.
	 */
	public TestItemAdapter(Context context, int resource, List<TestItem> objects) {
		super(context, resource, objects);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// get appropriate data
		final TestItem item = getItem(position);

		// Check if an existing view is being reused, otherwise inflate the view
		final ViewHolder viewHolder;

		if (convertView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.test_item_layout, parent, false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.textView.setText(item.getName());

		return convertView;
	}
}
