
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
 * extended; all references should be to ProtectBean
 */
public abstract class BaseProtectBean
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

    /** The value for the manageType field */
    private String manageType;

    /** The value for the positions field */
    private String positions;

    /** The value for the parent field */
    private int parent;

    /** The value for the priority field */
    private int priority;

    /** The value for the resourceId field */
    private int resourceId;

    /** The value for the color field */
    private int color;

    /** The value for the starttime field */
    private Date starttime;

    /** The value for the endtime field */
    private Date endtime;

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
     * Get the ManageType
     *
     * @return String
     */
    public String getManageType ()
    {
        return manageType;
    }

    /**
     * Set the value of ManageType
     *
     * @param v new value
     */
    public void setManageType(String v)
    {

        this.manageType = v;
        setModified(true);

    }

    /**
     * Get the Positions
     *
     * @return String
     */
    public String getPositions ()
    {
        return positions;
    }

    /**
     * Set the value of Positions
     *
     * @param v new value
     */
    public void setPositions(String v)
    {

        this.positions = v;
        setModified(true);

    }

    /**
     * Get the Parent
     *
     * @return int
     */
    public int getParent ()
    {
        return parent;
    }

    /**
     * Set the value of Parent
     *
     * @param v new value
     */
    public void setParent(int v)
    {

        this.parent = v;
        setModified(true);

    }

    /**
     * Get the Priority
     *
     * @return int
     */
    public int getPriority ()
    {
        return priority;
    }

    /**
     * Set the value of Priority
     *
     * @param v new value
     */
    public void setPriority(int v)
    {

        this.priority = v;
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
     * Get the Color
     *
     * @return int
     */
    public int getColor ()
    {
        return color;
    }

    /**
     * Set the value of Color
     *
     * @param v new value
     */
    public void setColor(int v)
    {

        this.color = v;
        setModified(true);

    }

    /**
     * Get the Starttime
     *
     * @return Date
     */
    public Date getStarttime ()
    {
        return starttime;
    }

    /**
     * Set the value of Starttime
     *
     * @param v new value
     */
    public void setStarttime(Date v)
    {

        this.starttime = v;
        setModified(true);

    }

    /**
     * Get the Endtime
     *
     * @return Date
     */
    public Date getEndtime ()
    {
        return endtime;
    }

    /**
     * Set the value of Endtime
     *
     * @param v new value
     */
    public void setEndtime(Date v)
    {

        this.endtime = v;
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





    /**
     * Collection to store aggregation of collProtectAdBeans
     */
    protected List<ProtectAdBean> collProtectAdBeans;

    /**
     * Returns the collection of ProtectAdBeans
     */
    public List<ProtectAdBean> getProtectAdBeans()
    {
        return collProtectAdBeans;
    }

    /**
     * Sets the collection of ProtectAdBeans to the specified value
     */
    public void setProtectAdBeans(List<ProtectAdBean> list)
    {
        if (list == null)
        {
            collProtectAdBeans = null;
        }
        else
        {
            collProtectAdBeans = new ArrayList<ProtectAdBean>(list);
        }
    }

}
