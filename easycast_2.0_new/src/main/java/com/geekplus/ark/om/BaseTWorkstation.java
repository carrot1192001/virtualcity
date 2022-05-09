package com.geekplus.ark.om;


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
import com.geekplus.ark.om.bean.TWorkstationBean;




public abstract class BaseTWorkstation extends BaseObject
{
    /** The Peer class */
    private static final TWorkstationPeer peer =
        new TWorkstationPeer();


    /** The value for the id field */
    private int id;

    /** The value for the workstationName field */
    private String workstationName;

    /** The value for the locationX field */
    private int locationX;

    /** The value for the locationY field */
    private int locationY;

    /** The value for the angle field */
    private int angle;

    /** The value for the stopPointIds field */
    private String stopPointIds;

    /** The value for the creatorUsername field */
    private String creatorUsername;

    /** The value for the creationTime field */
    private Date creationTime;

    /** The value for the updatorUsername field */
    private String updatorUsername;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the status field */
    private int status = 1;

    /** The value for the floorId field */
    private int floorId;

    /** The value for the cellType field */
    private String cellType;

    /** The value for the width field */
    private int width;

    /** The value for the length field */
    private int length;

    /** The value for the descr field */
    private String descr;

    /** The value for the restartCell field */
    private int restartCell = 0;

    /** The value for the hostcellcode field */
    private String hostcellcode;


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
     * Get the WorkstationName
     *
     * @return String
     */
    public String getWorkstationName()
    {
        return workstationName;
    }


    /**
     * Set the value of WorkstationName
     *
     * @param v new value
     */
    public void setWorkstationName(String v) 
    {

        if (!ObjectUtils.equals(this.workstationName, v))
        {
            this.workstationName = v;
            setModified(true);
        }


    }

    /**
     * Get the LocationX
     *
     * @return int
     */
    public int getLocationX()
    {
        return locationX;
    }


    /**
     * Set the value of LocationX
     *
     * @param v new value
     */
    public void setLocationX(int v) 
    {

        if (this.locationX != v)
        {
            this.locationX = v;
            setModified(true);
        }


    }

    /**
     * Get the LocationY
     *
     * @return int
     */
    public int getLocationY()
    {
        return locationY;
    }


    /**
     * Set the value of LocationY
     *
     * @param v new value
     */
    public void setLocationY(int v) 
    {

        if (this.locationY != v)
        {
            this.locationY = v;
            setModified(true);
        }


    }

    /**
     * Get the Angle
     *
     * @return int
     */
    public int getAngle()
    {
        return angle;
    }


    /**
     * Set the value of Angle
     *
     * @param v new value
     */
    public void setAngle(int v) 
    {

        if (this.angle != v)
        {
            this.angle = v;
            setModified(true);
        }


    }

    /**
     * Get the StopPointIds
     *
     * @return String
     */
    public String getStopPointIds()
    {
        return stopPointIds;
    }


    /**
     * Set the value of StopPointIds
     *
     * @param v new value
     */
    public void setStopPointIds(String v) 
    {

        if (!ObjectUtils.equals(this.stopPointIds, v))
        {
            this.stopPointIds = v;
            setModified(true);
        }


    }

    /**
     * Get the CreatorUsername
     *
     * @return String
     */
    public String getCreatorUsername()
    {
        return creatorUsername;
    }


    /**
     * Set the value of CreatorUsername
     *
     * @param v new value
     */
    public void setCreatorUsername(String v) 
    {

        if (!ObjectUtils.equals(this.creatorUsername, v))
        {
            this.creatorUsername = v;
            setModified(true);
        }


    }

    /**
     * Get the CreationTime
     *
     * @return Date
     */
    public Date getCreationTime()
    {
        return creationTime;
    }


    /**
     * Set the value of CreationTime
     *
     * @param v new value
     */
    public void setCreationTime(Date v) 
    {

        if (!ObjectUtils.equals(this.creationTime, v))
        {
            this.creationTime = v;
            setModified(true);
        }


    }

    /**
     * Get the UpdatorUsername
     *
     * @return String
     */
    public String getUpdatorUsername()
    {
        return updatorUsername;
    }


    /**
     * Set the value of UpdatorUsername
     *
     * @param v new value
     */
    public void setUpdatorUsername(String v) 
    {

        if (!ObjectUtils.equals(this.updatorUsername, v))
        {
            this.updatorUsername = v;
            setModified(true);
        }


    }

