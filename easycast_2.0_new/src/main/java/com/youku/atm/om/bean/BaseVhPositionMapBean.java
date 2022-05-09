
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
 * extended; all references should be to VhPositionMapBean
 */
public abstract class BaseVhPositionMapBean
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

    /** The value for the blockId field */
    private int blockId;

    /** The value for the vPositionId field */
    private int vPositionId;


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
     * Get the BlockId
     *
     * @return int
     */
    public int getBlockId ()
    {
        return blockId;
    }

    /**
     * Set the value of BlockId
     *
     * @param v new value
     */
    public void setBlockId(int v)
    {

        this.blockId = v;
        setModified(true);

    }

    /**
     * Get the VPositionId
     *
     * @return int
     */
    public int getVPositionId ()
    {
        return vPositionId;
    }

    /**
     * Set the value of VPositionId
     *
     * @param v new value
     */
    public void setVPositionId(int v)
    {

        this.vPositionId = v;
        setModified(true);

    }

    

}
