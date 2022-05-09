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
import com.youku.atm.om.bean.IdeaUrlBean;
import com.youku.atm.om.bean.IdeaBean;

import com.youku.atm.om.bean.IdeaThumbnailBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to IdeaUrl
 */
public abstract class BaseIdeaUrl extends BaseObject
{
    /** The Peer class */
    private static final IdeaUrlPeer peer =
        new IdeaUrlPeer();


    /** The value for the id field */
    private int id;

    /** The value for the ideaId field */
    private int ideaId;

    /** The value for the site field */
    private int site;

    /** The value for the bt field */
    private int bt;

    /** The value for the type field */
    private int type;

    /** The value for the os field */
    private String os;

    /** The value for the content field */
    private String content;

    /** The value for the title field */
    private String title;

    /** The value for the text1 field */
    private String text1;

    /** The value for the text2 field */
    private String text2;

    /** The value for the ideaWidth field */
    private int ideaWidth;

    /** The value for the ideaHeight field */
    private int ideaHeight;

    /** The value for the skipTx field */
    private String skipTx;

    /** The value for the displayType field */
    private int displayType;

    /** The value for the iphonex field */
    private int iphonex;

    /** The value for the showtime field */
    private int showtime = 0;

    /** The value for the seq field */
    private int seq = 0;

    /** The value for the bitRate field */
    private String bitRate;

    /** The value for the volume field */
    private String volume;


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



