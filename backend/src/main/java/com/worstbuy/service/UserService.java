package com.worstbuy.service;

import com.worstbuy.model.User;

import java.util.List;

public interface UserService {
    /**
     * save the User
     * @param user the user to be saved
     * @return the id of the saved User
     */
    Long save(User user);

    /**
     * update the given User
     * @param user the user to be upated
     */
    void update(User user);

    /**
     * get the user
     * @param id    the id of the user
     * @return      the target user
     */
    User get(Long id);

    /**
     * get all of the user
     * @return the list of the user
     */
    List<User> list();

    /**
     * delete the user
     * @param id    the id of the user to be deleted
     */
    void delete(Long id);
}
