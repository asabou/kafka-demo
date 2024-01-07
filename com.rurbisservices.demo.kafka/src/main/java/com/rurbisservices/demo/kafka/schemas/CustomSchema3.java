package com.rurbisservices.demo.kafka.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class CustomSchema3 {
    @JsonProperty("schema_3_property_1")
    @JsonPropertyDescription("Property 1 description")
    private String property1;

    @JsonProperty("schema_3_property_2")
    @JsonPropertyDescription("Property 2 description")
    private String property2;

    @JsonProperty("schema_3_property_3")
    @JsonPropertyDescription("Property 3 description")
    private String property3;

    public CustomSchema3 withProperty1(String property1) {
        this.property1 = property1;
        return this;
    }

    public CustomSchema3 withProperty2(String property2) {
        this.property2 = property2;
        return this;
    }

    public CustomSchema3 withProperty3(String property3) {
        this.property3 = property3;
        return this;
    }

    @Override
    public String toString() {
        return "CustomSchema3{" +
                "property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                ", property3='" + property3 + '\'' +
                '}';
    }
}
