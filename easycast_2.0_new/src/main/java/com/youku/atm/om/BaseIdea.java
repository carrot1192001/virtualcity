package com.youku.atm.om;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;




  import org.apache.commons.collections.map.IdentityMap;
import java.util.Iterator;
import com.youku.atm.om.bean.IdeaBean;

import com.youku.atm.om.bean.IdeaSurveyBean;
import com.youku.atm.om.bean.IdeaUrlBean;
import com.youku.atm.om.bean.IdeaMonitorBean;
import com.youku.atm.om.bean.IdeaCpmBean;
import com.youku.atm.om.bean.IdeaTimeBean;
import com.youku.atm.om.bean.HideaCpmBean;
import com.youku.atm.om.bean.HideaTimeBean;
import com.youku.atm.om.bean.VhideaCpmBean;
import com.youku.atm.om.bean.VhideaTimeBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Idea
 */
public abstract class BaseIdea extends BaseObject
{
    /** The Peer class */
    private static final IdeaPeer peer =
        new IdeaPeer();


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
     * Get the Id
     *
     * @return int
     */
    public int getId()
    {
        return id;
    }


    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(int v) throws TorqueException
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
        }



        // update associated IdeaSurvey
        if (collIdeaSurveys != null)
        {
            for (int i = 0; i < collIdeaSurveys.size(); i++)
            {
                ((IdeaSurvey) collIdeaSurveys.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated IdeaUrl
        if (collIdeaUrls != null)
        {
            for (int i = 0; i < collIdeaUrls.size(); i++)
            {
                ((IdeaUrl) collIdeaUrls.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated IdeaMonitor
        if (collIdeaMonitors != null)
        {
            for (int i = 0; i < collIdeaMonitors.size(); i++)
            {
                ((IdeaMonitor) collIdeaMonitors.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated IdeaCpm
        if (collIdeaCpms != null)
        {
            for (int i = 0; i < collIdeaCpms.size(); i++)
            {
                ((IdeaCpm) collIdeaCpms.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated IdeaTime
        if (collIdeaTimes != null)
        {
            for (int i = 0; i < collIdeaTimes.size(); i++)
            {
                ((IdeaTime) collIdeaTimes.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated HideaCpm
        if (collHideaCpms != null)
        {
            for (int i = 0; i < collHideaCpms.size(); i++)
            {
                ((HideaCpm) collHideaCpms.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated HideaTime
        if (collHideaTimes != null)
        {
            for (int i = 0; i < collHideaTimes.size(); i++)
            {
                ((HideaTime) collHideaTimes.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated VhideaCpm
        if (collVhideaCpms != null)
        {
            for (int i = 0; i < collVhideaCpms.size(); i++)
            {
                ((VhideaCpm) collVhideaCpms.get(i))
                        .setIdeaId(v);
            }
        }

        // update associated VhideaTime
        if (collVhideaTimes != null)
        {
            for (int i = 0; i < collVhideaTimes.size(); i++)
            {
                ((VhideaTime) collVhideaTimes.get(i))
                        .setIdeaId(v);
            }
        }
    }

    /**
     * Get the CastId
     *
     * @return int
     */
    public int getCastId()
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

        if (this.castId != v)
        {
            this.castId = v;
            setModified(true);
        }


    }

    /**
     * Get the Name
     *
     * @return String
     */
    public String getName()
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

        if (!ObjectUtils.equals(this.name, v))
        {
            this.name = v;
            setModified(true);
        }


    }

    /**
     * Get the Showtime
     *
     * @return int
     */
    public int getShowtime()
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

        if (this.showtime != v)
        {
            this.showtime = v;
            setModified(true);
        }


    }

    /**
     * Get the IPriority
     *
     * @return int
     */
    public int getIPriority()
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

        if (this.iPriority != v)
        {
            this.iPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the Count
     *
     * @return int
     */
    public int getCount()
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

        if (this.count != v)
        {
            this.count = v;
            setModified(true);
        }


    }

    /**
     * Get the Numlimit
     *
     * @return int
     */
    public int getNumlimit()
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

        if (this.numlimit != v)
        {
            this.numlimit = v;
            setModified(true);
        }


    }

    /**
     * Get the Dq
     *
     * @return String
     */
    public String getDq()
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

        if (!ObjectUtils.equals(this.dq, v))
        {
            this.dq = v;
            setModified(true);
        }


    }

    /**
     * Get the Iesorg
     *
     * @return String
     */
    public String getIesorg()
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

        if (!ObjectUtils.equals(this.iesorg, v))
        {
            this.iesorg = v;
            setModified(true);
        }


    }

    /**
     * Get the Cuf
     *
     * @return int
     */
    public int getCuf()
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

        if (this.cuf != v)
        {
            this.cuf = v;
            setModified(true);
        }


    }

    /**
     * Get the Controltype
     *
     * @return int
     */
    public int getControltype()
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

        if (this.controltype != v)
        {
            this.controltype = v;
            setModified(true);
        }


    }

    /**
     * Get the Issdk
     *
     * @return int
     */
    public int getIssdk()
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

        if (this.issdk != v)
        {
            this.issdk = v;
            setModified(true);
        }


    }

    /**
     * Get the Sdkid
     *
     * @return int
     */
    public int getSdkid()
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

        if (this.sdkid != v)
        {
            this.sdkid = v;
            setModified(true);
        }


    }

    /**
     * Get the Mst
     *
     * @return int
     */
    public int getMst()
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

        if (this.mst != v)
        {
            this.mst = v;
            setModified(true);
        }


    }

    /**
     * Get the LocationType
     *
     * @return String
     */
    public String getLocationType()
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

        if (!ObjectUtils.equals(this.locationType, v))
        {
            this.locationType = v;
            setModified(true);
        }


    }

    /**
     * Get the CloseMethod
     *
     * @return int
     */
    public int getCloseMethod()
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

        if (this.closeMethod != v)
        {
            this.closeMethod = v;
            setModified(true);
        }


    }

    /**
     * Get the IdeaShowLocation
     *
     * @return int
     */
    public int getIdeaShowLocation()
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

        if (this.ideaShowLocation != v)
        {
            this.ideaShowLocation = v;
            setModified(true);
        }


    }

    /**
     * Get the ControlTypeMobile
     *
     * @return int
     */
    public int getControlTypeMobile()
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

        if (this.controlTypeMobile != v)
        {
            this.controlTypeMobile = v;
            setModified(true);
        }


    }

    /**
     * Get the ChargeTime
     *
     * @return int
     */
    public int getChargeTime()
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

        if (this.chargeTime != v)
        {
            this.chargeTime = v;
            setModified(true);
        }


    }

    /**
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime()
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

        if (!ObjectUtils.equals(this.updateTime, v))
        {
            this.updateTime = v;
            setModified(true);
        }


    }

    /**
     * Get the PlayType
     *
     * @return int
     */
    public int getPlayType()
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

        if (this.playType != v)
        {
            this.playType = v;
            setModified(true);
        }


    }

    /**
     * Get the Status
     *
     * @return int
     */
    public int getStatus()
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

        if (this.status != v)
        {
            this.status = v;
            setModified(true);
        }


    }

    /**
     * Get the LocType
     *
     * @return String
     */
    public String getLocType()
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

        if (!ObjectUtils.equals(this.locType, v))
        {
            this.locType = v;
            setModified(true);
        }


    }

    /**
     * Get the DpCuf
     *
     * @return int
     */
    public int getDpCuf()
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

        if (this.dpCuf != v)
        {
            this.dpCuf = v;
            setModified(true);
        }


    }

    /**
     * Get the LinkType
     *
     * @return String
     */
    public String getLinkType()
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

        if (!ObjectUtils.equals(this.linkType, v))
        {
            this.linkType = v;
            setModified(true);
        }


    }

    /**
     * Get the LinkId
     *
     * @return String
     */
    public String getLinkId()
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

        if (!ObjectUtils.equals(this.linkId, v))
        {
            this.linkId = v;
            setModified(true);
        }


    }

    /**
     * Get the AppKey
     *
     * @return String
     */
    public String getAppKey()
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

        if (!ObjectUtils.equals(this.appKey, v))
        {
            this.appKey = v;
            setModified(true);
        }


    }

    /**
     * Get the NdisplayType
     *
     * @return int
     */
    public int getNdisplayType()
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

        if (this.ndisplayType != v)
        {
            this.ndisplayType = v;
            setModified(true);
        }


    }

    /**
     * Get the BeginDate
     *
     * @return Date
     */
    public Date getBeginDate()
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

        if (!ObjectUtils.equals(this.beginDate, v))
        {
            this.beginDate = v;
            setModified(true);
        }


    }

    /**
     * Get the EndDate
     *
     * @return Date
     */
    public Date getEndDate()
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

        if (!ObjectUtils.equals(this.endDate, v))
        {
            this.endDate = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collIdeaSurveys
     */
    protected List<IdeaSurvey> collIdeaSurveys;

    /**
     * Temporary storage of collIdeaSurveys to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaSurveys()
    {
        if (collIdeaSurveys == null)
        {
            collIdeaSurveys = new ArrayList<IdeaSurvey>();
        }
    }


    /**
     * Method called to associate a IdeaSurvey object to this object
     * through the IdeaSurvey foreign key attribute
     *
     * @param l IdeaSurvey
     * @throws TorqueException
     */
    public void addIdeaSurvey(IdeaSurvey l) throws TorqueException
    {
        getIdeaSurveys().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a IdeaSurvey object to this object
     * through the IdeaSurvey foreign key attribute using connection.
     *
     * @param l IdeaSurvey
     * @throws TorqueException
     */
    public void addIdeaSurvey(IdeaSurvey l, Connection con) throws TorqueException
    {
        getIdeaSurveys(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaSurveys
     */
    private Criteria lastIdeaSurveysCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaSurveys(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaSurvey> getIdeaSurveys()
        throws TorqueException
    {
        if (collIdeaSurveys == null)
        {
            collIdeaSurveys = getIdeaSurveys(new Criteria(10));
        }
        return collIdeaSurveys;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaSurveys from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaSurvey> getIdeaSurveys(Criteria criteria) throws TorqueException
    {
        if (collIdeaSurveys == null)
        {
            if (isNew())
            {
               collIdeaSurveys = new ArrayList<IdeaSurvey>();
            }
            else
            {
                criteria.add(IdeaSurveyPeer.IDEA_ID, getId() );
                collIdeaSurveys = IdeaSurveyPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(IdeaSurveyPeer.IDEA_ID, getId());
                if (!lastIdeaSurveysCriteria.equals(criteria))
                {
                    collIdeaSurveys = IdeaSurveyPeer.doSelect(criteria);
                }
            }
        }
        lastIdeaSurveysCriteria = criteria;

        return collIdeaSurveys;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaSurveys(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaSurvey> getIdeaSurveys(Connection con) throws TorqueException
    {
        if (collIdeaSurveys == null)
        {
            collIdeaSurveys = getIdeaSurveys(new Criteria(10), con);
        }
        return collIdeaSurveys;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaSurveys from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaSurvey> getIdeaSurveys(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaSurveys == null)
        {
            if (isNew())
            {
               collIdeaSurveys = new ArrayList<IdeaSurvey>();
            }
            else
            {
                 criteria.add(IdeaSurveyPeer.IDEA_ID, getId());
                 collIdeaSurveys = IdeaSurveyPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(IdeaSurveyPeer.IDEA_ID, getId());
                 if (!lastIdeaSurveysCriteria.equals(criteria))
                 {
                     collIdeaSurveys = IdeaSurveyPeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaSurveysCriteria = criteria;

         return collIdeaSurveys;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related IdeaSurveys from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<IdeaSurvey> getIdeaSurveysJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaSurveys == null)
        {
            if (isNew())
            {
               collIdeaSurveys = new ArrayList<IdeaSurvey>();
            }
            else
            {
                criteria.add(IdeaSurveyPeer.IDEA_ID, getId());
                collIdeaSurveys = IdeaSurveyPeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaSurveyPeer.IDEA_ID, getId());
            if (!lastIdeaSurveysCriteria.equals(criteria))
            {
                collIdeaSurveys = IdeaSurveyPeer.doSelectJoinIdea(criteria);
            }
        }
        lastIdeaSurveysCriteria = criteria;

        return collIdeaSurveys;
    }





    /**
     * Collection to store aggregation of collIdeaUrls
     */
    protected List<IdeaUrl> collIdeaUrls;

    /**
     * Temporary storage of collIdeaUrls to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaUrls()
    {
        if (collIdeaUrls == null)
        {
            collIdeaUrls = new ArrayList<IdeaUrl>();
        }
    }


    /**
     * Method called to associate a IdeaUrl object to this object
     * through the IdeaUrl foreign key attribute
     *
     * @param l IdeaUrl
     * @throws TorqueException
     */
    public void addIdeaUrl(IdeaUrl l) throws TorqueException
    {
        getIdeaUrls().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a IdeaUrl object to this object
     * through the IdeaUrl foreign key attribute using connection.
     *
     * @param l IdeaUrl
     * @throws TorqueException
     */
    public void addIdeaUrl(IdeaUrl l, Connection con) throws TorqueException
    {
        getIdeaUrls(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaUrls
     */
    private Criteria lastIdeaUrlsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaUrls(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaUrl> getIdeaUrls()
        throws TorqueException
    {
        if (collIdeaUrls == null)
        {
            collIdeaUrls = getIdeaUrls(new Criteria(10));
        }
        return collIdeaUrls;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaUrls from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaUrl> getIdeaUrls(Criteria criteria) throws TorqueException
    {
        if (collIdeaUrls == null)
        {
            if (isNew())
            {
               collIdeaUrls = new ArrayList<IdeaUrl>();
            }
            else
            {
                criteria.add(IdeaUrlPeer.IDEA_ID, getId() );
                collIdeaUrls = IdeaUrlPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(IdeaUrlPeer.IDEA_ID, getId());
                if (!lastIdeaUrlsCriteria.equals(criteria))
                {
                    collIdeaUrls = IdeaUrlPeer.doSelect(criteria);
                }
            }
        }
        lastIdeaUrlsCriteria = criteria;

        return collIdeaUrls;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaUrls(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaUrl> getIdeaUrls(Connection con) throws TorqueException
    {
        if (collIdeaUrls == null)
        {
            collIdeaUrls = getIdeaUrls(new Criteria(10), con);
        }
        return collIdeaUrls;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaUrls from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaUrl> getIdeaUrls(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaUrls == null)
        {
            if (isNew())
            {
               collIdeaUrls = new ArrayList<IdeaUrl>();
            }
            else
            {
                 criteria.add(IdeaUrlPeer.IDEA_ID, getId());
                 collIdeaUrls = IdeaUrlPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(IdeaUrlPeer.IDEA_ID, getId());
                 if (!lastIdeaUrlsCriteria.equals(criteria))
                 {
                     collIdeaUrls = IdeaUrlPeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaUrlsCriteria = criteria;

         return collIdeaUrls;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related IdeaUrls from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<IdeaUrl> getIdeaUrlsJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaUrls == null)
        {
            if (isNew())
            {
               collIdeaUrls = new ArrayList<IdeaUrl>();
            }
            else
            {
                criteria.add(IdeaUrlPeer.IDEA_ID, getId());
                collIdeaUrls = IdeaUrlPeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaUrlPeer.IDEA_ID, getId());
            if (!lastIdeaUrlsCriteria.equals(criteria))
            {
                collIdeaUrls = IdeaUrlPeer.doSelectJoinIdea(criteria);
            }
        }
        lastIdeaUrlsCriteria = criteria;

        return collIdeaUrls;
    }





    /**
     * Collection to store aggregation of collIdeaMonitors
     */
    protected List<IdeaMonitor> collIdeaMonitors;

    /**
     * Temporary storage of collIdeaMonitors to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaMonitors()
    {
        if (collIdeaMonitors == null)
        {
            collIdeaMonitors = new ArrayList<IdeaMonitor>();
        }
    }


    /**
     * Method called to associate a IdeaMonitor object to this object
     * through the IdeaMonitor foreign key attribute
     *
     * @param l IdeaMonitor
     * @throws TorqueException
     */
    public void addIdeaMonitor(IdeaMonitor l) throws TorqueException
    {
        getIdeaMonitors().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a IdeaMonitor object to this object
     * through the IdeaMonitor foreign key attribute using connection.
     *
     * @param l IdeaMonitor
     * @throws TorqueException
     */
    public void addIdeaMonitor(IdeaMonitor l, Connection con) throws TorqueException
    {
        getIdeaMonitors(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaMonitors
     */
    private Criteria lastIdeaMonitorsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaMonitors(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaMonitor> getIdeaMonitors()
        throws TorqueException
    {
        if (collIdeaMonitors == null)
        {
            collIdeaMonitors = getIdeaMonitors(new Criteria(10));
        }
        return collIdeaMonitors;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaMonitors from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaMonitor> getIdeaMonitors(Criteria criteria) throws TorqueException
    {
        if (collIdeaMonitors == null)
        {
            if (isNew())
            {
               collIdeaMonitors = new ArrayList<IdeaMonitor>();
            }
            else
            {
                criteria.add(IdeaMonitorPeer.IDEA_ID, getId() );
                collIdeaMonitors = IdeaMonitorPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(IdeaMonitorPeer.IDEA_ID, getId());
                if (!lastIdeaMonitorsCriteria.equals(criteria))
                {
                    collIdeaMonitors = IdeaMonitorPeer.doSelect(criteria);
                }
            }
        }
        lastIdeaMonitorsCriteria = criteria;

        return collIdeaMonitors;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaMonitors(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaMonitor> getIdeaMonitors(Connection con) throws TorqueException
    {
        if (collIdeaMonitors == null)
        {
            collIdeaMonitors = getIdeaMonitors(new Criteria(10), con);
        }
        return collIdeaMonitors;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaMonitors from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaMonitor> getIdeaMonitors(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaMonitors == null)
        {
            if (isNew())
            {
               collIdeaMonitors = new ArrayList<IdeaMonitor>();
            }
            else
            {
                 criteria.add(IdeaMonitorPeer.IDEA_ID, getId());
                 collIdeaMonitors = IdeaMonitorPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(IdeaMonitorPeer.IDEA_ID, getId());
                 if (!lastIdeaMonitorsCriteria.equals(criteria))
                 {
                     collIdeaMonitors = IdeaMonitorPeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaMonitorsCriteria = criteria;

         return collIdeaMonitors;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related IdeaMonitors from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<IdeaMonitor> getIdeaMonitorsJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaMonitors == null)
        {
            if (isNew())
            {
               collIdeaMonitors = new ArrayList<IdeaMonitor>();
            }
            else
            {
                criteria.add(IdeaMonitorPeer.IDEA_ID, getId());
                collIdeaMonitors = IdeaMonitorPeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaMonitorPeer.IDEA_ID, getId());
            if (!lastIdeaMonitorsCriteria.equals(criteria))
            {
                collIdeaMonitors = IdeaMonitorPeer.doSelectJoinIdea(criteria);
            }
        }
        lastIdeaMonitorsCriteria = criteria;

        return collIdeaMonitors;
    }





    /**
     * Collection to store aggregation of collIdeaCpms
     */
    protected List<IdeaCpm> collIdeaCpms;

    /**
     * Temporary storage of collIdeaCpms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaCpms()
    {
        if (collIdeaCpms == null)
        {
            collIdeaCpms = new ArrayList<IdeaCpm>();
        }
    }


    /**
     * Method called to associate a IdeaCpm object to this object
     * through the IdeaCpm foreign key attribute
     *
     * @param l IdeaCpm
     * @throws TorqueException
     */
    public void addIdeaCpm(IdeaCpm l) throws TorqueException
    {
        getIdeaCpms().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a IdeaCpm object to this object
     * through the IdeaCpm foreign key attribute using connection.
     *
     * @param l IdeaCpm
     * @throws TorqueException
     */
    public void addIdeaCpm(IdeaCpm l, Connection con) throws TorqueException
    {
        getIdeaCpms(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaCpms
     */
    private Criteria lastIdeaCpmsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaCpms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaCpm> getIdeaCpms()
        throws TorqueException
    {
        if (collIdeaCpms == null)
        {
            collIdeaCpms = getIdeaCpms(new Criteria(10));
        }
        return collIdeaCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaCpms from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaCpm> getIdeaCpms(Criteria criteria) throws TorqueException
    {
        if (collIdeaCpms == null)
        {
            if (isNew())
            {
               collIdeaCpms = new ArrayList<IdeaCpm>();
            }
            else
            {
                criteria.add(IdeaCpmPeer.IDEA_ID, getId() );
                collIdeaCpms = IdeaCpmPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(IdeaCpmPeer.IDEA_ID, getId());
                if (!lastIdeaCpmsCriteria.equals(criteria))
                {
                    collIdeaCpms = IdeaCpmPeer.doSelect(criteria);
                }
            }
        }
        lastIdeaCpmsCriteria = criteria;

        return collIdeaCpms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaCpms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaCpm> getIdeaCpms(Connection con) throws TorqueException
    {
        if (collIdeaCpms == null)
        {
            collIdeaCpms = getIdeaCpms(new Criteria(10), con);
        }
        return collIdeaCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaCpms from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaCpm> getIdeaCpms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaCpms == null)
        {
            if (isNew())
            {
               collIdeaCpms = new ArrayList<IdeaCpm>();
            }
            else
            {
                 criteria.add(IdeaCpmPeer.IDEA_ID, getId());
                 collIdeaCpms = IdeaCpmPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(IdeaCpmPeer.IDEA_ID, getId());
                 if (!lastIdeaCpmsCriteria.equals(criteria))
                 {
                     collIdeaCpms = IdeaCpmPeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaCpmsCriteria = criteria;

         return collIdeaCpms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related IdeaCpms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<IdeaCpm> getIdeaCpmsJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaCpms == null)
        {
            if (isNew())
            {
               collIdeaCpms = new ArrayList<IdeaCpm>();
            }
            else
            {
                criteria.add(IdeaCpmPeer.IDEA_ID, getId());
                collIdeaCpms = IdeaCpmPeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaCpmPeer.IDEA_ID, getId());
            if (!lastIdeaCpmsCriteria.equals(criteria))
            {
                collIdeaCpms = IdeaCpmPeer.doSelectJoinIdea(criteria);
            }
        }
        lastIdeaCpmsCriteria = criteria;

        return collIdeaCpms;
    }





    /**
     * Collection to store aggregation of collIdeaTimes
     */
    protected List<IdeaTime> collIdeaTimes;

    /**
     * Temporary storage of collIdeaTimes to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaTimes()
    {
        if (collIdeaTimes == null)
        {
            collIdeaTimes = new ArrayList<IdeaTime>();
        }
    }


    /**
     * Method called to associate a IdeaTime object to this object
     * through the IdeaTime foreign key attribute
     *
     * @param l IdeaTime
     * @throws TorqueException
     */
    public void addIdeaTime(IdeaTime l) throws TorqueException
    {
        getIdeaTimes().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a IdeaTime object to this object
     * through the IdeaTime foreign key attribute using connection.
     *
     * @param l IdeaTime
     * @throws TorqueException
     */
    public void addIdeaTime(IdeaTime l, Connection con) throws TorqueException
    {
        getIdeaTimes(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaTimes
     */
    private Criteria lastIdeaTimesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaTimes(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaTime> getIdeaTimes()
        throws TorqueException
    {
        if (collIdeaTimes == null)
        {
            collIdeaTimes = getIdeaTimes(new Criteria(10));
        }
        return collIdeaTimes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaTimes from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaTime> getIdeaTimes(Criteria criteria) throws TorqueException
    {
        if (collIdeaTimes == null)
        {
            if (isNew())
            {
               collIdeaTimes = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.IDEA_ID, getId() );
                collIdeaTimes = IdeaTimePeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(IdeaTimePeer.IDEA_ID, getId());
                if (!lastIdeaTimesCriteria.equals(criteria))
                {
                    collIdeaTimes = IdeaTimePeer.doSelect(criteria);
                }
            }
        }
        lastIdeaTimesCriteria = criteria;

        return collIdeaTimes;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaTimes(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaTime> getIdeaTimes(Connection con) throws TorqueException
    {
        if (collIdeaTimes == null)
        {
            collIdeaTimes = getIdeaTimes(new Criteria(10), con);
        }
        return collIdeaTimes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related IdeaTimes from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaTime> getIdeaTimes(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaTimes == null)
        {
            if (isNew())
            {
               collIdeaTimes = new ArrayList<IdeaTime>();
            }
            else
            {
                 criteria.add(IdeaTimePeer.IDEA_ID, getId());
                 collIdeaTimes = IdeaTimePeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(IdeaTimePeer.IDEA_ID, getId());
                 if (!lastIdeaTimesCriteria.equals(criteria))
                 {
                     collIdeaTimes = IdeaTimePeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaTimesCriteria = criteria;

         return collIdeaTimes;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related IdeaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<IdeaTime> getIdeaTimesJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaTimes == null)
        {
            if (isNew())
            {
               collIdeaTimes = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.IDEA_ID, getId());
                collIdeaTimes = IdeaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaTimePeer.IDEA_ID, getId());
            if (!lastIdeaTimesCriteria.equals(criteria))
            {
                collIdeaTimes = IdeaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        lastIdeaTimesCriteria = criteria;

        return collIdeaTimes;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related IdeaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<IdeaTime> getIdeaTimesJoinDcRelatedByDcId(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaTimes == null)
        {
            if (isNew())
            {
               collIdeaTimes = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.IDEA_ID, getId());
                collIdeaTimes = IdeaTimePeer.doSelectJoinDcRelatedByDcId(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaTimePeer.IDEA_ID, getId());
            if (!lastIdeaTimesCriteria.equals(criteria))
            {
                collIdeaTimes = IdeaTimePeer.doSelectJoinDcRelatedByDcId(criteria);
            }
        }
        lastIdeaTimesCriteria = criteria;

        return collIdeaTimes;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related IdeaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<IdeaTime> getIdeaTimesJoinDcRelatedByDcId2(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaTimes == null)
        {
            if (isNew())
            {
               collIdeaTimes = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.IDEA_ID, getId());
                collIdeaTimes = IdeaTimePeer.doSelectJoinDcRelatedByDcId2(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaTimePeer.IDEA_ID, getId());
            if (!lastIdeaTimesCriteria.equals(criteria))
            {
                collIdeaTimes = IdeaTimePeer.doSelectJoinDcRelatedByDcId2(criteria);
            }
        }
        lastIdeaTimesCriteria = criteria;

        return collIdeaTimes;
    }





    /**
     * Collection to store aggregation of collHideaCpms
     */
    protected List<HideaCpm> collHideaCpms;

    /**
     * Temporary storage of collHideaCpms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initHideaCpms()
    {
        if (collHideaCpms == null)
        {
            collHideaCpms = new ArrayList<HideaCpm>();
        }
    }


    /**
     * Method called to associate a HideaCpm object to this object
     * through the HideaCpm foreign key attribute
     *
     * @param l HideaCpm
     * @throws TorqueException
     */
    public void addHideaCpm(HideaCpm l) throws TorqueException
    {
        getHideaCpms().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a HideaCpm object to this object
     * through the HideaCpm foreign key attribute using connection.
     *
     * @param l HideaCpm
     * @throws TorqueException
     */
    public void addHideaCpm(HideaCpm l, Connection con) throws TorqueException
    {
        getHideaCpms(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collHideaCpms
     */
    private Criteria lastHideaCpmsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getHideaCpms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<HideaCpm> getHideaCpms()
        throws TorqueException
    {
        if (collHideaCpms == null)
        {
            collHideaCpms = getHideaCpms(new Criteria(10));
        }
        return collHideaCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related HideaCpms from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<HideaCpm> getHideaCpms(Criteria criteria) throws TorqueException
    {
        if (collHideaCpms == null)
        {
            if (isNew())
            {
               collHideaCpms = new ArrayList<HideaCpm>();
            }
            else
            {
                criteria.add(HideaCpmPeer.IDEA_ID, getId() );
                collHideaCpms = HideaCpmPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(HideaCpmPeer.IDEA_ID, getId());
                if (!lastHideaCpmsCriteria.equals(criteria))
                {
                    collHideaCpms = HideaCpmPeer.doSelect(criteria);
                }
            }
        }
        lastHideaCpmsCriteria = criteria;

        return collHideaCpms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getHideaCpms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<HideaCpm> getHideaCpms(Connection con) throws TorqueException
    {
        if (collHideaCpms == null)
        {
            collHideaCpms = getHideaCpms(new Criteria(10), con);
        }
        return collHideaCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related HideaCpms from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<HideaCpm> getHideaCpms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collHideaCpms == null)
        {
            if (isNew())
            {
               collHideaCpms = new ArrayList<HideaCpm>();
            }
            else
            {
                 criteria.add(HideaCpmPeer.IDEA_ID, getId());
                 collHideaCpms = HideaCpmPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(HideaCpmPeer.IDEA_ID, getId());
                 if (!lastHideaCpmsCriteria.equals(criteria))
                 {
                     collHideaCpms = HideaCpmPeer.doSelect(criteria, con);
                 }
             }
         }
         lastHideaCpmsCriteria = criteria;

         return collHideaCpms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related HideaCpms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<HideaCpm> getHideaCpmsJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collHideaCpms == null)
        {
            if (isNew())
            {
               collHideaCpms = new ArrayList<HideaCpm>();
            }
            else
            {
                criteria.add(HideaCpmPeer.IDEA_ID, getId());
                collHideaCpms = HideaCpmPeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(HideaCpmPeer.IDEA_ID, getId());
            if (!lastHideaCpmsCriteria.equals(criteria))
            {
                collHideaCpms = HideaCpmPeer.doSelectJoinIdea(criteria);
            }
        }
        lastHideaCpmsCriteria = criteria;

        return collHideaCpms;
    }





    /**
     * Collection to store aggregation of collHideaTimes
     */
    protected List<HideaTime> collHideaTimes;

    /**
     * Temporary storage of collHideaTimes to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initHideaTimes()
    {
        if (collHideaTimes == null)
        {
            collHideaTimes = new ArrayList<HideaTime>();
        }
    }


    /**
     * Method called to associate a HideaTime object to this object
     * through the HideaTime foreign key attribute
     *
     * @param l HideaTime
     * @throws TorqueException
     */
    public void addHideaTime(HideaTime l) throws TorqueException
    {
        getHideaTimes().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a HideaTime object to this object
     * through the HideaTime foreign key attribute using connection.
     *
     * @param l HideaTime
     * @throws TorqueException
     */
    public void addHideaTime(HideaTime l, Connection con) throws TorqueException
    {
        getHideaTimes(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collHideaTimes
     */
    private Criteria lastHideaTimesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getHideaTimes(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<HideaTime> getHideaTimes()
        throws TorqueException
    {
        if (collHideaTimes == null)
        {
            collHideaTimes = getHideaTimes(new Criteria(10));
        }
        return collHideaTimes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related HideaTimes from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<HideaTime> getHideaTimes(Criteria criteria) throws TorqueException
    {
        if (collHideaTimes == null)
        {
            if (isNew())
            {
               collHideaTimes = new ArrayList<HideaTime>();
            }
            else
            {
                criteria.add(HideaTimePeer.IDEA_ID, getId() );
                collHideaTimes = HideaTimePeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(HideaTimePeer.IDEA_ID, getId());
                if (!lastHideaTimesCriteria.equals(criteria))
                {
                    collHideaTimes = HideaTimePeer.doSelect(criteria);
                }
            }
        }
        lastHideaTimesCriteria = criteria;

        return collHideaTimes;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getHideaTimes(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<HideaTime> getHideaTimes(Connection con) throws TorqueException
    {
        if (collHideaTimes == null)
        {
            collHideaTimes = getHideaTimes(new Criteria(10), con);
        }
        return collHideaTimes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related HideaTimes from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<HideaTime> getHideaTimes(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collHideaTimes == null)
        {
            if (isNew())
            {
               collHideaTimes = new ArrayList<HideaTime>();
            }
            else
            {
                 criteria.add(HideaTimePeer.IDEA_ID, getId());
                 collHideaTimes = HideaTimePeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(HideaTimePeer.IDEA_ID, getId());
                 if (!lastHideaTimesCriteria.equals(criteria))
                 {
                     collHideaTimes = HideaTimePeer.doSelect(criteria, con);
                 }
             }
         }
         lastHideaTimesCriteria = criteria;

         return collHideaTimes;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related HideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<HideaTime> getHideaTimesJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collHideaTimes == null)
        {
            if (isNew())
            {
               collHideaTimes = new ArrayList<HideaTime>();
            }
            else
            {
                criteria.add(HideaTimePeer.IDEA_ID, getId());
                collHideaTimes = HideaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(HideaTimePeer.IDEA_ID, getId());
            if (!lastHideaTimesCriteria.equals(criteria))
            {
                collHideaTimes = HideaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        lastHideaTimesCriteria = criteria;

        return collHideaTimes;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related HideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<HideaTime> getHideaTimesJoinDc(Criteria criteria)
        throws TorqueException
    {
        if (collHideaTimes == null)
        {
            if (isNew())
            {
               collHideaTimes = new ArrayList<HideaTime>();
            }
            else
            {
                criteria.add(HideaTimePeer.IDEA_ID, getId());
                collHideaTimes = HideaTimePeer.doSelectJoinDc(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(HideaTimePeer.IDEA_ID, getId());
            if (!lastHideaTimesCriteria.equals(criteria))
            {
                collHideaTimes = HideaTimePeer.doSelectJoinDc(criteria);
            }
        }
        lastHideaTimesCriteria = criteria;

        return collHideaTimes;
    }





    /**
     * Collection to store aggregation of collVhideaCpms
     */
    protected List<VhideaCpm> collVhideaCpms;

    /**
     * Temporary storage of collVhideaCpms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initVhideaCpms()
    {
        if (collVhideaCpms == null)
        {
            collVhideaCpms = new ArrayList<VhideaCpm>();
        }
    }


    /**
     * Method called to associate a VhideaCpm object to this object
     * through the VhideaCpm foreign key attribute
     *
     * @param l VhideaCpm
     * @throws TorqueException
     */
    public void addVhideaCpm(VhideaCpm l) throws TorqueException
    {
        getVhideaCpms().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a VhideaCpm object to this object
     * through the VhideaCpm foreign key attribute using connection.
     *
     * @param l VhideaCpm
     * @throws TorqueException
     */
    public void addVhideaCpm(VhideaCpm l, Connection con) throws TorqueException
    {
        getVhideaCpms(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collVhideaCpms
     */
    private Criteria lastVhideaCpmsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getVhideaCpms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<VhideaCpm> getVhideaCpms()
        throws TorqueException
    {
        if (collVhideaCpms == null)
        {
            collVhideaCpms = getVhideaCpms(new Criteria(10));
        }
        return collVhideaCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related VhideaCpms from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<VhideaCpm> getVhideaCpms(Criteria criteria) throws TorqueException
    {
        if (collVhideaCpms == null)
        {
            if (isNew())
            {
               collVhideaCpms = new ArrayList<VhideaCpm>();
            }
            else
            {
                criteria.add(VhideaCpmPeer.IDEA_ID, getId() );
                collVhideaCpms = VhideaCpmPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(VhideaCpmPeer.IDEA_ID, getId());
                if (!lastVhideaCpmsCriteria.equals(criteria))
                {
                    collVhideaCpms = VhideaCpmPeer.doSelect(criteria);
                }
            }
        }
        lastVhideaCpmsCriteria = criteria;

        return collVhideaCpms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getVhideaCpms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<VhideaCpm> getVhideaCpms(Connection con) throws TorqueException
    {
        if (collVhideaCpms == null)
        {
            collVhideaCpms = getVhideaCpms(new Criteria(10), con);
        }
        return collVhideaCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related VhideaCpms from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<VhideaCpm> getVhideaCpms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collVhideaCpms == null)
        {
            if (isNew())
            {
               collVhideaCpms = new ArrayList<VhideaCpm>();
            }
            else
            {
                 criteria.add(VhideaCpmPeer.IDEA_ID, getId());
                 collVhideaCpms = VhideaCpmPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(VhideaCpmPeer.IDEA_ID, getId());
                 if (!lastVhideaCpmsCriteria.equals(criteria))
                 {
                     collVhideaCpms = VhideaCpmPeer.doSelect(criteria, con);
                 }
             }
         }
         lastVhideaCpmsCriteria = criteria;

         return collVhideaCpms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related VhideaCpms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<VhideaCpm> getVhideaCpmsJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collVhideaCpms == null)
        {
            if (isNew())
            {
               collVhideaCpms = new ArrayList<VhideaCpm>();
            }
            else
            {
                criteria.add(VhideaCpmPeer.IDEA_ID, getId());
                collVhideaCpms = VhideaCpmPeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(VhideaCpmPeer.IDEA_ID, getId());
            if (!lastVhideaCpmsCriteria.equals(criteria))
            {
                collVhideaCpms = VhideaCpmPeer.doSelectJoinIdea(criteria);
            }
        }
        lastVhideaCpmsCriteria = criteria;

        return collVhideaCpms;
    }





    /**
     * Collection to store aggregation of collVhideaTimes
     */
    protected List<VhideaTime> collVhideaTimes;

    /**
     * Temporary storage of collVhideaTimes to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initVhideaTimes()
    {
        if (collVhideaTimes == null)
        {
            collVhideaTimes = new ArrayList<VhideaTime>();
        }
    }


    /**
     * Method called to associate a VhideaTime object to this object
     * through the VhideaTime foreign key attribute
     *
     * @param l VhideaTime
     * @throws TorqueException
     */
    public void addVhideaTime(VhideaTime l) throws TorqueException
    {
        getVhideaTimes().add(l);
        l.setIdea((Idea) this);
    }

    /**
     * Method called to associate a VhideaTime object to this object
     * through the VhideaTime foreign key attribute using connection.
     *
     * @param l VhideaTime
     * @throws TorqueException
     */
    public void addVhideaTime(VhideaTime l, Connection con) throws TorqueException
    {
        getVhideaTimes(con).add(l);
        l.setIdea((Idea) this);
    }

    /**
     * The criteria used to select the current contents of collVhideaTimes
     */
    private Criteria lastVhideaTimesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getVhideaTimes(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<VhideaTime> getVhideaTimes()
        throws TorqueException
    {
        if (collVhideaTimes == null)
        {
            collVhideaTimes = getVhideaTimes(new Criteria(10));
        }
        return collVhideaTimes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<VhideaTime> getVhideaTimes(Criteria criteria) throws TorqueException
    {
        if (collVhideaTimes == null)
        {
            if (isNew())
            {
               collVhideaTimes = new ArrayList<VhideaTime>();
            }
            else
            {
                criteria.add(VhideaTimePeer.IDEA_ID, getId() );
                collVhideaTimes = VhideaTimePeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(VhideaTimePeer.IDEA_ID, getId());
                if (!lastVhideaTimesCriteria.equals(criteria))
                {
                    collVhideaTimes = VhideaTimePeer.doSelect(criteria);
                }
            }
        }
        lastVhideaTimesCriteria = criteria;

        return collVhideaTimes;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getVhideaTimes(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<VhideaTime> getVhideaTimes(Connection con) throws TorqueException
    {
        if (collVhideaTimes == null)
        {
            collVhideaTimes = getVhideaTimes(new Criteria(10), con);
        }
        return collVhideaTimes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     * If this Idea is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<VhideaTime> getVhideaTimes(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collVhideaTimes == null)
        {
            if (isNew())
            {
               collVhideaTimes = new ArrayList<VhideaTime>();
            }
            else
            {
                 criteria.add(VhideaTimePeer.IDEA_ID, getId());
                 collVhideaTimes = VhideaTimePeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(VhideaTimePeer.IDEA_ID, getId());
                 if (!lastVhideaTimesCriteria.equals(criteria))
                 {
                     collVhideaTimes = VhideaTimePeer.doSelect(criteria, con);
                 }
             }
         }
         lastVhideaTimesCriteria = criteria;

         return collVhideaTimes;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<VhideaTime> getVhideaTimesJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collVhideaTimes == null)
        {
            if (isNew())
            {
               collVhideaTimes = new ArrayList<VhideaTime>();
            }
            else
            {
                criteria.add(VhideaTimePeer.IDEA_ID, getId());
                collVhideaTimes = VhideaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(VhideaTimePeer.IDEA_ID, getId());
            if (!lastVhideaTimesCriteria.equals(criteria))
            {
                collVhideaTimes = VhideaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        lastVhideaTimesCriteria = criteria;

        return collVhideaTimes;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Idea is new, it will return
     * an empty collection; or if this Idea has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Idea.
     */
    protected List<VhideaTime> getVhideaTimesJoinDc(Criteria criteria)
        throws TorqueException
    {
        if (collVhideaTimes == null)
        {
            if (isNew())
            {
               collVhideaTimes = new ArrayList<VhideaTime>();
            }
            else
            {
                criteria.add(VhideaTimePeer.IDEA_ID, getId());
                collVhideaTimes = VhideaTimePeer.doSelectJoinDc(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(VhideaTimePeer.IDEA_ID, getId());
            if (!lastVhideaTimesCriteria.equals(criteria))
            {
                collVhideaTimes = VhideaTimePeer.doSelectJoinDc(criteria);
            }
        }
        lastVhideaTimesCriteria = criteria;

        return collVhideaTimes;
    }



        
    private static List<String> fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List<String> getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList<String>();
            fieldNames.add("Id");
            fieldNames.add("CastId");
            fieldNames.add("Name");
            fieldNames.add("Showtime");
            fieldNames.add("IPriority");
            fieldNames.add("Count");
            fieldNames.add("Numlimit");
            fieldNames.add("Dq");
            fieldNames.add("Iesorg");
            fieldNames.add("Cuf");
            fieldNames.add("Controltype");
            fieldNames.add("Issdk");
            fieldNames.add("Sdkid");
            fieldNames.add("Mst");
            fieldNames.add("LocationType");
            fieldNames.add("CloseMethod");
            fieldNames.add("IdeaShowLocation");
            fieldNames.add("ControlTypeMobile");
            fieldNames.add("ChargeTime");
            fieldNames.add("UpdateTime");
            fieldNames.add("PlayType");
            fieldNames.add("Status");
            fieldNames.add("LocType");
            fieldNames.add("DpCuf");
            fieldNames.add("LinkType");
            fieldNames.add("LinkId");
            fieldNames.add("AppKey");
            fieldNames.add("NdisplayType");
            fieldNames.add("BeginDate");
            fieldNames.add("EndDate");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("Id"))
        {
            return new Integer(getId());
        }
        if (name.equals("CastId"))
        {
            return new Integer(getCastId());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("Showtime"))
        {
            return new Integer(getShowtime());
        }
        if (name.equals("IPriority"))
        {
            return new Integer(getIPriority());
        }
        if (name.equals("Count"))
        {
            return new Integer(getCount());
        }
        if (name.equals("Numlimit"))
        {
            return new Integer(getNumlimit());
        }
        if (name.equals("Dq"))
        {
            return getDq();
        }
        if (name.equals("Iesorg"))
        {
            return getIesorg();
        }
        if (name.equals("Cuf"))
        {
            return new Integer(getCuf());
        }
        if (name.equals("Controltype"))
        {
            return new Integer(getControltype());
        }
        if (name.equals("Issdk"))
        {
            return new Integer(getIssdk());
        }
        if (name.equals("Sdkid"))
        {
            return new Integer(getSdkid());
        }
        if (name.equals("Mst"))
        {
            return new Integer(getMst());
        }
        if (name.equals("LocationType"))
        {
            return getLocationType();
        }
        if (name.equals("CloseMethod"))
        {
            return new Integer(getCloseMethod());
        }
        if (name.equals("IdeaShowLocation"))
        {
            return new Integer(getIdeaShowLocation());
        }
        if (name.equals("ControlTypeMobile"))
        {
            return new Integer(getControlTypeMobile());
        }
        if (name.equals("ChargeTime"))
        {
            return new Integer(getChargeTime());
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("PlayType"))
        {
            return new Integer(getPlayType());
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("LocType"))
        {
            return getLocType();
        }
        if (name.equals("DpCuf"))
        {
            return new Integer(getDpCuf());
        }
        if (name.equals("LinkType"))
        {
            return getLinkType();
        }
        if (name.equals("LinkId"))
        {
            return getLinkId();
        }
        if (name.equals("AppKey"))
        {
            return getAppKey();
        }
        if (name.equals("NdisplayType"))
        {
            return new Integer(getNdisplayType());
        }
        if (name.equals("BeginDate"))
        {
            return getBeginDate();
        }
        if (name.equals("EndDate"))
        {
            return getEndDate();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("Id"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CastId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCastId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Name"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setName((String) value);
            return true;
        }
        if (name.equals("Showtime"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setShowtime(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Count"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCount(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Numlimit"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNumlimit(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Dq"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDq((String) value);
            return true;
        }
        if (name.equals("Iesorg"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setIesorg((String) value);
            return true;
        }
        if (name.equals("Cuf"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCuf(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Controltype"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setControltype(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Issdk"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIssdk(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Sdkid"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSdkid(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Mst"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMst(((Integer) value).intValue());
            return true;
        }
        if (name.equals("LocationType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLocationType((String) value);
            return true;
        }
        if (name.equals("CloseMethod"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCloseMethod(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IdeaShowLocation"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaShowLocation(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ControlTypeMobile"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setControlTypeMobile(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ChargeTime"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setChargeTime(((Integer) value).intValue());
            return true;
        }
        if (name.equals("UpdateTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUpdateTime((Date) value);
            return true;
        }
        if (name.equals("PlayType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPlayType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Status"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStatus(((Integer) value).intValue());
            return true;
        }
        if (name.equals("LocType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLocType((String) value);
            return true;
        }
        if (name.equals("DpCuf"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDpCuf(((Integer) value).intValue());
            return true;
        }
        if (name.equals("LinkType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLinkType((String) value);
            return true;
        }
        if (name.equals("LinkId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLinkId((String) value);
            return true;
        }
        if (name.equals("AppKey"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setAppKey((String) value);
            return true;
        }
        if (name.equals("NdisplayType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNdisplayType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("BeginDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setBeginDate((Date) value);
            return true;
        }
        if (name.equals("EndDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEndDate((Date) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(IdeaPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IdeaPeer.CAST_ID))
        {
            return new Integer(getCastId());
        }
        if (name.equals(IdeaPeer.NAME))
        {
            return getName();
        }
        if (name.equals(IdeaPeer.SHOWTIME))
        {
            return new Integer(getShowtime());
        }
        if (name.equals(IdeaPeer.I_PRIORITY))
        {
            return new Integer(getIPriority());
        }
        if (name.equals(IdeaPeer.COUNT))
        {
            return new Integer(getCount());
        }
        if (name.equals(IdeaPeer.NUMLIMIT))
        {
            return new Integer(getNumlimit());
        }
        if (name.equals(IdeaPeer.DQ))
        {
            return getDq();
        }
        if (name.equals(IdeaPeer.IESORG))
        {
            return getIesorg();
        }
        if (name.equals(IdeaPeer.CUF))
        {
            return new Integer(getCuf());
        }
        if (name.equals(IdeaPeer.CONTROLTYPE))
        {
            return new Integer(getControltype());
        }
        if (name.equals(IdeaPeer.ISSDK))
        {
            return new Integer(getIssdk());
        }
        if (name.equals(IdeaPeer.SDKID))
        {
            return new Integer(getSdkid());
        }
        if (name.equals(IdeaPeer.MST))
        {
            return new Integer(getMst());
        }
        if (name.equals(IdeaPeer.LOCATION_TYPE))
        {
            return getLocationType();
        }
        if (name.equals(IdeaPeer.CLOSE_METHOD))
        {
            return new Integer(getCloseMethod());
        }
        if (name.equals(IdeaPeer.IDEA_SHOW_LOCATION))
        {
            return new Integer(getIdeaShowLocation());
        }
        if (name.equals(IdeaPeer.CONTROL_TYPE_MOBILE))
        {
            return new Integer(getControlTypeMobile());
        }
        if (name.equals(IdeaPeer.CHARGE_TIME))
        {
            return new Integer(getChargeTime());
        }
        if (name.equals(IdeaPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(IdeaPeer.PLAY_TYPE))
        {
            return new Integer(getPlayType());
        }
        if (name.equals(IdeaPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(IdeaPeer.LOC_TYPE))
        {
            return getLocType();
        }
        if (name.equals(IdeaPeer.DP_CUF))
        {
            return new Integer(getDpCuf());
        }
        if (name.equals(IdeaPeer.LINK_TYPE))
        {
            return getLinkType();
        }
        if (name.equals(IdeaPeer.LINK_ID))
        {
            return getLinkId();
        }
        if (name.equals(IdeaPeer.APP_KEY))
        {
            return getAppKey();
        }
        if (name.equals(IdeaPeer.NDISPLAY_TYPE))
        {
            return new Integer(getNdisplayType());
        }
        if (name.equals(IdeaPeer.BEGIN_DATE))
        {
            return getBeginDate();
        }
        if (name.equals(IdeaPeer.END_DATE))
        {
            return getEndDate();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (IdeaPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IdeaPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
        }
      if (IdeaPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (IdeaPeer.SHOWTIME.equals(name))
        {
            return setByName("Showtime", value);
        }
      if (IdeaPeer.I_PRIORITY.equals(name))
        {
            return setByName("IPriority", value);
        }
      if (IdeaPeer.COUNT.equals(name))
        {
            return setByName("Count", value);
        }
      if (IdeaPeer.NUMLIMIT.equals(name))
        {
            return setByName("Numlimit", value);
        }
      if (IdeaPeer.DQ.equals(name))
        {
            return setByName("Dq", value);
        }
      if (IdeaPeer.IESORG.equals(name))
        {
            return setByName("Iesorg", value);
        }
      if (IdeaPeer.CUF.equals(name))
        {
            return setByName("Cuf", value);
        }
      if (IdeaPeer.CONTROLTYPE.equals(name))
        {
            return setByName("Controltype", value);
        }
      if (IdeaPeer.ISSDK.equals(name))
        {
            return setByName("Issdk", value);
        }
      if (IdeaPeer.SDKID.equals(name))
        {
            return setByName("Sdkid", value);
        }
      if (IdeaPeer.MST.equals(name))
        {
            return setByName("Mst", value);
        }
      if (IdeaPeer.LOCATION_TYPE.equals(name))
        {
            return setByName("LocationType", value);
        }
      if (IdeaPeer.CLOSE_METHOD.equals(name))
        {
            return setByName("CloseMethod", value);
        }
      if (IdeaPeer.IDEA_SHOW_LOCATION.equals(name))
        {
            return setByName("IdeaShowLocation", value);
        }
      if (IdeaPeer.CONTROL_TYPE_MOBILE.equals(name))
        {
            return setByName("ControlTypeMobile", value);
        }
      if (IdeaPeer.CHARGE_TIME.equals(name))
        {
            return setByName("ChargeTime", value);
        }
      if (IdeaPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (IdeaPeer.PLAY_TYPE.equals(name))
        {
            return setByName("PlayType", value);
        }
      if (IdeaPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (IdeaPeer.LOC_TYPE.equals(name))
        {
            return setByName("LocType", value);
        }
      if (IdeaPeer.DP_CUF.equals(name))
        {
            return setByName("DpCuf", value);
        }
      if (IdeaPeer.LINK_TYPE.equals(name))
        {
            return setByName("LinkType", value);
        }
      if (IdeaPeer.LINK_ID.equals(name))
        {
            return setByName("LinkId", value);
        }
      if (IdeaPeer.APP_KEY.equals(name))
        {
            return setByName("AppKey", value);
        }
      if (IdeaPeer.NDISPLAY_TYPE.equals(name))
        {
            return setByName("NdisplayType", value);
        }
      if (IdeaPeer.BEGIN_DATE.equals(name))
        {
            return setByName("BeginDate", value);
        }
      if (IdeaPeer.END_DATE.equals(name))
        {
            return setByName("EndDate", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getId());
        }
        if (pos == 1)
        {
            return new Integer(getCastId());
        }
        if (pos == 2)
        {
            return getName();
        }
        if (pos == 3)
        {
            return new Integer(getShowtime());
        }
        if (pos == 4)
        {
            return new Integer(getIPriority());
        }
        if (pos == 5)
        {
            return new Integer(getCount());
        }
        if (pos == 6)
        {
            return new Integer(getNumlimit());
        }
        if (pos == 7)
        {
            return getDq();
        }
        if (pos == 8)
        {
            return getIesorg();
        }
        if (pos == 9)
        {
            return new Integer(getCuf());
        }
        if (pos == 10)
        {
            return new Integer(getControltype());
        }
        if (pos == 11)
        {
            return new Integer(getIssdk());
        }
        if (pos == 12)
        {
            return new Integer(getSdkid());
        }
        if (pos == 13)
        {
            return new Integer(getMst());
        }
        if (pos == 14)
        {
            return getLocationType();
        }
        if (pos == 15)
        {
            return new Integer(getCloseMethod());
        }
        if (pos == 16)
        {
            return new Integer(getIdeaShowLocation());
        }
        if (pos == 17)
        {
            return new Integer(getControlTypeMobile());
        }
        if (pos == 18)
        {
            return new Integer(getChargeTime());
        }
        if (pos == 19)
        {
            return getUpdateTime();
        }
        if (pos == 20)
        {
            return new Integer(getPlayType());
        }
        if (pos == 21)
        {
            return new Integer(getStatus());
        }
        if (pos == 22)
        {
            return getLocType();
        }
        if (pos == 23)
        {
            return new Integer(getDpCuf());
        }
        if (pos == 24)
        {
            return getLinkType();
        }
        if (pos == 25)
        {
            return getLinkId();
        }
        if (pos == 26)
        {
            return getAppKey();
        }
        if (pos == 27)
        {
            return new Integer(getNdisplayType());
        }
        if (pos == 28)
        {
            return getBeginDate();
        }
        if (pos == 29)
        {
            return getEndDate();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("Id", value);
        }
    if (position == 1)
        {
            return setByName("CastId", value);
        }
    if (position == 2)
        {
            return setByName("Name", value);
        }
    if (position == 3)
        {
            return setByName("Showtime", value);
        }
    if (position == 4)
        {
            return setByName("IPriority", value);
        }
    if (position == 5)
        {
            return setByName("Count", value);
        }
    if (position == 6)
        {
            return setByName("Numlimit", value);
        }
    if (position == 7)
        {
            return setByName("Dq", value);
        }
    if (position == 8)
        {
            return setByName("Iesorg", value);
        }
    if (position == 9)
        {
            return setByName("Cuf", value);
        }
    if (position == 10)
        {
            return setByName("Controltype", value);
        }
    if (position == 11)
        {
            return setByName("Issdk", value);
        }
    if (position == 12)
        {
            return setByName("Sdkid", value);
        }
    if (position == 13)
        {
            return setByName("Mst", value);
        }
    if (position == 14)
        {
            return setByName("LocationType", value);
        }
    if (position == 15)
        {
            return setByName("CloseMethod", value);
        }
    if (position == 16)
        {
            return setByName("IdeaShowLocation", value);
        }
    if (position == 17)
        {
            return setByName("ControlTypeMobile", value);
        }
    if (position == 18)
        {
            return setByName("ChargeTime", value);
        }
    if (position == 19)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 20)
        {
            return setByName("PlayType", value);
        }
    if (position == 21)
        {
            return setByName("Status", value);
        }
    if (position == 22)
        {
            return setByName("LocType", value);
        }
    if (position == 23)
        {
            return setByName("DpCuf", value);
        }
    if (position == 24)
        {
            return setByName("LinkType", value);
        }
    if (position == 25)
        {
            return setByName("LinkId", value);
        }
    if (position == 26)
        {
            return setByName("AppKey", value);
        }
    if (position == 27)
        {
            return setByName("NdisplayType", value);
        }
    if (position == 28)
        {
            return setByName("BeginDate", value);
        }
    if (position == 29)
        {
            return setByName("EndDate", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
        save(IdeaPeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    IdeaPeer.doInsert((Idea) this, con);
                    setNew(false);
                }
                else
                {
                    IdeaPeer.doUpdate((Idea) this, con);
                }
            }


            if (collIdeaSurveys != null)
            {
                for (int i = 0; i < collIdeaSurveys.size(); i++)
                {
                    ((IdeaSurvey) collIdeaSurveys.get(i)).save(con);
                }
            }

            if (collIdeaUrls != null)
            {
                for (int i = 0; i < collIdeaUrls.size(); i++)
                {
                    ((IdeaUrl) collIdeaUrls.get(i)).save(con);
                }
            }

            if (collIdeaMonitors != null)
            {
                for (int i = 0; i < collIdeaMonitors.size(); i++)
                {
                    ((IdeaMonitor) collIdeaMonitors.get(i)).save(con);
                }
            }

            if (collIdeaCpms != null)
            {
                for (int i = 0; i < collIdeaCpms.size(); i++)
                {
                    ((IdeaCpm) collIdeaCpms.get(i)).save(con);
                }
            }

            if (collIdeaTimes != null)
            {
                for (int i = 0; i < collIdeaTimes.size(); i++)
                {
                    ((IdeaTime) collIdeaTimes.get(i)).save(con);
                }
            }

            if (collHideaCpms != null)
            {
                for (int i = 0; i < collHideaCpms.size(); i++)
                {
                    ((HideaCpm) collHideaCpms.get(i)).save(con);
                }
            }

            if (collHideaTimes != null)
            {
                for (int i = 0; i < collHideaTimes.size(); i++)
                {
                    ((HideaTime) collHideaTimes.get(i)).save(con);
                }
            }

            if (collVhideaCpms != null)
            {
                for (int i = 0; i < collVhideaCpms.size(); i++)
                {
                    ((VhideaCpm) collVhideaCpms.get(i)).save(con);
                }
            }

            if (collVhideaTimes != null)
            {
                for (int i = 0; i < collVhideaTimes.size(); i++)
                {
                    ((VhideaTime) collVhideaTimes.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key id ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Idea copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public Idea copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public Idea copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Idea(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public Idea copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Idea(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Idea copyInto(Idea copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected Idea copyInto(Idea copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected Idea copyInto(Idea copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setName(name);
        copyObj.setShowtime(showtime);
        copyObj.setIPriority(iPriority);
        copyObj.setCount(count);
        copyObj.setNumlimit(numlimit);
        copyObj.setDq(dq);
        copyObj.setIesorg(iesorg);
        copyObj.setCuf(cuf);
        copyObj.setControltype(controltype);
        copyObj.setIssdk(issdk);
        copyObj.setSdkid(sdkid);
        copyObj.setMst(mst);
        copyObj.setLocationType(locationType);
        copyObj.setCloseMethod(closeMethod);
        copyObj.setIdeaShowLocation(ideaShowLocation);
        copyObj.setControlTypeMobile(controlTypeMobile);
        copyObj.setChargeTime(chargeTime);
        copyObj.setUpdateTime(updateTime);
        copyObj.setPlayType(playType);
        copyObj.setStatus(status);
        copyObj.setLocType(locType);
        copyObj.setDpCuf(dpCuf);
        copyObj.setLinkType(linkType);
        copyObj.setLinkId(linkId);
        copyObj.setAppKey(appKey);
        copyObj.setNdisplayType(ndisplayType);
        copyObj.setBeginDate(beginDate);
        copyObj.setEndDate(endDate);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<IdeaSurvey> vIdeaSurveys = getIdeaSurveys();
        if (vIdeaSurveys != null)
        {
            for (int i = 0; i < vIdeaSurveys.size(); i++)
            {
                IdeaSurvey obj =  vIdeaSurveys.get(i);
                copyObj.addIdeaSurvey(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaSurveys = null;
        }


        List<IdeaUrl> vIdeaUrls = getIdeaUrls();
        if (vIdeaUrls != null)
        {
            for (int i = 0; i < vIdeaUrls.size(); i++)
            {
                IdeaUrl obj =  vIdeaUrls.get(i);
                copyObj.addIdeaUrl(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaUrls = null;
        }


        List<IdeaMonitor> vIdeaMonitors = getIdeaMonitors();
        if (vIdeaMonitors != null)
        {
            for (int i = 0; i < vIdeaMonitors.size(); i++)
            {
                IdeaMonitor obj =  vIdeaMonitors.get(i);
                copyObj.addIdeaMonitor(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaMonitors = null;
        }


        List<IdeaCpm> vIdeaCpms = getIdeaCpms();
        if (vIdeaCpms != null)
        {
            for (int i = 0; i < vIdeaCpms.size(); i++)
            {
                IdeaCpm obj =  vIdeaCpms.get(i);
                copyObj.addIdeaCpm(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaCpms = null;
        }


        List<IdeaTime> vIdeaTimes = getIdeaTimes();
        if (vIdeaTimes != null)
        {
            for (int i = 0; i < vIdeaTimes.size(); i++)
            {
                IdeaTime obj =  vIdeaTimes.get(i);
                copyObj.addIdeaTime(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaTimes = null;
        }


        List<HideaCpm> vHideaCpms = getHideaCpms();
        if (vHideaCpms != null)
        {
            for (int i = 0; i < vHideaCpms.size(); i++)
            {
                HideaCpm obj =  vHideaCpms.get(i);
                copyObj.addHideaCpm(obj.copy());
            }
        }
        else
        {
            copyObj.collHideaCpms = null;
        }


        List<HideaTime> vHideaTimes = getHideaTimes();
        if (vHideaTimes != null)
        {
            for (int i = 0; i < vHideaTimes.size(); i++)
            {
                HideaTime obj =  vHideaTimes.get(i);
                copyObj.addHideaTime(obj.copy());
            }
        }
        else
        {
            copyObj.collHideaTimes = null;
        }


        List<VhideaCpm> vVhideaCpms = getVhideaCpms();
        if (vVhideaCpms != null)
        {
            for (int i = 0; i < vVhideaCpms.size(); i++)
            {
                VhideaCpm obj =  vVhideaCpms.get(i);
                copyObj.addVhideaCpm(obj.copy());
            }
        }
        else
        {
            copyObj.collVhideaCpms = null;
        }


        List<VhideaTime> vVhideaTimes = getVhideaTimes();
        if (vVhideaTimes != null)
        {
            for (int i = 0; i < vVhideaTimes.size(); i++)
            {
                VhideaTime obj =  vVhideaTimes.get(i);
                copyObj.addVhideaTime(obj.copy());
            }
        }
        else
        {
            copyObj.collVhideaTimes = null;
        }
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected Idea copyInto(Idea copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setName(name);
        copyObj.setShowtime(showtime);
        copyObj.setIPriority(iPriority);
        copyObj.setCount(count);
        copyObj.setNumlimit(numlimit);
        copyObj.setDq(dq);
        copyObj.setIesorg(iesorg);
        copyObj.setCuf(cuf);
        copyObj.setControltype(controltype);
        copyObj.setIssdk(issdk);
        copyObj.setSdkid(sdkid);
        copyObj.setMst(mst);
        copyObj.setLocationType(locationType);
        copyObj.setCloseMethod(closeMethod);
        copyObj.setIdeaShowLocation(ideaShowLocation);
        copyObj.setControlTypeMobile(controlTypeMobile);
        copyObj.setChargeTime(chargeTime);
        copyObj.setUpdateTime(updateTime);
        copyObj.setPlayType(playType);
        copyObj.setStatus(status);
        copyObj.setLocType(locType);
        copyObj.setDpCuf(dpCuf);
        copyObj.setLinkType(linkType);
        copyObj.setLinkId(linkId);
        copyObj.setAppKey(appKey);
        copyObj.setNdisplayType(ndisplayType);
        copyObj.setBeginDate(beginDate);
        copyObj.setEndDate(endDate);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<IdeaSurvey> vIdeaSurveys = getIdeaSurveys(con);
        if (vIdeaSurveys != null)
        {
            for (int i = 0; i < vIdeaSurveys.size(); i++)
            {
                IdeaSurvey obj =  vIdeaSurveys.get(i);
                copyObj.addIdeaSurvey(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaSurveys = null;
        }


        List<IdeaUrl> vIdeaUrls = getIdeaUrls(con);
        if (vIdeaUrls != null)
        {
            for (int i = 0; i < vIdeaUrls.size(); i++)
            {
                IdeaUrl obj =  vIdeaUrls.get(i);
                copyObj.addIdeaUrl(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaUrls = null;
        }


        List<IdeaMonitor> vIdeaMonitors = getIdeaMonitors(con);
        if (vIdeaMonitors != null)
        {
            for (int i = 0; i < vIdeaMonitors.size(); i++)
            {
                IdeaMonitor obj =  vIdeaMonitors.get(i);
                copyObj.addIdeaMonitor(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaMonitors = null;
        }


        List<IdeaCpm> vIdeaCpms = getIdeaCpms(con);
        if (vIdeaCpms != null)
        {
            for (int i = 0; i < vIdeaCpms.size(); i++)
            {
                IdeaCpm obj =  vIdeaCpms.get(i);
                copyObj.addIdeaCpm(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaCpms = null;
        }


        List<IdeaTime> vIdeaTimes = getIdeaTimes(con);
        if (vIdeaTimes != null)
        {
            for (int i = 0; i < vIdeaTimes.size(); i++)
            {
                IdeaTime obj =  vIdeaTimes.get(i);
                copyObj.addIdeaTime(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaTimes = null;
        }


        List<HideaCpm> vHideaCpms = getHideaCpms(con);
        if (vHideaCpms != null)
        {
            for (int i = 0; i < vHideaCpms.size(); i++)
            {
                HideaCpm obj =  vHideaCpms.get(i);
                copyObj.addHideaCpm(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collHideaCpms = null;
        }


        List<HideaTime> vHideaTimes = getHideaTimes(con);
        if (vHideaTimes != null)
        {
            for (int i = 0; i < vHideaTimes.size(); i++)
            {
                HideaTime obj =  vHideaTimes.get(i);
                copyObj.addHideaTime(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collHideaTimes = null;
        }


        List<VhideaCpm> vVhideaCpms = getVhideaCpms(con);
        if (vVhideaCpms != null)
        {
            for (int i = 0; i < vVhideaCpms.size(); i++)
            {
                VhideaCpm obj =  vVhideaCpms.get(i);
                copyObj.addVhideaCpm(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collVhideaCpms = null;
        }


        List<VhideaTime> vVhideaTimes = getVhideaTimes(con);
        if (vVhideaTimes != null)
        {
            for (int i = 0; i < vVhideaTimes.size(); i++)
            {
                VhideaTime obj =  vVhideaTimes.get(i);
                copyObj.addVhideaTime(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collVhideaTimes = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public IdeaPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return IdeaPeer.getTableMap();
    }

  
    /**
     * Creates a IdeaBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IdeaBean with the contents of this object
     */
    public IdeaBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IdeaBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IdeaBean with the contents of this object
     */
    public IdeaBean getBean(IdentityMap createdBeans)
    {
        IdeaBean result = (IdeaBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IdeaBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setCastId(getCastId());
        result.setName(getName());
        result.setShowtime(getShowtime());
        result.setIPriority(getIPriority());
        result.setCount(getCount());
        result.setNumlimit(getNumlimit());
        result.setDq(getDq());
        result.setIesorg(getIesorg());
        result.setCuf(getCuf());
        result.setControltype(getControltype());
        result.setIssdk(getIssdk());
        result.setSdkid(getSdkid());
        result.setMst(getMst());
        result.setLocationType(getLocationType());
        result.setCloseMethod(getCloseMethod());
        result.setIdeaShowLocation(getIdeaShowLocation());
        result.setControlTypeMobile(getControlTypeMobile());
        result.setChargeTime(getChargeTime());
        result.setUpdateTime(getUpdateTime());
        result.setPlayType(getPlayType());
        result.setStatus(getStatus());
        result.setLocType(getLocType());
        result.setDpCuf(getDpCuf());
        result.setLinkType(getLinkType());
        result.setLinkId(getLinkId());
        result.setAppKey(getAppKey());
        result.setNdisplayType(getNdisplayType());
        result.setBeginDate(getBeginDate());
        result.setEndDate(getEndDate());



        if (collIdeaSurveys != null)
        {
            List<IdeaSurveyBean> relatedBeans = new ArrayList<IdeaSurveyBean>(collIdeaSurveys.size());
            for (Iterator<IdeaSurvey> collIdeaSurveysIt = collIdeaSurveys.iterator(); collIdeaSurveysIt.hasNext(); )
            {
                IdeaSurvey related = (IdeaSurvey) collIdeaSurveysIt.next();
                IdeaSurveyBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaSurveyBeans(relatedBeans);
        }


        if (collIdeaUrls != null)
        {
            List<IdeaUrlBean> relatedBeans = new ArrayList<IdeaUrlBean>(collIdeaUrls.size());
            for (Iterator<IdeaUrl> collIdeaUrlsIt = collIdeaUrls.iterator(); collIdeaUrlsIt.hasNext(); )
            {
                IdeaUrl related = (IdeaUrl) collIdeaUrlsIt.next();
                IdeaUrlBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaUrlBeans(relatedBeans);
        }


        if (collIdeaMonitors != null)
        {
            List<IdeaMonitorBean> relatedBeans = new ArrayList<IdeaMonitorBean>(collIdeaMonitors.size());
            for (Iterator<IdeaMonitor> collIdeaMonitorsIt = collIdeaMonitors.iterator(); collIdeaMonitorsIt.hasNext(); )
            {
                IdeaMonitor related = (IdeaMonitor) collIdeaMonitorsIt.next();
                IdeaMonitorBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaMonitorBeans(relatedBeans);
        }


        if (collIdeaCpms != null)
        {
            List<IdeaCpmBean> relatedBeans = new ArrayList<IdeaCpmBean>(collIdeaCpms.size());
            for (Iterator<IdeaCpm> collIdeaCpmsIt = collIdeaCpms.iterator(); collIdeaCpmsIt.hasNext(); )
            {
                IdeaCpm related = (IdeaCpm) collIdeaCpmsIt.next();
                IdeaCpmBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaCpmBeans(relatedBeans);
        }


        if (collIdeaTimes != null)
        {
            List<IdeaTimeBean> relatedBeans = new ArrayList<IdeaTimeBean>(collIdeaTimes.size());
            for (Iterator<IdeaTime> collIdeaTimesIt = collIdeaTimes.iterator(); collIdeaTimesIt.hasNext(); )
            {
                IdeaTime related = (IdeaTime) collIdeaTimesIt.next();
                IdeaTimeBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaTimeBeans(relatedBeans);
        }


        if (collHideaCpms != null)
        {
            List<HideaCpmBean> relatedBeans = new ArrayList<HideaCpmBean>(collHideaCpms.size());
            for (Iterator<HideaCpm> collHideaCpmsIt = collHideaCpms.iterator(); collHideaCpmsIt.hasNext(); )
            {
                HideaCpm related = (HideaCpm) collHideaCpmsIt.next();
                HideaCpmBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setHideaCpmBeans(relatedBeans);
        }


        if (collHideaTimes != null)
        {
            List<HideaTimeBean> relatedBeans = new ArrayList<HideaTimeBean>(collHideaTimes.size());
            for (Iterator<HideaTime> collHideaTimesIt = collHideaTimes.iterator(); collHideaTimesIt.hasNext(); )
            {
                HideaTime related = (HideaTime) collHideaTimesIt.next();
                HideaTimeBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setHideaTimeBeans(relatedBeans);
        }


        if (collVhideaCpms != null)
        {
            List<VhideaCpmBean> relatedBeans = new ArrayList<VhideaCpmBean>(collVhideaCpms.size());
            for (Iterator<VhideaCpm> collVhideaCpmsIt = collVhideaCpms.iterator(); collVhideaCpmsIt.hasNext(); )
            {
                VhideaCpm related = (VhideaCpm) collVhideaCpmsIt.next();
                VhideaCpmBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setVhideaCpmBeans(relatedBeans);
        }


        if (collVhideaTimes != null)
        {
            List<VhideaTimeBean> relatedBeans = new ArrayList<VhideaTimeBean>(collVhideaTimes.size());
            for (Iterator<VhideaTime> collVhideaTimesIt = collVhideaTimes.iterator(); collVhideaTimesIt.hasNext(); )
            {
                VhideaTime related = (VhideaTime) collVhideaTimesIt.next();
                VhideaTimeBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setVhideaTimeBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Idea with the contents
     * of a IdeaBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IdeaBean which contents are used to create
     *        the resulting class
     * @return an instance of Idea with the contents of bean
     */
    public static Idea createIdea(IdeaBean bean)
        throws TorqueException
    {
        return createIdea(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Idea with the contents
     * of a IdeaBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IdeaBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Idea with the contents of bean
     */

    public static Idea createIdea(IdeaBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Idea result = (Idea) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Idea();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setCastId(bean.getCastId());
        result.setName(bean.getName());
        result.setShowtime(bean.getShowtime());
        result.setIPriority(bean.getIPriority());
        result.setCount(bean.getCount());
        result.setNumlimit(bean.getNumlimit());
        result.setDq(bean.getDq());
        result.setIesorg(bean.getIesorg());
        result.setCuf(bean.getCuf());
        result.setControltype(bean.getControltype());
        result.setIssdk(bean.getIssdk());
        result.setSdkid(bean.getSdkid());
        result.setMst(bean.getMst());
        result.setLocationType(bean.getLocationType());
        result.setCloseMethod(bean.getCloseMethod());
        result.setIdeaShowLocation(bean.getIdeaShowLocation());
        result.setControlTypeMobile(bean.getControlTypeMobile());
        result.setChargeTime(bean.getChargeTime());
        result.setUpdateTime(bean.getUpdateTime());
        result.setPlayType(bean.getPlayType());
        result.setStatus(bean.getStatus());
        result.setLocType(bean.getLocType());
        result.setDpCuf(bean.getDpCuf());
        result.setLinkType(bean.getLinkType());
        result.setLinkId(bean.getLinkId());
        result.setAppKey(bean.getAppKey());
        result.setNdisplayType(bean.getNdisplayType());
        result.setBeginDate(bean.getBeginDate());
        result.setEndDate(bean.getEndDate());



        {
            List<IdeaSurveyBean> relatedBeans = bean.getIdeaSurveyBeans();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaSurveyBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaSurveyBean relatedBean =  relatedBeansIt.next();
                    IdeaSurvey related = IdeaSurvey.createIdeaSurvey(relatedBean, createdObjects);
                    result.addIdeaSurveyFromBean(related);
                }
            }
        }


        {
            List<IdeaUrlBean> relatedBeans = bean.getIdeaUrlBeans();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaUrlBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaUrlBean relatedBean =  relatedBeansIt.next();
                    IdeaUrl related = IdeaUrl.createIdeaUrl(relatedBean, createdObjects);
                    result.addIdeaUrlFromBean(related);
                }
            }
        }


        {
            List<IdeaMonitorBean> relatedBeans = bean.getIdeaMonitorBeans();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaMonitorBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaMonitorBean relatedBean =  relatedBeansIt.next();
                    IdeaMonitor related = IdeaMonitor.createIdeaMonitor(relatedBean, createdObjects);
                    result.addIdeaMonitorFromBean(related);
                }
            }
        }


        {
            List<IdeaCpmBean> relatedBeans = bean.getIdeaCpmBeans();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaCpmBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaCpmBean relatedBean =  relatedBeansIt.next();
                    IdeaCpm related = IdeaCpm.createIdeaCpm(relatedBean, createdObjects);
                    result.addIdeaCpmFromBean(related);
                }
            }
        }


        {
            List<IdeaTimeBean> relatedBeans = bean.getIdeaTimeBeans();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaTimeBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaTimeBean relatedBean =  relatedBeansIt.next();
                    IdeaTime related = IdeaTime.createIdeaTime(relatedBean, createdObjects);
                    result.addIdeaTimeFromBean(related);
                }
            }
        }


        {
            List<HideaCpmBean> relatedBeans = bean.getHideaCpmBeans();
            if (relatedBeans != null)
            {
                for (Iterator<HideaCpmBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    HideaCpmBean relatedBean =  relatedBeansIt.next();
                    HideaCpm related = HideaCpm.createHideaCpm(relatedBean, createdObjects);
                    result.addHideaCpmFromBean(related);
                }
            }
        }


        {
            List<HideaTimeBean> relatedBeans = bean.getHideaTimeBeans();
            if (relatedBeans != null)
            {
                for (Iterator<HideaTimeBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    HideaTimeBean relatedBean =  relatedBeansIt.next();
                    HideaTime related = HideaTime.createHideaTime(relatedBean, createdObjects);
                    result.addHideaTimeFromBean(related);
                }
            }
        }


        {
            List<VhideaCpmBean> relatedBeans = bean.getVhideaCpmBeans();
            if (relatedBeans != null)
            {
                for (Iterator<VhideaCpmBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    VhideaCpmBean relatedBean =  relatedBeansIt.next();
                    VhideaCpm related = VhideaCpm.createVhideaCpm(relatedBean, createdObjects);
                    result.addVhideaCpmFromBean(related);
                }
            }
        }


        {
            List<VhideaTimeBean> relatedBeans = bean.getVhideaTimeBeans();
            if (relatedBeans != null)
            {
                for (Iterator<VhideaTimeBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    VhideaTimeBean relatedBean =  relatedBeansIt.next();
                    VhideaTime related = VhideaTime.createVhideaTime(relatedBean, createdObjects);
                    result.addVhideaTimeFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a IdeaSurvey object to this object.
     * through the IdeaSurvey foreign key attribute
     *
     * @param toAdd IdeaSurvey
     */
    protected void addIdeaSurveyFromBean(IdeaSurvey toAdd)
    {
        initIdeaSurveys();
        collIdeaSurveys.add(toAdd);
    }


    /**
     * Method called to associate a IdeaUrl object to this object.
     * through the IdeaUrl foreign key attribute
     *
     * @param toAdd IdeaUrl
     */
    protected void addIdeaUrlFromBean(IdeaUrl toAdd)
    {
        initIdeaUrls();
        collIdeaUrls.add(toAdd);
    }


    /**
     * Method called to associate a IdeaMonitor object to this object.
     * through the IdeaMonitor foreign key attribute
     *
     * @param toAdd IdeaMonitor
     */
    protected void addIdeaMonitorFromBean(IdeaMonitor toAdd)
    {
        initIdeaMonitors();
        collIdeaMonitors.add(toAdd);
    }


    /**
     * Method called to associate a IdeaCpm object to this object.
     * through the IdeaCpm foreign key attribute
     *
     * @param toAdd IdeaCpm
     */
    protected void addIdeaCpmFromBean(IdeaCpm toAdd)
    {
        initIdeaCpms();
        collIdeaCpms.add(toAdd);
    }


    /**
     * Method called to associate a IdeaTime object to this object.
     * through the IdeaTime foreign key attribute
     *
     * @param toAdd IdeaTime
     */
    protected void addIdeaTimeFromBean(IdeaTime toAdd)
    {
        initIdeaTimes();
        collIdeaTimes.add(toAdd);
    }


    /**
     * Method called to associate a HideaCpm object to this object.
     * through the HideaCpm foreign key attribute
     *
     * @param toAdd HideaCpm
     */
    protected void addHideaCpmFromBean(HideaCpm toAdd)
    {
        initHideaCpms();
        collHideaCpms.add(toAdd);
    }


    /**
     * Method called to associate a HideaTime object to this object.
     * through the HideaTime foreign key attribute
     *
     * @param toAdd HideaTime
     */
    protected void addHideaTimeFromBean(HideaTime toAdd)
    {
        initHideaTimes();
        collHideaTimes.add(toAdd);
    }


    /**
     * Method called to associate a VhideaCpm object to this object.
     * through the VhideaCpm foreign key attribute
     *
     * @param toAdd VhideaCpm
     */
    protected void addVhideaCpmFromBean(VhideaCpm toAdd)
    {
        initVhideaCpms();
        collVhideaCpms.add(toAdd);
    }


    /**
     * Method called to associate a VhideaTime object to this object.
     * through the VhideaTime foreign key attribute
     *
     * @param toAdd VhideaTime
     */
    protected void addVhideaTimeFromBean(VhideaTime toAdd)
    {
        initVhideaTimes();
        collVhideaTimes.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Idea:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Showtime = ")
           .append(getShowtime())
           .append("\n");
        str.append("IPriority = ")
           .append(getIPriority())
           .append("\n");
        str.append("Count = ")
           .append(getCount())
           .append("\n");
        str.append("Numlimit = ")
           .append(getNumlimit())
           .append("\n");
        str.append("Dq = ")
           .append(getDq())
           .append("\n");
        str.append("Iesorg = ")
           .append(getIesorg())
           .append("\n");
        str.append("Cuf = ")
           .append(getCuf())
           .append("\n");
        str.append("Controltype = ")
           .append(getControltype())
           .append("\n");
        str.append("Issdk = ")
           .append(getIssdk())
           .append("\n");
        str.append("Sdkid = ")
           .append(getSdkid())
           .append("\n");
        str.append("Mst = ")
           .append(getMst())
           .append("\n");
        str.append("LocationType = ")
           .append(getLocationType())
           .append("\n");
        str.append("CloseMethod = ")
           .append(getCloseMethod())
           .append("\n");
        str.append("IdeaShowLocation = ")
           .append(getIdeaShowLocation())
           .append("\n");
        str.append("ControlTypeMobile = ")
           .append(getControlTypeMobile())
           .append("\n");
        str.append("ChargeTime = ")
           .append(getChargeTime())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("PlayType = ")
           .append(getPlayType())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("LocType = ")
           .append(getLocType())
           .append("\n");
        str.append("DpCuf = ")
           .append(getDpCuf())
           .append("\n");
        str.append("LinkType = ")
           .append(getLinkType())
           .append("\n");
        str.append("LinkId = ")
           .append(getLinkId())
           .append("\n");
        str.append("AppKey = ")
           .append(getAppKey())
           .append("\n");
        str.append("NdisplayType = ")
           .append(getNdisplayType())
           .append("\n");
        str.append("BeginDate = ")
           .append(getBeginDate())
           .append("\n");
        str.append("EndDate = ")
           .append(getEndDate())
           .append("\n");
        return(str.toString());
    }
}
