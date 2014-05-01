package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

public class Cv extends SoapObjectAbstract implements Serializable {

	/**
	 * This class contains all the getters and setters for each CV object
	 * property. Additionally, it parses each object property to it's
	 * corresponding type.
	 * 
	 * @author Grand Tech Assembly
	 * @version 0.9
	 */

	private static final long serialVersionUID = 1L;
	private String Title, Name,  Date, Profession, Discipline, Province,
			Hours, City, Sex, EducationHistory, WorkExperience, Personal, Interests, JobRequirements;

	private int CvID, CrawlerID, Age;
	private EducationLevel EducationLevel;
	private Source Source;

	private enum userFields {
		Title, Name, Date, Profession, Discipline, Personal, Interests, JobRequirements, Province, Hours, City, Sex, EducationHistory, WorkExperience, CvID, CrawlerID, Age, EducationLevel, Source;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @return the date
	 */
	
	 public String getDate() { 
		 return Date; 
	}
	 

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return Profession;
	}

	/**
	 * @return the discipline
	 */
	public String getDiscipline() {
		return Discipline;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return Province;
	}

	/**
	 * @return the hours
	 */
	public String getHours() {
		return Hours;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return Sex;
	}

	/**
	 * @return the education
	 */
	public String getEducationHistory() {
		return EducationHistory;
	}

	/**
	 * @return the workExperience
	 */
	public String getWorkExperience() {
		return WorkExperience;
	}

	/**
	 * @return the cvID
	 */
	public int getCvID() {
		return CvID;
	}

	/**
	 * @return the crawlerID
	 */
	public int getCrawlerID() {
		return CrawlerID;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return Age;
	}

	/**
	 * @return the educationLevel
	 */
	public EducationLevel getEducationLevel() {
		return EducationLevel;
	}

	/**
	 * @return the source
	 */
	public Source getSource() {
		return Source;
	}

	public String getPersonal() {
		return Personal;
	}
	
	public String getJobRequirements() {
		return JobRequirements;
	}
	
	public String getInterests() {
		return Interests;
	}
	
	public void setJobRequirements(String jobRequirements) {
		JobRequirements = jobRequirements;
	}

	public void setPersonal(String personal) {
		Personal = personal;
	}

	public void setInterests(String interests) {
		Interests = interests;
	}
	
	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @param date
	 *            the date to set
	 */

	 public void setDate(String date) { 
		 Date = date; 
	}


	/**
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(String profession) {
		Profession = profession;
	}

	/**
	 * @param discipline
	 *            the discipline to set
	 */
	public void setDiscipline(String discipline) {
		Discipline = discipline;
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		Province = province;
	}

	/**
	 * @param hours
	 *            the hours to set
	 */
	public void setHours(String hours) {
		Hours = hours;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		City = city;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		Sex = sex;
	}

	/**
	 * @param education
	 *            the education to set
	 */
	public void setEducationHistory(String education) {
		EducationHistory = education;
	}

	/**
	 * @param workExperience
	 *            the workExperience to set
	 */
	public void setWorkExperience(String workExperience) {
		WorkExperience = workExperience;
	}

	/**
	 * @param cvID
	 *            the cvID to set
	 */
	public void setCvID(Integer cvID) {
		CvID = (Integer) cvID;
	}

	/**
	 * @param crawlerID
	 *            the crawlerID to set
	 */
	public void setCrawlerID(Integer crawlerID) {
		CrawlerID = (Integer) crawlerID;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		Age = (Integer) age;
	}

	/**
	 * @param educationLevel
	 *            the educationLevel to set
	 */
	public void setEducationLevel(EducationLevel educationLevel) {
		EducationLevel = educationLevel;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(Source source) {
		Source = source;
	}

	/**
	 * @return the object property.
	 * @param arg0
	 *            int
	 */

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return CvID;
		case 1:
			return CrawlerID;
		case 2:
			return Name;
		case 3:
			return Profession;
		case 4:
			return Discipline;
		case 5:
			return EducationLevel;
		case 6:
			return Province;
		case 7:
			return Hours;
		case 8:
			return City;
		case 9:
			return Sex;
		case 10:
			return Age;
		case 11:
			return EducationHistory;
		case 12:
			return WorkExperience;
		case 13:
			return Source;
		case 14:
			return Personal;
		case 15:
			return Interests;
		case 16:
			return JobRequirements;
		case 17: 
			return Date;
		}
		return null;
	}

	/**
	 * @return int property count.
	 */

	@Override
	public int getPropertyCount() {
		return 18;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "CvID";
			break;
		case 1:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "CrawlerID";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Name";
			break;
		case 3:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Profession";
			break;
		case 4:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Discipline";
			break;
		case 5:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "EducationLevel";
			break;
		case 6:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Province";
			break;
		case 7:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Hours";
			break;
		case 8:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "City";
			break;
		case 9:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Sex";
			break;
		case 10:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "Age";
			break;
		case 11:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "EducationHistory";
			break;
		case 12:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "WorkExperience";
			break;
		case 13:
			info.type = PropertyInfo.OBJECT_CLASS;
			info.name = "Source";
			break;
		case 14:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Personal";
			break;
		case 15:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Interests";
			break;
		case 16:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "JobRequirements";
			break;
		case 17: 
			info.type = PropertyInfo.STRING_CLASS; 
			info.name = "Date";
			break;
		default:
			break;
		}
	}

	/**
	 * This method sets each property to a string.
	 * 
	 * @param index
	 * @param value
	 */

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {

		case 0:
			CvID = Integer.parseInt(value.toString());
			break;
		case 1:
			CrawlerID = Integer.parseInt(value.toString());
			break;
		case 2:
			Name = value.toString();
			break;
		case 3:
			Profession = value.toString();
			break;
		case 4:
			Discipline = value.toString();
			break;
		case 5:
			EducationLevel = (EducationLevel) value;
			break;
		case 6:
			Province = value.toString();
			break;
		case 7:
			Hours = value.toString();
			break;
		case 8:
			City = value.toString();
			break;
		case 9:
			Sex = value.toString();
			break;
		case 10:
			Age = Integer.parseInt(value.toString());
			break;
		case 11:
			EducationHistory = value.toString();
			break;
		case 12:
			WorkExperience = value.toString();
			break;
		case 13:
			Source = (Source) value;
			break;
		case 14:
			Personal = value.toString();
			break;
		case 15:
			Interests = value.toString();
			break;
		case 16:
			JobRequirements = value.toString();
			break;
		case 17: 
			Date = value.toString(); 
			break;
		default:
			break;
		}
	}

	/**
	 * This method returns the type class of a property.
	 * 
	 * @return type class
	 * @param name
	 *            String Name of the property as a String
	 */

	@Override
	public Class<?> getPropertyClass(String name) {
		userFields fieldName = userFields.valueOf(name);

		switch (fieldName) {
		case CvID:
			return Integer.class;
		case CrawlerID:
			return Integer.class;
		case Name:
			return String.class;
		case Profession:
			return String.class;
		case Discipline:
			return String.class;
		case EducationLevel:
			return Object.class;
		case EducationHistory:
			return String.class;
		case Province:
			return String.class;
		case Hours:
			return String.class;
		case City:
			return String.class;
		case Age:
			return Integer.class;
		case Sex:
			return String.class;
		case WorkExperience:
			return String.class;
		case Source:
			return Object.class;
		case Personal:
			return String.class;
		case Interests:
			return String.class;
		case JobRequirements:
			return String.class;
		case Date: 
			return String.class;
		default:
			return null;
		}
	}
}
