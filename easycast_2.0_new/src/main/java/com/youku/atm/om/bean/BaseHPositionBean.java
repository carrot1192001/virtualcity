
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
 * extended; all references should be to HPositionBean
 */
public abstract class BaseHPositionBean
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

    /** The value for the parentId field */
    private int parentId;

    /** The value for the name field */
    private String name;

    /** The value for the type field */
    private int type;

    /** The value for the value field */
    private int value;

    /** The value for the templet field */
    private String templet;

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
     * Get the ParentId
     *
     * @return int
     */
    public int getParentId ()
    {
        return parentId;
    }

    /**
     * Set the value of ParentId
     *
     * @param v new value
     */
    public void setParentId(int v)
    {

        this.parentId = v;
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
     * Get the Value
     *
     * @return int
     */
    public int getValue ()
    {
        return value;
    }

    /**
     * Set the value of Value
     *
     * @param v new value
     */
    public void setValue(int v)
    {

        this.value = v;
        setModified(true);

    }

    /**
     * Get the Templet
     *
     * @return String
     */
    public String getTemplet ()
    {
        return templet;
    }

    /**
     * Set the value of Templet
     *
     * @param v new value
     */
    public void setTemplet(String v)
    {

        this.templet = v;
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
     * Collection to store aggregation of collCastHpositionBeans
     */
    protected List<CastHpositionBean> collCastHpositionBeans;

    /**
     * Returns the collection of CastHpositionBeans
     */
    public List<CastHpositionBean> getCastHpositionBeans()
    {
        return collCastHpositionBeans;
    }

    /**
     * Sets the collection of CastHpositionBeans to the specified value
     */
    public void setCastHpositionBeans(List<CastHpositionBean> list)
    {
        if (list == null)
        {
            collCastHpositionBeans = null;
        }
        else
        {
            collCastHpositionBeans = new ArrayList<CastHpositionBean>(list);
        }
    }

}
