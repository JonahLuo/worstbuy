package com.worstbuy.service;

import com.worstbuy.model.Image;

public interface ImageService {
    Image findById(long id);

    Image findByName(String name);

    Long save(Image image);
}
