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
import com.youku.atm.om.bean.AdlenRangeBean;
import com.youku.atm.om.bean.ResourceBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to AdlenRange
 */
public abstract class BaseAdlenRange extends BaseObject
{
    /** The Peer class */
    private static final AdlenRangePeer peer =
        new AdlenRangePeer();


    /** The value for the id field */
    private int id;

    /** The value for the vPointId field */
    private String vPointId;

    /** The value for the vlenLow field */
    private int vlenLow;

    /** The value for the vlenHigh field */
    private int vlenHigh;

    /** The value for the adlenMax field */
    private int adlenMax;

    /** The value for the adcountMax field */
    private int adcountMax;

    /** The value for the resourceId field */
    private int resourceId;

    /** The value for the status field */
    private int status;

    /** The value for the isuserange field */
    private int isuserange = 1;


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
     * Get the VPointId
     *
     * @return String
     */
    public String getVPointId()
    {
        return vPointId;
    }


    /**
     * Set the value of VPointId
     *
     * @param v new value
     */
    public void setVPointId(String v) 
    {

        if (!ObjectUtils.equals(this.vPointId, v))
        {
            this.vPointId = v;
            setModified(true);
        }


    }

    /**
     * Get the VlenLow
     *
     * @return int
     */
    public int getVlenLow()
    {
        return vlenLow;
    }


    /**
     * Set the value of VlenLow
     *
     * @param v new value
     */
    public void setVlenLow(int v) 
    {

        if (this.vlenLow != v)
        {
            this.vlenLow = v;
            setModified(true);
        }


    }

    /**
     * Get the VlenHigh
     *
     * @return int
     */
    public int getVlenHigh()
    {
        return vlenHigh;
    }


    /**
     * Set the value of VlenHigh
     *
     * @param v new value
     */
    public void setVlenHigh(int v) 
    {

        if (this.vlenHigh != v)
        {
            this.vlenHigh = v;
            setModified(true);
        }


    }

    /**
     * Get the AdlenMax
     *
     * @return int
     */
    public int getAdlenMax()
    {
        return adlenMax;
    }


    /**
     * Set the value of AdlenMax
     *
     * @param v new value
     */
    public void setAdlenMax(int v) 
    {

        if (this.adlenMax != v)
        {
            this.adlenMax = v;
            setModified(true);
        }


    }

    /**
     * Get the AdcountMax
     *
     * @return int
     */
    public int getAdcountMax()
    {
        return adcountMax;
    }


    /**
     * Set the value of AdcountMax
     *
     * @param v new value
     */
    public void setAdcountMax(int v) 
    {

        if (this.adcountMax != v)
        {
            this.adcountMax = v;
            setModified(true);
        }


    }

    /**
     * Get the ResourceId
     *
     * @return int
     */
    public int getResourceId()
    {
        return resourceId;
    }


