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
import com.youku.atm.om.bean.IeBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Ie
 */
public abstract class BaseIe extends BaseObject
{
    /** The Peer class */
    private static final IePeer peer =
        new IePeer();


    /** The value for the id field */
    private int id;

    /** The value for the newIe field */
    private int newIe;

    /** The value for the oldIe field */
    private int oldIe;

    /** The value for the direction field */
    private int direction;

    /** The value for the type field */
    private int type;


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
     * Get the NewIe
     *
     * @return int
     */
    public int getNewIe()
    {
        return newIe;
    }


    /**
     * Set the value of NewIe
     *
     * @param v new value
     */
    public void setNewIe(int v) 
    {

        if (this.newIe != v)
        {
            this.newIe = v;
            setModified(true);
        }


    }

    /**
     * Get the OldIe
     *
     * @return int
     */
    public int getOldIe()
    {
        return oldIe;
    }


    /**
     * Set the value of OldIe
     *
     * @param v new value
     */
    public void setOldIe(int v) 
    {

        if (this.oldIe != v)
        {
            this.oldIe = v;
            setModified(true);
        }


    }

    /**
     * Get the Direction
     *
     * @return int
     */
    public int getDirection()
    {
        return direction;
    }


    /**
     * Set the value of Direction
     *
     * @param v new value
     */
    public void setDirection(int v) 
    {

        if (this.direction != v)
        {
            this.direction = v;
            setModified(true);
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
            fieldNames.add("NewIe");
            fieldNames.add("OldIe");
            fieldNames.add("Direction");
            fieldNames.add("Type");
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
        if (name.equals("NewIe"))
        {
            return new Integer(getNewIe());
        }
        if (name.equals("OldIe"))
        {
            return new Integer(getOldIe());
        }
        if (name.equals("Direction"))
        {
            return new Integer(getDirection());
        }
        if (name.equals("Type"))
        {
            return new Integer(getType());
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
        if (name.equals("NewIe"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNewIe(((Integer) value).intValue());
            return true;
        }
        if (name.equals("OldIe"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setOldIe(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Direction"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDirection(((Integer) value).intValue());
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
        if (name.equals(IePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IePeer.NEW_IE))
        {
            return new Integer(getNewIe());
        }
        if (name.equals(IePeer.OLD_IE))
        {
            return new Integer(getOldIe());
        }
        if (name.equals(IePeer.DIRECTION))
        {
            return new Integer(getDirection());
        }
        if (name.equals(IePeer.TYPE))
        {
            return new Integer(getType());
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
      if (IePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IePeer.NEW_IE.equals(name))
        {
            return setByName("NewIe", value);
        }
      if (IePeer.OLD_IE.equals(name))
        {
            return setByName("OldIe", value);
        }
      if (IePeer.DIRECTION.equals(name))
        {
            return setByName("Direction", value);
        }
      if (IePeer.TYPE.equals(name))
        {
            return setByName("Type", value);
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
            return new Integer(getNewIe());
        }
        if (pos == 2)
        {
            return new Integer(getOldIe());
        }
        if (pos == 3)
        {
            return new Integer(getDirection());
        }
        if (pos == 4)
        {
            return new Integer(getType());
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
            return setByName("NewIe", value);
        }
    if (position == 2)
        {
            return setByName("OldIe", value);
        }
    if (position == 3)
        {
            return setByName("Direction", value);
        }
    if (position == 4)
        {
            return setByName("Type", value);
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
        save(IePeer.DATABASE_NAME);
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
                    IePeer.doInsert((Ie) this, con);
                    setNew(false);
                }
                else
                {
                    IePeer.doUpdate((Ie) this, con);
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
    public Ie copy() throws TorqueException
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
    public Ie copy(Connection con) throws TorqueException
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
    public Ie copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Ie(), deepcopy);
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
    public Ie copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Ie(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Ie copyInto(Ie copyObj) throws TorqueException
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
    protected Ie copyInto(Ie copyObj, Connection con) throws TorqueException
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
    protected Ie copyInto(Ie copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setNewIe(newIe);
        copyObj.setOldIe(oldIe);
        copyObj.setDirection(direction);
        copyObj.setType(type);

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
    protected Ie copyInto(Ie copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setNewIe(newIe);
        copyObj.setOldIe(oldIe);
        copyObj.setDirection(direction);
        copyObj.setType(type);

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
    public IePeer getPeer()
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
        return IePeer.getTableMap();
    }

  
    /**
     * Creates a IeBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IeBean with the contents of this object
     */
    public IeBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IeBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IeBean with the contents of this object
     */
    public IeBean getBean(IdentityMap createdBeans)
    {
        IeBean result = (IeBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IeBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setNewIe(getNewIe());
        result.setOldIe(getOldIe());
        result.setDirection(getDirection());
        result.setType(getType());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Ie with the contents
     * of a IeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IeBean which contents are used to create
     *        the resulting class
     * @return an instance of Ie with the contents of bean
     */
    public static Ie createIe(IeBean bean)
        throws TorqueException
    {
        return createIe(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Ie with the contents
     * of a IeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IeBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Ie with the contents of bean
     */

    public static Ie createIe(IeBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Ie result = (Ie) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Ie();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setNewIe(bean.getNewIe());
        result.setOldIe(bean.getOldIe());
        result.setDirection(bean.getDirection());
        result.setType(bean.getType());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Ie:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("NewIe = ")
           .append(getNewIe())
           .append("\n");
        str.append("OldIe = ")
           .append(getOldIe())
           .append("\n");
        str.append("Direction = ")
           .append(getDirection())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        return(str.toString());
    }
}
