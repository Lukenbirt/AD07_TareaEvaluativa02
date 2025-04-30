package eus.birt.dam.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.AllArgsConstructor;
import lombok.Data;


// solo se incluirán en el JSON las propiedades que no sean nulas
@JsonInclude(JsonInclude.Include.NON_NULL) 
// especifica el orden en el que las propiedades del objeto deben aparecer en el JSON
@JsonPropertyOrder({
    "_id",
    "id",
    "type",
    "geometry",
    "properties"
})

@Data
@AllArgsConstructor
@Document(collection="aeropuertos")

public class Aeropuerto {
		
	@JsonProperty("_id")
	private String id;
	@JsonProperty("id")
    private Integer aeropuertoId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("geometry")
    private Geometry geometry;
	@JsonProperty("properties")
	private Properties properties; 

}
