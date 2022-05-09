
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
 * extended; all references should be to CampaignBean
 */
public abstract class BaseCampaignBean
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

    /** The value for the type field */
    private int type = 1;

    /** The value for the startDate field */
    private Date startDate;

    /** The value for the endDate field */
    private Date endDate;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the numlimit field */
    private int numlimit = 0;

    /** The value for the daylimit field */
    private String daylimit = "0";

    /** The value for the unite field */
    private int unite = 0;

    /** The value for the status field */
    private int status = 1;


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
     * Get the Type
     *
     * @return int
     */
    public int getType ()
    {
        return type;
    }

    /**
     * Set the value of Type
     *
     * @param v new value
     */
    public void setType(int v)
    {

        this.type = v;
        setModified(true);

    }

    /**
     * Get the StartDate
     *
     * @return Date
     */
    public Date getStartDate ()
    {
        return startDate;
    }

    /**
     * Set the value of StartDate
     *
     * @param v new value
     */
    public void setStartDate(Date v)
    {

        this.startDate = v;
        setModified(true);

    }

    /**
     * Get the EndDate
     *
     * @return Date
     */
    public Date getEndDate ()
    {
        return endDate;
    }

    /**
     * Set the value of EndDate
     *
     * @param v new value
     */
    public void setEndDate(Date v)
    {

        this.endDate = v;
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
     * Get the Numlimit
     *
     * @return int
     */
    public int getNumlimit ()
    {
        return numlimit;
    }

    /**
     * Set the value of Numlimit
     *
     * @param v new value
     */
    public void setNumlimit(int v)
    {

        this.numlimit = v;
        setModified(true);

    }

    /**
     * Get the Daylimit
     *
     * @return String
     */
    public String getDaylimit ()
    {
        return daylimit;
    }

    /**
     * Set the value of Daylimit
     *
     * @param v new value
     */
    public void setDaylimit(String v)
    {

        this.daylimit = v;
        setModified(true);

    }

    /**
     * Get the Unite
     *
     * @return int
     */
    public int getUnite ()
    {
        return unite;
    }

    /**
     * Set the value of Unite
     *
     * @param v new value
     */
    public void setUnite(int v)
    {

        this.unite = v;
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
     * Collection to store aggregation of collCastCampaignBeans
     */
    protected List<CastCampaignBean> collCastCampaignBeans;

    /**
     * Returns the collection of CastCampaignBeans
     */
    public List<CastCampaignBean> getCastCampaignBeans()
    {
        return collCastCampaignBeans;
    }

    /**
     * Sets the collection of CastCampaignBeans to the specified value
     */
    public void setCastCampaignBeans(List<CastCampaignBean> list)
    {
        if (list == null)
        {
            collCastCampaignBeans = null;
        }
        else
        {
            collCastCampaignBeans = new ArrayList<CastCampaignBean>(list);
        }
    }

}
