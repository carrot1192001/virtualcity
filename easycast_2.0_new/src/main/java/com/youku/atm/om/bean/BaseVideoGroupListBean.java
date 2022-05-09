
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
 * extended; all references should be to VideoGroupListBean
 */
public abstract class BaseVideoGroupListBean
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

    /** The value for the type field */
    private int type;

    /** The value for the value field */
    private String value;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the startTime field */
    private Date startTime;

    /** The value for the endTime field */
    private Date endTime;

    /** The value for the videoGroupId field */
    private int videoGroupId;

    /** The value for the status field */
    private int status;


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
     * Get the Type
     *
     * @return int
     */
    public int getType ()
    {
        return type;
    }

    /**
     * Set the value of Type
     *
     * @param v new value
     */
    public void setType(int v)
    {

        this.type = v;
        setModified(true);

    }

    /**
     * Get the Value
     *
     * @return String
     */
    public String getValue ()
    {
        return value;
    }

    /**
     * Set the value of Value
     *
     * @param v new value
     */
    public void setValue(String v)
    {

        this.value = v;
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
     * Get the StartTime
     *
     * @return Date
     */
    public Date getStartTime ()
    {
        return startTime;
    }

    /**
     * Set the value of StartTime
     *
     * @param v new value
     */
    public void setStartTime(Date v)
    {

        this.startTime = v;
        setModified(true);

    }

    /**
     * Get the EndTime
     *
     * @return Date
     */
    public Date getEndTime ()
    {
        return endTime;
    }

    /**
     * Set the value of EndTime
     *
     * @param v new value
     */
    public void setEndTime(Date v)
    {

        this.endTime = v;
        setModified(true);

    }

    /**
     * Get the VideoGroupId
     *
     * @return int
     */
    public int getVideoGroupId ()
    {
        return videoGroupId;
    }

    /**
     * Set the value of VideoGroupId
     *
     * @param v new value
     */
    public void setVideoGroupId(int v)
    {

        this.videoGroupId = v;
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

    

}
