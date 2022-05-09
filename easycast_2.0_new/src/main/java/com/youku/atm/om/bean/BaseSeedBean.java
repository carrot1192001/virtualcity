
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
 * extended; all references should be to SeedBean
 */
public abstract class BaseSeedBean
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

    /** The value for the vid field */
    private String vid;

    /** The value for the name field */
    private String name;

    /** The value for the url field */
    private String url;

    /** The value for the description field */
    private String description;

    /** The value for the status field */
    private int status = 1;

    /** The value for the site field */
    private int site = 1;

    /** The value for the surveyUrl field */
    private String surveyUrl;


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
     * Get the Vid
     *
     * @return String
     */
    public String getVid ()
    {
        return vid;
    }

    /**
     * Set the value of Vid
     *
     * @param v new value
     */
    public void setVid(String v)
    {

        this.vid = v;
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
     * Get the Description
     *
     * @return String
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * Set the value of Description
     *
     * @param v new value
     */
    public void setDescription(String v)
    {

        this.description = v;
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
     * Get the SurveyUrl
     *
     * @return String
     */
    public String getSurveyUrl ()
    {
        return surveyUrl;
    }

    /**
     * Set the value of SurveyUrl
     *
     * @param v new value
     */
    public void setSurveyUrl(String v)
    {

        this.surveyUrl = v;
        setModified(true);

    }

    

}
