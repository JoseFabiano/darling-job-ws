package com.bandtec.darlingjob.dto.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Locale;

public enum RoleEnum {
    @JsonProperty("profissional")
    PROFISSIONAL("PROFISSIONAL"),
    @JsonProperty("contratante")
    CONTRATANTE("CONTRATANTE");

    private String description;

    RoleEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description.toLowerCase(Locale.ROOT);
    }
}
