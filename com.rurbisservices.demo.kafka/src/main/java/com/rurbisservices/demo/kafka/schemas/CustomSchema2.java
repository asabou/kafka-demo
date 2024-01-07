package com.rurbisservices.demo.kafka.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class CustomSchema2 {
    @JsonProperty("schema_2_property_1")
    @JsonPropertyDescription("Property 1 description")
    private String property1;

    @JsonProperty("schema_2_property_2")
    @JsonPropertyDescription("Property 2 description")
    private String property2;

    public CustomSchema2 withProperty1(String property1) {
        this.property1 = property1;
        return this;
    }

    public CustomSchema2 withProperty2(String property2) {
        this.property2 = property2;
        return this;
    }

    @Override
    public String toString() {
        return "CustomSchema2{" +
                "property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                '}';
    }
}
