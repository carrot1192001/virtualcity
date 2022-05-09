
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
 * extended; all references should be to OverflowRangeBean
 */
public abstract class BaseOverflowRangeBean
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
    private int id;

    /** The value for the resourceId field */
    private int resourceId;

    /** The value for the contents field */
    private String contents;


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
     * @return int
     */
    public int getId ()
    {
        return id;
    }

    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(int v)
    {

        this.id = v;
        setModified(true);

    }

    /**
     * Get the ResourceId
     *
     * @return int
     */
    public int getResourceId ()
    {
        return resourceId;
    }

    /**
     * Set the value of ResourceId
     *
     * @param v new value
     */
    public void setResourceId(int v)
    {

        this.resourceId = v;
        setModified(true);

    }

    /**
     * Get the Contents
     *
     * @return String
     */
    public String getContents ()
    {
        return contents;
    }

    /**
     * Set the value of Contents
     *
     * @param v new value
     */
    public void setContents(String v)
    {

        this.contents = v;
        setModified(true);

    }

    



    private ResourceBean aResourceBean;

    /**
     * sets an associated ResourceBean object
     *
     * @param v ResourceBean
     */
    public void setResourceBean(ResourceBean v)
    {
        if (v == null)
        {
            setResourceId( 0);
        }
        else
        {
            setResourceId(v.getId());
        }
        aResourceBean = v;
    }


    /**
     * Get the associated ResourceBean object
     *
     * @return the associated ResourceBean object
     */
    public ResourceBean getResourceBean()
    {
        return aResourceBean;
    }



}