    /**
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime()
    {
        return updateTime;
    }


    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(Date v) 
    {

        if (!ObjectUtils.equals(this.updateTime, v))
        {
            this.updateTime = v;
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
     * Get the FloorId
     *
     * @return int
     */
    public int getFloorId()
    {
        return floorId;
    }


    /**
     * Set the value of FloorId
     *
     * @param v new value
     */
    public void setFloorId(int v) 
    {

        if (this.floorId != v)
        {
            this.floorId = v;
            setModified(true);
        }


    }

    /**
     * Get the CellType
     *
     * @return String
     */
    public String getCellType()
    {
        return cellType;
    }


    /**
     * Set the value of CellType
     *
     * @param v new value
     */
    public void setCellType(String v) 
    {

        if (!ObjectUtils.equals(this.cellType, v))
        {
            this.cellType = v;
            setModified(true);
        }


    }

    /**
     * Get the Width
     *
     * @return int
     */
    public int getWidth()
    {
        return width;
    }


    /**
     * Set the value of Width
     *
     * @param v new value
     */
    public void setWidth(int v) 
    {

        if (this.width != v)
        {
            this.width = v;
            setModified(true);
        }


    }

    /**
     * Get the Length
     *
     * @return int
     */
    public int getLength()
    {
        return length;
    }


    /**
     * Set the value of Length
     *
     * @param v new value
     */
    public void setLength(int v) 
    {

        if (this.length != v)
        {
            this.length = v;
            setModified(true);
        }


    }

    /**
     * Get the Descr
     *
     * @return String
     */
    public String getDescr()
    {
        return descr;
    }


    /**
     * Set the value of Descr
     *
     * @param v new value
     */
    public void setDescr(String v) 
    {

        if (!ObjectUtils.equals(this.descr, v))
        {
            this.descr = v;
            setModified(true);
        }


    }

    /**
     * Get the RestartCell
     *
     * @return int
     */
    public int getRestartCell()
    {
        return restartCell;
    }


    /**
     * Set the value of RestartCell
     *
     * @param v new value
     */
    public void setRestartCell(int v) 
    {

        if (this.restartCell != v)
        {
            this.restartCell = v;
            setModified(true);
        }


    }

    /**
     * Get the Hostcellcode
     *
     * @return String
     */
    public String getHostcellcode()
    {
        return hostcellcode;
    }


