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
import com.youku.atm.om.bean.SdkLogBean;
import com.youku.atm.om.bean.SdkDeviceBean;
import com.youku.atm.om.bean.AdTypeBean;
import com.youku.atm.om.bean.SdkNameBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to SdkLog
 */
public abstract class BaseSdkLog extends BaseObject
{
    /** The Peer class */
    private static final SdkLogPeer peer =
        new SdkLogPeer();


    /** The value for the id field */
    private int id;

    /** The value for the sdkDeviceId field */
    private int sdkDeviceId;

    /** The value for the adTypeId field */
    private int adTypeId;

    /** The value for the sdkId field */
    private int sdkId;

    /** The value for the fillingRate field */
    private double fillingRate;

    /** The value for the showNum field */
    private int showNum;

    /** The value for the clickNum field */
    private int clickNum;

    /** The value for the income field */
    private double income;

    /** The value for the atmshow field */
    private int atmshow;

    /** The value for the castId field */
    private int castId;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the createDate field */
    private Date createDate;


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
     * Get the SdkDeviceId
     *
     * @return int
     */
    public int getSdkDeviceId()
    {
        return sdkDeviceId;
    }


    /**
     * Set the value of SdkDeviceId
     *
     * @param v new value
     */
    public void setSdkDeviceId(int v) throws TorqueException
    {

        if (this.sdkDeviceId != v)
        {
            this.sdkDeviceId = v;
            setModified(true);
        }


        if (aSdkDevice != null && !(aSdkDevice.getId() == v))
        {
            aSdkDevice = null;
        }

    }

    /**
     * Get the AdTypeId
     *
     * @return int
     */
    public int getAdTypeId()
    {
        return adTypeId;
    }


    /**
     * Set the value of AdTypeId
     *
     * @param v new value
     */
    public void setAdTypeId(int v) throws TorqueException
    {

        if (this.adTypeId != v)
        {
            this.adTypeId = v;
            setModified(true);
        }


        if (aAdType != null && !(aAdType.getId() == v))
        {
            aAdType = null;
        }

    }

    /**
     * Get the SdkId
     *
     * @return int
     */
    public int getSdkId()
    {
        return sdkId;
    }


    /**
     * Set the value of SdkId
     *
     * @param v new value
     */
    public void setSdkId(int v) throws TorqueException
    {

        if (this.sdkId != v)
        {
            this.sdkId = v;
            setModified(true);
        }


        if (aSdkName != null && !(aSdkName.getId() == v))
        {
            aSdkName = null;
        }

    }

    /**
     * Get the FillingRate
     *
     * @return double
     */
    public double getFillingRate()
    {
        return fillingRate;
    }


    /**
     * Set the value of FillingRate
     *
     * @param v new value
     */
    public void setFillingRate(double v) 
    {

        if (this.fillingRate != v)
        {
            this.fillingRate = v;
            setModified(true);
        }


    }

    /**
     * Get the ShowNum
     *
     * @return int
     */
    public int getShowNum()
    {
        return showNum;
    }


    /**
     * Set the value of ShowNum
     *
     * @param v new value
     */
    public void setShowNum(int v) 
    {

        if (this.showNum != v)
        {
            this.showNum = v;
            setModified(true);
        }


    }

    /**
     * Get the ClickNum
     *
     * @return int
     */
    public int getClickNum()
    {
        return clickNum;
    }


    /**
     * Set the value of ClickNum
     *
     * @param v new value
     */
    public void setClickNum(int v) 
    {

        if (this.clickNum != v)
        {
            this.clickNum = v;
            setModified(true);
        }


    }

    /**
     * Get the Income
     *
     * @return double
     */
    public double getIncome()
    {
        return income;
    }


    /**
     * Set the value of Income
     *
     * @param v new value
     */
    public void setIncome(double v) 
    {

        if (this.income != v)
        {
            this.income = v;
            setModified(true);
        }


    }

    /**
     * Get the Atmshow
     *
     * @return int
     */
    public int getAtmshow()
    {
        return atmshow;
    }


