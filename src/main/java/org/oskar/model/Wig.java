package org.oskar.model;

import java.io.Serializable;


public class Wig implements Serializable{

    private String type;
    private String color;
    private String length;
    private String productType;
    private String form;

    public Wig(String type, String color, String length, String productType, String form) {
        this.type = type;
        this.color = color;
        this.length = length;
        this.productType = productType;
        this.form = form;
    }

    public Wig(String type, String color, String length, String productType) {
        this.type = type;
        this.color = color;
        this.length = length;
        this.productType = productType;
        this.form = "";
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }


}
