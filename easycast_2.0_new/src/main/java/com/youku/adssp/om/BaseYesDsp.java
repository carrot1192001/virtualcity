package com.youku.adssp.om;


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
import com.youku.adssp.om.bean.YesDspBean;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to YesDsp
 */
public abstract class BaseYesDsp extends BaseObject
{
    /** The Peer class */
    private static final YesDspPeer peer =
        new YesDspPeer();


    /** The value for the id field */
    private int id;

    /** The value for the dspname field */
    private String dspname;

    /** The value for the dsptoken field */
    private String dsptoken;

    /** The value for the cookiemappingurl field */
    private String cookiemappingurl;

    /** The value for the bidurl field */
    private String bidurl;

    /** The value for the winnoticeurl field */
    private String winnoticeurl;

    /** The value for the qps field */
    private int qps;

    /** The value for the dspstart field */
    private int dspstart;

    /** The value for the ismaterialstart field */
    private int ismaterialstart;

    /** The value for the iscookiemapping field */
    private int iscookiemapping;

    /** The value for the isrtb field */
    private int isrtb;

    /** The value for the ispass field */
    private int ispass;

    /** The value for the ischeckmaterial field */
    private int ischeckmaterial;

    /** The value for the description field */
    private String description;

    /** The value for the enjoyad field */
    private int enjoyad;

    /** The value for the isopenchannel field */
    private int isopenchannel;

    /** The value for the isPdbReused field */
    private int isPdbReused;

    /** The value for the alias field */
    private String alias;


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
     * Get the Dspname
     *
     * @return String
     */
    public String getDspname()
    {
        return dspname;
    }


    /**
     * Set the value of Dspname
     *
     * @param v new value
     */
    public void setDspname(String v) 
    {

        if (!ObjectUtils.equals(this.dspname, v))
        {
            this.dspname = v;
            setModified(true);
        }


    }

    /**
     * Get the Dsptoken
     *
     * @return String
     */
    public String getDsptoken()
    {
        return dsptoken;
    }


    /**
     * Set the value of Dsptoken
     *
     * @param v new value
     */
    public void setDsptoken(String v) 
    {

        if (!ObjectUtils.equals(this.dsptoken, v))
        {
            this.dsptoken = v;
            setModified(true);
        }


    }

    /**
     * Get the Cookiemappingurl
     *
     * @return String
     */
    public String getCookiemappingurl()
    {
        return cookiemappingurl;
    }


    /**
     * Set the value of Cookiemappingurl
     *
     * @param v new value
     */
    public void setCookiemappingurl(String v) 
    {

        if (!ObjectUtils.equals(this.cookiemappingurl, v))
        {
            this.cookiemappingurl = v;
            setModified(true);
        }


    }

    /**
     * Get the Bidurl
     *
     * @return String
     */
    public String getBidurl()
    {
        return bidurl;
    }


    /**
     * Set the value of Bidurl
     *
     * @param v new value
     */
    public void setBidurl(String v) 
    {

        if (!ObjectUtils.equals(this.bidurl, v))
        {
            this.bidurl = v;
            setModified(true);
        }


    }

    /**
     * Get the Winnoticeurl
     *
     * @return String
     */
    public String getWinnoticeurl()
    {
        return winnoticeurl;
    }


    /**
     * Set the value of Winnoticeurl
     *
     * @param v new value
     */
    public void setWinnoticeurl(String v) 
    {

        if (!ObjectUtils.equals(this.winnoticeurl, v))
        {
            this.winnoticeurl = v;
            setModified(true);
        }


    }

    /**
     * Get the Qps
     *
     * @return int
     */
    public int getQps()
    {
        return qps;
    }


    /**
     * Set the value of Qps
     *
     * @param v new value
     */
    public void setQps(int v) 
    {

        if (this.qps != v)
        {
            this.qps = v;
            setModified(true);
        }


    }

    /**
     * Get the Dspstart
     *
     * @return int
     */
    public int getDspstart()
    {
        return dspstart;
    }


