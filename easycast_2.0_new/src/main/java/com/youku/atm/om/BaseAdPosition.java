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
import com.youku.atm.om.bean.AdPositionBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to AdPosition
 */
public abstract class BaseAdPosition extends BaseObject
{
    /** The Peer class */
    private static final AdPositionPeer peer =
        new AdPositionPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the media field */
    private String media;

    /** The value for the device field */
    private String device;

    /** The value for the type field */
    private String type;

    /** The value for the posType field */
    private String posType;

    /** The value for the posSubType field */
    private String posSubType;

    /** The value for the reqPoint field */
    private String reqPoint;

    /** The value for the pageComment field */
    private String pageComment;

    /** The value for the place field */
    private String place;

    /** The value for the pageSize field */
    private String pageSize;

    /** The value for the template field */
    private String template;

    /** The value for the seqNum field */
    private String seqNum;

    /** The value for the oldId field */
    private String oldId;

    /** The value for the value field */
    private String value;

    /** The value for the updateTime field */
    private String updateTime;

    /** The value for the status field */
    private String status;


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
     * Get the Media
     *
     * @return String
     */
    public String getMedia()
    {
        return media;
    }


    /**
     * Set the value of Media
     *
     * @param v new value
     */
    public void setMedia(String v) 
    {

        if (!ObjectUtils.equals(this.media, v))
        {
            this.media = v;
            setModified(true);
        }


    }

    /**
     * Get the Device
     *
     * @return String
     */
    public String getDevice()
    {
        return device;
    }


