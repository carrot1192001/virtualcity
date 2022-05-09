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
import com.youku.atm.om.bean.AdMutexBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to AdMutex
 */
public abstract class BaseAdMutex extends BaseObject
{
    /** The Peer class */
    private static final AdMutexPeer peer =
        new AdMutexPeer();


    /** The value for the id field */
    private int id;

    /** The value for the mutexId field */
    private int mutexId;

    /** The value for the subjectType field */
    private int subjectType;

    /** The value for the subjectValue field */
    private String subjectValue;

    /** The value for the objectType field */
    private int objectType;

    /** The value for the objectValue field */
    private String objectValue;

    /** The value for the adType field */
    private String adType;

    /** The value for the subAdType field */
    private String subAdType;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the startTime field */
    private Date startTime;

    /** The value for the endTime field */
    private Date endTime;

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
    public void setId(int v) 
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
        }


    }

    /**
     * Get the MutexId
     *
     * @return int
     */
    public int getMutexId()
    {
        return mutexId;
    }


    /**
     * Set the value of MutexId
     *
     * @param v new value
     */
    public void setMutexId(int v) 
    {

        if (this.mutexId != v)
        {
            this.mutexId = v;
            setModified(true);
        }


    }

    /**
     * Get the SubjectType
     *
     * @return int
     */
    public int getSubjectType()
    {
        return subjectType;
    }


    /**
     * Set the value of SubjectType
     *
     * @param v new value
     */
    public void setSubjectType(int v) 
    {

        if (this.subjectType != v)
        {
            this.subjectType = v;
            setModified(true);
        }


    }

    /**
     * Get the SubjectValue
     *
     * @return String
     */
    public String getSubjectValue()
    {
        return subjectValue;
    }


    /**
     * Set the value of SubjectValue
     *
     * @param v new value
     */
    public void setSubjectValue(String v) 
    {

        if (!ObjectUtils.equals(this.subjectValue, v))
        {
            this.subjectValue = v;
            setModified(true);
        }


    }

    /**
     * Get the ObjectType
     *
     * @return int
     */
    public int getObjectType()
    {
        return objectType;
    }


    /**
     * Set the value of ObjectType
     *
     * @param v new value
     */
    public void setObjectType(int v) 
    {

        if (this.objectType != v)
        {
            this.objectType = v;
            setModified(true);
        }


    }

    /**
     * Get the ObjectValue
     *
     * @return String
     */
    public String getObjectValue()
    {
        return objectValue;
    }


    /**
     * Set the value of ObjectValue
     *
     * @param v new value
     */
    public void setObjectValue(String v) 
    {

        if (!ObjectUtils.equals(this.objectValue, v))
        {
            this.objectValue = v;
            setModified(true);
        }


    }

    /**
     * Get the AdType
     *
     * @return String
     */
    public String getAdType()
    {
        return adType;
    }


    /**
     * Set the value of AdType
     *
     * @param v new value
     */
    public void setAdType(String v) 
    {

        if (!ObjectUtils.equals(this.adType, v))
        {
            this.adType = v;
            setModified(true);
        }


    }

    /**
     * Get the SubAdType
     *
     * @return String
     */
    public String getSubAdType()
    {
        return subAdType;
    }


    /**
     * Set the value of SubAdType
     *
     * @param v new value
     */
    public void setSubAdType(String v) 
    {

        if (!ObjectUtils.equals(this.subAdType, v))
        {
            this.subAdType = v;
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
     * Get the StartTime
     *
     * @return Date
     */
    public Date getStartTime()
    {
        return startTime;
    }


    /**
     * Set the value of StartTime
     *
     * @param v new value
     */
    public void setStartTime(Date v) 
    {

        if (!ObjectUtils.equals(this.startTime, v))
        {
            this.startTime = v;
            setModified(true);
        }


    }

    /**
     * Get the EndTime
     *
     * @return Date
     */
    public Date getEndTime()
    {
        return endTime;
    }


    /**
     * Set the value of EndTime
     *
     * @param v new value
     */
    public void setEndTime(Date v) 
    {

        if (!ObjectUtils.equals(this.endTime, v))
        {
            this.endTime = v;
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
            fieldNames.add("MutexId");
            fieldNames.add("SubjectType");
            fieldNames.add("SubjectValue");
            fieldNames.add("ObjectType");
            fieldNames.add("ObjectValue");
            fieldNames.add("AdType");
            fieldNames.add("SubAdType");
            fieldNames.add("UpdateTime");
            fieldNames.add("StartTime");
            fieldNames.add("EndTime");
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
        if (name.equals("MutexId"))
        {
            return new Integer(getMutexId());
        }
        if (name.equals("SubjectType"))
        {
            return new Integer(getSubjectType());
        }
        if (name.equals("SubjectValue"))
        {
            return getSubjectValue();
        }
        if (name.equals("ObjectType"))
        {
            return new Integer(getObjectType());
        }
        if (name.equals("ObjectValue"))
        {
            return getObjectValue();
        }
        if (name.equals("AdType"))
        {
            return getAdType();
        }
        if (name.equals("SubAdType"))
        {
            return getSubAdType();
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("StartTime"))
        {
            return getStartTime();
        }
        if (name.equals("EndTime"))
        {
            return getEndTime();
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
        if (name.equals("MutexId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMutexId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SubjectType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSubjectType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SubjectValue"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSubjectValue((String) value);
            return true;
        }
        if (name.equals("ObjectType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setObjectType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ObjectValue"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setObjectValue((String) value);
            return true;
        }
        if (name.equals("AdType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setAdType((String) value);
            return true;
        }
        if (name.equals("SubAdType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSubAdType((String) value);
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
        if (name.equals("StartTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStartTime((Date) value);
            return true;
        }
        if (name.equals("EndTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEndTime((Date) value);
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
        if (name.equals(AdMutexPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(AdMutexPeer.MUTEX_ID))
        {
            return new Integer(getMutexId());
        }
        if (name.equals(AdMutexPeer.SUBJECT_TYPE))
        {
            return new Integer(getSubjectType());
        }
        if (name.equals(AdMutexPeer.SUBJECT_VALUE))
        {
            return getSubjectValue();
        }
        if (name.equals(AdMutexPeer.OBJECT_TYPE))
        {
            return new Integer(getObjectType());
        }
        if (name.equals(AdMutexPeer.OBJECT_VALUE))
        {
            return getObjectValue();
        }
        if (name.equals(AdMutexPeer.AD_TYPE))
        {
            return getAdType();
        }
        if (name.equals(AdMutexPeer.SUB_AD_TYPE))
        {
            return getSubAdType();
        }
        if (name.equals(AdMutexPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(AdMutexPeer.START_TIME))
        {
            return getStartTime();
        }
        if (name.equals(AdMutexPeer.END_TIME))
        {
            return getEndTime();
        }
        if (name.equals(AdMutexPeer.STATUS))
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
      if (AdMutexPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (AdMutexPeer.MUTEX_ID.equals(name))
        {
            return setByName("MutexId", value);
        }
      if (AdMutexPeer.SUBJECT_TYPE.equals(name))
        {
            return setByName("SubjectType", value);
        }
      if (AdMutexPeer.SUBJECT_VALUE.equals(name))
        {
            return setByName("SubjectValue", value);
        }
      if (AdMutexPeer.OBJECT_TYPE.equals(name))
        {
            return setByName("ObjectType", value);
        }
      if (AdMutexPeer.OBJECT_VALUE.equals(name))
        {
            return setByName("ObjectValue", value);
        }
      if (AdMutexPeer.AD_TYPE.equals(name))
        {
            return setByName("AdType", value);
        }
      if (AdMutexPeer.SUB_AD_TYPE.equals(name))
        {
            return setByName("SubAdType", value);
        }
      if (AdMutexPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (AdMutexPeer.START_TIME.equals(name))
        {
            return setByName("StartTime", value);
        }
      if (AdMutexPeer.END_TIME.equals(name))
        {
            return setByName("EndTime", value);
        }
      if (AdMutexPeer.STATUS.equals(name))
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
            return new Integer(getMutexId());
        }
        if (pos == 2)
        {
            return new Integer(getSubjectType());
        }
        if (pos == 3)
        {
            return getSubjectValue();
        }
        if (pos == 4)
        {
            return new Integer(getObjectType());
        }
        if (pos == 5)
        {
            return getObjectValue();
        }
        if (pos == 6)
        {
            return getAdType();
        }
        if (pos == 7)
        {
            return getSubAdType();
        }
        if (pos == 8)
        {
            return getUpdateTime();
        }
        if (pos == 9)
        {
            return getStartTime();
        }
        if (pos == 10)
        {
            return getEndTime();
        }
        if (pos == 11)
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
            return setByName("MutexId", value);
        }
    if (position == 2)
        {
            return setByName("SubjectType", value);
        }
    if (position == 3)
        {
            return setByName("SubjectValue", value);
        }
    if (position == 4)
        {
            return setByName("ObjectType", value);
        }
    if (position == 5)
        {
            return setByName("ObjectValue", value);
        }
    if (position == 6)
        {
            return setByName("AdType", value);
        }
    if (position == 7)
        {
            return setByName("SubAdType", value);
        }
    if (position == 8)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 9)
        {
            return setByName("StartTime", value);
        }
    if (position == 10)
        {
            return setByName("EndTime", value);
        }
    if (position == 11)
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
        save(AdMutexPeer.DATABASE_NAME);
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
                    AdMutexPeer.doInsert((AdMutex) this, con);
                    setNew(false);
                }
                else
                {
                    AdMutexPeer.doUpdate((AdMutex) this, con);
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
        
    {
        setId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
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
    public AdMutex copy() throws TorqueException
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
    public AdMutex copy(Connection con) throws TorqueException
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
    public AdMutex copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new AdMutex(), deepcopy);
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
    public AdMutex copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new AdMutex(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected AdMutex copyInto(AdMutex copyObj) throws TorqueException
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
    protected AdMutex copyInto(AdMutex copyObj, Connection con) throws TorqueException
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
    protected AdMutex copyInto(AdMutex copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setMutexId(mutexId);
        copyObj.setSubjectType(subjectType);
        copyObj.setSubjectValue(subjectValue);
        copyObj.setObjectType(objectType);
        copyObj.setObjectValue(objectValue);
        copyObj.setAdType(adType);
        copyObj.setSubAdType(subAdType);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStartTime(startTime);
        copyObj.setEndTime(endTime);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {
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
    protected AdMutex copyInto(AdMutex copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setMutexId(mutexId);
        copyObj.setSubjectType(subjectType);
        copyObj.setSubjectValue(subjectValue);
        copyObj.setObjectType(objectType);
        copyObj.setObjectValue(objectValue);
        copyObj.setAdType(adType);
        copyObj.setSubAdType(subAdType);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStartTime(startTime);
        copyObj.setEndTime(endTime);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public AdMutexPeer getPeer()
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
        return AdMutexPeer.getTableMap();
    }

  
    /**
     * Creates a AdMutexBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a AdMutexBean with the contents of this object
     */
    public AdMutexBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a AdMutexBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a AdMutexBean with the contents of this object
     */
    public AdMutexBean getBean(IdentityMap createdBeans)
    {
        AdMutexBean result = (AdMutexBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new AdMutexBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setMutexId(getMutexId());
        result.setSubjectType(getSubjectType());
        result.setSubjectValue(getSubjectValue());
        result.setObjectType(getObjectType());
        result.setObjectValue(getObjectValue());
        result.setAdType(getAdType());
        result.setSubAdType(getSubAdType());
        result.setUpdateTime(getUpdateTime());
        result.setStartTime(getStartTime());
        result.setEndTime(getEndTime());
        result.setStatus(getStatus());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of AdMutex with the contents
     * of a AdMutexBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the AdMutexBean which contents are used to create
     *        the resulting class
     * @return an instance of AdMutex with the contents of bean
     */
    public static AdMutex createAdMutex(AdMutexBean bean)
        throws TorqueException
    {
        return createAdMutex(bean, new IdentityMap());
    }

    /**
     * Creates an instance of AdMutex with the contents
     * of a AdMutexBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the AdMutexBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of AdMutex with the contents of bean
     */

    public static AdMutex createAdMutex(AdMutexBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        AdMutex result = (AdMutex) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new AdMutex();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setMutexId(bean.getMutexId());
        result.setSubjectType(bean.getSubjectType());
        result.setSubjectValue(bean.getSubjectValue());
        result.setObjectType(bean.getObjectType());
        result.setObjectValue(bean.getObjectValue());
        result.setAdType(bean.getAdType());
        result.setSubAdType(bean.getSubAdType());
        result.setUpdateTime(bean.getUpdateTime());
        result.setStartTime(bean.getStartTime());
        result.setEndTime(bean.getEndTime());
        result.setStatus(bean.getStatus());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("AdMutex:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("MutexId = ")
           .append(getMutexId())
           .append("\n");
        str.append("SubjectType = ")
           .append(getSubjectType())
           .append("\n");
        str.append("SubjectValue = ")
           .append(getSubjectValue())
           .append("\n");
        str.append("ObjectType = ")
           .append(getObjectType())
           .append("\n");
        str.append("ObjectValue = ")
           .append(getObjectValue())
           .append("\n");
        str.append("AdType = ")
           .append(getAdType())
           .append("\n");
        str.append("SubAdType = ")
           .append(getSubAdType())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("StartTime = ")
           .append(getStartTime())
           .append("\n");
        str.append("EndTime = ")
           .append(getEndTime())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
