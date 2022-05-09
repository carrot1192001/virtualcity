
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
 * extended; all references should be to LogConfigBean
 */
public abstract class BaseLogConfigBean
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

    /** The value for the code field */
    private String code;

    /** The value for the ip field */
    private String ip;

    /** The value for the remoteport field */
    private String remoteport;

    /** The value for the localport field */
    private String localport;

    /** The value for the path field */
    private String path;

    /** The value for the site field */
    private int site = 0;

    /** The value for the logType field */
    private String logType = "a";

    /** The value for the pType field */
    private int pType = 0;


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
     * Get the Code
     *
     * @return String
     */
    public String getCode ()
    {
        return code;
    }

    /**
     * Set the value of Code
     *
     * @param v new value
     */
    public void setCode(String v)
    {

        this.code = v;
        setModified(true);

    }

    /**
     * Get the Ip
     *
     * @return String
     */
    public String getIp ()
    {
        return ip;
    }

    /**
     * Set the value of Ip
     *
     * @param v new value
     */
    public void setIp(String v)
    {

        this.ip = v;
        setModified(true);

    }

    /**
     * Get the Remoteport
     *
     * @return String
     */
    public String getRemoteport ()
    {
        return remoteport;
    }

    /**
     * Set the value of Remoteport
     *
     * @param v new value
     */
    public void setRemoteport(String v)
    {

        this.remoteport = v;
        setModified(true);

    }

    /**
     * Get the Localport
     *
     * @return String
     */
    public String getLocalport ()
    {
        return localport;
    }

    /**
     * Set the value of Localport
     *
     * @param v new value
     */
    public void setLocalport(String v)
    {

        this.localport = v;
        setModified(true);

    }

    /**
     * Get the Path
     *
     * @return String
     */
    public String getPath ()
    {
        return path;
    }

    /**
     * Set the value of Path
     *
     * @param v new value
     */
    public void setPath(String v)
    {

        this.path = v;
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
     * Get the LogType
     *
     * @return String
     */
    public String getLogType ()
    {
        return logType;
    }

    /**
     * Set the value of LogType
     *
     * @param v new value
     */
    public void setLogType(String v)
    {

        this.logType = v;
        setModified(true);

    }

    /**
     * Get the PType
     *
     * @return int
     */
    public int getPType ()
    {
        return pType;
    }

    /**
     * Set the value of PType
     *
     * @param v new value
     */
    public void setPType(int v)
    {

        this.pType = v;
        setModified(true);

    }

    

}
