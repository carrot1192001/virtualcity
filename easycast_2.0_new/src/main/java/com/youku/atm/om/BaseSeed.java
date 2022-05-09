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
import com.youku.atm.om.bean.SeedBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Seed
 */
public abstract class BaseSeed extends BaseObject
{
    /** The Peer class */
    private static final SeedPeer peer =
        new SeedPeer();


    /** The value for the id field */
    private int id;

    /** The value for the vid field */
    private String vid;

    /** The value for the name field */
    private String name;

    /** The value for the url field */
    private String url;

    /** The value for the description field */
    private String description;

    /** The value for the status field */
    private int status = 1;

    /** The value for the site field */
    private int site = 1;

    /** The value for the surveyUrl field */
    private String surveyUrl;


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
     * Get the Vid
     *
     * @return String
     */
    public String getVid()
    {
        return vid;
    }


    /**
     * Set the value of Vid
     *
     * @param v new value
     */
    public void setVid(String v) 
    {

        if (!ObjectUtils.equals(this.vid, v))
        {
            this.vid = v;
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
     * Get the Url
     *
     * @return String
     */
    public String getUrl()
    {
        return url;
    }


    /**
     * Set the value of Url
     *
     * @param v new value
     */
    public void setUrl(String v) 
    {

        if (!ObjectUtils.equals(this.url, v))
        {
            this.url = v;
            setModified(true);
        }


    }

    /**
     * Get the Description
     *
     * @return String
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Set the value of Description
     *
     * @param v new value
     */
    public void setDescription(String v) 
    {

        if (!ObjectUtils.equals(this.description, v))
        {
            this.description = v;
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
     * Get the SurveyUrl
     *
     * @return String
     */
    public String getSurveyUrl()
    {
        return surveyUrl;
    }


    /**
     * Set the value of SurveyUrl
     *
     * @param v new value
     */
    public void setSurveyUrl(String v) 
    {

        if (!ObjectUtils.equals(this.surveyUrl, v))
        {
            this.surveyUrl = v;
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
            fieldNames.add("Vid");
            fieldNames.add("Name");
            fieldNames.add("Url");
            fieldNames.add("Description");
            fieldNames.add("Status");
            fieldNames.add("Site");
            fieldNames.add("SurveyUrl");
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
        if (name.equals("Vid"))
        {
            return getVid();
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("Url"))
        {
            return getUrl();
        }
        if (name.equals("Description"))
        {
            return getDescription();
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("Site"))
        {
            return new Integer(getSite());
        }
        if (name.equals("SurveyUrl"))
        {
            return getSurveyUrl();
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
        if (name.equals("Vid"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setVid((String) value);
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
        if (name.equals("Url"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUrl((String) value);
            return true;
        }
        if (name.equals("Description"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDescription((String) value);
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
        if (name.equals("Site"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSite(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SurveyUrl"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSurveyUrl((String) value);
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
        if (name.equals(SeedPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(SeedPeer.VID))
        {
            return getVid();
        }
        if (name.equals(SeedPeer.NAME))
        {
            return getName();
        }
        if (name.equals(SeedPeer.URL))
        {
            return getUrl();
        }
        if (name.equals(SeedPeer.DESCRIPTION))
        {
            return getDescription();
        }
        if (name.equals(SeedPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(SeedPeer.SITE))
        {
            return new Integer(getSite());
        }
        if (name.equals(SeedPeer.SURVEY_URL))
        {
            return getSurveyUrl();
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
      if (SeedPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (SeedPeer.VID.equals(name))
        {
            return setByName("Vid", value);
        }
      if (SeedPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (SeedPeer.URL.equals(name))
        {
            return setByName("Url", value);
        }
      if (SeedPeer.DESCRIPTION.equals(name))
        {
            return setByName("Description", value);
        }
      if (SeedPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (SeedPeer.SITE.equals(name))
        {
            return setByName("Site", value);
        }
      if (SeedPeer.SURVEY_URL.equals(name))
        {
            return setByName("SurveyUrl", value);
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
            return getVid();
        }
        if (pos == 2)
        {
            return getName();
        }
        if (pos == 3)
        {
            return getUrl();
        }
        if (pos == 4)
        {
            return getDescription();
        }
        if (pos == 5)
        {
            return new Integer(getStatus());
        }
        if (pos == 6)
        {
            return new Integer(getSite());
        }
        if (pos == 7)
        {
            return getSurveyUrl();
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
            return setByName("Vid", value);
        }
    if (position == 2)
        {
            return setByName("Name", value);
        }
    if (position == 3)
        {
            return setByName("Url", value);
        }
    if (position == 4)
        {
            return setByName("Description", value);
        }
    if (position == 5)
        {
            return setByName("Status", value);
        }
    if (position == 6)
        {
            return setByName("Site", value);
        }
    if (position == 7)
        {
            return setByName("SurveyUrl", value);
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
        save(SeedPeer.DATABASE_NAME);
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
                    SeedPeer.doInsert((Seed) this, con);
                    setNew(false);
                }
                else
                {
                    SeedPeer.doUpdate((Seed) this, con);
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
    public Seed copy() throws TorqueException
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
    public Seed copy(Connection con) throws TorqueException
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
    public Seed copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Seed(), deepcopy);
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
    public Seed copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Seed(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Seed copyInto(Seed copyObj) throws TorqueException
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
    protected Seed copyInto(Seed copyObj, Connection con) throws TorqueException
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
    protected Seed copyInto(Seed copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setVid(vid);
        copyObj.setName(name);
        copyObj.setUrl(url);
        copyObj.setDescription(description);
        copyObj.setStatus(status);
        copyObj.setSite(site);
        copyObj.setSurveyUrl(surveyUrl);

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
    protected Seed copyInto(Seed copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setVid(vid);
        copyObj.setName(name);
        copyObj.setUrl(url);
        copyObj.setDescription(description);
        copyObj.setStatus(status);
        copyObj.setSite(site);
        copyObj.setSurveyUrl(surveyUrl);

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
    public SeedPeer getPeer()
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
        return SeedPeer.getTableMap();
    }

  
    /**
     * Creates a SeedBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a SeedBean with the contents of this object
     */
    public SeedBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a SeedBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a SeedBean with the contents of this object
     */
    public SeedBean getBean(IdentityMap createdBeans)
    {
        SeedBean result = (SeedBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new SeedBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setVid(getVid());
        result.setName(getName());
        result.setUrl(getUrl());
        result.setDescription(getDescription());
        result.setStatus(getStatus());
        result.setSite(getSite());
        result.setSurveyUrl(getSurveyUrl());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Seed with the contents
     * of a SeedBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the SeedBean which contents are used to create
     *        the resulting class
     * @return an instance of Seed with the contents of bean
     */
    public static Seed createSeed(SeedBean bean)
        throws TorqueException
    {
        return createSeed(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Seed with the contents
     * of a SeedBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the SeedBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Seed with the contents of bean
     */

    public static Seed createSeed(SeedBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Seed result = (Seed) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Seed();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setVid(bean.getVid());
        result.setName(bean.getName());
        result.setUrl(bean.getUrl());
        result.setDescription(bean.getDescription());
        result.setStatus(bean.getStatus());
        result.setSite(bean.getSite());
        result.setSurveyUrl(bean.getSurveyUrl());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Seed:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Vid = ")
           .append(getVid())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Url = ")
           .append(getUrl())
           .append("\n");
        str.append("Description = ")
           .append(getDescription())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("Site = ")
           .append(getSite())
           .append("\n");
        str.append("SurveyUrl = ")
           .append(getSurveyUrl())
           .append("\n");
        return(str.toString());
    }
}
