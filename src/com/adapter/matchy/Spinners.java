package com.adapter.matchy;

import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.main.matchy.R;
import com.screens.matchy.RemoteApplicationAccess;

/**
 * This class implements the onclicklisteners on custom spinners.
 *
 */

public class Spinners {
	private static boolean firstLoaded;

	/**
	 * @param firstLoaded the firstLoaded to set
	 */
	public static void setFirstLoaded(boolean firstLoaded) {
		Spinners.firstLoaded = firstLoaded;
	}

	public static OnItemSelectedListener onItemSelected(final List<String> list, final int textViewID) {
		return new OnItemSelectedListener() {
			TextView textView = (TextView) RemoteApplicationAccess.getActivity().findViewById(textViewID);

			@Override
			public void onItemSelected(AdapterView<?> adpView, View v, int position, long id) {
				if (firstLoaded) {
					textView.setText(R.string.spinnerTemplate);
					firstLoaded = false;
				} else {
					textView.setText(list.get(position));
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				//firstLoaded = activityClass;
				textView.setText(R.string.spinnerTemplate);
			}
		};
	}
}
