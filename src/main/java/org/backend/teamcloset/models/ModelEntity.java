package org.backend.teamcloset.models;

import jakarta.persistence.Entity;


@Entity
public class ModelEntity extends AbstractEntity{


    private String modelName;

    public ModelEntity() {}
    public ModelEntity(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}

