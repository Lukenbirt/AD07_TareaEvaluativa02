package eus.birt.dam.domain;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"documentname",
"documentdescription",
"templatetype",
"marks",
"tourismemail",
"web",
"municipality",
"municipalitycode",
"territory",
"territorycode",
"country",
"countrycode",
"friendlyurl",
"physicalurl",
"dataxml",
"metadataxml",
"zipfile"
})

@Data
@NoArgsConstructor
@Generated("jsonschema2pojo")
public class Properties {

	@JsonProperty("documentname")
	public String documentname;
	@JsonProperty("documentdescription")
	public String documentdescription;
	@JsonProperty("templatetype")
	public String templatetype;
	@JsonProperty("marks")
	public String marks;
	@JsonProperty("tourismemail")
	public String tourismemail;
	@JsonProperty("web")
	public String web;
	@JsonProperty("municipality")
	public String municipality;
	@JsonProperty("municipalitycode")
	public String municipalitycode;
	@JsonProperty("territory")
	public String territory;
	@JsonProperty("territorycode")
	public String territorycode;
	@JsonProperty("country")
	public String country;
	@JsonProperty("countrycode")
	public String countrycode;
	@JsonProperty("friendlyurl")
	public String friendlyurl;
	@JsonProperty("physicalurl")
	public String physicalurl;
	@JsonProperty("dataxml")
	public String dataxml;
	@JsonProperty("metadataxml")
	public String metadataxml;
	@JsonProperty("zipfile")
	public String zipfile;
}

