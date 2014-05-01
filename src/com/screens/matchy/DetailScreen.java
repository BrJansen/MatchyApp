package com.screens.matchy;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.database.matchy.MatchProvider;
import com.main.matchy.R;
import com.objects.matchy.DatabaseMatch;

/**
 * This activity is the FIRST PAGE profile screen. Contains only basic profile
 * data.
 * 
 * @author Grand Tech Assembly
 */

public class DetailScreen extends Activity {

	private int id;

	/**
	 * Creates screen elements and sets button listeners.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_screen);
		RemoteApplicationAccess.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();

		if (getIntent().getExtras() != null) {
			id = (int) getIntent().getExtras().getInt("id");
			fillProfileFromMatch();
		}
	}

	private void fillProfileFromMatch() {
		MatchProvider matchProvider = new MatchProvider(
				RemoteApplicationAccess.getContext());
		DatabaseMatch match = matchProvider.findMatchById(id, "job");

		TextView profileName = (TextView) findViewById(R.id.profile_name);
		profileName.setText(match.getMatch().getJob().getCompany()
				.getCompanyName());

		TextView profileCity = (TextView) findViewById(R.id.profile_city);
		profileCity.setText(match.getMatch().getJob().getCompany()
				.getCompanyCity());

		TextView profileEmail = (TextView) findViewById(R.id.profile_email);
		profileEmail.setText(match.getMatch().getJob().getCompany()
				.getCompanyEmail());

		TextView profileTelephone = (TextView) findViewById(R.id.profile_telephone);
		profileTelephone.setText(match.getMatch().getJob().getCompany()
				.getCompanyTel());

		TextView profileDesc = (TextView) findViewById(R.id.profile_companyDesc);
		String jobDesc = match.getMatch().getJob().getDetailJob().getData()
				.replaceAll("<br />", "\n").replaceAll("<br>", "\n")
				.replaceAll("\\<(/?[^\\>]+)\\>", " ")
				.replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2")
				.replaceAll("null", "").trim();
		profileDesc.setText(jobDesc);
	}

	/**
	 * The right side of the profile description. Fills textviews with
	 * properties from user object.
	 */

	private void createInnerScrolls() {

		TextView jobReq = (TextView) findViewById(R.id.profile_companyDesc);

		jobReq.setMovementMethod(new ScrollingMovementMethod());

	}
}