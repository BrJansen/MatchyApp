package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

public class Company extends SoapObjectAbstract implements Serializable{
	
	/**
	* This class contains all the getters and setters for each COMPANY object property.
	* Additionally, it parses each object property to it's corresponding type.
	* @author Grand Tech Assembly 
	* @version 0.9
	*/
	
	private static final long serialVersionUID = 1L;
	private String CompanyName, CompanyDescription, CompanyDate, CompanyEmail, CompanyCity, CompanyTel;

	private int CompanyID;
	

	private enum userFields {
		CompanyName, CompanyDescription, CompanyDate, CompanyEmail, CompanyTel, CompanyCity, CompanyID;
	}
	
	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getCompanyDescription() {
		return CompanyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		CompanyDescription = companyDescription;
	}

	public String getCompanyDate() {
		return CompanyDate;
	}

	public void setCompanyDate(String companyDate) {
		CompanyDate = companyDate;
	}

	public String getCompanyEmail() {
		return CompanyEmail;
	}

	public String getCompanyTel() {
		return CompanyTel;
	}
	
	public void setCompanyEmail(String companyEmail) {
		CompanyEmail = companyEmail;
	}
	
	public void setCompanyTel(String companyTel) {
		CompanyTel = companyTel;
	}

	public String getCompanyCity() {
		return CompanyCity;
	}

	public void setCompanyCity(String companyCity) {
		CompanyCity = companyCity;
	}

	public int getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(Integer companyID) {
		CompanyID = (Integer) companyID;
	}
	
	/**
	 * @return the object property.
	 * @param arg0 int
	 */

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return CompanyID;
			case 1:
				return CompanyName;
			case 2:
				return CompanyDescription;
			case 3:
				return CompanyDate;
			case 4:
				return CompanyEmail;
			case 5:
				return CompanyTel;
			case 6:
				return CompanyCity;
		}
		return null;
	}

	/**
	 * @return int property count.
	 */
	
	@Override
	public int getPropertyCount() {
		return 6;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "CompanyID";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CompanyName";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CompanyDescription";
				break;
			case 3:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CompanyDate";
				break;
			case 4:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CompanyEmail";
				break;
			case 5:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CompanyTel";
				break;
			case 6:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CompanyCity";
				break;
			default:
				break;
		}
	}

	/**
	 * This method sets each property to a string.
	 * @param index
	 * @param value
	 */
	
	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			CompanyID = Integer.parseInt(value.toString());
			break;
		case 1:
			CompanyName = value.toString();
			break;
		case 2:
			CompanyDescription = value.toString();
			break;
		case 3:
			CompanyDate = value.toString();
			break;
		case 4:
			CompanyEmail = value.toString();
			break;
		case 5:
			CompanyTel = value.toString();
			break;
		case 6:
			CompanyCity = value.toString();
			break;
		default:
			break;
		}
	}

	/**
	 * This method returns the type class of a property.
	 * @return type class
	 * @param name String Name of the property as a String
	 */
	
	@Override
	public Class<?> getPropertyClass(String name) {
		userFields fieldName = userFields.valueOf(name);
		
		switch(fieldName){
		case CompanyID:
			return Integer.class;
		case CompanyName:
			return String.class;
		case CompanyDescription:
			return String.class;
		case CompanyDate:
			return String.class;
		case CompanyEmail:
			return String.class;
		case CompanyTel:
			return String.class;
		case CompanyCity:
			return String.class;
		default:
			return null;
		}
	}
}
