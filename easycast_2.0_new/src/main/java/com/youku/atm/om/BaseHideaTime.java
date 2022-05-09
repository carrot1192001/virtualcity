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
import com.youku.atm.om.bean.HideaTimeBean;
import com.youku.atm.om.bean.IdeaBean;
import com.youku.atm.om.bean.DcBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to HideaTime
 */
public abstract class BaseHideaTime extends BaseObject
{
    /** The Peer class */
    private static final HideaTimePeer peer =
        new HideaTimePeer();


    /** The value for the id field */
    private int id;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the starttime field */
    private Date starttime;

    /** The value for the endtime field */
    private Date endtime;

    /** The value for the dcId field */
    private int dcId = 0;

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
     * Get the Starttime
     *
     * @return Date
     */
    public Date getStarttime()
    {
        return starttime;
    }


    /**
     * Set the value of Starttime
     *
     * @param v new value
     */
    public void setStarttime(Date v) 
    {

        if (!ObjectUtils.equals(this.starttime, v))
        {
            this.starttime = v;
            setModified(true);
        }


    }

    /**
     * Get the Endtime
     *
     * @return Date
     */
    public Date getEndtime()
    {
        return endtime;
    }


    /**
     * Set the value of Endtime
     *
     * @param v new value
     */
    public void setEndtime(Date v) 
    {

        if (!ObjectUtils.equals(this.endtime, v))
        {
            this.endtime = v;
            setModified(true);
        }


    }

    /**
     * Get the DcId
     *
     * @return int
     */
    public int getDcId()
    {
        return dcId;
    }


