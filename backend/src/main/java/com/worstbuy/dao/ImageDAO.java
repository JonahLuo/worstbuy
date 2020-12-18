package com.worstbuy.dao;

import com.worstbuy.model.Image;

public interface ImageDAO {
    Image findById(long id);

    Image findByName(String name);

    Long save(Image image);
}
