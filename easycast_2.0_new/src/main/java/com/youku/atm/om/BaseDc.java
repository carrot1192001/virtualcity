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
import com.youku.atm.om.bean.DcBean;

import com.youku.atm.om.bean.IdeaTimeBean;
import com.youku.atm.om.bean.IdeaTimeBean;
import com.youku.atm.om.bean.HideaTimeBean;
import com.youku.atm.om.bean.VhideaTimeBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Dc
 */
public abstract class BaseDc extends BaseObject
{
    /** The Peer class */
    private static final DcPeer peer =
        new DcPeer();


    /** The value for the id field */
    private int id;

    /** The value for the targetDate field */
    private Date targetDate;

    /** The value for the cpm field */
    private int cpm;

    /** The value for the cpc field */
    private int cpc;

    /** The value for the cpv field */
    private int cpv = 0;

    /** The value for the cpp field */
    private int cpp = 0;


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



        // update associated IdeaTime
        if (collIdeaTimesRelatedByDcId != null)
        {
            for (int i = 0; i < collIdeaTimesRelatedByDcId.size(); i++)
            {
                ((IdeaTime) collIdeaTimesRelatedByDcId.get(i))
                        .setDcId(v);
            }
        }

        // update associated IdeaTime
        if (collIdeaTimesRelatedByDcId2 != null)
        {
            for (int i = 0; i < collIdeaTimesRelatedByDcId2.size(); i++)
            {
                ((IdeaTime) collIdeaTimesRelatedByDcId2.get(i))
                        .setDcId2(v);
            }
        }

        // update associated HideaTime
        if (collHideaTimes != null)
        {
            for (int i = 0; i < collHideaTimes.size(); i++)
            {
                ((HideaTime) collHideaTimes.get(i))
                        .setDcId(v);
            }
        }

