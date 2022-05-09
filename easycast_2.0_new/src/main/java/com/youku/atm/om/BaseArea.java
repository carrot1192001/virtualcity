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
import com.youku.atm.om.bean.AreaBean;

import com.youku.atm.om.bean.CastAreaBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Area
 */
public abstract class BaseArea extends BaseObject
{
    /** The Peer class */
    private static final AreaPeer peer =
        new AreaPeer();


    /** The value for the id field */
    private String id;

    /** The value for the parentId field */
    private String parentId;

    /** The value for the level field */
    private String level;

    /** The value for the name field */
    private String name;

    /** The value for the status field */
    private int status = 1;

    /** The value for the description field */
    private String description;


    /**
     * Get the Id
     *
     * @return String
     */
    public String getId()
    {
        return id;
    }


    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(String v) throws TorqueException
    {

        if (!ObjectUtils.equals(this.id, v))
        {
            this.id = v;
            setModified(true);
        }



        // update associated CastArea
        if (collCastAreas != null)
        {
            for (int i = 0; i < collCastAreas.size(); i++)
            {
                ((CastArea) collCastAreas.get(i))
                        .setDirectValue(v);
            }
        }
    }

    /**
     * Get the ParentId
     *
     * @return String
     */
    public String getParentId()
    {
        return parentId;
    }


    /**
     * Set the value of ParentId
     *
     * @param v new value
     */
    public void setParentId(String v) 
    {

        if (!ObjectUtils.equals(this.parentId, v))
        {
            this.parentId = v;
            setModified(true);
        }


    }

    /**
     * Get the Level
     *
     * @return String
     */
    public String getLevel()
    {
        return level;
    }


