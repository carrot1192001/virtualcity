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
import com.youku.atm.om.bean.CastEmbedBean;
import com.youku.atm.om.bean.AdCastBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to CastEmbed
 */
public abstract class BaseCastEmbed extends BaseObject
{
    /** The Peer class */
    private static final CastEmbedPeer peer =
        new CastEmbedPeer();


    /** The value for the id field */
    private int id;

    /** The value for the castId field */
    private int castId;

    /** The value for the videoIdYk field */
    private String videoIdYk;

    /** The value for the videoIdTd field */
    private String videoIdTd;

    /** The value for the breakId field */
    private String breakId;

    /** The value for the startTime field */
    private int startTime;

    /** The value for the showTime field */
    private int showTime;


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
     * Get the VideoIdYk
     *
     * @return String
     */
    public String getVideoIdYk()
    {
        return videoIdYk;
    }


    /**
     * Set the value of VideoIdYk
     *
     * @param v new value
     */
    public void setVideoIdYk(String v) 
    {

        if (!ObjectUtils.equals(this.videoIdYk, v))
        {
            this.videoIdYk = v;
            setModified(true);
        }


    }

    /**
     * Get the VideoIdTd
     *
     * @return String
     */
    public String getVideoIdTd()
    {
        return videoIdTd;
    }


    /**
     * Set the value of VideoIdTd
     *
     * @param v new value
     */
    public void setVideoIdTd(String v) 
    {

        if (!ObjectUtils.equals(this.videoIdTd, v))
        {
            this.videoIdTd = v;
            setModified(true);
        }


    }

    /**
     * Get the BreakId
     *
     * @return String
     */
    public String getBreakId()
    {
        return breakId;
    }


    /**
     * Set the value of BreakId
     *
     * @param v new value
     */
    public void setBreakId(String v) 
    {

        if (!ObjectUtils.equals(this.breakId, v))
        {
            this.breakId = v;
            setModified(true);
        }


    }

    /**
     * Get the StartTime
     *
     * @return int
     */
    public int getStartTime()
    {
        return startTime;
    }


    /**
     * Set the value of StartTime
     *
     * @param v new value
     */
    public void setStartTime(int v) 
    {

        if (this.startTime != v)
        {
            this.startTime = v;
            setModified(true);
        }


    }

    /**
     * Get the ShowTime
     *
     * @return int
     */
    public int getShowTime()
    {
        return showTime;
    }


