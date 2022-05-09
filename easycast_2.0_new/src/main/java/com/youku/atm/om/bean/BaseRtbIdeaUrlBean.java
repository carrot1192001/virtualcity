
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
 * extended; all references should be to RtbIdeaUrlBean
 */
public abstract class BaseRtbIdeaUrlBean
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

    /** The value for the url field */
    private String url;

    /** The value for the dspId field */
    private String dspId;

    /** The value for the starttime field */
    private Date starttime;

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
     * Get the Url
     *
     * @return String
     */
    public String getUrl ()
    {
        return url;
    }

    /**
     * Set the value of Url
     *
     * @param v new value
     */
    public void setUrl(String v)
    {

        this.url = v;
        setModified(true);

    }

    /**
     * Get the DspId
     *
     * @return String
     */
    public String getDspId ()
    {
        return dspId;
    }

    /**
     * Set the value of DspId
     *
     * @param v new value
     */
    public void setDspId(String v)
    {

        this.dspId = v;
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
