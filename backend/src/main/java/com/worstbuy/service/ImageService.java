package com.worstbuy.service;

import com.worstbuy.model.Image;

import java.util.Optional;

public interface ImageService {
    void save(Image img);

    Optional<Image> findByName(String imageName);

    byte[] compressBytes(byte[] bytes);

    byte[] decompressBytes(byte[] picByte);
}
