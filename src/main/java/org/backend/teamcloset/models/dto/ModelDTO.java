package org.backend.teamcloset.models.dto;

public class ModelDTO {

    private String modelName;


    public ModelDTO(String modelName) {
        this.modelName = modelName;
    }

    public ModelDTO () {}

    public String getModelName() {
        return modelName;
    }
}
