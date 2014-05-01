package com.soaps.matchy;

import android.widget.Toast;

import com.asynctask.matchy.AsyncInterface;
import com.database.matchy.DBHelper;
import com.database.matchy.MatchProvider;
import com.main.matchy.R;
import com.objects.matchy.Match;
import com.objects.matchy.User;
import com.screens.matchy.RemoteApplicationAccess;

/**
 * This class initiates the call to the back-end for match purposes.
 * 
 *
 */

public class MatchCaller extends Thread implements AsyncInterface {
	
	private String FILE_NAME = "user.obj";
	private DBHelper dBHelper = null;
	public ConcreteMatch callMatch;
	private int cvID, limit, companyID;
	@SuppressWarnings("unused")
	private User currentUser;

	public MatchCaller(int cvID, int companyID, int limit) {
		this.limit = limit;
		if (cvID != 0) {
			this.cvID = cvID;
		} else {
			this.companyID =  companyID;
		}
	}

	public Object makeCall() {
		// Looper.prepare();

		try {
			if(this.cvID != 0)
				callMatch = new ConcreteMatch("GetMatchByCv", new String[] {
						"cv_id", "limit" }, cvID, limit);
			else	
				callMatch = new ConcreteMatch("GetMatchByCompany", new String[] {
						"companyID", "limit" }, companyID, limit);

			Object[] matches = callMatch.returnObject();

			dbHelper();
			Streams streams = new Streams();
			User user = new User();
			user = streams.createInputStream(FILE_NAME);

			
			for (int i = 0; i < matches.length; i++) {
				MatchProvider matchProvider = new MatchProvider(
						RemoteApplicationAccess.getContext());
				Match match = (Match) matches[i];
				if(checkIdentity())
					matchProvider.store(match, "company",user.getUserCompany().getCompanyID() );
				else 
					matchProvider.store(match, "cv",user.getUserCv().getCvID() );
			}
			dbHelper().close();
			dBHelper = null;

			return matches;
		} catch (Exception ex) {
			RemoteApplicationAccess.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(RemoteApplicationAccess.getContext(),
							R.string._errorConnection, Toast.LENGTH_LONG)
							.show();
				}
			});
		}
		return null;
	}

	private DBHelper dbHelper() {
		if (dBHelper == null) {
			dBHelper = new DBHelper(RemoteApplicationAccess.getContext());
			dBHelper.db();
		}
		return dBHelper;
	}

	private Boolean checkIdentity() {
		int Id;
		Boolean Identity;

		Streams streams = new Streams();
		User user = new User();
		user = streams.createInputStream(FILE_NAME);
		Id = user.getUserCompany().getCompanyID();

		Identity = Id == 0 ? false : true;

		return Identity;
	}

	@Override
	public void onBackgroundTaskCompleted(User user) {
		currentUser = user;
	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {}
}