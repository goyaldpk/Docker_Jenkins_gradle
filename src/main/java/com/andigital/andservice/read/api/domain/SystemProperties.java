package com.andigital.andservice.read.api.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "system_properties")
public class SystemProperties {

	@Id 
	private String id;

	private String last_updated_date;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the last_updated_date
	 */
	public String getLast_updated_date() {
		return last_updated_date;
	}

	/**
	 * @param last_updated_date the last_updated_date to set
	 */
	public void setLast_updated_date(String last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemProperties [id=");
		builder.append(id);
		builder.append(", last_updated_date=");
		builder.append(last_updated_date);
		builder.append("]");
		return builder.toString();
	}
}