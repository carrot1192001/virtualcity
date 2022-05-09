
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
 * extended; all references should be to SdkLogBean
 */
public abstract class BaseSdkLogBean
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

    /** The value for the sdkDeviceId field */
    private int sdkDeviceId;

    /** The value for the adTypeId field */
    private int adTypeId;

    /** The value for the sdkId field */
    private int sdkId;

    /** The value for the fillingRate field */
    private double fillingRate;

    /** The value for the showNum field */
    private int showNum;

    /** The value for the clickNum field */
    private int clickNum;

    /** The value for the income field */
    private double income;

    /** The value for the atmshow field */
    private int atmshow;

    /** The value for the castId field */
    private int castId;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the createDate field */
    private Date createDate;


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
     * Get the SdkDeviceId
     *
     * @return int
     */
    public int getSdkDeviceId ()
    {
        return sdkDeviceId;
    }

    /**
     * Set the value of SdkDeviceId
     *
     * @param v new value
     */
    public void setSdkDeviceId(int v)
    {

        this.sdkDeviceId = v;
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
     * Get the FillingRate
     *
     * @return double
     */
    public double getFillingRate ()
    {
        return fillingRate;
    }

    /**
     * Set the value of FillingRate
     *
     * @param v new value
     */
    public void setFillingRate(double v)
    {

        this.fillingRate = v;
        setModified(true);

    }

    /**
     * Get the ShowNum
     *
     * @return int
     */
    public int getShowNum ()
    {
        return showNum;
    }

    /**
     * Set the value of ShowNum
     *
     * @param v new value
     */
    public void setShowNum(int v)
    {

        this.showNum = v;
        setModified(true);

    }

    /**
     * Get the ClickNum
     *
     * @return int
     */
    public int getClickNum ()
    {
        return clickNum;
    }

    /**
     * Set the value of ClickNum
     *
     * @param v new value
     */
    public void setClickNum(int v)
    {

        this.clickNum = v;
        setModified(true);

    }

    /**
     * Get the Income
     *
     * @return double
     */
    public double getIncome ()
    {
        return income;
    }

    /**
     * Set the value of Income
     *
     * @param v new value
     */
    public void setIncome(double v)
    {

        this.income = v;
        setModified(true);

    }

    /**
     * Get the Atmshow
     *
     * @return int
     */
    public int getAtmshow ()
    {
        return atmshow;
    }

    /**
     * Set the value of Atmshow
     *
     * @param v new value
     */
    public void setAtmshow(int v)
    {

        this.atmshow = v;
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

    /**
     * Get the CreateDate
     *
     * @return Date
     */
    public Date getCreateDate ()
    {
        return createDate;
    }

    /**
     * Set the value of CreateDate
     *
     * @param v new value
     */
    public void setCreateDate(Date v)
    {

        this.createDate = v;
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
            setSdkDeviceId( 0);
        }
        else
        {
            setSdkDeviceId(v.getId());
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
