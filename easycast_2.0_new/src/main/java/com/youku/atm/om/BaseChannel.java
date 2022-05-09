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
import com.youku.atm.om.bean.ChannelBean;

import com.youku.atm.om.bean.CastChannelBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Channel
 */
public abstract class BaseChannel extends BaseObject
{
    /** The Peer class */
    private static final ChannelPeer peer =
        new ChannelPeer();


    /** The value for the id field */
    private String id;

    /** The value for the parentId field */
    private String parentId;

    /** The value for the type field */
    private String type;

    /** The value for the name field */
    private String name;

    /** The value for the isHot field */
    private int isHot = 0;

    /** The value for the status field */
    private int status = 1;

    /** The value for the refvalue field */
    private String refvalue;

    /** The value for the description field */
    private String description;


    /**
     * Get the Id
     *
     * @return String
     */
    public String getId()
    {
        return id;
    }


    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(String v) throws TorqueException
    {

        if (!ObjectUtils.equals(this.id, v))
        {
            this.id = v;
            setModified(true);
        }



        // update associated CastChannel
        if (collCastChannels != null)
        {
            for (int i = 0; i < collCastChannels.size(); i++)
            {
                ((CastChannel) collCastChannels.get(i))
                        .setDirectValue(v);
            }
        }
    }

    /**
     * Get the ParentId
     *
     * @return String
     */
    public String getParentId()
    {
        return parentId;
    }


    /**
     * Set the value of ParentId
     *
     * @param v new value
     */
    public void setParentId(String v) 
    {

        if (!ObjectUtils.equals(this.parentId, v))
        {
            this.parentId = v;
            setModified(true);
        }


    }

    /**
     * Get the Type
     *
     * @return String
     */
    public String getType()
    {
        return type;
    }


