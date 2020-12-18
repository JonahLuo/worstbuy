package com.worstbuy.model;

import javax.persistence.*;

@Entity
@Table(name="Image")
public class Image {
    @Id
    private Long id;

    private String type;

    private String name;

    @Column(name="picByte", length = 1000)
    private byte[] picByte;

    private Long ownerId;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
