/**
 * Copyright(c) 2013 Dialog-University of Moratuwa Mobile Communications Research Laboratory. All
 * Rights Reserved. This software is the proprietary information of Dialog-University of Moratuwa
 * Mobile Communications Research Laboratory(Dialog-UOM Lab).
 *
 * Dialog-UOM Lab or Dialog Axiata PLC reserves to right to modify, update and/or enhance the
 * software as it sees fit.
 *
 */
package lk.dialoglab.ezcash.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

/**
 * All the generic methods for database operations
 * 
 * @author Dewmini Premaratna
 * @since Feb 18, 2014,12:03:54 PM
 * @version 1.0
 * 
 */

public interface GenericDAO<T, ID extends Serializable> {

	
    /**
     * Save entity
     * 
     * @param entity - entity going to save
     */
    public void save(T entity);

    
    /**
     * Update entity
     * 
     * @param entity - entity going to update
     */
    public void update(T entity);

    /**
     * Delete entity
     * 
     * @param entity - entity going to delete
     */
    public void delete(T entity);

    /**
     * Give List of entities marching the query.
     * 
     * @param query - query to execute
     * @return - List of entities
     */
    public List<T> findMany(Query query);

    /**
     * Give entity marching the query.
     * 
     * @param query - query to execute
     * @return - entity
     */
    public T findOne(Query query);

    
    /**
     * All the records of particular entity
     * 
     * @param clazz - class name of the entity
     * @return - List of all entities
     */
    public List findAll(Class clazz);

    /**
     * All the records matching the entity unique id
     * 
     * @param clazz - class name of the entity
     * @param id - unique id
     * @return - entiy matched with the id
     */
    public T findByID(Class clazz, Number id);

}
