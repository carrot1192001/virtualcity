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
import com.youku.atm.om.bean.AdOrderBean;

import com.youku.atm.om.bean.AdCastBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to AdOrder
 */
public abstract class BaseAdOrder extends BaseObject
{
    /** The Peer class */
    private static final AdOrderPeer peer =
        new AdOrderPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the customId field */
    private int customId;

    /** The value for the customName field */
    private String customName;

    /** The value for the type field */
    private int type;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the status field */
    private int status = 1;

    /** The value for the industryId field */
    private int industryId;

    /** The value for the subIndustryId field */
    private int subIndustryId;

    /** The value for the categoryId field */
    private int categoryId;

    /** The value for the marketingType field */
    private int marketingType = 0;


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



        // update associated AdCast
        if (collAdCasts != null)
        {
            for (int i = 0; i < collAdCasts.size(); i++)
            {
                ((AdCast) collAdCasts.get(i))
                        .setOrderId(v);
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
     * Get the CustomId
     *
     * @return int
     */
    public int getCustomId()
    {
        return customId;
    }


    /**
     * Set the value of CustomId
     *
     * @param v new value
     */
    public void setCustomId(int v) 
    {

        if (this.customId != v)
        {
            this.customId = v;
            setModified(true);
        }


    }

    /**
     * Get the CustomName
     *
     * @return String
     */
    public String getCustomName()
    {
        return customName;
    }


    /**
     * Set the value of CustomName
     *
     * @param v new value
     */
    public void setCustomName(String v) 
    {

        if (!ObjectUtils.equals(this.customName, v))
        {
            this.customName = v;
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
     * Get the IndustryId
     *
     * @return int
     */
    public int getIndustryId()
    {
        return industryId;
    }


    /**
     * Set the value of IndustryId
     *
     * @param v new value
     */
    public void setIndustryId(int v) 
    {

        if (this.industryId != v)
        {
            this.industryId = v;
            setModified(true);
        }


    }

    /**
     * Get the SubIndustryId
     *
     * @return int
     */
    public int getSubIndustryId()
    {
        return subIndustryId;
    }


    /**
     * Set the value of SubIndustryId
     *
     * @param v new value
     */
    public void setSubIndustryId(int v) 
    {

        if (this.subIndustryId != v)
        {
            this.subIndustryId = v;
            setModified(true);
        }


    }

    /**
     * Get the CategoryId
     *
     * @return int
     */
    public int getCategoryId()
    {
        return categoryId;
    }


    /**
     * Set the value of CategoryId
     *
     * @param v new value
     */
    public void setCategoryId(int v) 
    {

        if (this.categoryId != v)
        {
            this.categoryId = v;
            setModified(true);
        }


    }

    /**
     * Get the MarketingType
     *
     * @return int
     */
    public int getMarketingType()
    {
        return marketingType;
    }


    /**
     * Set the value of MarketingType
     *
     * @param v new value
     */
    public void setMarketingType(int v) 
    {

        if (this.marketingType != v)
        {
            this.marketingType = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collAdCasts
     */
    protected List<AdCast> collAdCasts;

    /**
     * Temporary storage of collAdCasts to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initAdCasts()
    {
        if (collAdCasts == null)
        {
            collAdCasts = new ArrayList<AdCast>();
        }
    }


    /**
     * Method called to associate a AdCast object to this object
     * through the AdCast foreign key attribute
     *
     * @param l AdCast
     * @throws TorqueException
     */
    public void addAdCast(AdCast l) throws TorqueException
    {
        getAdCasts().add(l);
        l.setAdOrder((AdOrder) this);
    }

    /**
     * Method called to associate a AdCast object to this object
     * through the AdCast foreign key attribute using connection.
     *
     * @param l AdCast
     * @throws TorqueException
     */
    public void addAdCast(AdCast l, Connection con) throws TorqueException
    {
        getAdCasts(con).add(l);
        l.setAdOrder((AdOrder) this);
    }

    /**
     * The criteria used to select the current contents of collAdCasts
     */
    private Criteria lastAdCastsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getAdCasts(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<AdCast> getAdCasts()
        throws TorqueException
    {
        if (collAdCasts == null)
        {
            collAdCasts = getAdCasts(new Criteria(10));
        }
        return collAdCasts;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdOrder has previously
     * been saved, it will retrieve related AdCasts from storage.
     * If this AdOrder is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<AdCast> getAdCasts(Criteria criteria) throws TorqueException
    {
        if (collAdCasts == null)
        {
            if (isNew())
            {
               collAdCasts = new ArrayList<AdCast>();
            }
            else
            {
                criteria.add(AdCastPeer.ORDER_ID, getId() );
                collAdCasts = AdCastPeer.doSelect(criteria);
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
                criteria.add(AdCastPeer.ORDER_ID, getId());
                if (!lastAdCastsCriteria.equals(criteria))
                {
                    collAdCasts = AdCastPeer.doSelect(criteria);
                }
            }
        }
        lastAdCastsCriteria = criteria;

        return collAdCasts;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getAdCasts(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<AdCast> getAdCasts(Connection con) throws TorqueException
    {
        if (collAdCasts == null)
        {
            collAdCasts = getAdCasts(new Criteria(10), con);
        }
        return collAdCasts;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdOrder has previously
     * been saved, it will retrieve related AdCasts from storage.
     * If this AdOrder is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<AdCast> getAdCasts(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collAdCasts == null)
        {
            if (isNew())
            {
               collAdCasts = new ArrayList<AdCast>();
            }
            else
            {
                 criteria.add(AdCastPeer.ORDER_ID, getId());
                 collAdCasts = AdCastPeer.doSelect(criteria, con);
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
                 criteria.add(AdCastPeer.ORDER_ID, getId());
                 if (!lastAdCastsCriteria.equals(criteria))
                 {
                     collAdCasts = AdCastPeer.doSelect(criteria, con);
                 }
             }
         }
         lastAdCastsCriteria = criteria;

         return collAdCasts;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdOrder is new, it will return
     * an empty collection; or if this AdOrder has previously
     * been saved, it will retrieve related AdCasts from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdOrder.
     */
    protected List<AdCast> getAdCastsJoinAdType(Criteria criteria)
        throws TorqueException
    {
        if (collAdCasts == null)
        {
            if (isNew())
            {
               collAdCasts = new ArrayList<AdCast>();
            }
            else
            {
                criteria.add(AdCastPeer.ORDER_ID, getId());
                collAdCasts = AdCastPeer.doSelectJoinAdType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(AdCastPeer.ORDER_ID, getId());
            if (!lastAdCastsCriteria.equals(criteria))
            {
                collAdCasts = AdCastPeer.doSelectJoinAdType(criteria);
            }
        }
        lastAdCastsCriteria = criteria;

        return collAdCasts;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdOrder is new, it will return
     * an empty collection; or if this AdOrder has previously
     * been saved, it will retrieve related AdCasts from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdOrder.
     */
    protected List<AdCast> getAdCastsJoinAdOrder(Criteria criteria)
        throws TorqueException
    {
        if (collAdCasts == null)
        {
            if (isNew())
            {
               collAdCasts = new ArrayList<AdCast>();
            }
            else
            {
                criteria.add(AdCastPeer.ORDER_ID, getId());
                collAdCasts = AdCastPeer.doSelectJoinAdOrder(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(AdCastPeer.ORDER_ID, getId());
            if (!lastAdCastsCriteria.equals(criteria))
            {
                collAdCasts = AdCastPeer.doSelectJoinAdOrder(criteria);
            }
        }
        lastAdCastsCriteria = criteria;

        return collAdCasts;
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
            fieldNames.add("CustomId");
            fieldNames.add("CustomName");
            fieldNames.add("Type");
            fieldNames.add("UpdateTime");
            fieldNames.add("Status");
            fieldNames.add("IndustryId");
            fieldNames.add("SubIndustryId");
            fieldNames.add("CategoryId");
            fieldNames.add("MarketingType");
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
        if (name.equals("CustomId"))
        {
            return new Integer(getCustomId());
        }
        if (name.equals("CustomName"))
        {
            return getCustomName();
        }
        if (name.equals("Type"))
        {
            return new Integer(getType());
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("IndustryId"))
        {
            return new Integer(getIndustryId());
        }
        if (name.equals("SubIndustryId"))
        {
            return new Integer(getSubIndustryId());
        }
        if (name.equals("CategoryId"))
        {
            return new Integer(getCategoryId());
        }
        if (name.equals("MarketingType"))
        {
            return new Integer(getMarketingType());
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
        if (name.equals("CustomId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCustomId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CustomName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCustomName((String) value);
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
        if (name.equals("Status"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStatus(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IndustryId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIndustryId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SubIndustryId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSubIndustryId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CategoryId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCategoryId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MarketingType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMarketingType(((Integer) value).intValue());
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
        if (name.equals(AdOrderPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(AdOrderPeer.NAME))
        {
            return getName();
        }
        if (name.equals(AdOrderPeer.CUSTOM_ID))
        {
            return new Integer(getCustomId());
        }
        if (name.equals(AdOrderPeer.CUSTOM_NAME))
        {
            return getCustomName();
        }
        if (name.equals(AdOrderPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(AdOrderPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(AdOrderPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(AdOrderPeer.INDUSTRY_ID))
        {
            return new Integer(getIndustryId());
        }
        if (name.equals(AdOrderPeer.SUB_INDUSTRY_ID))
        {
            return new Integer(getSubIndustryId());
        }
        if (name.equals(AdOrderPeer.CATEGORY_ID))
        {
            return new Integer(getCategoryId());
        }
        if (name.equals(AdOrderPeer.MARKETING_TYPE))
        {
            return new Integer(getMarketingType());
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
      if (AdOrderPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (AdOrderPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (AdOrderPeer.CUSTOM_ID.equals(name))
        {
            return setByName("CustomId", value);
        }
      if (AdOrderPeer.CUSTOM_NAME.equals(name))
        {
            return setByName("CustomName", value);
        }
      if (AdOrderPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (AdOrderPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (AdOrderPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (AdOrderPeer.INDUSTRY_ID.equals(name))
        {
            return setByName("IndustryId", value);
        }
      if (AdOrderPeer.SUB_INDUSTRY_ID.equals(name))
        {
            return setByName("SubIndustryId", value);
        }
      if (AdOrderPeer.CATEGORY_ID.equals(name))
        {
            return setByName("CategoryId", value);
        }
      if (AdOrderPeer.MARKETING_TYPE.equals(name))
        {
            return setByName("MarketingType", value);
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
            return new Integer(getCustomId());
        }
        if (pos == 3)
        {
            return getCustomName();
        }
        if (pos == 4)
        {
            return new Integer(getType());
        }
        if (pos == 5)
        {
            return getUpdateTime();
        }
        if (pos == 6)
        {
            return new Integer(getStatus());
        }
        if (pos == 7)
        {
            return new Integer(getIndustryId());
        }
        if (pos == 8)
        {
            return new Integer(getSubIndustryId());
        }
        if (pos == 9)
        {
            return new Integer(getCategoryId());
        }
        if (pos == 10)
        {
            return new Integer(getMarketingType());
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
            return setByName("CustomId", value);
        }
    if (position == 3)
        {
            return setByName("CustomName", value);
        }
    if (position == 4)
        {
            return setByName("Type", value);
        }
    if (position == 5)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 6)
        {
            return setByName("Status", value);
        }
    if (position == 7)
        {
            return setByName("IndustryId", value);
        }
    if (position == 8)
        {
            return setByName("SubIndustryId", value);
        }
    if (position == 9)
        {
            return setByName("CategoryId", value);
        }
    if (position == 10)
        {
            return setByName("MarketingType", value);
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
        save(AdOrderPeer.DATABASE_NAME);
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
                    AdOrderPeer.doInsert((AdOrder) this, con);
                    setNew(false);
                }
                else
                {
                    AdOrderPeer.doUpdate((AdOrder) this, con);
                }
            }


            if (collAdCasts != null)
            {
                for (int i = 0; i < collAdCasts.size(); i++)
                {
                    ((AdCast) collAdCasts.get(i)).save(con);
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
    public AdOrder copy() throws TorqueException
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
    public AdOrder copy(Connection con) throws TorqueException
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
    public AdOrder copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new AdOrder(), deepcopy);
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
    public AdOrder copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new AdOrder(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected AdOrder copyInto(AdOrder copyObj) throws TorqueException
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
    protected AdOrder copyInto(AdOrder copyObj, Connection con) throws TorqueException
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
    protected AdOrder copyInto(AdOrder copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setCustomId(customId);
        copyObj.setCustomName(customName);
        copyObj.setType(type);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStatus(status);
        copyObj.setIndustryId(industryId);
        copyObj.setSubIndustryId(subIndustryId);
        copyObj.setCategoryId(categoryId);
        copyObj.setMarketingType(marketingType);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<AdCast> vAdCasts = getAdCasts();
        if (vAdCasts != null)
        {
            for (int i = 0; i < vAdCasts.size(); i++)
            {
                AdCast obj =  vAdCasts.get(i);
                copyObj.addAdCast(obj.copy());
            }
        }
        else
        {
            copyObj.collAdCasts = null;
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
    protected AdOrder copyInto(AdOrder copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setCustomId(customId);
        copyObj.setCustomName(customName);
        copyObj.setType(type);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStatus(status);
        copyObj.setIndustryId(industryId);
        copyObj.setSubIndustryId(subIndustryId);
        copyObj.setCategoryId(categoryId);
        copyObj.setMarketingType(marketingType);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<AdCast> vAdCasts = getAdCasts(con);
        if (vAdCasts != null)
        {
            for (int i = 0; i < vAdCasts.size(); i++)
            {
                AdCast obj =  vAdCasts.get(i);
                copyObj.addAdCast(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collAdCasts = null;
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
    public AdOrderPeer getPeer()
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
        return AdOrderPeer.getTableMap();
    }

  
    /**
     * Creates a AdOrderBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a AdOrderBean with the contents of this object
     */
    public AdOrderBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a AdOrderBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a AdOrderBean with the contents of this object
     */
    public AdOrderBean getBean(IdentityMap createdBeans)
    {
        AdOrderBean result = (AdOrderBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new AdOrderBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setCustomId(getCustomId());
        result.setCustomName(getCustomName());
        result.setType(getType());
        result.setUpdateTime(getUpdateTime());
        result.setStatus(getStatus());
        result.setIndustryId(getIndustryId());
        result.setSubIndustryId(getSubIndustryId());
        result.setCategoryId(getCategoryId());
        result.setMarketingType(getMarketingType());



        if (collAdCasts != null)
        {
            List<AdCastBean> relatedBeans = new ArrayList<AdCastBean>(collAdCasts.size());
            for (Iterator<AdCast> collAdCastsIt = collAdCasts.iterator(); collAdCastsIt.hasNext(); )
            {
                AdCast related = (AdCast) collAdCastsIt.next();
                AdCastBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setAdCastBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of AdOrder with the contents
     * of a AdOrderBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the AdOrderBean which contents are used to create
     *        the resulting class
     * @return an instance of AdOrder with the contents of bean
     */
    public static AdOrder createAdOrder(AdOrderBean bean)
        throws TorqueException
    {
        return createAdOrder(bean, new IdentityMap());
    }

    /**
     * Creates an instance of AdOrder with the contents
     * of a AdOrderBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the AdOrderBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of AdOrder with the contents of bean
     */

    public static AdOrder createAdOrder(AdOrderBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        AdOrder result = (AdOrder) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new AdOrder();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setCustomId(bean.getCustomId());
        result.setCustomName(bean.getCustomName());
        result.setType(bean.getType());
        result.setUpdateTime(bean.getUpdateTime());
        result.setStatus(bean.getStatus());
        result.setIndustryId(bean.getIndustryId());
        result.setSubIndustryId(bean.getSubIndustryId());
        result.setCategoryId(bean.getCategoryId());
        result.setMarketingType(bean.getMarketingType());



        {
            List<AdCastBean> relatedBeans = bean.getAdCastBeans();
            if (relatedBeans != null)
            {
                for (Iterator<AdCastBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    AdCastBean relatedBean =  relatedBeansIt.next();
                    AdCast related = AdCast.createAdCast(relatedBean, createdObjects);
                    result.addAdCastFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a AdCast object to this object.
     * through the AdCast foreign key attribute
     *
     * @param toAdd AdCast
     */
    protected void addAdCastFromBean(AdCast toAdd)
    {
        initAdCasts();
        collAdCasts.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("AdOrder:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("CustomId = ")
           .append(getCustomId())
           .append("\n");
        str.append("CustomName = ")
           .append(getCustomName())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("IndustryId = ")
           .append(getIndustryId())
           .append("\n");
        str.append("SubIndustryId = ")
           .append(getSubIndustryId())
           .append("\n");
        str.append("CategoryId = ")
           .append(getCategoryId())
           .append("\n");
        str.append("MarketingType = ")
           .append(getMarketingType())
           .append("\n");
        return(str.toString());
    }
}
