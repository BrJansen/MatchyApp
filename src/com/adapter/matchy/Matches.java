package com.adapter.matchy;

/**
 * Getters and setters for all match properties.
 * 
 * @author Grand Tech Assembly
 */

public class Matches {
	
	private int matchId;
    private String matchType;
    private String company;
    private String date;
    private String workTime;
    private String place;
    private String education;
    private String description;


	/**
	 * @return the matchId
	 */
	public int getMatchId() {
		return matchId;
	}
	
	/**
	 * @return the matchType
	 */
	public String getMatchType() {
		return matchType;
	}
	
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * @return the workTime
	 */
	public String getWorkTime() {
		return workTime;
	}
	
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	

	/**
	 * @param matchId the matchId to set
	 */
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	
	/**
	 * @param matchType the matchType to set
	 */
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * @param workTime the workTime to set
	 */
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
