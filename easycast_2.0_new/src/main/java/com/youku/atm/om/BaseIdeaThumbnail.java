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
import com.youku.atm.om.bean.IdeaThumbnailBean;
import com.youku.atm.om.bean.IdeaUrlBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to IdeaThumbnail
 */
public abstract class BaseIdeaThumbnail extends BaseObject
{
    /** The Peer class */
    private static final IdeaThumbnailPeer peer =
        new IdeaThumbnailPeer();


    /** The value for the id field */
    private int id;

    /** The value for the thumbnailId field */
    private String thumbnailId;

    /** The value for the ideaUrlId field */
    private int ideaUrlId;

    /** The value for the title field */
    private String title;

    /** The value for the thumbnailUrl field */
    private String thumbnailUrl;

    /** The value for the updateTime field */
    private Date updateTime;


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
     * Get the ThumbnailId
     *
     * @return String
     */
    public String getThumbnailId()
    {
        return thumbnailId;
    }


    /**
     * Set the value of ThumbnailId
     *
     * @param v new value
     */
    public void setThumbnailId(String v) 
    {

        if (!ObjectUtils.equals(this.thumbnailId, v))
        {
            this.thumbnailId = v;
            setModified(true);
        }


    }

    /**
     * Get the IdeaUrlId
     *
     * @return int
     */
    public int getIdeaUrlId()
    {
        return ideaUrlId;
    }


    /**
     * Set the value of IdeaUrlId
     *
     * @param v new value
     */
    public void setIdeaUrlId(int v) throws TorqueException
    {

        if (this.ideaUrlId != v)
        {
            this.ideaUrlId = v;
            setModified(true);
        }


        if (aIdeaUrl != null && !(aIdeaUrl.getId() == v))
        {
            aIdeaUrl = null;
        }

    }

    /**
     * Get the Title
     *
     * @return String
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * Set the value of Title
     *
     * @param v new value
     */
    public void setTitle(String v) 
    {

        if (!ObjectUtils.equals(this.title, v))
        {
            this.title = v;
            setModified(true);
        }


    }

    /**
     * Get the ThumbnailUrl
     *
     * @return String
     */
    public String getThumbnailUrl()
    {
        return thumbnailUrl;
    }


    /**
     * Set the value of ThumbnailUrl
     *
     * @param v new value
     */
    public void setThumbnailUrl(String v) 
    {

        if (!ObjectUtils.equals(this.thumbnailUrl, v))
        {
            this.thumbnailUrl = v;
            setModified(true);
        }


    }

    /**
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime()
    {
        return updateTime;
    }


    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(Date v) 
    {

        if (!ObjectUtils.equals(this.updateTime, v))
        {
            this.updateTime = v;
            setModified(true);
        }


    }

    



    private IdeaUrl aIdeaUrl;

    /**
     * Declares an association between this object and a IdeaUrl object
     *
     * @param v IdeaUrl
     * @throws TorqueException
     */
    public void setIdeaUrl(IdeaUrl v) throws TorqueException
    {
        if (v == null)
        {
            setIdeaUrlId( 0);
        }
        else
        {
            setIdeaUrlId(v.getId());
        }
        aIdeaUrl = v;
    }


    /**
     * Returns the associated IdeaUrl object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated IdeaUrl object
     * @throws TorqueException
     */
    public IdeaUrl getIdeaUrl()
        throws TorqueException
    {
        if (aIdeaUrl == null && (this.ideaUrlId != 0))
        {
            aIdeaUrl = IdeaUrlPeer.retrieveByPK(SimpleKey.keyFor(this.ideaUrlId));
        }
        return aIdeaUrl;
    }

