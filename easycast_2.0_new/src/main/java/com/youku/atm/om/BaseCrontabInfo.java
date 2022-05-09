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
import com.youku.atm.om.bean.CrontabInfoBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to CrontabInfo
 */
public abstract class BaseCrontabInfo extends BaseObject
{
    /** The Peer class */
    private static final CrontabInfoPeer peer =
        new CrontabInfoPeer();


    /** The value for the id field */
    private int id;

    /** The value for the period field */
    private String period;

    /** The value for the taskUrl field */
    private String taskUrl;

    /** The value for the ip field */
    private String ip;

    /** The value for the status field */
    private int status = 1;

    /** The value for the description field */
    private String description;


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
     * Get the Period
     *
     * @return String
     */
    public String getPeriod()
    {
        return period;
    }


    /**
     * Set the value of Period
     *
     * @param v new value
     */
    public void setPeriod(String v) 
    {

        if (!ObjectUtils.equals(this.period, v))
        {
            this.period = v;
            setModified(true);
        }


    }

    /**
     * Get the TaskUrl
     *
     * @return String
     */
    public String getTaskUrl()
    {
        return taskUrl;
    }


    /**
     * Set the value of TaskUrl
     *
     * @param v new value
     */
    public void setTaskUrl(String v) 
    {

        if (!ObjectUtils.equals(this.taskUrl, v))
        {
            this.taskUrl = v;
            setModified(true);
        }


    }

    /**
     * Get the Ip
     *
     * @return String
     */
    public String getIp()
    {
        return ip;
    }


    /**
     * Set the value of Ip
     *
     * @param v new value
     */
    public void setIp(String v) 
    {

        if (!ObjectUtils.equals(this.ip, v))
        {
            this.ip = v;
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
            fieldNames.add("Period");
            fieldNames.add("TaskUrl");
            fieldNames.add("Ip");
            fieldNames.add("Status");
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
            return new Integer(getId());
        }
        if (name.equals("Period"))
        {
            return getPeriod();
        }
        if (name.equals("TaskUrl"))
        {
            return getTaskUrl();
        }
        if (name.equals("Ip"))
        {
            return getIp();
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
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
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Period"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPeriod((String) value);
            return true;
        }
        if (name.equals("TaskUrl"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTaskUrl((String) value);
            return true;
        }
        if (name.equals("Ip"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setIp((String) value);
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
        if (name.equals(CrontabInfoPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(CrontabInfoPeer.PERIOD))
        {
            return getPeriod();
        }
        if (name.equals(CrontabInfoPeer.TASK_URL))
        {
            return getTaskUrl();
        }
        if (name.equals(CrontabInfoPeer.IP))
        {
            return getIp();
        }
        if (name.equals(CrontabInfoPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(CrontabInfoPeer.DESCRIPTION))
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
      if (CrontabInfoPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (CrontabInfoPeer.PERIOD.equals(name))
        {
            return setByName("Period", value);
        }
      if (CrontabInfoPeer.TASK_URL.equals(name))
        {
            return setByName("TaskUrl", value);
        }
      if (CrontabInfoPeer.IP.equals(name))
        {
            return setByName("Ip", value);
        }
      if (CrontabInfoPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (CrontabInfoPeer.DESCRIPTION.equals(name))
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
            return new Integer(getId());
        }
        if (pos == 1)
        {
            return getPeriod();
        }
        if (pos == 2)
        {
            return getTaskUrl();
        }
        if (pos == 3)
        {
            return getIp();
        }
        if (pos == 4)
        {
            return new Integer(getStatus());
        }
        if (pos == 5)
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
            return setByName("Period", value);
        }
    if (position == 2)
        {
            return setByName("TaskUrl", value);
        }
    if (position == 3)
        {
            return setByName("Ip", value);
        }
    if (position == 4)
        {
            return setByName("Status", value);
        }
    if (position == 5)
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
        save(CrontabInfoPeer.DATABASE_NAME);
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
                    CrontabInfoPeer.doInsert((CrontabInfo) this, con);
                    setNew(false);
                }
                else
                {
                    CrontabInfoPeer.doUpdate((CrontabInfo) this, con);
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
    public CrontabInfo copy() throws TorqueException
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
    public CrontabInfo copy(Connection con) throws TorqueException
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
    public CrontabInfo copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new CrontabInfo(), deepcopy);
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
    public CrontabInfo copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new CrontabInfo(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected CrontabInfo copyInto(CrontabInfo copyObj) throws TorqueException
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
    protected CrontabInfo copyInto(CrontabInfo copyObj, Connection con) throws TorqueException
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
    protected CrontabInfo copyInto(CrontabInfo copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setPeriod(period);
        copyObj.setTaskUrl(taskUrl);
        copyObj.setIp(ip);
        copyObj.setStatus(status);
        copyObj.setDescription(description);

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
    protected CrontabInfo copyInto(CrontabInfo copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setPeriod(period);
        copyObj.setTaskUrl(taskUrl);
        copyObj.setIp(ip);
        copyObj.setStatus(status);
        copyObj.setDescription(description);

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
    public CrontabInfoPeer getPeer()
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
        return CrontabInfoPeer.getTableMap();
    }

  
    /**
     * Creates a CrontabInfoBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a CrontabInfoBean with the contents of this object
     */
    public CrontabInfoBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a CrontabInfoBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a CrontabInfoBean with the contents of this object
     */
    public CrontabInfoBean getBean(IdentityMap createdBeans)
    {
        CrontabInfoBean result = (CrontabInfoBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new CrontabInfoBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setPeriod(getPeriod());
        result.setTaskUrl(getTaskUrl());
        result.setIp(getIp());
        result.setStatus(getStatus());
        result.setDescription(getDescription());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of CrontabInfo with the contents
     * of a CrontabInfoBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the CrontabInfoBean which contents are used to create
     *        the resulting class
     * @return an instance of CrontabInfo with the contents of bean
     */
    public static CrontabInfo createCrontabInfo(CrontabInfoBean bean)
        throws TorqueException
    {
        return createCrontabInfo(bean, new IdentityMap());
    }

    /**
     * Creates an instance of CrontabInfo with the contents
     * of a CrontabInfoBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the CrontabInfoBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of CrontabInfo with the contents of bean
     */

    public static CrontabInfo createCrontabInfo(CrontabInfoBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        CrontabInfo result = (CrontabInfo) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new CrontabInfo();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setPeriod(bean.getPeriod());
        result.setTaskUrl(bean.getTaskUrl());
        result.setIp(bean.getIp());
        result.setStatus(bean.getStatus());
        result.setDescription(bean.getDescription());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("CrontabInfo:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Period = ")
           .append(getPeriod())
           .append("\n");
        str.append("TaskUrl = ")
           .append(getTaskUrl())
           .append("\n");
        str.append("Ip = ")
           .append(getIp())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("Description = ")
           .append(getDescription())
           .append("\n");
        return(str.toString());
    }
}
