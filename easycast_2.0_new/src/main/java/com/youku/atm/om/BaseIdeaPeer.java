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
public abstract class BaseIdeaPeer
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
     * @deprecated Torque.getMapBuilder(IdeaMapBuilder.CLASS_NAME) instead
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return Torque.getMapBuilder(IdeaMapBuilder.CLASS_NAME);
    }

    /** the column name for the id field */
    public static final String ID;
    /** the column name for the cast_id field */
    public static final String CAST_ID;
    /** the column name for the name field */
    public static final String NAME;
    /** the column name for the showtime field */
    public static final String SHOWTIME;
    /** the column name for the i_priority field */
    public static final String I_PRIORITY;
    /** the column name for the count field */
    public static final String COUNT;
    /** the column name for the numlimit field */
    public static final String NUMLIMIT;
    /** the column name for the dq field */
    public static final String DQ;
    /** the column name for the iesorg field */
    public static final String IESORG;
    /** the column name for the cuf field */
    public static final String CUF;
    /** the column name for the controlType field */
    public static final String CONTROLTYPE;
    /** the column name for the issdk field */
    public static final String ISSDK;
    /** the column name for the sdkid field */
    public static final String SDKID;
    /** the column name for the mst field */
    public static final String MST;
    /** the column name for the location_type field */
    public static final String LOCATION_TYPE;
    /** the column name for the close_method field */
    public static final String CLOSE_METHOD;
    /** the column name for the idea_show_location field */
    public static final String IDEA_SHOW_LOCATION;
    /** the column name for the control_type_mobile field */
    public static final String CONTROL_TYPE_MOBILE;
    /** the column name for the charge_time field */
    public static final String CHARGE_TIME;
    /** the column name for the update_time field */
    public static final String UPDATE_TIME;
    /** the column name for the play_type field */
    public static final String PLAY_TYPE;
    /** the column name for the status field */
    public static final String STATUS;
    /** the column name for the loc_type field */
    public static final String LOC_TYPE;
    /** the column name for the dp_cuf field */
    public static final String DP_CUF;
    /** the column name for the link_type field */
    public static final String LINK_TYPE;
    /** the column name for the link_id field */
    public static final String LINK_ID;
    /** the column name for the app_key field */
    public static final String APP_KEY;
    /** the column name for the ndisplay_type field */
    public static final String NDISPLAY_TYPE;
    /** the column name for the begin_date field */
    public static final String BEGIN_DATE;
    /** the column name for the end_date field */
    public static final String END_DATE;

    static
    {
        DATABASE_NAME = "atm";
        TABLE_NAME = "idea";

        ID = "idea.id";
        CAST_ID = "idea.cast_id";
        NAME = "idea.name";
        SHOWTIME = "idea.showtime";
        I_PRIORITY = "idea.i_priority";
        COUNT = "idea.count";
        NUMLIMIT = "idea.numlimit";
        DQ = "idea.dq";
        IESORG = "idea.iesorg";
        CUF = "idea.cuf";
        CONTROLTYPE = "idea.controlType";
        ISSDK = "idea.issdk";
        SDKID = "idea.sdkid";
        MST = "idea.mst";
        LOCATION_TYPE = "idea.location_type";
        CLOSE_METHOD = "idea.close_method";
        IDEA_SHOW_LOCATION = "idea.idea_show_location";
        CONTROL_TYPE_MOBILE = "idea.control_type_mobile";
        CHARGE_TIME = "idea.charge_time";
        UPDATE_TIME = "idea.update_time";
        PLAY_TYPE = "idea.play_type";
        STATUS = "idea.status";
        LOC_TYPE = "idea.loc_type";
        DP_CUF = "idea.dp_cuf";
        LINK_TYPE = "idea.link_type";
        LINK_ID = "idea.link_id";
        APP_KEY = "idea.app_key";
        NDISPLAY_TYPE = "idea.ndisplay_type";
        BEGIN_DATE = "idea.begin_date";
        END_DATE = "idea.end_date";
        if (Torque.isInit())
        {
            try
            {
                Torque.getMapBuilder(IdeaMapBuilder.CLASS_NAME);
            }
            catch (TorqueException e)
            {
                log.error("Could not initialize Peer", e);
                throw new TorqueRuntimeException(e);
            }
        }
        else
        {
            Torque.registerMapBuilder(IdeaMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  30;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "com.youku.atm.om.Idea";

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
    public static List<Idea> resultSet2Objects(java.sql.ResultSet results)
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
        return BaseIdeaPeer
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
        criteria.addSelectColumn(CAST_ID);
        criteria.addSelectColumn(NAME);
        criteria.addSelectColumn(SHOWTIME);
        criteria.addSelectColumn(I_PRIORITY);
        criteria.addSelectColumn(COUNT);
        criteria.addSelectColumn(NUMLIMIT);
        criteria.addSelectColumn(DQ);
        criteria.addSelectColumn(IESORG);
        criteria.addSelectColumn(CUF);
        criteria.addSelectColumn(CONTROLTYPE);
        criteria.addSelectColumn(ISSDK);
        criteria.addSelectColumn(SDKID);
        criteria.addSelectColumn(MST);
        criteria.addSelectColumn(LOCATION_TYPE);
        criteria.addSelectColumn(CLOSE_METHOD);
        criteria.addSelectColumn(IDEA_SHOW_LOCATION);
        criteria.addSelectColumn(CONTROL_TYPE_MOBILE);
        criteria.addSelectColumn(CHARGE_TIME);
        criteria.addSelectColumn(UPDATE_TIME);
        criteria.addSelectColumn(PLAY_TYPE);
        criteria.addSelectColumn(STATUS);
        criteria.addSelectColumn(LOC_TYPE);
        criteria.addSelectColumn(DP_CUF);
        criteria.addSelectColumn(LINK_TYPE);
        criteria.addSelectColumn(LINK_ID);
        criteria.addSelectColumn(APP_KEY);
        criteria.addSelectColumn(NDISPLAY_TYPE);
        criteria.addSelectColumn(BEGIN_DATE);
        criteria.addSelectColumn(END_DATE);
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
    public static Idea row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            Idea obj = (Idea) cls.newInstance();
            IdeaPeer.populateObject(row, offset, obj);
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
                                      Idea obj)
        throws TorqueException
    {
        try
        {
            obj.setId(row.getValue(offset + 0).asInt());
            obj.setCastId(row.getValue(offset + 1).asInt());
            obj.setName(row.getValue(offset + 2).asString());
            obj.setShowtime(row.getValue(offset + 3).asInt());
            obj.setIPriority(row.getValue(offset + 4).asInt());
            obj.setCount(row.getValue(offset + 5).asInt());
            obj.setNumlimit(row.getValue(offset + 6).asInt());
            obj.setDq(row.getValue(offset + 7).asString());
            obj.setIesorg(row.getValue(offset + 8).asString());
            obj.setCuf(row.getValue(offset + 9).asInt());
            obj.setControltype(row.getValue(offset + 10).asInt());
            obj.setIssdk(row.getValue(offset + 11).asInt());
            obj.setSdkid(row.getValue(offset + 12).asInt());
            obj.setMst(row.getValue(offset + 13).asInt());
            obj.setLocationType(row.getValue(offset + 14).asString());
            obj.setCloseMethod(row.getValue(offset + 15).asInt());
            obj.setIdeaShowLocation(row.getValue(offset + 16).asInt());
            obj.setControlTypeMobile(row.getValue(offset + 17).asInt());
            obj.setChargeTime(row.getValue(offset + 18).asInt());
            obj.setUpdateTime(row.getValue(offset + 19).asUtilDate());
            obj.setPlayType(row.getValue(offset + 20).asInt());
            obj.setStatus(row.getValue(offset + 21).asInt());
            obj.setLocType(row.getValue(offset + 22).asString());
            obj.setDpCuf(row.getValue(offset + 23).asInt());
            obj.setLinkType(row.getValue(offset + 24).asString());
            obj.setLinkId(row.getValue(offset + 25).asString());
            obj.setAppKey(row.getValue(offset + 26).asString());
            obj.setNdisplayType(row.getValue(offset + 27).asInt());
            obj.setBeginDate(row.getValue(offset + 28).asUtilDate());
            obj.setEndDate(row.getValue(offset + 29).asUtilDate());
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
    public static List<Idea> doSelect(Criteria criteria) throws TorqueException
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
    public static List<Idea> doSelect(Criteria criteria, Connection con)
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
        return BaseIdeaPeer
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
    public static List<Idea> populateObjects(List<Record> records)
        throws TorqueException
    {
        List<Idea> results = new ArrayList<Idea>(records.size());

        // populate the object(s)
        for (int i = 0; i < records.size(); i++)
        {
            Record row =  records.get(i);
            results.add(IdeaPeer.row2Object(row, 1,
                IdeaPeer.getOMClass()));
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
         BaseIdeaPeer
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
         IdeaPeer
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
    public static List<Idea> doSelect(Idea obj) throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(Idea obj) throws TorqueException
    {
        doInsert(buildCriteria(obj));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * @param obj the data object to update in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Idea obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(Idea obj) throws TorqueException
    {
        doDelete(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Idea) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(Idea obj, Connection con)
        throws TorqueException
    {
        doInsert(buildCriteria(obj), con);
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(Idea) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Idea obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(Idea) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(Idea obj, Connection con)
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
        BaseIdeaPeer
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
    public static Criteria buildCriteria( Idea obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        criteria.add(ID, obj.getId());
        criteria.add(CAST_ID, obj.getCastId());
        criteria.add(NAME, obj.getName());
        criteria.add(SHOWTIME, obj.getShowtime());
        criteria.add(I_PRIORITY, obj.getIPriority());
        criteria.add(COUNT, obj.getCount());
        criteria.add(NUMLIMIT, obj.getNumlimit());
        criteria.add(DQ, obj.getDq());
        criteria.add(IESORG, obj.getIesorg());
        criteria.add(CUF, obj.getCuf());
        criteria.add(CONTROLTYPE, obj.getControltype());
        criteria.add(ISSDK, obj.getIssdk());
        criteria.add(SDKID, obj.getSdkid());
        criteria.add(MST, obj.getMst());
        criteria.add(LOCATION_TYPE, obj.getLocationType());
        criteria.add(CLOSE_METHOD, obj.getCloseMethod());
        criteria.add(IDEA_SHOW_LOCATION, obj.getIdeaShowLocation());
        criteria.add(CONTROL_TYPE_MOBILE, obj.getControlTypeMobile());
        criteria.add(CHARGE_TIME, obj.getChargeTime());
        criteria.add(UPDATE_TIME, obj.getUpdateTime());
        criteria.add(PLAY_TYPE, obj.getPlayType());
        criteria.add(STATUS, obj.getStatus());
        criteria.add(LOC_TYPE, obj.getLocType());
        criteria.add(DP_CUF, obj.getDpCuf());
        criteria.add(LINK_TYPE, obj.getLinkType());
        criteria.add(LINK_ID, obj.getLinkId());
        criteria.add(APP_KEY, obj.getAppKey());
        criteria.add(NDISPLAY_TYPE, obj.getNdisplayType());
        criteria.add(BEGIN_DATE, obj.getBeginDate());
        criteria.add(END_DATE, obj.getEndDate());
        return criteria;
    }

    /** Build a Criteria object from the data object for this peer, skipping all binary columns */
    public static Criteria buildSelectCriteria( Idea obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
            criteria.add(ID, obj.getId());
            criteria.add(CAST_ID, obj.getCastId());
            criteria.add(NAME, obj.getName());
            criteria.add(SHOWTIME, obj.getShowtime());
            criteria.add(I_PRIORITY, obj.getIPriority());
            criteria.add(COUNT, obj.getCount());
            criteria.add(NUMLIMIT, obj.getNumlimit());
            criteria.add(DQ, obj.getDq());
            criteria.add(IESORG, obj.getIesorg());
            criteria.add(CUF, obj.getCuf());
            criteria.add(CONTROLTYPE, obj.getControltype());
            criteria.add(ISSDK, obj.getIssdk());
            criteria.add(SDKID, obj.getSdkid());
            criteria.add(MST, obj.getMst());
            criteria.add(LOCATION_TYPE, obj.getLocationType());
            criteria.add(CLOSE_METHOD, obj.getCloseMethod());
            criteria.add(IDEA_SHOW_LOCATION, obj.getIdeaShowLocation());
            criteria.add(CONTROL_TYPE_MOBILE, obj.getControlTypeMobile());
            criteria.add(CHARGE_TIME, obj.getChargeTime());
            criteria.add(UPDATE_TIME, obj.getUpdateTime());
            criteria.add(PLAY_TYPE, obj.getPlayType());
            criteria.add(STATUS, obj.getStatus());
            criteria.add(LOC_TYPE, obj.getLocType());
            criteria.add(DP_CUF, obj.getDpCuf());
            criteria.add(LINK_TYPE, obj.getLinkType());
            criteria.add(LINK_ID, obj.getLinkId());
            criteria.add(APP_KEY, obj.getAppKey());
            criteria.add(NDISPLAY_TYPE, obj.getNdisplayType());
            criteria.add(BEGIN_DATE, obj.getBeginDate());
            criteria.add(END_DATE, obj.getEndDate());
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
    public static Idea retrieveByPK(int pk)
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
    public static Idea retrieveByPK(int pk, Connection con)
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
    public static Idea retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        Idea retVal = null;
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
    public static Idea retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List<Idea> v = doSelect(criteria, con);
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
            return (Idea)v.get(0);
        }
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Idea> retrieveByPKs(List<ObjectKey> pks)
        throws TorqueException
    {
        Connection db = null;
        List<Idea> retVal = null;
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
    public static List<Idea> retrieveByPKs( List<ObjectKey> pks, Connection dbcon )
        throws TorqueException
    {
        List<Idea> objs = null;
        if (pks == null || pks.size() == 0)
        {
            objs = new LinkedList<Idea>();
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
