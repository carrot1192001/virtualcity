
package com.youku.atm.om.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to AdCastBean
 */
public abstract class BaseAdCastBean
    implements Serializable
{

    /**
     * whether the bean or its underlying object has changed
     * since last reading from the database
     */
    private boolean modified = true;

    /**
     * false if the underlying object has been read from the database,
     * true otherwise
     */
    private boolean isNew = true;


    /** The value for the id field */
    private int id;

    /** The value for the orderId field */
    private int orderId;

    /** The value for the customerId field */
    private int customerId;

    /** The value for the productId field */
    private int productId;

    /** The value for the name field */
    private String name;

    /** The value for the adTypeId field */
    private int adTypeId;

    /** The value for the directWay field */
    private String directWay;

    /** The value for the castWay field */
    private String castWay;

    /** The value for the interactEffect field */
    private int interactEffect;

    /** The value for the isCopyright field */
    private int isCopyright = 0;

    /** The value for the price field */
    private double price = 0;

    /** The value for the speedType field */
    private int speedType = 0;

    /** The value for the typePriority field */
    private int typePriority;

    /** The value for the productPriority field */
    private int productPriority;

    /** The value for the vipPriority field */
    private int vipPriority;

    /** The value for the orderPriority field */
    private int orderPriority;

    /** The value for the customPriority field */
    private int customPriority;

    /** The value for the customNumPriority field */
    private int customNumPriority;

    /** The value for the campPriority field */
    private int campPriority;

    /** The value for the areaPriority field */
    private int areaPriority;

    /** The value for the channelPriority field */
    private int channelPriority;

    /** The value for the platformPriority field */
    private int platformPriority;

    /** The value for the userPriority field */
    private int userPriority;

    /** The value for the keywordPriority field */
    private int keywordPriority;

    /** The value for the videogroupPriority field */
    private int videogroupPriority;

    /** The value for the roPriority field */
    private int roPriority;

    /** The value for the sowType field */
    private int sowType = 0;

    /** The value for the rateM field */
    private int rateM = 0;

    /** The value for the rates field */
    private int rates = 100;

    /** The value for the threshold field */
    private double threshold = 0;

    /** The value for the rtbType field */
    private int rtbType = 0;

    /** The value for the updateTime field */
    private Date updateTime;

    /** The value for the startDate field */
    private Date startDate;

    /** The value for the endDate field */
    private Date endDate;

    /** The value for the rtbid field */
    private int rtbid = 0;

    /** The value for the ideaShowType field */
    private int ideaShowType;

    /** The value for the mainCastId field */
    private int mainCastId = 0;

    /** The value for the isBak field */
    private int isBak = 0;

    /** The value for the dspId field */
    private String dspId = "0";

    /** The value for the dealId field */
    private String dealId = "0";

    /** The value for the skipTime field */
    private int skipTime = 0;

    /** The value for the directType field */
    private int directType = 0;

    /** The value for the pdbType field */
    private int pdbType = 0;

    /** The value for the dangerIpWeight field */
    private int dangerIpWeight = 0;

    /** The value for the chargeType field */
    private int chargeType = 0;

    /** The value for the isAiidTa field */
    private int isAiidTa = 0;

    /** The value for the status field */
    private int status = 1;

    /** The value for the mutex field */
    private int mutex = 0;

    /** The value for the chargeTime field */
    private int chargeTime = 0;

    /** The value for the resourceType field */
    private String resourceType = "";

    /** The value for the outside field */
    private int outside = 0;

    /** The value for the pbak field */
    private int pbak = 0;

    /** The value for the isArea field */
    private int isArea = 0;


    /**
     * sets whether the bean exists in the database
     */
    public void setNew(boolean isNew)
    {
        this.isNew = isNew;
    }

    /**
     * returns whether the bean exists in the database
     */
    public boolean isNew()
    {
        return this.isNew;
    }

    /**
     * sets whether the bean or the object it was created from
     * was modified since the object was last read from the database
     */
    public void setModified(boolean isModified)
    {
        this.modified = isModified;
    }

    /**
     * returns whether the bean or the object it was created from
     * was modified since the object was last read from the database
     */
    public boolean isModified()
    {
        return this.modified;
    }


    /**
     * Get the Id
     *
     * @return int
     */
    public int getId ()
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

        this.id = v;
        setModified(true);

    }

    /**
     * Get the OrderId
     *
     * @return int
     */
    public int getOrderId ()
    {
        return orderId;
    }

    /**
     * Set the value of OrderId
     *
     * @param v new value
     */
    public void setOrderId(int v)
    {

        this.orderId = v;
        setModified(true);

    }

    /**
     * Get the CustomerId
     *
     * @return int
     */
    public int getCustomerId ()
    {
        return customerId;
    }

    /**
     * Set the value of CustomerId
     *
     * @param v new value
     */
    public void setCustomerId(int v)
    {

        this.customerId = v;
        setModified(true);

    }

    /**
     * Get the ProductId
     *
     * @return int
     */
    public int getProductId ()
    {
        return productId;
    }

    /**
     * Set the value of ProductId
     *
     * @param v new value
     */
    public void setProductId(int v)
    {

        this.productId = v;
        setModified(true);

    }

    /**
     * Get the Name
     *
     * @return String
     */
    public String getName ()
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

        this.name = v;
        setModified(true);

    }

    /**
     * Get the AdTypeId
     *
     * @return int
     */
    public int getAdTypeId ()
    {
        return adTypeId;
    }

    /**
     * Set the value of AdTypeId
     *
     * @param v new value
     */
    public void setAdTypeId(int v)
    {

        this.adTypeId = v;
        setModified(true);

    }

    /**
     * Get the DirectWay
     *
     * @return String
     */
    public String getDirectWay ()
    {
        return directWay;
    }

    /**
     * Set the value of DirectWay
     *
     * @param v new value
     */
    public void setDirectWay(String v)
    {

        this.directWay = v;
        setModified(true);

    }

    /**
     * Get the CastWay
     *
     * @return String
     */
    public String getCastWay ()
    {
        return castWay;
    }

    /**
     * Set the value of CastWay
     *
     * @param v new value
     */
    public void setCastWay(String v)
    {

        this.castWay = v;
        setModified(true);

    }

    /**
     * Get the InteractEffect
     *
     * @return int
     */
    public int getInteractEffect ()
    {
        return interactEffect;
    }

    /**
     * Set the value of InteractEffect
     *
     * @param v new value
     */
    public void setInteractEffect(int v)
    {

        this.interactEffect = v;
        setModified(true);

    }

    /**
     * Get the IsCopyright
     *
     * @return int
     */
    public int getIsCopyright ()
    {
        return isCopyright;
    }

    /**
     * Set the value of IsCopyright
     *
     * @param v new value
     */
    public void setIsCopyright(int v)
    {

        this.isCopyright = v;
        setModified(true);

    }

    /**
     * Get the Price
     *
     * @return double
     */
    public double getPrice ()
    {
        return price;
    }

    /**
     * Set the value of Price
     *
     * @param v new value
     */
    public void setPrice(double v)
    {

        this.price = v;
        setModified(true);

    }

    /**
     * Get the SpeedType
     *
     * @return int
     */
    public int getSpeedType ()
    {
        return speedType;
    }

    /**
     * Set the value of SpeedType
     *
     * @param v new value
     */
    public void setSpeedType(int v)
    {

        this.speedType = v;
        setModified(true);

    }

    /**
     * Get the TypePriority
     *
     * @return int
     */
    public int getTypePriority ()
    {
        return typePriority;
    }

    /**
     * Set the value of TypePriority
     *
     * @param v new value
     */
    public void setTypePriority(int v)
    {

        this.typePriority = v;
        setModified(true);

    }

    /**
     * Get the ProductPriority
     *
     * @return int
     */
    public int getProductPriority ()
    {
        return productPriority;
    }

    /**
     * Set the value of ProductPriority
     *
     * @param v new value
     */
    public void setProductPriority(int v)
    {

        this.productPriority = v;
        setModified(true);

    }

    /**
     * Get the VipPriority
     *
     * @return int
     */
    public int getVipPriority ()
    {
        return vipPriority;
    }

    /**
     * Set the value of VipPriority
     *
     * @param v new value
     */
    public void setVipPriority(int v)
    {

        this.vipPriority = v;
        setModified(true);

    }

    /**
     * Get the OrderPriority
     *
     * @return int
     */
    public int getOrderPriority ()
    {
        return orderPriority;
    }

    /**
     * Set the value of OrderPriority
     *
     * @param v new value
     */
    public void setOrderPriority(int v)
    {

        this.orderPriority = v;
        setModified(true);

    }

    /**
     * Get the CustomPriority
     *
     * @return int
     */
    public int getCustomPriority ()
    {
        return customPriority;
    }

    /**
     * Set the value of CustomPriority
     *
     * @param v new value
     */
    public void setCustomPriority(int v)
    {

        this.customPriority = v;
        setModified(true);

    }

    /**
     * Get the CustomNumPriority
     *
     * @return int
     */
    public int getCustomNumPriority ()
    {
        return customNumPriority;
    }

    /**
     * Set the value of CustomNumPriority
     *
     * @param v new value
     */
    public void setCustomNumPriority(int v)
    {

        this.customNumPriority = v;
        setModified(true);

    }

    /**
     * Get the CampPriority
     *
     * @return int
     */
    public int getCampPriority ()
    {
        return campPriority;
    }

    /**
     * Set the value of CampPriority
     *
     * @param v new value
     */
    public void setCampPriority(int v)
    {

        this.campPriority = v;
        setModified(true);

    }

    /**
     * Get the AreaPriority
     *
     * @return int
     */
    public int getAreaPriority ()
    {
        return areaPriority;
    }

    /**
     * Set the value of AreaPriority
     *
     * @param v new value
     */
    public void setAreaPriority(int v)
    {

        this.areaPriority = v;
        setModified(true);

    }

    /**
     * Get the ChannelPriority
     *
     * @return int
     */
    public int getChannelPriority ()
    {
        return channelPriority;
    }

    /**
     * Set the value of ChannelPriority
     *
     * @param v new value
     */
    public void setChannelPriority(int v)
    {

        this.channelPriority = v;
        setModified(true);

    }

    /**
     * Get the PlatformPriority
     *
     * @return int
     */
    public int getPlatformPriority ()
    {
        return platformPriority;
    }

    /**
     * Set the value of PlatformPriority
     *
     * @param v new value
     */
    public void setPlatformPriority(int v)
    {

        this.platformPriority = v;
        setModified(true);

    }

    /**
     * Get the UserPriority
     *
     * @return int
     */
    public int getUserPriority ()
    {
        return userPriority;
    }

    /**
     * Set the value of UserPriority
     *
     * @param v new value
     */
    public void setUserPriority(int v)
    {

        this.userPriority = v;
        setModified(true);

    }

    /**
     * Get the KeywordPriority
     *
     * @return int
     */
    public int getKeywordPriority ()
    {
        return keywordPriority;
    }

    /**
     * Set the value of KeywordPriority
     *
     * @param v new value
     */
    public void setKeywordPriority(int v)
    {

        this.keywordPriority = v;
        setModified(true);

    }

    /**
     * Get the VideogroupPriority
     *
     * @return int
     */
    public int getVideogroupPriority ()
    {
        return videogroupPriority;
    }

    /**
     * Set the value of VideogroupPriority
     *
     * @param v new value
     */
    public void setVideogroupPriority(int v)
    {

        this.videogroupPriority = v;
        setModified(true);

    }

    /**
     * Get the RoPriority
     *
     * @return int
     */
    public int getRoPriority ()
    {
        return roPriority;
    }

    /**
     * Set the value of RoPriority
     *
     * @param v new value
     */
    public void setRoPriority(int v)
    {

        this.roPriority = v;
        setModified(true);

    }

    /**
     * Get the SowType
     *
     * @return int
     */
    public int getSowType ()
    {
        return sowType;
    }

    /**
     * Set the value of SowType
     *
     * @param v new value
     */
    public void setSowType(int v)
    {

        this.sowType = v;
        setModified(true);

    }

    /**
     * Get the RateM
     *
     * @return int
     */
    public int getRateM ()
    {
        return rateM;
    }

    /**
     * Set the value of RateM
     *
     * @param v new value
     */
    public void setRateM(int v)
    {

        this.rateM = v;
        setModified(true);

    }

    /**
     * Get the Rates
     *
     * @return int
     */
    public int getRates ()
    {
        return rates;
    }

    /**
     * Set the value of Rates
     *
     * @param v new value
     */
    public void setRates(int v)
    {

        this.rates = v;
        setModified(true);

    }

    /**
     * Get the Threshold
     *
     * @return double
     */
    public double getThreshold ()
    {
        return threshold;
    }

    /**
     * Set the value of Threshold
     *
     * @param v new value
     */
    public void setThreshold(double v)
    {

        this.threshold = v;
        setModified(true);

    }

    /**
     * Get the RtbType
     *
     * @return int
     */
    public int getRtbType ()
    {
        return rtbType;
    }

    /**
     * Set the value of RtbType
     *
     * @param v new value
     */
    public void setRtbType(int v)
    {

        this.rtbType = v;
        setModified(true);

    }

    /**
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime ()
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

        this.updateTime = v;
        setModified(true);

    }

    /**
     * Get the StartDate
     *
     * @return Date
     */
    public Date getStartDate ()
    {
        return startDate;
    }

    /**
     * Set the value of StartDate
     *
     * @param v new value
     */
    public void setStartDate(Date v)
    {

        this.startDate = v;
        setModified(true);

    }

    /**
     * Get the EndDate
     *
     * @return Date
     */
    public Date getEndDate ()
    {
        return endDate;
    }

    /**
     * Set the value of EndDate
     *
     * @param v new value
     */
    public void setEndDate(Date v)
    {

        this.endDate = v;
        setModified(true);

    }

    /**
     * Get the Rtbid
     *
     * @return int
     */
    public int getRtbid ()
    {
        return rtbid;
    }

    /**
     * Set the value of Rtbid
     *
     * @param v new value
     */
    public void setRtbid(int v)
    {

        this.rtbid = v;
        setModified(true);

    }

    /**
     * Get the IdeaShowType
     *
     * @return int
     */
    public int getIdeaShowType ()
    {
        return ideaShowType;
    }

    /**
     * Set the value of IdeaShowType
     *
     * @param v new value
     */
    public void setIdeaShowType(int v)
    {

        this.ideaShowType = v;
        setModified(true);

    }

    /**
     * Get the MainCastId
     *
     * @return int
     */
    public int getMainCastId ()
    {
        return mainCastId;
    }

    /**
     * Set the value of MainCastId
     *
     * @param v new value
     */
    public void setMainCastId(int v)
    {

        this.mainCastId = v;
        setModified(true);

    }

    /**
     * Get the IsBak
     *
     * @return int
     */
    public int getIsBak ()
    {
        return isBak;
    }

    /**
     * Set the value of IsBak
     *
     * @param v new value
     */
    public void setIsBak(int v)
    {

        this.isBak = v;
        setModified(true);

    }

    /**
     * Get the DspId
     *
     * @return String
     */
    public String getDspId ()
    {
        return dspId;
    }

    /**
     * Set the value of DspId
     *
     * @param v new value
     */
    public void setDspId(String v)
    {

        this.dspId = v;
        setModified(true);

    }

    /**
     * Get the DealId
     *
     * @return String
     */
    public String getDealId ()
    {
        return dealId;
    }

    /**
     * Set the value of DealId
     *
     * @param v new value
     */
    public void setDealId(String v)
    {

        this.dealId = v;
        setModified(true);

    }

    /**
     * Get the SkipTime
     *
     * @return int
     */
    public int getSkipTime ()
    {
        return skipTime;
    }

    /**
     * Set the value of SkipTime
     *
     * @param v new value
     */
    public void setSkipTime(int v)
    {

        this.skipTime = v;
        setModified(true);

    }

    /**
     * Get the DirectType
     *
     * @return int
     */
    public int getDirectType ()
    {
        return directType;
    }

    /**
     * Set the value of DirectType
     *
     * @param v new value
     */
    public void setDirectType(int v)
    {

        this.directType = v;
        setModified(true);

    }

    /**
     * Get the PdbType
     *
     * @return int
     */
    public int getPdbType ()
    {
        return pdbType;
    }

    /**
     * Set the value of PdbType
     *
     * @param v new value
     */
    public void setPdbType(int v)
    {

        this.pdbType = v;
        setModified(true);

    }

    /**
     * Get the DangerIpWeight
     *
     * @return int
     */
    public int getDangerIpWeight ()
    {
        return dangerIpWeight;
    }

    /**
     * Set the value of DangerIpWeight
     *
     * @param v new value
     */
    public void setDangerIpWeight(int v)
    {

        this.dangerIpWeight = v;
        setModified(true);

    }

    /**
     * Get the ChargeType
     *
     * @return int
     */
    public int getChargeType ()
    {
        return chargeType;
    }

    /**
     * Set the value of ChargeType
     *
     * @param v new value
     */
    public void setChargeType(int v)
    {

        this.chargeType = v;
        setModified(true);

    }

    /**
     * Get the IsAiidTa
     *
     * @return int
     */
    public int getIsAiidTa ()
    {
        return isAiidTa;
    }

    /**
     * Set the value of IsAiidTa
     *
     * @param v new value
     */
    public void setIsAiidTa(int v)
    {

        this.isAiidTa = v;
        setModified(true);

    }

    /**
     * Get the Status
     *
     * @return int
     */
    public int getStatus ()
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

        this.status = v;
        setModified(true);

    }

    /**
     * Get the Mutex
     *
     * @return int
     */
    public int getMutex ()
    {
        return mutex;
    }

    /**
     * Set the value of Mutex
     *
     * @param v new value
     */
    public void setMutex(int v)
    {

        this.mutex = v;
        setModified(true);

    }

    /**
     * Get the ChargeTime
     *
     * @return int
     */
    public int getChargeTime ()
    {
        return chargeTime;
    }

    /**
     * Set the value of ChargeTime
     *
     * @param v new value
     */
    public void setChargeTime(int v)
    {

        this.chargeTime = v;
        setModified(true);

    }

    /**
     * Get the ResourceType
     *
     * @return String
     */
    public String getResourceType ()
    {
        return resourceType;
    }

    /**
     * Set the value of ResourceType
     *
     * @param v new value
     */
    public void setResourceType(String v)
    {

        this.resourceType = v;
        setModified(true);

    }

    /**
     * Get the Outside
     *
     * @return int
     */
    public int getOutside ()
    {
        return outside;
    }

    /**
     * Set the value of Outside
     *
     * @param v new value
     */
    public void setOutside(int v)
    {

        this.outside = v;
        setModified(true);

    }

    /**
     * Get the Pbak
     *
     * @return int
     */
    public int getPbak ()
    {
        return pbak;
    }

    /**
     * Set the value of Pbak
     *
     * @param v new value
     */
    public void setPbak(int v)
    {

        this.pbak = v;
        setModified(true);

    }

    /**
     * Get the IsArea
     *
     * @return int
     */
    public int getIsArea ()
    {
        return isArea;
    }

    /**
     * Set the value of IsArea
     *
     * @param v new value
     */
    public void setIsArea(int v)
    {

        this.isArea = v;
        setModified(true);

    }

    



    private AdTypeBean aAdTypeBean;

    /**
     * sets an associated AdTypeBean object
     *
     * @param v AdTypeBean
     */
    public void setAdTypeBean(AdTypeBean v)
    {
        if (v == null)
        {
            setAdTypeId( 0);
        }
        else
        {
            setAdTypeId(v.getId());
        }
        aAdTypeBean = v;
    }


    /**
     * Get the associated AdTypeBean object
     *
     * @return the associated AdTypeBean object
     */
    public AdTypeBean getAdTypeBean()
    {
        return aAdTypeBean;
    }





    private AdOrderBean aAdOrderBean;

    /**
     * sets an associated AdOrderBean object
     *
     * @param v AdOrderBean
     */
    public void setAdOrderBean(AdOrderBean v)
    {
        if (v == null)
        {
            setOrderId( 0);
        }
        else
        {
            setOrderId(v.getId());
        }
        aAdOrderBean = v;
    }


    /**
     * Get the associated AdOrderBean object
     *
     * @return the associated AdOrderBean object
     */
    public AdOrderBean getAdOrderBean()
    {
        return aAdOrderBean;
    }





    /**
     * Collection to store aggregation of collCastChannelBeans
     */
    protected List<CastChannelBean> collCastChannelBeans;

    /**
     * Returns the collection of CastChannelBeans
     */
    public List<CastChannelBean> getCastChannelBeans()
    {
        return collCastChannelBeans;
    }

    /**
     * Sets the collection of CastChannelBeans to the specified value
     */
    public void setCastChannelBeans(List<CastChannelBean> list)
    {
        if (list == null)
        {
            collCastChannelBeans = null;
        }
        else
        {
            collCastChannelBeans = new ArrayList<CastChannelBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastAreaBeans
     */
    protected List<CastAreaBean> collCastAreaBeans;

    /**
     * Returns the collection of CastAreaBeans
     */
    public List<CastAreaBean> getCastAreaBeans()
    {
        return collCastAreaBeans;
    }

    /**
     * Sets the collection of CastAreaBeans to the specified value
     */
    public void setCastAreaBeans(List<CastAreaBean> list)
    {
        if (list == null)
        {
            collCastAreaBeans = null;
        }
        else
        {
            collCastAreaBeans = new ArrayList<CastAreaBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastPlatformBeans
     */
    protected List<CastPlatformBean> collCastPlatformBeans;

    /**
     * Returns the collection of CastPlatformBeans
     */
    public List<CastPlatformBean> getCastPlatformBeans()
    {
        return collCastPlatformBeans;
    }

    /**
     * Sets the collection of CastPlatformBeans to the specified value
     */
    public void setCastPlatformBeans(List<CastPlatformBean> list)
    {
        if (list == null)
        {
            collCastPlatformBeans = null;
        }
        else
        {
            collCastPlatformBeans = new ArrayList<CastPlatformBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastPositionBeans
     */
    protected List<CastPositionBean> collCastPositionBeans;

    /**
     * Returns the collection of CastPositionBeans
     */
    public List<CastPositionBean> getCastPositionBeans()
    {
        return collCastPositionBeans;
    }

    /**
     * Sets the collection of CastPositionBeans to the specified value
     */
    public void setCastPositionBeans(List<CastPositionBean> list)
    {
        if (list == null)
        {
            collCastPositionBeans = null;
        }
        else
        {
            collCastPositionBeans = new ArrayList<CastPositionBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastHpositionBeans
     */
    protected List<CastHpositionBean> collCastHpositionBeans;

    /**
     * Returns the collection of CastHpositionBeans
     */
    public List<CastHpositionBean> getCastHpositionBeans()
    {
        return collCastHpositionBeans;
    }

    /**
     * Sets the collection of CastHpositionBeans to the specified value
     */
    public void setCastHpositionBeans(List<CastHpositionBean> list)
    {
        if (list == null)
        {
            collCastHpositionBeans = null;
        }
        else
        {
            collCastHpositionBeans = new ArrayList<CastHpositionBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastVideogroupBeans
     */
    protected List<CastVideogroupBean> collCastVideogroupBeans;

    /**
     * Returns the collection of CastVideogroupBeans
     */
    public List<CastVideogroupBean> getCastVideogroupBeans()
    {
        return collCastVideogroupBeans;
    }

    /**
     * Sets the collection of CastVideogroupBeans to the specified value
     */
    public void setCastVideogroupBeans(List<CastVideogroupBean> list)
    {
        if (list == null)
        {
            collCastVideogroupBeans = null;
        }
        else
        {
            collCastVideogroupBeans = new ArrayList<CastVideogroupBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastKeyBeans
     */
    protected List<CastKeyBean> collCastKeyBeans;

    /**
     * Returns the collection of CastKeyBeans
     */
    public List<CastKeyBean> getCastKeyBeans()
    {
        return collCastKeyBeans;
    }

    /**
     * Sets the collection of CastKeyBeans to the specified value
     */
    public void setCastKeyBeans(List<CastKeyBean> list)
    {
        if (list == null)
        {
            collCastKeyBeans = null;
        }
        else
        {
            collCastKeyBeans = new ArrayList<CastKeyBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastUserBeans
     */
    protected List<CastUserBean> collCastUserBeans;

    /**
     * Returns the collection of CastUserBeans
     */
    public List<CastUserBean> getCastUserBeans()
    {
        return collCastUserBeans;
    }

    /**
     * Sets the collection of CastUserBeans to the specified value
     */
    public void setCastUserBeans(List<CastUserBean> list)
    {
        if (list == null)
        {
            collCastUserBeans = null;
        }
        else
        {
            collCastUserBeans = new ArrayList<CastUserBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastPartneridBeans
     */
    protected List<CastPartneridBean> collCastPartneridBeans;

    /**
     * Returns the collection of CastPartneridBeans
     */
    public List<CastPartneridBean> getCastPartneridBeans()
    {
        return collCastPartneridBeans;
    }

    /**
     * Sets the collection of CastPartneridBeans to the specified value
     */
    public void setCastPartneridBeans(List<CastPartneridBean> list)
    {
        if (list == null)
        {
            collCastPartneridBeans = null;
        }
        else
        {
            collCastPartneridBeans = new ArrayList<CastPartneridBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastPidBeans
     */
    protected List<CastPidBean> collCastPidBeans;

    /**
     * Returns the collection of CastPidBeans
     */
    public List<CastPidBean> getCastPidBeans()
    {
        return collCastPidBeans;
    }

    /**
     * Sets the collection of CastPidBeans to the specified value
     */
    public void setCastPidBeans(List<CastPidBean> list)
    {
        if (list == null)
        {
            collCastPidBeans = null;
        }
        else
        {
            collCastPidBeans = new ArrayList<CastPidBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastDqBeans
     */
    protected List<CastDqBean> collCastDqBeans;

    /**
     * Returns the collection of CastDqBeans
     */
    public List<CastDqBean> getCastDqBeans()
    {
        return collCastDqBeans;
    }

    /**
     * Sets the collection of CastDqBeans to the specified value
     */
    public void setCastDqBeans(List<CastDqBean> list)
    {
        if (list == null)
        {
            collCastDqBeans = null;
        }
        else
        {
            collCastDqBeans = new ArrayList<CastDqBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastCampaignBeans
     */
    protected List<CastCampaignBean> collCastCampaignBeans;

    /**
     * Returns the collection of CastCampaignBeans
     */
    public List<CastCampaignBean> getCastCampaignBeans()
    {
        return collCastCampaignBeans;
    }

    /**
     * Sets the collection of CastCampaignBeans to the specified value
     */
    public void setCastCampaignBeans(List<CastCampaignBean> list)
    {
        if (list == null)
        {
            collCastCampaignBeans = null;
        }
        else
        {
            collCastCampaignBeans = new ArrayList<CastCampaignBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastPaidBeans
     */
    protected List<CastPaidBean> collCastPaidBeans;

    /**
     * Returns the collection of CastPaidBeans
     */
    public List<CastPaidBean> getCastPaidBeans()
    {
        return collCastPaidBeans;
    }

    /**
     * Sets the collection of CastPaidBeans to the specified value
     */
    public void setCastPaidBeans(List<CastPaidBean> list)
    {
        if (list == null)
        {
            collCastPaidBeans = null;
        }
        else
        {
            collCastPaidBeans = new ArrayList<CastPaidBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastPrdBeans
     */
    protected List<CastPrdBean> collCastPrdBeans;

    /**
     * Returns the collection of CastPrdBeans
     */
    public List<CastPrdBean> getCastPrdBeans()
    {
        return collCastPrdBeans;
    }

    /**
     * Sets the collection of CastPrdBeans to the specified value
     */
    public void setCastPrdBeans(List<CastPrdBean> list)
    {
        if (list == null)
        {
            collCastPrdBeans = null;
        }
        else
        {
            collCastPrdBeans = new ArrayList<CastPrdBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastTagBeans
     */
    protected List<CastTagBean> collCastTagBeans;

    /**
     * Returns the collection of CastTagBeans
     */
    public List<CastTagBean> getCastTagBeans()
    {
        return collCastTagBeans;
    }

    /**
     * Sets the collection of CastTagBeans to the specified value
     */
    public void setCastTagBeans(List<CastTagBean> list)
    {
        if (list == null)
        {
            collCastTagBeans = null;
        }
        else
        {
            collCastTagBeans = new ArrayList<CastTagBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastEmbedBeans
     */
    protected List<CastEmbedBean> collCastEmbedBeans;

    /**
     * Returns the collection of CastEmbedBeans
     */
    public List<CastEmbedBean> getCastEmbedBeans()
    {
        return collCastEmbedBeans;
    }

    /**
     * Sets the collection of CastEmbedBeans to the specified value
     */
    public void setCastEmbedBeans(List<CastEmbedBean> list)
    {
        if (list == null)
        {
            collCastEmbedBeans = null;
        }
        else
        {
            collCastEmbedBeans = new ArrayList<CastEmbedBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastDirectionBeans
     */
    protected List<CastDirectionBean> collCastDirectionBeans;

    /**
     * Returns the collection of CastDirectionBeans
     */
    public List<CastDirectionBean> getCastDirectionBeans()
    {
        return collCastDirectionBeans;
    }

    /**
     * Sets the collection of CastDirectionBeans to the specified value
     */
    public void setCastDirectionBeans(List<CastDirectionBean> list)
    {
        if (list == null)
        {
            collCastDirectionBeans = null;
        }
        else
        {
            collCastDirectionBeans = new ArrayList<CastDirectionBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastVipBeans
     */
    protected List<CastVipBean> collCastVipBeans;

    /**
     * Returns the collection of CastVipBeans
     */
    public List<CastVipBean> getCastVipBeans()
    {
        return collCastVipBeans;
    }

    /**
     * Sets the collection of CastVipBeans to the specified value
     */
    public void setCastVipBeans(List<CastVipBean> list)
    {
        if (list == null)
        {
            collCastVipBeans = null;
        }
        else
        {
            collCastVipBeans = new ArrayList<CastVipBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastCpmBeans
     */
    protected List<CastCpmBean> collCastCpmBeans;

    /**
     * Returns the collection of CastCpmBeans
     */
    public List<CastCpmBean> getCastCpmBeans()
    {
        return collCastCpmBeans;
    }

    /**
     * Sets the collection of CastCpmBeans to the specified value
     */
    public void setCastCpmBeans(List<CastCpmBean> list)
    {
        if (list == null)
        {
            collCastCpmBeans = null;
        }
        else
        {
            collCastCpmBeans = new ArrayList<CastCpmBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collHcastCpmBeans
     */
    protected List<HcastCpmBean> collHcastCpmBeans;

    /**
     * Returns the collection of HcastCpmBeans
     */
    public List<HcastCpmBean> getHcastCpmBeans()
    {
        return collHcastCpmBeans;
    }

    /**
     * Sets the collection of HcastCpmBeans to the specified value
     */
    public void setHcastCpmBeans(List<HcastCpmBean> list)
    {
        if (list == null)
        {
            collHcastCpmBeans = null;
        }
        else
        {
            collHcastCpmBeans = new ArrayList<HcastCpmBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collVhcastCpmBeans
     */
    protected List<VhcastCpmBean> collVhcastCpmBeans;

    /**
     * Returns the collection of VhcastCpmBeans
     */
    public List<VhcastCpmBean> getVhcastCpmBeans()
    {
        return collVhcastCpmBeans;
    }

    /**
     * Sets the collection of VhcastCpmBeans to the specified value
     */
    public void setVhcastCpmBeans(List<VhcastCpmBean> list)
    {
        if (list == null)
        {
            collVhcastCpmBeans = null;
        }
        else
        {
            collVhcastCpmBeans = new ArrayList<VhcastCpmBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastSceneBeans
     */
    protected List<CastSceneBean> collCastSceneBeans;

    /**
     * Returns the collection of CastSceneBeans
     */
    public List<CastSceneBean> getCastSceneBeans()
    {
        return collCastSceneBeans;
    }

    /**
     * Sets the collection of CastSceneBeans to the specified value
     */
    public void setCastSceneBeans(List<CastSceneBean> list)
    {
        if (list == null)
        {
            collCastSceneBeans = null;
        }
        else
        {
            collCastSceneBeans = new ArrayList<CastSceneBean>(list);
        }
    }



    /**
     * Collection to store aggregation of collCastGoodsBeans
     */
    protected List<CastGoodsBean> collCastGoodsBeans;

    /**
     * Returns the collection of CastGoodsBeans
     */
    public List<CastGoodsBean> getCastGoodsBeans()
    {
        return collCastGoodsBeans;
    }

    /**
     * Sets the collection of CastGoodsBeans to the specified value
     */
    public void setCastGoodsBeans(List<CastGoodsBean> list)
    {
        if (list == null)
        {
            collCastGoodsBeans = null;
        }
        else
        {
            collCastGoodsBeans = new ArrayList<CastGoodsBean>(list);
        }
    }

}
