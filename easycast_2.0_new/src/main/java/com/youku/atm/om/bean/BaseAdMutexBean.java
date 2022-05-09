
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
 * extended; all references should be to AdMutexBean
 */
public abstract class BaseAdMutexBean
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

    /** The value for the mutexId field */
    private int mutexId;

    /** The value for the subjectType field */
    private int subjectType;

    /** The value for the subjectValue field */
    private String subjectValue;

    /** The value for the objectType field */
    private int objectType;

    /** The value for the objectValue field */
    private String objectValue;

    /** The value for the adType field */
    private String adType;

    /** The value for the subAdType field */
    private String subAdType;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the startTime field */
    private Date startTime;

    /** The value for the endTime field */
    private Date endTime;

    /** The value for the status field */
    private int status = 1;


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
     * Get the MutexId
     *
     * @return int
     */
    public int getMutexId ()
    {
        return mutexId;
    }

    /**
     * Set the value of MutexId
     *
     * @param v new value
     */
    public void setMutexId(int v)
    {

        this.mutexId = v;
        setModified(true);

    }

    /**
     * Get the SubjectType
     *
     * @return int
     */
    public int getSubjectType ()
    {
        return subjectType;
    }

    /**
     * Set the value of SubjectType
     *
     * @param v new value
     */
    public void setSubjectType(int v)
    {

        this.subjectType = v;
        setModified(true);

    }

    /**
     * Get the SubjectValue
     *
     * @return String
     */
    public String getSubjectValue ()
    {
        return subjectValue;
    }

    /**
     * Set the value of SubjectValue
     *
     * @param v new value
     */
    public void setSubjectValue(String v)
    {

        this.subjectValue = v;
        setModified(true);

    }

    /**
     * Get the ObjectType
     *
     * @return int
     */
    public int getObjectType ()
    {
        return objectType;
    }

    /**
     * Set the value of ObjectType
     *
     * @param v new value
     */
    public void setObjectType(int v)
    {

        this.objectType = v;
        setModified(true);

    }

    /**
     * Get the ObjectValue
     *
     * @return String
     */
    public String getObjectValue ()
    {
        return objectValue;
    }

    /**
     * Set the value of ObjectValue
     *
     * @param v new value
     */
    public void setObjectValue(String v)
    {

        this.objectValue = v;
        setModified(true);

    }

    /**
     * Get the AdType
     *
     * @return String
     */
    public String getAdType ()
    {
        return adType;
    }

    /**
     * Set the value of AdType
     *
     * @param v new value
     */
    public void setAdType(String v)
    {

        this.adType = v;
        setModified(true);

    }

    /**
     * Get the SubAdType
     *
     * @return String
     */
    public String getSubAdType ()
    {
        return subAdType;
    }

    /**
     * Set the value of SubAdType
     *
     * @param v new value
     */
    public void setSubAdType(String v)
    {

        this.subAdType = v;
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