    /**
     * Set the value of ResourceId
     *
     * @param v new value
     */
    public void setResourceId(int v) throws TorqueException
    {

        if (this.resourceId != v)
        {
            this.resourceId = v;
            setModified(true);
        }


        if (aResource != null && !(aResource.getId() == v))
        {
            aResource = null;
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
     * Get the Isuserange
     *
     * @return int
     */
    public int getIsuserange()
    {
        return isuserange;
    }


    /**
     * Set the value of Isuserange
     *
     * @param v new value
     */
    public void setIsuserange(int v) 
    {

        if (this.isuserange != v)
        {
            this.isuserange = v;
            setModified(true);
        }


    }

    



    private Resource aResource;

    /**
     * Declares an association between this object and a Resource object
     *
     * @param v Resource
     * @throws TorqueException
     */
    public void setResource(Resource v) throws TorqueException
    {
        if (v == null)
        {
            setResourceId( 0);
        }
        else
        {
            setResourceId(v.getId());
        }
        aResource = v;
    }


    /**
     * Returns the associated Resource object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Resource object
     * @throws TorqueException
     */
    public Resource getResource()
        throws TorqueException
    {
        if (aResource == null && (this.resourceId != 0))
        {
            aResource = ResourcePeer.retrieveByPK(SimpleKey.keyFor(this.resourceId));
        }
        return aResource;
    }

    /**
     * Return the associated Resource object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Resource object
     * @throws TorqueException
     */
    public Resource getResource(Connection connection)
        throws TorqueException
    {
        if (aResource == null && (this.resourceId != 0))
        {
            aResource = ResourcePeer.retrieveByPK(SimpleKey.keyFor(this.resourceId), connection);
        }
        return aResource;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setResourceKey(ObjectKey key) throws TorqueException
    {

        setResourceId(((NumberKey) key).intValue());
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
            fieldNames.add("VPointId");
            fieldNames.add("VlenLow");
            fieldNames.add("VlenHigh");
            fieldNames.add("AdlenMax");
            fieldNames.add("AdcountMax");
            fieldNames.add("ResourceId");
            fieldNames.add("Status");
            fieldNames.add("Isuserange");
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
        if (name.equals("VPointId"))
        {
            return getVPointId();
        }
        if (name.equals("VlenLow"))
        {
            return new Integer(getVlenLow());
        }
        if (name.equals("VlenHigh"))
        {
            return new Integer(getVlenHigh());
        }
        if (name.equals("AdlenMax"))
        {
            return new Integer(getAdlenMax());
        }
        if (name.equals("AdcountMax"))
        {
            return new Integer(getAdcountMax());
        }
        if (name.equals("ResourceId"))
        {
            return new Integer(getResourceId());
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("Isuserange"))
        {
            return new Integer(getIsuserange());
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
        if (name.equals("VPointId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setVPointId((String) value);
            return true;
        }
        if (name.equals("VlenLow"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setVlenLow(((Integer) value).intValue());
            return true;
        }
        if (name.equals("VlenHigh"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setVlenHigh(((Integer) value).intValue());
            return true;
        }
        if (name.equals("AdlenMax"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAdlenMax(((Integer) value).intValue());
            return true;
        }
        if (name.equals("AdcountMax"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAdcountMax(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ResourceId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setResourceId(((Integer) value).intValue());
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
        if (name.equals("Isuserange"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsuserange(((Integer) value).intValue());
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
        if (name.equals(AdlenRangePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(AdlenRangePeer.V_POINT_ID))
        {
            return getVPointId();
        }
        if (name.equals(AdlenRangePeer.VLEN_LOW))
        {
            return new Integer(getVlenLow());
        }
        if (name.equals(AdlenRangePeer.VLEN_HIGH))
        {
            return new Integer(getVlenHigh());
        }
        if (name.equals(AdlenRangePeer.ADLEN_MAX))
        {
            return new Integer(getAdlenMax());
        }
        if (name.equals(AdlenRangePeer.ADCOUNT_MAX))
        {
            return new Integer(getAdcountMax());
        }
        if (name.equals(AdlenRangePeer.RESOURCE_ID))
        {
            return new Integer(getResourceId());
        }
        if (name.equals(AdlenRangePeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(AdlenRangePeer.ISUSERANGE))
        {
            return new Integer(getIsuserange());
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
      if (AdlenRangePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (AdlenRangePeer.V_POINT_ID.equals(name))
        {
            return setByName("VPointId", value);
        }
      if (AdlenRangePeer.VLEN_LOW.equals(name))
        {
            return setByName("VlenLow", value);
        }
      if (AdlenRangePeer.VLEN_HIGH.equals(name))
        {
            return setByName("VlenHigh", value);
        }
      if (AdlenRangePeer.ADLEN_MAX.equals(name))
        {
            return setByName("AdlenMax", value);
        }
      if (AdlenRangePeer.ADCOUNT_MAX.equals(name))
        {
            return setByName("AdcountMax", value);
        }
      if (AdlenRangePeer.RESOURCE_ID.equals(name))
        {
            return setByName("ResourceId", value);
        }
      if (AdlenRangePeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (AdlenRangePeer.ISUSERANGE.equals(name))
        {
            return setByName("Isuserange", value);
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
            return getVPointId();
        }
        if (pos == 2)
        {
            return new Integer(getVlenLow());
        }
        if (pos == 3)
        {
            return new Integer(getVlenHigh());
        }
        if (pos == 4)
        {
            return new Integer(getAdlenMax());
        }
        if (pos == 5)
        {
            return new Integer(getAdcountMax());
        }
        if (pos == 6)
        {
            return new Integer(getResourceId());
        }
        if (pos == 7)
        {
            return new Integer(getStatus());
        }
        if (pos == 8)
        {
            return new Integer(getIsuserange());
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
            return setByName("VPointId", value);
        }
    if (position == 2)
        {
            return setByName("VlenLow", value);
        }
    if (position == 3)
        {
            return setByName("VlenHigh", value);
        }
    if (position == 4)
        {
            return setByName("AdlenMax", value);
        }
    if (position == 5)
        {
            return setByName("AdcountMax", value);
        }
    if (position == 6)
        {
            return setByName("ResourceId", value);
        }
    if (position == 7)
        {
            return setByName("Status", value);
        }
    if (position == 8)
        {
            return setByName("Isuserange", value);
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
        save(AdlenRangePeer.DATABASE_NAME);
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
                    AdlenRangePeer.doInsert((AdlenRange) this, con);
                    setNew(false);
                }
                else
                {
                    AdlenRangePeer.doUpdate((AdlenRange) this, con);
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
    public AdlenRange copy() throws TorqueException
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
    public AdlenRange copy(Connection con) throws TorqueException
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
    public AdlenRange copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new AdlenRange(), deepcopy);
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
    public AdlenRange copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new AdlenRange(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected AdlenRange copyInto(AdlenRange copyObj) throws TorqueException
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
    protected AdlenRange copyInto(AdlenRange copyObj, Connection con) throws TorqueException
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
    protected AdlenRange copyInto(AdlenRange copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setVPointId(vPointId);
        copyObj.setVlenLow(vlenLow);
        copyObj.setVlenHigh(vlenHigh);
        copyObj.setAdlenMax(adlenMax);
        copyObj.setAdcountMax(adcountMax);
        copyObj.setResourceId(resourceId);
        copyObj.setStatus(status);
        copyObj.setIsuserange(isuserange);

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
    protected AdlenRange copyInto(AdlenRange copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setVPointId(vPointId);
        copyObj.setVlenLow(vlenLow);
        copyObj.setVlenHigh(vlenHigh);
        copyObj.setAdlenMax(adlenMax);
        copyObj.setAdcountMax(adcountMax);
        copyObj.setResourceId(resourceId);
        copyObj.setStatus(status);
        copyObj.setIsuserange(isuserange);

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
    public AdlenRangePeer getPeer()
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
        return AdlenRangePeer.getTableMap();
    }

  
    /**
     * Creates a AdlenRangeBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a AdlenRangeBean with the contents of this object
     */
    public AdlenRangeBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a AdlenRangeBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a AdlenRangeBean with the contents of this object
     */
    public AdlenRangeBean getBean(IdentityMap createdBeans)
    {
        AdlenRangeBean result = (AdlenRangeBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new AdlenRangeBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setVPointId(getVPointId());
        result.setVlenLow(getVlenLow());
        result.setVlenHigh(getVlenHigh());
        result.setAdlenMax(getAdlenMax());
        result.setAdcountMax(getAdcountMax());
        result.setResourceId(getResourceId());
        result.setStatus(getStatus());
        result.setIsuserange(getIsuserange());





        if (aResource != null)
        {
            ResourceBean relatedBean = aResource.getBean(createdBeans);
            result.setResourceBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of AdlenRange with the contents
     * of a AdlenRangeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the AdlenRangeBean which contents are used to create
     *        the resulting class
     * @return an instance of AdlenRange with the contents of bean
     */
    public static AdlenRange createAdlenRange(AdlenRangeBean bean)
        throws TorqueException
    {
        return createAdlenRange(bean, new IdentityMap());
    }

    /**
     * Creates an instance of AdlenRange with the contents
     * of a AdlenRangeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the AdlenRangeBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of AdlenRange with the contents of bean
     */

    public static AdlenRange createAdlenRange(AdlenRangeBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        AdlenRange result = (AdlenRange) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new AdlenRange();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setVPointId(bean.getVPointId());
        result.setVlenLow(bean.getVlenLow());
        result.setVlenHigh(bean.getVlenHigh());
        result.setAdlenMax(bean.getAdlenMax());
        result.setAdcountMax(bean.getAdcountMax());
        result.setResourceId(bean.getResourceId());
        result.setStatus(bean.getStatus());
        result.setIsuserange(bean.getIsuserange());





        {
            ResourceBean relatedBean = bean.getResourceBean();
            if (relatedBean != null)
            {
                Resource relatedObject = Resource.createResource(relatedBean, createdObjects);
                result.setResource(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("AdlenRange:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("VPointId = ")
           .append(getVPointId())
           .append("\n");
        str.append("VlenLow = ")
           .append(getVlenLow())
           .append("\n");
        str.append("VlenHigh = ")
           .append(getVlenHigh())
           .append("\n");
        str.append("AdlenMax = ")
           .append(getAdlenMax())
           .append("\n");
        str.append("AdcountMax = ")
           .append(getAdcountMax())
           .append("\n");
        str.append("ResourceId = ")
           .append(getResourceId())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("Isuserange = ")
           .append(getIsuserange())
           .append("\n");
        return(str.toString());
    }
}
