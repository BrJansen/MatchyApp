package com.objects.matchy;

import java.io.Serializable;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

import com.soaps.matchy.SoapObjectAbstract;

public class DetailJob extends SoapObjectAbstract implements Serializable {

	/**
	 * 
	 */

	private String Data;
	private int DetailJobId;
	private int JobId;
	private static final long serialVersionUID = 1L;

	private enum detailJobFields {
		Data, DetailJobId, JobId;
	}

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return Data;
		case 1:
			return DetailJobId;
		case 2:
			return JobId;
		}
		return null;
	}

	/**
	 * @return the jobId
	 */
	public int getJobId() {
		return JobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(int jobId) {
		JobId = jobId;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return Data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		Data = data;
	}

	/**
	 * @return the detailJobId
	 */
	public int getDetailJobId() {
		return DetailJobId;
	}

	/**
	 * @param detailJobId the detailJobId to set
	 */
	public void setDetailJobId(int detailJobId) {
		DetailJobId = detailJobId;
	}

	@Override
	public int getPropertyCount() {
		return 3;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "Data";
			break;
		case 1:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "DetailJobId";
			break;
		case 2:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "JobId";
			break;	
		default:
			break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			Data = value.toString();
			break;
		case 1:
			DetailJobId = Integer.parseInt(value.toString());
			break;
		case 2:
			JobId = Integer.parseInt(value.toString());
			break;
		default:
			break;
		}
	}

	@Override
	public Class<?> getPropertyClass(String name) {
		detailJobFields fieldName = detailJobFields.valueOf(name);
		switch (fieldName) {
		case Data:
			return String.class;
		case DetailJobId:
			return Integer.class;
		case JobId:
			return Integer.class;
		default:
			return null;
		}
	}
}
