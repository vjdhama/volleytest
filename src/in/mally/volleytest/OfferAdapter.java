package in.mally.volleytest;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OfferAdapter extends ArrayAdapter<Offer> {
	// View lookup cache
	private static class ViewHolder {
		TextView offerMain;
		TextView offerDesc;
		NetworkImageView image;
	}

	public OfferAdapter(Context context) {
		super(context, R.layout.offer_view);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		Offer offer = getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		ViewHolder viewHolder; // view lookup cache stored in tag
		if (convertView == null) {
			viewHolder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.offer_view, null);
			viewHolder.offerMain = (TextView) convertView
					.findViewById(R.id.offerMainTextView);
			viewHolder.offerDesc = (TextView) convertView
					.findViewById(R.id.offerDescTextView);
			viewHolder.image = (NetworkImageView) convertView
					.findViewById(R.id.offerImageView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		// Populate the data into the template view using the data object
		viewHolder.offerMain.setText(offer.getOfferHead());
		viewHolder.offerDesc.setText(offer.getOfferDesc());
		
		ImageLoader img = VolleyRequest.getInstance(getContext()).getImageLoader();
		viewHolder.image.setImageUrl(offer.getOfferUrl(), img);
		// Return the completed view to render on screen
		return convertView;
	}
}