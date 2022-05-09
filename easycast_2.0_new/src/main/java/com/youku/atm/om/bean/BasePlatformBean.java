
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
 * extended; all references should be to PlatformBean
 */
public abstract class BasePlatformBean
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

    /** The value for the brand field */
    private String brand;

    /** The value for the site field */
    private int site = 1;

    /** The value for the dt field */
    private String dt;

    /** The value for the deviceModel field */
    private String deviceModel;

    /** The value for the os field */
    private String os;

    /** The value for the osVersion field */
    private String osVersion;

    /** The value for the aw field */
    private String aw;

    /** The value for the clientVersion field */
    private String clientVersion;

    /** The value for the sortCode field */
    private int sortCode = 1;

    /** The value for the net field */
    private String net;

    /** The value for the value field */
    private String value;

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
     * Get the Brand
     *
     * @return String
     */
    public String getBrand ()
    {
        return brand;
    }

    /**
     * Set the value of Brand
     *
     * @param v new value
     */
    public void setBrand(String v)
    {

        this.brand = v;
        setModified(true);

    }

    /**
     * Get the Site
     *
     * @return int
     */
    public int getSite ()
    {
        return site;
    }

    /**
     * Set the value of Site
     *
     * @param v new value
     */
    public void setSite(int v)
    {

        this.site = v;
        setModified(true);

    }

    /**
     * Get the Dt
     *
     * @return String
     */
    public String getDt ()
    {
        return dt;
    }

    /**
     * Set the value of Dt
     *
     * @param v new value
     */
    public void setDt(String v)
    {

        this.dt = v;
        setModified(true);

    }

    /**
     * Get the DeviceModel
     *
     * @return String
     */
    public String getDeviceModel ()
    {
        return deviceModel;
    }

    /**
     * Set the value of DeviceModel
     *
     * @param v new value
     */
    public void setDeviceModel(String v)
    {

        this.deviceModel = v;
        setModified(true);

    }

    /**
     * Get the Os
     *
     * @return String
     */
    public String getOs ()
    {
        return os;
    }

    /**
     * Set the value of Os
     *
     * @param v new value
     */
    public void setOs(String v)
    {

        this.os = v;
        setModified(true);

    }

    /**
     * Get the OsVersion
     *
     * @return String
     */
    public String getOsVersion ()
    {
        return osVersion;
    }

    /**
     * Set the value of OsVersion
     *
     * @param v new value
     */
    public void setOsVersion(String v)
    {

        this.osVersion = v;
        setModified(true);

    }

    /**
     * Get the Aw
     *
     * @return String
     */
    public String getAw ()
    {
        return aw;
    }

    /**
     * Set the value of Aw
     *
     * @param v new value
     */
    public void setAw(String v)
    {

        this.aw = v;
        setModified(true);

    }

    /**
     * Get the ClientVersion
     *
     * @return String
     */
    public String getClientVersion ()
    {
        return clientVersion;
    }

    /**
     * Set the value of ClientVersion
     *
     * @param v new value
     */
    public void setClientVersion(String v)
    {

        this.clientVersion = v;
        setModified(true);

    }

    /**
     * Get the SortCode
     *
     * @return int
     */
    public int getSortCode ()
    {
        return sortCode;
    }

    /**
     * Set the value of SortCode
     *
     * @param v new value
     */
    public void setSortCode(int v)
    {

        this.sortCode = v;
        setModified(true);

    }

    /**
     * Get the Net
     *
     * @return String
     */
    public String getNet ()
    {
        return net;
    }

    /**
     * Set the value of Net
     *
     * @param v new value
     */
    public void setNet(String v)
    {

        this.net = v;
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
     * Collection to store aggregation of collCastPlatformBeans
     */
    protected List<CastPlatformBean> collCastPlatformBeans;

    /**
     * Returns the collection of CastPlatformBeans
     */
    public List<CastPlatformBean> getCastPlatformBeans()
    {
        return collCastPlatformBeans;
    }

    /**
     * Sets the collection of CastPlatformBeans to the specified value
     */
    public void setCastPlatformBeans(List<CastPlatformBean> list)
    {
        if (list == null)
        {
            collCastPlatformBeans = null;
        }
        else
        {
            collCastPlatformBeans = new ArrayList<CastPlatformBean>(list);
        }
    }

}
