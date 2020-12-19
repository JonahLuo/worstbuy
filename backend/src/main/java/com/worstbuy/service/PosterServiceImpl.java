package com.worstbuy.service;

import com.worstbuy.dao.PosterDAO;
import com.worstbuy.model.Poster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PosterServiceImpl implements PosterService{

    private PosterDAO posterDAO;

    @Autowired
    public PosterServiceImpl(PosterDAO posterDAO) {
        this.posterDAO = posterDAO;
    }

    @Override
    @Transactional
    public Poster get(long id) {
        return posterDAO.get(id);
    }

    @Override
    @Transactional
    public long save(Poster poster) {
        return posterDAO.save(poster);
    }

    @Override
    @Transactional
    public List<Poster> list() {
        return posterDAO.list();
    }

    @Override
    @Transactional
    public void update(long id, Poster poster) {
        posterDAO.update(id, poster);
    }

    @Override
    @Transactional
    public void delete(long id) {
        posterDAO.delete(id);
    }

    @Override
    @Transactional
    public List<Poster> getAllByCategory(String category) {
        return posterDAO.getAllByCategory(category);
    }
}
