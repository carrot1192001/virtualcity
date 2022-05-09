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
import com.youku.atm.om.bean.IdeaMonitorBean;
import com.youku.atm.om.bean.IdeaBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to IdeaMonitor
 */
public abstract class BaseIdeaMonitor extends BaseObject
{
    /** The Peer class */
    private static final IdeaMonitorPeer peer =
        new IdeaMonitorPeer();


    /** The value for the id field */
    private int id;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the type field */
    private int type;

    /** The value for the site field */
    private int site;

    /** The value for the bt field */
    private int bt;

    /** The value for the url field */
    private String url;

    /** The value for the mt field */
    private int mt = -1;

    /** The value for the content field */
    private String content;

    /** The value for the seq field */
    private int seq = 0;

    /** The value for the castId field */
    private int castId = 0;


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
     * Get the Bt
     *
     * @return int
     */
    public int getBt()
    {
        return bt;
    }


    /**
     * Set the value of Bt
     *
     * @param v new value
     */
    public void setBt(int v) 
    {

        if (this.bt != v)
        {
            this.bt = v;
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
     * Get the Mt
     *
     * @return int
     */
    public int getMt()
    {
        return mt;
    }


    /**
     * Set the value of Mt
     *
     * @param v new value
     */
    public void setMt(int v) 
    {

        if (this.mt != v)
        {
            this.mt = v;
            setModified(true);
        }


    }

    /**
     * Get the Content
     *
     * @return String
     */
    public String getContent()
    {
        return content;
    }


    /**
     * Set the value of Content
     *
     * @param v new value
     */
    public void setContent(String v) 
    {

        if (!ObjectUtils.equals(this.content, v))
        {
            this.content = v;
            setModified(true);
        }


    }

    /**
     * Get the Seq
     *
     * @return int
     */
    public int getSeq()
    {
        return seq;
    }


    /**
     * Set the value of Seq
     *
     * @param v new value
     */
    public void setSeq(int v) 
    {

        if (this.seq != v)
        {
            this.seq = v;
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
            fieldNames.add("Type");
            fieldNames.add("Site");
            fieldNames.add("Bt");
            fieldNames.add("Url");
            fieldNames.add("Mt");
            fieldNames.add("Content");
            fieldNames.add("Seq");
            fieldNames.add("CastId");
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
        if (name.equals("Type"))
        {
            return new Integer(getType());
        }
        if (name.equals("Site"))
        {
            return new Integer(getSite());
        }
        if (name.equals("Bt"))
        {
            return new Integer(getBt());
        }
        if (name.equals("Url"))
        {
            return getUrl();
        }
        if (name.equals("Mt"))
        {
            return new Integer(getMt());
        }
        if (name.equals("Content"))
        {
            return getContent();
        }
        if (name.equals("Seq"))
        {
            return new Integer(getSeq());
        }
        if (name.equals("CastId"))
        {
            return new Integer(getCastId());
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
        if (name.equals("Type"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setType(((Integer) value).intValue());
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
        if (name.equals("Bt"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setBt(((Integer) value).intValue());
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
        if (name.equals("Mt"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMt(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Content"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setContent((String) value);
            return true;
        }
        if (name.equals("Seq"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSeq(((Integer) value).intValue());
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
        if (name.equals(IdeaMonitorPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IdeaMonitorPeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(IdeaMonitorPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(IdeaMonitorPeer.SITE))
        {
            return new Integer(getSite());
        }
        if (name.equals(IdeaMonitorPeer.BT))
        {
            return new Integer(getBt());
        }
        if (name.equals(IdeaMonitorPeer.URL))
        {
            return getUrl();
        }
        if (name.equals(IdeaMonitorPeer.MT))
        {
            return new Integer(getMt());
        }
        if (name.equals(IdeaMonitorPeer.CONTENT))
        {
            return getContent();
        }
        if (name.equals(IdeaMonitorPeer.SEQ))
        {
            return new Integer(getSeq());
        }
        if (name.equals(IdeaMonitorPeer.CAST_ID))
        {
            return new Integer(getCastId());
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
      if (IdeaMonitorPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IdeaMonitorPeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (IdeaMonitorPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (IdeaMonitorPeer.SITE.equals(name))
        {
            return setByName("Site", value);
        }
      if (IdeaMonitorPeer.BT.equals(name))
        {
            return setByName("Bt", value);
        }
      if (IdeaMonitorPeer.URL.equals(name))
        {
            return setByName("Url", value);
        }
      if (IdeaMonitorPeer.MT.equals(name))
        {
            return setByName("Mt", value);
        }
      if (IdeaMonitorPeer.CONTENT.equals(name))
        {
            return setByName("Content", value);
        }
      if (IdeaMonitorPeer.SEQ.equals(name))
        {
            return setByName("Seq", value);
        }
      if (IdeaMonitorPeer.CAST_ID.equals(name))
        {
            return setByName("CastId", value);
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
            return new Integer(getType());
        }
        if (pos == 3)
        {
            return new Integer(getSite());
        }
        if (pos == 4)
        {
            return new Integer(getBt());
        }
        if (pos == 5)
        {
            return getUrl();
        }
        if (pos == 6)
        {
            return new Integer(getMt());
        }
        if (pos == 7)
        {
            return getContent();
        }
        if (pos == 8)
        {
            return new Integer(getSeq());
        }
        if (pos == 9)
        {
            return new Integer(getCastId());
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
            return setByName("Type", value);
        }
    if (position == 3)
        {
            return setByName("Site", value);
        }
    if (position == 4)
        {
            return setByName("Bt", value);
        }
    if (position == 5)
        {
            return setByName("Url", value);
        }
    if (position == 6)
        {
            return setByName("Mt", value);
        }
    if (position == 7)
        {
            return setByName("Content", value);
        }
    if (position == 8)
        {
            return setByName("Seq", value);
        }
    if (position == 9)
        {
            return setByName("CastId", value);
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
        save(IdeaMonitorPeer.DATABASE_NAME);
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
                    IdeaMonitorPeer.doInsert((IdeaMonitor) this, con);
                    setNew(false);
                }
                else
                {
                    IdeaMonitorPeer.doUpdate((IdeaMonitor) this, con);
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
    public IdeaMonitor copy() throws TorqueException
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
    public IdeaMonitor copy(Connection con) throws TorqueException
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
    public IdeaMonitor copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new IdeaMonitor(), deepcopy);
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
    public IdeaMonitor copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new IdeaMonitor(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected IdeaMonitor copyInto(IdeaMonitor copyObj) throws TorqueException
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
    protected IdeaMonitor copyInto(IdeaMonitor copyObj, Connection con) throws TorqueException
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
    protected IdeaMonitor copyInto(IdeaMonitor copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setType(type);
        copyObj.setSite(site);
        copyObj.setBt(bt);
        copyObj.setUrl(url);
        copyObj.setMt(mt);
        copyObj.setContent(content);
        copyObj.setSeq(seq);
        copyObj.setCastId(castId);

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
    protected IdeaMonitor copyInto(IdeaMonitor copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setType(type);
        copyObj.setSite(site);
        copyObj.setBt(bt);
        copyObj.setUrl(url);
        copyObj.setMt(mt);
        copyObj.setContent(content);
        copyObj.setSeq(seq);
        copyObj.setCastId(castId);

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
    public IdeaMonitorPeer getPeer()
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
        return IdeaMonitorPeer.getTableMap();
    }

  
    /**
     * Creates a IdeaMonitorBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IdeaMonitorBean with the contents of this object
     */
    public IdeaMonitorBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IdeaMonitorBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IdeaMonitorBean with the contents of this object
     */
    public IdeaMonitorBean getBean(IdentityMap createdBeans)
    {
        IdeaMonitorBean result = (IdeaMonitorBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IdeaMonitorBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setIdeaId(getIdeaId());
        result.setType(getType());
        result.setSite(getSite());
        result.setBt(getBt());
        result.setUrl(getUrl());
        result.setMt(getMt());
        result.setContent(getContent());
        result.setSeq(getSeq());
        result.setCastId(getCastId());





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
     * Creates an instance of IdeaMonitor with the contents
     * of a IdeaMonitorBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IdeaMonitorBean which contents are used to create
     *        the resulting class
     * @return an instance of IdeaMonitor with the contents of bean
     */
    public static IdeaMonitor createIdeaMonitor(IdeaMonitorBean bean)
        throws TorqueException
    {
        return createIdeaMonitor(bean, new IdentityMap());
    }

    /**
     * Creates an instance of IdeaMonitor with the contents
     * of a IdeaMonitorBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IdeaMonitorBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of IdeaMonitor with the contents of bean
     */

    public static IdeaMonitor createIdeaMonitor(IdeaMonitorBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        IdeaMonitor result = (IdeaMonitor) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new IdeaMonitor();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setIdeaId(bean.getIdeaId());
        result.setType(bean.getType());
        result.setSite(bean.getSite());
        result.setBt(bean.getBt());
        result.setUrl(bean.getUrl());
        result.setMt(bean.getMt());
        result.setContent(bean.getContent());
        result.setSeq(bean.getSeq());
        result.setCastId(bean.getCastId());





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
        str.append("IdeaMonitor:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("Site = ")
           .append(getSite())
           .append("\n");
        str.append("Bt = ")
           .append(getBt())
           .append("\n");
        str.append("Url = ")
           .append(getUrl())
           .append("\n");
        str.append("Mt = ")
           .append(getMt())
           .append("\n");
        str.append("Content = ")
           .append(getContent())
           .append("\n");
        str.append("Seq = ")
           .append(getSeq())
           .append("\n");
        str.append("CastId = ")
           .append(getCastId())
           .append("\n");
        return(str.toString());
    }
}
