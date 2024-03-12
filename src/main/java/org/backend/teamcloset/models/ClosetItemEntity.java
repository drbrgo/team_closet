package org.backend.teamcloset.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ClosetItemEntity extends AbstractEntity {


    private String model;

    private String series;
    private String size;
    private String season;
    private Long quantity;
    private String gender;
    private String bodyPart;
    private Float price;

    public ClosetItemEntity() {}
    public ClosetItemEntity(String model, String series, String size, String season, Long quantity, String gender, String bodyPart, Float price) {
        this.model = model;
        this.series = series;
        this.size = size;
        this.season = season;
        this.quantity = quantity;
        this.gender = gender;
        this.bodyPart = bodyPart;
        this.price = price;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}