    /**
     * Set the value of Dspstart
     *
     * @param v new value
     */
    public void setDspstart(int v) 
    {

        if (this.dspstart != v)
        {
            this.dspstart = v;
            setModified(true);
        }


    }

    /**
     * Get the Ismaterialstart
     *
     * @return int
     */
    public int getIsmaterialstart()
    {
        return ismaterialstart;
    }


    /**
     * Set the value of Ismaterialstart
     *
     * @param v new value
     */
    public void setIsmaterialstart(int v) 
    {

        if (this.ismaterialstart != v)
        {
            this.ismaterialstart = v;
            setModified(true);
        }


    }

    /**
     * Get the Iscookiemapping
     *
     * @return int
     */
    public int getIscookiemapping()
    {
        return iscookiemapping;
    }


    /**
     * Set the value of Iscookiemapping
     *
     * @param v new value
     */
    public void setIscookiemapping(int v) 
    {

        if (this.iscookiemapping != v)
        {
            this.iscookiemapping = v;
            setModified(true);
        }


    }

    /**
     * Get the Isrtb
     *
     * @return int
     */
    public int getIsrtb()
    {
        return isrtb;
    }


    /**
     * Set the value of Isrtb
     *
     * @param v new value
     */
    public void setIsrtb(int v) 
    {

        if (this.isrtb != v)
        {
            this.isrtb = v;
            setModified(true);
        }


    }

    /**
     * Get the Ispass
     *
     * @return int
     */
    public int getIspass()
    {
        return ispass;
    }


    /**
     * Set the value of Ispass
     *
     * @param v new value
     */
    public void setIspass(int v) 
    {

        if (this.ispass != v)
        {
            this.ispass = v;
            setModified(true);
        }


    }

    /**
     * Get the Ischeckmaterial
     *
     * @return int
     */
    public int getIscheckmaterial()
    {
        return ischeckmaterial;
    }


