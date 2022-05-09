
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
 * extended; all references should be to CastCampaignBean
 */
public abstract class BaseCastCampaignBean
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

    /** The value for the castId field */
    private int castId;

    /** The value for the campaignId field */
    private int campaignId;

    /** The value for the campaignNum field */
    private String campaignNum = "0";


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
     * Get the CampaignId
     *
     * @return int
     */
    public int getCampaignId ()
    {
        return campaignId;
    }

    /**
     * Set the value of CampaignId
     *
     * @param v new value
     */
    public void setCampaignId(int v)
    {

        this.campaignId = v;
        setModified(true);

    }

    /**
     * Get the CampaignNum
     *
     * @return String
     */
    public String getCampaignNum ()
    {
        return campaignNum;
    }

    /**
     * Set the value of CampaignNum
     *
     * @param v new value
     */
    public void setCampaignNum(String v)
    {

        this.campaignNum = v;
        setModified(true);

    }

    



    private AdCastBean aAdCastBean;

    /**
     * sets an associated AdCastBean object
     *
     * @param v AdCastBean
     */
    public void setAdCastBean(AdCastBean v)
    {
        if (v == null)
        {
            setCastId( 0);
        }
        else
        {
            setCastId(v.getId());
        }
        aAdCastBean = v;
    }


    /**
     * Get the associated AdCastBean object
     *
     * @return the associated AdCastBean object
     */
    public AdCastBean getAdCastBean()
    {
        return aAdCastBean;
    }





    private CampaignBean aCampaignBean;

    /**
     * sets an associated CampaignBean object
     *
     * @param v CampaignBean
     */
    public void setCampaignBean(CampaignBean v)
    {
        if (v == null)
        {
            setCampaignId( 0);
        }
        else
        {
            setCampaignId(v.getId());
        }
        aCampaignBean = v;
    }


    /**
     * Get the associated CampaignBean object
     *
     * @return the associated CampaignBean object
     */
    public CampaignBean getCampaignBean()
    {
        return aCampaignBean;
    }



}
