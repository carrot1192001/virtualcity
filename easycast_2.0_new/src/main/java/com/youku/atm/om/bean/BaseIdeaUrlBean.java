
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
 * extended; all references should be to IdeaUrlBean
 */
public abstract class BaseIdeaUrlBean
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

    /** The value for the site field */
    private int site;

    /** The value for the bt field */
    private int bt;

    /** The value for the type field */
    private int type;

    /** The value for the os field */
    private String os;

    /** The value for the content field */
    private String content;

    /** The value for the title field */
    private String title;

    /** The value for the text1 field */
    private String text1;

    /** The value for the text2 field */
    private String text2;

    /** The value for the ideaWidth field */
    private int ideaWidth;

    /** The value for the ideaHeight field */
    private int ideaHeight;

    /** The value for the skipTx field */
    private String skipTx;

    /** The value for the displayType field */
    private int displayType;

    /** The value for the iphonex field */
    private int iphonex;

    /** The value for the showtime field */
    private int showtime = 0;

    /** The value for the seq field */
    private int seq = 0;

    /** The value for the bitRate field */
    private String bitRate;

    /** The value for the volume field */
    private String volume;


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
     * Get the Os
     *
     * @return String
     */
    public String getOs ()
    {
        return os;
    }

    /**
     * Set the value of Os
     *
     * @param v new value
     */
    public void setOs(String v)
    {

        this.os = v;
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
     * Get the Text1
     *
     * @return String
     */
    public String getText1 ()
    {
        return text1;
    }

    /**
     * Set the value of Text1
     *
     * @param v new value
     */
    public void setText1(String v)
    {

        this.text1 = v;
        setModified(true);

    }

    /**
     * Get the Text2
     *
     * @return String
     */
    public String getText2 ()
    {
        return text2;
    }

    /**
     * Set the value of Text2
     *
     * @param v new value
     */
    public void setText2(String v)
    {

        this.text2 = v;
        setModified(true);

    }

    /**
     * Get the IdeaWidth
     *
     * @return int
     */
    public int getIdeaWidth ()
    {
        return ideaWidth;
    }

    /**
     * Set the value of IdeaWidth
     *
     * @param v new value
     */
    public void setIdeaWidth(int v)
    {

        this.ideaWidth = v;
        setModified(true);

    }

    /**
     * Get the IdeaHeight
     *
     * @return int
     */
    public int getIdeaHeight ()
    {
        return ideaHeight;
    }

    /**
     * Set the value of IdeaHeight
     *
     * @param v new value
     */
    public void setIdeaHeight(int v)
    {

        this.ideaHeight = v;
        setModified(true);

    }

    /**
     * Get the SkipTx
     *
     * @return String
     */
    public String getSkipTx ()
    {
        return skipTx;
    }

    /**
     * Set the value of SkipTx
     *
     * @param v new value
     */
    public void setSkipTx(String v)
    {

        this.skipTx = v;
        setModified(true);

    }

    /**
     * Get the DisplayType
     *
     * @return int
     */
    public int getDisplayType ()
    {
        return displayType;
    }

    /**
     * Set the value of DisplayType
     *
     * @param v new value
     */
    public void setDisplayType(int v)
    {

        this.displayType = v;
        setModified(true);

    }

    /**
     * Get the Iphonex
     *
     * @return int
     */
    public int getIphonex ()
    {
        return iphonex;
    }

    /**
     * Set the value of Iphonex
     *
     * @param v new value
     */
    public void setIphonex(int v)
    {

        this.iphonex = v;
        setModified(true);

    }

    /**
     * Get the Showtime
     *
     * @return int
     */
    public int getShowtime ()
    {
        return showtime;
    }

    /**
     * Set the value of Showtime
     *
     * @param v new value
     */
    public void setShowtime(int v)
    {

        this.showtime = v;
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
     * Get the BitRate
     *
     * @return String
     */
    public String getBitRate ()
    {
        return bitRate;
    }

    /**
     * Set the value of BitRate
     *
     * @param v new value
     */
    public void setBitRate(String v)
    {

        this.bitRate = v;
        setModified(true);

    }

    /**
     * Get the Volume
     *
     * @return String
     */
    public String getVolume ()
    {
        return volume;
    }

    /**
     * Set the value of Volume
     *
     * @param v new value
     */
    public void setVolume(String v)
    {

        this.volume = v;
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





    /**
     * Collection to store aggregation of collIdeaThumbnailBeans
     */
    protected List<IdeaThumbnailBean> collIdeaThumbnailBeans;

    /**
     * Returns the collection of IdeaThumbnailBeans
     */
    public List<IdeaThumbnailBean> getIdeaThumbnailBeans()
    {
        return collIdeaThumbnailBeans;
    }

    /**
     * Sets the collection of IdeaThumbnailBeans to the specified value
     */
    public void setIdeaThumbnailBeans(List<IdeaThumbnailBean> list)
    {
        if (list == null)
        {
            collIdeaThumbnailBeans = null;
        }
        else
        {
            collIdeaThumbnailBeans = new ArrayList<IdeaThumbnailBean>(list);
        }
    }

}
