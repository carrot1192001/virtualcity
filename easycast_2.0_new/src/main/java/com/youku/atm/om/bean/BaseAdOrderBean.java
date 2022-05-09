
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
 * extended; all references should be to AdOrderBean
 */
public abstract class BaseAdOrderBean
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

    /** The value for the customId field */
    private int customId;

    /** The value for the customName field */
    private String customName;

    /** The value for the type field */
    private int type;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the status field */
    private int status = 1;

    /** The value for the industryId field */
    private int industryId;

    /** The value for the subIndustryId field */
    private int subIndustryId;

    /** The value for the categoryId field */
    private int categoryId;

    /** The value for the marketingType field */
    private int marketingType = 0;


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
     * Get the CustomId
     *
     * @return int
     */
    public int getCustomId ()
    {
        return customId;
    }

    /**
     * Set the value of CustomId
     *
     * @param v new value
     */
    public void setCustomId(int v)
    {

        this.customId = v;
        setModified(true);

    }

    /**
     * Get the CustomName
     *
     * @return String
     */
    public String getCustomName ()
    {
        return customName;
    }

    /**
     * Set the value of CustomName
     *
     * @param v new value
     */
    public void setCustomName(String v)
    {

        this.customName = v;
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
     * Get the IndustryId
     *
     * @return int
     */
    public int getIndustryId ()
    {
        return industryId;
    }

    /**
     * Set the value of IndustryId
     *
     * @param v new value
     */
    public void setIndustryId(int v)
    {

        this.industryId = v;
        setModified(true);

    }

    /**
     * Get the SubIndustryId
     *
     * @return int
     */
    public int getSubIndustryId ()
    {
        return subIndustryId;
    }

    /**
     * Set the value of SubIndustryId
     *
     * @param v new value
     */
    public void setSubIndustryId(int v)
    {

        this.subIndustryId = v;
        setModified(true);

    }

    /**
     * Get the CategoryId
     *
     * @return int
     */
    public int getCategoryId ()
    {
        return categoryId;
    }

    /**
     * Set the value of CategoryId
     *
     * @param v new value
     */
    public void setCategoryId(int v)
    {

        this.categoryId = v;
        setModified(true);

    }

    /**
     * Get the MarketingType
     *
     * @return int
     */
    public int getMarketingType ()
    {
        return marketingType;
    }

    /**
     * Set the value of MarketingType
     *
     * @param v new value
     */
    public void setMarketingType(int v)
    {

        this.marketingType = v;
        setModified(true);

    }

    



    /**
     * Collection to store aggregation of collAdCastBeans
     */
    protected List<AdCastBean> collAdCastBeans;

    /**
     * Returns the collection of AdCastBeans
     */
    public List<AdCastBean> getAdCastBeans()
    {
        return collAdCastBeans;
    }

    /**
     * Sets the collection of AdCastBeans to the specified value
     */
    public void setAdCastBeans(List<AdCastBean> list)
    {
        if (list == null)
        {
            collAdCastBeans = null;
        }
        else
        {
            collAdCastBeans = new ArrayList<AdCastBean>(list);
        }
    }

}
