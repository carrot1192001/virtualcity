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
import com.youku.atm.om.bean.SdkNameBean;

import com.youku.atm.om.bean.SdkConfigBean;
import com.youku.atm.om.bean.SdkConfigLogBean;
import com.youku.atm.om.bean.SdkLogBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to SdkName
 */
public abstract class BaseSdkName extends BaseObject
{
    /** The Peer class */
    private static final SdkNamePeer peer =
        new SdkNamePeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the status field */
    private int status;


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



        // update associated SdkConfig
        if (collSdkConfigs != null)
        {
            for (int i = 0; i < collSdkConfigs.size(); i++)
            {
                ((SdkConfig) collSdkConfigs.get(i))
                        .setSdkId(v);
            }
        }

        // update associated SdkConfigLog
        if (collSdkConfigLogs != null)
        {
            for (int i = 0; i < collSdkConfigLogs.size(); i++)
            {
                ((SdkConfigLog) collSdkConfigLogs.get(i))
                        .setSdkId(v);
            }
        }

        // update associated SdkLog
        if (collSdkLogs != null)
        {
            for (int i = 0; i < collSdkLogs.size(); i++)
            {
                ((SdkLog) collSdkLogs.get(i))
                        .setSdkId(v);
            }
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
     * Collection to store aggregation of collSdkConfigs
     */
    protected List<SdkConfig> collSdkConfigs;

    /**
     * Temporary storage of collSdkConfigs to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initSdkConfigs()
    {
        if (collSdkConfigs == null)
        {
            collSdkConfigs = new ArrayList<SdkConfig>();
        }
    }


    /**
     * Method called to associate a SdkConfig object to this object
     * through the SdkConfig foreign key attribute
     *
     * @param l SdkConfig
     * @throws TorqueException
     */
    public void addSdkConfig(SdkConfig l) throws TorqueException
    {
        getSdkConfigs().add(l);
        l.setSdkName((SdkName) this);
    }

    /**
     * Method called to associate a SdkConfig object to this object
     * through the SdkConfig foreign key attribute using connection.
     *
     * @param l SdkConfig
     * @throws TorqueException
     */
    public void addSdkConfig(SdkConfig l, Connection con) throws TorqueException
    {
        getSdkConfigs(con).add(l);
        l.setSdkName((SdkName) this);
    }

    /**
     * The criteria used to select the current contents of collSdkConfigs
     */
    private Criteria lastSdkConfigsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSdkConfigs(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<SdkConfig> getSdkConfigs()
        throws TorqueException
    {
        if (collSdkConfigs == null)
        {
            collSdkConfigs = getSdkConfigs(new Criteria(10));
        }
        return collSdkConfigs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName has previously
     * been saved, it will retrieve related SdkConfigs from storage.
     * If this SdkName is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<SdkConfig> getSdkConfigs(Criteria criteria) throws TorqueException
    {
        if (collSdkConfigs == null)
        {
            if (isNew())
            {
               collSdkConfigs = new ArrayList<SdkConfig>();
            }
            else
            {
                criteria.add(SdkConfigPeer.SDK_ID, getId() );
                collSdkConfigs = SdkConfigPeer.doSelect(criteria);
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
                criteria.add(SdkConfigPeer.SDK_ID, getId());
                if (!lastSdkConfigsCriteria.equals(criteria))
                {
                    collSdkConfigs = SdkConfigPeer.doSelect(criteria);
                }
            }
        }
        lastSdkConfigsCriteria = criteria;

        return collSdkConfigs;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSdkConfigs(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<SdkConfig> getSdkConfigs(Connection con) throws TorqueException
    {
        if (collSdkConfigs == null)
        {
            collSdkConfigs = getSdkConfigs(new Criteria(10), con);
        }
        return collSdkConfigs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName has previously
     * been saved, it will retrieve related SdkConfigs from storage.
     * If this SdkName is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<SdkConfig> getSdkConfigs(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collSdkConfigs == null)
        {
            if (isNew())
            {
               collSdkConfigs = new ArrayList<SdkConfig>();
            }
            else
            {
                 criteria.add(SdkConfigPeer.SDK_ID, getId());
                 collSdkConfigs = SdkConfigPeer.doSelect(criteria, con);
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
                 criteria.add(SdkConfigPeer.SDK_ID, getId());
                 if (!lastSdkConfigsCriteria.equals(criteria))
                 {
                     collSdkConfigs = SdkConfigPeer.doSelect(criteria, con);
                 }
             }
         }
         lastSdkConfigsCriteria = criteria;

         return collSdkConfigs;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkConfigs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkConfig> getSdkConfigsJoinSdkDevice(Criteria criteria)
        throws TorqueException
    {
        if (collSdkConfigs == null)
        {
            if (isNew())
            {
               collSdkConfigs = new ArrayList<SdkConfig>();
            }
            else
            {
                criteria.add(SdkConfigPeer.SDK_ID, getId());
                collSdkConfigs = SdkConfigPeer.doSelectJoinSdkDevice(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkConfigPeer.SDK_ID, getId());
            if (!lastSdkConfigsCriteria.equals(criteria))
            {
                collSdkConfigs = SdkConfigPeer.doSelectJoinSdkDevice(criteria);
            }
        }
        lastSdkConfigsCriteria = criteria;

        return collSdkConfigs;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkConfigs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkConfig> getSdkConfigsJoinAdType(Criteria criteria)
        throws TorqueException
    {
        if (collSdkConfigs == null)
        {
            if (isNew())
            {
               collSdkConfigs = new ArrayList<SdkConfig>();
            }
            else
            {
                criteria.add(SdkConfigPeer.SDK_ID, getId());
                collSdkConfigs = SdkConfigPeer.doSelectJoinAdType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkConfigPeer.SDK_ID, getId());
            if (!lastSdkConfigsCriteria.equals(criteria))
            {
                collSdkConfigs = SdkConfigPeer.doSelectJoinAdType(criteria);
            }
        }
        lastSdkConfigsCriteria = criteria;

        return collSdkConfigs;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkConfigs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkConfig> getSdkConfigsJoinSdkName(Criteria criteria)
        throws TorqueException
    {
        if (collSdkConfigs == null)
        {
            if (isNew())
            {
               collSdkConfigs = new ArrayList<SdkConfig>();
            }
            else
            {
                criteria.add(SdkConfigPeer.SDK_ID, getId());
                collSdkConfigs = SdkConfigPeer.doSelectJoinSdkName(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkConfigPeer.SDK_ID, getId());
            if (!lastSdkConfigsCriteria.equals(criteria))
            {
                collSdkConfigs = SdkConfigPeer.doSelectJoinSdkName(criteria);
            }
        }
        lastSdkConfigsCriteria = criteria;

        return collSdkConfigs;
    }





    /**
     * Collection to store aggregation of collSdkConfigLogs
     */
    protected List<SdkConfigLog> collSdkConfigLogs;

    /**
     * Temporary storage of collSdkConfigLogs to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initSdkConfigLogs()
    {
        if (collSdkConfigLogs == null)
        {
            collSdkConfigLogs = new ArrayList<SdkConfigLog>();
        }
    }


    /**
     * Method called to associate a SdkConfigLog object to this object
     * through the SdkConfigLog foreign key attribute
     *
     * @param l SdkConfigLog
     * @throws TorqueException
     */
    public void addSdkConfigLog(SdkConfigLog l) throws TorqueException
    {
        getSdkConfigLogs().add(l);
        l.setSdkName((SdkName) this);
    }

    /**
     * Method called to associate a SdkConfigLog object to this object
     * through the SdkConfigLog foreign key attribute using connection.
     *
     * @param l SdkConfigLog
     * @throws TorqueException
     */
    public void addSdkConfigLog(SdkConfigLog l, Connection con) throws TorqueException
    {
        getSdkConfigLogs(con).add(l);
        l.setSdkName((SdkName) this);
    }

    /**
     * The criteria used to select the current contents of collSdkConfigLogs
     */
    private Criteria lastSdkConfigLogsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSdkConfigLogs(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<SdkConfigLog> getSdkConfigLogs()
        throws TorqueException
    {
        if (collSdkConfigLogs == null)
        {
            collSdkConfigLogs = getSdkConfigLogs(new Criteria(10));
        }
        return collSdkConfigLogs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName has previously
     * been saved, it will retrieve related SdkConfigLogs from storage.
     * If this SdkName is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<SdkConfigLog> getSdkConfigLogs(Criteria criteria) throws TorqueException
    {
        if (collSdkConfigLogs == null)
        {
            if (isNew())
            {
               collSdkConfigLogs = new ArrayList<SdkConfigLog>();
            }
            else
            {
                criteria.add(SdkConfigLogPeer.SDK_ID, getId() );
                collSdkConfigLogs = SdkConfigLogPeer.doSelect(criteria);
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
                criteria.add(SdkConfigLogPeer.SDK_ID, getId());
                if (!lastSdkConfigLogsCriteria.equals(criteria))
                {
                    collSdkConfigLogs = SdkConfigLogPeer.doSelect(criteria);
                }
            }
        }
        lastSdkConfigLogsCriteria = criteria;

        return collSdkConfigLogs;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSdkConfigLogs(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<SdkConfigLog> getSdkConfigLogs(Connection con) throws TorqueException
    {
        if (collSdkConfigLogs == null)
        {
            collSdkConfigLogs = getSdkConfigLogs(new Criteria(10), con);
        }
        return collSdkConfigLogs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName has previously
     * been saved, it will retrieve related SdkConfigLogs from storage.
     * If this SdkName is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<SdkConfigLog> getSdkConfigLogs(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collSdkConfigLogs == null)
        {
            if (isNew())
            {
               collSdkConfigLogs = new ArrayList<SdkConfigLog>();
            }
            else
            {
                 criteria.add(SdkConfigLogPeer.SDK_ID, getId());
                 collSdkConfigLogs = SdkConfigLogPeer.doSelect(criteria, con);
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
                 criteria.add(SdkConfigLogPeer.SDK_ID, getId());
                 if (!lastSdkConfigLogsCriteria.equals(criteria))
                 {
                     collSdkConfigLogs = SdkConfigLogPeer.doSelect(criteria, con);
                 }
             }
         }
         lastSdkConfigLogsCriteria = criteria;

         return collSdkConfigLogs;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkConfigLogs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkConfigLog> getSdkConfigLogsJoinSdkDevice(Criteria criteria)
        throws TorqueException
    {
        if (collSdkConfigLogs == null)
        {
            if (isNew())
            {
               collSdkConfigLogs = new ArrayList<SdkConfigLog>();
            }
            else
            {
                criteria.add(SdkConfigLogPeer.SDK_ID, getId());
                collSdkConfigLogs = SdkConfigLogPeer.doSelectJoinSdkDevice(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkConfigLogPeer.SDK_ID, getId());
            if (!lastSdkConfigLogsCriteria.equals(criteria))
            {
                collSdkConfigLogs = SdkConfigLogPeer.doSelectJoinSdkDevice(criteria);
            }
        }
        lastSdkConfigLogsCriteria = criteria;

        return collSdkConfigLogs;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkConfigLogs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkConfigLog> getSdkConfigLogsJoinAdType(Criteria criteria)
        throws TorqueException
    {
        if (collSdkConfigLogs == null)
        {
            if (isNew())
            {
               collSdkConfigLogs = new ArrayList<SdkConfigLog>();
            }
            else
            {
                criteria.add(SdkConfigLogPeer.SDK_ID, getId());
                collSdkConfigLogs = SdkConfigLogPeer.doSelectJoinAdType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkConfigLogPeer.SDK_ID, getId());
            if (!lastSdkConfigLogsCriteria.equals(criteria))
            {
                collSdkConfigLogs = SdkConfigLogPeer.doSelectJoinAdType(criteria);
            }
        }
        lastSdkConfigLogsCriteria = criteria;

        return collSdkConfigLogs;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkConfigLogs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkConfigLog> getSdkConfigLogsJoinSdkName(Criteria criteria)
        throws TorqueException
    {
        if (collSdkConfigLogs == null)
        {
            if (isNew())
            {
               collSdkConfigLogs = new ArrayList<SdkConfigLog>();
            }
            else
            {
                criteria.add(SdkConfigLogPeer.SDK_ID, getId());
                collSdkConfigLogs = SdkConfigLogPeer.doSelectJoinSdkName(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkConfigLogPeer.SDK_ID, getId());
            if (!lastSdkConfigLogsCriteria.equals(criteria))
            {
                collSdkConfigLogs = SdkConfigLogPeer.doSelectJoinSdkName(criteria);
            }
        }
        lastSdkConfigLogsCriteria = criteria;

        return collSdkConfigLogs;
    }





    /**
     * Collection to store aggregation of collSdkLogs
     */
    protected List<SdkLog> collSdkLogs;

    /**
     * Temporary storage of collSdkLogs to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initSdkLogs()
    {
        if (collSdkLogs == null)
        {
            collSdkLogs = new ArrayList<SdkLog>();
        }
    }


    /**
     * Method called to associate a SdkLog object to this object
     * through the SdkLog foreign key attribute
     *
     * @param l SdkLog
     * @throws TorqueException
     */
    public void addSdkLog(SdkLog l) throws TorqueException
    {
        getSdkLogs().add(l);
        l.setSdkName((SdkName) this);
    }

    /**
     * Method called to associate a SdkLog object to this object
     * through the SdkLog foreign key attribute using connection.
     *
     * @param l SdkLog
     * @throws TorqueException
     */
    public void addSdkLog(SdkLog l, Connection con) throws TorqueException
    {
        getSdkLogs(con).add(l);
        l.setSdkName((SdkName) this);
    }

    /**
     * The criteria used to select the current contents of collSdkLogs
     */
    private Criteria lastSdkLogsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSdkLogs(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<SdkLog> getSdkLogs()
        throws TorqueException
    {
        if (collSdkLogs == null)
        {
            collSdkLogs = getSdkLogs(new Criteria(10));
        }
        return collSdkLogs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName has previously
     * been saved, it will retrieve related SdkLogs from storage.
     * If this SdkName is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<SdkLog> getSdkLogs(Criteria criteria) throws TorqueException
    {
        if (collSdkLogs == null)
        {
            if (isNew())
            {
               collSdkLogs = new ArrayList<SdkLog>();
            }
            else
            {
                criteria.add(SdkLogPeer.SDK_ID, getId() );
                collSdkLogs = SdkLogPeer.doSelect(criteria);
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
                criteria.add(SdkLogPeer.SDK_ID, getId());
                if (!lastSdkLogsCriteria.equals(criteria))
                {
                    collSdkLogs = SdkLogPeer.doSelect(criteria);
                }
            }
        }
        lastSdkLogsCriteria = criteria;

        return collSdkLogs;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getSdkLogs(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<SdkLog> getSdkLogs(Connection con) throws TorqueException
    {
        if (collSdkLogs == null)
        {
            collSdkLogs = getSdkLogs(new Criteria(10), con);
        }
        return collSdkLogs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName has previously
     * been saved, it will retrieve related SdkLogs from storage.
     * If this SdkName is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<SdkLog> getSdkLogs(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collSdkLogs == null)
        {
            if (isNew())
            {
               collSdkLogs = new ArrayList<SdkLog>();
            }
            else
            {
                 criteria.add(SdkLogPeer.SDK_ID, getId());
                 collSdkLogs = SdkLogPeer.doSelect(criteria, con);
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
                 criteria.add(SdkLogPeer.SDK_ID, getId());
                 if (!lastSdkLogsCriteria.equals(criteria))
                 {
                     collSdkLogs = SdkLogPeer.doSelect(criteria, con);
                 }
             }
         }
         lastSdkLogsCriteria = criteria;

         return collSdkLogs;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkLogs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkLog> getSdkLogsJoinSdkDevice(Criteria criteria)
        throws TorqueException
    {
        if (collSdkLogs == null)
        {
            if (isNew())
            {
               collSdkLogs = new ArrayList<SdkLog>();
            }
            else
            {
                criteria.add(SdkLogPeer.SDK_ID, getId());
                collSdkLogs = SdkLogPeer.doSelectJoinSdkDevice(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkLogPeer.SDK_ID, getId());
            if (!lastSdkLogsCriteria.equals(criteria))
            {
                collSdkLogs = SdkLogPeer.doSelectJoinSdkDevice(criteria);
            }
        }
        lastSdkLogsCriteria = criteria;

        return collSdkLogs;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkLogs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkLog> getSdkLogsJoinAdType(Criteria criteria)
        throws TorqueException
    {
        if (collSdkLogs == null)
        {
            if (isNew())
            {
               collSdkLogs = new ArrayList<SdkLog>();
            }
            else
            {
                criteria.add(SdkLogPeer.SDK_ID, getId());
                collSdkLogs = SdkLogPeer.doSelectJoinAdType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkLogPeer.SDK_ID, getId());
            if (!lastSdkLogsCriteria.equals(criteria))
            {
                collSdkLogs = SdkLogPeer.doSelectJoinAdType(criteria);
            }
        }
        lastSdkLogsCriteria = criteria;

        return collSdkLogs;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this SdkName is new, it will return
     * an empty collection; or if this SdkName has previously
     * been saved, it will retrieve related SdkLogs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkName.
     */
    protected List<SdkLog> getSdkLogsJoinSdkName(Criteria criteria)
        throws TorqueException
    {
        if (collSdkLogs == null)
        {
            if (isNew())
            {
               collSdkLogs = new ArrayList<SdkLog>();
            }
            else
            {
                criteria.add(SdkLogPeer.SDK_ID, getId());
                collSdkLogs = SdkLogPeer.doSelectJoinSdkName(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(SdkLogPeer.SDK_ID, getId());
            if (!lastSdkLogsCriteria.equals(criteria))
            {
                collSdkLogs = SdkLogPeer.doSelectJoinSdkName(criteria);
            }
        }
        lastSdkLogsCriteria = criteria;

        return collSdkLogs;
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
            fieldNames.add("Name");
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
        if (name.equals("Name"))
        {
            return getName();
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
        if (name.equals(SdkNamePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(SdkNamePeer.NAME))
        {
            return getName();
        }
        if (name.equals(SdkNamePeer.STATUS))
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
      if (SdkNamePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (SdkNamePeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (SdkNamePeer.STATUS.equals(name))
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
            return getName();
        }
        if (pos == 2)
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
            return setByName("Name", value);
        }
    if (position == 2)
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
        save(SdkNamePeer.DATABASE_NAME);
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
                    SdkNamePeer.doInsert((SdkName) this, con);
                    setNew(false);
                }
                else
                {
                    SdkNamePeer.doUpdate((SdkName) this, con);
                }
            }


            if (collSdkConfigs != null)
            {
                for (int i = 0; i < collSdkConfigs.size(); i++)
                {
                    ((SdkConfig) collSdkConfigs.get(i)).save(con);
                }
            }

            if (collSdkConfigLogs != null)
            {
                for (int i = 0; i < collSdkConfigLogs.size(); i++)
                {
                    ((SdkConfigLog) collSdkConfigLogs.get(i)).save(con);
                }
            }

            if (collSdkLogs != null)
            {
                for (int i = 0; i < collSdkLogs.size(); i++)
                {
                    ((SdkLog) collSdkLogs.get(i)).save(con);
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
    public SdkName copy() throws TorqueException
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
    public SdkName copy(Connection con) throws TorqueException
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
    public SdkName copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new SdkName(), deepcopy);
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
    public SdkName copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new SdkName(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected SdkName copyInto(SdkName copyObj) throws TorqueException
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
    protected SdkName copyInto(SdkName copyObj, Connection con) throws TorqueException
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
    protected SdkName copyInto(SdkName copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<SdkConfig> vSdkConfigs = getSdkConfigs();
        if (vSdkConfigs != null)
        {
            for (int i = 0; i < vSdkConfigs.size(); i++)
            {
                SdkConfig obj =  vSdkConfigs.get(i);
                copyObj.addSdkConfig(obj.copy());
            }
        }
        else
        {
            copyObj.collSdkConfigs = null;
        }


        List<SdkConfigLog> vSdkConfigLogs = getSdkConfigLogs();
        if (vSdkConfigLogs != null)
        {
            for (int i = 0; i < vSdkConfigLogs.size(); i++)
            {
                SdkConfigLog obj =  vSdkConfigLogs.get(i);
                copyObj.addSdkConfigLog(obj.copy());
            }
        }
        else
        {
            copyObj.collSdkConfigLogs = null;
        }


        List<SdkLog> vSdkLogs = getSdkLogs();
        if (vSdkLogs != null)
        {
            for (int i = 0; i < vSdkLogs.size(); i++)
            {
                SdkLog obj =  vSdkLogs.get(i);
                copyObj.addSdkLog(obj.copy());
            }
        }
        else
        {
            copyObj.collSdkLogs = null;
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
    protected SdkName copyInto(SdkName copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setStatus(status);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<SdkConfig> vSdkConfigs = getSdkConfigs(con);
        if (vSdkConfigs != null)
        {
            for (int i = 0; i < vSdkConfigs.size(); i++)
            {
                SdkConfig obj =  vSdkConfigs.get(i);
                copyObj.addSdkConfig(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collSdkConfigs = null;
        }


        List<SdkConfigLog> vSdkConfigLogs = getSdkConfigLogs(con);
        if (vSdkConfigLogs != null)
        {
            for (int i = 0; i < vSdkConfigLogs.size(); i++)
            {
                SdkConfigLog obj =  vSdkConfigLogs.get(i);
                copyObj.addSdkConfigLog(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collSdkConfigLogs = null;
        }


        List<SdkLog> vSdkLogs = getSdkLogs(con);
        if (vSdkLogs != null)
        {
            for (int i = 0; i < vSdkLogs.size(); i++)
            {
                SdkLog obj =  vSdkLogs.get(i);
                copyObj.addSdkLog(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collSdkLogs = null;
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
    public SdkNamePeer getPeer()
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
        return SdkNamePeer.getTableMap();
    }

  
    /**
     * Creates a SdkNameBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a SdkNameBean with the contents of this object
     */
    public SdkNameBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a SdkNameBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a SdkNameBean with the contents of this object
     */
    public SdkNameBean getBean(IdentityMap createdBeans)
    {
        SdkNameBean result = (SdkNameBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new SdkNameBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setName(getName());
        result.setStatus(getStatus());



        if (collSdkConfigs != null)
        {
            List<SdkConfigBean> relatedBeans = new ArrayList<SdkConfigBean>(collSdkConfigs.size());
            for (Iterator<SdkConfig> collSdkConfigsIt = collSdkConfigs.iterator(); collSdkConfigsIt.hasNext(); )
            {
                SdkConfig related = (SdkConfig) collSdkConfigsIt.next();
                SdkConfigBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setSdkConfigBeans(relatedBeans);
        }


        if (collSdkConfigLogs != null)
        {
            List<SdkConfigLogBean> relatedBeans = new ArrayList<SdkConfigLogBean>(collSdkConfigLogs.size());
            for (Iterator<SdkConfigLog> collSdkConfigLogsIt = collSdkConfigLogs.iterator(); collSdkConfigLogsIt.hasNext(); )
            {
                SdkConfigLog related = (SdkConfigLog) collSdkConfigLogsIt.next();
                SdkConfigLogBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setSdkConfigLogBeans(relatedBeans);
        }


        if (collSdkLogs != null)
        {
            List<SdkLogBean> relatedBeans = new ArrayList<SdkLogBean>(collSdkLogs.size());
            for (Iterator<SdkLog> collSdkLogsIt = collSdkLogs.iterator(); collSdkLogsIt.hasNext(); )
            {
                SdkLog related = (SdkLog) collSdkLogsIt.next();
                SdkLogBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setSdkLogBeans(relatedBeans);
        }

        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of SdkName with the contents
     * of a SdkNameBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the SdkNameBean which contents are used to create
     *        the resulting class
     * @return an instance of SdkName with the contents of bean
     */
    public static SdkName createSdkName(SdkNameBean bean)
        throws TorqueException
    {
        return createSdkName(bean, new IdentityMap());
    }

    /**
     * Creates an instance of SdkName with the contents
     * of a SdkNameBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the SdkNameBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of SdkName with the contents of bean
     */

    public static SdkName createSdkName(SdkNameBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        SdkName result = (SdkName) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new SdkName();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setName(bean.getName());
        result.setStatus(bean.getStatus());



        {
            List<SdkConfigBean> relatedBeans = bean.getSdkConfigBeans();
            if (relatedBeans != null)
            {
                for (Iterator<SdkConfigBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    SdkConfigBean relatedBean =  relatedBeansIt.next();
                    SdkConfig related = SdkConfig.createSdkConfig(relatedBean, createdObjects);
                    result.addSdkConfigFromBean(related);
                }
            }
        }


        {
            List<SdkConfigLogBean> relatedBeans = bean.getSdkConfigLogBeans();
            if (relatedBeans != null)
            {
                for (Iterator<SdkConfigLogBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    SdkConfigLogBean relatedBean =  relatedBeansIt.next();
                    SdkConfigLog related = SdkConfigLog.createSdkConfigLog(relatedBean, createdObjects);
                    result.addSdkConfigLogFromBean(related);
                }
            }
        }


        {
            List<SdkLogBean> relatedBeans = bean.getSdkLogBeans();
            if (relatedBeans != null)
            {
                for (Iterator<SdkLogBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    SdkLogBean relatedBean =  relatedBeansIt.next();
                    SdkLog related = SdkLog.createSdkLog(relatedBean, createdObjects);
                    result.addSdkLogFromBean(related);
                }
            }
        }

    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a SdkConfig object to this object.
     * through the SdkConfig foreign key attribute
     *
     * @param toAdd SdkConfig
     */
    protected void addSdkConfigFromBean(SdkConfig toAdd)
    {
        initSdkConfigs();
        collSdkConfigs.add(toAdd);
    }


    /**
     * Method called to associate a SdkConfigLog object to this object.
     * through the SdkConfigLog foreign key attribute
     *
     * @param toAdd SdkConfigLog
     */
    protected void addSdkConfigLogFromBean(SdkConfigLog toAdd)
    {
        initSdkConfigLogs();
        collSdkConfigLogs.add(toAdd);
    }


    /**
     * Method called to associate a SdkLog object to this object.
     * through the SdkLog foreign key attribute
     *
     * @param toAdd SdkLog
     */
    protected void addSdkLogFromBean(SdkLog toAdd)
    {
        initSdkLogs();
        collSdkLogs.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("SdkName:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        return(str.toString());
    }
}
