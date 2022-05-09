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
import com.youku.atm.om.bean.IdeaCpmBean;
import com.youku.atm.om.bean.IdeaBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to IdeaCpm
 */
public abstract class BaseIdeaCpm extends BaseObject
{
    /** The Peer class */
    private static final IdeaCpmPeer peer =
        new IdeaCpmPeer();


    /** The value for the id field */
    private int id;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the cpm field */
    private int cpm;

    /** The value for the cpc field */
    private int cpc;

    /** The value for the rate field */
    private int rate;

    /** The value for the cpv field */
    private int cpv = 0;

    /** The value for the cpp field */
    private int cpp = 0;

    /** The value for the targetDate field */
    private Date targetDate;


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
     * Get the Cpm
     *
     * @return int
     */
    public int getCpm()
    {
        return cpm;
    }


    /**
     * Set the value of Cpm
     *
     * @param v new value
     */
    public void setCpm(int v) 
    {

        if (this.cpm != v)
        {
            this.cpm = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpc
     *
     * @return int
     */
    public int getCpc()
    {
        return cpc;
    }


    /**
     * Set the value of Cpc
     *
     * @param v new value
     */
    public void setCpc(int v) 
    {

        if (this.cpc != v)
        {
            this.cpc = v;
            setModified(true);
        }


    }

    /**
     * Get the Rate
     *
     * @return int
     */
    public int getRate()
    {
        return rate;
    }


    /**
     * Set the value of Rate
     *
     * @param v new value
     */
    public void setRate(int v) 
    {

        if (this.rate != v)
        {
            this.rate = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpv
     *
     * @return int
     */
    public int getCpv()
    {
        return cpv;
    }


    /**
     * Set the value of Cpv
     *
     * @param v new value
     */
    public void setCpv(int v) 
    {

        if (this.cpv != v)
        {
            this.cpv = v;
            setModified(true);
        }


    }

    /**
     * Get the Cpp
     *
     * @return int
     */
    public int getCpp()
    {
        return cpp;
    }


    /**
     * Set the value of Cpp
     *
     * @param v new value
     */
    public void setCpp(int v) 
    {

        if (this.cpp != v)
        {
            this.cpp = v;
            setModified(true);
        }


    }

    /**
     * Get the TargetDate
     *
     * @return Date
     */
    public Date getTargetDate()
    {
        return targetDate;
    }


    /**
     * Set the value of TargetDate
     *
     * @param v new value
     */
    public void setTargetDate(Date v) 
    {

        if (!ObjectUtils.equals(this.targetDate, v))
        {
            this.targetDate = v;
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
            fieldNames.add("Cpm");
            fieldNames.add("Cpc");
            fieldNames.add("Rate");
            fieldNames.add("Cpv");
            fieldNames.add("Cpp");
            fieldNames.add("TargetDate");
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
        if (name.equals("Cpm"))
        {
            return new Integer(getCpm());
        }
        if (name.equals("Cpc"))
        {
            return new Integer(getCpc());
        }
        if (name.equals("Rate"))
        {
            return new Integer(getRate());
        }
        if (name.equals("Cpv"))
        {
            return new Integer(getCpv());
        }
        if (name.equals("Cpp"))
        {
            return new Integer(getCpp());
        }
        if (name.equals("TargetDate"))
        {
            return getTargetDate();
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
        if (name.equals("Cpm"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpm(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpc"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpc(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Rate"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRate(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpv"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpv(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Cpp"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCpp(((Integer) value).intValue());
            return true;
        }
        if (name.equals("TargetDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTargetDate((Date) value);
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
        if (name.equals(IdeaCpmPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IdeaCpmPeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(IdeaCpmPeer.CPM))
        {
            return new Integer(getCpm());
        }
        if (name.equals(IdeaCpmPeer.CPC))
        {
            return new Integer(getCpc());
        }
        if (name.equals(IdeaCpmPeer.RATE))
        {
            return new Integer(getRate());
        }
        if (name.equals(IdeaCpmPeer.CPV))
        {
            return new Integer(getCpv());
        }
        if (name.equals(IdeaCpmPeer.CPP))
        {
            return new Integer(getCpp());
        }
        if (name.equals(IdeaCpmPeer.TARGET_DATE))
        {
            return getTargetDate();
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
      if (IdeaCpmPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IdeaCpmPeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (IdeaCpmPeer.CPM.equals(name))
        {
            return setByName("Cpm", value);
        }
      if (IdeaCpmPeer.CPC.equals(name))
        {
            return setByName("Cpc", value);
        }
      if (IdeaCpmPeer.RATE.equals(name))
        {
            return setByName("Rate", value);
        }
      if (IdeaCpmPeer.CPV.equals(name))
        {
            return setByName("Cpv", value);
        }
      if (IdeaCpmPeer.CPP.equals(name))
        {
            return setByName("Cpp", value);
        }
      if (IdeaCpmPeer.TARGET_DATE.equals(name))
        {
            return setByName("TargetDate", value);
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
            return new Integer(getCpm());
        }
        if (pos == 3)
        {
            return new Integer(getCpc());
        }
        if (pos == 4)
        {
            return new Integer(getRate());
        }
        if (pos == 5)
        {
            return new Integer(getCpv());
        }
        if (pos == 6)
        {
            return new Integer(getCpp());
        }
        if (pos == 7)
        {
            return getTargetDate();
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
            return setByName("Cpm", value);
        }
    if (position == 3)
        {
            return setByName("Cpc", value);
        }
    if (position == 4)
        {
            return setByName("Rate", value);
        }
    if (position == 5)
        {
            return setByName("Cpv", value);
        }
    if (position == 6)
        {
            return setByName("Cpp", value);
        }
    if (position == 7)
        {
            return setByName("TargetDate", value);
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
        save(IdeaCpmPeer.DATABASE_NAME);
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
                    IdeaCpmPeer.doInsert((IdeaCpm) this, con);
                    setNew(false);
                }
                else
                {
                    IdeaCpmPeer.doUpdate((IdeaCpm) this, con);
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
    public IdeaCpm copy() throws TorqueException
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
    public IdeaCpm copy(Connection con) throws TorqueException
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
    public IdeaCpm copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new IdeaCpm(), deepcopy);
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
    public IdeaCpm copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new IdeaCpm(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected IdeaCpm copyInto(IdeaCpm copyObj) throws TorqueException
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
    protected IdeaCpm copyInto(IdeaCpm copyObj, Connection con) throws TorqueException
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
    protected IdeaCpm copyInto(IdeaCpm copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setCpm(cpm);
        copyObj.setCpc(cpc);
        copyObj.setRate(rate);
        copyObj.setCpv(cpv);
        copyObj.setCpp(cpp);
        copyObj.setTargetDate(targetDate);

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
    protected IdeaCpm copyInto(IdeaCpm copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setCpm(cpm);
        copyObj.setCpc(cpc);
        copyObj.setRate(rate);
        copyObj.setCpv(cpv);
        copyObj.setCpp(cpp);
        copyObj.setTargetDate(targetDate);

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
    public IdeaCpmPeer getPeer()
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
        return IdeaCpmPeer.getTableMap();
    }

  
    /**
     * Creates a IdeaCpmBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IdeaCpmBean with the contents of this object
     */
    public IdeaCpmBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IdeaCpmBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IdeaCpmBean with the contents of this object
     */
    public IdeaCpmBean getBean(IdentityMap createdBeans)
    {
        IdeaCpmBean result = (IdeaCpmBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IdeaCpmBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setIdeaId(getIdeaId());
        result.setCpm(getCpm());
        result.setCpc(getCpc());
        result.setRate(getRate());
        result.setCpv(getCpv());
        result.setCpp(getCpp());
        result.setTargetDate(getTargetDate());





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
     * Creates an instance of IdeaCpm with the contents
     * of a IdeaCpmBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IdeaCpmBean which contents are used to create
     *        the resulting class
     * @return an instance of IdeaCpm with the contents of bean
     */
    public static IdeaCpm createIdeaCpm(IdeaCpmBean bean)
        throws TorqueException
    {
        return createIdeaCpm(bean, new IdentityMap());
    }

    /**
     * Creates an instance of IdeaCpm with the contents
     * of a IdeaCpmBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IdeaCpmBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of IdeaCpm with the contents of bean
     */

    public static IdeaCpm createIdeaCpm(IdeaCpmBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        IdeaCpm result = (IdeaCpm) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new IdeaCpm();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setIdeaId(bean.getIdeaId());
        result.setCpm(bean.getCpm());
        result.setCpc(bean.getCpc());
        result.setRate(bean.getRate());
        result.setCpv(bean.getCpv());
        result.setCpp(bean.getCpp());
        result.setTargetDate(bean.getTargetDate());





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
        str.append("IdeaCpm:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("Cpm = ")
           .append(getCpm())
           .append("\n");
        str.append("Cpc = ")
           .append(getCpc())
           .append("\n");
        str.append("Rate = ")
           .append(getRate())
           .append("\n");
        str.append("Cpv = ")
           .append(getCpv())
           .append("\n");
        str.append("Cpp = ")
           .append(getCpp())
           .append("\n");
        str.append("TargetDate = ")
           .append(getTargetDate())
           .append("\n");
        return(str.toString());
    }
}
