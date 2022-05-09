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
import com.youku.atm.om.bean.VPositionBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to VPosition
 */
public abstract class BaseVPosition extends BaseObject
{
    /** The Peer class */
    private static final VPositionPeer peer =
        new VPositionPeer();


    /** The value for the id field */
    private int id;

    /** The value for the parentId field */
    private int parentId;

    /** The value for the name field */
    private String name;

    /** The value for the manageType field */
    private String manageType;

    /** The value for the ps field */
    private int ps;

    /** The value for the adSeq field */
    private int adSeq;

    /** The value for the type field */
    private int type;

    /** The value for the status field */
    private int status = 1;


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
     * Get the ParentId
     *
     * @return int
     */
    public int getParentId()
    {
        return parentId;
    }


    /**
     * Set the value of ParentId
     *
     * @param v new value
     */
    public void setParentId(int v) 
    {

        if (this.parentId != v)
        {
            this.parentId = v;
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
     * Get the ManageType
     *
     * @return String
     */
    public String getManageType()
    {
        return manageType;
    }


    /**
     * Set the value of ManageType
     *
     * @param v new value
     */
    public void setManageType(String v) 
    {

        if (!ObjectUtils.equals(this.manageType, v))
        {
            this.manageType = v;
            setModified(true);
        }


    }

    /**
     * Get the Ps
     *
     * @return int
     */
    public int getPs()
    {
        return ps;
    }


    /**
     * Set the value of Ps
     *
     * @param v new value
     */
    public void setPs(int v) 
    {

        if (this.ps != v)
        {
            this.ps = v;
            setModified(true);
        }


    }

    /**
     * Get the AdSeq
     *
     * @return int
     */
    public int getAdSeq()
    {
        return adSeq;
    }


    /**
     * Set the value of AdSeq
     *
     * @param v new value
     */
    public void setAdSeq(int v) 
    {

        if (this.adSeq != v)
        {
            this.adSeq = v;
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
            fieldNames.add("ParentId");
            fieldNames.add("Name");
            fieldNames.add("ManageType");
            fieldNames.add("Ps");
            fieldNames.add("AdSeq");
            fieldNames.add("Type");
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
        if (name.equals("ParentId"))
        {
            return new Integer(getParentId());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("ManageType"))
        {
            return getManageType();
        }
        if (name.equals("Ps"))
        {
            return new Integer(getPs());
        }
        if (name.equals("AdSeq"))
        {
            return new Integer(getAdSeq());
        }
        if (name.equals("Type"))
        {
            return new Integer(getType());
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
        if (name.equals("ParentId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setParentId(((Integer) value).intValue());
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
        if (name.equals("ManageType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setManageType((String) value);
            return true;
        }
        if (name.equals("Ps"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPs(((Integer) value).intValue());
            return true;
        }
        if (name.equals("AdSeq"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAdSeq(((Integer) value).intValue());
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
        if (name.equals(VPositionPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(VPositionPeer.PARENT_ID))
        {
            return new Integer(getParentId());
        }
        if (name.equals(VPositionPeer.NAME))
        {
            return getName();
        }
        if (name.equals(VPositionPeer.MANAGE_TYPE))
        {
            return getManageType();
        }
        if (name.equals(VPositionPeer.PS))
        {
            return new Integer(getPs());
        }
        if (name.equals(VPositionPeer.AD_SEQ))
        {
            return new Integer(getAdSeq());
        }
        if (name.equals(VPositionPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(VPositionPeer.STATUS))
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
      if (VPositionPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (VPositionPeer.PARENT_ID.equals(name))
        {
            return setByName("ParentId", value);
        }
      if (VPositionPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (VPositionPeer.MANAGE_TYPE.equals(name))
        {
            return setByName("ManageType", value);
        }
      if (VPositionPeer.PS.equals(name))
        {
            return setByName("Ps", value);
        }
      if (VPositionPeer.AD_SEQ.equals(name))
        {
            return setByName("AdSeq", value);
        }
      if (VPositionPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (VPositionPeer.STATUS.equals(name))
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
            return new Integer(getParentId());
        }
        if (pos == 2)
        {
            return getName();
        }
        if (pos == 3)
        {
            return getManageType();
        }
        if (pos == 4)
        {
            return new Integer(getPs());
        }
        if (pos == 5)
        {
            return new Integer(getAdSeq());
        }
        if (pos == 6)
        {
            return new Integer(getType());
        }
        if (pos == 7)
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
            return setByName("ParentId", value);
        }
    if (position == 2)
        {
            return setByName("Name", value);
        }
    if (position == 3)
        {
            return setByName("ManageType", value);
        }
    if (position == 4)
        {
            return setByName("Ps", value);
        }
    if (position == 5)
        {
            return setByName("AdSeq", value);
        }
    if (position == 6)
        {
            return setByName("Type", value);
        }
    if (position == 7)
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
        save(VPositionPeer.DATABASE_NAME);
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
                    VPositionPeer.doInsert((VPosition) this, con);
                    setNew(false);
                }
                else
                {
                    VPositionPeer.doUpdate((VPosition) this, con);
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
    public VPosition copy() throws TorqueException
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
    public VPosition copy(Connection con) throws TorqueException
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
    public VPosition copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new VPosition(), deepcopy);
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
    public VPosition copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new VPosition(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected VPosition copyInto(VPosition copyObj) throws TorqueException
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
    protected VPosition copyInto(VPosition copyObj, Connection con) throws TorqueException
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
    protected VPosition copyInto(VPosition copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setName(name);
        copyObj.setManageType(manageType);
        copyObj.setPs(ps);
        copyObj.setAdSeq(adSeq);
        copyObj.setType(type);
        copyObj.setStatus(status);

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
    protected VPosition copyInto(VPosition copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setName(name);
        copyObj.setManageType(manageType);
        copyObj.setPs(ps);
        copyObj.setAdSeq(adSeq);
        copyObj.setType(type);
        copyObj.setStatus(status);

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
    public VPositionPeer getPeer()
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
        return VPositionPeer.getTableMap();
    }

  
    /**
     * Creates a VPositionBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a VPositionBean with the contents of this object
     */
    public VPositionBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a VPositionBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a VPositionBean with the contents of this object
     */
    public VPositionBean getBean(IdentityMap createdBeans)
    {
        VPositionBean result = (VPositionBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new VPositionBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setParentId(getParentId());
        result.setName(getName());
        result.setManageType(getManageType());
        result.setPs(getPs());
        result.setAdSeq(getAdSeq());
        result.setType(getType());
        result.setStatus(getStatus());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of VPosition with the contents
     * of a VPositionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the VPositionBean which contents are used to create
     *        the resulting class
     * @return an instance of VPosition with the contents of bean
     */
    public static VPosition createVPosition(VPositionBean bean)
        throws TorqueException
    {
        return createVPosition(bean, new IdentityMap());
    }

    /**
     * Creates an instance of VPosition with the contents
     * of a VPositionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the VPositionBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of VPosition with the contents of bean
     */

    public static VPosition createVPosition(VPositionBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        VPosition result = (VPosition) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new VPosition();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setParentId(bean.getParentId());
        result.setName(bean.getName());
        result.setManageType(bean.getManageType());
        result.setPs(bean.getPs());
        result.setAdSeq(bean.getAdSeq());
        result.setType(bean.getType());
        result.setStatus(bean.getStatus());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("VPosition:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ParentId = ")
           .append(getParentId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("ManageType = ")
           .append(getManageType())
           .append("\n");
        str.append("Ps = ")
           .append(getPs())
           .append("\n");
        str.append("AdSeq = ")
           .append(getAdSeq())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
