package com.screens.matchy;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import com.asynctask.matchy.AsyncInterface;
import com.asynctask.matchy.UserAsync;
import com.database.matchy.MatchProvider;
import com.main.matchy.R;
import com.objects.matchy.DatabaseMatch;
import com.objects.matchy.User;

/**
 * This activity is the FIRST PAGE profile screen. Contains only basic profile
 * data.
 * 
 * @author Grand Tech Assembly
 */

public class ProfileScreen_User extends Activity implements AsyncInterface {

	private String FILE_NAME = "user.obj";
	private int id;

	/**
	 * Creates screen elements and sets button listeners.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_screen);
		RemoteApplicationAccess.setActivity(this);

		BuildNavigation bn = new BuildNavigation();
		bn.createIntents();
		createInnerScrolls();

		OnClickListenerIntent onClickListenerIntent = new OnClickListenerIntent();
		Button eduNavButton = (Button) findViewById(R.id.eduNav);

		if (getIntent().getExtras() != null) {
			id = getIntent().getExtras().getInt("id");
			fillProfileFromMatch();		
		} else {
			id = 0;
			UserAsync task = new UserAsync(this);
			task.execute(new String[] { FILE_NAME });
		}
		eduNavButton.setOnClickListener(onClickListenerIntent.onClickIntent(
				ProfileScreen_User.this, ProfileScreen_Edu.class, id));
	}

	/**
	 * The right side of the profile description. Fills textviews with
	 * properties from user object.
	 */

	private void fillProfile(User user) {

		TextView profileName = (TextView) findViewById(R.id.profile_name);

		profileName.setText(user.getUserCv().getName());

		TextView profileAge = (TextView) findViewById(R.id.profile_age);
		profileAge.setText(Integer.toString(user.getUserCv().getAge()));

		TextView profileSex = (TextView) findViewById(R.id.profile_sex);
		profileSex.setText(user.getUserCv().getSex());

		TextView profileProvince = (TextView) findViewById(R.id.profile_province);
		profileProvince.setText(user.getUserCv().getProvince());

		TextView profileCity = (TextView) findViewById(R.id.profile_city);
		profileCity.setText(user.getUserCv().getCity());

		TextView profileProfession = (TextView) findViewById(R.id.profile_profession);
		profileProfession.setText(user.getUserCv().getProfession());

		TextView profileDiscipline = (TextView) findViewById(R.id.profile_discipline);
		profileDiscipline.setText(user.getUserCv().getProfession());

		TextView profilePersonal = (TextView) findViewById(R.id.profile_jobReq);
		String personal = user.getUserCv().getJobRequirements()
				.replaceAll("<br />", "");
		profilePersonal.setText(personal);

	}

	private void fillProfileFromMatch() {
		MatchProvider matchProvider = new MatchProvider(
				RemoteApplicationAccess.getContext());
		DatabaseMatch match = matchProvider.findMatchById(id, "cv");

		TextView profileName = (TextView) findViewById(R.id.profile_name);

		profileName.setText(match.getMatch().getCv().getName());

		TextView profileAge = (TextView) findViewById(R.id.profile_age);
		profileAge.setText(Integer.toString(match.getMatch().getCv().getAge()));

		TextView profileSex = (TextView) findViewById(R.id.profile_sex);
		profileSex.setText(match.getMatch().getCv().getSex());

		TextView profileProvince = (TextView) findViewById(R.id.profile_province);
		profileProvince.setText(match.getMatch().getCv().getProvince());

		TextView profileCity = (TextView) findViewById(R.id.profile_city);
		profileCity.setText(match.getMatch().getCv().getCity());

		TextView profileProfession = (TextView) findViewById(R.id.profile_profession);
		profileProfession.setText(match.getMatch().getCv().getProfession());

		TextView profileDiscipline = (TextView) findViewById(R.id.profile_discipline);
		profileDiscipline.setText(match.getMatch().getCv().getProfession());

		TextView profilePersonal = (TextView) findViewById(R.id.profile_jobReq);
		String personal = match.getMatch().getCv().getJobRequirements()
				.replaceAll("<br />", "");
		profilePersonal.setText(personal);
	}

	public void onBackgroundTaskCompleted(User user) {
		fillProfile(user);
	}

	@Override
	public void onBackgroundTaskCompleted(Boolean result) {
	}

	private void createInnerScrolls() {

		TextView jobReq = (TextView) findViewById(R.id.profile_jobReq);

		jobReq.setMovementMethod(new ScrollingMovementMethod());

	}
}