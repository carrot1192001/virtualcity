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
import com.youku.atm.om.bean.CampaignBean;

import com.youku.atm.om.bean.CastCampaignBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Campaign
 */
public abstract class BaseCampaign extends BaseObject
{
    /** The Peer class */
    private static final CampaignPeer peer =
        new CampaignPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the type field */
    private int type = 1;

    /** The value for the startDate field */
    private Date startDate;

    /** The value for the endDate field */
    private Date endDate;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the numlimit field */
    private int numlimit = 0;

    /** The value for the daylimit field */
    private String daylimit = "0";

    /** The value for the unite field */
    private int unite = 0;

    /** The value for the status field */
    private int status = 1;


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



        // update associated CastCampaign
        if (collCastCampaigns != null)
        {
            for (int i = 0; i < collCastCampaigns.size(); i++)
            {
                ((CastCampaign) collCastCampaigns.get(i))
                        .setCampaignId(v);
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
     * Get the StartDate
     *
     * @return Date
     */
    public Date getStartDate()
    {
        return startDate;
    }


    /**
     * Set the value of StartDate
     *
     * @param v new value
     */
    public void setStartDate(Date v) 
    {

        if (!ObjectUtils.equals(this.startDate, v))
        {
            this.startDate = v;
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
     * Get the Daylimit
     *
     * @return String
     */
    public String getDaylimit()
    {
        return daylimit;
    }


    /**
     * Set the value of Daylimit
     *
     * @param v new value
     */
    public void setDaylimit(String v) 
    {

        if (!ObjectUtils.equals(this.daylimit, v))
        {
            this.daylimit = v;
            setModified(true);
        }


    }

    /**
     * Get the Unite
     *
     * @return int
     */
    public int getUnite()
    {
        return unite;
    }


    /**
     * Set the value of Unite
     *
     * @param v new value
     */
    public void setUnite(int v) 
    {

        if (this.unite != v)
        {
            this.unite = v;
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
     * Collection to store aggregation of collCastCampaigns
     */
    protected List<CastCampaign> collCastCampaigns;

    /**
     * Temporary storage of collCastCampaigns to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastCampaigns()
    {
        if (collCastCampaigns == null)
        {
            collCastCampaigns = new ArrayList<CastCampaign>();
        }
    }


    /**
     * Method called to associate a CastCampaign object to this object
     * through the CastCampaign foreign key attribute
     *
     * @param l CastCampaign
     * @throws TorqueException
     */
    public void addCastCampaign(CastCampaign l) throws TorqueException
    {
        getCastCampaigns().add(l);
        l.setCampaign((Campaign) this);
    }

    /**
     * Method called to associate a CastCampaign object to this object
     * through the CastCampaign foreign key attribute using connection.
     *
     * @param l CastCampaign
     * @throws TorqueException
     */
    public void addCastCampaign(CastCampaign l, Connection con) throws TorqueException
    {
        getCastCampaigns(con).add(l);
        l.setCampaign((Campaign) this);
    }

    /**
     * The criteria used to select the current contents of collCastCampaigns
     */
    private Criteria lastCastCampaignsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastCampaigns(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastCampaign> getCastCampaigns()
        throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            collCastCampaigns = getCastCampaigns(new Criteria(10));
        }
        return collCastCampaigns;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Campaign has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     * If this Campaign is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastCampaign> getCastCampaigns(Criteria criteria) throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId() );
                collCastCampaigns = CastCampaignPeer.doSelect(criteria);
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
                criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId());
                if (!lastCastCampaignsCriteria.equals(criteria))
                {
                    collCastCampaigns = CastCampaignPeer.doSelect(criteria);
                }
            }
        }
        lastCastCampaignsCriteria = criteria;

        return collCastCampaigns;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastCampaigns(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastCampaign> getCastCampaigns(Connection con) throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            collCastCampaigns = getCastCampaigns(new Criteria(10), con);
        }
        return collCastCampaigns;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Campaign has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     * If this Campaign is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastCampaign> getCastCampaigns(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                 criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId());
                 collCastCampaigns = CastCampaignPeer.doSelect(criteria, con);
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
                 criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId());
                 if (!lastCastCampaignsCriteria.equals(criteria))
                 {
                     collCastCampaigns = CastCampaignPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastCampaignsCriteria = criteria;

         return collCastCampaigns;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Campaign is new, it will return
     * an empty collection; or if this Campaign has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Campaign.
     */
    protected List<CastCampaign> getCastCampaignsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId());
                collCastCampaigns = CastCampaignPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId());
            if (!lastCastCampaignsCriteria.equals(criteria))
            {
                collCastCampaigns = CastCampaignPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastCampaignsCriteria = criteria;

        return collCastCampaigns;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Campaign is new, it will return
     * an empty collection; or if this Campaign has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Campaign.
     */
    protected List<CastCampaign> getCastCampaignsJoinCampaign(Criteria criteria)
        throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId());
                collCastCampaigns = CastCampaignPeer.doSelectJoinCampaign(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastCampaignPeer.CAMPAIGN_ID, getId());
            if (!lastCastCampaignsCriteria.equals(criteria))
            {
                collCastCampaigns = CastCampaignPeer.doSelectJoinCampaign(criteria);
            }
        }
        lastCastCampaignsCriteria = criteria;

        return collCastCampaigns;
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
            fieldNames.add("StartDate");
            fieldNames.add("EndDate");
            fieldNames.add("UpdateTime");
            fieldNames.add("Numlimit");
            fieldNames.add("Daylimit");
            fieldNames.add("Unite");
            fieldNames.add("Status");
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
        if (name.equals("StartDate"))
        {
            return getStartDate();
        }
        if (name.equals("EndDate"))
        {
            return getEndDate();
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("Numlimit"))
        {
            return new Integer(getNumlimit());
        }
        if (name.equals("Daylimit"))
        {
            return getDaylimit();
        }
        if (name.equals("Unite"))
        {
            return new Integer(getUnite());
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
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
        if (name.equals("StartDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStartDate((Date) value);
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
        if (name.equals("Numlimit"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNumlimit(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Daylimit"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDaylimit((String) value);
            return true;
        }
        if (name.equals("Unite"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setUnite(((Integer) value).intValue());
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
        if (name.equals(CampaignPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(CampaignPeer.NAME))
        {
            return getName();
        }
        if (name.equals(CampaignPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(CampaignPeer.START_DATE))
        {
            return getStartDate();
        }
        if (name.equals(CampaignPeer.END_DATE))
        {
            return getEndDate();
        }
        if (name.equals(CampaignPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(CampaignPeer.NUMLIMIT))
        {
            return new Integer(getNumlimit());
        }
        if (name.equals(CampaignPeer.DAYLIMIT))
        {
            return getDaylimit();
        }
        if (name.equals(CampaignPeer.UNITE))
        {
            return new Integer(getUnite());
        }
        if (name.equals(CampaignPeer.STATUS))
        {
            return new Integer(getStatus());
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
      if (CampaignPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (CampaignPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (CampaignPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (CampaignPeer.START_DATE.equals(name))
        {
            return setByName("StartDate", value);
        }
      if (CampaignPeer.END_DATE.equals(name))
        {
            return setByName("EndDate", value);
        }
      if (CampaignPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (CampaignPeer.NUMLIMIT.equals(name))
        {
            return setByName("Numlimit", value);
        }
      if (CampaignPeer.DAYLIMIT.equals(name))
        {
            return setByName("Daylimit", value);
        }
      if (CampaignPeer.UNITE.equals(name))
        {
            return setByName("Unite", value);
        }
      if (CampaignPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
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
            return getStartDate();
        }
        if (pos == 4)
        {
            return getEndDate();
        }
        if (pos == 5)
        {
            return getUpdateTime();
        }
        if (pos == 6)
        {
            return new Integer(getNumlimit());
        }
        if (pos == 7)
        {
            return getDaylimit();
        }
        if (pos == 8)
        {
            return new Integer(getUnite());
        }
        if (pos == 9)
        {
            return new Integer(getStatus());
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
            return setByName("StartDate", value);
        }
    if (position == 4)
        {
            return setByName("EndDate", value);
        }
    if (position == 5)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 6)
        {
            return setByName("Numlimit", value);
        }
    if (position == 7)
        {
            return setByName("Daylimit", value);
        }
    if (position == 8)
        {
            return setByName("Unite", value);
        }
    if (position == 9)
        {
            return setByName("Status", value);
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
        save(CampaignPeer.DATABASE_NAME);
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
                    CampaignPeer.doInsert((Campaign) this, con);
                    setNew(false);
                }
                else
                {
                    CampaignPeer.doUpdate((Campaign) this, con);
                }
            }


            if (collCastCampaigns != null)
            {
                for (int i = 0; i < collCastCampaigns.size(); i++)
                {
                    ((CastCampaign) collCastCampaigns.get(i)).save(con);
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
    public Campaign copy() throws TorqueException
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
    public Campaign copy(Connection con) throws TorqueException
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
    public Campaign copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Campaign(), deepcopy);
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
    public Campaign copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Campaign(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Campaign copyInto(Campaign copyObj) throws TorqueException
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
    protected Campaign copyInto(Campaign copyObj, Connection con) throws TorqueException
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
    protected Campaign copyInto(Campaign copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setType(type);
        copyObj.setStartDate(startDate);
        copyObj.setEndDate(endDate);
        copyObj.setUpdateTime(updateTime);
        copyObj.setNumlimit(numlimit);
        copyObj.setDaylimit(daylimit);
        copyObj.setUnite(unite);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastCampaign> vCastCampaigns = getCastCampaigns();
        if (vCastCampaigns != null)
        {
            for (int i = 0; i < vCastCampaigns.size(); i++)
            {
                CastCampaign obj =  vCastCampaigns.get(i);
                copyObj.addCastCampaign(obj.copy());
            }
        }
        else
        {
            copyObj.collCastCampaigns = null;
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
    protected Campaign copyInto(Campaign copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setType(type);
        copyObj.setStartDate(startDate);
        copyObj.setEndDate(endDate);
        copyObj.setUpdateTime(updateTime);
        copyObj.setNumlimit(numlimit);
        copyObj.setDaylimit(daylimit);
        copyObj.setUnite(unite);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastCampaign> vCastCampaigns = getCastCampaigns(con);
        if (vCastCampaigns != null)
        {
            for (int i = 0; i < vCastCampaigns.size(); i++)
            {
                CastCampaign obj =  vCastCampaigns.get(i);
                copyObj.addCastCampaign(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastCampaigns = null;
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
    public CampaignPeer getPeer()
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
        return CampaignPeer.getTableMap();
    }

  
    /**
     * Creates a CampaignBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a CampaignBean with the contents of this object
     */
    public CampaignBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a CampaignBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a CampaignBean with the contents of this object
     */
    public CampaignBean getBean(IdentityMap createdBeans)
    {
        CampaignBean result = (CampaignBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new CampaignBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setType(getType());
        result.setStartDate(getStartDate());
        result.setEndDate(getEndDate());
        result.setUpdateTime(getUpdateTime());
        result.setNumlimit(getNumlimit());
        result.setDaylimit(getDaylimit());
        result.setUnite(getUnite());
        result.setStatus(getStatus());



        if (collCastCampaigns != null)
        {
            List<CastCampaignBean> relatedBeans = new ArrayList<CastCampaignBean>(collCastCampaigns.size());
            for (Iterator<CastCampaign> collCastCampaignsIt = collCastCampaigns.iterator(); collCastCampaignsIt.hasNext(); )
            {
                CastCampaign related = (CastCampaign) collCastCampaignsIt.next();
                CastCampaignBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastCampaignBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Campaign with the contents
     * of a CampaignBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the CampaignBean which contents are used to create
     *        the resulting class
     * @return an instance of Campaign with the contents of bean
     */
    public static Campaign createCampaign(CampaignBean bean)
        throws TorqueException
    {
        return createCampaign(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Campaign with the contents
     * of a CampaignBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the CampaignBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Campaign with the contents of bean
     */

    public static Campaign createCampaign(CampaignBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Campaign result = (Campaign) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Campaign();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setType(bean.getType());
        result.setStartDate(bean.getStartDate());
        result.setEndDate(bean.getEndDate());
        result.setUpdateTime(bean.getUpdateTime());
        result.setNumlimit(bean.getNumlimit());
        result.setDaylimit(bean.getDaylimit());
        result.setUnite(bean.getUnite());
        result.setStatus(bean.getStatus());



        {
            List<CastCampaignBean> relatedBeans = bean.getCastCampaignBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastCampaignBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastCampaignBean relatedBean =  relatedBeansIt.next();
                    CastCampaign related = CastCampaign.createCastCampaign(relatedBean, createdObjects);
                    result.addCastCampaignFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a CastCampaign object to this object.
     * through the CastCampaign foreign key attribute
     *
     * @param toAdd CastCampaign
     */
    protected void addCastCampaignFromBean(CastCampaign toAdd)
    {
        initCastCampaigns();
        collCastCampaigns.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Campaign:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("StartDate = ")
           .append(getStartDate())
           .append("\n");
        str.append("EndDate = ")
           .append(getEndDate())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("Numlimit = ")
           .append(getNumlimit())
           .append("\n");
        str.append("Daylimit = ")
           .append(getDaylimit())
           .append("\n");
        str.append("Unite = ")
           .append(getUnite())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
