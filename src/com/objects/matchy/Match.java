package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

public class Match extends SoapObjectAbstract implements Serializable {

	/**
	 * This class contains all the getters and setters for each MATCH object
	 * property. Additionally, it parses each object property to it's
	 * corresponding type.
	 * 
	 * @author Grand Tech Assembly
	 * @version 0.9
	 */

	private Job job;
	private Cv cv;
	private String Date;
	private String Score;

	private static final long serialVersionUID = 1L;

	public Match(){};
	public Match(Job job){
		this.job = job;
	}
	/**
	 * @return the cv
	 */
	public Cv getCv() {
		return cv;
	}

	/**
	 * @param cv the cv to set
	 */
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	
	/**
	 * @return the score
	 */
	public String getScore() {
		return Score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(String score) {
		Score = score;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}

	/**
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	private enum matchFields {
		Date, Score, Job, Cv
	}

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return cv;
		case 1:
			return job;
		case 2:
			return Score;
		case 3:
			return Date;
		default:
			return null;
		}
	}

	@Override
	public int getPropertyCount() {
		return 4;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "Cv";
			break;
		case 1:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "Job";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Score";
			break;
		case 3:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Date";
			break;
		default:
			break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			cv = (Cv) value;
			break;
		case 1:
			job = (Job) value;
			break;
		case 2:
			Score = value.toString();
			break;
		case 3:
			Date = value.toString();
			break;
		default:
			break;
		}

	}

	@Override
	public Class<?> getPropertyClass(String name) {
		matchFields fieldName = matchFields.valueOf(name);

		switch (fieldName) {
		case Cv:
			return Object.class;
		case Job:
			return Object.class;
		case Score:
			return String.class;
		case Date:
			return String.class;
		default:
			return null;
		}
	}

}
