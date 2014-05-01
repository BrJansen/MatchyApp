package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

public class EducationLevel extends SoapObjectAbstract implements Serializable{
	
	/**
	* This class contains all the getters and setters for each EDUCTAION object property.
	* Additionally, it parses each object property to it's corresponding type.
	* @author Grand Tech Assembly 
	* @version 0.9
	*/
	
	private static final long serialVersionUID = 1L;
	private int EducationId;
	private String Name;

	private enum userFields {
		EducationId, Name;
	}
	
	/**
	 * @return the educationId
	 */
	public int getEducationId() {
		return EducationId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param educationId the educationId to set
	 */
	public void setEducationId(Integer educationId) {
		EducationId = (Integer) educationId;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return EducationId;
			case 1:
				return Name;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 2;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "EducationId";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "Name";
				break;
			default:
				break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			EducationId = Integer.parseInt(value.toString());
			break;
		case 1:
			Name = value.toString();
			break;
		default:
			break;
		}
	}

	@Override
	public Class<?> getPropertyClass(String name) {
		userFields fieldName = userFields.valueOf(name);
		
		switch(fieldName){
		case EducationId:
			return Integer.class;
		case Name:
			return String.class;
		default:
			return null;
		}
	}
}
