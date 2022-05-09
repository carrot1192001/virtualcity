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
import com.youku.atm.om.bean.IdeaDirectionBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to IdeaDirection
 */
public abstract class BaseIdeaDirection extends BaseObject
{
    /** The Peer class */
    private static final IdeaDirectionPeer peer =
        new IdeaDirectionPeer();


    /** The value for the id field */
    private int id;

    /** The value for the castId field */
    private int castId;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the directionType field */
    private String directionType;

    /** The value for the directionValue field */
    private String directionValue;


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
     * Get the DirectionType
     *
     * @return String
     */
    public String getDirectionType()
    {
        return directionType;
    }


    /**
     * Set the value of DirectionType
     *
     * @param v new value
     */
    public void setDirectionType(String v) 
    {

        if (!ObjectUtils.equals(this.directionType, v))
        {
            this.directionType = v;
            setModified(true);
        }


    }

    /**
     * Get the DirectionValue
     *
     * @return String
     */
    public String getDirectionValue()
    {
        return directionValue;
    }


    /**
     * Set the value of DirectionValue
     *
     * @param v new value
     */
    public void setDirectionValue(String v) 
    {

        if (!ObjectUtils.equals(this.directionValue, v))
        {
            this.directionValue = v;
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
            fieldNames.add("DirectionType");
            fieldNames.add("DirectionValue");
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
        if (name.equals("CastId"))
        {
            return new Integer(getCastId());
        }
        if (name.equals("IdeaId"))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals("DirectionType"))
        {
            return getDirectionType();
        }
        if (name.equals("DirectionValue"))
        {
            return getDirectionValue();
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
        if (name.equals("DirectionType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDirectionType((String) value);
            return true;
        }
        if (name.equals("DirectionValue"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDirectionValue((String) value);
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
        if (name.equals(IdeaDirectionPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IdeaDirectionPeer.CAST_ID))
        {
            return new Integer(getCastId());
        }
        if (name.equals(IdeaDirectionPeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(IdeaDirectionPeer.DIRECTION_TYPE))
        {
            return getDirectionType();
        }
        if (name.equals(IdeaDirectionPeer.DIRECTION_VALUE))
        {
            return getDirectionValue();
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
      if (IdeaDirectionPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IdeaDirectionPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
        }
      if (IdeaDirectionPeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (IdeaDirectionPeer.DIRECTION_TYPE.equals(name))
        {
            return setByName("DirectionType", value);
        }
      if (IdeaDirectionPeer.DIRECTION_VALUE.equals(name))
        {
            return setByName("DirectionValue", value);
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
            return new Integer(getCastId());
        }
        if (pos == 2)
        {
            return new Integer(getIdeaId());
        }
        if (pos == 3)
        {
            return getDirectionType();
        }
        if (pos == 4)
        {
            return getDirectionValue();
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
            return setByName("DirectionType", value);
        }
    if (position == 4)
        {
            return setByName("DirectionValue", value);
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
        save(IdeaDirectionPeer.DATABASE_NAME);
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
                    IdeaDirectionPeer.doInsert((IdeaDirection) this, con);
                    setNew(false);
                }
                else
                {
                    IdeaDirectionPeer.doUpdate((IdeaDirection) this, con);
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
    public IdeaDirection copy() throws TorqueException
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
    public IdeaDirection copy(Connection con) throws TorqueException
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
    public IdeaDirection copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new IdeaDirection(), deepcopy);
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
    public IdeaDirection copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new IdeaDirection(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected IdeaDirection copyInto(IdeaDirection copyObj) throws TorqueException
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
    protected IdeaDirection copyInto(IdeaDirection copyObj, Connection con) throws TorqueException
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
    protected IdeaDirection copyInto(IdeaDirection copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setIdeaId(ideaId);
        copyObj.setDirectionType(directionType);
        copyObj.setDirectionValue(directionValue);

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
    protected IdeaDirection copyInto(IdeaDirection copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setIdeaId(ideaId);
        copyObj.setDirectionType(directionType);
        copyObj.setDirectionValue(directionValue);

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
    public IdeaDirectionPeer getPeer()
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
        return IdeaDirectionPeer.getTableMap();
    }

  
    /**
     * Creates a IdeaDirectionBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IdeaDirectionBean with the contents of this object
     */
    public IdeaDirectionBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IdeaDirectionBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IdeaDirectionBean with the contents of this object
     */
    public IdeaDirectionBean getBean(IdentityMap createdBeans)
    {
        IdeaDirectionBean result = (IdeaDirectionBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IdeaDirectionBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setCastId(getCastId());
        result.setIdeaId(getIdeaId());
        result.setDirectionType(getDirectionType());
        result.setDirectionValue(getDirectionValue());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of IdeaDirection with the contents
     * of a IdeaDirectionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IdeaDirectionBean which contents are used to create
     *        the resulting class
     * @return an instance of IdeaDirection with the contents of bean
     */
    public static IdeaDirection createIdeaDirection(IdeaDirectionBean bean)
        throws TorqueException
    {
        return createIdeaDirection(bean, new IdentityMap());
    }

    /**
     * Creates an instance of IdeaDirection with the contents
     * of a IdeaDirectionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IdeaDirectionBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of IdeaDirection with the contents of bean
     */

    public static IdeaDirection createIdeaDirection(IdeaDirectionBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        IdeaDirection result = (IdeaDirection) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new IdeaDirection();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setCastId(bean.getCastId());
        result.setIdeaId(bean.getIdeaId());
        result.setDirectionType(bean.getDirectionType());
        result.setDirectionValue(bean.getDirectionValue());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("IdeaDirection:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("DirectionType = ")
           .append(getDirectionType())
           .append("\n");
        str.append("DirectionValue = ")
           .append(getDirectionValue())
           .append("\n");
        return(str.toString());
    }
}
