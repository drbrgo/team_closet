package org.backend.teamcloset.models.dto;


public class ClosetItemDTO {

    private String model;
    private String series;
    private String size;
    private String season;
    private Long quantity;
    private String gender;
    private String bodyPart;
    private Float price;

    public ClosetItemDTO(String model, String series, String size, String season, Long quantity, String gender, String bodyPart, Float price) {
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

    public String getSeries() {
        return series;
    }

    public String getSize() {
        return size;
    }

    public String getSeason() {
        return season;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getGender() {
        return gender;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public Float getPrice() {
        return price;
    }
}