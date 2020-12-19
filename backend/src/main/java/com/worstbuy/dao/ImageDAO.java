package com.worstbuy.dao;

import com.worstbuy.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDAO  extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
}
