package com.youku.atm.om;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.TorqueRuntimeException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.workingdogs.village.DataSetException;
import com.workingdogs.village.QueryDataSet;
import com.workingdogs.village.Record;

// Local classes
import com.youku.atm.om.map.*;




/**
 * 
 *
 */
public abstract class BaseSdkConfigPeer
    extends BasePeer
{

    /** the default database name for this class */
    public static final String DATABASE_NAME;

     /** the table name for this class */
    public static final String TABLE_NAME;

    /**
     * @return the map builder for this peer
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @deprecated Torque.getMapBuilder(SdkConfigMapBuilder.CLASS_NAME) instead
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return Torque.getMapBuilder(SdkConfigMapBuilder.CLASS_NAME);
    }

    /** the column name for the id field */
    public static final String ID;
    /** the column name for the device_id field */
    public static final String DEVICE_ID;
    /** the column name for the ad_type_id field */
    public static final String AD_TYPE_ID;
    /** the column name for the sdk_id field */
    public static final String SDK_ID;
    /** the column name for the status field */
    public static final String STATUS;
    /** the column name for the manual_percent field */
    public static final String MANUAL_PERCENT;
    /** the column name for the auto_percent field */
    public static final String AUTO_PERCENT;
    /** the column name for the cast_id field */
    public static final String CAST_ID;
    /** the column name for the idea_id field */
    public static final String IDEA_ID;

    static
    {
        DATABASE_NAME = "atm";
        TABLE_NAME = "sdk_config";

        ID = "sdk_config.id";
        DEVICE_ID = "sdk_config.device_id";
        AD_TYPE_ID = "sdk_config.ad_type_id";
        SDK_ID = "sdk_config.sdk_id";
        STATUS = "sdk_config.status";
        MANUAL_PERCENT = "sdk_config.manual_percent";
        AUTO_PERCENT = "sdk_config.auto_percent";
        CAST_ID = "sdk_config.cast_id";
        IDEA_ID = "sdk_config.idea_id";
        if (Torque.isInit())
        {
            try
            {
                Torque.getMapBuilder(SdkConfigMapBuilder.CLASS_NAME);
            }
            catch (TorqueException e)
            {
                log.error("Could not initialize Peer", e);
                throw new TorqueRuntimeException(e);
            }
        }
        else
        {
            Torque.registerMapBuilder(SdkConfigMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  9;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "com.youku.atm.om.SdkConfig";

    /** A class that can be returned by this peer. */
    protected static final Class CLASS_DEFAULT = initClass(CLASSNAME_DEFAULT);

    /**
     * Class object initialization method.
     *
     * @param className name of the class to initialize
     * @return the initialized class
     */
    private static Class initClass(String className)
    {
        Class c = null;
        try
        {
            c = Class.forName(className);
        }
        catch (Throwable t)
        {
            log.error("A FATAL ERROR has occurred which should not "
                + "have happened under any circumstance.  Please notify "
                + "the Torque developers <torque-dev@db.apache.org> "
                + "and give as many details as possible (including the error "
                + "stack trace).", t);

            // Error objects should always be propagated.
            if (t instanceof Error)
            {
                throw (Error) t.fillInStackTrace();
            }
        }
        return c;
    }

    /**
     * Get the list of objects for a ResultSet.  Please not that your
     * resultset MUST return columns in the right order.  You can use
     * getFieldNames() in BaseObject to get the correct sequence.
     *
     * @param results the ResultSet
     * @return the list of objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<SdkConfig> resultSet2Objects(java.sql.ResultSet results)
            throws TorqueException
    {
        try
        {
            QueryDataSet qds = null;
            List<Record> rows = null;
            try
            {
                qds = new QueryDataSet(results);
                rows = getSelectResults(qds);
            }
            finally
            {
                if (qds != null)
                {
                    qds.close();
                }
            }

            return populateObjects(rows);
        }
        catch (SQLException e)
        {
            throw new TorqueException(e);
        }
        catch (DataSetException e)
        {
            throw new TorqueException(e);
        }
    }



    /**
     * Method to do inserts.
     *
     * @param criteria object used to create the INSERT statement.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(Criteria criteria)
        throws TorqueException
    {
        return BaseSdkConfigPeer
            .doInsert(criteria, (Connection) null);
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object used to create the INSERT statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(Criteria criteria, Connection con)
        throws TorqueException
    {
        correctBooleans(criteria);

        setDbName(criteria);

        if (con == null)
        {
            return BasePeer.doInsert(criteria);
        }
        else
        {
            return BasePeer.doInsert(criteria, con);
        }
    }

    /**
     * Add all the columns needed to create a new object.
     *
     * @param criteria object containing the columns to add.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void addSelectColumns(Criteria criteria)
            throws TorqueException
    {
        criteria.addSelectColumn(ID);
        criteria.addSelectColumn(DEVICE_ID);
        criteria.addSelectColumn(AD_TYPE_ID);
        criteria.addSelectColumn(SDK_ID);
        criteria.addSelectColumn(STATUS);
        criteria.addSelectColumn(MANUAL_PERCENT);
        criteria.addSelectColumn(AUTO_PERCENT);
        criteria.addSelectColumn(CAST_ID);
        criteria.addSelectColumn(IDEA_ID);
    }

    /**
     * changes the boolean values in the criteria to the appropriate type,
     * whenever a booleanchar or booleanint column is involved.
     * This enables the user to create criteria using Boolean values
     * for booleanchar or booleanint columns
     * @param criteria the criteria in which the boolean values should be corrected
     * @throws TorqueException if the database map for the criteria cannot be 
               obtained.
     */
    public static void correctBooleans(Criteria criteria) throws TorqueException
    {
        correctBooleans(criteria, getTableMap());
    }

    /**
     * Create a new object of type cls from a resultset row starting
     * from a specified offset.  This is done so that you can select
     * other rows than just those needed for this object.  You may
     * for example want to create two objects from the same row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static SdkConfig row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            SdkConfig obj = (SdkConfig) cls.newInstance();
            SdkConfigPeer.populateObject(row, offset, obj);
                obj.setModified(false);
            obj.setNew(false);

            return obj;
        }
        catch (InstantiationException e)
        {
            throw new TorqueException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new TorqueException(e);
        }
    }

    /**
     * Populates an object from a resultset row starting
     * from a specified offset.  This is done so that you can select
     * other rows than just those needed for this object.  You may
     * for example want to create two objects from the same row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void populateObject(Record row,
                                      int offset,
                                      SdkConfig obj)
        throws TorqueException
    {
        try
        {
            obj.setId(row.getValue(offset + 0).asInt());
            obj.setDeviceId(row.getValue(offset + 1).asInt());
            obj.setAdTypeId(row.getValue(offset + 2).asInt());
            obj.setSdkId(row.getValue(offset + 3).asInt());
            obj.setStatus(row.getValue(offset + 4).asInt());
            obj.setManualPercent(row.getValue(offset + 5).asInt());
            obj.setAutoPercent(row.getValue(offset + 6).asInt());
            obj.setCastId(row.getValue(offset + 7).asInt());
            obj.setIdeaId(row.getValue(offset + 8).asInt());
        }
        catch (DataSetException e)
        {
            throw new TorqueException(e);
        }
    }

    /**
     * Method to do selects.
     *
     * @param criteria object used to create the SELECT statement.
     * @return List of selected Objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<SdkConfig> doSelect(Criteria criteria) throws TorqueException
    {
        return populateObjects(doSelectVillageRecords(criteria));
    }

    /**
     * Method to do selects within a transaction.
     *
     * @param criteria object used to create the SELECT statement.
     * @param con the connection to use
     * @return List of selected Objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<SdkConfig> doSelect(Criteria criteria, Connection con)
        throws TorqueException
    {
        return populateObjects(doSelectVillageRecords(criteria, con));
    }

    /**
     * Grabs the raw Village records to be formed into objects.
     * This method handles connections internally.  The Record objects
     * returned by this method should be considered readonly.  Do not
     * alter the data and call save(), your results may vary, but are
     * certainly likely to result in hard to track MT bugs.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Record> doSelectVillageRecords(Criteria criteria)
        throws TorqueException
    {
        return BaseSdkConfigPeer
            .doSelectVillageRecords(criteria, (Connection) null);
    }

    /**
     * Grabs the raw Village records to be formed into objects.
     * This method should be used for transactions
     *
     * @param criteria object used to create the SELECT statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Record> doSelectVillageRecords(Criteria criteria, Connection con)
        throws TorqueException
    {
        if (criteria.getSelectColumns().size() == 0)
        {
            addSelectColumns(criteria);
        }
        correctBooleans(criteria);

        setDbName(criteria);

        // BasePeer returns a List of Value (Village) arrays.  The array
        // order follows the order columns were placed in the Select clause.
        if (con == null)
        {
            return BasePeer.doSelect(criteria);
        }
        else
        {
            return BasePeer.doSelect(criteria, con);
        }
    }

    /**
     * The returned List will contain objects of the default type or
     * objects that inherit from the default.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<SdkConfig> populateObjects(List<Record> records)
        throws TorqueException
    {
        List<SdkConfig> results = new ArrayList<SdkConfig>(records.size());

        // populate the object(s)
        for (int i = 0; i < records.size(); i++)
        {
            Record row =  records.get(i);
            results.add(SdkConfigPeer.row2Object(row, 1,
                SdkConfigPeer.getOMClass()));
        }
        return results;
    }
 

    /**
     * The class that the Peer will make instances of.
     * If the BO is abstract then you must implement this method
     * in the BO.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static Class getOMClass()
        throws TorqueException
    {
        return CLASS_DEFAULT;
    }

    /**
     * Method to do updates.
     *
     * @param criteria object containing data that is used to create the UPDATE
     *        statement.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Criteria criteria) throws TorqueException
    {
         BaseSdkConfigPeer
            .doUpdate(criteria, (Connection) null);
    }

    /**
     * Method to do updates.  This method is to be used during a transaction,
     * otherwise use the doUpdate(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object containing data that is used to create the UPDATE
     *        statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Criteria criteria, Connection con)
        throws TorqueException
    {
        Criteria selectCriteria = new Criteria(DATABASE_NAME, 2);
        correctBooleans(criteria);


         selectCriteria.put(ID, criteria.remove(ID));









        setDbName(criteria);

        if (con == null)
        {
            BasePeer.doUpdate(selectCriteria, criteria);
        }
        else
        {
            BasePeer.doUpdate(selectCriteria, criteria, con);
        }
    }

    /**
     * Method to do deletes.
     *
     * @param criteria object containing data that is used DELETE from database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static void doDelete(Criteria criteria) throws TorqueException
     {
         SdkConfigPeer
            .doDelete(criteria, (Connection) null);
     }

    /**
     * Method to do deletes.  This method is to be used during a transaction,
     * otherwise use the doDelete(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object containing data that is used DELETE from database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static void doDelete(Criteria criteria, Connection con)
        throws TorqueException
     {
        correctBooleans(criteria);

        setDbName(criteria);

        if (con == null)
        {
            BasePeer.doDelete(criteria, TABLE_NAME);
        }
        else
        {
            BasePeer.doDelete(criteria, TABLE_NAME, con);
        }
     }

    /**
     * Method to do selects
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<SdkConfig> doSelect(SdkConfig obj) throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(SdkConfig obj) throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildCriteria(obj)));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * @param obj the data object to update in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(SdkConfig obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(SdkConfig obj) throws TorqueException
    {
        doDelete(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(SdkConfig) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(SdkConfig obj, Connection con)
        throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildCriteria(obj), con));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(SdkConfig) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(SdkConfig obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(SdkConfig) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(SdkConfig obj, Connection con)
        throws TorqueException
    {
        doDelete(buildSelectCriteria(obj), con);
    }

    /**
     * Method to do deletes.
     *
     * @param pk ObjectKey that is used DELETE from database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ObjectKey pk) throws TorqueException
    {
        BaseSdkConfigPeer
           .doDelete(pk, (Connection) null);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(ObjectKey) method.  It will take
     * care of the connection details internally.
     *
     * @param pk the primary key for the object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ObjectKey pk, Connection con)
        throws TorqueException
    {
        doDelete(buildCriteria(pk), con);
    }

    /** Build a Criteria object from an ObjectKey */
    public static Criteria buildCriteria( ObjectKey pk )
    {
        Criteria criteria = new Criteria();
            criteria.add(ID, pk);
        return criteria;
     }

    /** Build a Criteria object from the data object for this peer */
    public static Criteria buildCriteria( SdkConfig obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        criteria.add(ID, obj.getId());
        criteria.add(DEVICE_ID, obj.getDeviceId());
        criteria.add(AD_TYPE_ID, obj.getAdTypeId());
        criteria.add(SDK_ID, obj.getSdkId());
        criteria.add(STATUS, obj.getStatus());
        criteria.add(MANUAL_PERCENT, obj.getManualPercent());
        criteria.add(AUTO_PERCENT, obj.getAutoPercent());
        criteria.add(CAST_ID, obj.getCastId());
        criteria.add(IDEA_ID, obj.getIdeaId());
        return criteria;
    }

    /** Build a Criteria object from the data object for this peer, skipping all binary columns */
    public static Criteria buildSelectCriteria( SdkConfig obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.add(ID, obj.getId());
        }
            criteria.add(DEVICE_ID, obj.getDeviceId());
            criteria.add(AD_TYPE_ID, obj.getAdTypeId());
            criteria.add(SDK_ID, obj.getSdkId());
            criteria.add(STATUS, obj.getStatus());
            criteria.add(MANUAL_PERCENT, obj.getManualPercent());
            criteria.add(AUTO_PERCENT, obj.getAutoPercent());
            criteria.add(CAST_ID, obj.getCastId());
            criteria.add(IDEA_ID, obj.getIdeaId());
        return criteria;
    }
 

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static SdkConfig retrieveByPK(int pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk));
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static SdkConfig retrieveByPK(int pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk), con);
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static SdkConfig retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        SdkConfig retVal = null;
        try
        {
            db = Torque.getConnection(DATABASE_NAME);
            retVal = retrieveByPK(pk, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return retVal;
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static SdkConfig retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List<SdkConfig> v = doSelect(criteria, con);
        if (v.size() == 0)
        {
            throw new NoRowsException("Failed to select a row.");
        }
        else if (v.size() > 1)
        {
            throw new TooManyRowsException("Failed to select only one row.");
        }
        else
        {
            return (SdkConfig)v.get(0);
        }
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<SdkConfig> retrieveByPKs(List<ObjectKey> pks)
        throws TorqueException
    {
        Connection db = null;
        List<SdkConfig> retVal = null;
        try
        {
           db = Torque.getConnection(DATABASE_NAME);
           retVal = retrieveByPKs(pks, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return retVal;
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @param dbcon the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<SdkConfig> retrieveByPKs( List<ObjectKey> pks, Connection dbcon )
        throws TorqueException
    {
        List<SdkConfig> objs = null;
        if (pks == null || pks.size() == 0)
        {
            objs = new LinkedList<SdkConfig>();
        }
        else
        {
            Criteria criteria = new Criteria();
            criteria.addIn( ID, pks );
        objs = doSelect(criteria, dbcon);
        }
        return objs;
    }

 








    /**
     * selects a collection of SdkConfig objects pre-filled with their
     * SdkDevice objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinSdkDevice(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinSdkDevice(criteria, null);
    }

    /**
     * selects a collection of SdkConfig objects pre-filled with their
     * SdkDevice objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinSdkDevice(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        SdkConfigPeer.addSelectColumns(criteria);
        int offset = numColumns + 1;
        SdkDevicePeer.addSelectColumns(criteria);

        criteria.addJoin(SdkConfigPeer.DEVICE_ID,
            SdkDevicePeer.ID);

        correctBooleans(criteria);

        List<Record> rows;
        if (conn == null)
        {
            rows = BasePeer.doSelect(criteria);
        }
        else
        {
            rows = BasePeer.doSelect(criteria,conn);
        }

        List<SdkConfig> results = new ArrayList<SdkConfig>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = SdkConfigPeer.getOMClass();
            SdkConfig obj1 = (SdkConfig) SdkConfigPeer
                .row2Object(row, 1, omClass);
             omClass = SdkDevicePeer.getOMClass();
            SdkDevice obj2 = (SdkDevice) SdkDevicePeer
                .row2Object(row, offset, omClass);

            boolean newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                SdkDevice temp_obj2 = (SdkDevice) temp_obj1.getSdkDevice();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initSdkConfigs();
                obj2.addSdkConfig(obj1);
            }
            results.add(obj1);
        }
        return results;
    }




    /**
     * selects a collection of SdkConfig objects pre-filled with their
     * AdType objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAdType(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinAdType(criteria, null);
    }

    /**
     * selects a collection of SdkConfig objects pre-filled with their
     * AdType objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAdType(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        SdkConfigPeer.addSelectColumns(criteria);
        int offset = numColumns + 1;
        AdTypePeer.addSelectColumns(criteria);

        criteria.addJoin(SdkConfigPeer.AD_TYPE_ID,
            AdTypePeer.ID);

        correctBooleans(criteria);

        List<Record> rows;
        if (conn == null)
        {
            rows = BasePeer.doSelect(criteria);
        }
        else
        {
            rows = BasePeer.doSelect(criteria,conn);
        }

        List<SdkConfig> results = new ArrayList<SdkConfig>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = SdkConfigPeer.getOMClass();
            SdkConfig obj1 = (SdkConfig) SdkConfigPeer
                .row2Object(row, 1, omClass);
             omClass = AdTypePeer.getOMClass();
            AdType obj2 = (AdType) AdTypePeer
                .row2Object(row, offset, omClass);

            boolean newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                AdType temp_obj2 = (AdType) temp_obj1.getAdType();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initSdkConfigs();
                obj2.addSdkConfig(obj1);
            }
            results.add(obj1);
        }
        return results;
    }




    /**
     * selects a collection of SdkConfig objects pre-filled with their
     * SdkName objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinSdkName(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinSdkName(criteria, null);
    }

    /**
     * selects a collection of SdkConfig objects pre-filled with their
     * SdkName objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinSdkName(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        SdkConfigPeer.addSelectColumns(criteria);
        int offset = numColumns + 1;
        SdkNamePeer.addSelectColumns(criteria);

        criteria.addJoin(SdkConfigPeer.SDK_ID,
            SdkNamePeer.ID);

        correctBooleans(criteria);

        List<Record> rows;
        if (conn == null)
        {
            rows = BasePeer.doSelect(criteria);
        }
        else
        {
            rows = BasePeer.doSelect(criteria,conn);
        }

        List<SdkConfig> results = new ArrayList<SdkConfig>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = SdkConfigPeer.getOMClass();
            SdkConfig obj1 = (SdkConfig) SdkConfigPeer
                .row2Object(row, 1, omClass);
             omClass = SdkNamePeer.getOMClass();
            SdkName obj2 = (SdkName) SdkNamePeer
                .row2Object(row, offset, omClass);

            boolean newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                SdkName temp_obj2 = (SdkName) temp_obj1.getSdkName();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initSdkConfigs();
                obj2.addSdkConfig(obj1);
            }
            results.add(obj1);
        }
        return results;
    }







    /**
     * selects a collection of SdkConfig objects pre-filled with
     * all related objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAllExceptSdkDevice(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinAllExceptSdkDevice(criteria, null);
    }

    /**
     * selects a collection of SdkConfig objects pre-filled with
     * all related objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAllExceptSdkDevice(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        addSelectColumns(criteria);
        int offset2 = numColumns + 1;


        AdTypePeer.addSelectColumns(criteria);
        criteria.addJoin(SdkConfigPeer.AD_TYPE_ID, AdTypePeer.ID);
        int offset3 = offset2 + AdTypePeer.numColumns;

        SdkNamePeer.addSelectColumns(criteria);
        criteria.addJoin(SdkConfigPeer.SDK_ID, SdkNamePeer.ID);

        correctBooleans(criteria);

        List<Record> rows;
        if (conn == null)
        {
            rows = BasePeer.doSelect(criteria);
        }
        else
        {
            rows = BasePeer.doSelect(criteria,conn);
        }

        List<SdkConfig> results = new ArrayList<SdkConfig>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = SdkConfigPeer.getOMClass();
            SdkConfig obj1 = (SdkConfig) SdkConfigPeer
                .row2Object(row, 1, omClass);





             omClass = AdTypePeer.getOMClass();
            AdType obj2 = (AdType) AdTypePeer
                .row2Object( row, offset2, omClass);

 boolean  newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                AdType temp_obj2 = (AdType) temp_obj1.getAdType();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initSdkConfigs();
                obj2.addSdkConfig(obj1);
            }




             omClass = SdkNamePeer.getOMClass();
            SdkName obj3 = (SdkName) SdkNamePeer
                .row2Object( row, offset3, omClass);

 newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                SdkName temp_obj3 = (SdkName) temp_obj1.getSdkName();
                if (temp_obj3.getPrimaryKey().equals(obj3.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj3.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj3.initSdkConfigs();
                obj3.addSdkConfig(obj1);
            }
            results.add(obj1);
        }
        return results;
    }




    /**
     * selects a collection of SdkConfig objects pre-filled with
     * all related objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAllExceptAdType(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinAllExceptAdType(criteria, null);
    }

    /**
     * selects a collection of SdkConfig objects pre-filled with
     * all related objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAllExceptAdType(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        addSelectColumns(criteria);
        int offset2 = numColumns + 1;

        SdkDevicePeer.addSelectColumns(criteria);
        criteria.addJoin(SdkConfigPeer.DEVICE_ID, SdkDevicePeer.ID);
        int offset3 = offset2 + SdkDevicePeer.numColumns;


        SdkNamePeer.addSelectColumns(criteria);
        criteria.addJoin(SdkConfigPeer.SDK_ID, SdkNamePeer.ID);

        correctBooleans(criteria);

        List<Record> rows;
        if (conn == null)
        {
            rows = BasePeer.doSelect(criteria);
        }
        else
        {
            rows = BasePeer.doSelect(criteria,conn);
        }

        List<SdkConfig> results = new ArrayList<SdkConfig>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = SdkConfigPeer.getOMClass();
            SdkConfig obj1 = (SdkConfig) SdkConfigPeer
                .row2Object(row, 1, omClass);




             omClass = SdkDevicePeer.getOMClass();
            SdkDevice obj2 = (SdkDevice) SdkDevicePeer
                .row2Object( row, offset2, omClass);

 boolean  newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                SdkDevice temp_obj2 = (SdkDevice) temp_obj1.getSdkDevice();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initSdkConfigs();
                obj2.addSdkConfig(obj1);
            }





             omClass = SdkNamePeer.getOMClass();
            SdkName obj3 = (SdkName) SdkNamePeer
                .row2Object( row, offset3, omClass);

 newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                SdkName temp_obj3 = (SdkName) temp_obj1.getSdkName();
                if (temp_obj3.getPrimaryKey().equals(obj3.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj3.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj3.initSdkConfigs();
                obj3.addSdkConfig(obj1);
            }
            results.add(obj1);
        }
        return results;
    }




    /**
     * selects a collection of SdkConfig objects pre-filled with
     * all related objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAllExceptSdkName(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinAllExceptSdkName(criteria, null);
    }

    /**
     * selects a collection of SdkConfig objects pre-filled with
     * all related objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in SdkConfigPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<SdkConfig> doSelectJoinAllExceptSdkName(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        addSelectColumns(criteria);
        int offset2 = numColumns + 1;

        SdkDevicePeer.addSelectColumns(criteria);
        criteria.addJoin(SdkConfigPeer.DEVICE_ID, SdkDevicePeer.ID);
        int offset3 = offset2 + SdkDevicePeer.numColumns;

        AdTypePeer.addSelectColumns(criteria);
        criteria.addJoin(SdkConfigPeer.AD_TYPE_ID, AdTypePeer.ID);


        correctBooleans(criteria);

        List<Record> rows;
        if (conn == null)
        {
            rows = BasePeer.doSelect(criteria);
        }
        else
        {
            rows = BasePeer.doSelect(criteria,conn);
        }

        List<SdkConfig> results = new ArrayList<SdkConfig>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = SdkConfigPeer.getOMClass();
            SdkConfig obj1 = (SdkConfig) SdkConfigPeer
                .row2Object(row, 1, omClass);




             omClass = SdkDevicePeer.getOMClass();
            SdkDevice obj2 = (SdkDevice) SdkDevicePeer
                .row2Object( row, offset2, omClass);

 boolean  newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                SdkDevice temp_obj2 = (SdkDevice) temp_obj1.getSdkDevice();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initSdkConfigs();
                obj2.addSdkConfig(obj1);
            }




             omClass = AdTypePeer.getOMClass();
            AdType obj3 = (AdType) AdTypePeer
                .row2Object( row, offset3, omClass);

 newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                SdkConfig temp_obj1 =  results.get(j);
                AdType temp_obj3 = (AdType) temp_obj1.getAdType();
                if (temp_obj3.getPrimaryKey().equals(obj3.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj3.addSdkConfig(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj3.initSdkConfigs();
                obj3.addSdkConfig(obj1);
            }

            results.add(obj1);
        }
        return results;
    }


    /**
     * Returns the TableMap related to this peer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static TableMap getTableMap()
        throws TorqueException
    {
        return Torque.getDatabaseMap(DATABASE_NAME).getTable(TABLE_NAME);
    }
 
    private static void setDbName(Criteria crit)
    {
        // Set the correct dbName if it has not been overridden
        // crit.getDbName will return the same object if not set to
        // another value so == check is okay and faster
        if (crit.getDbName() == Torque.getDefaultDB())
        {
            crit.setDbName(DATABASE_NAME);
        }
    }
    

    // The following methods wrap some methods in BasePeer
    // to have more support for Java5 generic types in the Peer
    
    /**
     * Utility method which executes a given sql statement.  This
     * method should be used for select statements only.  Use
     * executeStatement for update, insert, and delete operations.
     *
     * @param queryString A String with the sql statement to execute.
     * @return List of Record objects.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#executeQuery(String)
     */
    public static List<Record> executeQuery(String queryString) throws TorqueException
    {
        return BasePeer.executeQuery(queryString);
    }

    /**
     * Utility method which executes a given sql statement.  This
     * method should be used for select statements only.  Use
     * executeStatement for update, insert, and delete operations.
     *
     * @param queryString A String with the sql statement to execute.
     * @param dbName The database to connect to.
     * @return List of Record objects.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#executeQuery(String,String)
     */
    public static List<Record> executeQuery(String queryString, String dbName)
        throws TorqueException
    {
        return BasePeer.executeQuery(queryString,dbName);
    }
    

    /**
     * Method for performing a SELECT.  Returns all results.
     *
     * @param queryString A String with the sql statement to execute.
     * @param dbName The database to connect to.
     * @param singleRecord Whether or not we want to select only a
     * single record.
     * @return List of Record objects.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#executeQuery(String,String,boolean)
     */
    public static List<Record> executeQuery(
        String queryString,
        String dbName,
        boolean singleRecord)
        throws TorqueException
    {
        return BasePeer.executeQuery(queryString,dbName,singleRecord);
    }

    /**
     * Method for performing a SELECT.  Returns all results.
     *
     * @param queryString A String with the sql statement to execute.
     * @param singleRecord Whether or not we want to select only a
     * single record.
     * @param con A Connection.
     * @return List of Record objects.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#executeQuery(String,boolean,Connection)
     */
    public static List<Record> executeQuery(
        String queryString,
        boolean singleRecord,
        Connection con)
        throws TorqueException
    {
        return BasePeer.executeQuery(queryString,singleRecord,con);
    }

    /**
     * Method for performing a SELECT.
     *
     * @param queryString A String with the sql statement to execute.
     * @param start The first row to return.
     * @param numberOfResults The number of rows to return.
     * @param dbName The database to connect to.
     * @param singleRecord Whether or not we want to select only a
     * single record.
     * @return List of Record objects.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#executeQuery(String,int,int,String,boolean)
     */
    public static List<Record> executeQuery(
        String queryString,
        int start,
        int numberOfResults,
        String dbName,
        boolean singleRecord)
        throws TorqueException
    {
        return BasePeer.executeQuery(queryString,start,numberOfResults,dbName,singleRecord);
    }

    /**
     * Method for performing a SELECT.  Returns all results.
     *
     * @param queryString A String with the sql statement to execute.
     * @param start The first row to return.
     * @param numberOfResults The number of rows to return.
     * @param singleRecord Whether or not we want to select only a
     * single record.
     * @param con A Connection.
     * @return List of Record objects.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#executeQuery(String,int,int,String,boolean,Connection)
     */
    public static List<Record> executeQuery(
        String queryString,
        int start,
        int numberOfResults,
        boolean singleRecord,
        Connection con)
        throws TorqueException
    {
        return BasePeer.executeQuery(queryString,start,numberOfResults,singleRecord,con);
    }

    /**
     * Returns all records in a QueryDataSet as a List of Record
     * objects.  Used for functionality like util.LargeSelect.
     *
     * @see #getSelectResults(QueryDataSet, int, int, boolean)
     * @param qds the QueryDataSet
     * @return a List of Record objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#getSelectResults(QueryDataSet)
     */
    public static List<Record> getSelectResults(QueryDataSet qds)
        throws TorqueException
    {
        return BasePeer.getSelectResults(qds);
    }
    
    /**
     * Returns all records in a QueryDataSet as a List of Record
     * objects.  Used for functionality like util.LargeSelect.
     *
     * @see #getSelectResults(QueryDataSet, int, int, boolean)
     * @param qds the QueryDataSet
     * @param singleRecord
     * @return a List of Record objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#getSelectResults(QueryDataSet,boolean)
     */
    public static List<Record> getSelectResults(QueryDataSet qds, boolean singleRecord)
        throws TorqueException
    {
        return BasePeer.getSelectResults(qds,singleRecord);
    }
    
    /**
     * Returns numberOfResults records in a QueryDataSet as a List
     * of Record objects.  Starting at record 0.  Used for
     * functionality like util.LargeSelect.
     *
     * @see #getSelectResults(QueryDataSet, int, int, boolean)
     * @param qds the QueryDataSet
     * @param numberOfResults
     * @param singleRecord
     * @return a List of Record objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#getSelectResults(QueryDataSet,int,boolean)
     */
    public static List<Record> getSelectResults(
        QueryDataSet qds,
        int numberOfResults,
        boolean singleRecord)
        throws TorqueException
    {
        return BasePeer.getSelectResults(qds,numberOfResults,singleRecord);
    }

    /**
     * Returns numberOfResults records in a QueryDataSet as a List
     * of Record objects.  Starting at record start.  Used for
     * functionality like util.LargeSelect.
     *
     * @param qds The <code>QueryDataSet</code> to extract results
     * from.
     * @param start The index from which to start retrieving
     * <code>Record</code> objects from the data set.
     * @param numberOfResults The number of results to return (or
     * <code> -1</code> for all results).
     * @param singleRecord Whether or not we want to select only a
     * single record.
     * @return A <code>List</code> of <code>Record</code> objects.
     * @exception TorqueException If any <code>Exception</code> occurs.
     * @see org.apache.torque.util.BasePeer#getSelectResults(QueryDataSet,int,int,boolean)
     */
    public static List getSelectResults(
        QueryDataSet qds,
        int start,
        int numberOfResults,
        boolean singleRecord)
        throws TorqueException
    {
        return BasePeer.getSelectResults(qds,start,numberOfResults,singleRecord);
    }

    /**
     * Performs a SQL <code>select</code> using a PreparedStatement.
     * Note: this method does not handle null criteria values.
     *
     * @param criteria
     * @param con
     * @return a List of Record objects.
     * @throws TorqueException Error performing database query.
     * @see org.apache.torque.util.BasePeer#doPSSelect(Criteria,Connection)
     */
    public static List<Record> doPSSelect(Criteria criteria, Connection con)
        throws TorqueException
    {
        return BasePeer.doPSSelect(criteria,con);
    }

    /**
     * Do a Prepared Statement select according to the given criteria
     *
     * @param criteria
     * @return a List of Record objects.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @see org.apache.torque.util.BasePeer#doPSSelect(Criteria)
     */
    public static List<Record> doPSSelect(Criteria criteria) throws TorqueException
    {
        return BasePeer.doPSSelect(criteria);
    }
}
