package com.rurbisservices.demo.kafka.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class CustomSchema4 {
    @JsonProperty("schema_4_property_1")
    @JsonPropertyDescription("Property 1 description")
    private String property1;

    @JsonProperty("schema_4_property_2")
    @JsonPropertyDescription("Property 2 description")
    private String property2;

    @JsonProperty("schema_4_property_3")
    @JsonPropertyDescription("Property 3 description")
    private String property3;

    @JsonProperty("schema_4_property_4")
    @JsonPropertyDescription("Property 4 description")
    private String property4;

    public CustomSchema4 withProperty1(String property1) {
        this.property1 = property1;
        return this;
    }

    public CustomSchema4 withProperty2(String property2) {
        this.property2 = property2;
        return this;
    }

    public CustomSchema4 withProperty3(String property3) {
        this.property3 = property3;
        return this;
    }

    public CustomSchema4 withProperty4(String property4) {
        this.property4 = property4;
        return this;
    }

    @Override
    public String toString() {
        return "CustomSchema4{" +
                "property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                ", property3='" + property3 + '\'' +
                ", property4='" + property4 + '\'' +
                '}';
    }
}
