/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Tweet;

/**
 *
 * @author teren
 */
public interface ITweetDao {
    
    /**
     *
     * @param id
     * @return
     */
    Tweet findById(long id);
    
    /**
     *
     * @return
     */
    List<Tweet> findAll();
    
    /**
     *
     * @param entity
     * @return
     */
    Tweet create(Tweet entity);
    
    /**
     *
     * @param entity
     * @return
     */
    Tweet update(Tweet entity);
    
    /**
     *
     * @param entity
     */
    void delete(Tweet entity);
}