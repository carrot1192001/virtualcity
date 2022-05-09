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
import com.youku.atm.om.bean.PlatformBean;

import com.youku.atm.om.bean.CastPlatformBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Platform
 */
public abstract class BasePlatform extends BaseObject
{
    /** The Peer class */
    private static final PlatformPeer peer =
        new PlatformPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the brand field */
    private String brand;

    /** The value for the site field */
    private int site = 1;

    /** The value for the dt field */
    private String dt;

    /** The value for the deviceModel field */
    private String deviceModel;

    /** The value for the os field */
    private String os;

    /** The value for the osVersion field */
    private String osVersion;

    /** The value for the aw field */
    private String aw;

    /** The value for the clientVersion field */
    private String clientVersion;

    /** The value for the sortCode field */
    private int sortCode = 1;

    /** The value for the net field */
    private String net;

    /** The value for the value field */
    private String value;

    /** The value for the status field */
    private int status;


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
     * Get the Brand
     *
     * @return String
     */
    public String getBrand()
    {
        return brand;
    }


    /**
     * Set the value of Brand
     *
     * @param v new value
     */
    public void setBrand(String v) 
    {

        if (!ObjectUtils.equals(this.brand, v))
        {
            this.brand = v;
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
     * Get the Dt
     *
     * @return String
     */
    public String getDt()
    {
        return dt;
    }


    /**
     * Set the value of Dt
     *
     * @param v new value
     */
    public void setDt(String v) 
    {

        if (!ObjectUtils.equals(this.dt, v))
        {
            this.dt = v;
            setModified(true);
        }


    }

    /**
     * Get the DeviceModel
     *
     * @return String
     */
    public String getDeviceModel()
    {
        return deviceModel;
    }


    /**
     * Set the value of DeviceModel
     *
     * @param v new value
     */
    public void setDeviceModel(String v) 
    {

        if (!ObjectUtils.equals(this.deviceModel, v))
        {
            this.deviceModel = v;
            setModified(true);
        }


    }

    /**
     * Get the Os
     *
     * @return String
     */
    public String getOs()
    {
        return os;
    }


    /**
     * Set the value of Os
     *
     * @param v new value
     */
    public void setOs(String v) 
    {

        if (!ObjectUtils.equals(this.os, v))
        {
            this.os = v;
            setModified(true);
        }


    }

    /**
     * Get the OsVersion
     *
     * @return String
     */
    public String getOsVersion()
    {
        return osVersion;
    }


    /**
     * Set the value of OsVersion
     *
     * @param v new value
     */
    public void setOsVersion(String v) 
    {

        if (!ObjectUtils.equals(this.osVersion, v))
        {
            this.osVersion = v;
            setModified(true);
        }


    }

    /**
     * Get the Aw
     *
     * @return String
     */
    public String getAw()
    {
        return aw;
    }


    /**
     * Set the value of Aw
     *
     * @param v new value
     */
    public void setAw(String v) 
    {

        if (!ObjectUtils.equals(this.aw, v))
        {
            this.aw = v;
            setModified(true);
        }


    }

    /**
     * Get the ClientVersion
     *
     * @return String
     */
    public String getClientVersion()
    {
        return clientVersion;
    }


    /**
     * Set the value of ClientVersion
     *
     * @param v new value
     */
    public void setClientVersion(String v) 
    {

        if (!ObjectUtils.equals(this.clientVersion, v))
        {
            this.clientVersion = v;
            setModified(true);
        }


    }

    /**
     * Get the SortCode
     *
     * @return int
     */
    public int getSortCode()
    {
        return sortCode;
    }


    /**
     * Set the value of SortCode
     *
     * @param v new value
     */
    public void setSortCode(int v) 
    {

        if (this.sortCode != v)
        {
            this.sortCode = v;
            setModified(true);
        }


    }

    /**
     * Get the Net
     *
     * @return String
     */
    public String getNet()
    {
        return net;
    }


    /**
     * Set the value of Net
     *
     * @param v new value
     */
    public void setNet(String v) 
    {

        if (!ObjectUtils.equals(this.net, v))
        {
            this.net = v;
            setModified(true);
        }


    }

    /**
     * Get the Value
     *
     * @return String
     */
    public String getValue()
    {
        return value;
    }


    /**
     * Set the value of Value
     *
     * @param v new value
     */
    public void setValue(String v) throws TorqueException
    {

        if (!ObjectUtils.equals(this.value, v))
        {
            this.value = v;
            setModified(true);
        }



        // update associated CastPlatform
        if (collCastPlatforms != null)
        {
            for (int i = 0; i < collCastPlatforms.size(); i++)
            {
                ((CastPlatform) collCastPlatforms.get(i))
                        .setDirectValue(v);
            }
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
     * Collection to store aggregation of collCastPlatforms
     */
    protected List<CastPlatform> collCastPlatforms;

    /**
     * Temporary storage of collCastPlatforms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastPlatforms()
    {
        if (collCastPlatforms == null)
        {
            collCastPlatforms = new ArrayList<CastPlatform>();
        }
    }


    /**
     * Method called to associate a CastPlatform object to this object
     * through the CastPlatform foreign key attribute
     *
     * @param l CastPlatform
     * @throws TorqueException
     */
    public void addCastPlatform(CastPlatform l) throws TorqueException
    {
        getCastPlatforms().add(l);
        l.setPlatform((Platform) this);
    }

    /**
     * Method called to associate a CastPlatform object to this object
     * through the CastPlatform foreign key attribute using connection.
     *
     * @param l CastPlatform
     * @throws TorqueException
     */
    public void addCastPlatform(CastPlatform l, Connection con) throws TorqueException
    {
        getCastPlatforms(con).add(l);
        l.setPlatform((Platform) this);
    }

    /**
     * The criteria used to select the current contents of collCastPlatforms
     */
    private Criteria lastCastPlatformsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPlatforms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastPlatform> getCastPlatforms()
        throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            collCastPlatforms = getCastPlatforms(new Criteria(10));
        }
        return collCastPlatforms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Platform has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     * If this Platform is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastPlatform> getCastPlatforms(Criteria criteria) throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue() );
                collCastPlatforms = CastPlatformPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue());
                if (!lastCastPlatformsCriteria.equals(criteria))
                {
                    collCastPlatforms = CastPlatformPeer.doSelect(criteria);
                }
            }
        }
        lastCastPlatformsCriteria = criteria;

        return collCastPlatforms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPlatforms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPlatform> getCastPlatforms(Connection con) throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            collCastPlatforms = getCastPlatforms(new Criteria(10), con);
        }
        return collCastPlatforms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Platform has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     * If this Platform is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPlatform> getCastPlatforms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                 criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue());
                 collCastPlatforms = CastPlatformPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue());
                 if (!lastCastPlatformsCriteria.equals(criteria))
                 {
                     collCastPlatforms = CastPlatformPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastPlatformsCriteria = criteria;

         return collCastPlatforms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Platform is new, it will return
     * an empty collection; or if this Platform has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Platform.
     */
    protected List<CastPlatform> getCastPlatformsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue());
                collCastPlatforms = CastPlatformPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue());
            if (!lastCastPlatformsCriteria.equals(criteria))
            {
                collCastPlatforms = CastPlatformPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastPlatformsCriteria = criteria;

        return collCastPlatforms;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Platform is new, it will return
     * an empty collection; or if this Platform has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Platform.
     */
    protected List<CastPlatform> getCastPlatformsJoinPlatform(Criteria criteria)
        throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue());
                collCastPlatforms = CastPlatformPeer.doSelectJoinPlatform(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPlatformPeer.DIRECT_VALUE, getValue());
            if (!lastCastPlatformsCriteria.equals(criteria))
            {
                collCastPlatforms = CastPlatformPeer.doSelectJoinPlatform(criteria);
            }
        }
        lastCastPlatformsCriteria = criteria;

        return collCastPlatforms;
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
            fieldNames.add("Brand");
            fieldNames.add("Site");
            fieldNames.add("Dt");
            fieldNames.add("DeviceModel");
            fieldNames.add("Os");
            fieldNames.add("OsVersion");
            fieldNames.add("Aw");
            fieldNames.add("ClientVersion");
            fieldNames.add("SortCode");
            fieldNames.add("Net");
            fieldNames.add("Value");
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
        if (name.equals("Brand"))
        {
            return getBrand();
        }
        if (name.equals("Site"))
        {
            return new Integer(getSite());
        }
        if (name.equals("Dt"))
        {
            return getDt();
        }
        if (name.equals("DeviceModel"))
        {
            return getDeviceModel();
        }
        if (name.equals("Os"))
        {
            return getOs();
        }
        if (name.equals("OsVersion"))
        {
            return getOsVersion();
        }
        if (name.equals("Aw"))
        {
            return getAw();
        }
        if (name.equals("ClientVersion"))
        {
            return getClientVersion();
        }
        if (name.equals("SortCode"))
        {
            return new Integer(getSortCode());
        }
        if (name.equals("Net"))
        {
            return getNet();
        }
        if (name.equals("Value"))
        {
            return getValue();
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
        if (name.equals("Brand"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setBrand((String) value);
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
        if (name.equals("Dt"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDt((String) value);
            return true;
        }
        if (name.equals("DeviceModel"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDeviceModel((String) value);
            return true;
        }
        if (name.equals("Os"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setOs((String) value);
            return true;
        }
        if (name.equals("OsVersion"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setOsVersion((String) value);
            return true;
        }
        if (name.equals("Aw"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setAw((String) value);
            return true;
        }
        if (name.equals("ClientVersion"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setClientVersion((String) value);
            return true;
        }
        if (name.equals("SortCode"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSortCode(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Net"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setNet((String) value);
            return true;
        }
        if (name.equals("Value"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setValue((String) value);
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
        if (name.equals(PlatformPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(PlatformPeer.NAME))
        {
            return getName();
        }
        if (name.equals(PlatformPeer.BRAND))
        {
            return getBrand();
        }
        if (name.equals(PlatformPeer.SITE))
        {
            return new Integer(getSite());
        }
        if (name.equals(PlatformPeer.DT))
        {
            return getDt();
        }
        if (name.equals(PlatformPeer.DEVICE_MODEL))
        {
            return getDeviceModel();
        }
        if (name.equals(PlatformPeer.OS))
        {
            return getOs();
        }
        if (name.equals(PlatformPeer.OS_VERSION))
        {
            return getOsVersion();
        }
        if (name.equals(PlatformPeer.AW))
        {
            return getAw();
        }
        if (name.equals(PlatformPeer.CLIENT_VERSION))
        {
            return getClientVersion();
        }
        if (name.equals(PlatformPeer.SORT_CODE))
        {
            return new Integer(getSortCode());
        }
        if (name.equals(PlatformPeer.NET))
        {
            return getNet();
        }
        if (name.equals(PlatformPeer.VALUE))
        {
            return getValue();
        }
        if (name.equals(PlatformPeer.STATUS))
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
      if (PlatformPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (PlatformPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (PlatformPeer.BRAND.equals(name))
        {
            return setByName("Brand", value);
        }
      if (PlatformPeer.SITE.equals(name))
        {
            return setByName("Site", value);
        }
      if (PlatformPeer.DT.equals(name))
        {
            return setByName("Dt", value);
        }
      if (PlatformPeer.DEVICE_MODEL.equals(name))
        {
            return setByName("DeviceModel", value);
        }
      if (PlatformPeer.OS.equals(name))
        {
            return setByName("Os", value);
        }
      if (PlatformPeer.OS_VERSION.equals(name))
        {
            return setByName("OsVersion", value);
        }
      if (PlatformPeer.AW.equals(name))
        {
            return setByName("Aw", value);
        }
      if (PlatformPeer.CLIENT_VERSION.equals(name))
        {
            return setByName("ClientVersion", value);
        }
      if (PlatformPeer.SORT_CODE.equals(name))
        {
            return setByName("SortCode", value);
        }
      if (PlatformPeer.NET.equals(name))
        {
            return setByName("Net", value);
        }
      if (PlatformPeer.VALUE.equals(name))
        {
            return setByName("Value", value);
        }
      if (PlatformPeer.STATUS.equals(name))
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
            return getBrand();
        }
        if (pos == 3)
        {
            return new Integer(getSite());
        }
        if (pos == 4)
        {
            return getDt();
        }
        if (pos == 5)
        {
            return getDeviceModel();
        }
        if (pos == 6)
        {
            return getOs();
        }
        if (pos == 7)
        {
            return getOsVersion();
        }
        if (pos == 8)
        {
            return getAw();
        }
        if (pos == 9)
        {
            return getClientVersion();
        }
        if (pos == 10)
        {
            return new Integer(getSortCode());
        }
        if (pos == 11)
        {
            return getNet();
        }
        if (pos == 12)
        {
            return getValue();
        }
        if (pos == 13)
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
            return setByName("Brand", value);
        }
    if (position == 3)
        {
            return setByName("Site", value);
        }
    if (position == 4)
        {
            return setByName("Dt", value);
        }
    if (position == 5)
        {
            return setByName("DeviceModel", value);
        }
    if (position == 6)
        {
            return setByName("Os", value);
        }
    if (position == 7)
        {
            return setByName("OsVersion", value);
        }
    if (position == 8)
        {
            return setByName("Aw", value);
        }
    if (position == 9)
        {
            return setByName("ClientVersion", value);
        }
    if (position == 10)
        {
            return setByName("SortCode", value);
        }
    if (position == 11)
        {
            return setByName("Net", value);
        }
    if (position == 12)
        {
            return setByName("Value", value);
        }
    if (position == 13)
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
        save(PlatformPeer.DATABASE_NAME);
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
                    PlatformPeer.doInsert((Platform) this, con);
                    setNew(false);
                }
                else
                {
                    PlatformPeer.doUpdate((Platform) this, con);
                }
            }


            if (collCastPlatforms != null)
            {
                for (int i = 0; i < collCastPlatforms.size(); i++)
                {
                    ((CastPlatform) collCastPlatforms.get(i)).save(con);
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
    public Platform copy() throws TorqueException
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
    public Platform copy(Connection con) throws TorqueException
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
    public Platform copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Platform(), deepcopy);
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
    public Platform copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Platform(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Platform copyInto(Platform copyObj) throws TorqueException
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
    protected Platform copyInto(Platform copyObj, Connection con) throws TorqueException
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
    protected Platform copyInto(Platform copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setBrand(brand);
        copyObj.setSite(site);
        copyObj.setDt(dt);
        copyObj.setDeviceModel(deviceModel);
        copyObj.setOs(os);
        copyObj.setOsVersion(osVersion);
        copyObj.setAw(aw);
        copyObj.setClientVersion(clientVersion);
        copyObj.setSortCode(sortCode);
        copyObj.setNet(net);
        copyObj.setValue(value);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastPlatform> vCastPlatforms = getCastPlatforms();
        if (vCastPlatforms != null)
        {
            for (int i = 0; i < vCastPlatforms.size(); i++)
            {
                CastPlatform obj =  vCastPlatforms.get(i);
                copyObj.addCastPlatform(obj.copy());
            }
        }
        else
        {
            copyObj.collCastPlatforms = null;
        }
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
    protected Platform copyInto(Platform copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setBrand(brand);
        copyObj.setSite(site);
        copyObj.setDt(dt);
        copyObj.setDeviceModel(deviceModel);
        copyObj.setOs(os);
        copyObj.setOsVersion(osVersion);
        copyObj.setAw(aw);
        copyObj.setClientVersion(clientVersion);
        copyObj.setSortCode(sortCode);
        copyObj.setNet(net);
        copyObj.setValue(value);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastPlatform> vCastPlatforms = getCastPlatforms(con);
        if (vCastPlatforms != null)
        {
            for (int i = 0; i < vCastPlatforms.size(); i++)
            {
                CastPlatform obj =  vCastPlatforms.get(i);
                copyObj.addCastPlatform(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastPlatforms = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public PlatformPeer getPeer()
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
        return PlatformPeer.getTableMap();
    }

  
    /**
     * Creates a PlatformBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a PlatformBean with the contents of this object
     */
    public PlatformBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a PlatformBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a PlatformBean with the contents of this object
     */
    public PlatformBean getBean(IdentityMap createdBeans)
    {
        PlatformBean result = (PlatformBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new PlatformBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setBrand(getBrand());
        result.setSite(getSite());
        result.setDt(getDt());
        result.setDeviceModel(getDeviceModel());
        result.setOs(getOs());
        result.setOsVersion(getOsVersion());
        result.setAw(getAw());
        result.setClientVersion(getClientVersion());
        result.setSortCode(getSortCode());
        result.setNet(getNet());
        result.setValue(getValue());
        result.setStatus(getStatus());



        if (collCastPlatforms != null)
        {
            List<CastPlatformBean> relatedBeans = new ArrayList<CastPlatformBean>(collCastPlatforms.size());
            for (Iterator<CastPlatform> collCastPlatformsIt = collCastPlatforms.iterator(); collCastPlatformsIt.hasNext(); )
            {
                CastPlatform related = (CastPlatform) collCastPlatformsIt.next();
                CastPlatformBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastPlatformBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Platform with the contents
     * of a PlatformBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the PlatformBean which contents are used to create
     *        the resulting class
     * @return an instance of Platform with the contents of bean
     */
    public static Platform createPlatform(PlatformBean bean)
        throws TorqueException
    {
        return createPlatform(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Platform with the contents
     * of a PlatformBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the PlatformBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Platform with the contents of bean
     */

    public static Platform createPlatform(PlatformBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Platform result = (Platform) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Platform();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setBrand(bean.getBrand());
        result.setSite(bean.getSite());
        result.setDt(bean.getDt());
        result.setDeviceModel(bean.getDeviceModel());
        result.setOs(bean.getOs());
        result.setOsVersion(bean.getOsVersion());
        result.setAw(bean.getAw());
        result.setClientVersion(bean.getClientVersion());
        result.setSortCode(bean.getSortCode());
        result.setNet(bean.getNet());
        result.setValue(bean.getValue());
        result.setStatus(bean.getStatus());



        {
            List<CastPlatformBean> relatedBeans = bean.getCastPlatformBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastPlatformBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastPlatformBean relatedBean =  relatedBeansIt.next();
                    CastPlatform related = CastPlatform.createCastPlatform(relatedBean, createdObjects);
                    result.addCastPlatformFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a CastPlatform object to this object.
     * through the CastPlatform foreign key attribute
     *
     * @param toAdd CastPlatform
     */
    protected void addCastPlatformFromBean(CastPlatform toAdd)
    {
        initCastPlatforms();
        collCastPlatforms.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Platform:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Brand = ")
           .append(getBrand())
           .append("\n");
        str.append("Site = ")
           .append(getSite())
           .append("\n");
        str.append("Dt = ")
           .append(getDt())
           .append("\n");
        str.append("DeviceModel = ")
           .append(getDeviceModel())
           .append("\n");
        str.append("Os = ")
           .append(getOs())
           .append("\n");
        str.append("OsVersion = ")
           .append(getOsVersion())
           .append("\n");
        str.append("Aw = ")
           .append(getAw())
           .append("\n");
        str.append("ClientVersion = ")
           .append(getClientVersion())
           .append("\n");
        str.append("SortCode = ")
           .append(getSortCode())
           .append("\n");
        str.append("Net = ")
           .append(getNet())
           .append("\n");
        str.append("Value = ")
           .append(getValue())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
