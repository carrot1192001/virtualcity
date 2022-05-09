
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
 * extended; all references should be to RegionBean
 */
public abstract class BaseRegionBean
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

    /** The value for the cityId field */
    private String cityId;

    /** The value for the provinceId field */
    private String provinceId;

    /** The value for the startIp field */
    private String startIp;

    /** The value for the endIp field */
    private String endIp;

    /** The value for the geoid field */
    private String geoid;


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
     * Get the CityId
     *
     * @return String
     */
    public String getCityId ()
    {
        return cityId;
    }

    /**
     * Set the value of CityId
     *
     * @param v new value
     */
    public void setCityId(String v)
    {

        this.cityId = v;
        setModified(true);

    }

    /**
     * Get the ProvinceId
     *
     * @return String
     */
    public String getProvinceId ()
    {
        return provinceId;
    }

    /**
     * Set the value of ProvinceId
     *
     * @param v new value
     */
    public void setProvinceId(String v)
    {

        this.provinceId = v;
        setModified(true);

    }

    /**
     * Get the StartIp
     *
     * @return String
     */
    public String getStartIp ()
    {
        return startIp;
    }

    /**
     * Set the value of StartIp
     *
     * @param v new value
     */
    public void setStartIp(String v)
    {

        this.startIp = v;
        setModified(true);

    }

    /**
     * Get the EndIp
     *
     * @return String
     */
    public String getEndIp ()
    {
        return endIp;
    }

    /**
     * Set the value of EndIp
     *
     * @param v new value
     */
    public void setEndIp(String v)
    {

        this.endIp = v;
        setModified(true);

    }

    /**
     * Get the Geoid
     *
     * @return String
     */
    public String getGeoid ()
    {
        return geoid;
    }

    /**
     * Set the value of Geoid
     *
     * @param v new value
     */
    public void setGeoid(String v)
    {

        this.geoid = v;
        setModified(true);

    }

    

}