    /**
     * Set the value of ShowTime
     *
     * @param v new value
     */
    public void setShowTime(int v) 
    {

        if (this.showTime != v)
        {
            this.showTime = v;
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
            fieldNames.add("VideoIdYk");
            fieldNames.add("VideoIdTd");
            fieldNames.add("BreakId");
            fieldNames.add("StartTime");
            fieldNames.add("ShowTime");
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
        if (name.equals("VideoIdYk"))
        {
            return getVideoIdYk();
        }
        if (name.equals("VideoIdTd"))
        {
            return getVideoIdTd();
        }
        if (name.equals("BreakId"))
        {
            return getBreakId();
        }
        if (name.equals("StartTime"))
        {
            return new Integer(getStartTime());
        }
        if (name.equals("ShowTime"))
        {
            return new Integer(getShowTime());
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
        if (name.equals("VideoIdYk"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setVideoIdYk((String) value);
            return true;
        }
        if (name.equals("VideoIdTd"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setVideoIdTd((String) value);
            return true;
        }
        if (name.equals("BreakId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setBreakId((String) value);
            return true;
        }
        if (name.equals("StartTime"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStartTime(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ShowTime"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setShowTime(((Integer) value).intValue());
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
        if (name.equals(CastEmbedPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(CastEmbedPeer.CAST_ID))
        {
            return new Integer(getCastId());
        }
        if (name.equals(CastEmbedPeer.VIDEO_ID_YK))
        {
            return getVideoIdYk();
        }
        if (name.equals(CastEmbedPeer.VIDEO_ID_TD))
        {
            return getVideoIdTd();
        }
        if (name.equals(CastEmbedPeer.BREAK_ID))
        {
            return getBreakId();
        }
        if (name.equals(CastEmbedPeer.START_TIME))
        {
            return new Integer(getStartTime());
        }
        if (name.equals(CastEmbedPeer.SHOW_TIME))
        {
            return new Integer(getShowTime());
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
      if (CastEmbedPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (CastEmbedPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
        }
      if (CastEmbedPeer.VIDEO_ID_YK.equals(name))
        {
            return setByName("VideoIdYk", value);
        }
      if (CastEmbedPeer.VIDEO_ID_TD.equals(name))
        {
            return setByName("VideoIdTd", value);
        }
      if (CastEmbedPeer.BREAK_ID.equals(name))
        {
            return setByName("BreakId", value);
        }
      if (CastEmbedPeer.START_TIME.equals(name))
        {
            return setByName("StartTime", value);
        }
      if (CastEmbedPeer.SHOW_TIME.equals(name))
        {
            return setByName("ShowTime", value);
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
            return getVideoIdYk();
        }
        if (pos == 3)
        {
            return getVideoIdTd();
        }
        if (pos == 4)
        {
            return getBreakId();
        }
        if (pos == 5)
        {
            return new Integer(getStartTime());
        }
        if (pos == 6)
        {
            return new Integer(getShowTime());
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
            return setByName("VideoIdYk", value);
        }
    if (position == 3)
        {
            return setByName("VideoIdTd", value);
        }
    if (position == 4)
        {
            return setByName("BreakId", value);
        }
    if (position == 5)
        {
            return setByName("StartTime", value);
        }
    if (position == 6)
        {
            return setByName("ShowTime", value);
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
        save(CastEmbedPeer.DATABASE_NAME);
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
                    CastEmbedPeer.doInsert((CastEmbed) this, con);
                    setNew(false);
                }
                else
                {
                    CastEmbedPeer.doUpdate((CastEmbed) this, con);
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
    public CastEmbed copy() throws TorqueException
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
    public CastEmbed copy(Connection con) throws TorqueException
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
    public CastEmbed copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new CastEmbed(), deepcopy);
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
    public CastEmbed copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new CastEmbed(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected CastEmbed copyInto(CastEmbed copyObj) throws TorqueException
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
    protected CastEmbed copyInto(CastEmbed copyObj, Connection con) throws TorqueException
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
    protected CastEmbed copyInto(CastEmbed copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setVideoIdYk(videoIdYk);
        copyObj.setVideoIdTd(videoIdTd);
        copyObj.setBreakId(breakId);
        copyObj.setStartTime(startTime);
        copyObj.setShowTime(showTime);

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
    protected CastEmbed copyInto(CastEmbed copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCastId(castId);
        copyObj.setVideoIdYk(videoIdYk);
        copyObj.setVideoIdTd(videoIdTd);
        copyObj.setBreakId(breakId);
        copyObj.setStartTime(startTime);
        copyObj.setShowTime(showTime);

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
    public CastEmbedPeer getPeer()
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
        return CastEmbedPeer.getTableMap();
    }

  
    /**
     * Creates a CastEmbedBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a CastEmbedBean with the contents of this object
     */
    public CastEmbedBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a CastEmbedBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a CastEmbedBean with the contents of this object
     */
    public CastEmbedBean getBean(IdentityMap createdBeans)
    {
        CastEmbedBean result = (CastEmbedBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new CastEmbedBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setCastId(getCastId());
        result.setVideoIdYk(getVideoIdYk());
        result.setVideoIdTd(getVideoIdTd());
        result.setBreakId(getBreakId());
        result.setStartTime(getStartTime());
        result.setShowTime(getShowTime());





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
     * Creates an instance of CastEmbed with the contents
     * of a CastEmbedBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the CastEmbedBean which contents are used to create
     *        the resulting class
     * @return an instance of CastEmbed with the contents of bean
     */
    public static CastEmbed createCastEmbed(CastEmbedBean bean)
        throws TorqueException
    {
        return createCastEmbed(bean, new IdentityMap());
    }

    /**
     * Creates an instance of CastEmbed with the contents
     * of a CastEmbedBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the CastEmbedBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of CastEmbed with the contents of bean
     */

    public static CastEmbed createCastEmbed(CastEmbedBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        CastEmbed result = (CastEmbed) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new CastEmbed();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setCastId(bean.getCastId());
        result.setVideoIdYk(bean.getVideoIdYk());
        result.setVideoIdTd(bean.getVideoIdTd());
        result.setBreakId(bean.getBreakId());
        result.setStartTime(bean.getStartTime());
        result.setShowTime(bean.getShowTime());





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
        str.append("CastEmbed:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        str.append("VideoIdYk = ")
           .append(getVideoIdYk())
           .append("\n");
        str.append("VideoIdTd = ")
           .append(getVideoIdTd())
           .append("\n");
        str.append("BreakId = ")
           .append(getBreakId())
           .append("\n");
        str.append("StartTime = ")
           .append(getStartTime())
           .append("\n");
        str.append("ShowTime = ")
           .append(getShowTime())
           .append("\n");
        return(str.toString());
    }
}