    /**
     * Set the value of Device
     *
     * @param v new value
     */
    public void setDevice(String v) 
    {

        if (!ObjectUtils.equals(this.device, v))
        {
            this.device = v;
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
     * Get the PosType
     *
     * @return String
     */
    public String getPosType()
    {
        return posType;
    }


    /**
     * Set the value of PosType
     *
     * @param v new value
     */
    public void setPosType(String v) 
    {

        if (!ObjectUtils.equals(this.posType, v))
        {
            this.posType = v;
            setModified(true);
        }


    }

    /**
     * Get the PosSubType
     *
     * @return String
     */
    public String getPosSubType()
    {
        return posSubType;
    }


    /**
     * Set the value of PosSubType
     *
     * @param v new value
     */
    public void setPosSubType(String v) 
    {

        if (!ObjectUtils.equals(this.posSubType, v))
        {
            this.posSubType = v;
            setModified(true);
        }


    }

    /**
     * Get the ReqPoint
     *
     * @return String
     */
    public String getReqPoint()
    {
        return reqPoint;
    }


    /**
     * Set the value of ReqPoint
     *
     * @param v new value
     */
    public void setReqPoint(String v) 
    {

        if (!ObjectUtils.equals(this.reqPoint, v))
        {
            this.reqPoint = v;
            setModified(true);
        }


    }

    /**
     * Get the PageComment
     *
     * @return String
     */
    public String getPageComment()
    {
        return pageComment;
    }


    /**
     * Set the value of PageComment
     *
     * @param v new value
     */
    public void setPageComment(String v) 
    {

        if (!ObjectUtils.equals(this.pageComment, v))
        {
            this.pageComment = v;
            setModified(true);
        }


    }

    /**
     * Get the Place
     *
     * @return String
     */
    public String getPlace()
    {
        return place;
    }


    /**
     * Set the value of Place
     *
     * @param v new value
     */
    public void setPlace(String v) 
    {

        if (!ObjectUtils.equals(this.place, v))
        {
            this.place = v;
            setModified(true);
        }


    }

    /**
     * Get the PageSize
     *
     * @return String
     */
    public String getPageSize()
    {
        return pageSize;
    }


    /**
     * Set the value of PageSize
     *
     * @param v new value
     */
    public void setPageSize(String v) 
    {

        if (!ObjectUtils.equals(this.pageSize, v))
        {
            this.pageSize = v;
            setModified(true);
        }


    }

    /**
     * Get the Template
     *
     * @return String
     */
    public String getTemplate()
    {
        return template;
    }


    /**
     * Set the value of Template
     *
     * @param v new value
     */
    public void setTemplate(String v) 
    {

        if (!ObjectUtils.equals(this.template, v))
        {
            this.template = v;
            setModified(true);
        }


    }

    /**
     * Get the SeqNum
     *
     * @return String
     */
    public String getSeqNum()
    {
        return seqNum;
    }


    /**
     * Set the value of SeqNum
     *
     * @param v new value
     */
    public void setSeqNum(String v) 
    {

        if (!ObjectUtils.equals(this.seqNum, v))
        {
            this.seqNum = v;
            setModified(true);
        }


    }

    /**
     * Get the OldId
     *
     * @return String
     */
    public String getOldId()
    {
        return oldId;
    }


    /**
     * Set the value of OldId
     *
     * @param v new value
     */
    public void setOldId(String v) 
    {

        if (!ObjectUtils.equals(this.oldId, v))
        {
            this.oldId = v;
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
     * @return String
     */
    public String getUpdateTime()
    {
        return updateTime;
    }


    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(String v) 
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
     * @return String
     */
    public String getStatus()
    {
        return status;
    }


    /**
     * Set the value of Status
     *
     * @param v new value
     */
    public void setStatus(String v) 
    {

        if (!ObjectUtils.equals(this.status, v))
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
            fieldNames.add("Name");
            fieldNames.add("Media");
            fieldNames.add("Device");
            fieldNames.add("Type");
            fieldNames.add("PosType");
            fieldNames.add("PosSubType");
            fieldNames.add("ReqPoint");
            fieldNames.add("PageComment");
            fieldNames.add("Place");
            fieldNames.add("PageSize");
            fieldNames.add("Template");
            fieldNames.add("SeqNum");
            fieldNames.add("OldId");
            fieldNames.add("Value");
            fieldNames.add("UpdateTime");
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
        if (name.equals("Media"))
        {
            return getMedia();
        }
        if (name.equals("Device"))
        {
            return getDevice();
        }
        if (name.equals("Type"))
        {
            return getType();
        }
        if (name.equals("PosType"))
        {
            return getPosType();
        }
        if (name.equals("PosSubType"))
        {
            return getPosSubType();
        }
        if (name.equals("ReqPoint"))
        {
            return getReqPoint();
        }
        if (name.equals("PageComment"))
        {
            return getPageComment();
        }
        if (name.equals("Place"))
        {
            return getPlace();
        }
        if (name.equals("PageSize"))
        {
            return getPageSize();
        }
        if (name.equals("Template"))
        {
            return getTemplate();
        }
        if (name.equals("SeqNum"))
        {
            return getSeqNum();
        }
        if (name.equals("OldId"))
        {
            return getOldId();
        }
        if (name.equals("Value"))
        {
            return getValue();
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("Status"))
        {
            return getStatus();
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
        if (name.equals("Media"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setMedia((String) value);
            return true;
        }
        if (name.equals("Device"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDevice((String) value);
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
        if (name.equals("PosType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPosType((String) value);
            return true;
        }
        if (name.equals("PosSubType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPosSubType((String) value);
            return true;
        }
        if (name.equals("ReqPoint"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setReqPoint((String) value);
            return true;
        }
        if (name.equals("PageComment"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPageComment((String) value);
            return true;
        }
        if (name.equals("Place"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPlace((String) value);
            return true;
        }
        if (name.equals("PageSize"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPageSize((String) value);
            return true;
        }
        if (name.equals("Template"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTemplate((String) value);
            return true;
        }
        if (name.equals("SeqNum"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSeqNum((String) value);
            return true;
        }
        if (name.equals("OldId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setOldId((String) value);
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
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUpdateTime((String) value);
            return true;
        }
        if (name.equals("Status"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStatus((String) value);
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
        if (name.equals(AdPositionPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(AdPositionPeer.NAME))
        {
            return getName();
        }
        if (name.equals(AdPositionPeer.MEDIA))
        {
            return getMedia();
        }
        if (name.equals(AdPositionPeer.DEVICE))
        {
            return getDevice();
        }
        if (name.equals(AdPositionPeer.TYPE))
        {
            return getType();
        }
        if (name.equals(AdPositionPeer.POS_TYPE))
        {
            return getPosType();
        }
        if (name.equals(AdPositionPeer.POS_SUB_TYPE))
        {
            return getPosSubType();
        }
        if (name.equals(AdPositionPeer.REQ_POINT))
        {
            return getReqPoint();
        }
        if (name.equals(AdPositionPeer.PAGE_COMMENT))
        {
            return getPageComment();
        }
        if (name.equals(AdPositionPeer.PLACE))
        {
            return getPlace();
        }
        if (name.equals(AdPositionPeer.PAGE_SIZE))
        {
            return getPageSize();
        }
        if (name.equals(AdPositionPeer.TEMPLATE))
        {
            return getTemplate();
        }
        if (name.equals(AdPositionPeer.SEQ_NUM))
        {
            return getSeqNum();
        }
        if (name.equals(AdPositionPeer.OLD_ID))
        {
            return getOldId();
        }
        if (name.equals(AdPositionPeer.VALUE))
        {
            return getValue();
        }
        if (name.equals(AdPositionPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(AdPositionPeer.STATUS))
        {
            return getStatus();
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
      if (AdPositionPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (AdPositionPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (AdPositionPeer.MEDIA.equals(name))
        {
            return setByName("Media", value);
        }
      if (AdPositionPeer.DEVICE.equals(name))
        {
            return setByName("Device", value);
        }
      if (AdPositionPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (AdPositionPeer.POS_TYPE.equals(name))
        {
            return setByName("PosType", value);
        }
      if (AdPositionPeer.POS_SUB_TYPE.equals(name))
        {
            return setByName("PosSubType", value);
        }
      if (AdPositionPeer.REQ_POINT.equals(name))
        {
            return setByName("ReqPoint", value);
        }
      if (AdPositionPeer.PAGE_COMMENT.equals(name))
        {
            return setByName("PageComment", value);
        }
      if (AdPositionPeer.PLACE.equals(name))
        {
            return setByName("Place", value);
        }
      if (AdPositionPeer.PAGE_SIZE.equals(name))
        {
            return setByName("PageSize", value);
        }
      if (AdPositionPeer.TEMPLATE.equals(name))
        {
            return setByName("Template", value);
        }
      if (AdPositionPeer.SEQ_NUM.equals(name))
        {
            return setByName("SeqNum", value);
        }
      if (AdPositionPeer.OLD_ID.equals(name))
        {
            return setByName("OldId", value);
        }
      if (AdPositionPeer.VALUE.equals(name))
        {
            return setByName("Value", value);
        }
      if (AdPositionPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (AdPositionPeer.STATUS.equals(name))
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
            return getMedia();
        }
        if (pos == 3)
        {
            return getDevice();
        }
        if (pos == 4)
        {
            return getType();
        }
        if (pos == 5)
        {
            return getPosType();
        }
        if (pos == 6)
        {
            return getPosSubType();
        }
        if (pos == 7)
        {
            return getReqPoint();
        }
        if (pos == 8)
        {
            return getPageComment();
        }
        if (pos == 9)
        {
            return getPlace();
        }
        if (pos == 10)
        {
            return getPageSize();
        }
        if (pos == 11)
        {
            return getTemplate();
        }
        if (pos == 12)
        {
            return getSeqNum();
        }
        if (pos == 13)
        {
            return getOldId();
        }
        if (pos == 14)
        {
            return getValue();
        }
        if (pos == 15)
        {
            return getUpdateTime();
        }
        if (pos == 16)
        {
            return getStatus();
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
            return setByName("Media", value);
        }
    if (position == 3)
        {
            return setByName("Device", value);
        }
    if (position == 4)
        {
            return setByName("Type", value);
        }
    if (position == 5)
        {
            return setByName("PosType", value);
        }
    if (position == 6)
        {
            return setByName("PosSubType", value);
        }
    if (position == 7)
        {
            return setByName("ReqPoint", value);
        }
    if (position == 8)
        {
            return setByName("PageComment", value);
        }
    if (position == 9)
        {
            return setByName("Place", value);
        }
    if (position == 10)
        {
            return setByName("PageSize", value);
        }
    if (position == 11)
        {
            return setByName("Template", value);
        }
    if (position == 12)
        {
            return setByName("SeqNum", value);
        }
    if (position == 13)
        {
            return setByName("OldId", value);
        }
    if (position == 14)
        {
            return setByName("Value", value);
        }
    if (position == 15)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 16)
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
        save(AdPositionPeer.DATABASE_NAME);
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
                    AdPositionPeer.doInsert((AdPosition) this, con);
                    setNew(false);
                }
                else
                {
                    AdPositionPeer.doUpdate((AdPosition) this, con);
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
    public AdPosition copy() throws TorqueException
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
    public AdPosition copy(Connection con) throws TorqueException
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
    public AdPosition copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new AdPosition(), deepcopy);
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
    public AdPosition copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new AdPosition(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected AdPosition copyInto(AdPosition copyObj) throws TorqueException
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
    protected AdPosition copyInto(AdPosition copyObj, Connection con) throws TorqueException
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
    protected AdPosition copyInto(AdPosition copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setMedia(media);
        copyObj.setDevice(device);
        copyObj.setType(type);
        copyObj.setPosType(posType);
        copyObj.setPosSubType(posSubType);
        copyObj.setReqPoint(reqPoint);
        copyObj.setPageComment(pageComment);
        copyObj.setPlace(place);
        copyObj.setPageSize(pageSize);
        copyObj.setTemplate(template);
        copyObj.setSeqNum(seqNum);
        copyObj.setOldId(oldId);
        copyObj.setValue(value);
        copyObj.setUpdateTime(updateTime);
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
    protected AdPosition copyInto(AdPosition copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setMedia(media);
        copyObj.setDevice(device);
        copyObj.setType(type);
        copyObj.setPosType(posType);
        copyObj.setPosSubType(posSubType);
        copyObj.setReqPoint(reqPoint);
        copyObj.setPageComment(pageComment);
        copyObj.setPlace(place);
        copyObj.setPageSize(pageSize);
        copyObj.setTemplate(template);
        copyObj.setSeqNum(seqNum);
        copyObj.setOldId(oldId);
        copyObj.setValue(value);
        copyObj.setUpdateTime(updateTime);
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
    public AdPositionPeer getPeer()
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
        return AdPositionPeer.getTableMap();
    }

  
    /**
     * Creates a AdPositionBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a AdPositionBean with the contents of this object
     */
    public AdPositionBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a AdPositionBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a AdPositionBean with the contents of this object
     */
    public AdPositionBean getBean(IdentityMap createdBeans)
    {
        AdPositionBean result = (AdPositionBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new AdPositionBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setMedia(getMedia());
        result.setDevice(getDevice());
        result.setType(getType());
        result.setPosType(getPosType());
        result.setPosSubType(getPosSubType());
        result.setReqPoint(getReqPoint());
        result.setPageComment(getPageComment());
        result.setPlace(getPlace());
        result.setPageSize(getPageSize());
        result.setTemplate(getTemplate());
        result.setSeqNum(getSeqNum());
        result.setOldId(getOldId());
        result.setValue(getValue());
        result.setUpdateTime(getUpdateTime());
        result.setStatus(getStatus());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of AdPosition with the contents
     * of a AdPositionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the AdPositionBean which contents are used to create
     *        the resulting class
     * @return an instance of AdPosition with the contents of bean
     */
    public static AdPosition createAdPosition(AdPositionBean bean)
        throws TorqueException
    {
        return createAdPosition(bean, new IdentityMap());
    }

    /**
     * Creates an instance of AdPosition with the contents
     * of a AdPositionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the AdPositionBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of AdPosition with the contents of bean
     */

    public static AdPosition createAdPosition(AdPositionBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        AdPosition result = (AdPosition) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new AdPosition();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setMedia(bean.getMedia());
        result.setDevice(bean.getDevice());
        result.setType(bean.getType());
        result.setPosType(bean.getPosType());
        result.setPosSubType(bean.getPosSubType());
        result.setReqPoint(bean.getReqPoint());
        result.setPageComment(bean.getPageComment());
        result.setPlace(bean.getPlace());
        result.setPageSize(bean.getPageSize());
        result.setTemplate(bean.getTemplate());
        result.setSeqNum(bean.getSeqNum());
        result.setOldId(bean.getOldId());
        result.setValue(bean.getValue());
        result.setUpdateTime(bean.getUpdateTime());
        result.setStatus(bean.getStatus());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("AdPosition:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Media = ")
           .append(getMedia())
           .append("\n");
        str.append("Device = ")
           .append(getDevice())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("PosType = ")
           .append(getPosType())
           .append("\n");
        str.append("PosSubType = ")
           .append(getPosSubType())
           .append("\n");
        str.append("ReqPoint = ")
           .append(getReqPoint())
           .append("\n");
        str.append("PageComment = ")
           .append(getPageComment())
           .append("\n");
        str.append("Place = ")
           .append(getPlace())
           .append("\n");
        str.append("PageSize = ")
           .append(getPageSize())
           .append("\n");
        str.append("Template = ")
           .append(getTemplate())
           .append("\n");
        str.append("SeqNum = ")
           .append(getSeqNum())
           .append("\n");
        str.append("OldId = ")
           .append(getOldId())
           .append("\n");
        str.append("Value = ")
           .append(getValue())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
