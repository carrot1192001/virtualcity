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
public abstract class BaseAdCastPeer
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
     * @deprecated Torque.getMapBuilder(AdCastMapBuilder.CLASS_NAME) instead
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return Torque.getMapBuilder(AdCastMapBuilder.CLASS_NAME);
    }

    /** the column name for the id field */
    public static final String ID;
    /** the column name for the order_id field */
    public static final String ORDER_ID;
    /** the column name for the customer_id field */
    public static final String CUSTOMER_ID;
    /** the column name for the product_id field */
    public static final String PRODUCT_ID;
    /** the column name for the name field */
    public static final String NAME;
    /** the column name for the ad_type_id field */
    public static final String AD_TYPE_ID;
    /** the column name for the direct_way field */
    public static final String DIRECT_WAY;
    /** the column name for the cast_way field */
    public static final String CAST_WAY;
    /** the column name for the interact_effect field */
    public static final String INTERACT_EFFECT;
    /** the column name for the is_copyright field */
    public static final String IS_COPYRIGHT;
    /** the column name for the price field */
    public static final String PRICE;
    /** the column name for the speed_type field */
    public static final String SPEED_TYPE;
    /** the column name for the type_priority field */
    public static final String TYPE_PRIORITY;
    /** the column name for the product_priority field */
    public static final String PRODUCT_PRIORITY;
    /** the column name for the vip_priority field */
    public static final String VIP_PRIORITY;
    /** the column name for the order_priority field */
    public static final String ORDER_PRIORITY;
    /** the column name for the custom_priority field */
    public static final String CUSTOM_PRIORITY;
    /** the column name for the custom_num_priority field */
    public static final String CUSTOM_NUM_PRIORITY;
    /** the column name for the camp_priority field */
    public static final String CAMP_PRIORITY;
    /** the column name for the area_priority field */
    public static final String AREA_PRIORITY;
    /** the column name for the channel_priority field */
    public static final String CHANNEL_PRIORITY;
    /** the column name for the platform_priority field */
    public static final String PLATFORM_PRIORITY;
    /** the column name for the user_priority field */
    public static final String USER_PRIORITY;
    /** the column name for the keyword_priority field */
    public static final String KEYWORD_PRIORITY;
    /** the column name for the videogroup_priority field */
    public static final String VIDEOGROUP_PRIORITY;
    /** the column name for the ro_priority field */
    public static final String RO_PRIORITY;
    /** the column name for the sow_type field */
    public static final String SOW_TYPE;
    /** the column name for the rate_m field */
    public static final String RATE_M;
    /** the column name for the rates field */
    public static final String RATES;
    /** the column name for the threshold field */
    public static final String THRESHOLD;
    /** the column name for the rtb_type field */
    public static final String RTB_TYPE;
    /** the column name for the update_time field */
    public static final String UPDATE_TIME;
    /** the column name for the start_date field */
    public static final String START_DATE;
    /** the column name for the end_date field */
    public static final String END_DATE;
    /** the column name for the rtbid field */
    public static final String RTBID;
    /** the column name for the idea_show_type field */
    public static final String IDEA_SHOW_TYPE;
    /** the column name for the main_cast_id field */
    public static final String MAIN_CAST_ID;
    /** the column name for the is_bak field */
    public static final String IS_BAK;
    /** the column name for the dsp_id field */
    public static final String DSP_ID;
    /** the column name for the deal_id field */
    public static final String DEAL_ID;
    /** the column name for the skip_time field */
    public static final String SKIP_TIME;
    /** the column name for the direct_type field */
    public static final String DIRECT_TYPE;
    /** the column name for the pdb_type field */
    public static final String PDB_TYPE;
    /** the column name for the danger_ip_weight field */
    public static final String DANGER_IP_WEIGHT;
    /** the column name for the charge_type field */
    public static final String CHARGE_TYPE;
    /** the column name for the is_aiid_ta field */
    public static final String IS_AIID_TA;
    /** the column name for the status field */
    public static final String STATUS;
    /** the column name for the mutex field */
    public static final String MUTEX;
    /** the column name for the charge_time field */
    public static final String CHARGE_TIME;
    /** the column name for the resource_type field */
    public static final String RESOURCE_TYPE;
    /** the column name for the outside field */
    public static final String OUTSIDE;
    /** the column name for the pbak field */
    public static final String PBAK;
    /** the column name for the is_area field */
    public static final String IS_AREA;

    static
    {
        DATABASE_NAME = "atm";
        TABLE_NAME = "ad_cast";

        ID = "ad_cast.id";
        ORDER_ID = "ad_cast.order_id";
        CUSTOMER_ID = "ad_cast.customer_id";
        PRODUCT_ID = "ad_cast.product_id";
        NAME = "ad_cast.name";
        AD_TYPE_ID = "ad_cast.ad_type_id";
        DIRECT_WAY = "ad_cast.direct_way";
        CAST_WAY = "ad_cast.cast_way";
        INTERACT_EFFECT = "ad_cast.interact_effect";
        IS_COPYRIGHT = "ad_cast.is_copyright";
        PRICE = "ad_cast.price";
        SPEED_TYPE = "ad_cast.speed_type";
        TYPE_PRIORITY = "ad_cast.type_priority";
        PRODUCT_PRIORITY = "ad_cast.product_priority";
        VIP_PRIORITY = "ad_cast.vip_priority";
        ORDER_PRIORITY = "ad_cast.order_priority";
        CUSTOM_PRIORITY = "ad_cast.custom_priority";
        CUSTOM_NUM_PRIORITY = "ad_cast.custom_num_priority";
        CAMP_PRIORITY = "ad_cast.camp_priority";
        AREA_PRIORITY = "ad_cast.area_priority";
        CHANNEL_PRIORITY = "ad_cast.channel_priority";
        PLATFORM_PRIORITY = "ad_cast.platform_priority";
        USER_PRIORITY = "ad_cast.user_priority";
        KEYWORD_PRIORITY = "ad_cast.keyword_priority";
        VIDEOGROUP_PRIORITY = "ad_cast.videogroup_priority";
        RO_PRIORITY = "ad_cast.ro_priority";
        SOW_TYPE = "ad_cast.sow_type";
        RATE_M = "ad_cast.rate_m";
        RATES = "ad_cast.rates";
        THRESHOLD = "ad_cast.threshold";
        RTB_TYPE = "ad_cast.rtb_type";
        UPDATE_TIME = "ad_cast.update_time";
        START_DATE = "ad_cast.start_date";
        END_DATE = "ad_cast.end_date";
        RTBID = "ad_cast.rtbid";
        IDEA_SHOW_TYPE = "ad_cast.idea_show_type";
        MAIN_CAST_ID = "ad_cast.main_cast_id";
        IS_BAK = "ad_cast.is_bak";
        DSP_ID = "ad_cast.dsp_id";
        DEAL_ID = "ad_cast.deal_id";
        SKIP_TIME = "ad_cast.skip_time";
        DIRECT_TYPE = "ad_cast.direct_type";
        PDB_TYPE = "ad_cast.pdb_type";
        DANGER_IP_WEIGHT = "ad_cast.danger_ip_weight";
        CHARGE_TYPE = "ad_cast.charge_type";
        IS_AIID_TA = "ad_cast.is_aiid_ta";
        STATUS = "ad_cast.status";
        MUTEX = "ad_cast.mutex";
        CHARGE_TIME = "ad_cast.charge_time";
        RESOURCE_TYPE = "ad_cast.resource_type";
        OUTSIDE = "ad_cast.outside";
        PBAK = "ad_cast.pbak";
        IS_AREA = "ad_cast.is_area";
        if (Torque.isInit())
        {
            try
            {
                Torque.getMapBuilder(AdCastMapBuilder.CLASS_NAME);
            }
            catch (TorqueException e)
            {
                log.error("Could not initialize Peer", e);
                throw new TorqueRuntimeException(e);
            }
        }
        else
        {
            Torque.registerMapBuilder(AdCastMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  53;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "com.youku.atm.om.AdCast";

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
    public static List<AdCast> resultSet2Objects(java.sql.ResultSet results)
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
        return BaseAdCastPeer
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
        criteria.addSelectColumn(ORDER_ID);
        criteria.addSelectColumn(CUSTOMER_ID);
        criteria.addSelectColumn(PRODUCT_ID);
        criteria.addSelectColumn(NAME);
        criteria.addSelectColumn(AD_TYPE_ID);
        criteria.addSelectColumn(DIRECT_WAY);
        criteria.addSelectColumn(CAST_WAY);
        criteria.addSelectColumn(INTERACT_EFFECT);
        criteria.addSelectColumn(IS_COPYRIGHT);
        criteria.addSelectColumn(PRICE);
        criteria.addSelectColumn(SPEED_TYPE);
        criteria.addSelectColumn(TYPE_PRIORITY);
        criteria.addSelectColumn(PRODUCT_PRIORITY);
        criteria.addSelectColumn(VIP_PRIORITY);
        criteria.addSelectColumn(ORDER_PRIORITY);
        criteria.addSelectColumn(CUSTOM_PRIORITY);
        criteria.addSelectColumn(CUSTOM_NUM_PRIORITY);
        criteria.addSelectColumn(CAMP_PRIORITY);
        criteria.addSelectColumn(AREA_PRIORITY);
        criteria.addSelectColumn(CHANNEL_PRIORITY);
        criteria.addSelectColumn(PLATFORM_PRIORITY);
        criteria.addSelectColumn(USER_PRIORITY);
        criteria.addSelectColumn(KEYWORD_PRIORITY);
        criteria.addSelectColumn(VIDEOGROUP_PRIORITY);
        criteria.addSelectColumn(RO_PRIORITY);
        criteria.addSelectColumn(SOW_TYPE);
        criteria.addSelectColumn(RATE_M);
        criteria.addSelectColumn(RATES);
        criteria.addSelectColumn(THRESHOLD);
        criteria.addSelectColumn(RTB_TYPE);
        criteria.addSelectColumn(UPDATE_TIME);
        criteria.addSelectColumn(START_DATE);
        criteria.addSelectColumn(END_DATE);
        criteria.addSelectColumn(RTBID);
        criteria.addSelectColumn(IDEA_SHOW_TYPE);
        criteria.addSelectColumn(MAIN_CAST_ID);
        criteria.addSelectColumn(IS_BAK);
        criteria.addSelectColumn(DSP_ID);
        criteria.addSelectColumn(DEAL_ID);
        criteria.addSelectColumn(SKIP_TIME);
        criteria.addSelectColumn(DIRECT_TYPE);
        criteria.addSelectColumn(PDB_TYPE);
        criteria.addSelectColumn(DANGER_IP_WEIGHT);
        criteria.addSelectColumn(CHARGE_TYPE);
        criteria.addSelectColumn(IS_AIID_TA);
        criteria.addSelectColumn(STATUS);
        criteria.addSelectColumn(MUTEX);
        criteria.addSelectColumn(CHARGE_TIME);
        criteria.addSelectColumn(RESOURCE_TYPE);
        criteria.addSelectColumn(OUTSIDE);
        criteria.addSelectColumn(PBAK);
        criteria.addSelectColumn(IS_AREA);
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
    public static AdCast row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            AdCast obj = (AdCast) cls.newInstance();
            AdCastPeer.populateObject(row, offset, obj);
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
                                      AdCast obj)
        throws TorqueException
    {
        try
        {
            obj.setId(row.getValue(offset + 0).asInt());
            obj.setOrderId(row.getValue(offset + 1).asInt());
            obj.setCustomerId(row.getValue(offset + 2).asInt());
            obj.setProductId(row.getValue(offset + 3).asInt());
            obj.setName(row.getValue(offset + 4).asString());
            obj.setAdTypeId(row.getValue(offset + 5).asInt());
            obj.setDirectWay(row.getValue(offset + 6).asString());
            obj.setCastWay(row.getValue(offset + 7).asString());
            obj.setInteractEffect(row.getValue(offset + 8).asInt());
            obj.setIsCopyright(row.getValue(offset + 9).asInt());
            obj.setPrice(row.getValue(offset + 10).asDouble());
            obj.setSpeedType(row.getValue(offset + 11).asInt());
            obj.setTypePriority(row.getValue(offset + 12).asInt());
            obj.setProductPriority(row.getValue(offset + 13).asInt());
            obj.setVipPriority(row.getValue(offset + 14).asInt());
            obj.setOrderPriority(row.getValue(offset + 15).asInt());
            obj.setCustomPriority(row.getValue(offset + 16).asInt());
            obj.setCustomNumPriority(row.getValue(offset + 17).asInt());
            obj.setCampPriority(row.getValue(offset + 18).asInt());
            obj.setAreaPriority(row.getValue(offset + 19).asInt());
            obj.setChannelPriority(row.getValue(offset + 20).asInt());
            obj.setPlatformPriority(row.getValue(offset + 21).asInt());
            obj.setUserPriority(row.getValue(offset + 22).asInt());
            obj.setKeywordPriority(row.getValue(offset + 23).asInt());
            obj.setVideogroupPriority(row.getValue(offset + 24).asInt());
            obj.setRoPriority(row.getValue(offset + 25).asInt());
            obj.setSowType(row.getValue(offset + 26).asInt());
            obj.setRateM(row.getValue(offset + 27).asInt());
            obj.setRates(row.getValue(offset + 28).asInt());
            obj.setThreshold(row.getValue(offset + 29).asDouble());
            obj.setRtbType(row.getValue(offset + 30).asInt());
            obj.setUpdateTime(row.getValue(offset + 31).asUtilDate());
            obj.setStartDate(row.getValue(offset + 32).asUtilDate());
            obj.setEndDate(row.getValue(offset + 33).asUtilDate());
            obj.setRtbid(row.getValue(offset + 34).asInt());
            obj.setIdeaShowType(row.getValue(offset + 35).asInt());
            obj.setMainCastId(row.getValue(offset + 36).asInt());
            obj.setIsBak(row.getValue(offset + 37).asInt());
            obj.setDspId(row.getValue(offset + 38).asString());
            obj.setDealId(row.getValue(offset + 39).asString());
            obj.setSkipTime(row.getValue(offset + 40).asInt());
            obj.setDirectType(row.getValue(offset + 41).asInt());
            obj.setPdbType(row.getValue(offset + 42).asInt());
            obj.setDangerIpWeight(row.getValue(offset + 43).asInt());
            obj.setChargeType(row.getValue(offset + 44).asInt());
            obj.setIsAiidTa(row.getValue(offset + 45).asInt());
            obj.setStatus(row.getValue(offset + 46).asInt());
            obj.setMutex(row.getValue(offset + 47).asInt());
            obj.setChargeTime(row.getValue(offset + 48).asInt());
            obj.setResourceType(row.getValue(offset + 49).asString());
            obj.setOutside(row.getValue(offset + 50).asInt());
            obj.setPbak(row.getValue(offset + 51).asInt());
            obj.setIsArea(row.getValue(offset + 52).asInt());
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
    public static List<AdCast> doSelect(Criteria criteria) throws TorqueException
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
    public static List<AdCast> doSelect(Criteria criteria, Connection con)
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
        return BaseAdCastPeer
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
    public static List<AdCast> populateObjects(List<Record> records)
        throws TorqueException
    {
        List<AdCast> results = new ArrayList<AdCast>(records.size());

        // populate the object(s)
        for (int i = 0; i < records.size(); i++)
        {
            Record row =  records.get(i);
            results.add(AdCastPeer.row2Object(row, 1,
                AdCastPeer.getOMClass()));
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
         BaseAdCastPeer
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
         AdCastPeer
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
    public static List<AdCast> doSelect(AdCast obj) throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(AdCast obj) throws TorqueException
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
    public static void doUpdate(AdCast obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(AdCast obj) throws TorqueException
    {
        doDelete(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(AdCast) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(AdCast obj, Connection con)
        throws TorqueException
    {
        doInsert(buildCriteria(obj), con);
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(AdCast) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(AdCast obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(AdCast) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(AdCast obj, Connection con)
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
        BaseAdCastPeer
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
    public static Criteria buildCriteria( AdCast obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        criteria.add(ID, obj.getId());
        criteria.add(ORDER_ID, obj.getOrderId());
        criteria.add(CUSTOMER_ID, obj.getCustomerId());
        criteria.add(PRODUCT_ID, obj.getProductId());
        criteria.add(NAME, obj.getName());
        criteria.add(AD_TYPE_ID, obj.getAdTypeId());
        criteria.add(DIRECT_WAY, obj.getDirectWay());
        criteria.add(CAST_WAY, obj.getCastWay());
        criteria.add(INTERACT_EFFECT, obj.getInteractEffect());
        criteria.add(IS_COPYRIGHT, obj.getIsCopyright());
        criteria.add(PRICE, obj.getPrice());
        criteria.add(SPEED_TYPE, obj.getSpeedType());
        criteria.add(TYPE_PRIORITY, obj.getTypePriority());
        criteria.add(PRODUCT_PRIORITY, obj.getProductPriority());
        criteria.add(VIP_PRIORITY, obj.getVipPriority());
        criteria.add(ORDER_PRIORITY, obj.getOrderPriority());
        criteria.add(CUSTOM_PRIORITY, obj.getCustomPriority());
        criteria.add(CUSTOM_NUM_PRIORITY, obj.getCustomNumPriority());
        criteria.add(CAMP_PRIORITY, obj.getCampPriority());
        criteria.add(AREA_PRIORITY, obj.getAreaPriority());
        criteria.add(CHANNEL_PRIORITY, obj.getChannelPriority());
        criteria.add(PLATFORM_PRIORITY, obj.getPlatformPriority());
        criteria.add(USER_PRIORITY, obj.getUserPriority());
        criteria.add(KEYWORD_PRIORITY, obj.getKeywordPriority());
        criteria.add(VIDEOGROUP_PRIORITY, obj.getVideogroupPriority());
        criteria.add(RO_PRIORITY, obj.getRoPriority());
        criteria.add(SOW_TYPE, obj.getSowType());
        criteria.add(RATE_M, obj.getRateM());
        criteria.add(RATES, obj.getRates());
        criteria.add(THRESHOLD, obj.getThreshold());
        criteria.add(RTB_TYPE, obj.getRtbType());
        criteria.add(UPDATE_TIME, obj.getUpdateTime());
        criteria.add(START_DATE, obj.getStartDate());
        criteria.add(END_DATE, obj.getEndDate());
        criteria.add(RTBID, obj.getRtbid());
        criteria.add(IDEA_SHOW_TYPE, obj.getIdeaShowType());
        criteria.add(MAIN_CAST_ID, obj.getMainCastId());
        criteria.add(IS_BAK, obj.getIsBak());
        criteria.add(DSP_ID, obj.getDspId());
        criteria.add(DEAL_ID, obj.getDealId());
        criteria.add(SKIP_TIME, obj.getSkipTime());
        criteria.add(DIRECT_TYPE, obj.getDirectType());
        criteria.add(PDB_TYPE, obj.getPdbType());
        criteria.add(DANGER_IP_WEIGHT, obj.getDangerIpWeight());
        criteria.add(CHARGE_TYPE, obj.getChargeType());
        criteria.add(IS_AIID_TA, obj.getIsAiidTa());
        criteria.add(STATUS, obj.getStatus());
        criteria.add(MUTEX, obj.getMutex());
        criteria.add(CHARGE_TIME, obj.getChargeTime());
        criteria.add(RESOURCE_TYPE, obj.getResourceType());
        criteria.add(OUTSIDE, obj.getOutside());
        criteria.add(PBAK, obj.getPbak());
        criteria.add(IS_AREA, obj.getIsArea());
        return criteria;
    }

    /** Build a Criteria object from the data object for this peer, skipping all binary columns */
    public static Criteria buildSelectCriteria( AdCast obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
            criteria.add(ID, obj.getId());
            criteria.add(ORDER_ID, obj.getOrderId());
            criteria.add(CUSTOMER_ID, obj.getCustomerId());
            criteria.add(PRODUCT_ID, obj.getProductId());
            criteria.add(NAME, obj.getName());
            criteria.add(AD_TYPE_ID, obj.getAdTypeId());
            criteria.add(DIRECT_WAY, obj.getDirectWay());
            criteria.add(CAST_WAY, obj.getCastWay());
            criteria.add(INTERACT_EFFECT, obj.getInteractEffect());
            criteria.add(IS_COPYRIGHT, obj.getIsCopyright());
            criteria.add(PRICE, obj.getPrice());
            criteria.add(SPEED_TYPE, obj.getSpeedType());
            criteria.add(TYPE_PRIORITY, obj.getTypePriority());
            criteria.add(PRODUCT_PRIORITY, obj.getProductPriority());
            criteria.add(VIP_PRIORITY, obj.getVipPriority());
            criteria.add(ORDER_PRIORITY, obj.getOrderPriority());
            criteria.add(CUSTOM_PRIORITY, obj.getCustomPriority());
            criteria.add(CUSTOM_NUM_PRIORITY, obj.getCustomNumPriority());
            criteria.add(CAMP_PRIORITY, obj.getCampPriority());
            criteria.add(AREA_PRIORITY, obj.getAreaPriority());
            criteria.add(CHANNEL_PRIORITY, obj.getChannelPriority());
            criteria.add(PLATFORM_PRIORITY, obj.getPlatformPriority());
            criteria.add(USER_PRIORITY, obj.getUserPriority());
            criteria.add(KEYWORD_PRIORITY, obj.getKeywordPriority());
            criteria.add(VIDEOGROUP_PRIORITY, obj.getVideogroupPriority());
            criteria.add(RO_PRIORITY, obj.getRoPriority());
            criteria.add(SOW_TYPE, obj.getSowType());
            criteria.add(RATE_M, obj.getRateM());
            criteria.add(RATES, obj.getRates());
            criteria.add(THRESHOLD, obj.getThreshold());
            criteria.add(RTB_TYPE, obj.getRtbType());
            criteria.add(UPDATE_TIME, obj.getUpdateTime());
            criteria.add(START_DATE, obj.getStartDate());
            criteria.add(END_DATE, obj.getEndDate());
            criteria.add(RTBID, obj.getRtbid());
            criteria.add(IDEA_SHOW_TYPE, obj.getIdeaShowType());
            criteria.add(MAIN_CAST_ID, obj.getMainCastId());
            criteria.add(IS_BAK, obj.getIsBak());
            criteria.add(DSP_ID, obj.getDspId());
            criteria.add(DEAL_ID, obj.getDealId());
            criteria.add(SKIP_TIME, obj.getSkipTime());
            criteria.add(DIRECT_TYPE, obj.getDirectType());
            criteria.add(PDB_TYPE, obj.getPdbType());
            criteria.add(DANGER_IP_WEIGHT, obj.getDangerIpWeight());
            criteria.add(CHARGE_TYPE, obj.getChargeType());
            criteria.add(IS_AIID_TA, obj.getIsAiidTa());
            criteria.add(STATUS, obj.getStatus());
            criteria.add(MUTEX, obj.getMutex());
            criteria.add(CHARGE_TIME, obj.getChargeTime());
            criteria.add(RESOURCE_TYPE, obj.getResourceType());
            criteria.add(OUTSIDE, obj.getOutside());
            criteria.add(PBAK, obj.getPbak());
            criteria.add(IS_AREA, obj.getIsArea());
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
    public static AdCast retrieveByPK(int pk)
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
    public static AdCast retrieveByPK(int pk, Connection con)
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
    public static AdCast retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        AdCast retVal = null;
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
    public static AdCast retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List<AdCast> v = doSelect(criteria, con);
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
            return (AdCast)v.get(0);
        }
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<AdCast> retrieveByPKs(List<ObjectKey> pks)
        throws TorqueException
    {
        Connection db = null;
        List<AdCast> retVal = null;
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
    public static List<AdCast> retrieveByPKs( List<ObjectKey> pks, Connection dbcon )
        throws TorqueException
    {
        List<AdCast> objs = null;
        if (pks == null || pks.size() == 0)
        {
            objs = new LinkedList<AdCast>();
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
     * selects a collection of AdCast objects pre-filled with their
     * AdType objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCastPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<AdCast> doSelectJoinAdType(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinAdType(criteria, null);
    }

    /**
     * selects a collection of AdCast objects pre-filled with their
     * AdType objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCastPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<AdCast> doSelectJoinAdType(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        AdCastPeer.addSelectColumns(criteria);
        int offset = numColumns + 1;
        AdTypePeer.addSelectColumns(criteria);

        criteria.addJoin(AdCastPeer.AD_TYPE_ID,
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

        List<AdCast> results = new ArrayList<AdCast>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = AdCastPeer.getOMClass();
            AdCast obj1 = (AdCast) AdCastPeer
                .row2Object(row, 1, omClass);
             omClass = AdTypePeer.getOMClass();
            AdType obj2 = (AdType) AdTypePeer
                .row2Object(row, offset, omClass);

            boolean newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                AdCast temp_obj1 =  results.get(j);
                AdType temp_obj2 = (AdType) temp_obj1.getAdType();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addAdCast(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initAdCasts();
                obj2.addAdCast(obj1);
            }
            results.add(obj1);
        }
        return results;
    }




    /**
     * selects a collection of AdCast objects pre-filled with their
     * AdOrder objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCastPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<AdCast> doSelectJoinAdOrder(Criteria criteria)
        throws TorqueException
    {
        return doSelectJoinAdOrder(criteria, null);
    }

    /**
     * selects a collection of AdCast objects pre-filled with their
     * AdOrder objects.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCastPeer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    protected static List<AdCast> doSelectJoinAdOrder(Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        AdCastPeer.addSelectColumns(criteria);
        int offset = numColumns + 1;
        AdOrderPeer.addSelectColumns(criteria);

        criteria.addJoin(AdCastPeer.ORDER_ID,
            AdOrderPeer.ID);

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

        List<AdCast> results = new ArrayList<AdCast>();

        for (int i = 0; i < rows.size(); i++)
        {
            Record row =  rows.get(i);

            Class omClass = AdCastPeer.getOMClass();
            AdCast obj1 = (AdCast) AdCastPeer
                .row2Object(row, 1, omClass);
             omClass = AdOrderPeer.getOMClass();
            AdOrder obj2 = (AdOrder) AdOrderPeer
                .row2Object(row, offset, omClass);

            boolean newObject = true;
            for (int j = 0; j < results.size(); j++)
            {
                AdCast temp_obj1 =  results.get(j);
                AdOrder temp_obj2 = (AdOrder) temp_obj1.getAdOrder();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addAdCast(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initAdCasts();
                obj2.addAdCast(obj1);
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
