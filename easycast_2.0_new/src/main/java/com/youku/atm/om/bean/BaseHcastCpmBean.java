
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
 * extended; all references should be to HcastCpmBean
 */
public abstract class BaseHcastCpmBean
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

    /** The value for the cpm field */
    private int cpm;

    /** The value for the cpc field */
    private int cpc;

    /** The value for the lun field */
    private String lun;

    /** The value for the percent field */
    private int percent;

    /** The value for the targetDate field */
    private Date targetDate;


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
     * Get the Cpm
     *
     * @return int
     */
    public int getCpm ()
    {
        return cpm;
    }

    /**
     * Set the value of Cpm
     *
     * @param v new value
     */
    public void setCpm(int v)
    {

        this.cpm = v;
        setModified(true);

    }

    /**
     * Get the Cpc
     *
     * @return int
     */
    public int getCpc ()
    {
        return cpc;
    }

    /**
     * Set the value of Cpc
     *
     * @param v new value
     */
    public void setCpc(int v)
    {

        this.cpc = v;
        setModified(true);

    }

    /**
     * Get the Lun
     *
     * @return String
     */
    public String getLun ()
    {
        return lun;
    }

    /**
     * Set the value of Lun
     *
     * @param v new value
     */
    public void setLun(String v)
    {

        this.lun = v;
        setModified(true);

    }

    /**
     * Get the Percent
     *
     * @return int
     */
    public int getPercent ()
    {
        return percent;
    }

    /**
     * Set the value of Percent
     *
     * @param v new value
     */
    public void setPercent(int v)
    {

        this.percent = v;
        setModified(true);

    }

    /**
     * Get the TargetDate
     *
     * @return Date
     */
    public Date getTargetDate ()
    {
        return targetDate;
    }

    /**
     * Set the value of TargetDate
     *
     * @param v new value
     */
    public void setTargetDate(Date v)
    {

        this.targetDate = v;
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
