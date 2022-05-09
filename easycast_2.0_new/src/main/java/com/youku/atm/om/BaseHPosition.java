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
import com.youku.atm.om.bean.HPositionBean;

import com.youku.atm.om.bean.CastHpositionBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to HPosition
 */
public abstract class BaseHPosition extends BaseObject
{
    /** The Peer class */
    private static final HPositionPeer peer =
        new HPositionPeer();


    /** The value for the id field */
    private int id;

    /** The value for the parentId field */
    private int parentId;

    /** The value for the name field */
    private String name;

    /** The value for the type field */
    private int type;

    /** The value for the value field */
    private int value;

    /** The value for the templet field */
    private String templet;

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
    public void setId(int v) throws TorqueException
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
        }



        // update associated CastHposition
        if (collCastHpositions != null)
        {
            for (int i = 0; i < collCastHpositions.size(); i++)
            {
                ((CastHposition) collCastHpositions.get(i))
                        .setDirectValue(v);
            }
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
     * Get the Value
     *
     * @return int
     */
    public int getValue()
    {
        return value;
    }


    /**
     * Set the value of Value
     *
     * @param v new value
     */
    public void setValue(int v) 
    {

        if (this.value != v)
        {
            this.value = v;
            setModified(true);
        }


    }

    /**
     * Get the Templet
     *
     * @return String
     */
    public String getTemplet()
    {
        return templet;
    }


    /**
     * Set the value of Templet
     *
     * @param v new value
     */
    public void setTemplet(String v) 
    {

        if (!ObjectUtils.equals(this.templet, v))
        {
            this.templet = v;
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
     * Collection to store aggregation of collCastHpositions
     */
    protected List<CastHposition> collCastHpositions;

    /**
     * Temporary storage of collCastHpositions to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastHpositions()
    {
        if (collCastHpositions == null)
        {
            collCastHpositions = new ArrayList<CastHposition>();
        }
    }


    /**
     * Method called to associate a CastHposition object to this object
     * through the CastHposition foreign key attribute
     *
     * @param l CastHposition
     * @throws TorqueException
     */
    public void addCastHposition(CastHposition l) throws TorqueException
    {
        getCastHpositions().add(l);
        l.setHPosition((HPosition) this);
    }

    /**
     * Method called to associate a CastHposition object to this object
     * through the CastHposition foreign key attribute using connection.
     *
     * @param l CastHposition
     * @throws TorqueException
     */
    public void addCastHposition(CastHposition l, Connection con) throws TorqueException
    {
        getCastHpositions(con).add(l);
        l.setHPosition((HPosition) this);
    }

    /**
     * The criteria used to select the current contents of collCastHpositions
     */
    private Criteria lastCastHpositionsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastHpositions(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastHposition> getCastHpositions()
        throws TorqueException
    {
        if (collCastHpositions == null)
        {
            collCastHpositions = getCastHpositions(new Criteria(10));
        }
        return collCastHpositions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this HPosition has previously
     * been saved, it will retrieve related CastHpositions from storage.
     * If this HPosition is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastHposition> getCastHpositions(Criteria criteria) throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                criteria.add(CastHpositionPeer.DIRECT_VALUE, getId() );
                collCastHpositions = CastHpositionPeer.doSelect(criteria);
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
                criteria.add(CastHpositionPeer.DIRECT_VALUE, getId());
                if (!lastCastHpositionsCriteria.equals(criteria))
                {
                    collCastHpositions = CastHpositionPeer.doSelect(criteria);
                }
            }
        }
        lastCastHpositionsCriteria = criteria;

        return collCastHpositions;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastHpositions(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastHposition> getCastHpositions(Connection con) throws TorqueException
    {
        if (collCastHpositions == null)
        {
            collCastHpositions = getCastHpositions(new Criteria(10), con);
        }
        return collCastHpositions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this HPosition has previously
     * been saved, it will retrieve related CastHpositions from storage.
     * If this HPosition is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastHposition> getCastHpositions(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                 criteria.add(CastHpositionPeer.DIRECT_VALUE, getId());
                 collCastHpositions = CastHpositionPeer.doSelect(criteria, con);
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
                 criteria.add(CastHpositionPeer.DIRECT_VALUE, getId());
                 if (!lastCastHpositionsCriteria.equals(criteria))
                 {
                     collCastHpositions = CastHpositionPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastHpositionsCriteria = criteria;

         return collCastHpositions;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this HPosition is new, it will return
     * an empty collection; or if this HPosition has previously
     * been saved, it will retrieve related CastHpositions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in HPosition.
     */
    protected List<CastHposition> getCastHpositionsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                criteria.add(CastHpositionPeer.DIRECT_VALUE, getId());
                collCastHpositions = CastHpositionPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastHpositionPeer.DIRECT_VALUE, getId());
            if (!lastCastHpositionsCriteria.equals(criteria))
            {
                collCastHpositions = CastHpositionPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastHpositionsCriteria = criteria;

        return collCastHpositions;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this HPosition is new, it will return
     * an empty collection; or if this HPosition has previously
     * been saved, it will retrieve related CastHpositions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in HPosition.
     */
    protected List<CastHposition> getCastHpositionsJoinHPosition(Criteria criteria)
        throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                criteria.add(CastHpositionPeer.DIRECT_VALUE, getId());
                collCastHpositions = CastHpositionPeer.doSelectJoinHPosition(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastHpositionPeer.DIRECT_VALUE, getId());
            if (!lastCastHpositionsCriteria.equals(criteria))
            {
                collCastHpositions = CastHpositionPeer.doSelectJoinHPosition(criteria);
            }
        }
        lastCastHpositionsCriteria = criteria;

        return collCastHpositions;
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
            fieldNames.add("Type");
            fieldNames.add("Value");
            fieldNames.add("Templet");
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
        if (name.equals("Type"))
        {
            return new Integer(getType());
        }
        if (name.equals("Value"))
        {
            return new Integer(getValue());
        }
        if (name.equals("Templet"))
        {
            return getTemplet();
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
        if (name.equals("Type"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Value"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setValue(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Templet"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTemplet((String) value);
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
        if (name.equals(HPositionPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(HPositionPeer.PARENT_ID))
        {
            return new Integer(getParentId());
        }
        if (name.equals(HPositionPeer.NAME))
        {
            return getName();
        }
        if (name.equals(HPositionPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(HPositionPeer.VALUE))
        {
            return new Integer(getValue());
        }
        if (name.equals(HPositionPeer.TEMPLET))
        {
            return getTemplet();
        }
        if (name.equals(HPositionPeer.STATUS))
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
      if (HPositionPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (HPositionPeer.PARENT_ID.equals(name))
        {
            return setByName("ParentId", value);
        }
      if (HPositionPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (HPositionPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (HPositionPeer.VALUE.equals(name))
        {
            return setByName("Value", value);
        }
      if (HPositionPeer.TEMPLET.equals(name))
        {
            return setByName("Templet", value);
        }
      if (HPositionPeer.STATUS.equals(name))
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
            return new Integer(getType());
        }
        if (pos == 4)
        {
            return new Integer(getValue());
        }
        if (pos == 5)
        {
            return getTemplet();
        }
        if (pos == 6)
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
            return setByName("Type", value);
        }
    if (position == 4)
        {
            return setByName("Value", value);
        }
    if (position == 5)
        {
            return setByName("Templet", value);
        }
    if (position == 6)
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
        save(HPositionPeer.DATABASE_NAME);
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
                    HPositionPeer.doInsert((HPosition) this, con);
                    setNew(false);
                }
                else
                {
                    HPositionPeer.doUpdate((HPosition) this, con);
                }
            }


            if (collCastHpositions != null)
            {
                for (int i = 0; i < collCastHpositions.size(); i++)
                {
                    ((CastHposition) collCastHpositions.get(i)).save(con);
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
        throws TorqueException
    {
        setId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
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
    public HPosition copy() throws TorqueException
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
    public HPosition copy(Connection con) throws TorqueException
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
    public HPosition copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new HPosition(), deepcopy);
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
    public HPosition copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new HPosition(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected HPosition copyInto(HPosition copyObj) throws TorqueException
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
    protected HPosition copyInto(HPosition copyObj, Connection con) throws TorqueException
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
    protected HPosition copyInto(HPosition copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setName(name);
        copyObj.setType(type);
        copyObj.setValue(value);
        copyObj.setTemplet(templet);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastHposition> vCastHpositions = getCastHpositions();
        if (vCastHpositions != null)
        {
            for (int i = 0; i < vCastHpositions.size(); i++)
            {
                CastHposition obj =  vCastHpositions.get(i);
                copyObj.addCastHposition(obj.copy());
            }
        }
        else
        {
            copyObj.collCastHpositions = null;
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
    protected HPosition copyInto(HPosition copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setName(name);
        copyObj.setType(type);
        copyObj.setValue(value);
        copyObj.setTemplet(templet);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastHposition> vCastHpositions = getCastHpositions(con);
        if (vCastHpositions != null)
        {
            for (int i = 0; i < vCastHpositions.size(); i++)
            {
                CastHposition obj =  vCastHpositions.get(i);
                copyObj.addCastHposition(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastHpositions = null;
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
    public HPositionPeer getPeer()
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
        return HPositionPeer.getTableMap();
    }

  
    /**
     * Creates a HPositionBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a HPositionBean with the contents of this object
     */
    public HPositionBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a HPositionBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a HPositionBean with the contents of this object
     */
    public HPositionBean getBean(IdentityMap createdBeans)
    {
        HPositionBean result = (HPositionBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new HPositionBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setParentId(getParentId());
        result.setName(getName());
        result.setType(getType());
        result.setValue(getValue());
        result.setTemplet(getTemplet());
        result.setStatus(getStatus());



        if (collCastHpositions != null)
        {
            List<CastHpositionBean> relatedBeans = new ArrayList<CastHpositionBean>(collCastHpositions.size());
            for (Iterator<CastHposition> collCastHpositionsIt = collCastHpositions.iterator(); collCastHpositionsIt.hasNext(); )
            {
                CastHposition related = (CastHposition) collCastHpositionsIt.next();
                CastHpositionBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastHpositionBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of HPosition with the contents
     * of a HPositionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the HPositionBean which contents are used to create
     *        the resulting class
     * @return an instance of HPosition with the contents of bean
     */
    public static HPosition createHPosition(HPositionBean bean)
        throws TorqueException
    {
        return createHPosition(bean, new IdentityMap());
    }

    /**
     * Creates an instance of HPosition with the contents
     * of a HPositionBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the HPositionBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of HPosition with the contents of bean
     */

    public static HPosition createHPosition(HPositionBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        HPosition result = (HPosition) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new HPosition();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setParentId(bean.getParentId());
        result.setName(bean.getName());
        result.setType(bean.getType());
        result.setValue(bean.getValue());
        result.setTemplet(bean.getTemplet());
        result.setStatus(bean.getStatus());



        {
            List<CastHpositionBean> relatedBeans = bean.getCastHpositionBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastHpositionBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastHpositionBean relatedBean =  relatedBeansIt.next();
                    CastHposition related = CastHposition.createCastHposition(relatedBean, createdObjects);
                    result.addCastHpositionFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a CastHposition object to this object.
     * through the CastHposition foreign key attribute
     *
     * @param toAdd CastHposition
     */
    protected void addCastHpositionFromBean(CastHposition toAdd)
    {
        initCastHpositions();
        collCastHpositions.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("HPosition:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ParentId = ")
           .append(getParentId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("Value = ")
           .append(getValue())
           .append("\n");
        str.append("Templet = ")
           .append(getTemplet())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
