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
import com.youku.atm.om.bean.VideoGroupListBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to VideoGroupList
 */
public abstract class BaseVideoGroupList extends BaseObject
{
    /** The Peer class */
    private static final VideoGroupListPeer peer =
        new VideoGroupListPeer();


    /** The value for the id field */
    private int id;

    /** The value for the type field */
    private int type;

    /** The value for the value field */
    private String value;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the startTime field */
    private Date startTime;

    /** The value for the endTime field */
    private Date endTime;

    /** The value for the videoGroupId field */
    private int videoGroupId;

    /** The value for the status field */
    private int status;


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
     * Get the Value
     *
     * @return String
     */
    public String getValue()
    {
        return value;
    }


    /**
     * Set the value of Value
     *
     * @param v new value
     */
    public void setValue(String v) 
    {

        if (!ObjectUtils.equals(this.value, v))
        {
            this.value = v;
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
     * Get the VideoGroupId
     *
     * @return int
     */
    public int getVideoGroupId()
    {
        return videoGroupId;
    }


    /**
     * Set the value of VideoGroupId
     *
     * @param v new value
     */
    public void setVideoGroupId(int v) 
    {

        if (this.videoGroupId != v)
        {
            this.videoGroupId = v;
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
            fieldNames.add("Type");
            fieldNames.add("Value");
            fieldNames.add("UpdateTime");
            fieldNames.add("StartTime");
            fieldNames.add("EndTime");
            fieldNames.add("VideoGroupId");
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
        if (name.equals("Type"))
        {
            return new Integer(getType());
        }
        if (name.equals("Value"))
        {
            return getValue();
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
        if (name.equals("VideoGroupId"))
        {
            return new Integer(getVideoGroupId());
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
        if (name.equals("Type"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Value"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setValue((String) value);
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
        if (name.equals("VideoGroupId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setVideoGroupId(((Integer) value).intValue());
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
        if (name.equals(VideoGroupListPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(VideoGroupListPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(VideoGroupListPeer.VALUE))
        {
            return getValue();
        }
        if (name.equals(VideoGroupListPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(VideoGroupListPeer.START_TIME))
        {
            return getStartTime();
        }
        if (name.equals(VideoGroupListPeer.END_TIME))
        {
            return getEndTime();
        }
        if (name.equals(VideoGroupListPeer.VIDEO_GROUP_ID))
        {
            return new Integer(getVideoGroupId());
        }
        if (name.equals(VideoGroupListPeer.STATUS))
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
      if (VideoGroupListPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (VideoGroupListPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (VideoGroupListPeer.VALUE.equals(name))
        {
            return setByName("Value", value);
        }
      if (VideoGroupListPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (VideoGroupListPeer.START_TIME.equals(name))
        {
            return setByName("StartTime", value);
        }
      if (VideoGroupListPeer.END_TIME.equals(name))
        {
            return setByName("EndTime", value);
        }
      if (VideoGroupListPeer.VIDEO_GROUP_ID.equals(name))
        {
            return setByName("VideoGroupId", value);
        }
      if (VideoGroupListPeer.STATUS.equals(name))
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
            return new Integer(getType());
        }
        if (pos == 2)
        {
            return getValue();
        }
        if (pos == 3)
        {
            return getUpdateTime();
        }
        if (pos == 4)
        {
            return getStartTime();
        }
        if (pos == 5)
        {
            return getEndTime();
        }
        if (pos == 6)
        {
            return new Integer(getVideoGroupId());
        }
        if (pos == 7)
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
            return setByName("Type", value);
        }
    if (position == 2)
        {
            return setByName("Value", value);
        }
    if (position == 3)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 4)
        {
            return setByName("StartTime", value);
        }
    if (position == 5)
        {
            return setByName("EndTime", value);
        }
    if (position == 6)
        {
            return setByName("VideoGroupId", value);
        }
    if (position == 7)
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
        save(VideoGroupListPeer.DATABASE_NAME);
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
                    VideoGroupListPeer.doInsert((VideoGroupList) this, con);
                    setNew(false);
                }
                else
                {
                    VideoGroupListPeer.doUpdate((VideoGroupList) this, con);
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
    public VideoGroupList copy() throws TorqueException
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
    public VideoGroupList copy(Connection con) throws TorqueException
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
    public VideoGroupList copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new VideoGroupList(), deepcopy);
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
    public VideoGroupList copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new VideoGroupList(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected VideoGroupList copyInto(VideoGroupList copyObj) throws TorqueException
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
    protected VideoGroupList copyInto(VideoGroupList copyObj, Connection con) throws TorqueException
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
    protected VideoGroupList copyInto(VideoGroupList copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setType(type);
        copyObj.setValue(value);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStartTime(startTime);
        copyObj.setEndTime(endTime);
        copyObj.setVideoGroupId(videoGroupId);
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
    protected VideoGroupList copyInto(VideoGroupList copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setType(type);
        copyObj.setValue(value);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStartTime(startTime);
        copyObj.setEndTime(endTime);
        copyObj.setVideoGroupId(videoGroupId);
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
    public VideoGroupListPeer getPeer()
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
        return VideoGroupListPeer.getTableMap();
    }

  
    /**
     * Creates a VideoGroupListBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a VideoGroupListBean with the contents of this object
     */
    public VideoGroupListBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a VideoGroupListBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a VideoGroupListBean with the contents of this object
     */
    public VideoGroupListBean getBean(IdentityMap createdBeans)
    {
        VideoGroupListBean result = (VideoGroupListBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new VideoGroupListBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setType(getType());
        result.setValue(getValue());
        result.setUpdateTime(getUpdateTime());
        result.setStartTime(getStartTime());
        result.setEndTime(getEndTime());
        result.setVideoGroupId(getVideoGroupId());
        result.setStatus(getStatus());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of VideoGroupList with the contents
     * of a VideoGroupListBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the VideoGroupListBean which contents are used to create
     *        the resulting class
     * @return an instance of VideoGroupList with the contents of bean
     */
    public static VideoGroupList createVideoGroupList(VideoGroupListBean bean)
        throws TorqueException
    {
        return createVideoGroupList(bean, new IdentityMap());
    }

    /**
     * Creates an instance of VideoGroupList with the contents
     * of a VideoGroupListBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the VideoGroupListBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of VideoGroupList with the contents of bean
     */

    public static VideoGroupList createVideoGroupList(VideoGroupListBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        VideoGroupList result = (VideoGroupList) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new VideoGroupList();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setType(bean.getType());
        result.setValue(bean.getValue());
        result.setUpdateTime(bean.getUpdateTime());
        result.setStartTime(bean.getStartTime());
        result.setEndTime(bean.getEndTime());
        result.setVideoGroupId(bean.getVideoGroupId());
        result.setStatus(bean.getStatus());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("VideoGroupList:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("Value = ")
           .append(getValue())
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
        str.append("VideoGroupId = ")
           .append(getVideoGroupId())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
