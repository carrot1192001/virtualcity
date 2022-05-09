
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
 * extended; all references should be to CastEmbedBean
 */
public abstract class BaseCastEmbedBean
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

    /** The value for the videoIdYk field */
    private String videoIdYk;

    /** The value for the videoIdTd field */
    private String videoIdTd;

    /** The value for the breakId field */
    private String breakId;

    /** The value for the startTime field */
    private int startTime;

    /** The value for the showTime field */
    private int showTime;


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
     * Get the VideoIdYk
     *
     * @return String
     */
    public String getVideoIdYk ()
    {
        return videoIdYk;
    }

    /**
     * Set the value of VideoIdYk
     *
     * @param v new value
     */
    public void setVideoIdYk(String v)
    {

        this.videoIdYk = v;
        setModified(true);

    }

    /**
     * Get the VideoIdTd
     *
     * @return String
     */
    public String getVideoIdTd ()
    {
        return videoIdTd;
    }

    /**
     * Set the value of VideoIdTd
     *
     * @param v new value
     */
    public void setVideoIdTd(String v)
    {

        this.videoIdTd = v;
        setModified(true);

    }

    /**
     * Get the BreakId
     *
     * @return String
     */
    public String getBreakId ()
    {
        return breakId;
    }

    /**
     * Set the value of BreakId
     *
     * @param v new value
     */
    public void setBreakId(String v)
    {

        this.breakId = v;
        setModified(true);

    }

    /**
     * Get the StartTime
     *
     * @return int
     */
    public int getStartTime ()
    {
        return startTime;
    }

    /**
     * Set the value of StartTime
     *
     * @param v new value
     */
    public void setStartTime(int v)
    {

        this.startTime = v;
        setModified(true);

    }

    /**
     * Get the ShowTime
     *
     * @return int
     */
    public int getShowTime ()
    {
        return showTime;
    }

    /**
     * Set the value of ShowTime
     *
     * @param v new value
     */
    public void setShowTime(int v)
    {

        this.showTime = v;
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