    /**
     * Set the value of Hostcellcode
     *
     * @param v new value
     */
    public void setHostcellcode(String v) 
    {

        if (!ObjectUtils.equals(this.hostcellcode, v))
        {
            this.hostcellcode = v;
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
            fieldNames.add("WorkstationName");
            fieldNames.add("LocationX");
            fieldNames.add("LocationY");
            fieldNames.add("Angle");
            fieldNames.add("StopPointIds");
            fieldNames.add("CreatorUsername");
            fieldNames.add("CreationTime");
            fieldNames.add("UpdatorUsername");
            fieldNames.add("UpdateTime");
            fieldNames.add("Status");
            fieldNames.add("FloorId");
            fieldNames.add("CellType");
            fieldNames.add("Width");
            fieldNames.add("Length");
            fieldNames.add("Descr");
            fieldNames.add("RestartCell");
            fieldNames.add("Hostcellcode");
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
        if (name.equals("WorkstationName"))
        {
            return getWorkstationName();
        }
        if (name.equals("LocationX"))
        {
            return new Integer(getLocationX());
        }
        if (name.equals("LocationY"))
        {
            return new Integer(getLocationY());
        }
        if (name.equals("Angle"))
        {
            return new Integer(getAngle());
        }
        if (name.equals("StopPointIds"))
        {
            return getStopPointIds();
        }
        if (name.equals("CreatorUsername"))
        {
            return getCreatorUsername();
        }
        if (name.equals("CreationTime"))
        {
            return getCreationTime();
        }
        if (name.equals("UpdatorUsername"))
        {
            return getUpdatorUsername();
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("FloorId"))
        {
            return new Integer(getFloorId());
        }
        if (name.equals("CellType"))
        {
            return getCellType();
        }
        if (name.equals("Width"))
        {
            return new Integer(getWidth());
        }
        if (name.equals("Length"))
        {
            return new Integer(getLength());
        }
        if (name.equals("Descr"))
        {
            return getDescr();
        }
        if (name.equals("RestartCell"))
        {
            return new Integer(getRestartCell());
        }
        if (name.equals("Hostcellcode"))
        {
            return getHostcellcode();
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
        if (name.equals("WorkstationName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setWorkstationName((String) value);
            return true;
        }
        if (name.equals("LocationX"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setLocationX(((Integer) value).intValue());
            return true;
        }
        if (name.equals("LocationY"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setLocationY(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Angle"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAngle(((Integer) value).intValue());
            return true;
        }
        if (name.equals("StopPointIds"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStopPointIds((String) value);
            return true;
        }
        if (name.equals("CreatorUsername"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCreatorUsername((String) value);
            return true;
        }
        if (name.equals("CreationTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCreationTime((Date) value);
            return true;
        }
        if (name.equals("UpdatorUsername"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUpdatorUsername((String) value);
            return true;
        }
        if (name.equals("UpdateTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUpdateTime((Date) value);
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
        if (name.equals("FloorId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFloorId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CellType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCellType((String) value);
            return true;
        }
        if (name.equals("Width"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setWidth(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Length"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setLength(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Descr"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDescr((String) value);
            return true;
        }
        if (name.equals("RestartCell"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRestartCell(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Hostcellcode"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setHostcellcode((String) value);
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
        if (name.equals(TWorkstationPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(TWorkstationPeer.WORKSTATION_NAME))
        {
            return getWorkstationName();
        }
        if (name.equals(TWorkstationPeer.LOCATION_X))
        {
            return new Integer(getLocationX());
        }
        if (name.equals(TWorkstationPeer.LOCATION_Y))
        {
            return new Integer(getLocationY());
        }
        if (name.equals(TWorkstationPeer.ANGLE))
        {
            return new Integer(getAngle());
        }
        if (name.equals(TWorkstationPeer.STOP_POINT_IDS))
        {
            return getStopPointIds();
        }
        if (name.equals(TWorkstationPeer.CREATOR_USERNAME))
        {
            return getCreatorUsername();
        }
        if (name.equals(TWorkstationPeer.CREATION_TIME))
        {
            return getCreationTime();
        }
        if (name.equals(TWorkstationPeer.UPDATOR_USERNAME))
        {
            return getUpdatorUsername();
        }
        if (name.equals(TWorkstationPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(TWorkstationPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(TWorkstationPeer.FLOOR_ID))
        {
            return new Integer(getFloorId());
        }
        if (name.equals(TWorkstationPeer.CELL_TYPE))
        {
            return getCellType();
        }
        if (name.equals(TWorkstationPeer.WIDTH))
        {
            return new Integer(getWidth());
        }
        if (name.equals(TWorkstationPeer.LENGTH))
        {
            return new Integer(getLength());
        }
        if (name.equals(TWorkstationPeer.DESCR))
        {
            return getDescr();
        }
        if (name.equals(TWorkstationPeer.RESTART_CELL))
        {
            return new Integer(getRestartCell());
        }
        if (name.equals(TWorkstationPeer.HOSTCELLCODE))
        {
            return getHostcellcode();
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
      if (TWorkstationPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (TWorkstationPeer.WORKSTATION_NAME.equals(name))
        {
            return setByName("WorkstationName", value);
        }
      if (TWorkstationPeer.LOCATION_X.equals(name))
        {
            return setByName("LocationX", value);
        }
      if (TWorkstationPeer.LOCATION_Y.equals(name))
        {
            return setByName("LocationY", value);
        }
      if (TWorkstationPeer.ANGLE.equals(name))
        {
            return setByName("Angle", value);
        }
      if (TWorkstationPeer.STOP_POINT_IDS.equals(name))
        {
            return setByName("StopPointIds", value);
        }
      if (TWorkstationPeer.CREATOR_USERNAME.equals(name))
        {
            return setByName("CreatorUsername", value);
        }
      if (TWorkstationPeer.CREATION_TIME.equals(name))
        {
            return setByName("CreationTime", value);
        }
      if (TWorkstationPeer.UPDATOR_USERNAME.equals(name))
        {
            return setByName("UpdatorUsername", value);
        }
      if (TWorkstationPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (TWorkstationPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (TWorkstationPeer.FLOOR_ID.equals(name))
        {
            return setByName("FloorId", value);
        }
      if (TWorkstationPeer.CELL_TYPE.equals(name))
        {
            return setByName("CellType", value);
        }
      if (TWorkstationPeer.WIDTH.equals(name))
        {
            return setByName("Width", value);
        }
      if (TWorkstationPeer.LENGTH.equals(name))
        {
            return setByName("Length", value);
        }
      if (TWorkstationPeer.DESCR.equals(name))
        {
            return setByName("Descr", value);
        }
      if (TWorkstationPeer.RESTART_CELL.equals(name))
        {
            return setByName("RestartCell", value);
        }
      if (TWorkstationPeer.HOSTCELLCODE.equals(name))
        {
            return setByName("Hostcellcode", value);
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
            return getWorkstationName();
        }
        if (pos == 2)
        {
            return new Integer(getLocationX());
        }
        if (pos == 3)
        {
            return new Integer(getLocationY());
        }
        if (pos == 4)
        {
            return new Integer(getAngle());
        }
        if (pos == 5)
        {
            return getStopPointIds();
        }
        if (pos == 6)
        {
            return getCreatorUsername();
        }
        if (pos == 7)
        {
            return getCreationTime();
        }
        if (pos == 8)
        {
            return getUpdatorUsername();
        }
        if (pos == 9)
        {
            return getUpdateTime();
        }
        if (pos == 10)
        {
            return new Integer(getStatus());
        }
        if (pos == 11)
        {
            return new Integer(getFloorId());
        }
        if (pos == 12)
        {
            return getCellType();
        }
        if (pos == 13)
        {
            return new Integer(getWidth());
        }
        if (pos == 14)
        {
            return new Integer(getLength());
        }
        if (pos == 15)
        {
            return getDescr();
        }
        if (pos == 16)
        {
            return new Integer(getRestartCell());
        }
        if (pos == 17)
        {
            return getHostcellcode();
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
            return setByName("WorkstationName", value);
        }
    if (position == 2)
        {
            return setByName("LocationX", value);
        }
    if (position == 3)
        {
            return setByName("LocationY", value);
        }
    if (position == 4)
        {
            return setByName("Angle", value);
        }
    if (position == 5)
        {
            return setByName("StopPointIds", value);
        }
    if (position == 6)
        {
            return setByName("CreatorUsername", value);
        }
    if (position == 7)
        {
            return setByName("CreationTime", value);
        }
    if (position == 8)
        {
            return setByName("UpdatorUsername", value);
        }
    if (position == 9)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 10)
        {
            return setByName("Status", value);
        }
    if (position == 11)
        {
            return setByName("FloorId", value);
        }
    if (position == 12)
        {
            return setByName("CellType", value);
        }
    if (position == 13)
        {
            return setByName("Width", value);
        }
    if (position == 14)
        {
            return setByName("Length", value);
        }
    if (position == 15)
        {
            return setByName("Descr", value);
        }
    if (position == 16)
        {
            return setByName("RestartCell", value);
        }
    if (position == 17)
        {
            return setByName("Hostcellcode", value);
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
        save(TWorkstationPeer.DATABASE_NAME);
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
                    TWorkstationPeer.doInsert((TWorkstation) this, con);
                    setNew(false);
                }
                else
                {
                    TWorkstationPeer.doUpdate((TWorkstation) this, con);
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
    public TWorkstation copy() throws TorqueException
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
    public TWorkstation copy(Connection con) throws TorqueException
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
    public TWorkstation copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new TWorkstation(), deepcopy);
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
    public TWorkstation copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new TWorkstation(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected TWorkstation copyInto(TWorkstation copyObj) throws TorqueException
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
    protected TWorkstation copyInto(TWorkstation copyObj, Connection con) throws TorqueException
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
    protected TWorkstation copyInto(TWorkstation copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setWorkstationName(workstationName);
        copyObj.setLocationX(locationX);
        copyObj.setLocationY(locationY);
        copyObj.setAngle(angle);
        copyObj.setStopPointIds(stopPointIds);
        copyObj.setCreatorUsername(creatorUsername);
        copyObj.setCreationTime(creationTime);
        copyObj.setUpdatorUsername(updatorUsername);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStatus(status);
        copyObj.setFloorId(floorId);
        copyObj.setCellType(cellType);
        copyObj.setWidth(width);
        copyObj.setLength(length);
        copyObj.setDescr(descr);
        copyObj.setRestartCell(restartCell);
        copyObj.setHostcellcode(hostcellcode);

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
    protected TWorkstation copyInto(TWorkstation copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setWorkstationName(workstationName);
        copyObj.setLocationX(locationX);
        copyObj.setLocationY(locationY);
        copyObj.setAngle(angle);
        copyObj.setStopPointIds(stopPointIds);
        copyObj.setCreatorUsername(creatorUsername);
        copyObj.setCreationTime(creationTime);
        copyObj.setUpdatorUsername(updatorUsername);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStatus(status);
        copyObj.setFloorId(floorId);
        copyObj.setCellType(cellType);
        copyObj.setWidth(width);
        copyObj.setLength(length);
        copyObj.setDescr(descr);
        copyObj.setRestartCell(restartCell);
        copyObj.setHostcellcode(hostcellcode);

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
    public TWorkstationPeer getPeer()
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
        return TWorkstationPeer.getTableMap();
    }

  
    /**
     * Creates a TWorkstationBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a TWorkstationBean with the contents of this object
     */
    public TWorkstationBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a TWorkstationBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a TWorkstationBean with the contents of this object
     */
    public TWorkstationBean getBean(IdentityMap createdBeans)
    {
        TWorkstationBean result = (TWorkstationBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new TWorkstationBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setWorkstationName(getWorkstationName());
        result.setLocationX(getLocationX());
        result.setLocationY(getLocationY());
        result.setAngle(getAngle());
        result.setStopPointIds(getStopPointIds());
        result.setCreatorUsername(getCreatorUsername());
        result.setCreationTime(getCreationTime());
        result.setUpdatorUsername(getUpdatorUsername());
        result.setUpdateTime(getUpdateTime());
        result.setStatus(getStatus());
        result.setFloorId(getFloorId());
        result.setCellType(getCellType());
        result.setWidth(getWidth());
        result.setLength(getLength());
        result.setDescr(getDescr());
        result.setRestartCell(getRestartCell());
        result.setHostcellcode(getHostcellcode());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of TWorkstation with the contents
     * of a TWorkstationBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the TWorkstationBean which contents are used to create
     *        the resulting class
     * @return an instance of TWorkstation with the contents of bean
     */
    public static TWorkstation createTWorkstation(TWorkstationBean bean)
        throws TorqueException
    {
        return createTWorkstation(bean, new IdentityMap());
    }

    /**
     * Creates an instance of TWorkstation with the contents
     * of a TWorkstationBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the TWorkstationBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of TWorkstation with the contents of bean
     */

    public static TWorkstation createTWorkstation(TWorkstationBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        TWorkstation result = (TWorkstation) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new TWorkstation();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setWorkstationName(bean.getWorkstationName());
        result.setLocationX(bean.getLocationX());
        result.setLocationY(bean.getLocationY());
        result.setAngle(bean.getAngle());
        result.setStopPointIds(bean.getStopPointIds());
        result.setCreatorUsername(bean.getCreatorUsername());
        result.setCreationTime(bean.getCreationTime());
        result.setUpdatorUsername(bean.getUpdatorUsername());
        result.setUpdateTime(bean.getUpdateTime());
        result.setStatus(bean.getStatus());
        result.setFloorId(bean.getFloorId());
        result.setCellType(bean.getCellType());
        result.setWidth(bean.getWidth());
        result.setLength(bean.getLength());
        result.setDescr(bean.getDescr());
        result.setRestartCell(bean.getRestartCell());
        result.setHostcellcode(bean.getHostcellcode());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("TWorkstation:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("WorkstationName = ")
           .append(getWorkstationName())
           .append("\n");
        str.append("LocationX = ")
           .append(getLocationX())
           .append("\n");
        str.append("LocationY = ")
           .append(getLocationY())
           .append("\n");
        str.append("Angle = ")
           .append(getAngle())
           .append("\n");
        str.append("StopPointIds = ")
           .append(getStopPointIds())
           .append("\n");
        str.append("CreatorUsername = ")
           .append(getCreatorUsername())
           .append("\n");
        str.append("CreationTime = ")
           .append(getCreationTime())
           .append("\n");
        str.append("UpdatorUsername = ")
           .append(getUpdatorUsername())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("FloorId = ")
           .append(getFloorId())
           .append("\n");
        str.append("CellType = ")
           .append(getCellType())
           .append("\n");
        str.append("Width = ")
           .append(getWidth())
           .append("\n");
        str.append("Length = ")
           .append(getLength())
           .append("\n");
        str.append("Descr = ")
           .append(getDescr())
           .append("\n");
        str.append("RestartCell = ")
           .append(getRestartCell())
           .append("\n");
        str.append("Hostcellcode = ")
           .append(getHostcellcode())
           .append("\n");
        return(str.toString());
    }
}
