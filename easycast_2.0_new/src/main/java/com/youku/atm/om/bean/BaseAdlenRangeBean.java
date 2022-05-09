
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
 * extended; all references should be to AdlenRangeBean
 */
public abstract class BaseAdlenRangeBean
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

    /** The value for the vPointId field */
    private String vPointId;

    /** The value for the vlenLow field */
    private int vlenLow;

    /** The value for the vlenHigh field */
    private int vlenHigh;

    /** The value for the adlenMax field */
    private int adlenMax;

    /** The value for the adcountMax field */
    private int adcountMax;

    /** The value for the resourceId field */
    private int resourceId;

    /** The value for the status field */
    private int status;

    /** The value for the isuserange field */
    private int isuserange = 1;


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
     * Get the VPointId
     *
     * @return String
     */
    public String getVPointId ()
    {
        return vPointId;
    }

    /**
     * Set the value of VPointId
     *
     * @param v new value
     */
    public void setVPointId(String v)
    {

        this.vPointId = v;
        setModified(true);

    }

    /**
     * Get the VlenLow
     *
     * @return int
     */
    public int getVlenLow ()
    {
        return vlenLow;
    }

    /**
     * Set the value of VlenLow
     *
     * @param v new value
     */
    public void setVlenLow(int v)
    {

        this.vlenLow = v;
        setModified(true);

    }

    /**
     * Get the VlenHigh
     *
     * @return int
     */
    public int getVlenHigh ()
    {
        return vlenHigh;
    }

    /**
     * Set the value of VlenHigh
     *
     * @param v new value
     */
    public void setVlenHigh(int v)
    {

        this.vlenHigh = v;
        setModified(true);

    }

    /**
     * Get the AdlenMax
     *
     * @return int
     */
    public int getAdlenMax ()
    {
        return adlenMax;
    }

    /**
     * Set the value of AdlenMax
     *
     * @param v new value
     */
    public void setAdlenMax(int v)
    {

        this.adlenMax = v;
        setModified(true);

    }

    /**
     * Get the AdcountMax
     *
     * @return int
     */
    public int getAdcountMax ()
    {
        return adcountMax;
    }

    /**
     * Set the value of AdcountMax
     *
     * @param v new value
     */
    public void setAdcountMax(int v)
    {

        this.adcountMax = v;
        setModified(true);

    }

    /**
     * Get the ResourceId
     *
     * @return int
     */
    public int getResourceId ()
    {
        return resourceId;
    }

    /**
     * Set the value of ResourceId
     *
     * @param v new value
     */
    public void setResourceId(int v)
    {

        this.resourceId = v;
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
     * Get the Isuserange
     *
     * @return int
     */
    public int getIsuserange ()
    {
        return isuserange;
    }

    /**
     * Set the value of Isuserange
     *
     * @param v new value
     */
    public void setIsuserange(int v)
    {

        this.isuserange = v;
        setModified(true);

    }

    



    private ResourceBean aResourceBean;

    /**
     * sets an associated ResourceBean object
     *
     * @param v ResourceBean
     */
    public void setResourceBean(ResourceBean v)
    {
        if (v == null)
        {
            setResourceId( 0);
        }
        else
        {
            setResourceId(v.getId());
        }
        aResourceBean = v;
    }


    /**
     * Get the associated ResourceBean object
     *
     * @return the associated ResourceBean object
     */
    public ResourceBean getResourceBean()
    {
        return aResourceBean;
    }



}