    /**
     * Set the value of DcId
     *
     * @param v new value
     */
    public void setDcId(int v) throws TorqueException
    {

        if (this.dcId != v)
        {
            this.dcId = v;
            setModified(true);
        }


        if (aDc != null && !(aDc.getId() == v))
        {
            aDc = null;
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




    private Dc aDc;

    /**
     * Declares an association between this object and a Dc object
     *
     * @param v Dc
     * @throws TorqueException
     */
    public void setDc(Dc v) throws TorqueException
    {
        if (v == null)
        {
            setDcId( 0);
        }
        else
        {
            setDcId(v.getId());
        }
        aDc = v;
    }


    /**
     * Returns the associated Dc object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Dc object
     * @throws TorqueException
     */
    public Dc getDc()
        throws TorqueException
    {
        if (aDc == null && (this.dcId != 0))
        {
            aDc = DcPeer.retrieveByPK(SimpleKey.keyFor(this.dcId));
        }
        return aDc;
    }

    /**
     * Return the associated Dc object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Dc object
     * @throws TorqueException
     */
    public Dc getDc(Connection connection)
        throws TorqueException
    {
        if (aDc == null && (this.dcId != 0))
        {
            aDc = DcPeer.retrieveByPK(SimpleKey.keyFor(this.dcId), connection);
        }
        return aDc;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setDcKey(ObjectKey key) throws TorqueException
    {

        setDcId(((NumberKey) key).intValue());
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
            fieldNames.add("Starttime");
            fieldNames.add("Endtime");
            fieldNames.add("DcId");
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
        if (name.equals("IdeaId"))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals("Starttime"))
        {
            return getStarttime();
        }
        if (name.equals("Endtime"))
        {
            return getEndtime();
        }
        if (name.equals("DcId"))
        {
            return new Integer(getDcId());
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
        if (name.equals("IdeaId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Starttime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStarttime((Date) value);
            return true;
        }
        if (name.equals("Endtime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEndtime((Date) value);
            return true;
        }
        if (name.equals("DcId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDcId(((Integer) value).intValue());
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
        if (name.equals(HideaTimePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(HideaTimePeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(HideaTimePeer.STARTTIME))
        {
            return getStarttime();
        }
        if (name.equals(HideaTimePeer.ENDTIME))
        {
            return getEndtime();
        }
        if (name.equals(HideaTimePeer.DC_ID))
        {
            return new Integer(getDcId());
        }
        if (name.equals(HideaTimePeer.STATUS))
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
      if (HideaTimePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (HideaTimePeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (HideaTimePeer.STARTTIME.equals(name))
        {
            return setByName("Starttime", value);
        }
      if (HideaTimePeer.ENDTIME.equals(name))
        {
            return setByName("Endtime", value);
        }
      if (HideaTimePeer.DC_ID.equals(name))
        {
            return setByName("DcId", value);
        }
      if (HideaTimePeer.STATUS.equals(name))
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
            return new Integer(getIdeaId());
        }
        if (pos == 2)
        {
            return getStarttime();
        }
        if (pos == 3)
        {
            return getEndtime();
        }
        if (pos == 4)
        {
            return new Integer(getDcId());
        }
        if (pos == 5)
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
            return setByName("IdeaId", value);
        }
    if (position == 2)
        {
            return setByName("Starttime", value);
        }
    if (position == 3)
        {
            return setByName("Endtime", value);
        }
    if (position == 4)
        {
            return setByName("DcId", value);
        }
    if (position == 5)
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
        save(HideaTimePeer.DATABASE_NAME);
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
                    HideaTimePeer.doInsert((HideaTime) this, con);
                    setNew(false);
                }
                else
                {
                    HideaTimePeer.doUpdate((HideaTime) this, con);
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
    public HideaTime copy() throws TorqueException
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
    public HideaTime copy(Connection con) throws TorqueException
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
    public HideaTime copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new HideaTime(), deepcopy);
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
    public HideaTime copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new HideaTime(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected HideaTime copyInto(HideaTime copyObj) throws TorqueException
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
    protected HideaTime copyInto(HideaTime copyObj, Connection con) throws TorqueException
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
    protected HideaTime copyInto(HideaTime copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setStarttime(starttime);
        copyObj.setEndtime(endtime);
        copyObj.setDcId(dcId);
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
    protected HideaTime copyInto(HideaTime copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setStarttime(starttime);
        copyObj.setEndtime(endtime);
        copyObj.setDcId(dcId);
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
    public HideaTimePeer getPeer()
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
        return HideaTimePeer.getTableMap();
    }

  
    /**
     * Creates a HideaTimeBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a HideaTimeBean with the contents of this object
     */
    public HideaTimeBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a HideaTimeBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a HideaTimeBean with the contents of this object
     */
    public HideaTimeBean getBean(IdentityMap createdBeans)
    {
        HideaTimeBean result = (HideaTimeBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new HideaTimeBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setIdeaId(getIdeaId());
        result.setStarttime(getStarttime());
        result.setEndtime(getEndtime());
        result.setDcId(getDcId());
        result.setStatus(getStatus());





        if (aIdea != null)
        {
            IdeaBean relatedBean = aIdea.getBean(createdBeans);
            result.setIdeaBean(relatedBean);
        }



        if (aDc != null)
        {
            DcBean relatedBean = aDc.getBean(createdBeans);
            result.setDcBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of HideaTime with the contents
     * of a HideaTimeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the HideaTimeBean which contents are used to create
     *        the resulting class
     * @return an instance of HideaTime with the contents of bean
     */
    public static HideaTime createHideaTime(HideaTimeBean bean)
        throws TorqueException
    {
        return createHideaTime(bean, new IdentityMap());
    }

    /**
     * Creates an instance of HideaTime with the contents
     * of a HideaTimeBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the HideaTimeBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of HideaTime with the contents of bean
     */

    public static HideaTime createHideaTime(HideaTimeBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        HideaTime result = (HideaTime) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new HideaTime();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setIdeaId(bean.getIdeaId());
        result.setStarttime(bean.getStarttime());
        result.setEndtime(bean.getEndtime());
        result.setDcId(bean.getDcId());
        result.setStatus(bean.getStatus());





        {
            IdeaBean relatedBean = bean.getIdeaBean();
            if (relatedBean != null)
            {
                Idea relatedObject = Idea.createIdea(relatedBean, createdObjects);
                result.setIdea(relatedObject);
            }
        }



        {
            DcBean relatedBean = bean.getDcBean();
            if (relatedBean != null)
            {
                Dc relatedObject = Dc.createDc(relatedBean, createdObjects);
                result.setDc(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("HideaTime:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("Starttime = ")
           .append(getStarttime())
           .append("\n");
        str.append("Endtime = ")
           .append(getEndtime())
           .append("\n");
        str.append("DcId = ")
           .append(getDcId())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
