
package com.youku.adssp.om.bean;

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
 * extended; all references should be to YesDspBean
 */
public abstract class BaseYesDspBean
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

    /** The value for the dspname field */
    private String dspname;

    /** The value for the dsptoken field */
    private String dsptoken;

    /** The value for the cookiemappingurl field */
    private String cookiemappingurl;

    /** The value for the bidurl field */
    private String bidurl;

    /** The value for the winnoticeurl field */
    private String winnoticeurl;

    /** The value for the qps field */
    private int qps;

    /** The value for the dspstart field */
    private int dspstart;

    /** The value for the ismaterialstart field */
    private int ismaterialstart;

    /** The value for the iscookiemapping field */
    private int iscookiemapping;

    /** The value for the isrtb field */
    private int isrtb;

    /** The value for the ispass field */
    private int ispass;

    /** The value for the ischeckmaterial field */
    private int ischeckmaterial;

    /** The value for the description field */
    private String description;

    /** The value for the enjoyad field */
    private int enjoyad;

    /** The value for the isopenchannel field */
    private int isopenchannel;

    /** The value for the isPdbReused field */
    private int isPdbReused;

    /** The value for the alias field */
    private String alias;


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
     * Get the Dspname
     *
     * @return String
     */
    public String getDspname ()
    {
        return dspname;
    }

    /**
     * Set the value of Dspname
     *
     * @param v new value
     */
    public void setDspname(String v)
    {

        this.dspname = v;
        setModified(true);

    }

    /**
     * Get the Dsptoken
     *
     * @return String
     */
    public String getDsptoken ()
    {
        return dsptoken;
    }

    /**
     * Set the value of Dsptoken
     *
     * @param v new value
     */
    public void setDsptoken(String v)
    {

        this.dsptoken = v;
        setModified(true);

    }

    /**
     * Get the Cookiemappingurl
     *
     * @return String
     */
    public String getCookiemappingurl ()
    {
        return cookiemappingurl;
    }

    /**
     * Set the value of Cookiemappingurl
     *
     * @param v new value
     */
    public void setCookiemappingurl(String v)
    {

        this.cookiemappingurl = v;
        setModified(true);

    }

    /**
     * Get the Bidurl
     *
     * @return String
     */
    public String getBidurl ()
    {
        return bidurl;
    }

    /**
     * Set the value of Bidurl
     *
     * @param v new value
     */
    public void setBidurl(String v)
    {

        this.bidurl = v;
        setModified(true);

    }

    /**
     * Get the Winnoticeurl
     *
     * @return String
     */
    public String getWinnoticeurl ()
    {
        return winnoticeurl;
    }

    /**
     * Set the value of Winnoticeurl
     *
     * @param v new value
     */
    public void setWinnoticeurl(String v)
    {

        this.winnoticeurl = v;
        setModified(true);

    }

    /**
     * Get the Qps
     *
     * @return int
     */
    public int getQps ()
    {
        return qps;
    }

    /**
     * Set the value of Qps
     *
     * @param v new value
     */
    public void setQps(int v)
    {

        this.qps = v;
        setModified(true);

    }

    /**
     * Get the Dspstart
     *
     * @return int
     */
    public int getDspstart ()
    {
        return dspstart;
    }

    /**
     * Set the value of Dspstart
     *
     * @param v new value
     */
    public void setDspstart(int v)
    {

        this.dspstart = v;
        setModified(true);

    }

    /**
     * Get the Ismaterialstart
     *
     * @return int
     */
    public int getIsmaterialstart ()
    {
        return ismaterialstart;
    }

    /**
     * Set the value of Ismaterialstart
     *
     * @param v new value
     */
    public void setIsmaterialstart(int v)
    {

        this.ismaterialstart = v;
        setModified(true);

    }

    /**
     * Get the Iscookiemapping
     *
     * @return int
     */
    public int getIscookiemapping ()
    {
        return iscookiemapping;
    }

    /**
     * Set the value of Iscookiemapping
     *
     * @param v new value
     */
    public void setIscookiemapping(int v)
    {

        this.iscookiemapping = v;
        setModified(true);

    }

    /**
     * Get the Isrtb
     *
     * @return int
     */
    public int getIsrtb ()
    {
        return isrtb;
    }

    /**
     * Set the value of Isrtb
     *
     * @param v new value
     */
    public void setIsrtb(int v)
    {

        this.isrtb = v;
        setModified(true);

    }

    /**
     * Get the Ispass
     *
     * @return int
     */
    public int getIspass ()
    {
        return ispass;
    }

    /**
     * Set the value of Ispass
     *
     * @param v new value
     */
    public void setIspass(int v)
    {

        this.ispass = v;
        setModified(true);

    }

    /**
     * Get the Ischeckmaterial
     *
     * @return int
     */
    public int getIscheckmaterial ()
    {
        return ischeckmaterial;
    }

    /**
     * Set the value of Ischeckmaterial
     *
     * @param v new value
     */
    public void setIscheckmaterial(int v)
    {

        this.ischeckmaterial = v;
        setModified(true);

    }

    /**
     * Get the Description
     *
     * @return String
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * Set the value of Description
     *
     * @param v new value
     */
    public void setDescription(String v)
    {

        this.description = v;
        setModified(true);

    }

    /**
     * Get the Enjoyad
     *
     * @return int
     */
    public int getEnjoyad ()
    {
        return enjoyad;
    }

    /**
     * Set the value of Enjoyad
     *
     * @param v new value
     */
    public void setEnjoyad(int v)
    {

        this.enjoyad = v;
        setModified(true);

    }

    /**
     * Get the Isopenchannel
     *
     * @return int
     */
    public int getIsopenchannel ()
    {
        return isopenchannel;
    }

    /**
     * Set the value of Isopenchannel
     *
     * @param v new value
     */
    public void setIsopenchannel(int v)
    {

        this.isopenchannel = v;
        setModified(true);

    }

    /**
     * Get the IsPdbReused
     *
     * @return int
     */
    public int getIsPdbReused ()
    {
        return isPdbReused;
    }

    /**
     * Set the value of IsPdbReused
     *
     * @param v new value
     */
    public void setIsPdbReused(int v)
    {

        this.isPdbReused = v;
        setModified(true);

    }

    /**
     * Get the Alias
     *
     * @return String
     */
    public String getAlias ()
    {
        return alias;
    }

    /**
     * Set the value of Alias
     *
     * @param v new value
     */
    public void setAlias(String v)
    {

        this.alias = v;
        setModified(true);

    }

    

}
