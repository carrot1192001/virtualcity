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
import com.youku.atm.om.bean.TimeTaskBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to TimeTask
 */
public abstract class BaseTimeTask extends BaseObject
{
    /** The Peer class */
    private static final TimeTaskPeer peer =
        new TimeTaskPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the period field */
    private String period;

    /** The value for the ip field */
    private String ip;

    /** The value for the interfaceName field */
    private String interfaceName;

    /** The value for the params field */
    private String params;

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
     * Get the InterfaceName
     *
     * @return String
     */
    public String getInterfaceName()
    {
        return interfaceName;
    }


    /**
     * Set the value of InterfaceName
     *
     * @param v new value
     */
    public void setInterfaceName(String v) 
    {

        if (!ObjectUtils.equals(this.interfaceName, v))
        {
            this.interfaceName = v;
            setModified(true);
        }


    }

    /**
     * Get the Params
     *
     * @return String
     */
    public String getParams()
    {
        return params;
    }


    /**
     * Set the value of Params
     *
     * @param v new value
     */
    public void setParams(String v) 
    {

        if (!ObjectUtils.equals(this.params, v))
        {
            this.params = v;
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
            fieldNames.add("Name");
            fieldNames.add("Period");
            fieldNames.add("Ip");
            fieldNames.add("InterfaceName");
            fieldNames.add("Params");
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
        if (name.equals("Period"))
        {
            return getPeriod();
        }
        if (name.equals("Ip"))
        {
            return getIp();
        }
        if (name.equals("InterfaceName"))
        {
            return getInterfaceName();
        }
        if (name.equals("Params"))
        {
            return getParams();
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
        if (name.equals("InterfaceName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setInterfaceName((String) value);
            return true;
        }
        if (name.equals("Params"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setParams((String) value);
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
        if (name.equals(TimeTaskPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(TimeTaskPeer.NAME))
        {
            return getName();
        }
        if (name.equals(TimeTaskPeer.PERIOD))
        {
            return getPeriod();
        }
        if (name.equals(TimeTaskPeer.IP))
        {
            return getIp();
        }
        if (name.equals(TimeTaskPeer.INTERFACE_NAME))
        {
            return getInterfaceName();
        }
        if (name.equals(TimeTaskPeer.PARAMS))
        {
            return getParams();
        }
        if (name.equals(TimeTaskPeer.STATUS))
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
      if (TimeTaskPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (TimeTaskPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (TimeTaskPeer.PERIOD.equals(name))
        {
            return setByName("Period", value);
        }
      if (TimeTaskPeer.IP.equals(name))
        {
            return setByName("Ip", value);
        }
      if (TimeTaskPeer.INTERFACE_NAME.equals(name))
        {
            return setByName("InterfaceName", value);
        }
      if (TimeTaskPeer.PARAMS.equals(name))
        {
            return setByName("Params", value);
        }
      if (TimeTaskPeer.STATUS.equals(name))
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
            return getPeriod();
        }
        if (pos == 3)
        {
            return getIp();
        }
        if (pos == 4)
        {
            return getInterfaceName();
        }
        if (pos == 5)
        {
            return getParams();
        }
        if (pos == 6)
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
            return setByName("Period", value);
        }
    if (position == 3)
        {
            return setByName("Ip", value);
        }
    if (position == 4)
        {
            return setByName("InterfaceName", value);
        }
    if (position == 5)
        {
            return setByName("Params", value);
        }
    if (position == 6)
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
        save(TimeTaskPeer.DATABASE_NAME);
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
                    TimeTaskPeer.doInsert((TimeTask) this, con);
                    setNew(false);
                }
                else
                {
                    TimeTaskPeer.doUpdate((TimeTask) this, con);
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
    public TimeTask copy() throws TorqueException
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
    public TimeTask copy(Connection con) throws TorqueException
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
    public TimeTask copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new TimeTask(), deepcopy);
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
    public TimeTask copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new TimeTask(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected TimeTask copyInto(TimeTask copyObj) throws TorqueException
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
    protected TimeTask copyInto(TimeTask copyObj, Connection con) throws TorqueException
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
    protected TimeTask copyInto(TimeTask copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setPeriod(period);
        copyObj.setIp(ip);
        copyObj.setInterfaceName(interfaceName);
        copyObj.setParams(params);
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
    protected TimeTask copyInto(TimeTask copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setPeriod(period);
        copyObj.setIp(ip);
        copyObj.setInterfaceName(interfaceName);
        copyObj.setParams(params);
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
    public TimeTaskPeer getPeer()
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
        return TimeTaskPeer.getTableMap();
    }

  
    /**
     * Creates a TimeTaskBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a TimeTaskBean with the contents of this object
     */
    public TimeTaskBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a TimeTaskBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a TimeTaskBean with the contents of this object
     */
    public TimeTaskBean getBean(IdentityMap createdBeans)
    {
        TimeTaskBean result = (TimeTaskBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new TimeTaskBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setPeriod(getPeriod());
        result.setIp(getIp());
        result.setInterfaceName(getInterfaceName());
        result.setParams(getParams());
        result.setStatus(getStatus());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of TimeTask with the contents
     * of a TimeTaskBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the TimeTaskBean which contents are used to create
     *        the resulting class
     * @return an instance of TimeTask with the contents of bean
     */
    public static TimeTask createTimeTask(TimeTaskBean bean)
        throws TorqueException
    {
        return createTimeTask(bean, new IdentityMap());
    }

    /**
     * Creates an instance of TimeTask with the contents
     * of a TimeTaskBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the TimeTaskBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of TimeTask with the contents of bean
     */

    public static TimeTask createTimeTask(TimeTaskBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        TimeTask result = (TimeTask) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new TimeTask();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setPeriod(bean.getPeriod());
        result.setIp(bean.getIp());
        result.setInterfaceName(bean.getInterfaceName());
        result.setParams(bean.getParams());
        result.setStatus(bean.getStatus());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("TimeTask:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Period = ")
           .append(getPeriod())
           .append("\n");
        str.append("Ip = ")
           .append(getIp())
           .append("\n");
        str.append("InterfaceName = ")
           .append(getInterfaceName())
           .append("\n");
        str.append("Params = ")
           .append(getParams())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
