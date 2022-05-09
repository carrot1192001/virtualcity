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
import com.youku.atm.om.bean.OverflowRangeBean;
import com.youku.atm.om.bean.ResourceBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to OverflowRange
 */
public abstract class BaseOverflowRange extends BaseObject
{
    /** The Peer class */
    private static final OverflowRangePeer peer =
        new OverflowRangePeer();


    /** The value for the id field */
    private int id;

    /** The value for the resourceId field */
    private int resourceId;

    /** The value for the contents field */
    private String contents;


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
     * Get the Contents
     *
     * @return String
     */
    public String getContents()
    {
        return contents;
    }


    /**
     * Set the value of Contents
     *
     * @param v new value
     */
    public void setContents(String v) 
    {

        if (!ObjectUtils.equals(this.contents, v))
        {
            this.contents = v;
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
            fieldNames.add("ResourceId");
            fieldNames.add("Contents");
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
        if (name.equals("ResourceId"))
        {
            return new Integer(getResourceId());
        }
        if (name.equals("Contents"))
        {
            return getContents();
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
        if (name.equals("ResourceId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setResourceId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Contents"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setContents((String) value);
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
        if (name.equals(OverflowRangePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(OverflowRangePeer.RESOURCE_ID))
        {
            return new Integer(getResourceId());
        }
        if (name.equals(OverflowRangePeer.CONTENTS))
        {
            return getContents();
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
      if (OverflowRangePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (OverflowRangePeer.RESOURCE_ID.equals(name))
        {
            return setByName("ResourceId", value);
        }
      if (OverflowRangePeer.CONTENTS.equals(name))
        {
            return setByName("Contents", value);
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
            return new Integer(getResourceId());
        }
        if (pos == 2)
        {
            return getContents();
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
            return setByName("ResourceId", value);
        }
    if (position == 2)
        {
            return setByName("Contents", value);
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
        save(OverflowRangePeer.DATABASE_NAME);
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
                    OverflowRangePeer.doInsert((OverflowRange) this, con);
                    setNew(false);
                }
                else
                {
                    OverflowRangePeer.doUpdate((OverflowRange) this, con);
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
    public OverflowRange copy() throws TorqueException
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
    public OverflowRange copy(Connection con) throws TorqueException
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
    public OverflowRange copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new OverflowRange(), deepcopy);
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
    public OverflowRange copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new OverflowRange(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected OverflowRange copyInto(OverflowRange copyObj) throws TorqueException
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
    protected OverflowRange copyInto(OverflowRange copyObj, Connection con) throws TorqueException
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
    protected OverflowRange copyInto(OverflowRange copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setResourceId(resourceId);
        copyObj.setContents(contents);

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
    protected OverflowRange copyInto(OverflowRange copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setResourceId(resourceId);
        copyObj.setContents(contents);

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
    public OverflowRangePeer getPeer()
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
        return OverflowRangePeer.getTableMap();
    }

  
    /**
     * Creates a OverflowRangeBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a OverflowRangeBean with the contents of this object
     */
    public OverflowRangeBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a OverflowRangeBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a OverflowRangeBean with the contents of this object
     */
    public OverflowRangeBean getBean(IdentityMap createdBeans)
    {
        OverflowRangeBean result = (OverflowRangeBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new OverflowRangeBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setResourceId(getResourceId());
        result.setContents(getContents());





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
     * Creates an instance of OverflowRange with the contents
     * of a OverflowRangeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the OverflowRangeBean which contents are used to create
     *        the resulting class
     * @return an instance of OverflowRange with the contents of bean
     */
    public static OverflowRange createOverflowRange(OverflowRangeBean bean)
        throws TorqueException
    {
        return createOverflowRange(bean, new IdentityMap());
    }

    /**
     * Creates an instance of OverflowRange with the contents
     * of a OverflowRangeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the OverflowRangeBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of OverflowRange with the contents of bean
     */

    public static OverflowRange createOverflowRange(OverflowRangeBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        OverflowRange result = (OverflowRange) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new OverflowRange();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setResourceId(bean.getResourceId());
        result.setContents(bean.getContents());





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
        str.append("OverflowRange:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ResourceId = ")
           .append(getResourceId())
           .append("\n");
        str.append("Contents = ")
           .append(getContents())
           .append("\n");
        return(str.toString());
    }
}
