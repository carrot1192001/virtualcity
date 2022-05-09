
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
 * extended; all references should be to IdeaMonitorBean
 */
public abstract class BaseIdeaMonitorBean
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

    /** The value for the type field */
    private int type;

    /** The value for the site field */
    private int site;

    /** The value for the bt field */
    private int bt;

    /** The value for the url field */
    private String url;

    /** The value for the mt field */
    private int mt = -1;

    /** The value for the content field */
    private String content;

    /** The value for the seq field */
    private int seq = 0;

    /** The value for the castId field */
    private int castId = 0;


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
     * Get the Site
     *
     * @return int
     */
    public int getSite ()
    {
        return site;
    }

    /**
     * Set the value of Site
     *
     * @param v new value
     */
    public void setSite(int v)
    {

        this.site = v;
        setModified(true);

    }

    /**
     * Get the Bt
     *
     * @return int
     */
    public int getBt ()
    {
        return bt;
    }

    /**
     * Set the value of Bt
     *
     * @param v new value
     */
    public void setBt(int v)
    {

        this.bt = v;
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
     * Get the Mt
     *
     * @return int
     */
    public int getMt ()
    {
        return mt;
    }

    /**
     * Set the value of Mt
     *
     * @param v new value
     */
    public void setMt(int v)
    {

        this.mt = v;
        setModified(true);

    }

    /**
     * Get the Content
     *
     * @return String
     */
    public String getContent ()
    {
        return content;
    }

    /**
     * Set the value of Content
     *
     * @param v new value
     */
    public void setContent(String v)
    {

        this.content = v;
        setModified(true);

    }

    /**
     * Get the Seq
     *
     * @return int
     */
    public int getSeq ()
    {
        return seq;
    }

    /**
     * Set the value of Seq
     *
     * @param v new value
     */
    public void setSeq(int v)
    {

        this.seq = v;
        setModified(true);

    }

    /**
     * Get the CastId
     *
     * @return int
     */
    public int getCastId ()
    {
        return castId;
    }

    /**
     * Set the value of CastId
     *
     * @param v new value
     */
    public void setCastId(int v)
    {

        this.castId = v;
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



}
