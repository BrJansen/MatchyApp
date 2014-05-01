package com.adapter.matchy;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.main.matchy.R;
import com.objects.matchy.DatabaseMatch;
import com.objects.matchy.User;
import com.soaps.matchy.Streams;

public class MatchAdapter extends BaseAdapter {

	private String FILE_NAME = "user.obj";
	public List<DatabaseMatch> matchList;
	private Activity activity;

	private int listItem;

	public MatchAdapter(Activity activity, List<DatabaseMatch> matches) {
		super();

		this.activity = activity;
		this.matchList = matches;
		listItem = R.layout.match_item;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return matchList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return matchList.get(position);
	}

	@Override
	public long getItemId(int position) {
		long matchId;
		if (checkIdentity())
			matchId = matchList.get(position).getMatch().getCv().getCvID();
		else
			matchId = matchList.get(position).getMatch().getJob().getJobID();
		return matchId;
	}

	private class ViewHolder {
		TextView type;
		TextView title;
		TextView description;
		TextView matchDate;
		TextView matchPlace;
		TextView matchEducation;
		TextView matchWorkTime;
		TextView score;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();
		DatabaseMatch curMatch = matchList.get(position);

		convertView = null;

		convertView = inflater.inflate(listItem, null);

		holder = new ViewHolder();
		holder.type = (TextView) convertView.findViewById(R.id.matchType);
		holder.title = (TextView) convertView.findViewById(R.id.matchTitle);
		holder.description = (TextView) convertView
				.findViewById(R.id.matchDescription);
		holder.matchDate = (TextView) convertView.findViewById(R.id.matchDate);
		holder.matchPlace = (TextView) convertView
				.findViewById(R.id.matchPlace);
		holder.matchEducation = (TextView) convertView
				.findViewById(R.id.matchEducation);
		holder.matchWorkTime = (TextView) convertView
				.findViewById(R.id.matchWorkTime);
		holder.score = (TextView) convertView.findViewById(R.id.score);

		convertView.setTag(holder);
		if (checkIdentity()) {
			String personal = curMatch.getMatch().getCv().getPersonal()
					.replaceAll("<br />", "");

			holder.type.setText(curMatch.getMatch().getDate());
			holder.title.setText(curMatch.getMatch().getCv().getName());
			holder.description.setText(personal);
			holder.matchDate.setText(curMatch.getMatch().getCv().getCity());
			holder.matchPlace
					.setText(curMatch.getMatch().getCv().getProvince());
			holder.matchEducation.setText(curMatch.getMatch().getCv()
					.getEducationLevel().getName());
			holder.matchWorkTime
					.setText(curMatch.getMatch().getCv().getHours());
			holder.score.setText(curMatch.getMatch().getScore());
		} else {
			holder.type.setText(curMatch.getMatch().getDate());
			holder.title.setText(curMatch.getMatch().getJob().getJobTitle());
			holder.description.setText(curMatch.getMatch().getJob()
					.getJobDescription());
			holder.matchDate.setText(curMatch.getMatch().getJob().getDate());
			holder.matchPlace.setText(curMatch.getMatch().getJob().getDate());
			holder.matchEducation.setText(curMatch.getMatch().getJob()
					.getEducation().getName());
			holder.matchWorkTime.setText(curMatch.getMatch().getJob()
					.getJobHours());
			holder.score.setText(curMatch.getMatch().getScore());
		}

		return convertView;
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

}