        // update associated IdeaThumbnail
        if (collIdeaThumbnails != null)
        {
            for (int i = 0; i < collIdeaThumbnails.size(); i++)
            {
                ((IdeaThumbnail) collIdeaThumbnails.get(i))
                        .setIdeaUrlId(v);
            }
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
     * Get the Site
     *
     * @return int
     */
    public int getSite()
    {
        return site;
    }


    /**
     * Set the value of Site
     *
     * @param v new value
     */
    public void setSite(int v) 
    {

        if (this.site != v)
        {
            this.site = v;
            setModified(true);
        }


    }

    /**
     * Get the Bt
     *
     * @return int
     */
    public int getBt()
    {
        return bt;
    }


    /**
     * Set the value of Bt
     *
     * @param v new value
     */
    public void setBt(int v) 
    {

        if (this.bt != v)
        {
            this.bt = v;
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
     * Get the Os
     *
     * @return String
     */
    public String getOs()
    {
        return os;
    }


    /**
     * Set the value of Os
     *
     * @param v new value
     */
    public void setOs(String v) 
    {

        if (!ObjectUtils.equals(this.os, v))
        {
            this.os = v;
            setModified(true);
        }


    }

    /**
     * Get the Content
     *
     * @return String
     */
    public String getContent()
    {
        return content;
    }


    /**
     * Set the value of Content
     *
     * @param v new value
     */
    public void setContent(String v) 
    {

        if (!ObjectUtils.equals(this.content, v))
        {
            this.content = v;
            setModified(true);
        }


    }

    /**
     * Get the Title
     *
     * @return String
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * Set the value of Title
     *
     * @param v new value
     */
    public void setTitle(String v) 
    {

        if (!ObjectUtils.equals(this.title, v))
        {
            this.title = v;
            setModified(true);
        }


    }

    /**
     * Get the Text1
     *
     * @return String
     */
    public String getText1()
    {
        return text1;
    }


    /**
     * Set the value of Text1
     *
     * @param v new value
     */
    public void setText1(String v) 
    {

        if (!ObjectUtils.equals(this.text1, v))
        {
            this.text1 = v;
            setModified(true);
        }


    }

    /**
     * Get the Text2
     *
     * @return String
     */
    public String getText2()
    {
        return text2;
    }


    /**
     * Set the value of Text2
     *
     * @param v new value
     */
    public void setText2(String v) 
    {

        if (!ObjectUtils.equals(this.text2, v))
        {
            this.text2 = v;
            setModified(true);
        }


    }

    /**
     * Get the IdeaWidth
     *
     * @return int
     */
    public int getIdeaWidth()
    {
        return ideaWidth;
    }


    /**
     * Set the value of IdeaWidth
     *
     * @param v new value
     */
    public void setIdeaWidth(int v) 
    {

        if (this.ideaWidth != v)
        {
            this.ideaWidth = v;
            setModified(true);
        }


    }

    /**
     * Get the IdeaHeight
     *
     * @return int
     */
    public int getIdeaHeight()
    {
        return ideaHeight;
    }


    /**
     * Set the value of IdeaHeight
     *
     * @param v new value
     */
    public void setIdeaHeight(int v) 
    {

        if (this.ideaHeight != v)
        {
            this.ideaHeight = v;
            setModified(true);
        }


    }

    /**
     * Get the SkipTx
     *
     * @return String
     */
    public String getSkipTx()
    {
        return skipTx;
    }


    /**
     * Set the value of SkipTx
     *
     * @param v new value
     */
    public void setSkipTx(String v) 
    {

        if (!ObjectUtils.equals(this.skipTx, v))
        {
            this.skipTx = v;
            setModified(true);
        }


    }

    /**
     * Get the DisplayType
     *
     * @return int
     */
    public int getDisplayType()
    {
        return displayType;
    }


    /**
     * Set the value of DisplayType
     *
     * @param v new value
     */
    public void setDisplayType(int v) 
    {

        if (this.displayType != v)
        {
            this.displayType = v;
            setModified(true);
        }


    }

    /**
     * Get the Iphonex
     *
     * @return int
     */
    public int getIphonex()
    {
        return iphonex;
    }


    /**
     * Set the value of Iphonex
     *
     * @param v new value
     */
    public void setIphonex(int v) 
    {

        if (this.iphonex != v)
        {
            this.iphonex = v;
            setModified(true);
        }


    }

    /**
     * Get the Showtime
     *
     * @return int
     */
    public int getShowtime()
    {
        return showtime;
    }


    /**
     * Set the value of Showtime
     *
     * @param v new value
     */
    public void setShowtime(int v) 
    {

        if (this.showtime != v)
        {
            this.showtime = v;
            setModified(true);
        }


    }

    /**
     * Get the Seq
     *
     * @return int
     */
    public int getSeq()
    {
        return seq;
    }


    /**
     * Set the value of Seq
     *
     * @param v new value
     */
    public void setSeq(int v) 
    {

        if (this.seq != v)
        {
            this.seq = v;
            setModified(true);
        }


    }

    /**
     * Get the BitRate
     *
     * @return String
     */
    public String getBitRate()
    {
        return bitRate;
    }


    /**
     * Set the value of BitRate
     *
     * @param v new value
     */
    public void setBitRate(String v) 
    {

        if (!ObjectUtils.equals(this.bitRate, v))
        {
            this.bitRate = v;
            setModified(true);
        }


    }

    /**
     * Get the Volume
     *
     * @return String
     */
    public String getVolume()
    {
        return volume;
    }


    /**
     * Set the value of Volume
     *
     * @param v new value
     */
    public void setVolume(String v) 
    {

        if (!ObjectUtils.equals(this.volume, v))
        {
            this.volume = v;
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
   


    /**
     * Collection to store aggregation of collIdeaThumbnails
     */
    protected List<IdeaThumbnail> collIdeaThumbnails;

    /**
     * Temporary storage of collIdeaThumbnails to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initIdeaThumbnails()
    {
        if (collIdeaThumbnails == null)
        {
            collIdeaThumbnails = new ArrayList<IdeaThumbnail>();
        }
    }


    /**
     * Method called to associate a IdeaThumbnail object to this object
     * through the IdeaThumbnail foreign key attribute
     *
     * @param l IdeaThumbnail
     * @throws TorqueException
     */
    public void addIdeaThumbnail(IdeaThumbnail l) throws TorqueException
    {
        getIdeaThumbnails().add(l);
        l.setIdeaUrl((IdeaUrl) this);
    }

    /**
     * Method called to associate a IdeaThumbnail object to this object
     * through the IdeaThumbnail foreign key attribute using connection.
     *
     * @param l IdeaThumbnail
     * @throws TorqueException
     */
    public void addIdeaThumbnail(IdeaThumbnail l, Connection con) throws TorqueException
    {
        getIdeaThumbnails(con).add(l);
        l.setIdeaUrl((IdeaUrl) this);
    }

    /**
     * The criteria used to select the current contents of collIdeaThumbnails
     */
    private Criteria lastIdeaThumbnailsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaThumbnails(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<IdeaThumbnail> getIdeaThumbnails()
        throws TorqueException
    {
        if (collIdeaThumbnails == null)
        {
            collIdeaThumbnails = getIdeaThumbnails(new Criteria(10));
        }
        return collIdeaThumbnails;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this IdeaUrl has previously
     * been saved, it will retrieve related IdeaThumbnails from storage.
     * If this IdeaUrl is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<IdeaThumbnail> getIdeaThumbnails(Criteria criteria) throws TorqueException
    {
        if (collIdeaThumbnails == null)
        {
            if (isNew())
            {
               collIdeaThumbnails = new ArrayList<IdeaThumbnail>();
            }
            else
            {
                criteria.add(IdeaThumbnailPeer.IDEA_URL_ID, getId() );
                collIdeaThumbnails = IdeaThumbnailPeer.doSelect(criteria);
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
                criteria.add(IdeaThumbnailPeer.IDEA_URL_ID, getId());
                if (!lastIdeaThumbnailsCriteria.equals(criteria))
                {
                    collIdeaThumbnails = IdeaThumbnailPeer.doSelect(criteria);
                }
            }
        }
        lastIdeaThumbnailsCriteria = criteria;

        return collIdeaThumbnails;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getIdeaThumbnails(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaThumbnail> getIdeaThumbnails(Connection con) throws TorqueException
    {
        if (collIdeaThumbnails == null)
        {
            collIdeaThumbnails = getIdeaThumbnails(new Criteria(10), con);
        }
        return collIdeaThumbnails;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this IdeaUrl has previously
     * been saved, it will retrieve related IdeaThumbnails from storage.
     * If this IdeaUrl is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<IdeaThumbnail> getIdeaThumbnails(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collIdeaThumbnails == null)
        {
            if (isNew())
            {
               collIdeaThumbnails = new ArrayList<IdeaThumbnail>();
            }
            else
            {
                 criteria.add(IdeaThumbnailPeer.IDEA_URL_ID, getId());
                 collIdeaThumbnails = IdeaThumbnailPeer.doSelect(criteria, con);
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
                 criteria.add(IdeaThumbnailPeer.IDEA_URL_ID, getId());
                 if (!lastIdeaThumbnailsCriteria.equals(criteria))
                 {
                     collIdeaThumbnails = IdeaThumbnailPeer.doSelect(criteria, con);
                 }
             }
         }
         lastIdeaThumbnailsCriteria = criteria;

         return collIdeaThumbnails;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this IdeaUrl is new, it will return
     * an empty collection; or if this IdeaUrl has previously
     * been saved, it will retrieve related IdeaThumbnails from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in IdeaUrl.
     */
    protected List<IdeaThumbnail> getIdeaThumbnailsJoinIdeaUrl(Criteria criteria)
        throws TorqueException
    {
        if (collIdeaThumbnails == null)
        {
            if (isNew())
            {
               collIdeaThumbnails = new ArrayList<IdeaThumbnail>();
            }
            else
            {
                criteria.add(IdeaThumbnailPeer.IDEA_URL_ID, getId());
                collIdeaThumbnails = IdeaThumbnailPeer.doSelectJoinIdeaUrl(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(IdeaThumbnailPeer.IDEA_URL_ID, getId());
            if (!lastIdeaThumbnailsCriteria.equals(criteria))
            {
                collIdeaThumbnails = IdeaThumbnailPeer.doSelectJoinIdeaUrl(criteria);
            }
        }
        lastIdeaThumbnailsCriteria = criteria;

        return collIdeaThumbnails;
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
            fieldNames.add("Site");
            fieldNames.add("Bt");
            fieldNames.add("Type");
            fieldNames.add("Os");
            fieldNames.add("Content");
            fieldNames.add("Title");
            fieldNames.add("Text1");
            fieldNames.add("Text2");
            fieldNames.add("IdeaWidth");
            fieldNames.add("IdeaHeight");
            fieldNames.add("SkipTx");
            fieldNames.add("DisplayType");
            fieldNames.add("Iphonex");
            fieldNames.add("Showtime");
            fieldNames.add("Seq");
            fieldNames.add("BitRate");
            fieldNames.add("Volume");
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
        if (name.equals("Site"))
        {
            return new Integer(getSite());
        }
        if (name.equals("Bt"))
        {
            return new Integer(getBt());
        }
        if (name.equals("Type"))
        {
            return new Integer(getType());
        }
        if (name.equals("Os"))
        {
            return getOs();
        }
        if (name.equals("Content"))
        {
            return getContent();
        }
        if (name.equals("Title"))
        {
            return getTitle();
        }
        if (name.equals("Text1"))
        {
            return getText1();
        }
        if (name.equals("Text2"))
        {
            return getText2();
        }
        if (name.equals("IdeaWidth"))
        {
            return new Integer(getIdeaWidth());
        }
        if (name.equals("IdeaHeight"))
        {
            return new Integer(getIdeaHeight());
        }
        if (name.equals("SkipTx"))
        {
            return getSkipTx();
        }
        if (name.equals("DisplayType"))
        {
            return new Integer(getDisplayType());
        }
        if (name.equals("Iphonex"))
        {
            return new Integer(getIphonex());
        }
        if (name.equals("Showtime"))
        {
            return new Integer(getShowtime());
        }
        if (name.equals("Seq"))
        {
            return new Integer(getSeq());
        }
        if (name.equals("BitRate"))
        {
            return getBitRate();
        }
        if (name.equals("Volume"))
        {
            return getVolume();
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
        if (name.equals("Site"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSite(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Bt"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setBt(((Integer) value).intValue());
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
        if (name.equals("Os"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setOs((String) value);
            return true;
        }
        if (name.equals("Content"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setContent((String) value);
            return true;
        }
        if (name.equals("Title"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTitle((String) value);
            return true;
        }
        if (name.equals("Text1"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setText1((String) value);
            return true;
        }
        if (name.equals("Text2"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setText2((String) value);
            return true;
        }
        if (name.equals("IdeaWidth"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaWidth(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IdeaHeight"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaHeight(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SkipTx"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSkipTx((String) value);
            return true;
        }
        if (name.equals("DisplayType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDisplayType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Iphonex"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIphonex(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Showtime"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setShowtime(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Seq"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSeq(((Integer) value).intValue());
            return true;
        }
        if (name.equals("BitRate"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setBitRate((String) value);
            return true;
        }
        if (name.equals("Volume"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setVolume((String) value);
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
        if (name.equals(IdeaUrlPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(IdeaUrlPeer.IDEA_ID))
        {
            return new Integer(getIdeaId());
        }
        if (name.equals(IdeaUrlPeer.SITE))
        {
            return new Integer(getSite());
        }
        if (name.equals(IdeaUrlPeer.BT))
        {
            return new Integer(getBt());
        }
        if (name.equals(IdeaUrlPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(IdeaUrlPeer.OS))
        {
            return getOs();
        }
        if (name.equals(IdeaUrlPeer.CONTENT))
        {
            return getContent();
        }
        if (name.equals(IdeaUrlPeer.TITLE))
        {
            return getTitle();
        }
        if (name.equals(IdeaUrlPeer.TEXT1))
        {
            return getText1();
        }
        if (name.equals(IdeaUrlPeer.TEXT2))
        {
            return getText2();
        }
        if (name.equals(IdeaUrlPeer.IDEA_WIDTH))
        {
            return new Integer(getIdeaWidth());
        }
        if (name.equals(IdeaUrlPeer.IDEA_HEIGHT))
        {
            return new Integer(getIdeaHeight());
        }
        if (name.equals(IdeaUrlPeer.SKIP_TX))
        {
            return getSkipTx();
        }
        if (name.equals(IdeaUrlPeer.DISPLAY_TYPE))
        {
            return new Integer(getDisplayType());
        }
        if (name.equals(IdeaUrlPeer.IPHONEX))
        {
            return new Integer(getIphonex());
        }
        if (name.equals(IdeaUrlPeer.SHOWTIME))
        {
            return new Integer(getShowtime());
        }
        if (name.equals(IdeaUrlPeer.SEQ))
        {
            return new Integer(getSeq());
        }
        if (name.equals(IdeaUrlPeer.BIT_RATE))
        {
            return getBitRate();
        }
        if (name.equals(IdeaUrlPeer.VOLUME))
        {
            return getVolume();
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
      if (IdeaUrlPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (IdeaUrlPeer.IDEA_ID.equals(name))
        {
            return setByName("IdeaId", value);
        }
      if (IdeaUrlPeer.SITE.equals(name))
        {
            return setByName("Site", value);
        }
      if (IdeaUrlPeer.BT.equals(name))
        {
            return setByName("Bt", value);
        }
      if (IdeaUrlPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (IdeaUrlPeer.OS.equals(name))
        {
            return setByName("Os", value);
        }
      if (IdeaUrlPeer.CONTENT.equals(name))
        {
            return setByName("Content", value);
        }
      if (IdeaUrlPeer.TITLE.equals(name))
        {
            return setByName("Title", value);
        }
      if (IdeaUrlPeer.TEXT1.equals(name))
        {
            return setByName("Text1", value);
        }
      if (IdeaUrlPeer.TEXT2.equals(name))
        {
            return setByName("Text2", value);
        }
      if (IdeaUrlPeer.IDEA_WIDTH.equals(name))
        {
            return setByName("IdeaWidth", value);
        }
      if (IdeaUrlPeer.IDEA_HEIGHT.equals(name))
        {
            return setByName("IdeaHeight", value);
        }
      if (IdeaUrlPeer.SKIP_TX.equals(name))
        {
            return setByName("SkipTx", value);
        }
      if (IdeaUrlPeer.DISPLAY_TYPE.equals(name))
        {
            return setByName("DisplayType", value);
        }
      if (IdeaUrlPeer.IPHONEX.equals(name))
        {
            return setByName("Iphonex", value);
        }
      if (IdeaUrlPeer.SHOWTIME.equals(name))
        {
            return setByName("Showtime", value);
        }
      if (IdeaUrlPeer.SEQ.equals(name))
        {
            return setByName("Seq", value);
        }
      if (IdeaUrlPeer.BIT_RATE.equals(name))
        {
            return setByName("BitRate", value);
        }
      if (IdeaUrlPeer.VOLUME.equals(name))
        {
            return setByName("Volume", value);
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
            return new Integer(getSite());
        }
        if (pos == 3)
        {
            return new Integer(getBt());
        }
        if (pos == 4)
        {
            return new Integer(getType());
        }
        if (pos == 5)
        {
            return getOs();
        }
        if (pos == 6)
        {
            return getContent();
        }
        if (pos == 7)
        {
            return getTitle();
        }
        if (pos == 8)
        {
            return getText1();
        }
        if (pos == 9)
        {
            return getText2();
        }
        if (pos == 10)
        {
            return new Integer(getIdeaWidth());
        }
        if (pos == 11)
        {
            return new Integer(getIdeaHeight());
        }
        if (pos == 12)
        {
            return getSkipTx();
        }
        if (pos == 13)
        {
            return new Integer(getDisplayType());
        }
        if (pos == 14)
        {
            return new Integer(getIphonex());
        }
        if (pos == 15)
        {
            return new Integer(getShowtime());
        }
        if (pos == 16)
        {
            return new Integer(getSeq());
        }
        if (pos == 17)
        {
            return getBitRate();
        }
        if (pos == 18)
        {
            return getVolume();
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
            return setByName("Site", value);
        }
    if (position == 3)
        {
            return setByName("Bt", value);
        }
    if (position == 4)
        {
            return setByName("Type", value);
        }
    if (position == 5)
        {
            return setByName("Os", value);
        }
    if (position == 6)
        {
            return setByName("Content", value);
        }
    if (position == 7)
        {
            return setByName("Title", value);
        }
    if (position == 8)
        {
            return setByName("Text1", value);
        }
    if (position == 9)
        {
            return setByName("Text2", value);
        }
    if (position == 10)
        {
            return setByName("IdeaWidth", value);
        }
    if (position == 11)
        {
            return setByName("IdeaHeight", value);
        }
    if (position == 12)
        {
            return setByName("SkipTx", value);
        }
    if (position == 13)
        {
            return setByName("DisplayType", value);
        }
    if (position == 14)
        {
            return setByName("Iphonex", value);
        }
    if (position == 15)
        {
            return setByName("Showtime", value);
        }
    if (position == 16)
        {
            return setByName("Seq", value);
        }
    if (position == 17)
        {
            return setByName("BitRate", value);
        }
    if (position == 18)
        {
            return setByName("Volume", value);
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
        save(IdeaUrlPeer.DATABASE_NAME);
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
                    IdeaUrlPeer.doInsert((IdeaUrl) this, con);
                    setNew(false);
                }
                else
                {
                    IdeaUrlPeer.doUpdate((IdeaUrl) this, con);
                }
            }


            if (collIdeaThumbnails != null)
            {
                for (int i = 0; i < collIdeaThumbnails.size(); i++)
                {
                    ((IdeaThumbnail) collIdeaThumbnails.get(i)).save(con);
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
    public IdeaUrl copy() throws TorqueException
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
    public IdeaUrl copy(Connection con) throws TorqueException
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
    public IdeaUrl copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new IdeaUrl(), deepcopy);
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
    public IdeaUrl copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new IdeaUrl(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected IdeaUrl copyInto(IdeaUrl copyObj) throws TorqueException
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
    protected IdeaUrl copyInto(IdeaUrl copyObj, Connection con) throws TorqueException
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
    protected IdeaUrl copyInto(IdeaUrl copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setSite(site);
        copyObj.setBt(bt);
        copyObj.setType(type);
        copyObj.setOs(os);
        copyObj.setContent(content);
        copyObj.setTitle(title);
        copyObj.setText1(text1);
        copyObj.setText2(text2);
        copyObj.setIdeaWidth(ideaWidth);
        copyObj.setIdeaHeight(ideaHeight);
        copyObj.setSkipTx(skipTx);
        copyObj.setDisplayType(displayType);
        copyObj.setIphonex(iphonex);
        copyObj.setShowtime(showtime);
        copyObj.setSeq(seq);
        copyObj.setBitRate(bitRate);
        copyObj.setVolume(volume);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<IdeaThumbnail> vIdeaThumbnails = getIdeaThumbnails();
        if (vIdeaThumbnails != null)
        {
            for (int i = 0; i < vIdeaThumbnails.size(); i++)
            {
                IdeaThumbnail obj =  vIdeaThumbnails.get(i);
                copyObj.addIdeaThumbnail(obj.copy());
            }
        }
        else
        {
            copyObj.collIdeaThumbnails = null;
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
    protected IdeaUrl copyInto(IdeaUrl copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIdeaId(ideaId);
        copyObj.setSite(site);
        copyObj.setBt(bt);
        copyObj.setType(type);
        copyObj.setOs(os);
        copyObj.setContent(content);
        copyObj.setTitle(title);
        copyObj.setText1(text1);
        copyObj.setText2(text2);
        copyObj.setIdeaWidth(ideaWidth);
        copyObj.setIdeaHeight(ideaHeight);
        copyObj.setSkipTx(skipTx);
        copyObj.setDisplayType(displayType);
        copyObj.setIphonex(iphonex);
        copyObj.setShowtime(showtime);
        copyObj.setSeq(seq);
        copyObj.setBitRate(bitRate);
        copyObj.setVolume(volume);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<IdeaThumbnail> vIdeaThumbnails = getIdeaThumbnails(con);
        if (vIdeaThumbnails != null)
        {
            for (int i = 0; i < vIdeaThumbnails.size(); i++)
            {
                IdeaThumbnail obj =  vIdeaThumbnails.get(i);
                copyObj.addIdeaThumbnail(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collIdeaThumbnails = null;
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
    public IdeaUrlPeer getPeer()
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
        return IdeaUrlPeer.getTableMap();
    }

  
    /**
     * Creates a IdeaUrlBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a IdeaUrlBean with the contents of this object
     */
    public IdeaUrlBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a IdeaUrlBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a IdeaUrlBean with the contents of this object
     */
    public IdeaUrlBean getBean(IdentityMap createdBeans)
    {
        IdeaUrlBean result = (IdeaUrlBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new IdeaUrlBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setIdeaId(getIdeaId());
        result.setSite(getSite());
        result.setBt(getBt());
        result.setType(getType());
        result.setOs(getOs());
        result.setContent(getContent());
        result.setTitle(getTitle());
        result.setText1(getText1());
        result.setText2(getText2());
        result.setIdeaWidth(getIdeaWidth());
        result.setIdeaHeight(getIdeaHeight());
        result.setSkipTx(getSkipTx());
        result.setDisplayType(getDisplayType());
        result.setIphonex(getIphonex());
        result.setShowtime(getShowtime());
        result.setSeq(getSeq());
        result.setBitRate(getBitRate());
        result.setVolume(getVolume());



        if (collIdeaThumbnails != null)
        {
            List<IdeaThumbnailBean> relatedBeans = new ArrayList<IdeaThumbnailBean>(collIdeaThumbnails.size());
            for (Iterator<IdeaThumbnail> collIdeaThumbnailsIt = collIdeaThumbnails.iterator(); collIdeaThumbnailsIt.hasNext(); )
            {
                IdeaThumbnail related = (IdeaThumbnail) collIdeaThumbnailsIt.next();
                IdeaThumbnailBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setIdeaThumbnailBeans(relatedBeans);
        }




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
     * Creates an instance of IdeaUrl with the contents
     * of a IdeaUrlBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the IdeaUrlBean which contents are used to create
     *        the resulting class
     * @return an instance of IdeaUrl with the contents of bean
     */
    public static IdeaUrl createIdeaUrl(IdeaUrlBean bean)
        throws TorqueException
    {
        return createIdeaUrl(bean, new IdentityMap());
    }

    /**
     * Creates an instance of IdeaUrl with the contents
     * of a IdeaUrlBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the IdeaUrlBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of IdeaUrl with the contents of bean
     */

    public static IdeaUrl createIdeaUrl(IdeaUrlBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        IdeaUrl result = (IdeaUrl) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new IdeaUrl();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setIdeaId(bean.getIdeaId());
        result.setSite(bean.getSite());
        result.setBt(bean.getBt());
        result.setType(bean.getType());
        result.setOs(bean.getOs());
        result.setContent(bean.getContent());
        result.setTitle(bean.getTitle());
        result.setText1(bean.getText1());
        result.setText2(bean.getText2());
        result.setIdeaWidth(bean.getIdeaWidth());
        result.setIdeaHeight(bean.getIdeaHeight());
        result.setSkipTx(bean.getSkipTx());
        result.setDisplayType(bean.getDisplayType());
        result.setIphonex(bean.getIphonex());
        result.setShowtime(bean.getShowtime());
        result.setSeq(bean.getSeq());
        result.setBitRate(bean.getBitRate());
        result.setVolume(bean.getVolume());



        {
            List<IdeaThumbnailBean> relatedBeans = bean.getIdeaThumbnailBeans();
            if (relatedBeans != null)
            {
                for (Iterator<IdeaThumbnailBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    IdeaThumbnailBean relatedBean =  relatedBeansIt.next();
                    IdeaThumbnail related = IdeaThumbnail.createIdeaThumbnail(relatedBean, createdObjects);
                    result.addIdeaThumbnailFromBean(related);
                }
            }
        }




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



    /**
     * Method called to associate a IdeaThumbnail object to this object.
     * through the IdeaThumbnail foreign key attribute
     *
     * @param toAdd IdeaThumbnail
     */
    protected void addIdeaThumbnailFromBean(IdeaThumbnail toAdd)
    {
        initIdeaThumbnails();
        collIdeaThumbnails.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("IdeaUrl:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("IdeaId = ")
           .append(getIdeaId())
           .append("\n");
        str.append("Site = ")
           .append(getSite())
           .append("\n");
        str.append("Bt = ")
           .append(getBt())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("Os = ")
           .append(getOs())
           .append("\n");
        str.append("Content = ")
           .append(getContent())
           .append("\n");
        str.append("Title = ")
           .append(getTitle())
           .append("\n");
        str.append("Text1 = ")
           .append(getText1())
           .append("\n");
        str.append("Text2 = ")
           .append(getText2())
           .append("\n");
        str.append("IdeaWidth = ")
           .append(getIdeaWidth())
           .append("\n");
        str.append("IdeaHeight = ")
           .append(getIdeaHeight())
           .append("\n");
        str.append("SkipTx = ")
           .append(getSkipTx())
           .append("\n");
        str.append("DisplayType = ")
           .append(getDisplayType())
           .append("\n");
        str.append("Iphonex = ")
           .append(getIphonex())
           .append("\n");
        str.append("Showtime = ")
           .append(getShowtime())
           .append("\n");
        str.append("Seq = ")
           .append(getSeq())
           .append("\n");
        str.append("BitRate = ")
           .append(getBitRate())
           .append("\n");
        str.append("Volume = ")
           .append(getVolume())
           .append("\n");
        return(str.toString());
    }
}
