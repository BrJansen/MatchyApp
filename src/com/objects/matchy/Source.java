package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

public class Source extends SoapObjectAbstract implements Serializable{

	/**
	* This class contains all the getters and setters for each SOURCE object property.
	* Additionally, it parses each object property to it's corresponding type.
	* @author Grand Tech Assembly 
	* @version 0.9
	*/
	
	private static final long serialVersionUID = 1L;
	private String Description;
	private int SourceId;

	private enum userFields {
		Description, SourceId;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @return the sourceId
	 */
	public int getSourceId() {
		return SourceId;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(Integer sourceId) {
		SourceId = (Integer) sourceId;
	}
	
	/**
	 * @return the object property.
	 * @param int arg0
	 */
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return SourceId;
		case 1:
			return Description;
		}
		return null;
	}

	/**
	 * @return int property count.
	 */
	
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
			info.name = "SourceId";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Description";
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
			SourceId = Integer.parseInt(value.toString());
			break;
		case 1:
			Description = value.toString();
			break;
		default:
			break;
		}
	}
	
	/**
	 * This method returns the type class of a property.
	 * @return type class
	 * @param String name Name of the property as a String
	 */
	
	@Override
	public Class<?> getPropertyClass(String name) {
		userFields fieldName = userFields.valueOf(name);
		
		switch(fieldName){
		case SourceId:
			return Integer.class;
		case Description:
			return String.class;
		default:
			return null;
		}
	}
}
