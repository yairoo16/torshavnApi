package com.orellanab.springboot.torshavn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marker", schema="public")
public class Marker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Double lat;
    @Column
    private Double lng;
    @Column
    private Boolean draggable;
    @Column
    private String animation;
    @Column
    private String imagePath;
    @Column
    private String label;
    @Column
    private String description;
    @Column
    private String iconPath;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLng() {

        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Boolean getDraggable() {
        return draggable;
    }

    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public String toString() {
        return "Marker{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                ", draggable=" + draggable +
                ", animation='" + animation + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", iconPath='" + iconPath + '\'' +
                '}';
    }
}

