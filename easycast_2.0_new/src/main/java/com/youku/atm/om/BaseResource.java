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
import com.youku.atm.om.bean.ResourceBean;

import com.youku.atm.om.bean.AdlenRangeBean;
import com.youku.atm.om.bean.OverflowRangeBean;
import com.youku.atm.om.bean.ProtectBean;
import com.youku.atm.om.bean.ResourceDirectionBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Resource
 */
public abstract class BaseResource extends BaseObject
{
    /** The Peer class */
    private static final ResourcePeer peer =
        new ResourcePeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the type field */
    private int type;

    /** The value for the level field */
    private int level;


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



        // update associated AdlenRange
        if (collAdlenRanges != null)
        {
            for (int i = 0; i < collAdlenRanges.size(); i++)
            {
                ((AdlenRange) collAdlenRanges.get(i))
                        .setResourceId(v);
            }
        }

        // update associated OverflowRange
        if (collOverflowRanges != null)
        {
            for (int i = 0; i < collOverflowRanges.size(); i++)
            {
                ((OverflowRange) collOverflowRanges.get(i))
                        .setResourceId(v);
            }
        }

        // update associated Protect
        if (collProtects != null)
        {
            for (int i = 0; i < collProtects.size(); i++)
            {
                ((Protect) collProtects.get(i))
                        .setResourceId(v);
            }
        }

        // update associated ResourceDirection
        if (collResourceDirections != null)
        {
            for (int i = 0; i < collResourceDirections.size(); i++)
            {
                ((ResourceDirection) collResourceDirections.get(i))
                        .setResourceId(v);
            }
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
     * Get the Type
     *
     * @return int
     */
    public int getType()
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

        if (this.type != v)
        {
            this.type = v;
            setModified(true);
        }


    }

    /**
     * Get the Level
     *
     * @return int
     */
    public int getLevel()
    {
        return level;
    }


