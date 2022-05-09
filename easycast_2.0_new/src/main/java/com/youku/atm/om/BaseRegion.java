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
import com.youku.atm.om.bean.RegionBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Region
 */
public abstract class BaseRegion extends BaseObject
{
    /** The Peer class */
    private static final RegionPeer peer =
        new RegionPeer();


    /** The value for the id field */
    private int id;

    /** The value for the cityId field */
    private String cityId;

    /** The value for the provinceId field */
    private String provinceId;

    /** The value for the startIp field */
    private String startIp;

    /** The value for the endIp field */
    private String endIp;

    /** The value for the geoid field */
    private String geoid;


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
     * Get the CityId
     *
     * @return String
     */
    public String getCityId()
    {
        return cityId;
    }


    /**
     * Set the value of CityId
     *
     * @param v new value
     */
    public void setCityId(String v) 
    {

        if (!ObjectUtils.equals(this.cityId, v))
        {
            this.cityId = v;
            setModified(true);
        }


    }

    /**
     * Get the ProvinceId
     *
     * @return String
     */
    public String getProvinceId()
    {
        return provinceId;
    }


    /**
     * Set the value of ProvinceId
     *
     * @param v new value
     */
    public void setProvinceId(String v) 
    {

        if (!ObjectUtils.equals(this.provinceId, v))
        {
            this.provinceId = v;
            setModified(true);
        }


    }

    /**
     * Get the StartIp
     *
     * @return String
     */
    public String getStartIp()
    {
        return startIp;
    }


    /**
     * Set the value of StartIp
     *
     * @param v new value
     */
    public void setStartIp(String v) 
    {

        if (!ObjectUtils.equals(this.startIp, v))
        {
            this.startIp = v;
            setModified(true);
        }


    }

    /**
     * Get the EndIp
     *
     * @return String
     */
    public String getEndIp()
    {
        return endIp;
    }


    /**
     * Set the value of EndIp
     *
     * @param v new value
     */
    public void setEndIp(String v) 
    {

        if (!ObjectUtils.equals(this.endIp, v))
        {
            this.endIp = v;
            setModified(true);
        }


    }

    /**
     * Get the Geoid
     *
     * @return String
     */
    public String getGeoid()
    {
        return geoid;
    }


    /**
     * Set the value of Geoid
     *
     * @param v new value
     */
    public void setGeoid(String v) 
    {

        if (!ObjectUtils.equals(this.geoid, v))
        {
            this.geoid = v;
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
            fieldNames.add("CityId");
            fieldNames.add("ProvinceId");
            fieldNames.add("StartIp");
            fieldNames.add("EndIp");
            fieldNames.add("Geoid");
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
        if (name.equals("CityId"))
        {
            return getCityId();
        }
        if (name.equals("ProvinceId"))
        {
            return getProvinceId();
        }
        if (name.equals("StartIp"))
        {
            return getStartIp();
        }
        if (name.equals("EndIp"))
        {
            return getEndIp();
        }
        if (name.equals("Geoid"))
        {
            return getGeoid();
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
        if (name.equals("CityId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCityId((String) value);
            return true;
        }
        if (name.equals("ProvinceId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setProvinceId((String) value);
            return true;
        }
        if (name.equals("StartIp"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStartIp((String) value);
            return true;
        }
        if (name.equals("EndIp"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEndIp((String) value);
            return true;
        }
        if (name.equals("Geoid"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setGeoid((String) value);
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
        if (name.equals(RegionPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(RegionPeer.CITY_ID))
        {
            return getCityId();
        }
        if (name.equals(RegionPeer.PROVINCE_ID))
        {
            return getProvinceId();
        }
        if (name.equals(RegionPeer.START_IP))
        {
            return getStartIp();
        }
        if (name.equals(RegionPeer.END_IP))
        {
            return getEndIp();
        }
        if (name.equals(RegionPeer.GEOID))
        {
            return getGeoid();
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
      if (RegionPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (RegionPeer.CITY_ID.equals(name))
        {
            return setByName("CityId", value);
        }
      if (RegionPeer.PROVINCE_ID.equals(name))
        {
            return setByName("ProvinceId", value);
        }
      if (RegionPeer.START_IP.equals(name))
        {
            return setByName("StartIp", value);
        }
      if (RegionPeer.END_IP.equals(name))
        {
            return setByName("EndIp", value);
        }
      if (RegionPeer.GEOID.equals(name))
        {
            return setByName("Geoid", value);
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
            return getCityId();
        }
        if (pos == 2)
        {
            return getProvinceId();
        }
        if (pos == 3)
        {
            return getStartIp();
        }
        if (pos == 4)
        {
            return getEndIp();
        }
        if (pos == 5)
        {
            return getGeoid();
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
            return setByName("CityId", value);
        }
    if (position == 2)
        {
            return setByName("ProvinceId", value);
        }
    if (position == 3)
        {
            return setByName("StartIp", value);
        }
    if (position == 4)
        {
            return setByName("EndIp", value);
        }
    if (position == 5)
        {
            return setByName("Geoid", value);
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
        save(RegionPeer.DATABASE_NAME);
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
                    RegionPeer.doInsert((Region) this, con);
                    setNew(false);
                }
                else
                {
                    RegionPeer.doUpdate((Region) this, con);
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
    public Region copy() throws TorqueException
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
    public Region copy(Connection con) throws TorqueException
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
    public Region copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Region(), deepcopy);
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
    public Region copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Region(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Region copyInto(Region copyObj) throws TorqueException
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
    protected Region copyInto(Region copyObj, Connection con) throws TorqueException
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
    protected Region copyInto(Region copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCityId(cityId);
        copyObj.setProvinceId(provinceId);
        copyObj.setStartIp(startIp);
        copyObj.setEndIp(endIp);
        copyObj.setGeoid(geoid);

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
    protected Region copyInto(Region copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCityId(cityId);
        copyObj.setProvinceId(provinceId);
        copyObj.setStartIp(startIp);
        copyObj.setEndIp(endIp);
        copyObj.setGeoid(geoid);

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
    public RegionPeer getPeer()
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
        return RegionPeer.getTableMap();
    }

  
    /**
     * Creates a RegionBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a RegionBean with the contents of this object
     */
    public RegionBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a RegionBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a RegionBean with the contents of this object
     */
    public RegionBean getBean(IdentityMap createdBeans)
    {
        RegionBean result = (RegionBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new RegionBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setCityId(getCityId());
        result.setProvinceId(getProvinceId());
        result.setStartIp(getStartIp());
        result.setEndIp(getEndIp());
        result.setGeoid(getGeoid());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Region with the contents
     * of a RegionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the RegionBean which contents are used to create
     *        the resulting class
     * @return an instance of Region with the contents of bean
     */
    public static Region createRegion(RegionBean bean)
        throws TorqueException
    {
        return createRegion(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Region with the contents
     * of a RegionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the RegionBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Region with the contents of bean
     */

    public static Region createRegion(RegionBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Region result = (Region) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Region();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setCityId(bean.getCityId());
        result.setProvinceId(bean.getProvinceId());
        result.setStartIp(bean.getStartIp());
        result.setEndIp(bean.getEndIp());
        result.setGeoid(bean.getGeoid());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Region:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("CityId = ")
           .append(getCityId())
           .append("\n");
        str.append("ProvinceId = ")
           .append(getProvinceId())
           .append("\n");
        str.append("StartIp = ")
           .append(getStartIp())
           .append("\n");
        str.append("EndIp = ")
           .append(getEndIp())
           .append("\n");
        str.append("Geoid = ")
           .append(getGeoid())
           .append("\n");
        return(str.toString());
    }
}
