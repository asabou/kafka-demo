package com.rurbisservices.demo.kafka.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

//@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class CustomSchema1 {
    @JsonProperty("schema_1_property_1")
    @JsonPropertyDescription("Property 1 description")
    private String property1;

    public CustomSchema1 withProperty1(String property1) {
        this.property1 = property1;
        return this;
    }

    @Override
    public String toString() {
        return "CustomSchema1{" +
                "property1='" + property1 + '\'' +
                '}';
    }
}
