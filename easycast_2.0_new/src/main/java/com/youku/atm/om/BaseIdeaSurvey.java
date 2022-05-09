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
import com.youku.atm.om.bean.IdeaSurveyBean;
import com.youku.atm.om.bean.IdeaBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to IdeaSurvey
 */
public abstract class BaseIdeaSurvey extends BaseObject
{
    /** The Peer class */
    private static final IdeaSurveyPeer peer =
        new IdeaSurveyPeer();


    /** The value for the id field */
    private int id;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the stype field */
    private int stype;

    /** The value for the site field */
    private int site = 1;

    /** The value for the aw field */
    private String aw;

    /** The value for the surveyUrl field */
    private String surveyUrl;

    /** The value for the clickUrl field */
    private String clickUrl;

    /** The value for the surveyText field */
    private String surveyText;

    /** The value for the timeLen field */
    private int timeLen = 0;


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
    public void setIdeaId(int v) throws TorqueException
    {

        if (this.ideaId != v)
        {
            this.ideaId = v;
            setModified(true);
        }


        if (aIdea != null && !(aIdea.getId() == v))
        {
            aIdea = null;
        }

    }

    /**
     * Get the Stype
     *
     * @return int
     */
    public int getStype()
    {
        return stype;
    }


    /**
     * Set the value of Stype
     *
     * @param v new value
     */
    public void setStype(int v) 
    {

        if (this.stype != v)
        {
            this.stype = v;
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

    /**
     * Get the ClickUrl
     *
     * @return String
     */
    public String getClickUrl()
    {
        return clickUrl;
    }


    /**
     * Set the value of ClickUrl
     *
     * @param v new value
     */
    public void setClickUrl(String v) 
    {

        if (!ObjectUtils.equals(this.clickUrl, v))
        {
            this.clickUrl = v;
            setModified(true);
        }


    }

    /**
     * Get the SurveyText
     *
     * @return String
     */
    public String getSurveyText()
    {
        return surveyText;
    }


    /**
     * Set the value of SurveyText
     *
     * @param v new value
     */
    public void setSurveyText(String v) 
    {

        if (!ObjectUtils.equals(this.surveyText, v))
        {
            this.surveyText = v;
            setModified(true);
        }


    }

    /**
     * Get the TimeLen
     *
     * @return int
     */
    public int getTimeLen()
    {
        return timeLen;
    }


    /**
     * Set the value of TimeLen
     *
     * @param v new value
     */
    public void setTimeLen(int v) 
    {

        if (this.timeLen != v)
        {
            this.timeLen = v;
            setModified(true);
        }


    }

    



    private Idea aIdea;

    /**
     * Declares an association between this object and a Idea object
     *
     * @param v Idea
     * @throws TorqueException
     */
    public void setIdea(Idea v) throws TorqueException
    {
        if (v == null)
        {
            setIdeaId( 0);
        }
        else
        {
            setIdeaId(v.getId());
        }
        aIdea = v;
    }


    /**
     * Returns the associated Idea object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Idea object
     * @throws TorqueException
     */
    public Idea getIdea()
        throws TorqueException
    {
        if (aIdea == null && (this.ideaId != 0))
        {
            aIdea = IdeaPeer.retrieveByPK(SimpleKey.keyFor(this.ideaId));
        }
        return aIdea;
    }

    /**
     * Return the associated Idea object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Idea object
     * @throws TorqueException
     */
    public Idea getIdea(Connection connection)
        throws TorqueException
    {
        if (aIdea == null && (this.ideaId != 0))
        {
            aIdea = IdeaPeer.retrieveByPK(SimpleKey.keyFor(this.ideaId), connection);
        }
        return aIdea;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setIdeaKey(ObjectKey key) throws TorqueException
    {

        setIdeaId(((NumberKey) key).intValue());
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
            fieldNames.add("IdeaId");
            fieldNames.add("Stype");
            fieldNames.add("Site");
            fieldNames.add("Aw");
            fieldNames.add("SurveyUrl");
            fieldNames.add("ClickUrl");
            fieldNames.add("SurveyText");
            fieldNames.add("TimeLen");
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
        if (name.equals("IdeaId"))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals("Stype"))
        {
            return new Integer(getStype());
        }
        if (name.equals("Site"))
        {
            return new Integer(getSite());
        }
        if (name.equals("Aw"))
        {
            return getAw();
        }
        if (name.equals("SurveyUrl"))
        {
            return getSurveyUrl();
        }
        if (name.equals("ClickUrl"))
        {
            return getClickUrl();
        }
        if (name.equals("SurveyText"))
        {
            return getSurveyText();
        }
        if (name.equals("TimeLen"))
        {
            return new Integer(getTimeLen());
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
        if (name.equals("IdeaId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Stype"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStype(((Integer) value).intValue());
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
        if (name.equals("ClickUrl"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setClickUrl((String) value);
            return true;
        }
        if (name.equals("SurveyText"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSurveyText((String) value);
            return true;
        }
        if (name.equals("TimeLen"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTimeLen(((Integer) value).intValue());
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
        if (name.equals(IdeaSurveyPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IdeaSurveyPeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(IdeaSurveyPeer.STYPE))
        {
            return new Integer(getStype());
        }
        if (name.equals(IdeaSurveyPeer.SITE))
        {
            return new Integer(getSite());
        }
        if (name.equals(IdeaSurveyPeer.AW))
        {
            return getAw();
        }
        if (name.equals(IdeaSurveyPeer.SURVEY_URL))
        {
            return getSurveyUrl();
        }
        if (name.equals(IdeaSurveyPeer.CLICK_URL))
        {
            return getClickUrl();
        }
        if (name.equals(IdeaSurveyPeer.SURVEY_TEXT))
        {
            return getSurveyText();
        }
        if (name.equals(IdeaSurveyPeer.TIME_LEN))
        {
            return new Integer(getTimeLen());
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
      if (IdeaSurveyPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IdeaSurveyPeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (IdeaSurveyPeer.STYPE.equals(name))
        {
            return setByName("Stype", value);
        }
      if (IdeaSurveyPeer.SITE.equals(name))
        {
            return setByName("Site", value);
        }
      if (IdeaSurveyPeer.AW.equals(name))
        {
            return setByName("Aw", value);
        }
      if (IdeaSurveyPeer.SURVEY_URL.equals(name))
        {
            return setByName("SurveyUrl", value);
        }
      if (IdeaSurveyPeer.CLICK_URL.equals(name))
        {
            return setByName("ClickUrl", value);
        }
      if (IdeaSurveyPeer.SURVEY_TEXT.equals(name))
        {
            return setByName("SurveyText", value);
        }
      if (IdeaSurveyPeer.TIME_LEN.equals(name))
        {
            return setByName("TimeLen", value);
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
            return new Integer(getIdeaId());
        }
        if (pos == 2)
        {
            return new Integer(getStype());
        }
        if (pos == 3)
        {
            return new Integer(getSite());
        }
        if (pos == 4)
        {
            return getAw();
        }
        if (pos == 5)
        {
            return getSurveyUrl();
        }
        if (pos == 6)
        {
            return getClickUrl();
        }
        if (pos == 7)
        {
            return getSurveyText();
        }
        if (pos == 8)
        {
            return new Integer(getTimeLen());
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
            return setByName("IdeaId", value);
        }
    if (position == 2)
        {
            return setByName("Stype", value);
        }
    if (position == 3)
        {
            return setByName("Site", value);
        }
    if (position == 4)
        {
            return setByName("Aw", value);
        }
    if (position == 5)
        {
            return setByName("SurveyUrl", value);
        }
    if (position == 6)
        {
            return setByName("ClickUrl", value);
        }
    if (position == 7)
        {
            return setByName("SurveyText", value);
        }
    if (position == 8)
        {
            return setByName("TimeLen", value);
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
        save(IdeaSurveyPeer.DATABASE_NAME);
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
                    IdeaSurveyPeer.doInsert((IdeaSurvey) this, con);
                    setNew(false);
                }
                else
                {
                    IdeaSurveyPeer.doUpdate((IdeaSurvey) this, con);
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
    public IdeaSurvey copy() throws TorqueException
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
    public IdeaSurvey copy(Connection con) throws TorqueException
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
    public IdeaSurvey copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new IdeaSurvey(), deepcopy);
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
    public IdeaSurvey copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new IdeaSurvey(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected IdeaSurvey copyInto(IdeaSurvey copyObj) throws TorqueException
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
    protected IdeaSurvey copyInto(IdeaSurvey copyObj, Connection con) throws TorqueException
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
    protected IdeaSurvey copyInto(IdeaSurvey copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setStype(stype);
        copyObj.setSite(site);
        copyObj.setAw(aw);
        copyObj.setSurveyUrl(surveyUrl);
        copyObj.setClickUrl(clickUrl);
        copyObj.setSurveyText(surveyText);
        copyObj.setTimeLen(timeLen);

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
    protected IdeaSurvey copyInto(IdeaSurvey copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setStype(stype);
        copyObj.setSite(site);
        copyObj.setAw(aw);
        copyObj.setSurveyUrl(surveyUrl);
        copyObj.setClickUrl(clickUrl);
        copyObj.setSurveyText(surveyText);
        copyObj.setTimeLen(timeLen);

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
    public IdeaSurveyPeer getPeer()
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
        return IdeaSurveyPeer.getTableMap();
    }

  
    /**
     * Creates a IdeaSurveyBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IdeaSurveyBean with the contents of this object
     */
    public IdeaSurveyBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IdeaSurveyBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IdeaSurveyBean with the contents of this object
     */
    public IdeaSurveyBean getBean(IdentityMap createdBeans)
    {
        IdeaSurveyBean result = (IdeaSurveyBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IdeaSurveyBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setIdeaId(getIdeaId());
        result.setStype(getStype());
        result.setSite(getSite());
        result.setAw(getAw());
        result.setSurveyUrl(getSurveyUrl());
        result.setClickUrl(getClickUrl());
        result.setSurveyText(getSurveyText());
        result.setTimeLen(getTimeLen());





        if (aIdea != null)
        {
            IdeaBean relatedBean = aIdea.getBean(createdBeans);
            result.setIdeaBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of IdeaSurvey with the contents
     * of a IdeaSurveyBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IdeaSurveyBean which contents are used to create
     *        the resulting class
     * @return an instance of IdeaSurvey with the contents of bean
     */
    public static IdeaSurvey createIdeaSurvey(IdeaSurveyBean bean)
        throws TorqueException
    {
        return createIdeaSurvey(bean, new IdentityMap());
    }

    /**
     * Creates an instance of IdeaSurvey with the contents
     * of a IdeaSurveyBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IdeaSurveyBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of IdeaSurvey with the contents of bean
     */

    public static IdeaSurvey createIdeaSurvey(IdeaSurveyBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        IdeaSurvey result = (IdeaSurvey) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new IdeaSurvey();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setIdeaId(bean.getIdeaId());
        result.setStype(bean.getStype());
        result.setSite(bean.getSite());
        result.setAw(bean.getAw());
        result.setSurveyUrl(bean.getSurveyUrl());
        result.setClickUrl(bean.getClickUrl());
        result.setSurveyText(bean.getSurveyText());
        result.setTimeLen(bean.getTimeLen());





        {
            IdeaBean relatedBean = bean.getIdeaBean();
            if (relatedBean != null)
            {
                Idea relatedObject = Idea.createIdea(relatedBean, createdObjects);
                result.setIdea(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("IdeaSurvey:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("Stype = ")
           .append(getStype())
           .append("\n");
        str.append("Site = ")
           .append(getSite())
           .append("\n");
        str.append("Aw = ")
           .append(getAw())
           .append("\n");
        str.append("SurveyUrl = ")
           .append(getSurveyUrl())
           .append("\n");
        str.append("ClickUrl = ")
           .append(getClickUrl())
           .append("\n");
        str.append("SurveyText = ")
           .append(getSurveyText())
           .append("\n");
        str.append("TimeLen = ")
           .append(getTimeLen())
           .append("\n");
        return(str.toString());
    }
}
