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
import com.youku.atm.om.bean.CastDirectionBean;
import com.youku.atm.om.bean.AdCastBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to CastDirection
 */
public abstract class BaseCastDirection extends BaseObject
{
    /** The Peer class */
    private static final CastDirectionPeer peer =
        new CastDirectionPeer();


    /** The value for the id field */
    private int id;

    /** The value for the castId field */
    private int castId;

    /** The value for the directName field */
    private String directName;

    /** The value for the directValue field */
    private String directValue;

    /** The value for the isPositive field */
    private int isPositive = 1;

    /** The value for the type field */
    private int type = 0;


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
    public void setCastId(int v) throws TorqueException
    {

        if (this.castId != v)
        {
            this.castId = v;
            setModified(true);
        }


        if (aAdCast != null && !(aAdCast.getId() == v))
        {
            aAdCast = null;
        }

    }

    /**
     * Get the DirectName
     *
     * @return String
     */
    public String getDirectName()
    {
        return directName;
    }


    /**
     * Set the value of DirectName
     *
     * @param v new value
     */
    public void setDirectName(String v) 
    {

        if (!ObjectUtils.equals(this.directName, v))
        {
            this.directName = v;
            setModified(true);
        }


    }

    /**
     * Get the DirectValue
     *
     * @return String
     */
    public String getDirectValue()
    {
        return directValue;
    }


    /**
     * Set the value of DirectValue
     *
     * @param v new value
     */
    public void setDirectValue(String v) 
    {

        if (!ObjectUtils.equals(this.directValue, v))
        {
            this.directValue = v;
            setModified(true);
        }


    }

    /**
     * Get the IsPositive
     *
     * @return int
     */
    public int getIsPositive()
    {
        return isPositive;
    }


