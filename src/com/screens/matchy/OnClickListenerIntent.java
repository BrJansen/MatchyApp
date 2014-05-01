package com.screens.matchy;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This class creates a template with which to make onClickListeners. Prevents
 * the need to manually create each onClickListener on each separate screen.
 * 
 * @author Grand Tech Assembly
 */

public class OnClickListenerIntent {

	public OnClickListener onClickIntent(final Context currContext,
			final Class<?> classIntent, final int id) {
		return new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent;
				if(id!=0){
					intent = new Intent(currContext, classIntent);
					intent.putExtra("id", id);
				}
				else
					intent = new Intent(currContext, classIntent);
				currContext.startActivity(intent);
			}
		};
	}
}