    /**
     * Set the value of Level
     *
     * @param v new value
     */
    public void setLevel(String v) 
    {

        if (!ObjectUtils.equals(this.level, v))
        {
            this.level = v;
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
     * Collection to store aggregation of collCastAreas
     */
    protected List<CastArea> collCastAreas;

    /**
     * Temporary storage of collCastAreas to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastAreas()
    {
        if (collCastAreas == null)
        {
            collCastAreas = new ArrayList<CastArea>();
        }
    }


    /**
     * Method called to associate a CastArea object to this object
     * through the CastArea foreign key attribute
     *
     * @param l CastArea
     * @throws TorqueException
     */
    public void addCastArea(CastArea l) throws TorqueException
    {
        getCastAreas().add(l);
        l.setArea((Area) this);
    }

    /**
     * Method called to associate a CastArea object to this object
     * through the CastArea foreign key attribute using connection.
     *
     * @param l CastArea
     * @throws TorqueException
     */
    public void addCastArea(CastArea l, Connection con) throws TorqueException
    {
        getCastAreas(con).add(l);
        l.setArea((Area) this);
    }

    /**
     * The criteria used to select the current contents of collCastAreas
     */
    private Criteria lastCastAreasCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastAreas(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastArea> getCastAreas()
        throws TorqueException
    {
        if (collCastAreas == null)
        {
            collCastAreas = getCastAreas(new Criteria(10));
        }
        return collCastAreas;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Area has previously
     * been saved, it will retrieve related CastAreas from storage.
     * If this Area is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastArea> getCastAreas(Criteria criteria) throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                criteria.add(CastAreaPeer.DIRECT_VALUE, getId() );
                collCastAreas = CastAreaPeer.doSelect(criteria);
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
                criteria.add(CastAreaPeer.DIRECT_VALUE, getId());
                if (!lastCastAreasCriteria.equals(criteria))
                {
                    collCastAreas = CastAreaPeer.doSelect(criteria);
                }
            }
        }
        lastCastAreasCriteria = criteria;

        return collCastAreas;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastAreas(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastArea> getCastAreas(Connection con) throws TorqueException
    {
        if (collCastAreas == null)
        {
            collCastAreas = getCastAreas(new Criteria(10), con);
        }
        return collCastAreas;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Area has previously
     * been saved, it will retrieve related CastAreas from storage.
     * If this Area is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastArea> getCastAreas(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                 criteria.add(CastAreaPeer.DIRECT_VALUE, getId());
                 collCastAreas = CastAreaPeer.doSelect(criteria, con);
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
                 criteria.add(CastAreaPeer.DIRECT_VALUE, getId());
                 if (!lastCastAreasCriteria.equals(criteria))
                 {
                     collCastAreas = CastAreaPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastAreasCriteria = criteria;

         return collCastAreas;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Area is new, it will return
     * an empty collection; or if this Area has previously
     * been saved, it will retrieve related CastAreas from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Area.
     */
    protected List<CastArea> getCastAreasJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                criteria.add(CastAreaPeer.DIRECT_VALUE, getId());
                collCastAreas = CastAreaPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastAreaPeer.DIRECT_VALUE, getId());
            if (!lastCastAreasCriteria.equals(criteria))
            {
                collCastAreas = CastAreaPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastAreasCriteria = criteria;

        return collCastAreas;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Area is new, it will return
     * an empty collection; or if this Area has previously
     * been saved, it will retrieve related CastAreas from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Area.
     */
    protected List<CastArea> getCastAreasJoinArea(Criteria criteria)
        throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                criteria.add(CastAreaPeer.DIRECT_VALUE, getId());
                collCastAreas = CastAreaPeer.doSelectJoinArea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastAreaPeer.DIRECT_VALUE, getId());
            if (!lastCastAreasCriteria.equals(criteria))
            {
                collCastAreas = CastAreaPeer.doSelectJoinArea(criteria);
            }
        }
        lastCastAreasCriteria = criteria;

        return collCastAreas;
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
            fieldNames.add("Level");
            fieldNames.add("Name");
            fieldNames.add("Status");
            fieldNames.add("Description");
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
            return getId();
        }
        if (name.equals("ParentId"))
        {
            return getParentId();
        }
        if (name.equals("Level"))
        {
            return getLevel();
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("Description"))
        {
            return getDescription();
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
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setId((String) value);
            return true;
        }
        if (name.equals("ParentId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setParentId((String) value);
            return true;
        }
        if (name.equals("Level"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLevel((String) value);
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
        if (name.equals("Status"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStatus(((Integer) value).intValue());
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
        if (name.equals(AreaPeer.ID))
        {
            return getId();
        }
        if (name.equals(AreaPeer.PARENT_ID))
        {
            return getParentId();
        }
        if (name.equals(AreaPeer.LEVEL))
        {
            return getLevel();
        }
        if (name.equals(AreaPeer.NAME))
        {
            return getName();
        }
        if (name.equals(AreaPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(AreaPeer.DESCRIPTION))
        {
            return getDescription();
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
      if (AreaPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (AreaPeer.PARENT_ID.equals(name))
        {
            return setByName("ParentId", value);
        }
      if (AreaPeer.LEVEL.equals(name))
        {
            return setByName("Level", value);
        }
      if (AreaPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (AreaPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (AreaPeer.DESCRIPTION.equals(name))
        {
            return setByName("Description", value);
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
            return getId();
        }
        if (pos == 1)
        {
            return getParentId();
        }
        if (pos == 2)
        {
            return getLevel();
        }
        if (pos == 3)
        {
            return getName();
        }
        if (pos == 4)
        {
            return new Integer(getStatus());
        }
        if (pos == 5)
        {
            return getDescription();
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
            return setByName("Level", value);
        }
    if (position == 3)
        {
            return setByName("Name", value);
        }
    if (position == 4)
        {
            return setByName("Status", value);
        }
    if (position == 5)
        {
            return setByName("Description", value);
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
        save(AreaPeer.DATABASE_NAME);
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
                    AreaPeer.doInsert((Area) this, con);
                    setNew(false);
                }
                else
                {
                    AreaPeer.doUpdate((Area) this, con);
                }
            }


            if (collCastAreas != null)
            {
                for (int i = 0; i < collCastAreas.size(); i++)
                {
                    ((CastArea) collCastAreas.get(i)).save(con);
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
        setId(key.toString());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setId(key);
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
    public Area copy() throws TorqueException
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
    public Area copy(Connection con) throws TorqueException
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
    public Area copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Area(), deepcopy);
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
    public Area copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Area(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Area copyInto(Area copyObj) throws TorqueException
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
    protected Area copyInto(Area copyObj, Connection con) throws TorqueException
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
    protected Area copyInto(Area copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setLevel(level);
        copyObj.setName(name);
        copyObj.setStatus(status);
        copyObj.setDescription(description);

        copyObj.setId((String)null);

        if (deepcopy)
        {


        List<CastArea> vCastAreas = getCastAreas();
        if (vCastAreas != null)
        {
            for (int i = 0; i < vCastAreas.size(); i++)
            {
                CastArea obj =  vCastAreas.get(i);
                copyObj.addCastArea(obj.copy());
            }
        }
        else
        {
            copyObj.collCastAreas = null;
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
    protected Area copyInto(Area copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setParentId(parentId);
        copyObj.setLevel(level);
        copyObj.setName(name);
        copyObj.setStatus(status);
        copyObj.setDescription(description);

        copyObj.setId((String)null);

        if (deepcopy)
        {


        List<CastArea> vCastAreas = getCastAreas(con);
        if (vCastAreas != null)
        {
            for (int i = 0; i < vCastAreas.size(); i++)
            {
                CastArea obj =  vCastAreas.get(i);
                copyObj.addCastArea(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastAreas = null;
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
    public AreaPeer getPeer()
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
        return AreaPeer.getTableMap();
    }

  
    /**
     * Creates a AreaBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a AreaBean with the contents of this object
     */
    public AreaBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a AreaBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a AreaBean with the contents of this object
     */
    public AreaBean getBean(IdentityMap createdBeans)
    {
        AreaBean result = (AreaBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new AreaBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setParentId(getParentId());
        result.setLevel(getLevel());
        result.setName(getName());
        result.setStatus(getStatus());
        result.setDescription(getDescription());



        if (collCastAreas != null)
        {
            List<CastAreaBean> relatedBeans = new ArrayList<CastAreaBean>(collCastAreas.size());
            for (Iterator<CastArea> collCastAreasIt = collCastAreas.iterator(); collCastAreasIt.hasNext(); )
            {
                CastArea related = (CastArea) collCastAreasIt.next();
                CastAreaBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastAreaBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of Area with the contents
     * of a AreaBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the AreaBean which contents are used to create
     *        the resulting class
     * @return an instance of Area with the contents of bean
     */
    public static Area createArea(AreaBean bean)
        throws TorqueException
    {
        return createArea(bean, new IdentityMap());
    }

    /**
     * Creates an instance of Area with the contents
     * of a AreaBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the AreaBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of Area with the contents of bean
     */

    public static Area createArea(AreaBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        Area result = (Area) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new Area();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setParentId(bean.getParentId());
        result.setLevel(bean.getLevel());
        result.setName(bean.getName());
        result.setStatus(bean.getStatus());
        result.setDescription(bean.getDescription());



        {
            List<CastAreaBean> relatedBeans = bean.getCastAreaBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastAreaBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastAreaBean relatedBean =  relatedBeansIt.next();
                    CastArea related = CastArea.createCastArea(relatedBean, createdObjects);
                    result.addCastAreaFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a CastArea object to this object.
     * through the CastArea foreign key attribute
     *
     * @param toAdd CastArea
     */
    protected void addCastAreaFromBean(CastArea toAdd)
    {
        initCastAreas();
        collCastAreas.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Area:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ParentId = ")
           .append(getParentId())
           .append("\n");
        str.append("Level = ")
           .append(getLevel())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("Description = ")
           .append(getDescription())
           .append("\n");
        return(str.toString());
    }
}
