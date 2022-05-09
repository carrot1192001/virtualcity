
package com.youku.atm.om.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to AreaBean
 */
public abstract class BaseAreaBean
    implements Serializable
{

    /**
     * whether the bean or its underlying object has changed
     * since last reading from the database
     */
    private boolean modified = true;

    /**
     * false if the underlying object has been read from the database,
     * true otherwise
     */
    private boolean isNew = true;


    /** The value for the id field */
    private String id;

    /** The value for the parentId field */
    private String parentId;

    /** The value for the level field */
    private String level;

    /** The value for the name field */
    private String name;

    /** The value for the status field */
    private int status = 1;

    /** The value for the description field */
    private String description;


    /**
     * sets whether the bean exists in the database
     */
    public void setNew(boolean isNew)
    {
        this.isNew = isNew;
    }

    /**
     * returns whether the bean exists in the database
     */
    public boolean isNew()
    {
        return this.isNew;
    }

    /**
     * sets whether the bean or the object it was created from
     * was modified since the object was last read from the database
     */
    public void setModified(boolean isModified)
    {
        this.modified = isModified;
    }

    /**
     * returns whether the bean or the object it was created from
     * was modified since the object was last read from the database
     */
    public boolean isModified()
    {
        return this.modified;
    }


    /**
     * Get the Id
     *
     * @return String
     */
    public String getId ()
    {
        return id;
    }

    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(String v)
    {

        this.id = v;
        setModified(true);

    }

    /**
     * Get the ParentId
     *
     * @return String
     */
    public String getParentId ()
    {
        return parentId;
    }

    /**
     * Set the value of ParentId
     *
     * @param v new value
     */
    public void setParentId(String v)
    {

        this.parentId = v;
        setModified(true);

    }

    /**
     * Get the Level
     *
     * @return String
     */
    public String getLevel ()
    {
        return level;
    }

    /**
     * Set the value of Level
     *
     * @param v new value
     */
    public void setLevel(String v)
    {

        this.level = v;
        setModified(true);

    }

    /**
     * Get the Name
     *
     * @return String
     */
    public String getName ()
    {
        return name;
    }

    /**
     * Set the value of Name
     *
     * @param v new value
     */
    public void setName(String v)
    {

        this.name = v;
        setModified(true);

    }

    /**
     * Get the Status
     *
     * @return int
     */
    public int getStatus ()
    {
        return status;
    }

    /**
     * Set the value of Status
     *
     * @param v new value
     */
    public void setStatus(int v)
    {

        this.status = v;
        setModified(true);

    }

    /**
     * Get the Description
     *
     * @return String
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * Set the value of Description
     *
     * @param v new value
     */
    public void setDescription(String v)
    {

        this.description = v;
        setModified(true);

    }

    



    /**
     * Collection to store aggregation of collCastAreaBeans
     */
    protected List<CastAreaBean> collCastAreaBeans;

    /**
     * Returns the collection of CastAreaBeans
     */
    public List<CastAreaBean> getCastAreaBeans()
    {
        return collCastAreaBeans;
    }

    /**
     * Sets the collection of CastAreaBeans to the specified value
     */
    public void setCastAreaBeans(List<CastAreaBean> list)
    {
        if (list == null)
        {
            collCastAreaBeans = null;
        }
        else
        {
            collCastAreaBeans = new ArrayList<CastAreaBean>(list);
        }
    }

}
