
package com.geekplus.ark.om.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;




public abstract class BaseTWorkstationBean
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

    /** The value for the workstationName field */
    private String workstationName;

    /** The value for the locationX field */
    private int locationX;

    /** The value for the locationY field */
    private int locationY;

    /** The value for the angle field */
    private int angle;

    /** The value for the stopPointIds field */
    private String stopPointIds;

    /** The value for the creatorUsername field */
    private String creatorUsername;

    /** The value for the creationTime field */
    private Date creationTime;

    /** The value for the updatorUsername field */
    private String updatorUsername;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the status field */
    private int status = 1;

    /** The value for the floorId field */
    private int floorId;

    /** The value for the cellType field */
    private String cellType;

    /** The value for the width field */
    private int width;

    /** The value for the length field */
    private int length;

    /** The value for the descr field */
    private String descr;

    /** The value for the restartCell field */
    private int restartCell = 0;

    /** The value for the hostcellcode field */
    private String hostcellcode;


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
     * Get the WorkstationName
     *
     * @return String
     */
    public String getWorkstationName ()
    {
        return workstationName;
    }

    /**
     * Set the value of WorkstationName
     *
     * @param v new value
     */
    public void setWorkstationName(String v)
    {

        this.workstationName = v;
        setModified(true);

    }

    /**
     * Get the LocationX
     *
     * @return int
     */
    public int getLocationX ()
    {
        return locationX;
    }

    /**
     * Set the value of LocationX
     *
     * @param v new value
     */
    public void setLocationX(int v)
    {

        this.locationX = v;
        setModified(true);

    }

    /**
     * Get the LocationY
     *
     * @return int
     */
    public int getLocationY ()
    {
        return locationY;
    }

    /**
     * Set the value of LocationY
     *
     * @param v new value
     */
    public void setLocationY(int v)
    {

        this.locationY = v;
        setModified(true);

    }

    /**
     * Get the Angle
     *
     * @return int
     */
    public int getAngle ()
    {
        return angle;
    }

    /**
     * Set the value of Angle
     *
     * @param v new value
     */
    public void setAngle(int v)
    {

        this.angle = v;
        setModified(true);

    }

    /**
     * Get the StopPointIds
     *
     * @return String
     */
    public String getStopPointIds ()
    {
        return stopPointIds;
    }

    /**
     * Set the value of StopPointIds
     *
     * @param v new value
     */
    public void setStopPointIds(String v)
    {

        this.stopPointIds = v;
        setModified(true);

    }

    /**
     * Get the CreatorUsername
     *
     * @return String
     */
    public String getCreatorUsername ()
    {
        return creatorUsername;
    }

    /**
     * Set the value of CreatorUsername
     *
     * @param v new value
     */
    public void setCreatorUsername(String v)
    {

        this.creatorUsername = v;
        setModified(true);

    }

    /**
     * Get the CreationTime
     *
     * @return Date
     */
    public Date getCreationTime ()
    {
        return creationTime;
    }

    /**
     * Set the value of CreationTime
     *
     * @param v new value
     */
    public void setCreationTime(Date v)
    {

        this.creationTime = v;
        setModified(true);

    }

    /**
     * Get the UpdatorUsername
     *
     * @return String
     */
    public String getUpdatorUsername ()
    {
        return updatorUsername;
    }

    /**
     * Set the value of UpdatorUsername
     *
     * @param v new value
     */
    public void setUpdatorUsername(String v)
    {

        this.updatorUsername = v;
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
     * Get the FloorId
     *
     * @return int
     */
    public int getFloorId ()
    {
        return floorId;
    }

    /**
     * Set the value of FloorId
     *
     * @param v new value
     */
    public void setFloorId(int v)
    {

        this.floorId = v;
        setModified(true);

    }

    /**
     * Get the CellType
     *
     * @return String
     */
    public String getCellType ()
    {
        return cellType;
    }

    /**
     * Set the value of CellType
     *
     * @param v new value
     */
    public void setCellType(String v)
    {

        this.cellType = v;
        setModified(true);

    }

    /**
     * Get the Width
     *
     * @return int
     */
    public int getWidth ()
    {
        return width;
    }

    /**
     * Set the value of Width
     *
     * @param v new value
     */
    public void setWidth(int v)
    {

        this.width = v;
        setModified(true);

    }

    /**
     * Get the Length
     *
     * @return int
     */
    public int getLength ()
    {
        return length;
    }

    /**
     * Set the value of Length
     *
     * @param v new value
     */
    public void setLength(int v)
    {

        this.length = v;
        setModified(true);

    }

    /**
     * Get the Descr
     *
     * @return String
     */
    public String getDescr ()
    {
        return descr;
    }

    /**
     * Set the value of Descr
     *
     * @param v new value
     */
    public void setDescr(String v)
    {

        this.descr = v;
        setModified(true);

    }

    /**
     * Get the RestartCell
     *
     * @return int
     */
    public int getRestartCell ()
    {
        return restartCell;
    }

    /**
     * Set the value of RestartCell
     *
     * @param v new value
     */
    public void setRestartCell(int v)
    {

        this.restartCell = v;
        setModified(true);

    }

    /**
     * Get the Hostcellcode
     *
     * @return String
     */
    public String getHostcellcode ()
    {
        return hostcellcode;
    }

    /**
     * Set the value of Hostcellcode
     *
     * @param v new value
     */
    public void setHostcellcode(String v)
    {

        this.hostcellcode = v;
        setModified(true);

    }

    

}