    /**
     * Set the value of Level
     *
     * @param v new value
     */
    public void setLevel(int v) 
    {

        if (this.level != v)
        {
            this.level = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collAdlenRanges
     */
    protected List<AdlenRange> collAdlenRanges;

    /**
     * Temporary storage of collAdlenRanges to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initAdlenRanges()
    {
        if (collAdlenRanges == null)
        {
            collAdlenRanges = new ArrayList<AdlenRange>();
        }
    }


    /**
     * Method called to associate a AdlenRange object to this object
     * through the AdlenRange foreign key attribute
     *
     * @param l AdlenRange
     * @throws TorqueException
     */
    public void addAdlenRange(AdlenRange l) throws TorqueException
    {
        getAdlenRanges().add(l);
        l.setResource((Resource) this);
    }

    /**
     * Method called to associate a AdlenRange object to this object
     * through the AdlenRange foreign key attribute using connection.
     *
     * @param l AdlenRange
     * @throws TorqueException
     */
    public void addAdlenRange(AdlenRange l, Connection con) throws TorqueException
    {
        getAdlenRanges(con).add(l);
        l.setResource((Resource) this);
    }

    /**
     * The criteria used to select the current contents of collAdlenRanges
     */
    private Criteria lastAdlenRangesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getAdlenRanges(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<AdlenRange> getAdlenRanges()
        throws TorqueException
    {
        if (collAdlenRanges == null)
        {
            collAdlenRanges = getAdlenRanges(new Criteria(10));
        }
        return collAdlenRanges;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related AdlenRanges from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<AdlenRange> getAdlenRanges(Criteria criteria) throws TorqueException
    {
        if (collAdlenRanges == null)
        {
            if (isNew())
            {
               collAdlenRanges = new ArrayList<AdlenRange>();
            }
            else
            {
                criteria.add(AdlenRangePeer.RESOURCE_ID, getId() );
                collAdlenRanges = AdlenRangePeer.doSelect(criteria);
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
                criteria.add(AdlenRangePeer.RESOURCE_ID, getId());
                if (!lastAdlenRangesCriteria.equals(criteria))
                {
                    collAdlenRanges = AdlenRangePeer.doSelect(criteria);
                }
            }
        }
        lastAdlenRangesCriteria = criteria;

        return collAdlenRanges;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getAdlenRanges(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<AdlenRange> getAdlenRanges(Connection con) throws TorqueException
    {
        if (collAdlenRanges == null)
        {
            collAdlenRanges = getAdlenRanges(new Criteria(10), con);
        }
        return collAdlenRanges;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related AdlenRanges from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<AdlenRange> getAdlenRanges(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collAdlenRanges == null)
        {
            if (isNew())
            {
               collAdlenRanges = new ArrayList<AdlenRange>();
            }
            else
            {
                 criteria.add(AdlenRangePeer.RESOURCE_ID, getId());
                 collAdlenRanges = AdlenRangePeer.doSelect(criteria, con);
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
                 criteria.add(AdlenRangePeer.RESOURCE_ID, getId());
                 if (!lastAdlenRangesCriteria.equals(criteria))
                 {
                     collAdlenRanges = AdlenRangePeer.doSelect(criteria, con);
                 }
             }
         }
         lastAdlenRangesCriteria = criteria;

         return collAdlenRanges;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource is new, it will return
     * an empty collection; or if this Resource has previously
     * been saved, it will retrieve related AdlenRanges from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Resource.
     */
    protected List<AdlenRange> getAdlenRangesJoinResource(Criteria criteria)
        throws TorqueException
    {
        if (collAdlenRanges == null)
        {
            if (isNew())
            {
               collAdlenRanges = new ArrayList<AdlenRange>();
            }
            else
            {
                criteria.add(AdlenRangePeer.RESOURCE_ID, getId());
                collAdlenRanges = AdlenRangePeer.doSelectJoinResource(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(AdlenRangePeer.RESOURCE_ID, getId());
            if (!lastAdlenRangesCriteria.equals(criteria))
            {
                collAdlenRanges = AdlenRangePeer.doSelectJoinResource(criteria);
            }
        }
        lastAdlenRangesCriteria = criteria;

        return collAdlenRanges;
    }





    /**
     * Collection to store aggregation of collOverflowRanges
     */
    protected List<OverflowRange> collOverflowRanges;

    /**
     * Temporary storage of collOverflowRanges to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initOverflowRanges()
    {
        if (collOverflowRanges == null)
        {
            collOverflowRanges = new ArrayList<OverflowRange>();
        }
    }


    /**
     * Method called to associate a OverflowRange object to this object
     * through the OverflowRange foreign key attribute
     *
     * @param l OverflowRange
     * @throws TorqueException
     */
    public void addOverflowRange(OverflowRange l) throws TorqueException
    {
        getOverflowRanges().add(l);
        l.setResource((Resource) this);
    }

    /**
     * Method called to associate a OverflowRange object to this object
     * through the OverflowRange foreign key attribute using connection.
     *
     * @param l OverflowRange
     * @throws TorqueException
     */
    public void addOverflowRange(OverflowRange l, Connection con) throws TorqueException
    {
        getOverflowRanges(con).add(l);
        l.setResource((Resource) this);
    }

    /**
     * The criteria used to select the current contents of collOverflowRanges
     */
    private Criteria lastOverflowRangesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getOverflowRanges(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<OverflowRange> getOverflowRanges()
        throws TorqueException
    {
        if (collOverflowRanges == null)
        {
            collOverflowRanges = getOverflowRanges(new Criteria(10));
        }
        return collOverflowRanges;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related OverflowRanges from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<OverflowRange> getOverflowRanges(Criteria criteria) throws TorqueException
    {
        if (collOverflowRanges == null)
        {
            if (isNew())
            {
               collOverflowRanges = new ArrayList<OverflowRange>();
            }
            else
            {
                criteria.add(OverflowRangePeer.RESOURCE_ID, getId() );
                collOverflowRanges = OverflowRangePeer.doSelect(criteria);
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
                criteria.add(OverflowRangePeer.RESOURCE_ID, getId());
                if (!lastOverflowRangesCriteria.equals(criteria))
                {
                    collOverflowRanges = OverflowRangePeer.doSelect(criteria);
                }
            }
        }
        lastOverflowRangesCriteria = criteria;

        return collOverflowRanges;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getOverflowRanges(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<OverflowRange> getOverflowRanges(Connection con) throws TorqueException
    {
        if (collOverflowRanges == null)
        {
            collOverflowRanges = getOverflowRanges(new Criteria(10), con);
        }
        return collOverflowRanges;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related OverflowRanges from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<OverflowRange> getOverflowRanges(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collOverflowRanges == null)
        {
            if (isNew())
            {
               collOverflowRanges = new ArrayList<OverflowRange>();
            }
            else
            {
                 criteria.add(OverflowRangePeer.RESOURCE_ID, getId());
                 collOverflowRanges = OverflowRangePeer.doSelect(criteria, con);
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
                 criteria.add(OverflowRangePeer.RESOURCE_ID, getId());
                 if (!lastOverflowRangesCriteria.equals(criteria))
                 {
                     collOverflowRanges = OverflowRangePeer.doSelect(criteria, con);
                 }
             }
         }
         lastOverflowRangesCriteria = criteria;

         return collOverflowRanges;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource is new, it will return
     * an empty collection; or if this Resource has previously
     * been saved, it will retrieve related OverflowRanges from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Resource.
     */
    protected List<OverflowRange> getOverflowRangesJoinResource(Criteria criteria)
        throws TorqueException
    {
        if (collOverflowRanges == null)
        {
            if (isNew())
            {
               collOverflowRanges = new ArrayList<OverflowRange>();
            }
            else
            {
                criteria.add(OverflowRangePeer.RESOURCE_ID, getId());
                collOverflowRanges = OverflowRangePeer.doSelectJoinResource(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(OverflowRangePeer.RESOURCE_ID, getId());
            if (!lastOverflowRangesCriteria.equals(criteria))
            {
                collOverflowRanges = OverflowRangePeer.doSelectJoinResource(criteria);
            }
        }
        lastOverflowRangesCriteria = criteria;

        return collOverflowRanges;
    }





    /**
     * Collection to store aggregation of collProtects
     */
    protected List<Protect> collProtects;

    /**
     * Temporary storage of collProtects to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initProtects()
    {
        if (collProtects == null)
        {
            collProtects = new ArrayList<Protect>();
        }
    }


    /**
     * Method called to associate a Protect object to this object
     * through the Protect foreign key attribute
     *
     * @param l Protect
     * @throws TorqueException
     */
    public void addProtect(Protect l) throws TorqueException
    {
        getProtects().add(l);
        l.setResource((Resource) this);
    }

    /**
     * Method called to associate a Protect object to this object
     * through the Protect foreign key attribute using connection.
     *
     * @param l Protect
     * @throws TorqueException
     */
    public void addProtect(Protect l, Connection con) throws TorqueException
    {
        getProtects(con).add(l);
        l.setResource((Resource) this);
    }

    /**
     * The criteria used to select the current contents of collProtects
     */
    private Criteria lastProtectsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getProtects(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<Protect> getProtects()
        throws TorqueException
    {
        if (collProtects == null)
        {
            collProtects = getProtects(new Criteria(10));
        }
        return collProtects;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related Protects from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<Protect> getProtects(Criteria criteria) throws TorqueException
    {
        if (collProtects == null)
        {
            if (isNew())
            {
               collProtects = new ArrayList<Protect>();
            }
            else
            {
                criteria.add(ProtectPeer.RESOURCE_ID, getId() );
                collProtects = ProtectPeer.doSelect(criteria);
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
                criteria.add(ProtectPeer.RESOURCE_ID, getId());
                if (!lastProtectsCriteria.equals(criteria))
                {
                    collProtects = ProtectPeer.doSelect(criteria);
                }
            }
        }
        lastProtectsCriteria = criteria;

        return collProtects;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getProtects(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<Protect> getProtects(Connection con) throws TorqueException
    {
        if (collProtects == null)
        {
            collProtects = getProtects(new Criteria(10), con);
        }
        return collProtects;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related Protects from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<Protect> getProtects(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collProtects == null)
        {
            if (isNew())
            {
               collProtects = new ArrayList<Protect>();
            }
            else
            {
                 criteria.add(ProtectPeer.RESOURCE_ID, getId());
                 collProtects = ProtectPeer.doSelect(criteria, con);
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
                 criteria.add(ProtectPeer.RESOURCE_ID, getId());
                 if (!lastProtectsCriteria.equals(criteria))
                 {
                     collProtects = ProtectPeer.doSelect(criteria, con);
                 }
             }
         }
         lastProtectsCriteria = criteria;

         return collProtects;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource is new, it will return
     * an empty collection; or if this Resource has previously
     * been saved, it will retrieve related Protects from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Resource.
     */
    protected List<Protect> getProtectsJoinResource(Criteria criteria)
        throws TorqueException
    {
        if (collProtects == null)
        {
            if (isNew())
            {
               collProtects = new ArrayList<Protect>();
            }
            else
            {
                criteria.add(ProtectPeer.RESOURCE_ID, getId());
                collProtects = ProtectPeer.doSelectJoinResource(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(ProtectPeer.RESOURCE_ID, getId());
            if (!lastProtectsCriteria.equals(criteria))
            {
                collProtects = ProtectPeer.doSelectJoinResource(criteria);
            }
        }
        lastProtectsCriteria = criteria;

        return collProtects;
    }





    /**
     * Collection to store aggregation of collResourceDirections
     */
    protected List<ResourceDirection> collResourceDirections;

    /**
     * Temporary storage of collResourceDirections to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initResourceDirections()
    {
        if (collResourceDirections == null)
        {
            collResourceDirections = new ArrayList<ResourceDirection>();
        }
    }


    /**
     * Method called to associate a ResourceDirection object to this object
     * through the ResourceDirection foreign key attribute
     *
     * @param l ResourceDirection
     * @throws TorqueException
     */
    public void addResourceDirection(ResourceDirection l) throws TorqueException
    {
        getResourceDirections().add(l);
        l.setResource((Resource) this);
    }

    /**
     * Method called to associate a ResourceDirection object to this object
     * through the ResourceDirection foreign key attribute using connection.
     *
     * @param l ResourceDirection
     * @throws TorqueException
     */
    public void addResourceDirection(ResourceDirection l, Connection con) throws TorqueException
    {
        getResourceDirections(con).add(l);
        l.setResource((Resource) this);
    }

    /**
     * The criteria used to select the current contents of collResourceDirections
     */
    private Criteria lastResourceDirectionsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getResourceDirections(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<ResourceDirection> getResourceDirections()
        throws TorqueException
    {
        if (collResourceDirections == null)
        {
            collResourceDirections = getResourceDirections(new Criteria(10));
        }
        return collResourceDirections;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related ResourceDirections from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<ResourceDirection> getResourceDirections(Criteria criteria) throws TorqueException
    {
        if (collResourceDirections == null)
        {
            if (isNew())
            {
               collResourceDirections = new ArrayList<ResourceDirection>();
            }
            else
            {
                criteria.add(ResourceDirectionPeer.RESOURCE_ID, getId() );
                collResourceDirections = ResourceDirectionPeer.doSelect(criteria);
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
                criteria.add(ResourceDirectionPeer.RESOURCE_ID, getId());
                if (!lastResourceDirectionsCriteria.equals(criteria))
                {
                    collResourceDirections = ResourceDirectionPeer.doSelect(criteria);
                }
            }
        }
        lastResourceDirectionsCriteria = criteria;

        return collResourceDirections;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getResourceDirections(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<ResourceDirection> getResourceDirections(Connection con) throws TorqueException
    {
        if (collResourceDirections == null)
        {
            collResourceDirections = getResourceDirections(new Criteria(10), con);
        }
        return collResourceDirections;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource has previously
     * been saved, it will retrieve related ResourceDirections from storage.
     * If this Resource is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<ResourceDirection> getResourceDirections(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collResourceDirections == null)
        {
            if (isNew())
            {
               collResourceDirections = new ArrayList<ResourceDirection>();
            }
            else
            {
                 criteria.add(ResourceDirectionPeer.RESOURCE_ID, getId());
                 collResourceDirections = ResourceDirectionPeer.doSelect(criteria, con);
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
                 criteria.add(ResourceDirectionPeer.RESOURCE_ID, getId());
                 if (!lastResourceDirectionsCriteria.equals(criteria))
                 {
                     collResourceDirections = ResourceDirectionPeer.doSelect(criteria, con);
                 }
             }
         }
         lastResourceDirectionsCriteria = criteria;

         return collResourceDirections;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Resource is new, it will return
     * an empty collection; or if this Resource has previously
     * been saved, it will retrieve related ResourceDirections from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Resource.
     */
    protected List<ResourceDirection> getResourceDirectionsJoinResource(Criteria criteria)
        throws TorqueException
    {
        if (collResourceDirections == null)
        {
            if (isNew())
            {
               collResourceDirections = new ArrayList<ResourceDirection>();
            }
            else
            {
                criteria.add(ResourceDirectionPeer.RESOURCE_ID, getId());
                collResourceDirections = ResourceDirectionPeer.doSelectJoinResource(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(ResourceDirectionPeer.RESOURCE_ID, getId());
            if (!lastResourceDirectionsCriteria.equals(criteria))
            {
                collResourceDirections = ResourceDirectionPeer.doSelectJoinResource(criteria);
            }
        }
        lastResourceDirectionsCriteria = criteria;

        return collResourceDirections;
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
            fieldNames.add("Name");
            fieldNames.add("Type");
            fieldNames.add("Level");
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
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("Type"))
        {
            return new Integer(getType());
        }
        if (name.equals("Level"))
        {
            return new Integer(getLevel());
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
        if (name.equals("Type"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Level"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setLevel(((Integer) value).intValue());
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
        if (name.equals(ResourcePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(ResourcePeer.NAME))
        {
            return getName();
        }
        if (name.equals(ResourcePeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(ResourcePeer.LEVEL))
        {
            return new Integer(getLevel());
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
      if (ResourcePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (ResourcePeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (ResourcePeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (ResourcePeer.LEVEL.equals(name))
        {
            return setByName("Level", value);
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
            return getName();
        }
        if (pos == 2)
        {
            return new Integer(getType());
        }
        if (pos == 3)
        {
            return new Integer(getLevel());
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
            return setByName("Name", value);
        }
    if (position == 2)
        {
            return setByName("Type", value);
        }
    if (position == 3)
        {
            return setByName("Level", value);
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
        save(ResourcePeer.DATABASE_NAME);
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
                    ResourcePeer.doInsert((Resource) this, con);
                    setNew(false);
                }
                else
                {
                    ResourcePeer.doUpdate((Resource) this, con);
                }
            }


            if (collAdlenRanges != null)
            {
                for (int i = 0; i < collAdlenRanges.size(); i++)
                {
                    ((AdlenRange) collAdlenRanges.get(i)).save(con);
                }
            }

            if (collOverflowRanges != null)
            {
                for (int i = 0; i < collOverflowRanges.size(); i++)
                {
                    ((OverflowRange) collOverflowRanges.get(i)).save(con);
                }
            }

            if (collProtects != null)
            {
                for (int i = 0; i < collProtects.size(); i++)
                {
                    ((Protect) collProtects.get(i)).save(con);
                }
            }

            if (collResourceDirections != null)
            {
                for (int i = 0; i < collResourceDirections.size(); i++)
                {
                    ((ResourceDirection) collResourceDirections.get(i)).save(con);
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
    public Resource copy() throws TorqueException
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
    public Resource copy(Connection con) throws TorqueException
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
    public Resource copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Resource(), deepcopy);
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
    public Resource copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Resource(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Resource copyInto(Resource copyObj) throws TorqueException
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
    protected Resource copyInto(Resource copyObj, Connection con) throws TorqueException
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
    protected Resource copyInto(Resource copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setType(type);
        copyObj.setLevel(level);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<AdlenRange> vAdlenRanges = getAdlenRanges();
        if (vAdlenRanges != null)
        {
            for (int i = 0; i < vAdlenRanges.size(); i++)
            {
                AdlenRange obj =  vAdlenRanges.get(i);
                copyObj.addAdlenRange(obj.copy());
            }
        }
        else
        {
            copyObj.collAdlenRanges = null;
        }


        List<OverflowRange> vOverflowRanges = getOverflowRanges();
        if (vOverflowRanges != null)
        {
            for (int i = 0; i < vOverflowRanges.size(); i++)
            {
                OverflowRange obj =  vOverflowRanges.get(i);
                copyObj.addOverflowRange(obj.copy());
            }
        }
        else
        {
            copyObj.collOverflowRanges = null;
        }


        List<Protect> vProtects = getProtects();
        if (vProtects != null)
        {
            for (int i = 0; i < vProtects.size(); i++)
            {
                Protect obj =  vProtects.get(i);
                copyObj.addProtect(obj.copy());
            }
        }
        else
        {
            copyObj.collProtects = null;
        }


        List<ResourceDirection> vResourceDirections = getResourceDirections();
        if (vResourceDirections != null)
        {
            for (int i = 0; i < vResourceDirections.size(); i++)
            {
                ResourceDirection obj =  vResourceDirections.get(i);
                copyObj.addResourceDirection(obj.copy());
            }
        }
        else
        {
            copyObj.collResourceDirections = null;
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
    protected Resource copyInto(Resource copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setType(type);
        copyObj.setLevel(level);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<AdlenRange> vAdlenRanges = getAdlenRanges(con);
        if (vAdlenRanges != null)
        {
            for (int i = 0; i < vAdlenRanges.size(); i++)
            {
                AdlenRange obj =  vAdlenRanges.get(i);
                copyObj.addAdlenRange(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collAdlenRanges = null;
        }


        List<OverflowRange> vOverflowRanges = getOverflowRanges(con);
        if (vOverflowRanges != null)
        {
            for (int i = 0; i < vOverflowRanges.size(); i++)
            {
                OverflowRange obj =  vOverflowRanges.get(i);
                copyObj.addOverflowRange(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collOverflowRanges = null;
        }


        List<Protect> vProtects = getProtects(con);
        if (vProtects != null)
        {
            for (int i = 0; i < vProtects.size(); i++)
            {
                Protect obj =  vProtects.get(i);
                copyObj.addProtect(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collProtects = null;
        }


        List<ResourceDirection> vResourceDirections = getResourceDirections(con);
        if (vResourceDirections != null)
        {
            for (int i = 0; i < vResourceDirections.size(); i++)
            {
                ResourceDirection obj =  vResourceDirections.get(i);
                copyObj.addResourceDirection(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collResourceDirections = null;
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
    public ResourcePeer getPeer()
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
        return ResourcePeer.getTableMap();
    }

  
    /**
     * Creates a ResourceBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a ResourceBean with the contents of this object
     */
    public ResourceBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a ResourceBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a ResourceBean with the contents of this object
     */
    public ResourceBean getBean(IdentityMap createdBeans)
    {
        ResourceBean result = (ResourceBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new ResourceBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setType(getType());
        result.setLevel(getLevel());



        if (collAdlenRanges != null)
        {
            List<AdlenRangeBean> relatedBeans = new ArrayList<AdlenRangeBean>(collAdlenRanges.size());
            for (Iterator<AdlenRange> collAdlenRangesIt = collAdlenRanges.iterator(); collAdlenRangesIt.hasNext(); )
            {
                AdlenRange related = (AdlenRange) collAdlenRangesIt.next();
                AdlenRangeBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setAdlenRangeBeans(relatedBeans);
        }


        if (collOverflowRanges != null)
        {
            List<OverflowRangeBean> relatedBeans = new ArrayList<OverflowRangeBean>(collOverflowRanges.size());
            for (Iterator<OverflowRange> collOverflowRangesIt = collOverflowRanges.iterator(); collOverflowRangesIt.hasNext(); )
            {
                OverflowRange related = (OverflowRange) collOverflowRangesIt.next();
                OverflowRangeBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setOverflowRangeBeans(relatedBeans);
        }


        if (collProtects != null)
        {
            List<ProtectBean> relatedBeans = new ArrayList<ProtectBean>(collProtects.size());
            for (Iterator<Protect> collProtectsIt = collProtects.iterator(); collProtectsIt.hasNext(); )
            {
                Protect related = (Protect) collProtectsIt.next();
                ProtectBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setProtectBeans(relatedBeans);
        }


        if (collResourceDirections != null)
        {
            List<ResourceDirectionBean> relatedBeans = new ArrayList<ResourceDirectionBean>(collResourceDirections.size());
            for (Iterator<ResourceDirection> collResourceDirectionsIt = collResourceDirections.iterator(); collResourceDirectionsIt.hasNext(); )
            {
                ResourceDirection related = (ResourceDirection) collResourceDirectionsIt.next();
                ResourceDirectionBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setResourceDirectionBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Resource with the contents
     * of a ResourceBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the ResourceBean which contents are used to create
     *        the resulting class
     * @return an instance of Resource with the contents of bean
     */
    public static Resource createResource(ResourceBean bean)
        throws TorqueException
    {
        return createResource(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Resource with the contents
     * of a ResourceBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the ResourceBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Resource with the contents of bean
     */

    public static Resource createResource(ResourceBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Resource result = (Resource) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Resource();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setType(bean.getType());
        result.setLevel(bean.getLevel());



        {
            List<AdlenRangeBean> relatedBeans = bean.getAdlenRangeBeans();
            if (relatedBeans != null)
            {
                for (Iterator<AdlenRangeBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    AdlenRangeBean relatedBean =  relatedBeansIt.next();
                    AdlenRange related = AdlenRange.createAdlenRange(relatedBean, createdObjects);
                    result.addAdlenRangeFromBean(related);
                }
            }
        }


        {
            List<OverflowRangeBean> relatedBeans = bean.getOverflowRangeBeans();
            if (relatedBeans != null)
            {
                for (Iterator<OverflowRangeBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    OverflowRangeBean relatedBean =  relatedBeansIt.next();
                    OverflowRange related = OverflowRange.createOverflowRange(relatedBean, createdObjects);
                    result.addOverflowRangeFromBean(related);
                }
            }
        }


        {
            List<ProtectBean> relatedBeans = bean.getProtectBeans();
            if (relatedBeans != null)
            {
                for (Iterator<ProtectBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    ProtectBean relatedBean =  relatedBeansIt.next();
                    Protect related = Protect.createProtect(relatedBean, createdObjects);
                    result.addProtectFromBean(related);
                }
            }
        }


        {
            List<ResourceDirectionBean> relatedBeans = bean.getResourceDirectionBeans();
            if (relatedBeans != null)
            {
                for (Iterator<ResourceDirectionBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    ResourceDirectionBean relatedBean =  relatedBeansIt.next();
                    ResourceDirection related = ResourceDirection.createResourceDirection(relatedBean, createdObjects);
                    result.addResourceDirectionFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a AdlenRange object to this object.
     * through the AdlenRange foreign key attribute
     *
     * @param toAdd AdlenRange
     */
    protected void addAdlenRangeFromBean(AdlenRange toAdd)
    {
        initAdlenRanges();
        collAdlenRanges.add(toAdd);
    }


    /**
     * Method called to associate a OverflowRange object to this object.
     * through the OverflowRange foreign key attribute
     *
     * @param toAdd OverflowRange
     */
    protected void addOverflowRangeFromBean(OverflowRange toAdd)
    {
        initOverflowRanges();
        collOverflowRanges.add(toAdd);
    }


    /**
     * Method called to associate a Protect object to this object.
     * through the Protect foreign key attribute
     *
     * @param toAdd Protect
     */
    protected void addProtectFromBean(Protect toAdd)
    {
        initProtects();
        collProtects.add(toAdd);
    }


    /**
     * Method called to associate a ResourceDirection object to this object.
     * through the ResourceDirection foreign key attribute
     *
     * @param toAdd ResourceDirection
     */
    protected void addResourceDirectionFromBean(ResourceDirection toAdd)
    {
        initResourceDirections();
        collResourceDirections.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Resource:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("Level = ")
           .append(getLevel())
           .append("\n");
        return(str.toString());
    }
}
