
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
 * extended; all references should be to IdeaTimeBean
 */
public abstract class BaseIdeaTimeBean
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

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the starttime field */
    private Date starttime;

    /** The value for the endtime field */
    private Date endtime;

    /** The value for the dcId field */
    private int dcId = 0;

    /** The value for the dcId2 field */
    private int dcId2 = 0;

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
     * Get the DcId
     *
     * @return int
     */
    public int getDcId ()
    {
        return dcId;
    }

    /**
     * Set the value of DcId
     *
     * @param v new value
     */
    public void setDcId(int v)
    {

        this.dcId = v;
        setModified(true);

    }

    /**
     * Get the DcId2
     *
     * @return int
     */
    public int getDcId2 ()
    {
        return dcId2;
    }

    /**
     * Set the value of DcId2
     *
     * @param v new value
     */
    public void setDcId2(int v)
    {

        this.dcId2 = v;
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

    



    private IdeaBean aIdeaBean;

    /**
     * sets an associated IdeaBean object
     *
     * @param v IdeaBean
     */
    public void setIdeaBean(IdeaBean v)
    {
        if (v == null)
        {
            setIdeaId( 0);
        }
        else
        {
            setIdeaId(v.getId());
        }
        aIdeaBean = v;
    }


    /**
     * Get the associated IdeaBean object
     *
     * @return the associated IdeaBean object
     */
    public IdeaBean getIdeaBean()
    {
        return aIdeaBean;
    }





    private DcBean aDcBeanRelatedByDcId;

    /**
     * sets an associated DcBean object
     *
     * @param v DcBean
     */
    public void setDcBeanRelatedByDcId(DcBean v)
    {
        if (v == null)
        {
            setDcId( 0);
        }
        else
        {
            setDcId(v.getId());
        }
        aDcBeanRelatedByDcId = v;
    }


    /**
     * Get the associated DcBean object
     *
     * @return the associated DcBean object
     */
    public DcBean getDcBeanRelatedByDcId()
    {
        return aDcBeanRelatedByDcId;
    }





    private DcBean aDcBeanRelatedByDcId2;

    /**
     * sets an associated DcBean object
     *
     * @param v DcBean
     */
    public void setDcBeanRelatedByDcId2(DcBean v)
    {
        if (v == null)
        {
            setDcId2( 0);
        }
        else
        {
            setDcId2(v.getId());
        }
        aDcBeanRelatedByDcId2 = v;
    }


    /**
     * Get the associated DcBean object
     *
     * @return the associated DcBean object
     */
    public DcBean getDcBeanRelatedByDcId2()
    {
        return aDcBeanRelatedByDcId2;
    }



}
