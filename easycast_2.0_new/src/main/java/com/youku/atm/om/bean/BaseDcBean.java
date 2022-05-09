
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
 * extended; all references should be to DcBean
 */
public abstract class BaseDcBean
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

    /** The value for the targetDate field */
    private Date targetDate;

    /** The value for the cpm field */
    private int cpm;

    /** The value for the cpc field */
    private int cpc;

    /** The value for the cpv field */
    private int cpv = 0;

    /** The value for the cpp field */
    private int cpp = 0;


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
     * Get the TargetDate
     *
     * @return Date
     */
    public Date getTargetDate ()
    {
        return targetDate;
    }

    /**
     * Set the value of TargetDate
     *
     * @param v new value
     */
    public void setTargetDate(Date v)
    {

        this.targetDate = v;
        setModified(true);

    }

    /**
     * Get the Cpm
     *
     * @return int
     */
    public int getCpm ()
    {
        return cpm;
    }

    /**
     * Set the value of Cpm
     *
     * @param v new value
     */
    public void setCpm(int v)
    {

        this.cpm = v;
        setModified(true);

    }

    /**
     * Get the Cpc
     *
     * @return int
     */
    public int getCpc ()
    {
        return cpc;
    }

    /**
     * Set the value of Cpc
     *
     * @param v new value
     */
    public void setCpc(int v)
    {

        this.cpc = v;
        setModified(true);

    }

    /**
     * Get the Cpv
     *
     * @return int
     */
    public int getCpv ()
    {
        return cpv;
    }

    /**
     * Set the value of Cpv
     *
     * @param v new value
     */
    public void setCpv(int v)
    {

        this.cpv = v;
        setModified(true);

    }

    /**
     * Get the Cpp
     *
     * @return int
     */
    public int getCpp ()
    {
        return cpp;
    }

    /**
     * Set the value of Cpp
     *
     * @param v new value
     */
    public void setCpp(int v)
    {

        this.cpp = v;
        setModified(true);

    }

    



    /**
     * Collection to store aggregation of collIdeaTimeBeansRelatedByDcId
     */
    protected List<IdeaTimeBean> collIdeaTimeBeansRelatedByDcId;

    /**
     * Returns the collection of IdeaTimeBeansRelatedByDcId
     */
    public List<IdeaTimeBean> getIdeaTimeBeansRelatedByDcId()
    {
        return collIdeaTimeBeansRelatedByDcId;
    }

    /**
     * Sets the collection of IdeaTimeBeansRelatedByDcId to the specified value
     */
    public void setIdeaTimeBeansRelatedByDcId(List<IdeaTimeBean> list)
    {
        if (list == null)
        {
            collIdeaTimeBeansRelatedByDcId = null;
        }
        else
        {
            collIdeaTimeBeansRelatedByDcId = new ArrayList<IdeaTimeBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collIdeaTimeBeansRelatedByDcId2
     */
    protected List<IdeaTimeBean> collIdeaTimeBeansRelatedByDcId2;

    /**
     * Returns the collection of IdeaTimeBeansRelatedByDcId2
     */
    public List<IdeaTimeBean> getIdeaTimeBeansRelatedByDcId2()
    {
        return collIdeaTimeBeansRelatedByDcId2;
    }

    /**
     * Sets the collection of IdeaTimeBeansRelatedByDcId2 to the specified value
     */
    public void setIdeaTimeBeansRelatedByDcId2(List<IdeaTimeBean> list)
    {
        if (list == null)
        {
            collIdeaTimeBeansRelatedByDcId2 = null;
        }
        else
        {
            collIdeaTimeBeansRelatedByDcId2 = new ArrayList<IdeaTimeBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collHideaTimeBeans
     */
    protected List<HideaTimeBean> collHideaTimeBeans;

    /**
     * Returns the collection of HideaTimeBeans
     */
    public List<HideaTimeBean> getHideaTimeBeans()
    {
        return collHideaTimeBeans;
    }

    /**
     * Sets the collection of HideaTimeBeans to the specified value
     */
    public void setHideaTimeBeans(List<HideaTimeBean> list)
    {
        if (list == null)
        {
            collHideaTimeBeans = null;
        }
        else
        {
            collHideaTimeBeans = new ArrayList<HideaTimeBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collVhideaTimeBeans
     */
    protected List<VhideaTimeBean> collVhideaTimeBeans;

    /**
     * Returns the collection of VhideaTimeBeans
     */
    public List<VhideaTimeBean> getVhideaTimeBeans()
    {
        return collVhideaTimeBeans;
    }

    /**
     * Sets the collection of VhideaTimeBeans to the specified value
     */
    public void setVhideaTimeBeans(List<VhideaTimeBean> list)
    {
        if (list == null)
        {
            collVhideaTimeBeans = null;
        }
        else
        {
            collVhideaTimeBeans = new ArrayList<VhideaTimeBean>(list);
        }
    }

}