    /**
     * Return the associated IdeaUrl object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated IdeaUrl object
     * @throws TorqueException
     */
    public IdeaUrl getIdeaUrl(Connection connection)
        throws TorqueException
    {
        if (aIdeaUrl == null && (this.ideaUrlId != 0))
        {
            aIdeaUrl = IdeaUrlPeer.retrieveByPK(SimpleKey.keyFor(this.ideaUrlId), connection);
        }
        return aIdeaUrl;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setIdeaUrlKey(ObjectKey key) throws TorqueException
    {

        setIdeaUrlId(((NumberKey) key).intValue());
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
            fieldNames.add("ThumbnailId");
            fieldNames.add("IdeaUrlId");
            fieldNames.add("Title");
            fieldNames.add("ThumbnailUrl");
            fieldNames.add("UpdateTime");
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
        if (name.equals("ThumbnailId"))
        {
            return getThumbnailId();
        }
        if (name.equals("IdeaUrlId"))
        {
            return new Integer(getIdeaUrlId());
        }
        if (name.equals("Title"))
        {
            return getTitle();
        }
        if (name.equals("ThumbnailUrl"))
        {
            return getThumbnailUrl();
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
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
        if (name.equals("ThumbnailId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setThumbnailId((String) value);
            return true;
        }
        if (name.equals("IdeaUrlId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaUrlId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Title"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTitle((String) value);
            return true;
        }
        if (name.equals("ThumbnailUrl"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setThumbnailUrl((String) value);
            return true;
        }
        if (name.equals("UpdateTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUpdateTime((Date) value);
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
        if (name.equals(IdeaThumbnailPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IdeaThumbnailPeer.THUMBNAIL_ID))
        {
            return getThumbnailId();
        }
        if (name.equals(IdeaThumbnailPeer.IDEA_URL_ID))
        {
            return new Integer(getIdeaUrlId());
        }
        if (name.equals(IdeaThumbnailPeer.TITLE))
        {
            return getTitle();
        }
        if (name.equals(IdeaThumbnailPeer.THUMBNAIL_URL))
        {
            return getThumbnailUrl();
        }
        if (name.equals(IdeaThumbnailPeer.UPDATE_TIME))
        {
            return getUpdateTime();
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
      if (IdeaThumbnailPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IdeaThumbnailPeer.THUMBNAIL_ID.equals(name))
        {
            return setByName("ThumbnailId", value);
        }
      if (IdeaThumbnailPeer.IDEA_URL_ID.equals(name))
        {
            return setByName("IdeaUrlId", value);
        }
      if (IdeaThumbnailPeer.TITLE.equals(name))
        {
            return setByName("Title", value);
        }
      if (IdeaThumbnailPeer.THUMBNAIL_URL.equals(name))
        {
            return setByName("ThumbnailUrl", value);
        }
      if (IdeaThumbnailPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
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
            return getThumbnailId();
        }
        if (pos == 2)
        {
            return new Integer(getIdeaUrlId());
        }
        if (pos == 3)
        {
            return getTitle();
        }
        if (pos == 4)
        {
            return getThumbnailUrl();
        }
        if (pos == 5)
        {
            return getUpdateTime();
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
            return setByName("ThumbnailId", value);
        }
    if (position == 2)
        {
            return setByName("IdeaUrlId", value);
        }
    if (position == 3)
        {
            return setByName("Title", value);
        }
    if (position == 4)
        {
            return setByName("ThumbnailUrl", value);
        }
    if (position == 5)
        {
            return setByName("UpdateTime", value);
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
        save(IdeaThumbnailPeer.DATABASE_NAME);
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
                    IdeaThumbnailPeer.doInsert((IdeaThumbnail) this, con);
                    setNew(false);
                }
                else
                {
                    IdeaThumbnailPeer.doUpdate((IdeaThumbnail) this, con);
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
    public IdeaThumbnail copy() throws TorqueException
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
    public IdeaThumbnail copy(Connection con) throws TorqueException
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
    public IdeaThumbnail copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new IdeaThumbnail(), deepcopy);
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
    public IdeaThumbnail copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new IdeaThumbnail(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected IdeaThumbnail copyInto(IdeaThumbnail copyObj) throws TorqueException
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
    protected IdeaThumbnail copyInto(IdeaThumbnail copyObj, Connection con) throws TorqueException
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
    protected IdeaThumbnail copyInto(IdeaThumbnail copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setThumbnailId(thumbnailId);
        copyObj.setIdeaUrlId(ideaUrlId);
        copyObj.setTitle(title);
        copyObj.setThumbnailUrl(thumbnailUrl);
        copyObj.setUpdateTime(updateTime);

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
    protected IdeaThumbnail copyInto(IdeaThumbnail copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setThumbnailId(thumbnailId);
        copyObj.setIdeaUrlId(ideaUrlId);
        copyObj.setTitle(title);
        copyObj.setThumbnailUrl(thumbnailUrl);
        copyObj.setUpdateTime(updateTime);

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
    public IdeaThumbnailPeer getPeer()
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
        return IdeaThumbnailPeer.getTableMap();
    }

  
    /**
     * Creates a IdeaThumbnailBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IdeaThumbnailBean with the contents of this object
     */
    public IdeaThumbnailBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IdeaThumbnailBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IdeaThumbnailBean with the contents of this object
     */
    public IdeaThumbnailBean getBean(IdentityMap createdBeans)
    {
        IdeaThumbnailBean result = (IdeaThumbnailBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IdeaThumbnailBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setThumbnailId(getThumbnailId());
        result.setIdeaUrlId(getIdeaUrlId());
        result.setTitle(getTitle());
        result.setThumbnailUrl(getThumbnailUrl());
        result.setUpdateTime(getUpdateTime());





        if (aIdeaUrl != null)
        {
            IdeaUrlBean relatedBean = aIdeaUrl.getBean(createdBeans);
            result.setIdeaUrlBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of IdeaThumbnail with the contents
     * of a IdeaThumbnailBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IdeaThumbnailBean which contents are used to create
     *        the resulting class
     * @return an instance of IdeaThumbnail with the contents of bean
     */
    public static IdeaThumbnail createIdeaThumbnail(IdeaThumbnailBean bean)
        throws TorqueException
    {
        return createIdeaThumbnail(bean, new IdentityMap());
    }

    /**
     * Creates an instance of IdeaThumbnail with the contents
     * of a IdeaThumbnailBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IdeaThumbnailBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of IdeaThumbnail with the contents of bean
     */

    public static IdeaThumbnail createIdeaThumbnail(IdeaThumbnailBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        IdeaThumbnail result = (IdeaThumbnail) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new IdeaThumbnail();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setThumbnailId(bean.getThumbnailId());
        result.setIdeaUrlId(bean.getIdeaUrlId());
        result.setTitle(bean.getTitle());
        result.setThumbnailUrl(bean.getThumbnailUrl());
        result.setUpdateTime(bean.getUpdateTime());





        {
            IdeaUrlBean relatedBean = bean.getIdeaUrlBean();
            if (relatedBean != null)
            {
                IdeaUrl relatedObject = IdeaUrl.createIdeaUrl(relatedBean, createdObjects);
                result.setIdeaUrl(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("IdeaThumbnail:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ThumbnailId = ")
           .append(getThumbnailId())
           .append("\n");
        str.append("IdeaUrlId = ")
           .append(getIdeaUrlId())
           .append("\n");
        str.append("Title = ")
           .append(getTitle())
           .append("\n");
        str.append("ThumbnailUrl = ")
           .append(getThumbnailUrl())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        return(str.toString());
    }
}
