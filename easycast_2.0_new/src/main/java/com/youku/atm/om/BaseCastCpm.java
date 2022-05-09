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
import com.youku.atm.om.bean.CastCpmBean;
import com.youku.atm.om.bean.AdCastBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to CastCpm
 */
public abstract class BaseCastCpm extends BaseObject
{
    /** The Peer class */
    private static final CastCpmPeer peer =
        new CastCpmPeer();


    /** The value for the id field */
    private int id;

    /** The value for the castId field */
    private int castId;

    /** The value for the cpm field */
    private int cpm;

    /** The value for the cpc field */
    private int cpc;

    /** The value for the lun field */
    private String lun;

    /** The value for the percent field */
    private int percent;

    /** The value for the cpv field */
    private int cpv = 0;

    /** The value for the cpp field */
    private int cpp = 0;

    /** The value for the dcId field */
    private int dcId = 0;

    /** The value for the dcId2 field */
    private int dcId2 = 0;

    /** The value for the targetDate field */
    private Date targetDate;


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
     * Get the Cpm
     *
     * @return int
     */
    public int getCpm()
    {
        return cpm;
    }


    /**
     * Set the value of Cpm
     *
     * @param v new value
     */
    public void setCpm(int v) 
    {

        if (this.cpm != v)
        {
            this.cpm = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpc
     *
     * @return int
     */
    public int getCpc()
    {
        return cpc;
    }


    /**
     * Set the value of Cpc
     *
     * @param v new value
     */
    public void setCpc(int v) 
    {

        if (this.cpc != v)
        {
            this.cpc = v;
            setModified(true);
        }


    }

    /**
     * Get the Lun
     *
     * @return String
     */
    public String getLun()
    {
        return lun;
    }


    /**
     * Set the value of Lun
     *
     * @param v new value
     */
    public void setLun(String v) 
    {

        if (!ObjectUtils.equals(this.lun, v))
        {
            this.lun = v;
            setModified(true);
        }


    }

    /**
     * Get the Percent
     *
     * @return int
     */
    public int getPercent()
    {
        return percent;
    }


    /**
     * Set the value of Percent
     *
     * @param v new value
     */
    public void setPercent(int v) 
    {

        if (this.percent != v)
        {
            this.percent = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpv
     *
     * @return int
     */
    public int getCpv()
    {
        return cpv;
    }


    /**
     * Set the value of Cpv
     *
     * @param v new value
     */
    public void setCpv(int v) 
    {

        if (this.cpv != v)
        {
            this.cpv = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpp
     *
     * @return int
     */
    public int getCpp()
    {
        return cpp;
    }


    /**
     * Set the value of Cpp
     *
     * @param v new value
     */
    public void setCpp(int v) 
    {

        if (this.cpp != v)
        {
            this.cpp = v;
            setModified(true);
        }


    }

    /**
     * Get the DcId
     *
     * @return int
     */
    public int getDcId()
    {
        return dcId;
    }


    /**
     * Set the value of DcId
     *
     * @param v new value
     */
    public void setDcId(int v) 
    {

        if (this.dcId != v)
        {
            this.dcId = v;
            setModified(true);
        }


    }

    /**
     * Get the DcId2
     *
     * @return int
     */
    public int getDcId2()
    {
        return dcId2;
    }


    /**
     * Set the value of DcId2
     *
     * @param v new value
     */
    public void setDcId2(int v) 
    {

        if (this.dcId2 != v)
        {
            this.dcId2 = v;
            setModified(true);
        }


    }

    /**
     * Get the TargetDate
     *
     * @return Date
     */
    public Date getTargetDate()
    {
        return targetDate;
    }


    /**
     * Set the value of TargetDate
     *
     * @param v new value
     */
    public void setTargetDate(Date v) 
    {

        if (!ObjectUtils.equals(this.targetDate, v))
        {
            this.targetDate = v;
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
            fieldNames.add("Cpm");
            fieldNames.add("Cpc");
            fieldNames.add("Lun");
            fieldNames.add("Percent");
            fieldNames.add("Cpv");
            fieldNames.add("Cpp");
            fieldNames.add("DcId");
            fieldNames.add("DcId2");
            fieldNames.add("TargetDate");
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
        if (name.equals("Cpm"))
        {
            return new Integer(getCpm());
        }
        if (name.equals("Cpc"))
        {
            return new Integer(getCpc());
        }
        if (name.equals("Lun"))
        {
            return getLun();
        }
        if (name.equals("Percent"))
        {
            return new Integer(getPercent());
        }
        if (name.equals("Cpv"))
        {
            return new Integer(getCpv());
        }
        if (name.equals("Cpp"))
        {
            return new Integer(getCpp());
        }
        if (name.equals("DcId"))
        {
            return new Integer(getDcId());
        }
        if (name.equals("DcId2"))
        {
            return new Integer(getDcId2());
        }
        if (name.equals("TargetDate"))
        {
            return getTargetDate();
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
        if (name.equals("Cpm"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpm(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpc"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpc(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Lun"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLun((String) value);
            return true;
        }
        if (name.equals("Percent"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPercent(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpv"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpv(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpp"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpp(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DcId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDcId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DcId2"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDcId2(((Integer) value).intValue());
            return true;
        }
        if (name.equals("TargetDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTargetDate((Date) value);
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
        if (name.equals(CastCpmPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(CastCpmPeer.CAST_ID))
        {
            return new Integer(getCastId());
        }
        if (name.equals(CastCpmPeer.CPM))
        {
            return new Integer(getCpm());
        }
        if (name.equals(CastCpmPeer.CPC))
        {
            return new Integer(getCpc());
        }
        if (name.equals(CastCpmPeer.LUN))
        {
            return getLun();
        }
        if (name.equals(CastCpmPeer.PERCENT))
        {
            return new Integer(getPercent());
        }
        if (name.equals(CastCpmPeer.CPV))
        {
            return new Integer(getCpv());
        }
        if (name.equals(CastCpmPeer.CPP))
        {
            return new Integer(getCpp());
        }
        if (name.equals(CastCpmPeer.DC_ID))
        {
            return new Integer(getDcId());
        }
        if (name.equals(CastCpmPeer.DC_ID2))
        {
            return new Integer(getDcId2());
        }
        if (name.equals(CastCpmPeer.TARGET_DATE))
        {
            return getTargetDate();
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
      if (CastCpmPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (CastCpmPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
        }
      if (CastCpmPeer.CPM.equals(name))
        {
            return setByName("Cpm", value);
        }
      if (CastCpmPeer.CPC.equals(name))
        {
            return setByName("Cpc", value);
        }
      if (CastCpmPeer.LUN.equals(name))
        {
            return setByName("Lun", value);
        }
      if (CastCpmPeer.PERCENT.equals(name))
        {
            return setByName("Percent", value);
        }
      if (CastCpmPeer.CPV.equals(name))
        {
            return setByName("Cpv", value);
        }
      if (CastCpmPeer.CPP.equals(name))
        {
            return setByName("Cpp", value);
        }
      if (CastCpmPeer.DC_ID.equals(name))
        {
            return setByName("DcId", value);
        }
      if (CastCpmPeer.DC_ID2.equals(name))
        {
            return setByName("DcId2", value);
        }
      if (CastCpmPeer.TARGET_DATE.equals(name))
        {
            return setByName("TargetDate", value);
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
            return new Integer(getCpm());
        }
        if (pos == 3)
        {
            return new Integer(getCpc());
        }
        if (pos == 4)
        {
            return getLun();
        }
        if (pos == 5)
        {
            return new Integer(getPercent());
        }
        if (pos == 6)
        {
            return new Integer(getCpv());
        }
        if (pos == 7)
        {
            return new Integer(getCpp());
        }
        if (pos == 8)
        {
            return new Integer(getDcId());
        }
        if (pos == 9)
        {
            return new Integer(getDcId2());
        }
        if (pos == 10)
        {
            return getTargetDate();
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
            return setByName("Cpm", value);
        }
    if (position == 3)
        {
            return setByName("Cpc", value);
        }
    if (position == 4)
        {
            return setByName("Lun", value);
        }
    if (position == 5)
        {
            return setByName("Percent", value);
        }
    if (position == 6)
        {
            return setByName("Cpv", value);
        }
    if (position == 7)
        {
            return setByName("Cpp", value);
        }
    if (position == 8)
        {
            return setByName("DcId", value);
        }
    if (position == 9)
        {
            return setByName("DcId2", value);
        }
    if (position == 10)
        {
            return setByName("TargetDate", value);
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
        save(CastCpmPeer.DATABASE_NAME);
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
                    CastCpmPeer.doInsert((CastCpm) this, con);
                    setNew(false);
                }
                else
                {
                    CastCpmPeer.doUpdate((CastCpm) this, con);
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
    public CastCpm copy() throws TorqueException
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
    public CastCpm copy(Connection con) throws TorqueException
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
    public CastCpm copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new CastCpm(), deepcopy);
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
    public CastCpm copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new CastCpm(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected CastCpm copyInto(CastCpm copyObj) throws TorqueException
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
    protected CastCpm copyInto(CastCpm copyObj, Connection con) throws TorqueException
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
    protected CastCpm copyInto(CastCpm copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setCpm(cpm);
        copyObj.setCpc(cpc);
        copyObj.setLun(lun);
        copyObj.setPercent(percent);
        copyObj.setCpv(cpv);
        copyObj.setCpp(cpp);
        copyObj.setDcId(dcId);
        copyObj.setDcId2(dcId2);
        copyObj.setTargetDate(targetDate);

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
    protected CastCpm copyInto(CastCpm copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setCpm(cpm);
        copyObj.setCpc(cpc);
        copyObj.setLun(lun);
        copyObj.setPercent(percent);
        copyObj.setCpv(cpv);
        copyObj.setCpp(cpp);
        copyObj.setDcId(dcId);
        copyObj.setDcId2(dcId2);
        copyObj.setTargetDate(targetDate);

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
    public CastCpmPeer getPeer()
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
        return CastCpmPeer.getTableMap();
    }

  
    /**
     * Creates a CastCpmBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a CastCpmBean with the contents of this object
     */
    public CastCpmBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a CastCpmBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a CastCpmBean with the contents of this object
     */
    public CastCpmBean getBean(IdentityMap createdBeans)
    {
        CastCpmBean result = (CastCpmBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new CastCpmBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setCastId(getCastId());
        result.setCpm(getCpm());
        result.setCpc(getCpc());
        result.setLun(getLun());
        result.setPercent(getPercent());
        result.setCpv(getCpv());
        result.setCpp(getCpp());
        result.setDcId(getDcId());
        result.setDcId2(getDcId2());
        result.setTargetDate(getTargetDate());





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
     * Creates an instance of CastCpm with the contents
     * of a CastCpmBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the CastCpmBean which contents are used to create
     *        the resulting class
     * @return an instance of CastCpm with the contents of bean
     */
    public static CastCpm createCastCpm(CastCpmBean bean)
        throws TorqueException
    {
        return createCastCpm(bean, new IdentityMap());
    }

    /**
     * Creates an instance of CastCpm with the contents
     * of a CastCpmBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the CastCpmBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of CastCpm with the contents of bean
     */

    public static CastCpm createCastCpm(CastCpmBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        CastCpm result = (CastCpm) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new CastCpm();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setCastId(bean.getCastId());
        result.setCpm(bean.getCpm());
        result.setCpc(bean.getCpc());
        result.setLun(bean.getLun());
        result.setPercent(bean.getPercent());
        result.setCpv(bean.getCpv());
        result.setCpp(bean.getCpp());
        result.setDcId(bean.getDcId());
        result.setDcId2(bean.getDcId2());
        result.setTargetDate(bean.getTargetDate());





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
        str.append("CastCpm:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        str.append("Cpm = ")
           .append(getCpm())
           .append("\n");
        str.append("Cpc = ")
           .append(getCpc())
           .append("\n");
        str.append("Lun = ")
           .append(getLun())
           .append("\n");
        str.append("Percent = ")
           .append(getPercent())
           .append("\n");
        str.append("Cpv = ")
           .append(getCpv())
           .append("\n");
        str.append("Cpp = ")
           .append(getCpp())
           .append("\n");
        str.append("DcId = ")
           .append(getDcId())
           .append("\n");
        str.append("DcId2 = ")
           .append(getDcId2())
           .append("\n");
        str.append("TargetDate = ")
           .append(getTargetDate())
           .append("\n");
        return(str.toString());
    }
}
