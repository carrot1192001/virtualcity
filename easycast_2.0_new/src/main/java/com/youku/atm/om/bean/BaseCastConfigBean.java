
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
 * extended; all references should be to CastConfigBean
 */
public abstract class BaseCastConfigBean
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

    /** The value for the castKey field */
    private String castKey;

    /** The value for the castValue field */
    private String castValue;


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
     * Get the CastKey
     *
     * @return String
     */
    public String getCastKey ()
    {
        return castKey;
    }

    /**
     * Set the value of CastKey
     *
     * @param v new value
     */
    public void setCastKey(String v)
    {

        this.castKey = v;
        setModified(true);

    }

    /**
     * Get the CastValue
     *
     * @return String
     */
    public String getCastValue ()
    {
        return castValue;
    }

    /**
     * Set the value of CastValue
     *
     * @param v new value
     */
    public void setCastValue(String v)
    {

        this.castValue = v;
        setModified(true);

    }

    

}
