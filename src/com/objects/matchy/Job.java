package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

public class Job extends SoapObjectAbstract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Date, JobTitle, JobDescription, JobPlaceDate, JobHours;
	private DetailJob DetailJob;
	private Company Company;
	private int JobID;
	private EducationLevel Education;

	private enum jobFields {
		Date, JobTitle, JobDescription, JobPlaceDate, JobHours, DetailJob, JobID, Education, Company;
	}

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return Date;
		case 1:
			return JobTitle;
		case 2:
			return JobDescription;
		case 3:
			return JobPlaceDate;
		case 4:
			return JobHours;
		case 5:
			return DetailJob;
		case 6:
			return JobID;
		case 7:
			return Education;
		case 8:
			return Company;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 9;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Date";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "JobTitle";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "JobDescription";
			break;
		case 3:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "JobPlaceDate";
			break;
		case 4:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "JobHours";
			break;
		case 5:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "DetailJob";
			break;
		case 6:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "JobID";
			break;
		case 7:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "Education";
			break;
		case 8:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "Company";
			break;
		default:
			break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			Date = value.toString();
			break;
		case 1:
			JobTitle = value.toString();
			break;
		case 2:
			JobDescription = value.toString();
			break;
		case 3:
			JobPlaceDate = value.toString();
			break;
		case 4:
			JobHours = value.toString();
			break;
		case 5:
			DetailJob = (DetailJob) value;
			break;
		case 6:
			JobID = Integer.parseInt(value.toString());
			break;
		case 7:
			Education = (EducationLevel) value;
			break;
		case 8:
			Company = (Company) value;
			break;
		default:
			break;
		}
	}

	@Override
	public Class<?> getPropertyClass(String name) {
		jobFields fieldName = jobFields.valueOf(name);

		switch (fieldName) {
		case Date:
			return String.class;
		case JobTitle:
			return String.class;
		case JobDescription:
			return String.class;
		case JobPlaceDate:
			return String.class;
		case JobHours:
			return String.class;
		case DetailJob:
			return Object.class;
		case JobID:
			return Integer.class;
		case Education:
			return Object.class;
		case Company:
			return Object.class;
		default:
			return null;
		}
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
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return JobTitle;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}

	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return JobDescription;
	}

	/**
	 * @param jobDescription
	 *            the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

	/**
	 * @return the jobPlaceDate
	 */
	public String getJobPlaceDate() {
		return JobPlaceDate;
	}

	/**
	 * @param jobPlaceDate
	 *            the jobPlaceDate to set
	 */
	public void setJobPlaceDate(String jobPlaceDate) {
		JobPlaceDate = jobPlaceDate;
	}

	/**
	 * @return the jobHours
	 */
	public String getJobHours() {
		return JobHours;
	}

	/**
	 * @param jobHours
	 *            the jobHours to set
	 */
	public void setJobHours(String jobHours) {
		JobHours = jobHours;
	}

	/**
	 * @return the detailJob
	 */
	public DetailJob getDetailJob() {
		return DetailJob;
	}

	/**
	 * @param detailJob
	 *            the detailJob to set
	 */
	public void setDetailJob(DetailJob detailJob) {
		this.DetailJob = detailJob;
	}

	/**
	 * @return the jobID
	 */
	public int getJobID() {
		return JobID;
	}

	/**
	 * @param jobID
	 *            the jobID to set
	 */
	public void setJobID(int jobID) {
		this.JobID = jobID;
	}

	/**
	 * @return the eductionID
	 */
	public EducationLevel getEducation() {
		return Education;
	}

	/**
	 * @param eductionID
	 *            the eductionID to set
	 */
	public void setEducation(EducationLevel education) {
		Education = education;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return Company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(Company company) {
		this.Company = company;
	}

}