    /**
     * Set the value of Atmshow
     *
     * @param v new value
     */
    public void setAtmshow(int v) 
    {

        if (this.atmshow != v)
        {
            this.atmshow = v;
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
     * Get the CreateDate
     *
     * @return Date
     */
    public Date getCreateDate()
    {
        return createDate;
    }


    /**
     * Set the value of CreateDate
     *
     * @param v new value
     */
    public void setCreateDate(Date v) 
    {

        if (!ObjectUtils.equals(this.createDate, v))
        {
            this.createDate = v;
            setModified(true);
        }


    }

    



    private SdkDevice aSdkDevice;

    /**
     * Declares an association between this object and a SdkDevice object
     *
     * @param v SdkDevice
     * @throws TorqueException
     */
    public void setSdkDevice(SdkDevice v) throws TorqueException
    {
        if (v == null)
        {
            setSdkDeviceId( 0);
        }
        else
        {
            setSdkDeviceId(v.getId());
        }
        aSdkDevice = v;
    }


    /**
     * Returns the associated SdkDevice object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated SdkDevice object
     * @throws TorqueException
     */
    public SdkDevice getSdkDevice()
        throws TorqueException
    {
        if (aSdkDevice == null && (this.sdkDeviceId != 0))
        {
            aSdkDevice = SdkDevicePeer.retrieveByPK(SimpleKey.keyFor(this.sdkDeviceId));
        }
        return aSdkDevice;
    }

    /**
     * Return the associated SdkDevice object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated SdkDevice object
     * @throws TorqueException
     */
    public SdkDevice getSdkDevice(Connection connection)
        throws TorqueException
    {
        if (aSdkDevice == null && (this.sdkDeviceId != 0))
        {
            aSdkDevice = SdkDevicePeer.retrieveByPK(SimpleKey.keyFor(this.sdkDeviceId), connection);
        }
        return aSdkDevice;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setSdkDeviceKey(ObjectKey key) throws TorqueException
    {

        setSdkDeviceId(((NumberKey) key).intValue());
    }




    private AdType aAdType;

    /**
     * Declares an association between this object and a AdType object
     *
     * @param v AdType
     * @throws TorqueException
     */
    public void setAdType(AdType v) throws TorqueException
    {
        if (v == null)
        {
            setAdTypeId( 0);
        }
        else
        {
            setAdTypeId(v.getId());
        }
        aAdType = v;
    }


    /**
     * Returns the associated AdType object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated AdType object
     * @throws TorqueException
     */
    public AdType getAdType()
        throws TorqueException
    {
        if (aAdType == null && (this.adTypeId != 0))
        {
            aAdType = AdTypePeer.retrieveByPK(SimpleKey.keyFor(this.adTypeId));
        }
        return aAdType;
    }

    /**
     * Return the associated AdType object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated AdType object
     * @throws TorqueException
     */
    public AdType getAdType(Connection connection)
        throws TorqueException
    {
        if (aAdType == null && (this.adTypeId != 0))
        {
            aAdType = AdTypePeer.retrieveByPK(SimpleKey.keyFor(this.adTypeId), connection);
        }
        return aAdType;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setAdTypeKey(ObjectKey key) throws TorqueException
    {

        setAdTypeId(((NumberKey) key).intValue());
    }




    private SdkName aSdkName;

    /**
     * Declares an association between this object and a SdkName object
     *
     * @param v SdkName
     * @throws TorqueException
     */
    public void setSdkName(SdkName v) throws TorqueException
    {
        if (v == null)
        {
            setSdkId( 0);
        }
        else
        {
            setSdkId(v.getId());
        }
        aSdkName = v;
    }


    /**
     * Returns the associated SdkName object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated SdkName object
     * @throws TorqueException
     */
    public SdkName getSdkName()
        throws TorqueException
    {
        if (aSdkName == null && (this.sdkId != 0))
        {
            aSdkName = SdkNamePeer.retrieveByPK(SimpleKey.keyFor(this.sdkId));
        }
        return aSdkName;
    }

    /**
     * Return the associated SdkName object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated SdkName object
     * @throws TorqueException
     */
    public SdkName getSdkName(Connection connection)
        throws TorqueException
    {
        if (aSdkName == null && (this.sdkId != 0))
        {
            aSdkName = SdkNamePeer.retrieveByPK(SimpleKey.keyFor(this.sdkId), connection);
        }
        return aSdkName;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setSdkNameKey(ObjectKey key) throws TorqueException
    {

        setSdkId(((NumberKey) key).intValue());
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
            fieldNames.add("SdkDeviceId");
            fieldNames.add("AdTypeId");
            fieldNames.add("SdkId");
            fieldNames.add("FillingRate");
            fieldNames.add("ShowNum");
            fieldNames.add("ClickNum");
            fieldNames.add("Income");
            fieldNames.add("Atmshow");
            fieldNames.add("CastId");
            fieldNames.add("IdeaId");
            fieldNames.add("CreateDate");
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
        if (name.equals("SdkDeviceId"))
        {
            return new Integer(getSdkDeviceId());
        }
        if (name.equals("AdTypeId"))
        {
            return new Integer(getAdTypeId());
        }
        if (name.equals("SdkId"))
        {
            return new Integer(getSdkId());
        }
        if (name.equals("FillingRate"))
        {
            return new Double(getFillingRate());
        }
        if (name.equals("ShowNum"))
        {
            return new Integer(getShowNum());
        }
        if (name.equals("ClickNum"))
        {
            return new Integer(getClickNum());
        }
        if (name.equals("Income"))
        {
            return new Double(getIncome());
        }
        if (name.equals("Atmshow"))
        {
            return new Integer(getAtmshow());
        }
        if (name.equals("CastId"))
        {
            return new Integer(getCastId());
        }
        if (name.equals("IdeaId"))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals("CreateDate"))
        {
            return getCreateDate();
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
        if (name.equals("SdkDeviceId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSdkDeviceId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("AdTypeId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAdTypeId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SdkId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSdkId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("FillingRate"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setFillingRate(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ShowNum"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setShowNum(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ClickNum"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setClickNum(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Income"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setIncome(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Atmshow"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAtmshow(((Integer) value).intValue());
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
        if (name.equals("CreateDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCreateDate((Date) value);
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
        if (name.equals(SdkLogPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(SdkLogPeer.SDK_DEVICE_ID))
        {
            return new Integer(getSdkDeviceId());
        }
        if (name.equals(SdkLogPeer.AD_TYPE_ID))
        {
            return new Integer(getAdTypeId());
        }
        if (name.equals(SdkLogPeer.SDK_ID))
        {
            return new Integer(getSdkId());
        }
        if (name.equals(SdkLogPeer.FILLING_RATE))
        {
            return new Double(getFillingRate());
        }
        if (name.equals(SdkLogPeer.SHOW_NUM))
        {
            return new Integer(getShowNum());
        }
        if (name.equals(SdkLogPeer.CLICK_NUM))
        {
            return new Integer(getClickNum());
        }
        if (name.equals(SdkLogPeer.INCOME))
        {
            return new Double(getIncome());
        }
        if (name.equals(SdkLogPeer.ATMSHOW))
        {
            return new Integer(getAtmshow());
        }
        if (name.equals(SdkLogPeer.CAST_ID))
        {
            return new Integer(getCastId());
        }
        if (name.equals(SdkLogPeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(SdkLogPeer.CREATE_DATE))
        {
            return getCreateDate();
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
      if (SdkLogPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (SdkLogPeer.SDK_DEVICE_ID.equals(name))
        {
            return setByName("SdkDeviceId", value);
        }
      if (SdkLogPeer.AD_TYPE_ID.equals(name))
        {
            return setByName("AdTypeId", value);
        }
      if (SdkLogPeer.SDK_ID.equals(name))
        {
            return setByName("SdkId", value);
        }
      if (SdkLogPeer.FILLING_RATE.equals(name))
        {
            return setByName("FillingRate", value);
        }
      if (SdkLogPeer.SHOW_NUM.equals(name))
        {
            return setByName("ShowNum", value);
        }
      if (SdkLogPeer.CLICK_NUM.equals(name))
        {
            return setByName("ClickNum", value);
        }
      if (SdkLogPeer.INCOME.equals(name))
        {
            return setByName("Income", value);
        }
      if (SdkLogPeer.ATMSHOW.equals(name))
        {
            return setByName("Atmshow", value);
        }
      if (SdkLogPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
        }
      if (SdkLogPeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (SdkLogPeer.CREATE_DATE.equals(name))
        {
            return setByName("CreateDate", value);
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
            return new Integer(getSdkDeviceId());
        }
        if (pos == 2)
        {
            return new Integer(getAdTypeId());
        }
        if (pos == 3)
        {
            return new Integer(getSdkId());
        }
        if (pos == 4)
        {
            return new Double(getFillingRate());
        }
        if (pos == 5)
        {
            return new Integer(getShowNum());
        }
        if (pos == 6)
        {
            return new Integer(getClickNum());
        }
        if (pos == 7)
        {
            return new Double(getIncome());
        }
        if (pos == 8)
        {
            return new Integer(getAtmshow());
        }
        if (pos == 9)
        {
            return new Integer(getCastId());
        }
        if (pos == 10)
        {
            return new Integer(getIdeaId());
        }
        if (pos == 11)
        {
            return getCreateDate();
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
            return setByName("SdkDeviceId", value);
        }
    if (position == 2)
        {
            return setByName("AdTypeId", value);
        }
    if (position == 3)
        {
            return setByName("SdkId", value);
        }
    if (position == 4)
        {
            return setByName("FillingRate", value);
        }
    if (position == 5)
        {
            return setByName("ShowNum", value);
        }
    if (position == 6)
        {
            return setByName("ClickNum", value);
        }
    if (position == 7)
        {
            return setByName("Income", value);
        }
    if (position == 8)
        {
            return setByName("Atmshow", value);
        }
    if (position == 9)
        {
            return setByName("CastId", value);
        }
    if (position == 10)
        {
            return setByName("IdeaId", value);
        }
    if (position == 11)
        {
            return setByName("CreateDate", value);
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
        save(SdkLogPeer.DATABASE_NAME);
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
                    SdkLogPeer.doInsert((SdkLog) this, con);
                    setNew(false);
                }
                else
                {
                    SdkLogPeer.doUpdate((SdkLog) this, con);
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
    public SdkLog copy() throws TorqueException
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
    public SdkLog copy(Connection con) throws TorqueException
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
    public SdkLog copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new SdkLog(), deepcopy);
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
    public SdkLog copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new SdkLog(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected SdkLog copyInto(SdkLog copyObj) throws TorqueException
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
    protected SdkLog copyInto(SdkLog copyObj, Connection con) throws TorqueException
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
    protected SdkLog copyInto(SdkLog copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setSdkDeviceId(sdkDeviceId);
        copyObj.setAdTypeId(adTypeId);
        copyObj.setSdkId(sdkId);
        copyObj.setFillingRate(fillingRate);
        copyObj.setShowNum(showNum);
        copyObj.setClickNum(clickNum);
        copyObj.setIncome(income);
        copyObj.setAtmshow(atmshow);
        copyObj.setCastId(castId);
        copyObj.setIdeaId(ideaId);
        copyObj.setCreateDate(createDate);

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
    protected SdkLog copyInto(SdkLog copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setSdkDeviceId(sdkDeviceId);
        copyObj.setAdTypeId(adTypeId);
        copyObj.setSdkId(sdkId);
        copyObj.setFillingRate(fillingRate);
        copyObj.setShowNum(showNum);
        copyObj.setClickNum(clickNum);
        copyObj.setIncome(income);
        copyObj.setAtmshow(atmshow);
        copyObj.setCastId(castId);
        copyObj.setIdeaId(ideaId);
        copyObj.setCreateDate(createDate);

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
    public SdkLogPeer getPeer()
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
        return SdkLogPeer.getTableMap();
    }

  
    /**
     * Creates a SdkLogBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a SdkLogBean with the contents of this object
     */
    public SdkLogBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a SdkLogBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a SdkLogBean with the contents of this object
     */
    public SdkLogBean getBean(IdentityMap createdBeans)
    {
        SdkLogBean result = (SdkLogBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new SdkLogBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setSdkDeviceId(getSdkDeviceId());
        result.setAdTypeId(getAdTypeId());
        result.setSdkId(getSdkId());
        result.setFillingRate(getFillingRate());
        result.setShowNum(getShowNum());
        result.setClickNum(getClickNum());
        result.setIncome(getIncome());
        result.setAtmshow(getAtmshow());
        result.setCastId(getCastId());
        result.setIdeaId(getIdeaId());
        result.setCreateDate(getCreateDate());





        if (aSdkDevice != null)
        {
            SdkDeviceBean relatedBean = aSdkDevice.getBean(createdBeans);
            result.setSdkDeviceBean(relatedBean);
        }



        if (aAdType != null)
        {
            AdTypeBean relatedBean = aAdType.getBean(createdBeans);
            result.setAdTypeBean(relatedBean);
        }



        if (aSdkName != null)
        {
            SdkNameBean relatedBean = aSdkName.getBean(createdBeans);
            result.setSdkNameBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of SdkLog with the contents
     * of a SdkLogBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the SdkLogBean which contents are used to create
     *        the resulting class
     * @return an instance of SdkLog with the contents of bean
     */
    public static SdkLog createSdkLog(SdkLogBean bean)
        throws TorqueException
    {
        return createSdkLog(bean, new IdentityMap());
    }

    /**
     * Creates an instance of SdkLog with the contents
     * of a SdkLogBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the SdkLogBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of SdkLog with the contents of bean
     */

    public static SdkLog createSdkLog(SdkLogBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        SdkLog result = (SdkLog) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new SdkLog();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setSdkDeviceId(bean.getSdkDeviceId());
        result.setAdTypeId(bean.getAdTypeId());
        result.setSdkId(bean.getSdkId());
        result.setFillingRate(bean.getFillingRate());
        result.setShowNum(bean.getShowNum());
        result.setClickNum(bean.getClickNum());
        result.setIncome(bean.getIncome());
        result.setAtmshow(bean.getAtmshow());
        result.setCastId(bean.getCastId());
        result.setIdeaId(bean.getIdeaId());
        result.setCreateDate(bean.getCreateDate());





        {
            SdkDeviceBean relatedBean = bean.getSdkDeviceBean();
            if (relatedBean != null)
            {
                SdkDevice relatedObject = SdkDevice.createSdkDevice(relatedBean, createdObjects);
                result.setSdkDevice(relatedObject);
            }
        }



        {
            AdTypeBean relatedBean = bean.getAdTypeBean();
            if (relatedBean != null)
            {
                AdType relatedObject = AdType.createAdType(relatedBean, createdObjects);
                result.setAdType(relatedObject);
            }
        }



        {
            SdkNameBean relatedBean = bean.getSdkNameBean();
            if (relatedBean != null)
            {
                SdkName relatedObject = SdkName.createSdkName(relatedBean, createdObjects);
                result.setSdkName(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("SdkLog:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("SdkDeviceId = ")
           .append(getSdkDeviceId())
           .append("\n");
        str.append("AdTypeId = ")
           .append(getAdTypeId())
           .append("\n");
        str.append("SdkId = ")
           .append(getSdkId())
           .append("\n");
        str.append("FillingRate = ")
           .append(getFillingRate())
           .append("\n");
        str.append("ShowNum = ")
           .append(getShowNum())
           .append("\n");
        str.append("ClickNum = ")
           .append(getClickNum())
           .append("\n");
        str.append("Income = ")
           .append(getIncome())
           .append("\n");
        str.append("Atmshow = ")
           .append(getAtmshow())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("CreateDate = ")
           .append(getCreateDate())
           .append("\n");
        return(str.toString());
    }
}
