package com.example.shop.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_item;
    private String itemName;
    private String itemDesc;
    private String itemQuality;
    private Integer whoAdd;
    private Byte[] image;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemQuality() {
        return itemQuality;
    }

    public void setItemQuality(String itemQuality) {
        this.itemQuality = itemQuality;
    }

    public Integer getId() {
        return id_item;
    }

    public void setId(Integer id) {
        this.id_item = id;
    }

    public Integer getWhoAdd() {
        return whoAdd;
    }

    public void setWhoAdd(Integer whoAdd) {
        this.whoAdd = whoAdd;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