    /**
     * Set the value of Ischeckmaterial
     *
     * @param v new value
     */
    public void setIscheckmaterial(int v) 
    {

        if (this.ischeckmaterial != v)
        {
            this.ischeckmaterial = v;
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
     * Get the Enjoyad
     *
     * @return int
     */
    public int getEnjoyad()
    {
        return enjoyad;
    }


    /**
     * Set the value of Enjoyad
     *
     * @param v new value
     */
    public void setEnjoyad(int v) 
    {

        if (this.enjoyad != v)
        {
            this.enjoyad = v;
            setModified(true);
        }


    }

    /**
     * Get the Isopenchannel
     *
     * @return int
     */
    public int getIsopenchannel()
    {
        return isopenchannel;
    }


    /**
     * Set the value of Isopenchannel
     *
     * @param v new value
     */
    public void setIsopenchannel(int v) 
    {

        if (this.isopenchannel != v)
        {
            this.isopenchannel = v;
            setModified(true);
        }


    }

    /**
     * Get the IsPdbReused
     *
     * @return int
     */
    public int getIsPdbReused()
    {
        return isPdbReused;
    }


    /**
     * Set the value of IsPdbReused
     *
     * @param v new value
     */
    public void setIsPdbReused(int v) 
    {

        if (this.isPdbReused != v)
        {
            this.isPdbReused = v;
            setModified(true);
        }


    }

    /**
     * Get the Alias
     *
     * @return String
     */
    public String getAlias()
    {
        return alias;
    }


    /**
     * Set the value of Alias
     *
     * @param v new value
     */
    public void setAlias(String v) 
    {

        if (!ObjectUtils.equals(this.alias, v))
        {
            this.alias = v;
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
            fieldNames.add("Dspname");
            fieldNames.add("Dsptoken");
            fieldNames.add("Cookiemappingurl");
            fieldNames.add("Bidurl");
            fieldNames.add("Winnoticeurl");
            fieldNames.add("Qps");
            fieldNames.add("Dspstart");
            fieldNames.add("Ismaterialstart");
            fieldNames.add("Iscookiemapping");
            fieldNames.add("Isrtb");
            fieldNames.add("Ispass");
            fieldNames.add("Ischeckmaterial");
            fieldNames.add("Description");
            fieldNames.add("Enjoyad");
            fieldNames.add("Isopenchannel");
            fieldNames.add("IsPdbReused");
            fieldNames.add("Alias");
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
        if (name.equals("Dspname"))
        {
            return getDspname();
        }
        if (name.equals("Dsptoken"))
        {
            return getDsptoken();
        }
        if (name.equals("Cookiemappingurl"))
        {
            return getCookiemappingurl();
        }
        if (name.equals("Bidurl"))
        {
            return getBidurl();
        }
        if (name.equals("Winnoticeurl"))
        {
            return getWinnoticeurl();
        }
        if (name.equals("Qps"))
        {
            return new Integer(getQps());
        }
        if (name.equals("Dspstart"))
        {
            return new Integer(getDspstart());
        }
        if (name.equals("Ismaterialstart"))
        {
            return new Integer(getIsmaterialstart());
        }
        if (name.equals("Iscookiemapping"))
        {
            return new Integer(getIscookiemapping());
        }
        if (name.equals("Isrtb"))
        {
            return new Integer(getIsrtb());
        }
        if (name.equals("Ispass"))
        {
            return new Integer(getIspass());
        }
        if (name.equals("Ischeckmaterial"))
        {
            return new Integer(getIscheckmaterial());
        }
        if (name.equals("Description"))
        {
            return getDescription();
        }
        if (name.equals("Enjoyad"))
        {
            return new Integer(getEnjoyad());
        }
        if (name.equals("Isopenchannel"))
        {
            return new Integer(getIsopenchannel());
        }
        if (name.equals("IsPdbReused"))
        {
            return new Integer(getIsPdbReused());
        }
        if (name.equals("Alias"))
        {
            return getAlias();
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
        if (name.equals("Dspname"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDspname((String) value);
            return true;
        }
        if (name.equals("Dsptoken"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDsptoken((String) value);
            return true;
        }
        if (name.equals("Cookiemappingurl"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCookiemappingurl((String) value);
            return true;
        }
        if (name.equals("Bidurl"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setBidurl((String) value);
            return true;
        }
        if (name.equals("Winnoticeurl"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setWinnoticeurl((String) value);
            return true;
        }
        if (name.equals("Qps"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setQps(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Dspstart"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDspstart(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Ismaterialstart"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsmaterialstart(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Iscookiemapping"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIscookiemapping(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Isrtb"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsrtb(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Ispass"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIspass(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Ischeckmaterial"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIscheckmaterial(((Integer) value).intValue());
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
        if (name.equals("Enjoyad"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setEnjoyad(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Isopenchannel"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsopenchannel(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IsPdbReused"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsPdbReused(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Alias"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setAlias((String) value);
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
        if (name.equals(YesDspPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(YesDspPeer.DSPNAME))
        {
            return getDspname();
        }
        if (name.equals(YesDspPeer.DSPTOKEN))
        {
            return getDsptoken();
        }
        if (name.equals(YesDspPeer.COOKIEMAPPINGURL))
        {
            return getCookiemappingurl();
        }
        if (name.equals(YesDspPeer.BIDURL))
        {
            return getBidurl();
        }
        if (name.equals(YesDspPeer.WINNOTICEURL))
        {
            return getWinnoticeurl();
        }
        if (name.equals(YesDspPeer.QPS))
        {
            return new Integer(getQps());
        }
        if (name.equals(YesDspPeer.DSPSTART))
        {
            return new Integer(getDspstart());
        }
        if (name.equals(YesDspPeer.ISMATERIALSTART))
        {
            return new Integer(getIsmaterialstart());
        }
        if (name.equals(YesDspPeer.ISCOOKIEMAPPING))
        {
            return new Integer(getIscookiemapping());
        }
        if (name.equals(YesDspPeer.ISRTB))
        {
            return new Integer(getIsrtb());
        }
        if (name.equals(YesDspPeer.ISPASS))
        {
            return new Integer(getIspass());
        }
        if (name.equals(YesDspPeer.ISCHECKMATERIAL))
        {
            return new Integer(getIscheckmaterial());
        }
        if (name.equals(YesDspPeer.DESCRIPTION))
        {
            return getDescription();
        }
        if (name.equals(YesDspPeer.ENJOYAD))
        {
            return new Integer(getEnjoyad());
        }
        if (name.equals(YesDspPeer.ISOPENCHANNEL))
        {
            return new Integer(getIsopenchannel());
        }
        if (name.equals(YesDspPeer.IS_PDB_REUSED))
        {
            return new Integer(getIsPdbReused());
        }
        if (name.equals(YesDspPeer.ALIAS))
        {
            return getAlias();
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
      if (YesDspPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (YesDspPeer.DSPNAME.equals(name))
        {
            return setByName("Dspname", value);
        }
      if (YesDspPeer.DSPTOKEN.equals(name))
        {
            return setByName("Dsptoken", value);
        }
      if (YesDspPeer.COOKIEMAPPINGURL.equals(name))
        {
            return setByName("Cookiemappingurl", value);
        }
      if (YesDspPeer.BIDURL.equals(name))
        {
            return setByName("Bidurl", value);
        }
      if (YesDspPeer.WINNOTICEURL.equals(name))
        {
            return setByName("Winnoticeurl", value);
        }
      if (YesDspPeer.QPS.equals(name))
        {
            return setByName("Qps", value);
        }
      if (YesDspPeer.DSPSTART.equals(name))
        {
            return setByName("Dspstart", value);
        }
      if (YesDspPeer.ISMATERIALSTART.equals(name))
        {
            return setByName("Ismaterialstart", value);
        }
      if (YesDspPeer.ISCOOKIEMAPPING.equals(name))
        {
            return setByName("Iscookiemapping", value);
        }
      if (YesDspPeer.ISRTB.equals(name))
        {
            return setByName("Isrtb", value);
        }
      if (YesDspPeer.ISPASS.equals(name))
        {
            return setByName("Ispass", value);
        }
      if (YesDspPeer.ISCHECKMATERIAL.equals(name))
        {
            return setByName("Ischeckmaterial", value);
        }
      if (YesDspPeer.DESCRIPTION.equals(name))
        {
            return setByName("Description", value);
        }
      if (YesDspPeer.ENJOYAD.equals(name))
        {
            return setByName("Enjoyad", value);
        }
      if (YesDspPeer.ISOPENCHANNEL.equals(name))
        {
            return setByName("Isopenchannel", value);
        }
      if (YesDspPeer.IS_PDB_REUSED.equals(name))
        {
            return setByName("IsPdbReused", value);
        }
      if (YesDspPeer.ALIAS.equals(name))
        {
            return setByName("Alias", value);
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
            return getDspname();
        }
        if (pos == 2)
        {
            return getDsptoken();
        }
        if (pos == 3)
        {
            return getCookiemappingurl();
        }
        if (pos == 4)
        {
            return getBidurl();
        }
        if (pos == 5)
        {
            return getWinnoticeurl();
        }
        if (pos == 6)
        {
            return new Integer(getQps());
        }
        if (pos == 7)
        {
            return new Integer(getDspstart());
        }
        if (pos == 8)
        {
            return new Integer(getIsmaterialstart());
        }
        if (pos == 9)
        {
            return new Integer(getIscookiemapping());
        }
        if (pos == 10)
        {
            return new Integer(getIsrtb());
        }
        if (pos == 11)
        {
            return new Integer(getIspass());
        }
        if (pos == 12)
        {
            return new Integer(getIscheckmaterial());
        }
        if (pos == 13)
        {
            return getDescription();
        }
        if (pos == 14)
        {
            return new Integer(getEnjoyad());
        }
        if (pos == 15)
        {
            return new Integer(getIsopenchannel());
        }
        if (pos == 16)
        {
            return new Integer(getIsPdbReused());
        }
        if (pos == 17)
        {
            return getAlias();
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
            return setByName("Dspname", value);
        }
    if (position == 2)
        {
            return setByName("Dsptoken", value);
        }
    if (position == 3)
        {
            return setByName("Cookiemappingurl", value);
        }
    if (position == 4)
        {
            return setByName("Bidurl", value);
        }
    if (position == 5)
        {
            return setByName("Winnoticeurl", value);
        }
    if (position == 6)
        {
            return setByName("Qps", value);
        }
    if (position == 7)
        {
            return setByName("Dspstart", value);
        }
    if (position == 8)
        {
            return setByName("Ismaterialstart", value);
        }
    if (position == 9)
        {
            return setByName("Iscookiemapping", value);
        }
    if (position == 10)
        {
            return setByName("Isrtb", value);
        }
    if (position == 11)
        {
            return setByName("Ispass", value);
        }
    if (position == 12)
        {
            return setByName("Ischeckmaterial", value);
        }
    if (position == 13)
        {
            return setByName("Description", value);
        }
    if (position == 14)
        {
            return setByName("Enjoyad", value);
        }
    if (position == 15)
        {
            return setByName("Isopenchannel", value);
        }
    if (position == 16)
        {
            return setByName("IsPdbReused", value);
        }
    if (position == 17)
        {
            return setByName("Alias", value);
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
        save(YesDspPeer.DATABASE_NAME);
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
                    YesDspPeer.doInsert((YesDsp) this, con);
                    setNew(false);
                }
                else
                {
                    YesDspPeer.doUpdate((YesDsp) this, con);
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
    public YesDsp copy() throws TorqueException
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
    public YesDsp copy(Connection con) throws TorqueException
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
    public YesDsp copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new YesDsp(), deepcopy);
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
    public YesDsp copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new YesDsp(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected YesDsp copyInto(YesDsp copyObj) throws TorqueException
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
    protected YesDsp copyInto(YesDsp copyObj, Connection con) throws TorqueException
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
    protected YesDsp copyInto(YesDsp copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setDspname(dspname);
        copyObj.setDsptoken(dsptoken);
        copyObj.setCookiemappingurl(cookiemappingurl);
        copyObj.setBidurl(bidurl);
        copyObj.setWinnoticeurl(winnoticeurl);
        copyObj.setQps(qps);
        copyObj.setDspstart(dspstart);
        copyObj.setIsmaterialstart(ismaterialstart);
        copyObj.setIscookiemapping(iscookiemapping);
        copyObj.setIsrtb(isrtb);
        copyObj.setIspass(ispass);
        copyObj.setIscheckmaterial(ischeckmaterial);
        copyObj.setDescription(description);
        copyObj.setEnjoyad(enjoyad);
        copyObj.setIsopenchannel(isopenchannel);
        copyObj.setIsPdbReused(isPdbReused);
        copyObj.setAlias(alias);

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
    protected YesDsp copyInto(YesDsp copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setDspname(dspname);
        copyObj.setDsptoken(dsptoken);
        copyObj.setCookiemappingurl(cookiemappingurl);
        copyObj.setBidurl(bidurl);
        copyObj.setWinnoticeurl(winnoticeurl);
        copyObj.setQps(qps);
        copyObj.setDspstart(dspstart);
        copyObj.setIsmaterialstart(ismaterialstart);
        copyObj.setIscookiemapping(iscookiemapping);
        copyObj.setIsrtb(isrtb);
        copyObj.setIspass(ispass);
        copyObj.setIscheckmaterial(ischeckmaterial);
        copyObj.setDescription(description);
        copyObj.setEnjoyad(enjoyad);
        copyObj.setIsopenchannel(isopenchannel);
        copyObj.setIsPdbReused(isPdbReused);
        copyObj.setAlias(alias);

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
    public YesDspPeer getPeer()
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
        return YesDspPeer.getTableMap();
    }

  
    /**
     * Creates a YesDspBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a YesDspBean with the contents of this object
     */
    public YesDspBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a YesDspBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a YesDspBean with the contents of this object
     */
    public YesDspBean getBean(IdentityMap createdBeans)
    {
        YesDspBean result = (YesDspBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new YesDspBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setDspname(getDspname());
        result.setDsptoken(getDsptoken());
        result.setCookiemappingurl(getCookiemappingurl());
        result.setBidurl(getBidurl());
        result.setWinnoticeurl(getWinnoticeurl());
        result.setQps(getQps());
        result.setDspstart(getDspstart());
        result.setIsmaterialstart(getIsmaterialstart());
        result.setIscookiemapping(getIscookiemapping());
        result.setIsrtb(getIsrtb());
        result.setIspass(getIspass());
        result.setIscheckmaterial(getIscheckmaterial());
        result.setDescription(getDescription());
        result.setEnjoyad(getEnjoyad());
        result.setIsopenchannel(getIsopenchannel());
        result.setIsPdbReused(getIsPdbReused());
        result.setAlias(getAlias());


        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of YesDsp with the contents
     * of a YesDspBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the YesDspBean which contents are used to create
     *        the resulting class
     * @return an instance of YesDsp with the contents of bean
     */
    public static YesDsp createYesDsp(YesDspBean bean)
        throws TorqueException
    {
        return createYesDsp(bean, new IdentityMap());
    }

    /**
     * Creates an instance of YesDsp with the contents
     * of a YesDspBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the YesDspBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of YesDsp with the contents of bean
     */

    public static YesDsp createYesDsp(YesDspBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        YesDsp result = (YesDsp) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new YesDsp();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setDspname(bean.getDspname());
        result.setDsptoken(bean.getDsptoken());
        result.setCookiemappingurl(bean.getCookiemappingurl());
        result.setBidurl(bean.getBidurl());
        result.setWinnoticeurl(bean.getWinnoticeurl());
        result.setQps(bean.getQps());
        result.setDspstart(bean.getDspstart());
        result.setIsmaterialstart(bean.getIsmaterialstart());
        result.setIscookiemapping(bean.getIscookiemapping());
        result.setIsrtb(bean.getIsrtb());
        result.setIspass(bean.getIspass());
        result.setIscheckmaterial(bean.getIscheckmaterial());
        result.setDescription(bean.getDescription());
        result.setEnjoyad(bean.getEnjoyad());
        result.setIsopenchannel(bean.getIsopenchannel());
        result.setIsPdbReused(bean.getIsPdbReused());
        result.setAlias(bean.getAlias());


    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("YesDsp:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Dspname = ")
           .append(getDspname())
           .append("\n");
        str.append("Dsptoken = ")
           .append(getDsptoken())
           .append("\n");
        str.append("Cookiemappingurl = ")
           .append(getCookiemappingurl())
           .append("\n");
        str.append("Bidurl = ")
           .append(getBidurl())
           .append("\n");
        str.append("Winnoticeurl = ")
           .append(getWinnoticeurl())
           .append("\n");
        str.append("Qps = ")
           .append(getQps())
           .append("\n");
        str.append("Dspstart = ")
           .append(getDspstart())
           .append("\n");
        str.append("Ismaterialstart = ")
           .append(getIsmaterialstart())
           .append("\n");
        str.append("Iscookiemapping = ")
           .append(getIscookiemapping())
           .append("\n");
        str.append("Isrtb = ")
           .append(getIsrtb())
           .append("\n");
        str.append("Ispass = ")
           .append(getIspass())
           .append("\n");
        str.append("Ischeckmaterial = ")
           .append(getIscheckmaterial())
           .append("\n");
        str.append("Description = ")
           .append(getDescription())
           .append("\n");
        str.append("Enjoyad = ")
           .append(getEnjoyad())
           .append("\n");
        str.append("Isopenchannel = ")
           .append(getIsopenchannel())
           .append("\n");
        str.append("IsPdbReused = ")
           .append(getIsPdbReused())
           .append("\n");
        str.append("Alias = ")
           .append(getAlias())
           .append("\n");
        return(str.toString());
    }
}
