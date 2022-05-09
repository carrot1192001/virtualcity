
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
 * extended; all references should be to IdeaBean
 */
public abstract class BaseIdeaBean
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

    /** The value for the castId field */
    private int castId;

    /** The value for the name field */
    private String name;

    /** The value for the showtime field */
    private int showtime;

    /** The value for the iPriority field */
    private int iPriority;

    /** The value for the count field */
    private int count;

    /** The value for the numlimit field */
    private int numlimit = 0;

    /** The value for the dq field */
    private String dq;

    /** The value for the iesorg field */
    private String iesorg;

    /** The value for the cuf field */
    private int cuf;

    /** The value for the controltype field */
    private int controltype;

    /** The value for the issdk field */
    private int issdk;

    /** The value for the sdkid field */
    private int sdkid = 0;

    /** The value for the mst field */
    private int mst = 0;

    /** The value for the locationType field */
    private String locationType;

    /** The value for the closeMethod field */
    private int closeMethod;

    /** The value for the ideaShowLocation field */
    private int ideaShowLocation = 0;

    /** The value for the controlTypeMobile field */
    private int controlTypeMobile = 0;

    /** The value for the chargeTime field */
    private int chargeTime;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the playType field */
    private int playType = 0;

    /** The value for the status field */
    private int status = 1;

    /** The value for the locType field */
    private String locType;

    /** The value for the dpCuf field */
    private int dpCuf = 0;

    /** The value for the linkType field */
    private String linkType;

    /** The value for the linkId field */
    private String linkId;

    /** The value for the appKey field */
    private String appKey;

    /** The value for the ndisplayType field */
    private int ndisplayType = 0;

    /** The value for the beginDate field */
    private Date beginDate;

    /** The value for the endDate field */
    private Date endDate;


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
     * Get the IPriority
     *
     * @return int
     */
    public int getIPriority ()
    {
        return iPriority;
    }

    /**
     * Set the value of IPriority
     *
     * @param v new value
     */
    public void setIPriority(int v)
    {

        this.iPriority = v;
        setModified(true);

    }

    /**
     * Get the Count
     *
     * @return int
     */
    public int getCount ()
    {
        return count;
    }

    /**
     * Set the value of Count
     *
     * @param v new value
     */
    public void setCount(int v)
    {

        this.count = v;
        setModified(true);

    }

    /**
     * Get the Numlimit
     *
     * @return int
     */
    public int getNumlimit ()
    {
        return numlimit;
    }

    /**
     * Set the value of Numlimit
     *
     * @param v new value
     */
    public void setNumlimit(int v)
    {

        this.numlimit = v;
        setModified(true);

    }

    /**
     * Get the Dq
     *
     * @return String
     */
    public String getDq ()
    {
        return dq;
    }

    /**
     * Set the value of Dq
     *
     * @param v new value
     */
    public void setDq(String v)
    {

        this.dq = v;
        setModified(true);

    }

    /**
     * Get the Iesorg
     *
     * @return String
     */
    public String getIesorg ()
    {
        return iesorg;
    }

    /**
     * Set the value of Iesorg
     *
     * @param v new value
     */
    public void setIesorg(String v)
    {

        this.iesorg = v;
        setModified(true);

    }

    /**
     * Get the Cuf
     *
     * @return int
     */
    public int getCuf ()
    {
        return cuf;
    }

    /**
     * Set the value of Cuf
     *
     * @param v new value
     */
    public void setCuf(int v)
    {

        this.cuf = v;
        setModified(true);

    }

    /**
     * Get the Controltype
     *
     * @return int
     */
    public int getControltype ()
    {
        return controltype;
    }

    /**
     * Set the value of Controltype
     *
     * @param v new value
     */
    public void setControltype(int v)
    {

        this.controltype = v;
        setModified(true);

    }

    /**
     * Get the Issdk
     *
     * @return int
     */
    public int getIssdk ()
    {
        return issdk;
    }

    /**
     * Set the value of Issdk
     *
     * @param v new value
     */
    public void setIssdk(int v)
    {

        this.issdk = v;
        setModified(true);

    }

    /**
     * Get the Sdkid
     *
     * @return int
     */
    public int getSdkid ()
    {
        return sdkid;
    }

    /**
     * Set the value of Sdkid
     *
     * @param v new value
     */
    public void setSdkid(int v)
    {

        this.sdkid = v;
        setModified(true);

    }

    /**
     * Get the Mst
     *
     * @return int
     */
    public int getMst ()
    {
        return mst;
    }

    /**
     * Set the value of Mst
     *
     * @param v new value
     */
    public void setMst(int v)
    {

        this.mst = v;
        setModified(true);

    }

    /**
     * Get the LocationType
     *
     * @return String
     */
    public String getLocationType ()
    {
        return locationType;
    }

    /**
     * Set the value of LocationType
     *
     * @param v new value
     */
    public void setLocationType(String v)
    {

        this.locationType = v;
        setModified(true);

    }

    /**
     * Get the CloseMethod
     *
     * @return int
     */
    public int getCloseMethod ()
    {
        return closeMethod;
    }

    /**
     * Set the value of CloseMethod
     *
     * @param v new value
     */
    public void setCloseMethod(int v)
    {

        this.closeMethod = v;
        setModified(true);

    }

    /**
     * Get the IdeaShowLocation
     *
     * @return int
     */
    public int getIdeaShowLocation ()
    {
        return ideaShowLocation;
    }

    /**
     * Set the value of IdeaShowLocation
     *
     * @param v new value
     */
    public void setIdeaShowLocation(int v)
    {

        this.ideaShowLocation = v;
        setModified(true);

    }

    /**
     * Get the ControlTypeMobile
     *
     * @return int
     */
    public int getControlTypeMobile ()
    {
        return controlTypeMobile;
    }

    /**
     * Set the value of ControlTypeMobile
     *
     * @param v new value
     */
    public void setControlTypeMobile(int v)
    {

        this.controlTypeMobile = v;
        setModified(true);

    }

    /**
     * Get the ChargeTime
     *
     * @return int
     */
    public int getChargeTime ()
    {
        return chargeTime;
    }

    /**
     * Set the value of ChargeTime
     *
     * @param v new value
     */
    public void setChargeTime(int v)
    {

        this.chargeTime = v;
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

    /**
     * Get the PlayType
     *
     * @return int
     */
    public int getPlayType ()
    {
        return playType;
    }

    /**
     * Set the value of PlayType
     *
     * @param v new value
     */
    public void setPlayType(int v)
    {

        this.playType = v;
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
     * Get the LocType
     *
     * @return String
     */
    public String getLocType ()
    {
        return locType;
    }

    /**
     * Set the value of LocType
     *
     * @param v new value
     */
    public void setLocType(String v)
    {

        this.locType = v;
        setModified(true);

    }

    /**
     * Get the DpCuf
     *
     * @return int
     */
    public int getDpCuf ()
    {
        return dpCuf;
    }

    /**
     * Set the value of DpCuf
     *
     * @param v new value
     */
    public void setDpCuf(int v)
    {

        this.dpCuf = v;
        setModified(true);

    }

    /**
     * Get the LinkType
     *
     * @return String
     */
    public String getLinkType ()
    {
        return linkType;
    }

    /**
     * Set the value of LinkType
     *
     * @param v new value
     */
    public void setLinkType(String v)
    {

        this.linkType = v;
        setModified(true);

    }

    /**
     * Get the LinkId
     *
     * @return String
     */
    public String getLinkId ()
    {
        return linkId;
    }

    /**
     * Set the value of LinkId
     *
     * @param v new value
     */
    public void setLinkId(String v)
    {

        this.linkId = v;
        setModified(true);

    }

    /**
     * Get the AppKey
     *
     * @return String
     */
    public String getAppKey ()
    {
        return appKey;
    }

    /**
     * Set the value of AppKey
     *
     * @param v new value
     */
    public void setAppKey(String v)
    {

        this.appKey = v;
        setModified(true);

    }

    /**
     * Get the NdisplayType
     *
     * @return int
     */
    public int getNdisplayType ()
    {
        return ndisplayType;
    }

    /**
     * Set the value of NdisplayType
     *
     * @param v new value
     */
    public void setNdisplayType(int v)
    {

        this.ndisplayType = v;
        setModified(true);

    }

    /**
     * Get the BeginDate
     *
     * @return Date
     */
    public Date getBeginDate ()
    {
        return beginDate;
    }

    /**
     * Set the value of BeginDate
     *
     * @param v new value
     */
    public void setBeginDate(Date v)
    {

        this.beginDate = v;
        setModified(true);

    }

    /**
     * Get the EndDate
     *
     * @return Date
     */
    public Date getEndDate ()
    {
        return endDate;
    }

    /**
     * Set the value of EndDate
     *
     * @param v new value
     */
    public void setEndDate(Date v)
    {

        this.endDate = v;
        setModified(true);

    }

    



    /**
     * Collection to store aggregation of collIdeaSurveyBeans
     */
    protected List<IdeaSurveyBean> collIdeaSurveyBeans;

    /**
     * Returns the collection of IdeaSurveyBeans
     */
    public List<IdeaSurveyBean> getIdeaSurveyBeans()
    {
        return collIdeaSurveyBeans;
    }

    /**
     * Sets the collection of IdeaSurveyBeans to the specified value
     */
    public void setIdeaSurveyBeans(List<IdeaSurveyBean> list)
    {
        if (list == null)
        {
            collIdeaSurveyBeans = null;
        }
        else
        {
            collIdeaSurveyBeans = new ArrayList<IdeaSurveyBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collIdeaUrlBeans
     */
    protected List<IdeaUrlBean> collIdeaUrlBeans;

    /**
     * Returns the collection of IdeaUrlBeans
     */
    public List<IdeaUrlBean> getIdeaUrlBeans()
    {
        return collIdeaUrlBeans;
    }

    /**
     * Sets the collection of IdeaUrlBeans to the specified value
     */
    public void setIdeaUrlBeans(List<IdeaUrlBean> list)
    {
        if (list == null)
        {
            collIdeaUrlBeans = null;
        }
        else
        {
            collIdeaUrlBeans = new ArrayList<IdeaUrlBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collIdeaMonitorBeans
     */
    protected List<IdeaMonitorBean> collIdeaMonitorBeans;

    /**
     * Returns the collection of IdeaMonitorBeans
     */
    public List<IdeaMonitorBean> getIdeaMonitorBeans()
    {
        return collIdeaMonitorBeans;
    }

    /**
     * Sets the collection of IdeaMonitorBeans to the specified value
     */
    public void setIdeaMonitorBeans(List<IdeaMonitorBean> list)
    {
        if (list == null)
        {
            collIdeaMonitorBeans = null;
        }
        else
        {
            collIdeaMonitorBeans = new ArrayList<IdeaMonitorBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collIdeaCpmBeans
     */
    protected List<IdeaCpmBean> collIdeaCpmBeans;

    /**
     * Returns the collection of IdeaCpmBeans
     */
    public List<IdeaCpmBean> getIdeaCpmBeans()
    {
        return collIdeaCpmBeans;
    }

    /**
     * Sets the collection of IdeaCpmBeans to the specified value
     */
    public void setIdeaCpmBeans(List<IdeaCpmBean> list)
    {
        if (list == null)
        {
            collIdeaCpmBeans = null;
        }
        else
        {
            collIdeaCpmBeans = new ArrayList<IdeaCpmBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collIdeaTimeBeans
     */
    protected List<IdeaTimeBean> collIdeaTimeBeans;

    /**
     * Returns the collection of IdeaTimeBeans
     */
    public List<IdeaTimeBean> getIdeaTimeBeans()
    {
        return collIdeaTimeBeans;
    }

    /**
     * Sets the collection of IdeaTimeBeans to the specified value
     */
    public void setIdeaTimeBeans(List<IdeaTimeBean> list)
    {
        if (list == null)
        {
            collIdeaTimeBeans = null;
        }
        else
        {
            collIdeaTimeBeans = new ArrayList<IdeaTimeBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collHideaCpmBeans
     */
    protected List<HideaCpmBean> collHideaCpmBeans;

    /**
     * Returns the collection of HideaCpmBeans
     */
    public List<HideaCpmBean> getHideaCpmBeans()
    {
        return collHideaCpmBeans;
    }

    /**
     * Sets the collection of HideaCpmBeans to the specified value
     */
    public void setHideaCpmBeans(List<HideaCpmBean> list)
    {
        if (list == null)
        {
            collHideaCpmBeans = null;
        }
        else
        {
            collHideaCpmBeans = new ArrayList<HideaCpmBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collHideaTimeBeans
     */
    protected List<HideaTimeBean> collHideaTimeBeans;

    /**
     * Returns the collection of HideaTimeBeans
     */
    public List<HideaTimeBean> getHideaTimeBeans()
    {
        return collHideaTimeBeans;
    }

    /**
     * Sets the collection of HideaTimeBeans to the specified value
     */
    public void setHideaTimeBeans(List<HideaTimeBean> list)
    {
        if (list == null)
        {
            collHideaTimeBeans = null;
        }
        else
        {
            collHideaTimeBeans = new ArrayList<HideaTimeBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collVhideaCpmBeans
     */
    protected List<VhideaCpmBean> collVhideaCpmBeans;

    /**
     * Returns the collection of VhideaCpmBeans
     */
    public List<VhideaCpmBean> getVhideaCpmBeans()
    {
        return collVhideaCpmBeans;
    }

    /**
     * Sets the collection of VhideaCpmBeans to the specified value
     */
    public void setVhideaCpmBeans(List<VhideaCpmBean> list)
    {
        if (list == null)
        {
            collVhideaCpmBeans = null;
        }
        else
        {
            collVhideaCpmBeans = new ArrayList<VhideaCpmBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collVhideaTimeBeans
     */
    protected List<VhideaTimeBean> collVhideaTimeBeans;

    /**
     * Returns the collection of VhideaTimeBeans
     */
    public List<VhideaTimeBean> getVhideaTimeBeans()
    {
        return collVhideaTimeBeans;
    }

    /**
     * Sets the collection of VhideaTimeBeans to the specified value
     */
    public void setVhideaTimeBeans(List<VhideaTimeBean> list)
    {
        if (list == null)
        {
            collVhideaTimeBeans = null;
        }
        else
        {
            collVhideaTimeBeans = new ArrayList<VhideaTimeBean>(list);
        }
    }

}
