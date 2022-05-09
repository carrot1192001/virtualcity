
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
 * extended; all references should be to SdkNameBean
 */
public abstract class BaseSdkNameBean
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

    /** The value for the status field */
    private int status;


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
     * Collection to store aggregation of collSdkConfigBeans
     */
    protected List<SdkConfigBean> collSdkConfigBeans;

    /**
     * Returns the collection of SdkConfigBeans
     */
    public List<SdkConfigBean> getSdkConfigBeans()
    {
        return collSdkConfigBeans;
    }

    /**
     * Sets the collection of SdkConfigBeans to the specified value
     */
    public void setSdkConfigBeans(List<SdkConfigBean> list)
    {
        if (list == null)
        {
            collSdkConfigBeans = null;
        }
        else
        {
            collSdkConfigBeans = new ArrayList<SdkConfigBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collSdkConfigLogBeans
     */
    protected List<SdkConfigLogBean> collSdkConfigLogBeans;

    /**
     * Returns the collection of SdkConfigLogBeans
     */
    public List<SdkConfigLogBean> getSdkConfigLogBeans()
    {
        return collSdkConfigLogBeans;
    }

    /**
     * Sets the collection of SdkConfigLogBeans to the specified value
     */
    public void setSdkConfigLogBeans(List<SdkConfigLogBean> list)
    {
        if (list == null)
        {
            collSdkConfigLogBeans = null;
        }
        else
        {
            collSdkConfigLogBeans = new ArrayList<SdkConfigLogBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collSdkLogBeans
     */
    protected List<SdkLogBean> collSdkLogBeans;

    /**
     * Returns the collection of SdkLogBeans
     */
    public List<SdkLogBean> getSdkLogBeans()
    {
        return collSdkLogBeans;
    }

    /**
     * Sets the collection of SdkLogBeans to the specified value
     */
    public void setSdkLogBeans(List<SdkLogBean> list)
    {
        if (list == null)
        {
            collSdkLogBeans = null;
        }
        else
        {
            collSdkLogBeans = new ArrayList<SdkLogBean>(list);
        }
    }

}