    /**
     * Set the value of IsPositive
     *
     * @param v new value
     */
    public void setIsPositive(int v) 
    {

        if (this.isPositive != v)
        {
            this.isPositive = v;
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

    



    private AdCast aAdCast;

    /**
     * Declares an association between this object and a AdCast object
     *
     * @param v AdCast
     * @throws TorqueException
     */
    public void setAdCast(AdCast v) throws TorqueException
    {
        if (v == null)
        {
            setCastId( 0);
        }
        else
        {
            setCastId(v.getId());
        }
        aAdCast = v;
    }


    /**
     * Returns the associated AdCast object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated AdCast object
     * @throws TorqueException
     */
    public AdCast getAdCast()
        throws TorqueException
    {
        if (aAdCast == null && (this.castId != 0))
        {
            aAdCast = AdCastPeer.retrieveByPK(SimpleKey.keyFor(this.castId));
        }
        return aAdCast;
    }

    /**
     * Return the associated AdCast object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated AdCast object
     * @throws TorqueException
     */
    public AdCast getAdCast(Connection connection)
        throws TorqueException
    {
        if (aAdCast == null && (this.castId != 0))
        {
            aAdCast = AdCastPeer.retrieveByPK(SimpleKey.keyFor(this.castId), connection);
        }
        return aAdCast;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setAdCastKey(ObjectKey key) throws TorqueException
    {

        setCastId(((NumberKey) key).intValue());
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
            fieldNames.add("DirectName");
            fieldNames.add("DirectValue");
            fieldNames.add("IsPositive");
            fieldNames.add("Type");
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
        if (name.equals("DirectName"))
        {
            return getDirectName();
        }
        if (name.equals("DirectValue"))
        {
            return getDirectValue();
        }
        if (name.equals("IsPositive"))
        {
            return new Integer(getIsPositive());
        }
        if (name.equals("Type"))
        {
            return new Integer(getType());
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
        if (name.equals("DirectName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDirectName((String) value);
            return true;
        }
        if (name.equals("DirectValue"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDirectValue((String) value);
            return true;
        }
        if (name.equals("IsPositive"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsPositive(((Integer) value).intValue());
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
        if (name.equals(CastDirectionPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(CastDirectionPeer.CAST_ID))
        {
            return new Integer(getCastId());
        }
        if (name.equals(CastDirectionPeer.DIRECT_NAME))
        {
            return getDirectName();
        }
        if (name.equals(CastDirectionPeer.DIRECT_VALUE))
        {
            return getDirectValue();
        }
        if (name.equals(CastDirectionPeer.IS_POSITIVE))
        {
            return new Integer(getIsPositive());
        }
        if (name.equals(CastDirectionPeer.TYPE))
        {
            return new Integer(getType());
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
      if (CastDirectionPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (CastDirectionPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
        }
      if (CastDirectionPeer.DIRECT_NAME.equals(name))
        {
            return setByName("DirectName", value);
        }
      if (CastDirectionPeer.DIRECT_VALUE.equals(name))
        {
            return setByName("DirectValue", value);
        }
      if (CastDirectionPeer.IS_POSITIVE.equals(name))
        {
            return setByName("IsPositive", value);
        }
      if (CastDirectionPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
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
            return getDirectName();
        }
        if (pos == 3)
        {
            return getDirectValue();
        }
        if (pos == 4)
        {
            return new Integer(getIsPositive());
        }
        if (pos == 5)
        {
            return new Integer(getType());
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
            return setByName("DirectName", value);
        }
    if (position == 3)
        {
            return setByName("DirectValue", value);
        }
    if (position == 4)
        {
            return setByName("IsPositive", value);
        }
    if (position == 5)
        {
            return setByName("Type", value);
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
        save(CastDirectionPeer.DATABASE_NAME);
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
                    CastDirectionPeer.doInsert((CastDirection) this, con);
                    setNew(false);
                }
                else
                {
                    CastDirectionPeer.doUpdate((CastDirection) this, con);
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
    public CastDirection copy() throws TorqueException
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
    public CastDirection copy(Connection con) throws TorqueException
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
    public CastDirection copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new CastDirection(), deepcopy);
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
    public CastDirection copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new CastDirection(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected CastDirection copyInto(CastDirection copyObj) throws TorqueException
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
    protected CastDirection copyInto(CastDirection copyObj, Connection con) throws TorqueException
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
    protected CastDirection copyInto(CastDirection copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setDirectName(directName);
        copyObj.setDirectValue(directValue);
        copyObj.setIsPositive(isPositive);
        copyObj.setType(type);

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
    protected CastDirection copyInto(CastDirection copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setDirectName(directName);
        copyObj.setDirectValue(directValue);
        copyObj.setIsPositive(isPositive);
        copyObj.setType(type);

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
    public CastDirectionPeer getPeer()
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
        return CastDirectionPeer.getTableMap();
    }

  
    /**
     * Creates a CastDirectionBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a CastDirectionBean with the contents of this object
     */
    public CastDirectionBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a CastDirectionBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a CastDirectionBean with the contents of this object
     */
    public CastDirectionBean getBean(IdentityMap createdBeans)
    {
        CastDirectionBean result = (CastDirectionBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new CastDirectionBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setCastId(getCastId());
        result.setDirectName(getDirectName());
        result.setDirectValue(getDirectValue());
        result.setIsPositive(getIsPositive());
        result.setType(getType());





        if (aAdCast != null)
        {
            AdCastBean relatedBean = aAdCast.getBean(createdBeans);
            result.setAdCastBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of CastDirection with the contents
     * of a CastDirectionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the CastDirectionBean which contents are used to create
     *        the resulting class
     * @return an instance of CastDirection with the contents of bean
     */
    public static CastDirection createCastDirection(CastDirectionBean bean)
        throws TorqueException
    {
        return createCastDirection(bean, new IdentityMap());
    }

    /**
     * Creates an instance of CastDirection with the contents
     * of a CastDirectionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the CastDirectionBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of CastDirection with the contents of bean
     */

    public static CastDirection createCastDirection(CastDirectionBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        CastDirection result = (CastDirection) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new CastDirection();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setCastId(bean.getCastId());
        result.setDirectName(bean.getDirectName());
        result.setDirectValue(bean.getDirectValue());
        result.setIsPositive(bean.getIsPositive());
        result.setType(bean.getType());





        {
            AdCastBean relatedBean = bean.getAdCastBean();
            if (relatedBean != null)
            {
                AdCast relatedObject = AdCast.createAdCast(relatedBean, createdObjects);
                result.setAdCast(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("CastDirection:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        str.append("DirectName = ")
           .append(getDirectName())
           .append("\n");
        str.append("DirectValue = ")
           .append(getDirectValue())
           .append("\n");
        str.append("IsPositive = ")
           .append(getIsPositive())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        return(str.toString());
    }
}
