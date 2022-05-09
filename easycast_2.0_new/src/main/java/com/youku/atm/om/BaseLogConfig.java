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
import com.youku.atm.om.bean.LogConfigBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to LogConfig
 */
public abstract class BaseLogConfig extends BaseObject
{
    /** The Peer class */
    private static final LogConfigPeer peer =
        new LogConfigPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the code field */
    private String code;

    /** The value for the ip field */
    private String ip;

    /** The value for the remoteport field */
    private String remoteport;

    /** The value for the localport field */
    private String localport;

    /** The value for the path field */
    private String path;

    /** The value for the site field */
    private int site = 0;

    /** The value for the logType field */
    private String logType = "a";

    /** The value for the pType field */
    private int pType = 0;


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
     * Get the Code
     *
     * @return String
     */
    public String getCode()
    {
        return code;
    }


    /**
     * Set the value of Code
     *
     * @param v new value
     */
    public void setCode(String v) 
    {

        if (!ObjectUtils.equals(this.code, v))
        {
            this.code = v;
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
     * Get the Remoteport
     *
     * @return String
     */
    public String getRemoteport()
    {
        return remoteport;
    }


    /**
     * Set the value of Remoteport
     *
     * @param v new value
     */
    public void setRemoteport(String v) 
    {

        if (!ObjectUtils.equals(this.remoteport, v))
        {
            this.remoteport = v;
            setModified(true);
        }


    }

    /**
     * Get the Localport
     *
     * @return String
     */
    public String getLocalport()
    {
        return localport;
    }


    /**
     * Set the value of Localport
     *
     * @param v new value
     */
    public void setLocalport(String v) 
    {

        if (!ObjectUtils.equals(this.localport, v))
        {
            this.localport = v;
            setModified(true);
        }


    }

    /**
     * Get the Path
     *
     * @return String
     */
    public String getPath()
    {
        return path;
    }


    /**
     * Set the value of Path
     *
     * @param v new value
     */
    public void setPath(String v) 
    {

        if (!ObjectUtils.equals(this.path, v))
        {
            this.path = v;
            setModified(true);
        }


    }

    /**
     * Get the Site
     *
     * @return int
     */
    public int getSite()
    {
        return site;
    }


    /**
     * Set the value of Site
     *
     * @param v new value
     */
    public void setSite(int v) 
    {

        if (this.site != v)
        {
            this.site = v;
            setModified(true);
        }


    }

    /**
     * Get the LogType
     *
     * @return String
     */
    public String getLogType()
    {
        return logType;
    }


    /**
     * Set the value of LogType
     *
     * @param v new value
     */
    public void setLogType(String v) 
    {

        if (!ObjectUtils.equals(this.logType, v))
        {
            this.logType = v;
            setModified(true);
        }


    }

    /**
     * Get the PType
     *
     * @return int
     */
    public int getPType()
    {
        return pType;
    }


    /**
     * Set the value of PType
     *
     * @param v new value
     */
    public void setPType(int v) 
    {

        if (this.pType != v)
        {
            this.pType = v;
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
            fieldNames.add("Code");
            fieldNames.add("Ip");
            fieldNames.add("Remoteport");
            fieldNames.add("Localport");
            fieldNames.add("Path");
            fieldNames.add("Site");
            fieldNames.add("LogType");
            fieldNames.add("PType");
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
        if (name.equals("Code"))
        {
            return getCode();
        }
        if (name.equals("Ip"))
        {
            return getIp();
        }
        if (name.equals("Remoteport"))
        {
            return getRemoteport();
        }
        if (name.equals("Localport"))
        {
            return getLocalport();
        }
        if (name.equals("Path"))
        {
            return getPath();
        }
        if (name.equals("Site"))
        {
            return new Integer(getSite());
        }
        if (name.equals("LogType"))
        {
            return getLogType();
        }
        if (name.equals("PType"))
        {
            return new Integer(getPType());
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
        if (name.equals("Code"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCode((String) value);
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
        if (name.equals("Remoteport"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setRemoteport((String) value);
            return true;
        }
        if (name.equals("Localport"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLocalport((String) value);
            return true;
        }
        if (name.equals("Path"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPath((String) value);
            return true;
        }
        if (name.equals("Site"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSite(((Integer) value).intValue());
            return true;
        }
        if (name.equals("LogType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLogType((String) value);
            return true;
        }
        if (name.equals("PType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPType(((Integer) value).intValue());
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
        if (name.equals(LogConfigPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(LogConfigPeer.NAME))
        {
            return getName();
        }
        if (name.equals(LogConfigPeer.CODE))
        {
            return getCode();
        }
        if (name.equals(LogConfigPeer.IP))
        {
            return getIp();
        }
        if (name.equals(LogConfigPeer.REMOTEPORT))
        {
            return getRemoteport();
        }
        if (name.equals(LogConfigPeer.LOCALPORT))
        {
            return getLocalport();
        }
        if (name.equals(LogConfigPeer.PATH))
        {
            return getPath();
        }
        if (name.equals(LogConfigPeer.SITE))
        {
            return new Integer(getSite());
        }
        if (name.equals(LogConfigPeer.LOG_TYPE))
        {
            return getLogType();
        }
        if (name.equals(LogConfigPeer.P_TYPE))
        {
            return new Integer(getPType());
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
      if (LogConfigPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (LogConfigPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (LogConfigPeer.CODE.equals(name))
        {
            return setByName("Code", value);
        }
      if (LogConfigPeer.IP.equals(name))
        {
            return setByName("Ip", value);
        }
      if (LogConfigPeer.REMOTEPORT.equals(name))
        {
            return setByName("Remoteport", value);
        }
      if (LogConfigPeer.LOCALPORT.equals(name))
        {
            return setByName("Localport", value);
        }
      if (LogConfigPeer.PATH.equals(name))
        {
            return setByName("Path", value);
        }
      if (LogConfigPeer.SITE.equals(name))
        {
            return setByName("Site", value);
        }
      if (LogConfigPeer.LOG_TYPE.equals(name))
        {
            return setByName("LogType", value);
        }
      if (LogConfigPeer.P_TYPE.equals(name))
        {
            return setByName("PType", value);
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
            return getCode();
        }
        if (pos == 3)
        {
            return getIp();
        }
        if (pos == 4)
        {
            return getRemoteport();
        }
        if (pos == 5)
        {
            return getLocalport();
        }
        if (pos == 6)
        {
            return getPath();
        }
        if (pos == 7)
        {
            return new Integer(getSite());
        }
        if (pos == 8)
        {
            return getLogType();
        }
        if (pos == 9)
        {
            return new Integer(getPType());
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
            return setByName("Code", value);
        }
    if (position == 3)
        {
            return setByName("Ip", value);
        }
    if (position == 4)
        {
            return setByName("Remoteport", value);
        }
    if (position == 5)
        {
            return setByName("Localport", value);
        }
    if (position == 6)
        {
            return setByName("Path", value);
        }
    if (position == 7)
        {
            return setByName("Site", value);
        }
    if (position == 8)
        {
            return setByName("LogType", value);
        }
    if (position == 9)
        {
            return setByName("PType", value);
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
        save(LogConfigPeer.DATABASE_NAME);
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
                    LogConfigPeer.doInsert((LogConfig) this, con);
                    setNew(false);
                }
                else
                {
                    LogConfigPeer.doUpdate((LogConfig) this, con);
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
    public LogConfig copy() throws TorqueException
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
    public LogConfig copy(Connection con) throws TorqueException
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
    public LogConfig copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new LogConfig(), deepcopy);
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
    public LogConfig copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new LogConfig(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected LogConfig copyInto(LogConfig copyObj) throws TorqueException
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
    protected LogConfig copyInto(LogConfig copyObj, Connection con) throws TorqueException
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
    protected LogConfig copyInto(LogConfig copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setCode(code);
        copyObj.setIp(ip);
        copyObj.setRemoteport(remoteport);
        copyObj.setLocalport(localport);
        copyObj.setPath(path);
        copyObj.setSite(site);
        copyObj.setLogType(logType);
        copyObj.setPType(pType);

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
    protected LogConfig copyInto(LogConfig copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setCode(code);
        copyObj.setIp(ip);
        copyObj.setRemoteport(remoteport);
        copyObj.setLocalport(localport);
        copyObj.setPath(path);
        copyObj.setSite(site);
        copyObj.setLogType(logType);
        copyObj.setPType(pType);

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
    public LogConfigPeer getPeer()
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
        return LogConfigPeer.getTableMap();
    }

  
    /**
     * Creates a LogConfigBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a LogConfigBean with the contents of this object
     */
    public LogConfigBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a LogConfigBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a LogConfigBean with the contents of this object
     */
    public LogConfigBean getBean(IdentityMap createdBeans)
    {
        LogConfigBean result = (LogConfigBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new LogConfigBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setCode(getCode());
        result.setIp(getIp());
        result.setRemoteport(getRemoteport());
        result.setLocalport(getLocalport());
        result.setPath(getPath());
        result.setSite(getSite());
        result.setLogType(getLogType());
        result.setPType(getPType());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of LogConfig with the contents
     * of a LogConfigBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the LogConfigBean which contents are used to create
     *        the resulting class
     * @return an instance of LogConfig with the contents of bean
     */
    public static LogConfig createLogConfig(LogConfigBean bean)
        throws TorqueException
    {
        return createLogConfig(bean, new IdentityMap());
    }

    /**
     * Creates an instance of LogConfig with the contents
     * of a LogConfigBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the LogConfigBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of LogConfig with the contents of bean
     */

    public static LogConfig createLogConfig(LogConfigBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        LogConfig result = (LogConfig) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new LogConfig();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setCode(bean.getCode());
        result.setIp(bean.getIp());
        result.setRemoteport(bean.getRemoteport());
        result.setLocalport(bean.getLocalport());
        result.setPath(bean.getPath());
        result.setSite(bean.getSite());
        result.setLogType(bean.getLogType());
        result.setPType(bean.getPType());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("LogConfig:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Code = ")
           .append(getCode())
           .append("\n");
        str.append("Ip = ")
           .append(getIp())
           .append("\n");
        str.append("Remoteport = ")
           .append(getRemoteport())
           .append("\n");
        str.append("Localport = ")
           .append(getLocalport())
           .append("\n");
        str.append("Path = ")
           .append(getPath())
           .append("\n");
        str.append("Site = ")
           .append(getSite())
           .append("\n");
        str.append("LogType = ")
           .append(getLogType())
           .append("\n");
        str.append("PType = ")
           .append(getPType())
           .append("\n");
        return(str.toString());
    }
}
