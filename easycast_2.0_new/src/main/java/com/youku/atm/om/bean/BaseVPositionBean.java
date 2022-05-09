
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
 * extended; all references should be to VPositionBean
 */
public abstract class BaseVPositionBean
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

    /** The value for the manageType field */
    private String manageType;

    /** The value for the ps field */
    private int ps;

    /** The value for the adSeq field */
    private int adSeq;

    /** The value for the type field */
    private int type;

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
     * Get the Ps
     *
     * @return int
     */
    public int getPs ()
    {
        return ps;
    }

    /**
     * Set the value of Ps
     *
     * @param v new value
     */
    public void setPs(int v)
    {

        this.ps = v;
        setModified(true);

    }

    /**
     * Get the AdSeq
     *
     * @return int
     */
    public int getAdSeq ()
    {
        return adSeq;
    }

    /**
     * Set the value of AdSeq
     *
     * @param v new value
     */
    public void setAdSeq(int v)
    {

        this.adSeq = v;
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

    

}
