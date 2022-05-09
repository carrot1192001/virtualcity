
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
 * extended; all references should be to ResourceBean
 */
public abstract class BaseResourceBean
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
    private int type;

    /** The value for the level field */
    private int level;


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
     * Get the Level
     *
     * @return int
     */
    public int getLevel ()
    {
        return level;
    }

    /**
     * Set the value of Level
     *
     * @param v new value
     */
    public void setLevel(int v)
    {

        this.level = v;
        setModified(true);

    }

    



    /**
     * Collection to store aggregation of collAdlenRangeBeans
     */
    protected List<AdlenRangeBean> collAdlenRangeBeans;

    /**
     * Returns the collection of AdlenRangeBeans
     */
    public List<AdlenRangeBean> getAdlenRangeBeans()
    {
        return collAdlenRangeBeans;
    }

    /**
     * Sets the collection of AdlenRangeBeans to the specified value
     */
    public void setAdlenRangeBeans(List<AdlenRangeBean> list)
    {
        if (list == null)
        {
            collAdlenRangeBeans = null;
        }
        else
        {
            collAdlenRangeBeans = new ArrayList<AdlenRangeBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collOverflowRangeBeans
     */
    protected List<OverflowRangeBean> collOverflowRangeBeans;

    /**
     * Returns the collection of OverflowRangeBeans
     */
    public List<OverflowRangeBean> getOverflowRangeBeans()
    {
        return collOverflowRangeBeans;
    }

    /**
     * Sets the collection of OverflowRangeBeans to the specified value
     */
    public void setOverflowRangeBeans(List<OverflowRangeBean> list)
    {
        if (list == null)
        {
            collOverflowRangeBeans = null;
        }
        else
        {
            collOverflowRangeBeans = new ArrayList<OverflowRangeBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collProtectBeans
     */
    protected List<ProtectBean> collProtectBeans;

    /**
     * Returns the collection of ProtectBeans
     */
    public List<ProtectBean> getProtectBeans()
    {
        return collProtectBeans;
    }

    /**
     * Sets the collection of ProtectBeans to the specified value
     */
    public void setProtectBeans(List<ProtectBean> list)
    {
        if (list == null)
        {
            collProtectBeans = null;
        }
        else
        {
            collProtectBeans = new ArrayList<ProtectBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collResourceDirectionBeans
     */
    protected List<ResourceDirectionBean> collResourceDirectionBeans;

    /**
     * Returns the collection of ResourceDirectionBeans
     */
    public List<ResourceDirectionBean> getResourceDirectionBeans()
    {
        return collResourceDirectionBeans;
    }

    /**
     * Sets the collection of ResourceDirectionBeans to the specified value
     */
    public void setResourceDirectionBeans(List<ResourceDirectionBean> list)
    {
        if (list == null)
        {
            collResourceDirectionBeans = null;
        }
        else
        {
            collResourceDirectionBeans = new ArrayList<ResourceDirectionBean>(list);
        }
    }

}
