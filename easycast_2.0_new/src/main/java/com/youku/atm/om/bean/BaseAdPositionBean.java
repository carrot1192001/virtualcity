
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
 * extended; all references should be to AdPositionBean
 */
public abstract class BaseAdPositionBean
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

    /** The value for the name field */
    private String name;

    /** The value for the media field */
    private String media;

    /** The value for the device field */
    private String device;

    /** The value for the type field */
    private String type;

    /** The value for the posType field */
    private String posType;

    /** The value for the posSubType field */
    private String posSubType;

    /** The value for the reqPoint field */
    private String reqPoint;

    /** The value for the pageComment field */
    private String pageComment;

    /** The value for the place field */
    private String place;

    /** The value for the pageSize field */
    private String pageSize;

    /** The value for the template field */
    private String template;

    /** The value for the seqNum field */
    private String seqNum;

    /** The value for the oldId field */
    private String oldId;

    /** The value for the value field */
    private String value;

    /** The value for the updateTime field */
    private String updateTime;

    /** The value for the status field */
    private String status;


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
     * Get the Media
     *
     * @return String
     */
    public String getMedia ()
    {
        return media;
    }

    /**
     * Set the value of Media
     *
     * @param v new value
     */
    public void setMedia(String v)
    {

        this.media = v;
        setModified(true);

    }

    /**
     * Get the Device
     *
     * @return String
     */
    public String getDevice ()
    {
        return device;
    }

    /**
     * Set the value of Device
     *
     * @param v new value
     */
    public void setDevice(String v)
    {

        this.device = v;
        setModified(true);

    }

    /**
     * Get the Type
     *
     * @return String
     */
    public String getType ()
    {
        return type;
    }

    /**
     * Set the value of Type
     *
     * @param v new value
     */
    public void setType(String v)
    {

        this.type = v;
        setModified(true);

    }

    /**
     * Get the PosType
     *
     * @return String
     */
    public String getPosType ()
    {
        return posType;
    }

    /**
     * Set the value of PosType
     *
     * @param v new value
     */
    public void setPosType(String v)
    {

        this.posType = v;
        setModified(true);

    }

    /**
     * Get the PosSubType
     *
     * @return String
     */
    public String getPosSubType ()
    {
        return posSubType;
    }

    /**
     * Set the value of PosSubType
     *
     * @param v new value
     */
    public void setPosSubType(String v)
    {

        this.posSubType = v;
        setModified(true);

    }

    /**
     * Get the ReqPoint
     *
     * @return String
     */
    public String getReqPoint ()
    {
        return reqPoint;
    }

    /**
     * Set the value of ReqPoint
     *
     * @param v new value
     */
    public void setReqPoint(String v)
    {

        this.reqPoint = v;
        setModified(true);

    }

    /**
     * Get the PageComment
     *
     * @return String
     */
    public String getPageComment ()
    {
        return pageComment;
    }

    /**
     * Set the value of PageComment
     *
     * @param v new value
     */
    public void setPageComment(String v)
    {

        this.pageComment = v;
        setModified(true);

    }

    /**
     * Get the Place
     *
     * @return String
     */
    public String getPlace ()
    {
        return place;
    }

    /**
     * Set the value of Place
     *
     * @param v new value
     */
    public void setPlace(String v)
    {

        this.place = v;
        setModified(true);

    }

    /**
     * Get the PageSize
     *
     * @return String
     */
    public String getPageSize ()
    {
        return pageSize;
    }

    /**
     * Set the value of PageSize
     *
     * @param v new value
     */
    public void setPageSize(String v)
    {

        this.pageSize = v;
        setModified(true);

    }

    /**
     * Get the Template
     *
     * @return String
     */
    public String getTemplate ()
    {
        return template;
    }

    /**
     * Set the value of Template
     *
     * @param v new value
     */
    public void setTemplate(String v)
    {

        this.template = v;
        setModified(true);

    }

    /**
     * Get the SeqNum
     *
     * @return String
     */
    public String getSeqNum ()
    {
        return seqNum;
    }

    /**
     * Set the value of SeqNum
     *
     * @param v new value
     */
    public void setSeqNum(String v)
    {

        this.seqNum = v;
        setModified(true);

    }

    /**
     * Get the OldId
     *
     * @return String
     */
    public String getOldId ()
    {
        return oldId;
    }

    /**
     * Set the value of OldId
     *
     * @param v new value
     */
    public void setOldId(String v)
    {

        this.oldId = v;
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
     * @return String
     */
    public String getUpdateTime ()
    {
        return updateTime;
    }

    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(String v)
    {

        this.updateTime = v;
        setModified(true);

    }

    /**
     * Get the Status
     *
     * @return String
     */
    public String getStatus ()
    {
        return status;
    }

    /**
     * Set the value of Status
     *
     * @param v new value
     */
    public void setStatus(String v)
    {

        this.status = v;
        setModified(true);

    }

    

}
