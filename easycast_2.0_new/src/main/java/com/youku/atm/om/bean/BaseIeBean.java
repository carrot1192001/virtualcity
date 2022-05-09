
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
 * extended; all references should be to IeBean
 */
public abstract class BaseIeBean
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

    /** The value for the newIe field */
    private int newIe;

    /** The value for the oldIe field */
    private int oldIe;

    /** The value for the direction field */
    private int direction;

    /** The value for the type field */
    private int type;


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
     * Get the NewIe
     *
     * @return int
     */
    public int getNewIe ()
    {
        return newIe;
    }

    /**
     * Set the value of NewIe
     *
     * @param v new value
     */
    public void setNewIe(int v)
    {

        this.newIe = v;
        setModified(true);

    }

    /**
     * Get the OldIe
     *
     * @return int
     */
    public int getOldIe ()
    {
        return oldIe;
    }

    /**
     * Set the value of OldIe
     *
     * @param v new value
     */
    public void setOldIe(int v)
    {

        this.oldIe = v;
        setModified(true);

    }

    /**
     * Get the Direction
     *
     * @return int
     */
    public int getDirection ()
    {
        return direction;
    }

    /**
     * Set the value of Direction
     *
     * @param v new value
     */
    public void setDirection(int v)
    {

        this.direction = v;
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

    

}
