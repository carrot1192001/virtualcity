
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
 * extended; all references should be to CastSceneBean
 */
public abstract class BaseCastSceneBean
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

    /** The value for the castId field */
    private int castId;

    /** The value for the directName field */
    private String directName;

    /** The value for the directValue field */
    private String directValue;

    /** The value for the isPositive field */
    private int isPositive = 1;


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
     * Get the CastId
     *
     * @return int
     */
    public int getCastId ()
    {
        return castId;
    }

    /**
     * Set the value of CastId
     *
     * @param v new value
     */
    public void setCastId(int v)
    {

        this.castId = v;
        setModified(true);

    }

    /**
     * Get the DirectName
     *
     * @return String
     */
    public String getDirectName ()
    {
        return directName;
    }

    /**
     * Set the value of DirectName
     *
     * @param v new value
     */
    public void setDirectName(String v)
    {

        this.directName = v;
        setModified(true);

    }

    /**
     * Get the DirectValue
     *
     * @return String
     */
    public String getDirectValue ()
    {
        return directValue;
    }

    /**
     * Set the value of DirectValue
     *
     * @param v new value
     */
    public void setDirectValue(String v)
    {

        this.directValue = v;
        setModified(true);

    }

    /**
     * Get the IsPositive
     *
     * @return int
     */
    public int getIsPositive ()
    {
        return isPositive;
    }

    /**
     * Set the value of IsPositive
     *
     * @param v new value
     */
    public void setIsPositive(int v)
    {

        this.isPositive = v;
        setModified(true);

    }

    



    private AdCastBean aAdCastBean;

    /**
     * sets an associated AdCastBean object
     *
     * @param v AdCastBean
     */
    public void setAdCastBean(AdCastBean v)
    {
        if (v == null)
        {
            setCastId( 0);
        }
        else
        {
            setCastId(v.getId());
        }
        aAdCastBean = v;
    }


    /**
     * Get the associated AdCastBean object
     *
     * @return the associated AdCastBean object
     */
    public AdCastBean getAdCastBean()
    {
        return aAdCastBean;
    }



}
