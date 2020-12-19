package com.worstbuy.service;

import com.worstbuy.model.User;

import java.util.List;

public interface UserService {
    /**
     * save the User
     * @param user the user to be saved
     * @return the id of the saved User
     */
    long save(User user);

    /**
     * update the given User
     * @param id
     * @param user the user to be upated
     */
    void update(long id, User user);

    /**
     * get the user
     * @param id    the id of the user
     * @return      the target user
     */
    User get(long id);

    /**
     * get the user by username
     * @param username  the username of the user
     * @return          the target user or null if it dose not exist
     */
    User getByName(String username);

    /**
     * get all of the user
     * @return the list of the user
     */
    List<User> list();

    /**
     * delete the user
     * @param id    the id of the user to be deleted
     */
    void delete(long id);

    /**
     * Get User by email
     * @param email     the email of the target user
     * @return          target user
     */
    User findUserByEmail(String email);

    boolean checkBeforeSignup(User user);
}
