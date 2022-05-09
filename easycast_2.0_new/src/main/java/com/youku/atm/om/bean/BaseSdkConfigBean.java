
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
 * extended; all references should be to SdkConfigBean
 */
public abstract class BaseSdkConfigBean
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

    /** The value for the deviceId field */
    private int deviceId;

    /** The value for the adTypeId field */
    private int adTypeId;

    /** The value for the sdkId field */
    private int sdkId;

    /** The value for the status field */
    private int status = 1;

    /** The value for the manualPercent field */
    private int manualPercent = 0;

    /** The value for the autoPercent field */
    private int autoPercent = 0;

    /** The value for the castId field */
    private int castId;

    /** The value for the ideaId field */
    private int ideaId;


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
     * Get the DeviceId
     *
     * @return int
     */
    public int getDeviceId ()
    {
        return deviceId;
    }

    /**
     * Set the value of DeviceId
     *
     * @param v new value
     */
    public void setDeviceId(int v)
    {

        this.deviceId = v;
        setModified(true);

    }

    /**
     * Get the AdTypeId
     *
     * @return int
     */
    public int getAdTypeId ()
    {
        return adTypeId;
    }

    /**
     * Set the value of AdTypeId
     *
     * @param v new value
     */
    public void setAdTypeId(int v)
    {

        this.adTypeId = v;
        setModified(true);

    }

    /**
     * Get the SdkId
     *
     * @return int
     */
    public int getSdkId ()
    {
        return sdkId;
    }

    /**
     * Set the value of SdkId
     *
     * @param v new value
     */
    public void setSdkId(int v)
    {

        this.sdkId = v;
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
     * Get the ManualPercent
     *
     * @return int
     */
    public int getManualPercent ()
    {
        return manualPercent;
    }

    /**
     * Set the value of ManualPercent
     *
     * @param v new value
     */
    public void setManualPercent(int v)
    {

        this.manualPercent = v;
        setModified(true);

    }

    /**
     * Get the AutoPercent
     *
     * @return int
     */
    public int getAutoPercent ()
    {
        return autoPercent;
    }

    /**
     * Set the value of AutoPercent
     *
     * @param v new value
     */
    public void setAutoPercent(int v)
    {

        this.autoPercent = v;
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

    



    private SdkDeviceBean aSdkDeviceBean;

    /**
     * sets an associated SdkDeviceBean object
     *
     * @param v SdkDeviceBean
     */
    public void setSdkDeviceBean(SdkDeviceBean v)
    {
        if (v == null)
        {
            setDeviceId( 0);
        }
        else
        {
            setDeviceId(v.getId());
        }
        aSdkDeviceBean = v;
    }


    /**
     * Get the associated SdkDeviceBean object
     *
     * @return the associated SdkDeviceBean object
     */
    public SdkDeviceBean getSdkDeviceBean()
    {
        return aSdkDeviceBean;
    }





    private AdTypeBean aAdTypeBean;

    /**
     * sets an associated AdTypeBean object
     *
     * @param v AdTypeBean
     */
    public void setAdTypeBean(AdTypeBean v)
    {
        if (v == null)
        {
            setAdTypeId( 0);
        }
        else
        {
            setAdTypeId(v.getId());
        }
        aAdTypeBean = v;
    }


    /**
     * Get the associated AdTypeBean object
     *
     * @return the associated AdTypeBean object
     */
    public AdTypeBean getAdTypeBean()
    {
        return aAdTypeBean;
    }





    private SdkNameBean aSdkNameBean;

    /**
     * sets an associated SdkNameBean object
     *
     * @param v SdkNameBean
     */
    public void setSdkNameBean(SdkNameBean v)
    {
        if (v == null)
        {
            setSdkId( 0);
        }
        else
        {
            setSdkId(v.getId());
        }
        aSdkNameBean = v;
    }


    /**
     * Get the associated SdkNameBean object
     *
     * @return the associated SdkNameBean object
     */
    public SdkNameBean getSdkNameBean()
    {
        return aSdkNameBean;
    }



}
