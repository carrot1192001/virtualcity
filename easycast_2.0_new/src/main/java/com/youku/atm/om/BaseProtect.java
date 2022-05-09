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
import com.youku.atm.om.bean.ProtectBean;
import com.youku.atm.om.bean.ResourceBean;

import com.youku.atm.om.bean.ProtectAdBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Protect
 */
public abstract class BaseProtect extends BaseObject
{
    /** The Peer class */
    private static final ProtectPeer peer =
        new ProtectPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the manageType field */
    private String manageType;

    /** The value for the positions field */
    private String positions;

    /** The value for the parent field */
    private int parent;

    /** The value for the priority field */
    private int priority;

    /** The value for the resourceId field */
    private int resourceId;

    /** The value for the color field */
    private int color;

    /** The value for the starttime field */
    private Date starttime;

    /** The value for the endtime field */
    private Date endtime;

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



        // update associated ProtectAd
        if (collProtectAds != null)
        {
            for (int i = 0; i < collProtectAds.size(); i++)
            {
                ((ProtectAd) collProtectAds.get(i))
                        .setProtectId(v);
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
     * Get the ManageType
     *
     * @return String
     */
    public String getManageType()
    {
        return manageType;
    }


    /**
     * Set the value of ManageType
     *
     * @param v new value
     */
    public void setManageType(String v) 
    {

        if (!ObjectUtils.equals(this.manageType, v))
        {
            this.manageType = v;
            setModified(true);
        }


    }

    /**
     * Get the Positions
     *
     * @return String
     */
    public String getPositions()
    {
        return positions;
    }


    /**
     * Set the value of Positions
     *
     * @param v new value
     */
    public void setPositions(String v) 
    {

        if (!ObjectUtils.equals(this.positions, v))
        {
            this.positions = v;
            setModified(true);
        }


    }

    /**
     * Get the Parent
     *
     * @return int
     */
    public int getParent()
    {
        return parent;
    }


    /**
     * Set the value of Parent
     *
     * @param v new value
     */
    public void setParent(int v) 
    {

        if (this.parent != v)
        {
            this.parent = v;
            setModified(true);
        }


    }

    /**
     * Get the Priority
     *
     * @return int
     */
    public int getPriority()
    {
        return priority;
    }


    /**
     * Set the value of Priority
     *
     * @param v new value
     */
    public void setPriority(int v) 
    {

        if (this.priority != v)
        {
            this.priority = v;
            setModified(true);
        }


    }

    /**
     * Get the ResourceId
     *
     * @return int
     */
    public int getResourceId()
    {
        return resourceId;
    }


    /**
     * Set the value of ResourceId
     *
     * @param v new value
     */
    public void setResourceId(int v) throws TorqueException
    {

        if (this.resourceId != v)
        {
            this.resourceId = v;
            setModified(true);
        }


        if (aResource != null && !(aResource.getId() == v))
        {
            aResource = null;
        }

    }

    /**
     * Get the Color
     *
     * @return int
     */
    public int getColor()
    {
        return color;
    }


    /**
     * Set the value of Color
     *
     * @param v new value
     */
    public void setColor(int v) 
    {

        if (this.color != v)
        {
            this.color = v;
            setModified(true);
        }


    }

    /**
     * Get the Starttime
     *
     * @return Date
     */
    public Date getStarttime()
    {
        return starttime;
    }


    /**
     * Set the value of Starttime
     *
     * @param v new value
     */
    public void setStarttime(Date v) 
    {

        if (!ObjectUtils.equals(this.starttime, v))
        {
            this.starttime = v;
            setModified(true);
        }


    }

    /**
     * Get the Endtime
     *
     * @return Date
     */
    public Date getEndtime()
    {
        return endtime;
    }


    /**
     * Set the value of Endtime
     *
     * @param v new value
     */
    public void setEndtime(Date v) 
    {

        if (!ObjectUtils.equals(this.endtime, v))
        {
            this.endtime = v;
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

    



    private Resource aResource;

    /**
     * Declares an association between this object and a Resource object
     *
     * @param v Resource
     * @throws TorqueException
     */
    public void setResource(Resource v) throws TorqueException
    {
        if (v == null)
        {
            setResourceId( 0);
        }
        else
        {
            setResourceId(v.getId());
        }
        aResource = v;
    }


    /**
     * Returns the associated Resource object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Resource object
     * @throws TorqueException
     */
    public Resource getResource()
        throws TorqueException
    {
        if (aResource == null && (this.resourceId != 0))
        {
            aResource = ResourcePeer.retrieveByPK(SimpleKey.keyFor(this.resourceId));
        }
        return aResource;
    }

    /**
     * Return the associated Resource object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Resource object
     * @throws TorqueException
     */
    public Resource getResource(Connection connection)
        throws TorqueException
    {
        if (aResource == null && (this.resourceId != 0))
        {
            aResource = ResourcePeer.retrieveByPK(SimpleKey.keyFor(this.resourceId), connection);
        }
        return aResource;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setResourceKey(ObjectKey key) throws TorqueException
    {

        setResourceId(((NumberKey) key).intValue());
    }
   


    /**
     * Collection to store aggregation of collProtectAds
     */
    protected List<ProtectAd> collProtectAds;

    /**
     * Temporary storage of collProtectAds to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initProtectAds()
    {
        if (collProtectAds == null)
        {
            collProtectAds = new ArrayList<ProtectAd>();
        }
    }


    /**
     * Method called to associate a ProtectAd object to this object
     * through the ProtectAd foreign key attribute
     *
     * @param l ProtectAd
     * @throws TorqueException
     */
    public void addProtectAd(ProtectAd l) throws TorqueException
    {
        getProtectAds().add(l);
        l.setProtect((Protect) this);
    }

    /**
     * Method called to associate a ProtectAd object to this object
     * through the ProtectAd foreign key attribute using connection.
     *
     * @param l ProtectAd
     * @throws TorqueException
     */
    public void addProtectAd(ProtectAd l, Connection con) throws TorqueException
    {
        getProtectAds(con).add(l);
        l.setProtect((Protect) this);
    }

    /**
     * The criteria used to select the current contents of collProtectAds
     */
    private Criteria lastProtectAdsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getProtectAds(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<ProtectAd> getProtectAds()
        throws TorqueException
    {
        if (collProtectAds == null)
        {
            collProtectAds = getProtectAds(new Criteria(10));
        }
        return collProtectAds;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Protect has previously
     * been saved, it will retrieve related ProtectAds from storage.
     * If this Protect is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<ProtectAd> getProtectAds(Criteria criteria) throws TorqueException
    {
        if (collProtectAds == null)
        {
            if (isNew())
            {
               collProtectAds = new ArrayList<ProtectAd>();
            }
            else
            {
                criteria.add(ProtectAdPeer.PROTECT_ID, getId() );
                collProtectAds = ProtectAdPeer.doSelect(criteria);
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
                criteria.add(ProtectAdPeer.PROTECT_ID, getId());
                if (!lastProtectAdsCriteria.equals(criteria))
                {
                    collProtectAds = ProtectAdPeer.doSelect(criteria);
                }
            }
        }
        lastProtectAdsCriteria = criteria;

        return collProtectAds;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getProtectAds(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<ProtectAd> getProtectAds(Connection con) throws TorqueException
    {
        if (collProtectAds == null)
        {
            collProtectAds = getProtectAds(new Criteria(10), con);
        }
        return collProtectAds;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Protect has previously
     * been saved, it will retrieve related ProtectAds from storage.
     * If this Protect is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<ProtectAd> getProtectAds(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collProtectAds == null)
        {
            if (isNew())
            {
               collProtectAds = new ArrayList<ProtectAd>();
            }
            else
            {
                 criteria.add(ProtectAdPeer.PROTECT_ID, getId());
                 collProtectAds = ProtectAdPeer.doSelect(criteria, con);
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
                 criteria.add(ProtectAdPeer.PROTECT_ID, getId());
                 if (!lastProtectAdsCriteria.equals(criteria))
                 {
                     collProtectAds = ProtectAdPeer.doSelect(criteria, con);
                 }
             }
         }
         lastProtectAdsCriteria = criteria;

         return collProtectAds;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Protect is new, it will return
     * an empty collection; or if this Protect has previously
     * been saved, it will retrieve related ProtectAds from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Protect.
     */
    protected List<ProtectAd> getProtectAdsJoinProtect(Criteria criteria)
        throws TorqueException
    {
        if (collProtectAds == null)
        {
            if (isNew())
            {
               collProtectAds = new ArrayList<ProtectAd>();
            }
            else
            {
                criteria.add(ProtectAdPeer.PROTECT_ID, getId());
                collProtectAds = ProtectAdPeer.doSelectJoinProtect(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(ProtectAdPeer.PROTECT_ID, getId());
            if (!lastProtectAdsCriteria.equals(criteria))
            {
                collProtectAds = ProtectAdPeer.doSelectJoinProtect(criteria);
            }
        }
        lastProtectAdsCriteria = criteria;

        return collProtectAds;
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
            fieldNames.add("ManageType");
            fieldNames.add("Positions");
            fieldNames.add("Parent");
            fieldNames.add("Priority");
            fieldNames.add("ResourceId");
            fieldNames.add("Color");
            fieldNames.add("Starttime");
            fieldNames.add("Endtime");
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
        if (name.equals("ManageType"))
        {
            return getManageType();
        }
        if (name.equals("Positions"))
        {
            return getPositions();
        }
        if (name.equals("Parent"))
        {
            return new Integer(getParent());
        }
        if (name.equals("Priority"))
        {
            return new Integer(getPriority());
        }
        if (name.equals("ResourceId"))
        {
            return new Integer(getResourceId());
        }
        if (name.equals("Color"))
        {
            return new Integer(getColor());
        }
        if (name.equals("Starttime"))
        {
            return getStarttime();
        }
        if (name.equals("Endtime"))
        {
            return getEndtime();
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
        if (name.equals("ManageType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setManageType((String) value);
            return true;
        }
        if (name.equals("Positions"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPositions((String) value);
            return true;
        }
        if (name.equals("Parent"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setParent(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Priority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ResourceId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setResourceId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Color"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setColor(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Starttime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStarttime((Date) value);
            return true;
        }
        if (name.equals("Endtime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEndtime((Date) value);
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
        if (name.equals(ProtectPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(ProtectPeer.NAME))
        {
            return getName();
        }
        if (name.equals(ProtectPeer.MANAGE_TYPE))
        {
            return getManageType();
        }
        if (name.equals(ProtectPeer.POSITIONS))
        {
            return getPositions();
        }
        if (name.equals(ProtectPeer.PARENT))
        {
            return new Integer(getParent());
        }
        if (name.equals(ProtectPeer.PRIORITY))
        {
            return new Integer(getPriority());
        }
        if (name.equals(ProtectPeer.RESOURCE_ID))
        {
            return new Integer(getResourceId());
        }
        if (name.equals(ProtectPeer.COLOR))
        {
            return new Integer(getColor());
        }
        if (name.equals(ProtectPeer.STARTTIME))
        {
            return getStarttime();
        }
        if (name.equals(ProtectPeer.ENDTIME))
        {
            return getEndtime();
        }
        if (name.equals(ProtectPeer.STATUS))
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
      if (ProtectPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (ProtectPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (ProtectPeer.MANAGE_TYPE.equals(name))
        {
            return setByName("ManageType", value);
        }
      if (ProtectPeer.POSITIONS.equals(name))
        {
            return setByName("Positions", value);
        }
      if (ProtectPeer.PARENT.equals(name))
        {
            return setByName("Parent", value);
        }
      if (ProtectPeer.PRIORITY.equals(name))
        {
            return setByName("Priority", value);
        }
      if (ProtectPeer.RESOURCE_ID.equals(name))
        {
            return setByName("ResourceId", value);
        }
      if (ProtectPeer.COLOR.equals(name))
        {
            return setByName("Color", value);
        }
      if (ProtectPeer.STARTTIME.equals(name))
        {
            return setByName("Starttime", value);
        }
      if (ProtectPeer.ENDTIME.equals(name))
        {
            return setByName("Endtime", value);
        }
      if (ProtectPeer.STATUS.equals(name))
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
            return getManageType();
        }
        if (pos == 3)
        {
            return getPositions();
        }
        if (pos == 4)
        {
            return new Integer(getParent());
        }
        if (pos == 5)
        {
            return new Integer(getPriority());
        }
        if (pos == 6)
        {
            return new Integer(getResourceId());
        }
        if (pos == 7)
        {
            return new Integer(getColor());
        }
        if (pos == 8)
        {
            return getStarttime();
        }
        if (pos == 9)
        {
            return getEndtime();
        }
        if (pos == 10)
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
            return setByName("ManageType", value);
        }
    if (position == 3)
        {
            return setByName("Positions", value);
        }
    if (position == 4)
        {
            return setByName("Parent", value);
        }
    if (position == 5)
        {
            return setByName("Priority", value);
        }
    if (position == 6)
        {
            return setByName("ResourceId", value);
        }
    if (position == 7)
        {
            return setByName("Color", value);
        }
    if (position == 8)
        {
            return setByName("Starttime", value);
        }
    if (position == 9)
        {
            return setByName("Endtime", value);
        }
    if (position == 10)
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
        save(ProtectPeer.DATABASE_NAME);
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
                    ProtectPeer.doInsert((Protect) this, con);
                    setNew(false);
                }
                else
                {
                    ProtectPeer.doUpdate((Protect) this, con);
                }
            }


            if (collProtectAds != null)
            {
                for (int i = 0; i < collProtectAds.size(); i++)
                {
                    ((ProtectAd) collProtectAds.get(i)).save(con);
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
    public Protect copy() throws TorqueException
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
    public Protect copy(Connection con) throws TorqueException
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
    public Protect copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Protect(), deepcopy);
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
    public Protect copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Protect(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Protect copyInto(Protect copyObj) throws TorqueException
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
    protected Protect copyInto(Protect copyObj, Connection con) throws TorqueException
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
    protected Protect copyInto(Protect copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setManageType(manageType);
        copyObj.setPositions(positions);
        copyObj.setParent(parent);
        copyObj.setPriority(priority);
        copyObj.setResourceId(resourceId);
        copyObj.setColor(color);
        copyObj.setStarttime(starttime);
        copyObj.setEndtime(endtime);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<ProtectAd> vProtectAds = getProtectAds();
        if (vProtectAds != null)
        {
            for (int i = 0; i < vProtectAds.size(); i++)
            {
                ProtectAd obj =  vProtectAds.get(i);
                copyObj.addProtectAd(obj.copy());
            }
        }
        else
        {
            copyObj.collProtectAds = null;
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
    protected Protect copyInto(Protect copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setManageType(manageType);
        copyObj.setPositions(positions);
        copyObj.setParent(parent);
        copyObj.setPriority(priority);
        copyObj.setResourceId(resourceId);
        copyObj.setColor(color);
        copyObj.setStarttime(starttime);
        copyObj.setEndtime(endtime);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<ProtectAd> vProtectAds = getProtectAds(con);
        if (vProtectAds != null)
        {
            for (int i = 0; i < vProtectAds.size(); i++)
            {
                ProtectAd obj =  vProtectAds.get(i);
                copyObj.addProtectAd(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collProtectAds = null;
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
    public ProtectPeer getPeer()
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
        return ProtectPeer.getTableMap();
    }

  
    /**
     * Creates a ProtectBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a ProtectBean with the contents of this object
     */
    public ProtectBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a ProtectBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a ProtectBean with the contents of this object
     */
    public ProtectBean getBean(IdentityMap createdBeans)
    {
        ProtectBean result = (ProtectBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new ProtectBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setManageType(getManageType());
        result.setPositions(getPositions());
        result.setParent(getParent());
        result.setPriority(getPriority());
        result.setResourceId(getResourceId());
        result.setColor(getColor());
        result.setStarttime(getStarttime());
        result.setEndtime(getEndtime());
        result.setStatus(getStatus());



        if (collProtectAds != null)
        {
            List<ProtectAdBean> relatedBeans = new ArrayList<ProtectAdBean>(collProtectAds.size());
            for (Iterator<ProtectAd> collProtectAdsIt = collProtectAds.iterator(); collProtectAdsIt.hasNext(); )
            {
                ProtectAd related = (ProtectAd) collProtectAdsIt.next();
                ProtectAdBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setProtectAdBeans(relatedBeans);
        }




        if (aResource != null)
        {
            ResourceBean relatedBean = aResource.getBean(createdBeans);
            result.setResourceBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Protect with the contents
     * of a ProtectBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the ProtectBean which contents are used to create
     *        the resulting class
     * @return an instance of Protect with the contents of bean
     */
    public static Protect createProtect(ProtectBean bean)
        throws TorqueException
    {
        return createProtect(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Protect with the contents
     * of a ProtectBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the ProtectBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Protect with the contents of bean
     */

    public static Protect createProtect(ProtectBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Protect result = (Protect) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Protect();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setManageType(bean.getManageType());
        result.setPositions(bean.getPositions());
        result.setParent(bean.getParent());
        result.setPriority(bean.getPriority());
        result.setResourceId(bean.getResourceId());
        result.setColor(bean.getColor());
        result.setStarttime(bean.getStarttime());
        result.setEndtime(bean.getEndtime());
        result.setStatus(bean.getStatus());



        {
            List<ProtectAdBean> relatedBeans = bean.getProtectAdBeans();
            if (relatedBeans != null)
            {
                for (Iterator<ProtectAdBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    ProtectAdBean relatedBean =  relatedBeansIt.next();
                    ProtectAd related = ProtectAd.createProtectAd(relatedBean, createdObjects);
                    result.addProtectAdFromBean(related);
                }
            }
        }




        {
            ResourceBean relatedBean = bean.getResourceBean();
            if (relatedBean != null)
            {
                Resource relatedObject = Resource.createResource(relatedBean, createdObjects);
                result.setResource(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a ProtectAd object to this object.
     * through the ProtectAd foreign key attribute
     *
     * @param toAdd ProtectAd
     */
    protected void addProtectAdFromBean(ProtectAd toAdd)
    {
        initProtectAds();
        collProtectAds.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Protect:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("ManageType = ")
           .append(getManageType())
           .append("\n");
        str.append("Positions = ")
           .append(getPositions())
           .append("\n");
        str.append("Parent = ")
           .append(getParent())
           .append("\n");
        str.append("Priority = ")
           .append(getPriority())
           .append("\n");
        str.append("ResourceId = ")
           .append(getResourceId())
           .append("\n");
        str.append("Color = ")
           .append(getColor())
           .append("\n");
        str.append("Starttime = ")
           .append(getStarttime())
           .append("\n");
        str.append("Endtime = ")
           .append(getEndtime())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
