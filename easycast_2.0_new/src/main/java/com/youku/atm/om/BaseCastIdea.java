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
import com.youku.atm.om.bean.CastIdeaBean;



/**
 * cast_idea
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to CastIdea
 */
public abstract class BaseCastIdea extends BaseObject
{
    /** The Peer class */
    private static final CastIdeaPeer peer =
        new CastIdeaPeer();


    /** The value for the id field */
    private long id;

    /** The value for the castId field */
    private int castId;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the status field */
    private int status = 1;

    /** The value for the issdk field */
    private int issdk = 1;

    /** The value for the iesorg field */
    private String iesorg;

    /** The value for the cuf field */
    private int cuf;

    /** The value for the mst field */
    private int mst = 0;

    /** The value for the monitorAddType field */
    private int monitorAddType = 0;

    /** The value for the weight field */
    private int weight = 0;

    /** The value for the isDefault field */
    private int isDefault = 0;


    /**
     * Get the Id
     *
     * @return long
     */
    public long getId()
    {
        return id;
    }


    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(long v) 
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
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
     * Get the IdeaId
     *
     * @return int
     */
    public int getIdeaId()
    {
        return ideaId;
    }


    /**
     * Set the value of IdeaId
     *
     * @param v new value
     */
    public void setIdeaId(int v) 
    {

        if (this.ideaId != v)
        {
            this.ideaId = v;
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
     * Get the MonitorAddType
     *
     * @return int
     */
    public int getMonitorAddType()
    {
        return monitorAddType;
    }


    /**
     * Set the value of MonitorAddType
     *
     * @param v new value
     */
    public void setMonitorAddType(int v) 
    {

        if (this.monitorAddType != v)
        {
            this.monitorAddType = v;
            setModified(true);
        }


    }

    /**
     * Get the Weight
     *
     * @return int
     */
    public int getWeight()
    {
        return weight;
    }


    /**
     * Set the value of Weight
     *
     * @param v new value
     */
    public void setWeight(int v) 
    {

        if (this.weight != v)
        {
            this.weight = v;
            setModified(true);
        }


    }

    /**
     * Get the IsDefault
     *
     * @return int
     */
    public int getIsDefault()
    {
        return isDefault;
    }


    /**
     * Set the value of IsDefault
     *
     * @param v new value
     */
    public void setIsDefault(int v) 
    {

        if (this.isDefault != v)
        {
            this.isDefault = v;
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
            fieldNames.add("CastId");
            fieldNames.add("IdeaId");
            fieldNames.add("UpdateTime");
            fieldNames.add("Status");
            fieldNames.add("Issdk");
            fieldNames.add("Iesorg");
            fieldNames.add("Cuf");
            fieldNames.add("Mst");
            fieldNames.add("MonitorAddType");
            fieldNames.add("Weight");
            fieldNames.add("IsDefault");
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
            return new Long(getId());
        }
        if (name.equals("CastId"))
        {
            return new Integer(getCastId());
        }
        if (name.equals("IdeaId"))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("Issdk"))
        {
            return new Integer(getIssdk());
        }
        if (name.equals("Iesorg"))
        {
            return getIesorg();
        }
        if (name.equals("Cuf"))
        {
            return new Integer(getCuf());
        }
        if (name.equals("Mst"))
        {
            return new Integer(getMst());
        }
        if (name.equals("MonitorAddType"))
        {
            return new Integer(getMonitorAddType());
        }
        if (name.equals("Weight"))
        {
            return new Integer(getWeight());
        }
        if (name.equals("IsDefault"))
        {
            return new Integer(getIsDefault());
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
            if (value == null || ! (Long.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Long object.");
            }
            setId(((Long) value).longValue());
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
        if (name.equals("IdeaId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaId(((Integer) value).intValue());
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
        if (name.equals("Issdk"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIssdk(((Integer) value).intValue());
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
        if (name.equals("Mst"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMst(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MonitorAddType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMonitorAddType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Weight"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setWeight(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IsDefault"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsDefault(((Integer) value).intValue());
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
        if (name.equals(CastIdeaPeer.ID))
        {
            return new Long(getId());
        }
        if (name.equals(CastIdeaPeer.CAST_ID))
        {
            return new Integer(getCastId());
        }
        if (name.equals(CastIdeaPeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(CastIdeaPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(CastIdeaPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(CastIdeaPeer.ISSDK))
        {
            return new Integer(getIssdk());
        }
        if (name.equals(CastIdeaPeer.IESORG))
        {
            return getIesorg();
        }
        if (name.equals(CastIdeaPeer.CUF))
        {
            return new Integer(getCuf());
        }
        if (name.equals(CastIdeaPeer.MST))
        {
            return new Integer(getMst());
        }
        if (name.equals(CastIdeaPeer.MONITOR_ADD_TYPE))
        {
            return new Integer(getMonitorAddType());
        }
        if (name.equals(CastIdeaPeer.WEIGHT))
        {
            return new Integer(getWeight());
        }
        if (name.equals(CastIdeaPeer.IS_DEFAULT))
        {
            return new Integer(getIsDefault());
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
      if (CastIdeaPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (CastIdeaPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
        }
      if (CastIdeaPeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (CastIdeaPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (CastIdeaPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (CastIdeaPeer.ISSDK.equals(name))
        {
            return setByName("Issdk", value);
        }
      if (CastIdeaPeer.IESORG.equals(name))
        {
            return setByName("Iesorg", value);
        }
      if (CastIdeaPeer.CUF.equals(name))
        {
            return setByName("Cuf", value);
        }
      if (CastIdeaPeer.MST.equals(name))
        {
            return setByName("Mst", value);
        }
      if (CastIdeaPeer.MONITOR_ADD_TYPE.equals(name))
        {
            return setByName("MonitorAddType", value);
        }
      if (CastIdeaPeer.WEIGHT.equals(name))
        {
            return setByName("Weight", value);
        }
      if (CastIdeaPeer.IS_DEFAULT.equals(name))
        {
            return setByName("IsDefault", value);
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
            return new Long(getId());
        }
        if (pos == 1)
        {
            return new Integer(getCastId());
        }
        if (pos == 2)
        {
            return new Integer(getIdeaId());
        }
        if (pos == 3)
        {
            return getUpdateTime();
        }
        if (pos == 4)
        {
            return new Integer(getStatus());
        }
        if (pos == 5)
        {
            return new Integer(getIssdk());
        }
        if (pos == 6)
        {
            return getIesorg();
        }
        if (pos == 7)
        {
            return new Integer(getCuf());
        }
        if (pos == 8)
        {
            return new Integer(getMst());
        }
        if (pos == 9)
        {
            return new Integer(getMonitorAddType());
        }
        if (pos == 10)
        {
            return new Integer(getWeight());
        }
        if (pos == 11)
        {
            return new Integer(getIsDefault());
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
            return setByName("IdeaId", value);
        }
    if (position == 3)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 4)
        {
            return setByName("Status", value);
        }
    if (position == 5)
        {
            return setByName("Issdk", value);
        }
    if (position == 6)
        {
            return setByName("Iesorg", value);
        }
    if (position == 7)
        {
            return setByName("Cuf", value);
        }
    if (position == 8)
        {
            return setByName("Mst", value);
        }
    if (position == 9)
        {
            return setByName("MonitorAddType", value);
        }
    if (position == 10)
        {
            return setByName("Weight", value);
        }
    if (position == 11)
        {
            return setByName("IsDefault", value);
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
        save(CastIdeaPeer.DATABASE_NAME);
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
                    CastIdeaPeer.doInsert((CastIdea) this, con);
                    setNew(false);
                }
                else
                {
                    CastIdeaPeer.doUpdate((CastIdea) this, con);
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
        setId(((NumberKey) key).longValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setId(Long.parseLong(key));
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
    public CastIdea copy() throws TorqueException
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
    public CastIdea copy(Connection con) throws TorqueException
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
    public CastIdea copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new CastIdea(), deepcopy);
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
    public CastIdea copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new CastIdea(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected CastIdea copyInto(CastIdea copyObj) throws TorqueException
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
    protected CastIdea copyInto(CastIdea copyObj, Connection con) throws TorqueException
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
    protected CastIdea copyInto(CastIdea copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setIdeaId(ideaId);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStatus(status);
        copyObj.setIssdk(issdk);
        copyObj.setIesorg(iesorg);
        copyObj.setCuf(cuf);
        copyObj.setMst(mst);
        copyObj.setMonitorAddType(monitorAddType);
        copyObj.setWeight(weight);
        copyObj.setIsDefault(isDefault);

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
    protected CastIdea copyInto(CastIdea copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setIdeaId(ideaId);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStatus(status);
        copyObj.setIssdk(issdk);
        copyObj.setIesorg(iesorg);
        copyObj.setCuf(cuf);
        copyObj.setMst(mst);
        copyObj.setMonitorAddType(monitorAddType);
        copyObj.setWeight(weight);
        copyObj.setIsDefault(isDefault);

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
    public CastIdeaPeer getPeer()
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
        return CastIdeaPeer.getTableMap();
    }

  
    /**
     * Creates a CastIdeaBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a CastIdeaBean with the contents of this object
     */
    public CastIdeaBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a CastIdeaBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a CastIdeaBean with the contents of this object
     */
    public CastIdeaBean getBean(IdentityMap createdBeans)
    {
        CastIdeaBean result = (CastIdeaBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new CastIdeaBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setCastId(getCastId());
        result.setIdeaId(getIdeaId());
        result.setUpdateTime(getUpdateTime());
        result.setStatus(getStatus());
        result.setIssdk(getIssdk());
        result.setIesorg(getIesorg());
        result.setCuf(getCuf());
        result.setMst(getMst());
        result.setMonitorAddType(getMonitorAddType());
        result.setWeight(getWeight());
        result.setIsDefault(getIsDefault());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of CastIdea with the contents
     * of a CastIdeaBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the CastIdeaBean which contents are used to create
     *        the resulting class
     * @return an instance of CastIdea with the contents of bean
     */
    public static CastIdea createCastIdea(CastIdeaBean bean)
        throws TorqueException
    {
        return createCastIdea(bean, new IdentityMap());
    }

    /**
     * Creates an instance of CastIdea with the contents
     * of a CastIdeaBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the CastIdeaBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of CastIdea with the contents of bean
     */

    public static CastIdea createCastIdea(CastIdeaBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        CastIdea result = (CastIdea) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new CastIdea();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setCastId(bean.getCastId());
        result.setIdeaId(bean.getIdeaId());
        result.setUpdateTime(bean.getUpdateTime());
        result.setStatus(bean.getStatus());
        result.setIssdk(bean.getIssdk());
        result.setIesorg(bean.getIesorg());
        result.setCuf(bean.getCuf());
        result.setMst(bean.getMst());
        result.setMonitorAddType(bean.getMonitorAddType());
        result.setWeight(bean.getWeight());
        result.setIsDefault(bean.getIsDefault());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("CastIdea:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("Issdk = ")
           .append(getIssdk())
           .append("\n");
        str.append("Iesorg = ")
           .append(getIesorg())
           .append("\n");
        str.append("Cuf = ")
           .append(getCuf())
           .append("\n");
        str.append("Mst = ")
           .append(getMst())
           .append("\n");
        str.append("MonitorAddType = ")
           .append(getMonitorAddType())
           .append("\n");
        str.append("Weight = ")
           .append(getWeight())
           .append("\n");
        str.append("IsDefault = ")
           .append(getIsDefault())
           .append("\n");
        return(str.toString());
    }
}
