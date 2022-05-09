
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
 * extended; all references should be to VhideaCpmBean
 */
public abstract class BaseVhideaCpmBean
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

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the cpm field */
    private int cpm;

    /** The value for the cpc field */
    private int cpc;

    /** The value for the rate field */
    private int rate;

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
     * Get the IdeaId
     *
     * @return int
     */
    public int getIdeaId ()
    {
        return ideaId;
    }

    /**
     * Set the value of IdeaId
     *
     * @param v new value
     */
    public void setIdeaId(int v)
    {

        this.ideaId = v;
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
     * Get the Rate
     *
     * @return int
     */
    public int getRate ()
    {
        return rate;
    }

    /**
     * Set the value of Rate
     *
     * @param v new value
     */
    public void setRate(int v)
    {

        this.rate = v;
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

    



    private IdeaBean aIdeaBean;

    /**
     * sets an associated IdeaBean object
     *
     * @param v IdeaBean
     */
    public void setIdeaBean(IdeaBean v)
    {
        if (v == null)
        {
            setIdeaId( 0);
        }
        else
        {
            setIdeaId(v.getId());
        }
        aIdeaBean = v;
    }


    /**
     * Get the associated IdeaBean object
     *
     * @return the associated IdeaBean object
     */
    public IdeaBean getIdeaBean()
    {
        return aIdeaBean;
    }



}
