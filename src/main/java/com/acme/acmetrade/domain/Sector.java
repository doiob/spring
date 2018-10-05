package com.acme.acmetrade.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sector {
	
	@JsonProperty(defaultValue="0")
	@ApiModelProperty(value="Representation of the sector id, as generated from the database")
	private int id;
	
	@JsonProperty()
	@ApiModelProperty(value="The name of the market sector, must be a unique name in the database")
	private String sectorName;
	
	@JsonProperty
	@ApiModelProperty(value="A description of the market sector")
	private String sectorDesc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getSectorDesc() {
		return sectorDesc;
	}
	public void setSectorDesc(String sectorDesc) {
		this.sectorDesc = sectorDesc;
	}
	
	public Sector() {};
	
	public Sector(String sectorName, String sectorDesc) {
		this.sectorName = sectorName;
		this.sectorDesc = sectorDesc;
	}
	
	public Sector(int id, String sectorName, String sectorDesc) {
		this.id = id;
		this.sectorName = sectorName;
		this.sectorDesc = sectorDesc;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sector [id=");
		builder.append(id);
		builder.append(", sectorName=");
		builder.append(sectorName);
		builder.append(", sectorDesc=");
		builder.append(sectorDesc);
		builder.append("]");
		return builder.toString();
	}
	
	
}
