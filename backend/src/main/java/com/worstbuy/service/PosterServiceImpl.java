package com.worstbuy.service;

import com.worstbuy.dao.PosterDAO;
import com.worstbuy.model.Poster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosterServiceImpl implements PosterService{

    private PosterDAO posterDAO;

    @Autowired
    public PosterServiceImpl(PosterDAO posterDAO) {
        this.posterDAO = posterDAO;
    }

    @Override
    public Poster get(long id) {
        return null;
    }

    @Override
    public long save(Poster poster) {
        return 0;
    }

    @Override
    public List<Poster> list() {
        return null;
    }

    @Override
    public void update(Poster poster) {

    }

    @Override
    public void delete(long id) {

    }
}