        // update associated VhideaTime
        if (collVhideaTimes != null)
        {
            for (int i = 0; i < collVhideaTimes.size(); i++)
            {
                ((VhideaTime) collVhideaTimes.get(i))
                        .setDcId(v);
            }
        }
    }

    /**
     * Get the TargetDate
     *
     * @return Date
     */
    public Date getTargetDate()
    {
        return targetDate;
    }


    /**
     * Set the value of TargetDate
     *
     * @param v new value
     */
    public void setTargetDate(Date v) 
    {

        if (!ObjectUtils.equals(this.targetDate, v))
        {
            this.targetDate = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpm
     *
     * @return int
     */
    public int getCpm()
    {
        return cpm;
    }


    /**
     * Set the value of Cpm
     *
     * @param v new value
     */
    public void setCpm(int v) 
    {

        if (this.cpm != v)
        {
            this.cpm = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpc
     *
     * @return int
     */
    public int getCpc()
    {
        return cpc;
    }


    /**
     * Set the value of Cpc
     *
     * @param v new value
     */
    public void setCpc(int v) 
    {

        if (this.cpc != v)
        {
            this.cpc = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpv
     *
     * @return int
     */
    public int getCpv()
    {
        return cpv;
    }


    /**
     * Set the value of Cpv
     *
     * @param v new value
     */
    public void setCpv(int v) 
    {

        if (this.cpv != v)
        {
            this.cpv = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpp
     *
     * @return int
     */
    public int getCpp()
    {
        return cpp;
    }


    /**
     * Set the value of Cpp
     *
     * @param v new value
     */
    public void setCpp(int v) 
    {

        if (this.cpp != v)
        {
            this.cpp = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collIdeaTimesRelatedByDcId
     */
    protected List<IdeaTime> collIdeaTimesRelatedByDcId;

    /**
     * Temporary storage of collIdeaTimesRelatedByDcId to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaTimesRelatedByDcId()
    {
        if (collIdeaTimesRelatedByDcId == null)
        {
            collIdeaTimesRelatedByDcId = new ArrayList<IdeaTime>();
        }
    }


    /**
     * Method called to associate a IdeaTime object to this object
     * through the IdeaTime foreign key attribute
     *
     * @param l IdeaTime
     * @throws TorqueException
     */
    public void addIdeaTimeRelatedByDcId(IdeaTime l) throws TorqueException
    {
        getIdeaTimesRelatedByDcId().add(l);
        l.setDcRelatedByDcId((Dc) this);
    }

    /**
     * Method called to associate a IdeaTime object to this object
     * through the IdeaTime foreign key attribute using connection.
     *
     * @param l IdeaTime
     * @throws TorqueException
     */
    public void addIdeaTimeRelatedByDcId(IdeaTime l, Connection con) throws TorqueException
    {
        getIdeaTimesRelatedByDcId(con).add(l);
        l.setDcRelatedByDcId((Dc) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaTimesRelatedByDcId
     */
    private Criteria lastIdeaTimesRelatedByDcIdCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaTimesRelatedByDcId(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId()
        throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId == null)
        {
            collIdeaTimesRelatedByDcId = getIdeaTimesRelatedByDcId(new Criteria(10));
        }
        return collIdeaTimesRelatedByDcId;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId from storage.
     * If this Dc is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId(Criteria criteria) throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.DC_ID, getId() );
                collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelect(criteria);
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
                criteria.add(IdeaTimePeer.DC_ID, getId());
                if (!lastIdeaTimesRelatedByDcIdCriteria.equals(criteria))
                {
                    collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelect(criteria);
                }
            }
        }
        lastIdeaTimesRelatedByDcIdCriteria = criteria;

        return collIdeaTimesRelatedByDcId;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaTimesRelatedByDcId(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId(Connection con) throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId == null)
        {
            collIdeaTimesRelatedByDcId = getIdeaTimesRelatedByDcId(new Criteria(10), con);
        }
        return collIdeaTimesRelatedByDcId;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId from storage.
     * If this Dc is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId = new ArrayList<IdeaTime>();
            }
            else
            {
                 criteria.add(IdeaTimePeer.DC_ID, getId());
                 collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelect(criteria, con);
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
                 criteria.add(IdeaTimePeer.DC_ID, getId());
                 if (!lastIdeaTimesRelatedByDcIdCriteria.equals(criteria))
                 {
                     collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaTimesRelatedByDcIdCriteria = criteria;

         return collIdeaTimesRelatedByDcId;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
     */
    protected List<IdeaTime> getIdeaTimesRelatedByDcIdJoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.DC_ID, getId());
                collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaTimePeer.DC_ID, getId());
            if (!lastIdeaTimesRelatedByDcIdCriteria.equals(criteria))
            {
                collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        lastIdeaTimesRelatedByDcIdCriteria = criteria;

        return collIdeaTimesRelatedByDcId;
    }

















    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
     */
    protected List<IdeaTime> getIdeaTimesRelatedByDcIdJoinDcRelatedByDcId2(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.DC_ID, getId());
                collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelectJoinDcRelatedByDcId2(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaTimePeer.DC_ID, getId());
            if (!lastIdeaTimesRelatedByDcIdCriteria.equals(criteria))
            {
                collIdeaTimesRelatedByDcId = IdeaTimePeer.doSelectJoinDcRelatedByDcId2(criteria);
            }
        }
        lastIdeaTimesRelatedByDcIdCriteria = criteria;

        return collIdeaTimesRelatedByDcId;
    }





    /**
     * Collection to store aggregation of collIdeaTimesRelatedByDcId2
     */
    protected List<IdeaTime> collIdeaTimesRelatedByDcId2;

    /**
     * Temporary storage of collIdeaTimesRelatedByDcId2 to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaTimesRelatedByDcId2()
    {
        if (collIdeaTimesRelatedByDcId2 == null)
        {
            collIdeaTimesRelatedByDcId2 = new ArrayList<IdeaTime>();
        }
    }


    /**
     * Method called to associate a IdeaTime object to this object
     * through the IdeaTime foreign key attribute
     *
     * @param l IdeaTime
     * @throws TorqueException
     */
    public void addIdeaTimeRelatedByDcId2(IdeaTime l) throws TorqueException
    {
        getIdeaTimesRelatedByDcId2().add(l);
        l.setDcRelatedByDcId2((Dc) this);
    }

    /**
     * Method called to associate a IdeaTime object to this object
     * through the IdeaTime foreign key attribute using connection.
     *
     * @param l IdeaTime
     * @throws TorqueException
     */
    public void addIdeaTimeRelatedByDcId2(IdeaTime l, Connection con) throws TorqueException
    {
        getIdeaTimesRelatedByDcId2(con).add(l);
        l.setDcRelatedByDcId2((Dc) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaTimesRelatedByDcId2
     */
    private Criteria lastIdeaTimesRelatedByDcId2Criteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaTimesRelatedByDcId2(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId2()
        throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId2 == null)
        {
            collIdeaTimesRelatedByDcId2 = getIdeaTimesRelatedByDcId2(new Criteria(10));
        }
        return collIdeaTimesRelatedByDcId2;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId2 from storage.
     * If this Dc is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId2(Criteria criteria) throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId2 == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId2 = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.DC_ID2, getId() );
                collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelect(criteria);
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
                criteria.add(IdeaTimePeer.DC_ID2, getId());
                if (!lastIdeaTimesRelatedByDcId2Criteria.equals(criteria))
                {
                    collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelect(criteria);
                }
            }
        }
        lastIdeaTimesRelatedByDcId2Criteria = criteria;

        return collIdeaTimesRelatedByDcId2;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaTimesRelatedByDcId2(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId2(Connection con) throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId2 == null)
        {
            collIdeaTimesRelatedByDcId2 = getIdeaTimesRelatedByDcId2(new Criteria(10), con);
        }
        return collIdeaTimesRelatedByDcId2;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId2 from storage.
     * If this Dc is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaTime> getIdeaTimesRelatedByDcId2(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId2 == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId2 = new ArrayList<IdeaTime>();
            }
            else
            {
                 criteria.add(IdeaTimePeer.DC_ID2, getId());
                 collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelect(criteria, con);
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
                 criteria.add(IdeaTimePeer.DC_ID2, getId());
                 if (!lastIdeaTimesRelatedByDcId2Criteria.equals(criteria))
                 {
                     collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaTimesRelatedByDcId2Criteria = criteria;

         return collIdeaTimesRelatedByDcId2;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId2 from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
     */
    protected List<IdeaTime> getIdeaTimesRelatedByDcId2JoinIdea(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId2 == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId2 = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.DC_ID2, getId());
                collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaTimePeer.DC_ID2, getId());
            if (!lastIdeaTimesRelatedByDcId2Criteria.equals(criteria))
            {
                collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        lastIdeaTimesRelatedByDcId2Criteria = criteria;

        return collIdeaTimesRelatedByDcId2;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related IdeaTimesRelatedByDcId2 from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
     */
    protected List<IdeaTime> getIdeaTimesRelatedByDcId2JoinDcRelatedByDcId(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaTimesRelatedByDcId2 == null)
        {
            if (isNew())
            {
               collIdeaTimesRelatedByDcId2 = new ArrayList<IdeaTime>();
            }
            else
            {
                criteria.add(IdeaTimePeer.DC_ID2, getId());
                collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelectJoinDcRelatedByDcId(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaTimePeer.DC_ID2, getId());
            if (!lastIdeaTimesRelatedByDcId2Criteria.equals(criteria))
            {
                collIdeaTimesRelatedByDcId2 = IdeaTimePeer.doSelectJoinDcRelatedByDcId(criteria);
            }
        }
        lastIdeaTimesRelatedByDcId2Criteria = criteria;

        return collIdeaTimesRelatedByDcId2;
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
        l.setDc((Dc) this);
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
        l.setDc((Dc) this);
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
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related HideaTimes from storage.
     * If this Dc is new, it will return
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
                criteria.add(HideaTimePeer.DC_ID, getId() );
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
                criteria.add(HideaTimePeer.DC_ID, getId());
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
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related HideaTimes from storage.
     * If this Dc is new, it will return
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
                 criteria.add(HideaTimePeer.DC_ID, getId());
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
                 criteria.add(HideaTimePeer.DC_ID, getId());
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
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related HideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
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
                criteria.add(HideaTimePeer.DC_ID, getId());
                collHideaTimes = HideaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(HideaTimePeer.DC_ID, getId());
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
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related HideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
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
                criteria.add(HideaTimePeer.DC_ID, getId());
                collHideaTimes = HideaTimePeer.doSelectJoinDc(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(HideaTimePeer.DC_ID, getId());
            if (!lastHideaTimesCriteria.equals(criteria))
            {
                collHideaTimes = HideaTimePeer.doSelectJoinDc(criteria);
            }
        }
        lastHideaTimesCriteria = criteria;

        return collHideaTimes;
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
        l.setDc((Dc) this);
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
        l.setDc((Dc) this);
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
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     * If this Dc is new, it will return
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
                criteria.add(VhideaTimePeer.DC_ID, getId() );
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
                criteria.add(VhideaTimePeer.DC_ID, getId());
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
     * Otherwise if this Dc has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     * If this Dc is new, it will return
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
                 criteria.add(VhideaTimePeer.DC_ID, getId());
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
                 criteria.add(VhideaTimePeer.DC_ID, getId());
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
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
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
                criteria.add(VhideaTimePeer.DC_ID, getId());
                collVhideaTimes = VhideaTimePeer.doSelectJoinIdea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(VhideaTimePeer.DC_ID, getId());
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
     * Otherwise if this Dc is new, it will return
     * an empty collection; or if this Dc has previously
     * been saved, it will retrieve related VhideaTimes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Dc.
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
                criteria.add(VhideaTimePeer.DC_ID, getId());
                collVhideaTimes = VhideaTimePeer.doSelectJoinDc(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(VhideaTimePeer.DC_ID, getId());
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
            fieldNames.add("TargetDate");
            fieldNames.add("Cpm");
            fieldNames.add("Cpc");
            fieldNames.add("Cpv");
            fieldNames.add("Cpp");
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
        if (name.equals("TargetDate"))
        {
            return getTargetDate();
        }
        if (name.equals("Cpm"))
        {
            return new Integer(getCpm());
        }
        if (name.equals("Cpc"))
        {
            return new Integer(getCpc());
        }
        if (name.equals("Cpv"))
        {
            return new Integer(getCpv());
        }
        if (name.equals("Cpp"))
        {
            return new Integer(getCpp());
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
        if (name.equals("TargetDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTargetDate((Date) value);
            return true;
        }
        if (name.equals("Cpm"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpm(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpc"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpc(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpv"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpv(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpp"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpp(((Integer) value).intValue());
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
        if (name.equals(DcPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(DcPeer.TARGET_DATE))
        {
            return getTargetDate();
        }
        if (name.equals(DcPeer.CPM))
        {
            return new Integer(getCpm());
        }
        if (name.equals(DcPeer.CPC))
        {
            return new Integer(getCpc());
        }
        if (name.equals(DcPeer.CPV))
        {
            return new Integer(getCpv());
        }
        if (name.equals(DcPeer.CPP))
        {
            return new Integer(getCpp());
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
      if (DcPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (DcPeer.TARGET_DATE.equals(name))
        {
            return setByName("TargetDate", value);
        }
      if (DcPeer.CPM.equals(name))
        {
            return setByName("Cpm", value);
        }
      if (DcPeer.CPC.equals(name))
        {
            return setByName("Cpc", value);
        }
      if (DcPeer.CPV.equals(name))
        {
            return setByName("Cpv", value);
        }
      if (DcPeer.CPP.equals(name))
        {
            return setByName("Cpp", value);
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
            return getTargetDate();
        }
        if (pos == 2)
        {
            return new Integer(getCpm());
        }
        if (pos == 3)
        {
            return new Integer(getCpc());
        }
        if (pos == 4)
        {
            return new Integer(getCpv());
        }
        if (pos == 5)
        {
            return new Integer(getCpp());
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
            return setByName("TargetDate", value);
        }
    if (position == 2)
        {
            return setByName("Cpm", value);
        }
    if (position == 3)
        {
            return setByName("Cpc", value);
        }
    if (position == 4)
        {
            return setByName("Cpv", value);
        }
    if (position == 5)
        {
            return setByName("Cpp", value);
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
        save(DcPeer.DATABASE_NAME);
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
                    DcPeer.doInsert((Dc) this, con);
                    setNew(false);
                }
                else
                {
                    DcPeer.doUpdate((Dc) this, con);
                }
            }


            if (collIdeaTimesRelatedByDcId != null)
            {
                for (int i = 0; i < collIdeaTimesRelatedByDcId.size(); i++)
                {
                    ((IdeaTime) collIdeaTimesRelatedByDcId.get(i)).save(con);
                }
            }

            if (collIdeaTimesRelatedByDcId2 != null)
            {
                for (int i = 0; i < collIdeaTimesRelatedByDcId2.size(); i++)
                {
                    ((IdeaTime) collIdeaTimesRelatedByDcId2.get(i)).save(con);
                }
            }

            if (collHideaTimes != null)
            {
                for (int i = 0; i < collHideaTimes.size(); i++)
                {
                    ((HideaTime) collHideaTimes.get(i)).save(con);
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
    public Dc copy() throws TorqueException
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
    public Dc copy(Connection con) throws TorqueException
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
    public Dc copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Dc(), deepcopy);
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
    public Dc copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Dc(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Dc copyInto(Dc copyObj) throws TorqueException
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
    protected Dc copyInto(Dc copyObj, Connection con) throws TorqueException
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
    protected Dc copyInto(Dc copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setTargetDate(targetDate);
        copyObj.setCpm(cpm);
        copyObj.setCpc(cpc);
        copyObj.setCpv(cpv);
        copyObj.setCpp(cpp);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<IdeaTime> vIdeaTimesRelatedByDcId = getIdeaTimesRelatedByDcId();
        if (vIdeaTimesRelatedByDcId != null)
        {
            for (int i = 0; i < vIdeaTimesRelatedByDcId.size(); i++)
            {
                IdeaTime obj =  vIdeaTimesRelatedByDcId.get(i);
                copyObj.addIdeaTimeRelatedByDcId(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaTimesRelatedByDcId = null;
        }


        List<IdeaTime> vIdeaTimesRelatedByDcId2 = getIdeaTimesRelatedByDcId2();
        if (vIdeaTimesRelatedByDcId2 != null)
        {
            for (int i = 0; i < vIdeaTimesRelatedByDcId2.size(); i++)
            {
                IdeaTime obj =  vIdeaTimesRelatedByDcId2.get(i);
                copyObj.addIdeaTimeRelatedByDcId2(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaTimesRelatedByDcId2 = null;
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
    protected Dc copyInto(Dc copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setTargetDate(targetDate);
        copyObj.setCpm(cpm);
        copyObj.setCpc(cpc);
        copyObj.setCpv(cpv);
        copyObj.setCpp(cpp);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<IdeaTime> vIdeaTimesRelatedByDcId = getIdeaTimesRelatedByDcId(con);
        if (vIdeaTimesRelatedByDcId != null)
        {
            for (int i = 0; i < vIdeaTimesRelatedByDcId.size(); i++)
            {
                IdeaTime obj =  vIdeaTimesRelatedByDcId.get(i);
                copyObj.addIdeaTimeRelatedByDcId(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaTimesRelatedByDcId = null;
        }


        List<IdeaTime> vIdeaTimesRelatedByDcId2 = getIdeaTimesRelatedByDcId2(con);
        if (vIdeaTimesRelatedByDcId2 != null)
        {
            for (int i = 0; i < vIdeaTimesRelatedByDcId2.size(); i++)
            {
                IdeaTime obj =  vIdeaTimesRelatedByDcId2.get(i);
                copyObj.addIdeaTimeRelatedByDcId2(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaTimesRelatedByDcId2 = null;
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
    public DcPeer getPeer()
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
        return DcPeer.getTableMap();
    }

  
    /**
     * Creates a DcBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a DcBean with the contents of this object
     */
    public DcBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a DcBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a DcBean with the contents of this object
     */
    public DcBean getBean(IdentityMap createdBeans)
    {
        DcBean result = (DcBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new DcBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setTargetDate(getTargetDate());
        result.setCpm(getCpm());
        result.setCpc(getCpc());
        result.setCpv(getCpv());
        result.setCpp(getCpp());



        if (collIdeaTimesRelatedByDcId != null)
        {
            List<IdeaTimeBean> relatedBeans = new ArrayList<IdeaTimeBean>(collIdeaTimesRelatedByDcId.size());
            for (Iterator<IdeaTime> collIdeaTimesRelatedByDcIdIt = collIdeaTimesRelatedByDcId.iterator(); collIdeaTimesRelatedByDcIdIt.hasNext(); )
            {
                IdeaTime related = (IdeaTime) collIdeaTimesRelatedByDcIdIt.next();
                IdeaTimeBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaTimeBeansRelatedByDcId(relatedBeans);
        }


        if (collIdeaTimesRelatedByDcId2 != null)
        {
            List<IdeaTimeBean> relatedBeans = new ArrayList<IdeaTimeBean>(collIdeaTimesRelatedByDcId2.size());
            for (Iterator<IdeaTime> collIdeaTimesRelatedByDcId2It = collIdeaTimesRelatedByDcId2.iterator(); collIdeaTimesRelatedByDcId2It.hasNext(); )
            {
                IdeaTime related = (IdeaTime) collIdeaTimesRelatedByDcId2It.next();
                IdeaTimeBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaTimeBeansRelatedByDcId2(relatedBeans);
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
     * Creates an instance of Dc with the contents
     * of a DcBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the DcBean which contents are used to create
     *        the resulting class
     * @return an instance of Dc with the contents of bean
     */
    public static Dc createDc(DcBean bean)
        throws TorqueException
    {
        return createDc(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Dc with the contents
     * of a DcBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the DcBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Dc with the contents of bean
     */

    public static Dc createDc(DcBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Dc result = (Dc) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Dc();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setTargetDate(bean.getTargetDate());
        result.setCpm(bean.getCpm());
        result.setCpc(bean.getCpc());
        result.setCpv(bean.getCpv());
        result.setCpp(bean.getCpp());



        {
            List<IdeaTimeBean> relatedBeans = bean.getIdeaTimeBeansRelatedByDcId();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaTimeBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaTimeBean relatedBean =  relatedBeansIt.next();
                    IdeaTime related = IdeaTime.createIdeaTime(relatedBean, createdObjects);
                    result.addIdeaTimeRelatedByDcIdFromBean(related);
                }
            }
        }


        {
            List<IdeaTimeBean> relatedBeans = bean.getIdeaTimeBeansRelatedByDcId2();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaTimeBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaTimeBean relatedBean =  relatedBeansIt.next();
                    IdeaTime related = IdeaTime.createIdeaTime(relatedBean, createdObjects);
                    result.addIdeaTimeRelatedByDcId2FromBean(related);
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
     * Method called to associate a IdeaTime object to this object.
     * through the IdeaTime foreign key attribute
     *
     * @param toAdd IdeaTime
     */
    protected void addIdeaTimeRelatedByDcIdFromBean(IdeaTime toAdd)
    {
        initIdeaTimesRelatedByDcId();
        collIdeaTimesRelatedByDcId.add(toAdd);
    }


    /**
     * Method called to associate a IdeaTime object to this object.
     * through the IdeaTime foreign key attribute
     *
     * @param toAdd IdeaTime
     */
    protected void addIdeaTimeRelatedByDcId2FromBean(IdeaTime toAdd)
    {
        initIdeaTimesRelatedByDcId2();
        collIdeaTimesRelatedByDcId2.add(toAdd);
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
        str.append("Dc:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("TargetDate = ")
           .append(getTargetDate())
           .append("\n");
        str.append("Cpm = ")
           .append(getCpm())
           .append("\n");
        str.append("Cpc = ")
           .append(getCpc())
           .append("\n");
        str.append("Cpv = ")
           .append(getCpv())
           .append("\n");
        str.append("Cpp = ")
           .append(getCpp())
           .append("\n");
        return(str.toString());
    }
}
