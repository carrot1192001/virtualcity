
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
 * extended; all references should be to ProtectAdBean
 */
public abstract class BaseProtectAdBean
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

    /** The value for the protectId field */
    private int protectId;

    /** The value for the type field */
    private int type;

    /** The value for the value field */
    private String value;


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
     * Get the ProtectId
     *
     * @return int
     */
    public int getProtectId ()
    {
        return protectId;
    }

    /**
     * Set the value of ProtectId
     *
     * @param v new value
     */
    public void setProtectId(int v)
    {

        this.protectId = v;
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
     * @return String
     */
    public String getValue ()
    {
        return value;
    }

    /**
     * Set the value of Value
     *
     * @param v new value
     */
    public void setValue(String v)
    {

        this.value = v;
        setModified(true);

    }

    



    private ProtectBean aProtectBean;

    /**
     * sets an associated ProtectBean object
     *
     * @param v ProtectBean
     */
    public void setProtectBean(ProtectBean v)
    {
        if (v == null)
        {
            setProtectId( 0);
        }
        else
        {
            setProtectId(v.getId());
        }
        aProtectBean = v;
    }


    /**
     * Get the associated ProtectBean object
     *
     * @return the associated ProtectBean object
     */
    public ProtectBean getProtectBean()
    {
        return aProtectBean;
    }



}
