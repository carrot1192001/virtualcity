
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
 * extended; all references should be to IdeaThumbnailBean
 */
public abstract class BaseIdeaThumbnailBean
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

    /** The value for the thumbnailId field */
    private String thumbnailId;

    /** The value for the ideaUrlId field */
    private int ideaUrlId;

    /** The value for the title field */
    private String title;

    /** The value for the thumbnailUrl field */
    private String thumbnailUrl;

    /** The value for the updateTime field */
    private Date updateTime;


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
     * Get the ThumbnailId
     *
     * @return String
     */
    public String getThumbnailId ()
    {
        return thumbnailId;
    }

    /**
     * Set the value of ThumbnailId
     *
     * @param v new value
     */
    public void setThumbnailId(String v)
    {

        this.thumbnailId = v;
        setModified(true);

    }

    /**
     * Get the IdeaUrlId
     *
     * @return int
     */
    public int getIdeaUrlId ()
    {
        return ideaUrlId;
    }

    /**
     * Set the value of IdeaUrlId
     *
     * @param v new value
     */
    public void setIdeaUrlId(int v)
    {

        this.ideaUrlId = v;
        setModified(true);

    }

    /**
     * Get the Title
     *
     * @return String
     */
    public String getTitle ()
    {
        return title;
    }

    /**
     * Set the value of Title
     *
     * @param v new value
     */
    public void setTitle(String v)
    {

        this.title = v;
        setModified(true);

    }

    /**
     * Get the ThumbnailUrl
     *
     * @return String
     */
    public String getThumbnailUrl ()
    {
        return thumbnailUrl;
    }

    /**
     * Set the value of ThumbnailUrl
     *
     * @param v new value
     */
    public void setThumbnailUrl(String v)
    {

        this.thumbnailUrl = v;
        setModified(true);

    }

    /**
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime ()
    {
        return updateTime;
    }

    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(Date v)
    {

        this.updateTime = v;
        setModified(true);

    }

    



    private IdeaUrlBean aIdeaUrlBean;

    /**
     * sets an associated IdeaUrlBean object
     *
     * @param v IdeaUrlBean
     */
    public void setIdeaUrlBean(IdeaUrlBean v)
    {
        if (v == null)
        {
            setIdeaUrlId( 0);
        }
        else
        {
            setIdeaUrlId(v.getId());
        }
        aIdeaUrlBean = v;
    }


    /**
     * Get the associated IdeaUrlBean object
     *
     * @return the associated IdeaUrlBean object
     */
    public IdeaUrlBean getIdeaUrlBean()
    {
        return aIdeaUrlBean;
    }



}
