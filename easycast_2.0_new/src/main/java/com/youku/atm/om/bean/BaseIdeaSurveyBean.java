
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
 * extended; all references should be to IdeaSurveyBean
 */
public abstract class BaseIdeaSurveyBean
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

    /** The value for the stype field */
    private int stype;

    /** The value for the site field */
    private int site = 1;

    /** The value for the aw field */
    private String aw;

    /** The value for the surveyUrl field */
    private String surveyUrl;

    /** The value for the clickUrl field */
    private String clickUrl;

    /** The value for the surveyText field */
    private String surveyText;

    /** The value for the timeLen field */
    private int timeLen = 0;


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
     * Get the Stype
     *
     * @return int
     */
    public int getStype ()
    {
        return stype;
    }

    /**
     * Set the value of Stype
     *
     * @param v new value
     */
    public void setStype(int v)
    {

        this.stype = v;
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
     * Get the Aw
     *
     * @return String
     */
    public String getAw ()
    {
        return aw;
    }

    /**
     * Set the value of Aw
     *
     * @param v new value
     */
    public void setAw(String v)
    {

        this.aw = v;
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

    /**
     * Get the ClickUrl
     *
     * @return String
     */
    public String getClickUrl ()
    {
        return clickUrl;
    }

    /**
     * Set the value of ClickUrl
     *
     * @param v new value
     */
    public void setClickUrl(String v)
    {

        this.clickUrl = v;
        setModified(true);

    }

    /**
     * Get the SurveyText
     *
     * @return String
     */
    public String getSurveyText ()
    {
        return surveyText;
    }

    /**
     * Set the value of SurveyText
     *
     * @param v new value
     */
    public void setSurveyText(String v)
    {

        this.surveyText = v;
        setModified(true);

    }

    /**
     * Get the TimeLen
     *
     * @return int
     */
    public int getTimeLen ()
    {
        return timeLen;
    }

    /**
     * Set the value of TimeLen
     *
     * @param v new value
     */
    public void setTimeLen(int v)
    {

        this.timeLen = v;
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