    /**
     * Set the value of Type
     *
     * @param v new value
     */
    public void setType(String v) 
    {

        if (!ObjectUtils.equals(this.type, v))
        {
            this.type = v;
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
     * Get the IsHot
     *
     * @return int
     */
    public int getIsHot()
    {
        return isHot;
    }


    /**
     * Set the value of IsHot
     *
     * @param v new value
     */
    public void setIsHot(int v) 
    {

        if (this.isHot != v)
        {
            this.isHot = v;
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
     * Get the Refvalue
     *
     * @return String
     */
    public String getRefvalue()
    {
        return refvalue;
    }


    /**
     * Set the value of Refvalue
     *
     * @param v new value
     */
    public void setRefvalue(String v) 
    {

        if (!ObjectUtils.equals(this.refvalue, v))
        {
            this.refvalue = v;
            setModified(true);
        }


    }

    /**
     * Get the Description
     *
     * @return String
     */
    public String getDescription()
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

        if (!ObjectUtils.equals(this.description, v))
        {
            this.description = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collCastChannels
     */
    protected List<CastChannel> collCastChannels;

    /**
     * Temporary storage of collCastChannels to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastChannels()
    {
        if (collCastChannels == null)
        {
            collCastChannels = new ArrayList<CastChannel>();
        }
    }


    /**
     * Method called to associate a CastChannel object to this object
     * through the CastChannel foreign key attribute
     *
     * @param l CastChannel
     * @throws TorqueException
     */
    public void addCastChannel(CastChannel l) throws TorqueException
    {
        getCastChannels().add(l);
        l.setChannel((Channel) this);
    }

    /**
     * Method called to associate a CastChannel object to this object
     * through the CastChannel foreign key attribute using connection.
     *
     * @param l CastChannel
     * @throws TorqueException
     */
    public void addCastChannel(CastChannel l, Connection con) throws TorqueException
    {
        getCastChannels(con).add(l);
        l.setChannel((Channel) this);
    }

    /**
     * The criteria used to select the current contents of collCastChannels
     */
    private Criteria lastCastChannelsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastChannels(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastChannel> getCastChannels()
        throws TorqueException
    {
        if (collCastChannels == null)
        {
            collCastChannels = getCastChannels(new Criteria(10));
        }
        return collCastChannels;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Channel has previously
     * been saved, it will retrieve related CastChannels from storage.
     * If this Channel is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastChannel> getCastChannels(Criteria criteria) throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                criteria.add(CastChannelPeer.DIRECT_VALUE, getId() );
                collCastChannels = CastChannelPeer.doSelect(criteria);
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
                criteria.add(CastChannelPeer.DIRECT_VALUE, getId());
                if (!lastCastChannelsCriteria.equals(criteria))
                {
                    collCastChannels = CastChannelPeer.doSelect(criteria);
                }
            }
        }
        lastCastChannelsCriteria = criteria;

        return collCastChannels;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastChannels(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastChannel> getCastChannels(Connection con) throws TorqueException
    {
        if (collCastChannels == null)
        {
            collCastChannels = getCastChannels(new Criteria(10), con);
        }
        return collCastChannels;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Channel has previously
     * been saved, it will retrieve related CastChannels from storage.
     * If this Channel is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastChannel> getCastChannels(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                 criteria.add(CastChannelPeer.DIRECT_VALUE, getId());
                 collCastChannels = CastChannelPeer.doSelect(criteria, con);
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
                 criteria.add(CastChannelPeer.DIRECT_VALUE, getId());
                 if (!lastCastChannelsCriteria.equals(criteria))
                 {
                     collCastChannels = CastChannelPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastChannelsCriteria = criteria;

         return collCastChannels;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Channel is new, it will return
     * an empty collection; or if this Channel has previously
     * been saved, it will retrieve related CastChannels from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Channel.
     */
    protected List<CastChannel> getCastChannelsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                criteria.add(CastChannelPeer.DIRECT_VALUE, getId());
                collCastChannels = CastChannelPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastChannelPeer.DIRECT_VALUE, getId());
            if (!lastCastChannelsCriteria.equals(criteria))
            {
                collCastChannels = CastChannelPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastChannelsCriteria = criteria;

        return collCastChannels;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Channel is new, it will return
     * an empty collection; or if this Channel has previously
     * been saved, it will retrieve related CastChannels from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Channel.
     */
    protected List<CastChannel> getCastChannelsJoinChannel(Criteria criteria)
        throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                criteria.add(CastChannelPeer.DIRECT_VALUE, getId());
                collCastChannels = CastChannelPeer.doSelectJoinChannel(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastChannelPeer.DIRECT_VALUE, getId());
            if (!lastCastChannelsCriteria.equals(criteria))
            {
                collCastChannels = CastChannelPeer.doSelectJoinChannel(criteria);
            }
        }
        lastCastChannelsCriteria = criteria;

        return collCastChannels;
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
            fieldNames.add("ParentId");
            fieldNames.add("Type");
            fieldNames.add("Name");
            fieldNames.add("IsHot");
            fieldNames.add("Status");
            fieldNames.add("Refvalue");
            fieldNames.add("Description");
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
            return getId();
        }
        if (name.equals("ParentId"))
        {
            return getParentId();
        }
        if (name.equals("Type"))
        {
            return getType();
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("IsHot"))
        {
            return new Integer(getIsHot());
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("Refvalue"))
        {
            return getRefvalue();
        }
        if (name.equals("Description"))
        {
            return getDescription();
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
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setId((String) value);
            return true;
        }
        if (name.equals("ParentId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setParentId((String) value);
            return true;
        }
        if (name.equals("Type"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setType((String) value);
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
        if (name.equals("IsHot"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsHot(((Integer) value).intValue());
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
        if (name.equals("Refvalue"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setRefvalue((String) value);
            return true;
        }
        if (name.equals("Description"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDescription((String) value);
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
        if (name.equals(ChannelPeer.ID))
        {
            return getId();
        }
        if (name.equals(ChannelPeer.PARENT_ID))
        {
            return getParentId();
        }
        if (name.equals(ChannelPeer.TYPE))
        {
            return getType();
        }
        if (name.equals(ChannelPeer.NAME))
        {
            return getName();
        }
        if (name.equals(ChannelPeer.IS_HOT))
        {
            return new Integer(getIsHot());
        }
        if (name.equals(ChannelPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(ChannelPeer.REFVALUE))
        {
            return getRefvalue();
        }
        if (name.equals(ChannelPeer.DESCRIPTION))
        {
            return getDescription();
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
      if (ChannelPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (ChannelPeer.PARENT_ID.equals(name))
        {
            return setByName("ParentId", value);
        }
      if (ChannelPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (ChannelPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (ChannelPeer.IS_HOT.equals(name))
        {
            return setByName("IsHot", value);
        }
      if (ChannelPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (ChannelPeer.REFVALUE.equals(name))
        {
            return setByName("Refvalue", value);
        }
      if (ChannelPeer.DESCRIPTION.equals(name))
        {
            return setByName("Description", value);
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
            return getId();
        }
        if (pos == 1)
        {
            return getParentId();
        }
        if (pos == 2)
        {
            return getType();
        }
        if (pos == 3)
        {
            return getName();
        }
        if (pos == 4)
        {
            return new Integer(getIsHot());
        }
        if (pos == 5)
        {
            return new Integer(getStatus());
        }
        if (pos == 6)
        {
            return getRefvalue();
        }
        if (pos == 7)
        {
            return getDescription();
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
            return setByName("ParentId", value);
        }
    if (position == 2)
        {
            return setByName("Type", value);
        }
    if (position == 3)
        {
            return setByName("Name", value);
        }
    if (position == 4)
        {
            return setByName("IsHot", value);
        }
    if (position == 5)
        {
            return setByName("Status", value);
        }
    if (position == 6)
        {
            return setByName("Refvalue", value);
        }
    if (position == 7)
        {
            return setByName("Description", value);
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
        save(ChannelPeer.DATABASE_NAME);
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
                    ChannelPeer.doInsert((Channel) this, con);
                    setNew(false);
                }
                else
                {
                    ChannelPeer.doUpdate((Channel) this, con);
                }
            }


            if (collCastChannels != null)
            {
                for (int i = 0; i < collCastChannels.size(); i++)
                {
                    ((CastChannel) collCastChannels.get(i)).save(con);
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
        setId(key.toString());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setId(key);
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
    public Channel copy() throws TorqueException
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
    public Channel copy(Connection con) throws TorqueException
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
    public Channel copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Channel(), deepcopy);
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
    public Channel copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Channel(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Channel copyInto(Channel copyObj) throws TorqueException
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
    protected Channel copyInto(Channel copyObj, Connection con) throws TorqueException
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
    protected Channel copyInto(Channel copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setType(type);
        copyObj.setName(name);
        copyObj.setIsHot(isHot);
        copyObj.setStatus(status);
        copyObj.setRefvalue(refvalue);
        copyObj.setDescription(description);

        copyObj.setId((String)null);

        if (deepcopy)
        {


        List<CastChannel> vCastChannels = getCastChannels();
        if (vCastChannels != null)
        {
            for (int i = 0; i < vCastChannels.size(); i++)
            {
                CastChannel obj =  vCastChannels.get(i);
                copyObj.addCastChannel(obj.copy());
            }
        }
        else
        {
            copyObj.collCastChannels = null;
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
    protected Channel copyInto(Channel copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setType(type);
        copyObj.setName(name);
        copyObj.setIsHot(isHot);
        copyObj.setStatus(status);
        copyObj.setRefvalue(refvalue);
        copyObj.setDescription(description);

        copyObj.setId((String)null);

        if (deepcopy)
        {


        List<CastChannel> vCastChannels = getCastChannels(con);
        if (vCastChannels != null)
        {
            for (int i = 0; i < vCastChannels.size(); i++)
            {
                CastChannel obj =  vCastChannels.get(i);
                copyObj.addCastChannel(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastChannels = null;
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
    public ChannelPeer getPeer()
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
        return ChannelPeer.getTableMap();
    }

  
    /**
     * Creates a ChannelBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a ChannelBean with the contents of this object
     */
    public ChannelBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a ChannelBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a ChannelBean with the contents of this object
     */
    public ChannelBean getBean(IdentityMap createdBeans)
    {
        ChannelBean result = (ChannelBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new ChannelBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setParentId(getParentId());
        result.setType(getType());
        result.setName(getName());
        result.setIsHot(getIsHot());
        result.setStatus(getStatus());
        result.setRefvalue(getRefvalue());
        result.setDescription(getDescription());



        if (collCastChannels != null)
        {
            List<CastChannelBean> relatedBeans = new ArrayList<CastChannelBean>(collCastChannels.size());
            for (Iterator<CastChannel> collCastChannelsIt = collCastChannels.iterator(); collCastChannelsIt.hasNext(); )
            {
                CastChannel related = (CastChannel) collCastChannelsIt.next();
                CastChannelBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastChannelBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Channel with the contents
     * of a ChannelBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the ChannelBean which contents are used to create
     *        the resulting class
     * @return an instance of Channel with the contents of bean
     */
    public static Channel createChannel(ChannelBean bean)
        throws TorqueException
    {
        return createChannel(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Channel with the contents
     * of a ChannelBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the ChannelBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Channel with the contents of bean
     */

    public static Channel createChannel(ChannelBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Channel result = (Channel) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Channel();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setParentId(bean.getParentId());
        result.setType(bean.getType());
        result.setName(bean.getName());
        result.setIsHot(bean.getIsHot());
        result.setStatus(bean.getStatus());
        result.setRefvalue(bean.getRefvalue());
        result.setDescription(bean.getDescription());



        {
            List<CastChannelBean> relatedBeans = bean.getCastChannelBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastChannelBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastChannelBean relatedBean =  relatedBeansIt.next();
                    CastChannel related = CastChannel.createCastChannel(relatedBean, createdObjects);
                    result.addCastChannelFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a CastChannel object to this object.
     * through the CastChannel foreign key attribute
     *
     * @param toAdd CastChannel
     */
    protected void addCastChannelFromBean(CastChannel toAdd)
    {
        initCastChannels();
        collCastChannels.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Channel:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ParentId = ")
           .append(getParentId())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("IsHot = ")
           .append(getIsHot())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("Refvalue = ")
           .append(getRefvalue())
           .append("\n");
        str.append("Description = ")
           .append(getDescription())
           .append("\n");
        return(str.toString());
    }
}
