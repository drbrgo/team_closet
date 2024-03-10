package org.backend.teamcloset.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class ModelEntity extends AbstractEntity{


    private String modelName;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<ClosetItemEntity> closetItemEntityList;

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

