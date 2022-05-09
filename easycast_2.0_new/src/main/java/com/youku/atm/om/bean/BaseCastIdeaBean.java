
package com.youku.atm.om.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * cast_idea
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to CastIdeaBean
 */
public abstract class BaseCastIdeaBean
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
    private long id;

    /** The value for the castId field */
    private int castId;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the status field */
    private int status = 1;

    /** The value for the issdk field */
    private int issdk = 1;

    /** The value for the iesorg field */
    private String iesorg;

    /** The value for the cuf field */
    private int cuf;

    /** The value for the mst field */
    private int mst = 0;

    /** The value for the monitorAddType field */
    private int monitorAddType = 0;

    /** The value for the weight field */
    private int weight = 0;

    /** The value for the isDefault field */
    private int isDefault = 0;


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
     * @return long
     */
    public long getId ()
    {
        return id;
    }

    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(long v)
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
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime ()
    {
        return updateTime;
    }

    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(Date v)
    {

        this.updateTime = v;
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
     * Get the Issdk
     *
     * @return int
     */
    public int getIssdk ()
    {
        return issdk;
    }

    /**
     * Set the value of Issdk
     *
     * @param v new value
     */
    public void setIssdk(int v)
    {

        this.issdk = v;
        setModified(true);

    }

    /**
     * Get the Iesorg
     *
     * @return String
     */
    public String getIesorg ()
    {
        return iesorg;
    }

    /**
     * Set the value of Iesorg
     *
     * @param v new value
     */
    public void setIesorg(String v)
    {

        this.iesorg = v;
        setModified(true);

    }

    /**
     * Get the Cuf
     *
     * @return int
     */
    public int getCuf ()
    {
        return cuf;
    }

    /**
     * Set the value of Cuf
     *
     * @param v new value
     */
    public void setCuf(int v)
    {

        this.cuf = v;
        setModified(true);

    }

    /**
     * Get the Mst
     *
     * @return int
     */
    public int getMst ()
    {
        return mst;
    }

    /**
     * Set the value of Mst
     *
     * @param v new value
     */
    public void setMst(int v)
    {

        this.mst = v;
        setModified(true);

    }

    /**
     * Get the MonitorAddType
     *
     * @return int
     */
    public int getMonitorAddType ()
    {
        return monitorAddType;
    }

    /**
     * Set the value of MonitorAddType
     *
     * @param v new value
     */
    public void setMonitorAddType(int v)
    {

        this.monitorAddType = v;
        setModified(true);

    }

    /**
     * Get the Weight
     *
     * @return int
     */
    public int getWeight ()
    {
        return weight;
    }

    /**
     * Set the value of Weight
     *
     * @param v new value
     */
    public void setWeight(int v)
    {

        this.weight = v;
        setModified(true);

    }

    /**
     * Get the IsDefault
     *
     * @return int
     */
    public int getIsDefault ()
    {
        return isDefault;
    }

    /**
     * Set the value of IsDefault
     *
     * @param v new value
     */
    public void setIsDefault(int v)
    {

        this.isDefault = v;
        setModified(true);

    }

    

}
