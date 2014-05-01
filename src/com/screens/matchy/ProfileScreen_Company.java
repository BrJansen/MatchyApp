package com.screens.matchy;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.asynctask.matchy.AsyncInterface;
import com.asynctask.matchy.UserAsync;
import com.main.matchy.R;
import com.objects.matchy.User;

/**
 * This activity is the COMPANY profile screen. Contains basic profile data and
 * company description.
 * 
 * @author Grand Tech Assembly
 */

public class ProfileScreen_Company extends Activity implements AsyncInterface {

	private String FILE_NAME = "user.obj";

	/**
	 * Creates screen elements and sets button listeners.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_screen_company);
		RemoteApplicationAccess.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();
		UserAsync task = new UserAsync(this);
		task.execute(new String[] { FILE_NAME });

	}

	/**
	 * The right side of the profile description. Fills textviews with
	 * properties from user object.
	 */

	private void fillProfile(User user) {

		TextView profileName = (TextView) findViewById(R.id.profile_name);
		profileName.setText(user.getUserCompany().getCompanyName());

		TextView profileCity = (TextView) findViewById(R.id.profile_city);
		profileCity.setText(user.getUserCompany().getCompanyCity());

		TextView profileEmail = (TextView) findViewById(R.id.profile_email);
		profileEmail.setText(user.getUserCompany().getCompanyEmail());

		TextView profileTelephone = (TextView) findViewById(R.id.profile_telephone);
		profileTelephone.setText(user.getUserCompany().getCompanyTel());
		
		TextView profileDesc = (TextView) findViewById(R.id.profile_companyDesc);
		profileDesc.setText(user.getUserCompany().getCompanyDescription());
	}

	public void onBackgroundTaskCompleted(User user) {
		fillProfile(user);
	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {
	}

	/**
	 * Creates scrollable Textview for the company description.
	 */
	
	private void createInnerScrolls() {

		TextView description = (TextView) findViewById(R.id.profile_companyDesc);

		description.setMovementMethod(new ScrollingMovementMethod());

	}
}
