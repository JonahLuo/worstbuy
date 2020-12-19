package com.worstbuy.service;

import com.worstbuy.model.Poster;

import java.util.List;

public interface PosterService {
    /**
     * get the poster
     * @param id the id of the poster to be found
     * @return the Poster looking for
     */
    Poster get(long id);

    /**
     * save the given poster
     * @param poster the poster to be saved
     * @return the id of the poster saved
     */
    long save(Poster poster);

    /**
     * get all of the poster
     * @return the list of posters
     */
    List<Poster> list();

    /**
     * update the poster
     * @param id
     * @param poster the poster to be updated
     */
    void update(long id, Poster poster);

    /**
     * delete the poster
     * @param id the id of the poster to be deleted
     */
    void delete(long id);

    List<Poster> getAllByCategory(String category);
}
