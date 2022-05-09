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
import com.youku.atm.om.bean.AdCastBean;
import com.youku.atm.om.bean.AdTypeBean;
import com.youku.atm.om.bean.AdOrderBean;

import com.youku.atm.om.bean.CastChannelBean;
import com.youku.atm.om.bean.CastAreaBean;
import com.youku.atm.om.bean.CastPlatformBean;
import com.youku.atm.om.bean.CastPositionBean;
import com.youku.atm.om.bean.CastHpositionBean;
import com.youku.atm.om.bean.CastVideogroupBean;
import com.youku.atm.om.bean.CastKeyBean;
import com.youku.atm.om.bean.CastUserBean;
import com.youku.atm.om.bean.CastPartneridBean;
import com.youku.atm.om.bean.CastPidBean;
import com.youku.atm.om.bean.CastDqBean;
import com.youku.atm.om.bean.CastCampaignBean;
import com.youku.atm.om.bean.CastPaidBean;
import com.youku.atm.om.bean.CastPrdBean;
import com.youku.atm.om.bean.CastTagBean;
import com.youku.atm.om.bean.CastEmbedBean;
import com.youku.atm.om.bean.CastDirectionBean;
import com.youku.atm.om.bean.CastVipBean;
import com.youku.atm.om.bean.CastCpmBean;
import com.youku.atm.om.bean.HcastCpmBean;
import com.youku.atm.om.bean.VhcastCpmBean;
import com.youku.atm.om.bean.CastSceneBean;
import com.youku.atm.om.bean.CastGoodsBean;


/**
 * 
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to AdCast
 */
public abstract class BaseAdCast extends BaseObject
{
    /** The Peer class */
    private static final AdCastPeer peer =
        new AdCastPeer();


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



        // update associated CastChannel
        if (collCastChannels != null)
        {
            for (int i = 0; i < collCastChannels.size(); i++)
            {
                ((CastChannel) collCastChannels.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastArea
        if (collCastAreas != null)
        {
            for (int i = 0; i < collCastAreas.size(); i++)
            {
                ((CastArea) collCastAreas.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastPlatform
        if (collCastPlatforms != null)
        {
            for (int i = 0; i < collCastPlatforms.size(); i++)
            {
                ((CastPlatform) collCastPlatforms.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastPosition
        if (collCastPositions != null)
        {
            for (int i = 0; i < collCastPositions.size(); i++)
            {
                ((CastPosition) collCastPositions.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastHposition
        if (collCastHpositions != null)
        {
            for (int i = 0; i < collCastHpositions.size(); i++)
            {
                ((CastHposition) collCastHpositions.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastVideogroup
        if (collCastVideogroups != null)
        {
            for (int i = 0; i < collCastVideogroups.size(); i++)
            {
                ((CastVideogroup) collCastVideogroups.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastKey
        if (collCastKeys != null)
        {
            for (int i = 0; i < collCastKeys.size(); i++)
            {
                ((CastKey) collCastKeys.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastUser
        if (collCastUsers != null)
        {
            for (int i = 0; i < collCastUsers.size(); i++)
            {
                ((CastUser) collCastUsers.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastPartnerid
        if (collCastPartnerids != null)
        {
            for (int i = 0; i < collCastPartnerids.size(); i++)
            {
                ((CastPartnerid) collCastPartnerids.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastPid
        if (collCastPids != null)
        {
            for (int i = 0; i < collCastPids.size(); i++)
            {
                ((CastPid) collCastPids.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastDq
        if (collCastDqs != null)
        {
            for (int i = 0; i < collCastDqs.size(); i++)
            {
                ((CastDq) collCastDqs.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastCampaign
        if (collCastCampaigns != null)
        {
            for (int i = 0; i < collCastCampaigns.size(); i++)
            {
                ((CastCampaign) collCastCampaigns.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastPaid
        if (collCastPaids != null)
        {
            for (int i = 0; i < collCastPaids.size(); i++)
            {
                ((CastPaid) collCastPaids.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastPrd
        if (collCastPrds != null)
        {
            for (int i = 0; i < collCastPrds.size(); i++)
            {
                ((CastPrd) collCastPrds.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastTag
        if (collCastTags != null)
        {
            for (int i = 0; i < collCastTags.size(); i++)
            {
                ((CastTag) collCastTags.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastEmbed
        if (collCastEmbeds != null)
        {
            for (int i = 0; i < collCastEmbeds.size(); i++)
            {
                ((CastEmbed) collCastEmbeds.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastDirection
        if (collCastDirections != null)
        {
            for (int i = 0; i < collCastDirections.size(); i++)
            {
                ((CastDirection) collCastDirections.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastVip
        if (collCastVips != null)
        {
            for (int i = 0; i < collCastVips.size(); i++)
            {
                ((CastVip) collCastVips.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastCpm
        if (collCastCpms != null)
        {
            for (int i = 0; i < collCastCpms.size(); i++)
            {
                ((CastCpm) collCastCpms.get(i))
                        .setCastId(v);
            }
        }

        // update associated HcastCpm
        if (collHcastCpms != null)
        {
            for (int i = 0; i < collHcastCpms.size(); i++)
            {
                ((HcastCpm) collHcastCpms.get(i))
                        .setCastId(v);
            }
        }

        // update associated VhcastCpm
        if (collVhcastCpms != null)
        {
            for (int i = 0; i < collVhcastCpms.size(); i++)
            {
                ((VhcastCpm) collVhcastCpms.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastScene
        if (collCastScenes != null)
        {
            for (int i = 0; i < collCastScenes.size(); i++)
            {
                ((CastScene) collCastScenes.get(i))
                        .setCastId(v);
            }
        }

        // update associated CastGoods
        if (collCastGoodss != null)
        {
            for (int i = 0; i < collCastGoodss.size(); i++)
            {
                ((CastGoods) collCastGoodss.get(i))
                        .setCastId(v);
            }
        }
    }

    /**
     * Get the OrderId
     *
     * @return int
     */
    public int getOrderId()
    {
        return orderId;
    }


    /**
     * Set the value of OrderId
     *
     * @param v new value
     */
    public void setOrderId(int v) throws TorqueException
    {

        if (this.orderId != v)
        {
            this.orderId = v;
            setModified(true);
        }


        if (aAdOrder != null && !(aAdOrder.getId() == v))
        {
            aAdOrder = null;
        }

    }

    /**
     * Get the CustomerId
     *
     * @return int
     */
    public int getCustomerId()
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

        if (this.customerId != v)
        {
            this.customerId = v;
            setModified(true);
        }


    }

    /**
     * Get the ProductId
     *
     * @return int
     */
    public int getProductId()
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

        if (this.productId != v)
        {
            this.productId = v;
            setModified(true);
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
     * Get the AdTypeId
     *
     * @return int
     */
    public int getAdTypeId()
    {
        return adTypeId;
    }


    /**
     * Set the value of AdTypeId
     *
     * @param v new value
     */
    public void setAdTypeId(int v) throws TorqueException
    {

        if (this.adTypeId != v)
        {
            this.adTypeId = v;
            setModified(true);
        }


        if (aAdType != null && !(aAdType.getId() == v))
        {
            aAdType = null;
        }

    }

    /**
     * Get the DirectWay
     *
     * @return String
     */
    public String getDirectWay()
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

        if (!ObjectUtils.equals(this.directWay, v))
        {
            this.directWay = v;
            setModified(true);
        }


    }

    /**
     * Get the CastWay
     *
     * @return String
     */
    public String getCastWay()
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

        if (!ObjectUtils.equals(this.castWay, v))
        {
            this.castWay = v;
            setModified(true);
        }


    }

    /**
     * Get the InteractEffect
     *
     * @return int
     */
    public int getInteractEffect()
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

        if (this.interactEffect != v)
        {
            this.interactEffect = v;
            setModified(true);
        }


    }

    /**
     * Get the IsCopyright
     *
     * @return int
     */
    public int getIsCopyright()
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

        if (this.isCopyright != v)
        {
            this.isCopyright = v;
            setModified(true);
        }


    }

    /**
     * Get the Price
     *
     * @return double
     */
    public double getPrice()
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

        if (this.price != v)
        {
            this.price = v;
            setModified(true);
        }


    }

    /**
     * Get the SpeedType
     *
     * @return int
     */
    public int getSpeedType()
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

        if (this.speedType != v)
        {
            this.speedType = v;
            setModified(true);
        }


    }

    /**
     * Get the TypePriority
     *
     * @return int
     */
    public int getTypePriority()
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

        if (this.typePriority != v)
        {
            this.typePriority = v;
            setModified(true);
        }


    }

    /**
     * Get the ProductPriority
     *
     * @return int
     */
    public int getProductPriority()
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

        if (this.productPriority != v)
        {
            this.productPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the VipPriority
     *
     * @return int
     */
    public int getVipPriority()
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

        if (this.vipPriority != v)
        {
            this.vipPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the OrderPriority
     *
     * @return int
     */
    public int getOrderPriority()
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

        if (this.orderPriority != v)
        {
            this.orderPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the CustomPriority
     *
     * @return int
     */
    public int getCustomPriority()
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

        if (this.customPriority != v)
        {
            this.customPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the CustomNumPriority
     *
     * @return int
     */
    public int getCustomNumPriority()
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

        if (this.customNumPriority != v)
        {
            this.customNumPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the CampPriority
     *
     * @return int
     */
    public int getCampPriority()
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

        if (this.campPriority != v)
        {
            this.campPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the AreaPriority
     *
     * @return int
     */
    public int getAreaPriority()
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

        if (this.areaPriority != v)
        {
            this.areaPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the ChannelPriority
     *
     * @return int
     */
    public int getChannelPriority()
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

        if (this.channelPriority != v)
        {
            this.channelPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the PlatformPriority
     *
     * @return int
     */
    public int getPlatformPriority()
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

        if (this.platformPriority != v)
        {
            this.platformPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the UserPriority
     *
     * @return int
     */
    public int getUserPriority()
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

        if (this.userPriority != v)
        {
            this.userPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the KeywordPriority
     *
     * @return int
     */
    public int getKeywordPriority()
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

        if (this.keywordPriority != v)
        {
            this.keywordPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the VideogroupPriority
     *
     * @return int
     */
    public int getVideogroupPriority()
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

        if (this.videogroupPriority != v)
        {
            this.videogroupPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the RoPriority
     *
     * @return int
     */
    public int getRoPriority()
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

        if (this.roPriority != v)
        {
            this.roPriority = v;
            setModified(true);
        }


    }

    /**
     * Get the SowType
     *
     * @return int
     */
    public int getSowType()
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

        if (this.sowType != v)
        {
            this.sowType = v;
            setModified(true);
        }


    }

    /**
     * Get the RateM
     *
     * @return int
     */
    public int getRateM()
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

        if (this.rateM != v)
        {
            this.rateM = v;
            setModified(true);
        }


    }

    /**
     * Get the Rates
     *
     * @return int
     */
    public int getRates()
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

        if (this.rates != v)
        {
            this.rates = v;
            setModified(true);
        }


    }

    /**
     * Get the Threshold
     *
     * @return double
     */
    public double getThreshold()
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

        if (this.threshold != v)
        {
            this.threshold = v;
            setModified(true);
        }


    }

    /**
     * Get the RtbType
     *
     * @return int
     */
    public int getRtbType()
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

        if (this.rtbType != v)
        {
            this.rtbType = v;
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
     * Get the StartDate
     *
     * @return Date
     */
    public Date getStartDate()
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

        if (!ObjectUtils.equals(this.startDate, v))
        {
            this.startDate = v;
            setModified(true);
        }


    }

    /**
     * Get the EndDate
     *
     * @return Date
     */
    public Date getEndDate()
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

        if (!ObjectUtils.equals(this.endDate, v))
        {
            this.endDate = v;
            setModified(true);
        }


    }

    /**
     * Get the Rtbid
     *
     * @return int
     */
    public int getRtbid()
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

        if (this.rtbid != v)
        {
            this.rtbid = v;
            setModified(true);
        }


    }

    /**
     * Get the IdeaShowType
     *
     * @return int
     */
    public int getIdeaShowType()
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

        if (this.ideaShowType != v)
        {
            this.ideaShowType = v;
            setModified(true);
        }


    }

    /**
     * Get the MainCastId
     *
     * @return int
     */
    public int getMainCastId()
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

        if (this.mainCastId != v)
        {
            this.mainCastId = v;
            setModified(true);
        }


    }

    /**
     * Get the IsBak
     *
     * @return int
     */
    public int getIsBak()
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

        if (this.isBak != v)
        {
            this.isBak = v;
            setModified(true);
        }


    }

    /**
     * Get the DspId
     *
     * @return String
     */
    public String getDspId()
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

        if (!ObjectUtils.equals(this.dspId, v))
        {
            this.dspId = v;
            setModified(true);
        }


    }

    /**
     * Get the DealId
     *
     * @return String
     */
    public String getDealId()
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

        if (!ObjectUtils.equals(this.dealId, v))
        {
            this.dealId = v;
            setModified(true);
        }


    }

    /**
     * Get the SkipTime
     *
     * @return int
     */
    public int getSkipTime()
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

        if (this.skipTime != v)
        {
            this.skipTime = v;
            setModified(true);
        }


    }

    /**
     * Get the DirectType
     *
     * @return int
     */
    public int getDirectType()
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

        if (this.directType != v)
        {
            this.directType = v;
            setModified(true);
        }


    }

    /**
     * Get the PdbType
     *
     * @return int
     */
    public int getPdbType()
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

        if (this.pdbType != v)
        {
            this.pdbType = v;
            setModified(true);
        }


    }

    /**
     * Get the DangerIpWeight
     *
     * @return int
     */
    public int getDangerIpWeight()
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

        if (this.dangerIpWeight != v)
        {
            this.dangerIpWeight = v;
            setModified(true);
        }


    }

    /**
     * Get the ChargeType
     *
     * @return int
     */
    public int getChargeType()
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

        if (this.chargeType != v)
        {
            this.chargeType = v;
            setModified(true);
        }


    }

    /**
     * Get the IsAiidTa
     *
     * @return int
     */
    public int getIsAiidTa()
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

        if (this.isAiidTa != v)
        {
            this.isAiidTa = v;
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
     * Get the Mutex
     *
     * @return int
     */
    public int getMutex()
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

        if (this.mutex != v)
        {
            this.mutex = v;
            setModified(true);
        }


    }

    /**
     * Get the ChargeTime
     *
     * @return int
     */
    public int getChargeTime()
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

        if (this.chargeTime != v)
        {
            this.chargeTime = v;
            setModified(true);
        }


    }

    /**
     * Get the ResourceType
     *
     * @return String
     */
    public String getResourceType()
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

        if (!ObjectUtils.equals(this.resourceType, v))
        {
            this.resourceType = v;
            setModified(true);
        }


    }

    /**
     * Get the Outside
     *
     * @return int
     */
    public int getOutside()
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

        if (this.outside != v)
        {
            this.outside = v;
            setModified(true);
        }


    }

    /**
     * Get the Pbak
     *
     * @return int
     */
    public int getPbak()
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

        if (this.pbak != v)
        {
            this.pbak = v;
            setModified(true);
        }


    }

    /**
     * Get the IsArea
     *
     * @return int
     */
    public int getIsArea()
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

        if (this.isArea != v)
        {
            this.isArea = v;
            setModified(true);
        }


    }

    



    private AdType aAdType;

    /**
     * Declares an association between this object and a AdType object
     *
     * @param v AdType
     * @throws TorqueException
     */
    public void setAdType(AdType v) throws TorqueException
    {
        if (v == null)
        {
            setAdTypeId( 0);
        }
        else
        {
            setAdTypeId(v.getId());
        }
        aAdType = v;
    }


    /**
     * Returns the associated AdType object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated AdType object
     * @throws TorqueException
     */
    public AdType getAdType()
        throws TorqueException
    {
        if (aAdType == null && (this.adTypeId != 0))
        {
            aAdType = AdTypePeer.retrieveByPK(SimpleKey.keyFor(this.adTypeId));
        }
        return aAdType;
    }

    /**
     * Return the associated AdType object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated AdType object
     * @throws TorqueException
     */
    public AdType getAdType(Connection connection)
        throws TorqueException
    {
        if (aAdType == null && (this.adTypeId != 0))
        {
            aAdType = AdTypePeer.retrieveByPK(SimpleKey.keyFor(this.adTypeId), connection);
        }
        return aAdType;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setAdTypeKey(ObjectKey key) throws TorqueException
    {

        setAdTypeId(((NumberKey) key).intValue());
    }




    private AdOrder aAdOrder;

    /**
     * Declares an association between this object and a AdOrder object
     *
     * @param v AdOrder
     * @throws TorqueException
     */
    public void setAdOrder(AdOrder v) throws TorqueException
    {
        if (v == null)
        {
            setOrderId( 0);
        }
        else
        {
            setOrderId(v.getId());
        }
        aAdOrder = v;
    }


    /**
     * Returns the associated AdOrder object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated AdOrder object
     * @throws TorqueException
     */
    public AdOrder getAdOrder()
        throws TorqueException
    {
        if (aAdOrder == null && (this.orderId != 0))
        {
            aAdOrder = AdOrderPeer.retrieveByPK(SimpleKey.keyFor(this.orderId));
        }
        return aAdOrder;
    }

    /**
     * Return the associated AdOrder object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated AdOrder object
     * @throws TorqueException
     */
    public AdOrder getAdOrder(Connection connection)
        throws TorqueException
    {
        if (aAdOrder == null && (this.orderId != 0))
        {
            aAdOrder = AdOrderPeer.retrieveByPK(SimpleKey.keyFor(this.orderId), connection);
        }
        return aAdOrder;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setAdOrderKey(ObjectKey key) throws TorqueException
    {

        setOrderId(((NumberKey) key).intValue());
    }
   


    /**
     * Collection to store aggregation of collCastChannels
     */
    protected List<CastChannel> collCastChannels;

    /**
     * Temporary storage of collCastChannels to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastChannels()
    {
        if (collCastChannels == null)
        {
            collCastChannels = new ArrayList<CastChannel>();
        }
    }


    /**
     * Method called to associate a CastChannel object to this object
     * through the CastChannel foreign key attribute
     *
     * @param l CastChannel
     * @throws TorqueException
     */
    public void addCastChannel(CastChannel l) throws TorqueException
    {
        getCastChannels().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastChannel object to this object
     * through the CastChannel foreign key attribute using connection.
     *
     * @param l CastChannel
     * @throws TorqueException
     */
    public void addCastChannel(CastChannel l, Connection con) throws TorqueException
    {
        getCastChannels(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastChannels
     */
    private Criteria lastCastChannelsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastChannels(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastChannel> getCastChannels()
        throws TorqueException
    {
        if (collCastChannels == null)
        {
            collCastChannels = getCastChannels(new Criteria(10));
        }
        return collCastChannels;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastChannels from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastChannel> getCastChannels(Criteria criteria) throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                criteria.add(CastChannelPeer.CAST_ID, getId() );
                collCastChannels = CastChannelPeer.doSelect(criteria);
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
                criteria.add(CastChannelPeer.CAST_ID, getId());
                if (!lastCastChannelsCriteria.equals(criteria))
                {
                    collCastChannels = CastChannelPeer.doSelect(criteria);
                }
            }
        }
        lastCastChannelsCriteria = criteria;

        return collCastChannels;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastChannels(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastChannel> getCastChannels(Connection con) throws TorqueException
    {
        if (collCastChannels == null)
        {
            collCastChannels = getCastChannels(new Criteria(10), con);
        }
        return collCastChannels;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastChannels from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastChannel> getCastChannels(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                 criteria.add(CastChannelPeer.CAST_ID, getId());
                 collCastChannels = CastChannelPeer.doSelect(criteria, con);
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
                 criteria.add(CastChannelPeer.CAST_ID, getId());
                 if (!lastCastChannelsCriteria.equals(criteria))
                 {
                     collCastChannels = CastChannelPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastChannelsCriteria = criteria;

         return collCastChannels;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastChannels from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastChannel> getCastChannelsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                criteria.add(CastChannelPeer.CAST_ID, getId());
                collCastChannels = CastChannelPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastChannelPeer.CAST_ID, getId());
            if (!lastCastChannelsCriteria.equals(criteria))
            {
                collCastChannels = CastChannelPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastChannelsCriteria = criteria;

        return collCastChannels;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastChannels from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastChannel> getCastChannelsJoinChannel(Criteria criteria)
        throws TorqueException
    {
        if (collCastChannels == null)
        {
            if (isNew())
            {
               collCastChannels = new ArrayList<CastChannel>();
            }
            else
            {
                criteria.add(CastChannelPeer.CAST_ID, getId());
                collCastChannels = CastChannelPeer.doSelectJoinChannel(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastChannelPeer.CAST_ID, getId());
            if (!lastCastChannelsCriteria.equals(criteria))
            {
                collCastChannels = CastChannelPeer.doSelectJoinChannel(criteria);
            }
        }
        lastCastChannelsCriteria = criteria;

        return collCastChannels;
    }





    /**
     * Collection to store aggregation of collCastAreas
     */
    protected List<CastArea> collCastAreas;

    /**
     * Temporary storage of collCastAreas to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastAreas()
    {
        if (collCastAreas == null)
        {
            collCastAreas = new ArrayList<CastArea>();
        }
    }


    /**
     * Method called to associate a CastArea object to this object
     * through the CastArea foreign key attribute
     *
     * @param l CastArea
     * @throws TorqueException
     */
    public void addCastArea(CastArea l) throws TorqueException
    {
        getCastAreas().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastArea object to this object
     * through the CastArea foreign key attribute using connection.
     *
     * @param l CastArea
     * @throws TorqueException
     */
    public void addCastArea(CastArea l, Connection con) throws TorqueException
    {
        getCastAreas(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastAreas
     */
    private Criteria lastCastAreasCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastAreas(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastArea> getCastAreas()
        throws TorqueException
    {
        if (collCastAreas == null)
        {
            collCastAreas = getCastAreas(new Criteria(10));
        }
        return collCastAreas;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastAreas from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastArea> getCastAreas(Criteria criteria) throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                criteria.add(CastAreaPeer.CAST_ID, getId() );
                collCastAreas = CastAreaPeer.doSelect(criteria);
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
                criteria.add(CastAreaPeer.CAST_ID, getId());
                if (!lastCastAreasCriteria.equals(criteria))
                {
                    collCastAreas = CastAreaPeer.doSelect(criteria);
                }
            }
        }
        lastCastAreasCriteria = criteria;

        return collCastAreas;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastAreas(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastArea> getCastAreas(Connection con) throws TorqueException
    {
        if (collCastAreas == null)
        {
            collCastAreas = getCastAreas(new Criteria(10), con);
        }
        return collCastAreas;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastAreas from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastArea> getCastAreas(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                 criteria.add(CastAreaPeer.CAST_ID, getId());
                 collCastAreas = CastAreaPeer.doSelect(criteria, con);
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
                 criteria.add(CastAreaPeer.CAST_ID, getId());
                 if (!lastCastAreasCriteria.equals(criteria))
                 {
                     collCastAreas = CastAreaPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastAreasCriteria = criteria;

         return collCastAreas;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastAreas from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastArea> getCastAreasJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                criteria.add(CastAreaPeer.CAST_ID, getId());
                collCastAreas = CastAreaPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastAreaPeer.CAST_ID, getId());
            if (!lastCastAreasCriteria.equals(criteria))
            {
                collCastAreas = CastAreaPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastAreasCriteria = criteria;

        return collCastAreas;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastAreas from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastArea> getCastAreasJoinArea(Criteria criteria)
        throws TorqueException
    {
        if (collCastAreas == null)
        {
            if (isNew())
            {
               collCastAreas = new ArrayList<CastArea>();
            }
            else
            {
                criteria.add(CastAreaPeer.CAST_ID, getId());
                collCastAreas = CastAreaPeer.doSelectJoinArea(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastAreaPeer.CAST_ID, getId());
            if (!lastCastAreasCriteria.equals(criteria))
            {
                collCastAreas = CastAreaPeer.doSelectJoinArea(criteria);
            }
        }
        lastCastAreasCriteria = criteria;

        return collCastAreas;
    }





    /**
     * Collection to store aggregation of collCastPlatforms
     */
    protected List<CastPlatform> collCastPlatforms;

    /**
     * Temporary storage of collCastPlatforms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastPlatforms()
    {
        if (collCastPlatforms == null)
        {
            collCastPlatforms = new ArrayList<CastPlatform>();
        }
    }


    /**
     * Method called to associate a CastPlatform object to this object
     * through the CastPlatform foreign key attribute
     *
     * @param l CastPlatform
     * @throws TorqueException
     */
    public void addCastPlatform(CastPlatform l) throws TorqueException
    {
        getCastPlatforms().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastPlatform object to this object
     * through the CastPlatform foreign key attribute using connection.
     *
     * @param l CastPlatform
     * @throws TorqueException
     */
    public void addCastPlatform(CastPlatform l, Connection con) throws TorqueException
    {
        getCastPlatforms(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastPlatforms
     */
    private Criteria lastCastPlatformsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPlatforms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastPlatform> getCastPlatforms()
        throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            collCastPlatforms = getCastPlatforms(new Criteria(10));
        }
        return collCastPlatforms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastPlatform> getCastPlatforms(Criteria criteria) throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                criteria.add(CastPlatformPeer.CAST_ID, getId() );
                collCastPlatforms = CastPlatformPeer.doSelect(criteria);
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
                criteria.add(CastPlatformPeer.CAST_ID, getId());
                if (!lastCastPlatformsCriteria.equals(criteria))
                {
                    collCastPlatforms = CastPlatformPeer.doSelect(criteria);
                }
            }
        }
        lastCastPlatformsCriteria = criteria;

        return collCastPlatforms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPlatforms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPlatform> getCastPlatforms(Connection con) throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            collCastPlatforms = getCastPlatforms(new Criteria(10), con);
        }
        return collCastPlatforms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPlatform> getCastPlatforms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                 criteria.add(CastPlatformPeer.CAST_ID, getId());
                 collCastPlatforms = CastPlatformPeer.doSelect(criteria, con);
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
                 criteria.add(CastPlatformPeer.CAST_ID, getId());
                 if (!lastCastPlatformsCriteria.equals(criteria))
                 {
                     collCastPlatforms = CastPlatformPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastPlatformsCriteria = criteria;

         return collCastPlatforms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastPlatform> getCastPlatformsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                criteria.add(CastPlatformPeer.CAST_ID, getId());
                collCastPlatforms = CastPlatformPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPlatformPeer.CAST_ID, getId());
            if (!lastCastPlatformsCriteria.equals(criteria))
            {
                collCastPlatforms = CastPlatformPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastPlatformsCriteria = criteria;

        return collCastPlatforms;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastPlatforms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastPlatform> getCastPlatformsJoinPlatform(Criteria criteria)
        throws TorqueException
    {
        if (collCastPlatforms == null)
        {
            if (isNew())
            {
               collCastPlatforms = new ArrayList<CastPlatform>();
            }
            else
            {
                criteria.add(CastPlatformPeer.CAST_ID, getId());
                collCastPlatforms = CastPlatformPeer.doSelectJoinPlatform(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPlatformPeer.CAST_ID, getId());
            if (!lastCastPlatformsCriteria.equals(criteria))
            {
                collCastPlatforms = CastPlatformPeer.doSelectJoinPlatform(criteria);
            }
        }
        lastCastPlatformsCriteria = criteria;

        return collCastPlatforms;
    }





    /**
     * Collection to store aggregation of collCastPositions
     */
    protected List<CastPosition> collCastPositions;

    /**
     * Temporary storage of collCastPositions to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastPositions()
    {
        if (collCastPositions == null)
        {
            collCastPositions = new ArrayList<CastPosition>();
        }
    }


    /**
     * Method called to associate a CastPosition object to this object
     * through the CastPosition foreign key attribute
     *
     * @param l CastPosition
     * @throws TorqueException
     */
    public void addCastPosition(CastPosition l) throws TorqueException
    {
        getCastPositions().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastPosition object to this object
     * through the CastPosition foreign key attribute using connection.
     *
     * @param l CastPosition
     * @throws TorqueException
     */
    public void addCastPosition(CastPosition l, Connection con) throws TorqueException
    {
        getCastPositions(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastPositions
     */
    private Criteria lastCastPositionsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPositions(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastPosition> getCastPositions()
        throws TorqueException
    {
        if (collCastPositions == null)
        {
            collCastPositions = getCastPositions(new Criteria(10));
        }
        return collCastPositions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPositions from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastPosition> getCastPositions(Criteria criteria) throws TorqueException
    {
        if (collCastPositions == null)
        {
            if (isNew())
            {
               collCastPositions = new ArrayList<CastPosition>();
            }
            else
            {
                criteria.add(CastPositionPeer.CAST_ID, getId() );
                collCastPositions = CastPositionPeer.doSelect(criteria);
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
                criteria.add(CastPositionPeer.CAST_ID, getId());
                if (!lastCastPositionsCriteria.equals(criteria))
                {
                    collCastPositions = CastPositionPeer.doSelect(criteria);
                }
            }
        }
        lastCastPositionsCriteria = criteria;

        return collCastPositions;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPositions(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPosition> getCastPositions(Connection con) throws TorqueException
    {
        if (collCastPositions == null)
        {
            collCastPositions = getCastPositions(new Criteria(10), con);
        }
        return collCastPositions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPositions from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPosition> getCastPositions(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastPositions == null)
        {
            if (isNew())
            {
               collCastPositions = new ArrayList<CastPosition>();
            }
            else
            {
                 criteria.add(CastPositionPeer.CAST_ID, getId());
                 collCastPositions = CastPositionPeer.doSelect(criteria, con);
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
                 criteria.add(CastPositionPeer.CAST_ID, getId());
                 if (!lastCastPositionsCriteria.equals(criteria))
                 {
                     collCastPositions = CastPositionPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastPositionsCriteria = criteria;

         return collCastPositions;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastPositions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastPosition> getCastPositionsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastPositions == null)
        {
            if (isNew())
            {
               collCastPositions = new ArrayList<CastPosition>();
            }
            else
            {
                criteria.add(CastPositionPeer.CAST_ID, getId());
                collCastPositions = CastPositionPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPositionPeer.CAST_ID, getId());
            if (!lastCastPositionsCriteria.equals(criteria))
            {
                collCastPositions = CastPositionPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastPositionsCriteria = criteria;

        return collCastPositions;
    }





    /**
     * Collection to store aggregation of collCastHpositions
     */
    protected List<CastHposition> collCastHpositions;

    /**
     * Temporary storage of collCastHpositions to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastHpositions()
    {
        if (collCastHpositions == null)
        {
            collCastHpositions = new ArrayList<CastHposition>();
        }
    }


    /**
     * Method called to associate a CastHposition object to this object
     * through the CastHposition foreign key attribute
     *
     * @param l CastHposition
     * @throws TorqueException
     */
    public void addCastHposition(CastHposition l) throws TorqueException
    {
        getCastHpositions().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastHposition object to this object
     * through the CastHposition foreign key attribute using connection.
     *
     * @param l CastHposition
     * @throws TorqueException
     */
    public void addCastHposition(CastHposition l, Connection con) throws TorqueException
    {
        getCastHpositions(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastHpositions
     */
    private Criteria lastCastHpositionsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastHpositions(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastHposition> getCastHpositions()
        throws TorqueException
    {
        if (collCastHpositions == null)
        {
            collCastHpositions = getCastHpositions(new Criteria(10));
        }
        return collCastHpositions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastHpositions from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastHposition> getCastHpositions(Criteria criteria) throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                criteria.add(CastHpositionPeer.CAST_ID, getId() );
                collCastHpositions = CastHpositionPeer.doSelect(criteria);
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
                criteria.add(CastHpositionPeer.CAST_ID, getId());
                if (!lastCastHpositionsCriteria.equals(criteria))
                {
                    collCastHpositions = CastHpositionPeer.doSelect(criteria);
                }
            }
        }
        lastCastHpositionsCriteria = criteria;

        return collCastHpositions;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastHpositions(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastHposition> getCastHpositions(Connection con) throws TorqueException
    {
        if (collCastHpositions == null)
        {
            collCastHpositions = getCastHpositions(new Criteria(10), con);
        }
        return collCastHpositions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastHpositions from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastHposition> getCastHpositions(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                 criteria.add(CastHpositionPeer.CAST_ID, getId());
                 collCastHpositions = CastHpositionPeer.doSelect(criteria, con);
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
                 criteria.add(CastHpositionPeer.CAST_ID, getId());
                 if (!lastCastHpositionsCriteria.equals(criteria))
                 {
                     collCastHpositions = CastHpositionPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastHpositionsCriteria = criteria;

         return collCastHpositions;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastHpositions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastHposition> getCastHpositionsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                criteria.add(CastHpositionPeer.CAST_ID, getId());
                collCastHpositions = CastHpositionPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastHpositionPeer.CAST_ID, getId());
            if (!lastCastHpositionsCriteria.equals(criteria))
            {
                collCastHpositions = CastHpositionPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastHpositionsCriteria = criteria;

        return collCastHpositions;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastHpositions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastHposition> getCastHpositionsJoinHPosition(Criteria criteria)
        throws TorqueException
    {
        if (collCastHpositions == null)
        {
            if (isNew())
            {
               collCastHpositions = new ArrayList<CastHposition>();
            }
            else
            {
                criteria.add(CastHpositionPeer.CAST_ID, getId());
                collCastHpositions = CastHpositionPeer.doSelectJoinHPosition(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastHpositionPeer.CAST_ID, getId());
            if (!lastCastHpositionsCriteria.equals(criteria))
            {
                collCastHpositions = CastHpositionPeer.doSelectJoinHPosition(criteria);
            }
        }
        lastCastHpositionsCriteria = criteria;

        return collCastHpositions;
    }





    /**
     * Collection to store aggregation of collCastVideogroups
     */
    protected List<CastVideogroup> collCastVideogroups;

    /**
     * Temporary storage of collCastVideogroups to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastVideogroups()
    {
        if (collCastVideogroups == null)
        {
            collCastVideogroups = new ArrayList<CastVideogroup>();
        }
    }


    /**
     * Method called to associate a CastVideogroup object to this object
     * through the CastVideogroup foreign key attribute
     *
     * @param l CastVideogroup
     * @throws TorqueException
     */
    public void addCastVideogroup(CastVideogroup l) throws TorqueException
    {
        getCastVideogroups().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastVideogroup object to this object
     * through the CastVideogroup foreign key attribute using connection.
     *
     * @param l CastVideogroup
     * @throws TorqueException
     */
    public void addCastVideogroup(CastVideogroup l, Connection con) throws TorqueException
    {
        getCastVideogroups(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastVideogroups
     */
    private Criteria lastCastVideogroupsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastVideogroups(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastVideogroup> getCastVideogroups()
        throws TorqueException
    {
        if (collCastVideogroups == null)
        {
            collCastVideogroups = getCastVideogroups(new Criteria(10));
        }
        return collCastVideogroups;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastVideogroups from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastVideogroup> getCastVideogroups(Criteria criteria) throws TorqueException
    {
        if (collCastVideogroups == null)
        {
            if (isNew())
            {
               collCastVideogroups = new ArrayList<CastVideogroup>();
            }
            else
            {
                criteria.add(CastVideogroupPeer.CAST_ID, getId() );
                collCastVideogroups = CastVideogroupPeer.doSelect(criteria);
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
                criteria.add(CastVideogroupPeer.CAST_ID, getId());
                if (!lastCastVideogroupsCriteria.equals(criteria))
                {
                    collCastVideogroups = CastVideogroupPeer.doSelect(criteria);
                }
            }
        }
        lastCastVideogroupsCriteria = criteria;

        return collCastVideogroups;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastVideogroups(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastVideogroup> getCastVideogroups(Connection con) throws TorqueException
    {
        if (collCastVideogroups == null)
        {
            collCastVideogroups = getCastVideogroups(new Criteria(10), con);
        }
        return collCastVideogroups;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastVideogroups from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastVideogroup> getCastVideogroups(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastVideogroups == null)
        {
            if (isNew())
            {
               collCastVideogroups = new ArrayList<CastVideogroup>();
            }
            else
            {
                 criteria.add(CastVideogroupPeer.CAST_ID, getId());
                 collCastVideogroups = CastVideogroupPeer.doSelect(criteria, con);
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
                 criteria.add(CastVideogroupPeer.CAST_ID, getId());
                 if (!lastCastVideogroupsCriteria.equals(criteria))
                 {
                     collCastVideogroups = CastVideogroupPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastVideogroupsCriteria = criteria;

         return collCastVideogroups;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastVideogroups from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastVideogroup> getCastVideogroupsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastVideogroups == null)
        {
            if (isNew())
            {
               collCastVideogroups = new ArrayList<CastVideogroup>();
            }
            else
            {
                criteria.add(CastVideogroupPeer.CAST_ID, getId());
                collCastVideogroups = CastVideogroupPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastVideogroupPeer.CAST_ID, getId());
            if (!lastCastVideogroupsCriteria.equals(criteria))
            {
                collCastVideogroups = CastVideogroupPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastVideogroupsCriteria = criteria;

        return collCastVideogroups;
    }





    /**
     * Collection to store aggregation of collCastKeys
     */
    protected List<CastKey> collCastKeys;

    /**
     * Temporary storage of collCastKeys to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastKeys()
    {
        if (collCastKeys == null)
        {
            collCastKeys = new ArrayList<CastKey>();
        }
    }


    /**
     * Method called to associate a CastKey object to this object
     * through the CastKey foreign key attribute
     *
     * @param l CastKey
     * @throws TorqueException
     */
    public void addCastKey(CastKey l) throws TorqueException
    {
        getCastKeys().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastKey object to this object
     * through the CastKey foreign key attribute using connection.
     *
     * @param l CastKey
     * @throws TorqueException
     */
    public void addCastKey(CastKey l, Connection con) throws TorqueException
    {
        getCastKeys(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastKeys
     */
    private Criteria lastCastKeysCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastKeys(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastKey> getCastKeys()
        throws TorqueException
    {
        if (collCastKeys == null)
        {
            collCastKeys = getCastKeys(new Criteria(10));
        }
        return collCastKeys;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastKeys from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastKey> getCastKeys(Criteria criteria) throws TorqueException
    {
        if (collCastKeys == null)
        {
            if (isNew())
            {
               collCastKeys = new ArrayList<CastKey>();
            }
            else
            {
                criteria.add(CastKeyPeer.CAST_ID, getId() );
                collCastKeys = CastKeyPeer.doSelect(criteria);
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
                criteria.add(CastKeyPeer.CAST_ID, getId());
                if (!lastCastKeysCriteria.equals(criteria))
                {
                    collCastKeys = CastKeyPeer.doSelect(criteria);
                }
            }
        }
        lastCastKeysCriteria = criteria;

        return collCastKeys;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastKeys(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastKey> getCastKeys(Connection con) throws TorqueException
    {
        if (collCastKeys == null)
        {
            collCastKeys = getCastKeys(new Criteria(10), con);
        }
        return collCastKeys;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastKeys from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastKey> getCastKeys(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastKeys == null)
        {
            if (isNew())
            {
               collCastKeys = new ArrayList<CastKey>();
            }
            else
            {
                 criteria.add(CastKeyPeer.CAST_ID, getId());
                 collCastKeys = CastKeyPeer.doSelect(criteria, con);
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
                 criteria.add(CastKeyPeer.CAST_ID, getId());
                 if (!lastCastKeysCriteria.equals(criteria))
                 {
                     collCastKeys = CastKeyPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastKeysCriteria = criteria;

         return collCastKeys;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastKeys from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastKey> getCastKeysJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastKeys == null)
        {
            if (isNew())
            {
               collCastKeys = new ArrayList<CastKey>();
            }
            else
            {
                criteria.add(CastKeyPeer.CAST_ID, getId());
                collCastKeys = CastKeyPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastKeyPeer.CAST_ID, getId());
            if (!lastCastKeysCriteria.equals(criteria))
            {
                collCastKeys = CastKeyPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastKeysCriteria = criteria;

        return collCastKeys;
    }





    /**
     * Collection to store aggregation of collCastUsers
     */
    protected List<CastUser> collCastUsers;

    /**
     * Temporary storage of collCastUsers to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastUsers()
    {
        if (collCastUsers == null)
        {
            collCastUsers = new ArrayList<CastUser>();
        }
    }


    /**
     * Method called to associate a CastUser object to this object
     * through the CastUser foreign key attribute
     *
     * @param l CastUser
     * @throws TorqueException
     */
    public void addCastUser(CastUser l) throws TorqueException
    {
        getCastUsers().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastUser object to this object
     * through the CastUser foreign key attribute using connection.
     *
     * @param l CastUser
     * @throws TorqueException
     */
    public void addCastUser(CastUser l, Connection con) throws TorqueException
    {
        getCastUsers(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastUsers
     */
    private Criteria lastCastUsersCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastUsers(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastUser> getCastUsers()
        throws TorqueException
    {
        if (collCastUsers == null)
        {
            collCastUsers = getCastUsers(new Criteria(10));
        }
        return collCastUsers;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastUsers from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastUser> getCastUsers(Criteria criteria) throws TorqueException
    {
        if (collCastUsers == null)
        {
            if (isNew())
            {
               collCastUsers = new ArrayList<CastUser>();
            }
            else
            {
                criteria.add(CastUserPeer.CAST_ID, getId() );
                collCastUsers = CastUserPeer.doSelect(criteria);
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
                criteria.add(CastUserPeer.CAST_ID, getId());
                if (!lastCastUsersCriteria.equals(criteria))
                {
                    collCastUsers = CastUserPeer.doSelect(criteria);
                }
            }
        }
        lastCastUsersCriteria = criteria;

        return collCastUsers;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastUsers(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastUser> getCastUsers(Connection con) throws TorqueException
    {
        if (collCastUsers == null)
        {
            collCastUsers = getCastUsers(new Criteria(10), con);
        }
        return collCastUsers;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastUsers from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastUser> getCastUsers(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastUsers == null)
        {
            if (isNew())
            {
               collCastUsers = new ArrayList<CastUser>();
            }
            else
            {
                 criteria.add(CastUserPeer.CAST_ID, getId());
                 collCastUsers = CastUserPeer.doSelect(criteria, con);
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
                 criteria.add(CastUserPeer.CAST_ID, getId());
                 if (!lastCastUsersCriteria.equals(criteria))
                 {
                     collCastUsers = CastUserPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastUsersCriteria = criteria;

         return collCastUsers;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastUsers from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastUser> getCastUsersJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastUsers == null)
        {
            if (isNew())
            {
               collCastUsers = new ArrayList<CastUser>();
            }
            else
            {
                criteria.add(CastUserPeer.CAST_ID, getId());
                collCastUsers = CastUserPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastUserPeer.CAST_ID, getId());
            if (!lastCastUsersCriteria.equals(criteria))
            {
                collCastUsers = CastUserPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastUsersCriteria = criteria;

        return collCastUsers;
    }





    /**
     * Collection to store aggregation of collCastPartnerids
     */
    protected List<CastPartnerid> collCastPartnerids;

    /**
     * Temporary storage of collCastPartnerids to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastPartnerids()
    {
        if (collCastPartnerids == null)
        {
            collCastPartnerids = new ArrayList<CastPartnerid>();
        }
    }


    /**
     * Method called to associate a CastPartnerid object to this object
     * through the CastPartnerid foreign key attribute
     *
     * @param l CastPartnerid
     * @throws TorqueException
     */
    public void addCastPartnerid(CastPartnerid l) throws TorqueException
    {
        getCastPartnerids().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastPartnerid object to this object
     * through the CastPartnerid foreign key attribute using connection.
     *
     * @param l CastPartnerid
     * @throws TorqueException
     */
    public void addCastPartnerid(CastPartnerid l, Connection con) throws TorqueException
    {
        getCastPartnerids(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastPartnerids
     */
    private Criteria lastCastPartneridsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPartnerids(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastPartnerid> getCastPartnerids()
        throws TorqueException
    {
        if (collCastPartnerids == null)
        {
            collCastPartnerids = getCastPartnerids(new Criteria(10));
        }
        return collCastPartnerids;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPartnerids from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastPartnerid> getCastPartnerids(Criteria criteria) throws TorqueException
    {
        if (collCastPartnerids == null)
        {
            if (isNew())
            {
               collCastPartnerids = new ArrayList<CastPartnerid>();
            }
            else
            {
                criteria.add(CastPartneridPeer.CAST_ID, getId() );
                collCastPartnerids = CastPartneridPeer.doSelect(criteria);
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
                criteria.add(CastPartneridPeer.CAST_ID, getId());
                if (!lastCastPartneridsCriteria.equals(criteria))
                {
                    collCastPartnerids = CastPartneridPeer.doSelect(criteria);
                }
            }
        }
        lastCastPartneridsCriteria = criteria;

        return collCastPartnerids;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPartnerids(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPartnerid> getCastPartnerids(Connection con) throws TorqueException
    {
        if (collCastPartnerids == null)
        {
            collCastPartnerids = getCastPartnerids(new Criteria(10), con);
        }
        return collCastPartnerids;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPartnerids from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPartnerid> getCastPartnerids(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastPartnerids == null)
        {
            if (isNew())
            {
               collCastPartnerids = new ArrayList<CastPartnerid>();
            }
            else
            {
                 criteria.add(CastPartneridPeer.CAST_ID, getId());
                 collCastPartnerids = CastPartneridPeer.doSelect(criteria, con);
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
                 criteria.add(CastPartneridPeer.CAST_ID, getId());
                 if (!lastCastPartneridsCriteria.equals(criteria))
                 {
                     collCastPartnerids = CastPartneridPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastPartneridsCriteria = criteria;

         return collCastPartnerids;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastPartnerids from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastPartnerid> getCastPartneridsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastPartnerids == null)
        {
            if (isNew())
            {
               collCastPartnerids = new ArrayList<CastPartnerid>();
            }
            else
            {
                criteria.add(CastPartneridPeer.CAST_ID, getId());
                collCastPartnerids = CastPartneridPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPartneridPeer.CAST_ID, getId());
            if (!lastCastPartneridsCriteria.equals(criteria))
            {
                collCastPartnerids = CastPartneridPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastPartneridsCriteria = criteria;

        return collCastPartnerids;
    }





    /**
     * Collection to store aggregation of collCastPids
     */
    protected List<CastPid> collCastPids;

    /**
     * Temporary storage of collCastPids to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastPids()
    {
        if (collCastPids == null)
        {
            collCastPids = new ArrayList<CastPid>();
        }
    }


    /**
     * Method called to associate a CastPid object to this object
     * through the CastPid foreign key attribute
     *
     * @param l CastPid
     * @throws TorqueException
     */
    public void addCastPid(CastPid l) throws TorqueException
    {
        getCastPids().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastPid object to this object
     * through the CastPid foreign key attribute using connection.
     *
     * @param l CastPid
     * @throws TorqueException
     */
    public void addCastPid(CastPid l, Connection con) throws TorqueException
    {
        getCastPids(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastPids
     */
    private Criteria lastCastPidsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPids(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastPid> getCastPids()
        throws TorqueException
    {
        if (collCastPids == null)
        {
            collCastPids = getCastPids(new Criteria(10));
        }
        return collCastPids;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPids from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastPid> getCastPids(Criteria criteria) throws TorqueException
    {
        if (collCastPids == null)
        {
            if (isNew())
            {
               collCastPids = new ArrayList<CastPid>();
            }
            else
            {
                criteria.add(CastPidPeer.CAST_ID, getId() );
                collCastPids = CastPidPeer.doSelect(criteria);
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
                criteria.add(CastPidPeer.CAST_ID, getId());
                if (!lastCastPidsCriteria.equals(criteria))
                {
                    collCastPids = CastPidPeer.doSelect(criteria);
                }
            }
        }
        lastCastPidsCriteria = criteria;

        return collCastPids;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPids(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPid> getCastPids(Connection con) throws TorqueException
    {
        if (collCastPids == null)
        {
            collCastPids = getCastPids(new Criteria(10), con);
        }
        return collCastPids;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPids from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPid> getCastPids(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastPids == null)
        {
            if (isNew())
            {
               collCastPids = new ArrayList<CastPid>();
            }
            else
            {
                 criteria.add(CastPidPeer.CAST_ID, getId());
                 collCastPids = CastPidPeer.doSelect(criteria, con);
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
                 criteria.add(CastPidPeer.CAST_ID, getId());
                 if (!lastCastPidsCriteria.equals(criteria))
                 {
                     collCastPids = CastPidPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastPidsCriteria = criteria;

         return collCastPids;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastPids from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastPid> getCastPidsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastPids == null)
        {
            if (isNew())
            {
               collCastPids = new ArrayList<CastPid>();
            }
            else
            {
                criteria.add(CastPidPeer.CAST_ID, getId());
                collCastPids = CastPidPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPidPeer.CAST_ID, getId());
            if (!lastCastPidsCriteria.equals(criteria))
            {
                collCastPids = CastPidPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastPidsCriteria = criteria;

        return collCastPids;
    }





    /**
     * Collection to store aggregation of collCastDqs
     */
    protected List<CastDq> collCastDqs;

    /**
     * Temporary storage of collCastDqs to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastDqs()
    {
        if (collCastDqs == null)
        {
            collCastDqs = new ArrayList<CastDq>();
        }
    }


    /**
     * Method called to associate a CastDq object to this object
     * through the CastDq foreign key attribute
     *
     * @param l CastDq
     * @throws TorqueException
     */
    public void addCastDq(CastDq l) throws TorqueException
    {
        getCastDqs().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastDq object to this object
     * through the CastDq foreign key attribute using connection.
     *
     * @param l CastDq
     * @throws TorqueException
     */
    public void addCastDq(CastDq l, Connection con) throws TorqueException
    {
        getCastDqs(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastDqs
     */
    private Criteria lastCastDqsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastDqs(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastDq> getCastDqs()
        throws TorqueException
    {
        if (collCastDqs == null)
        {
            collCastDqs = getCastDqs(new Criteria(10));
        }
        return collCastDqs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastDqs from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastDq> getCastDqs(Criteria criteria) throws TorqueException
    {
        if (collCastDqs == null)
        {
            if (isNew())
            {
               collCastDqs = new ArrayList<CastDq>();
            }
            else
            {
                criteria.add(CastDqPeer.CAST_ID, getId() );
                collCastDqs = CastDqPeer.doSelect(criteria);
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
                criteria.add(CastDqPeer.CAST_ID, getId());
                if (!lastCastDqsCriteria.equals(criteria))
                {
                    collCastDqs = CastDqPeer.doSelect(criteria);
                }
            }
        }
        lastCastDqsCriteria = criteria;

        return collCastDqs;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastDqs(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastDq> getCastDqs(Connection con) throws TorqueException
    {
        if (collCastDqs == null)
        {
            collCastDqs = getCastDqs(new Criteria(10), con);
        }
        return collCastDqs;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastDqs from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastDq> getCastDqs(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastDqs == null)
        {
            if (isNew())
            {
               collCastDqs = new ArrayList<CastDq>();
            }
            else
            {
                 criteria.add(CastDqPeer.CAST_ID, getId());
                 collCastDqs = CastDqPeer.doSelect(criteria, con);
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
                 criteria.add(CastDqPeer.CAST_ID, getId());
                 if (!lastCastDqsCriteria.equals(criteria))
                 {
                     collCastDqs = CastDqPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastDqsCriteria = criteria;

         return collCastDqs;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastDqs from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastDq> getCastDqsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastDqs == null)
        {
            if (isNew())
            {
               collCastDqs = new ArrayList<CastDq>();
            }
            else
            {
                criteria.add(CastDqPeer.CAST_ID, getId());
                collCastDqs = CastDqPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastDqPeer.CAST_ID, getId());
            if (!lastCastDqsCriteria.equals(criteria))
            {
                collCastDqs = CastDqPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastDqsCriteria = criteria;

        return collCastDqs;
    }





    /**
     * Collection to store aggregation of collCastCampaigns
     */
    protected List<CastCampaign> collCastCampaigns;

    /**
     * Temporary storage of collCastCampaigns to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastCampaigns()
    {
        if (collCastCampaigns == null)
        {
            collCastCampaigns = new ArrayList<CastCampaign>();
        }
    }


    /**
     * Method called to associate a CastCampaign object to this object
     * through the CastCampaign foreign key attribute
     *
     * @param l CastCampaign
     * @throws TorqueException
     */
    public void addCastCampaign(CastCampaign l) throws TorqueException
    {
        getCastCampaigns().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastCampaign object to this object
     * through the CastCampaign foreign key attribute using connection.
     *
     * @param l CastCampaign
     * @throws TorqueException
     */
    public void addCastCampaign(CastCampaign l, Connection con) throws TorqueException
    {
        getCastCampaigns(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastCampaigns
     */
    private Criteria lastCastCampaignsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastCampaigns(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastCampaign> getCastCampaigns()
        throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            collCastCampaigns = getCastCampaigns(new Criteria(10));
        }
        return collCastCampaigns;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastCampaign> getCastCampaigns(Criteria criteria) throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                criteria.add(CastCampaignPeer.CAST_ID, getId() );
                collCastCampaigns = CastCampaignPeer.doSelect(criteria);
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
                criteria.add(CastCampaignPeer.CAST_ID, getId());
                if (!lastCastCampaignsCriteria.equals(criteria))
                {
                    collCastCampaigns = CastCampaignPeer.doSelect(criteria);
                }
            }
        }
        lastCastCampaignsCriteria = criteria;

        return collCastCampaigns;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastCampaigns(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastCampaign> getCastCampaigns(Connection con) throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            collCastCampaigns = getCastCampaigns(new Criteria(10), con);
        }
        return collCastCampaigns;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastCampaign> getCastCampaigns(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                 criteria.add(CastCampaignPeer.CAST_ID, getId());
                 collCastCampaigns = CastCampaignPeer.doSelect(criteria, con);
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
                 criteria.add(CastCampaignPeer.CAST_ID, getId());
                 if (!lastCastCampaignsCriteria.equals(criteria))
                 {
                     collCastCampaigns = CastCampaignPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastCampaignsCriteria = criteria;

         return collCastCampaigns;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastCampaign> getCastCampaignsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                criteria.add(CastCampaignPeer.CAST_ID, getId());
                collCastCampaigns = CastCampaignPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastCampaignPeer.CAST_ID, getId());
            if (!lastCastCampaignsCriteria.equals(criteria))
            {
                collCastCampaigns = CastCampaignPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastCampaignsCriteria = criteria;

        return collCastCampaigns;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastCampaigns from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastCampaign> getCastCampaignsJoinCampaign(Criteria criteria)
        throws TorqueException
    {
        if (collCastCampaigns == null)
        {
            if (isNew())
            {
               collCastCampaigns = new ArrayList<CastCampaign>();
            }
            else
            {
                criteria.add(CastCampaignPeer.CAST_ID, getId());
                collCastCampaigns = CastCampaignPeer.doSelectJoinCampaign(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastCampaignPeer.CAST_ID, getId());
            if (!lastCastCampaignsCriteria.equals(criteria))
            {
                collCastCampaigns = CastCampaignPeer.doSelectJoinCampaign(criteria);
            }
        }
        lastCastCampaignsCriteria = criteria;

        return collCastCampaigns;
    }





    /**
     * Collection to store aggregation of collCastPaids
     */
    protected List<CastPaid> collCastPaids;

    /**
     * Temporary storage of collCastPaids to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastPaids()
    {
        if (collCastPaids == null)
        {
            collCastPaids = new ArrayList<CastPaid>();
        }
    }


    /**
     * Method called to associate a CastPaid object to this object
     * through the CastPaid foreign key attribute
     *
     * @param l CastPaid
     * @throws TorqueException
     */
    public void addCastPaid(CastPaid l) throws TorqueException
    {
        getCastPaids().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastPaid object to this object
     * through the CastPaid foreign key attribute using connection.
     *
     * @param l CastPaid
     * @throws TorqueException
     */
    public void addCastPaid(CastPaid l, Connection con) throws TorqueException
    {
        getCastPaids(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastPaids
     */
    private Criteria lastCastPaidsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPaids(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastPaid> getCastPaids()
        throws TorqueException
    {
        if (collCastPaids == null)
        {
            collCastPaids = getCastPaids(new Criteria(10));
        }
        return collCastPaids;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPaids from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastPaid> getCastPaids(Criteria criteria) throws TorqueException
    {
        if (collCastPaids == null)
        {
            if (isNew())
            {
               collCastPaids = new ArrayList<CastPaid>();
            }
            else
            {
                criteria.add(CastPaidPeer.CAST_ID, getId() );
                collCastPaids = CastPaidPeer.doSelect(criteria);
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
                criteria.add(CastPaidPeer.CAST_ID, getId());
                if (!lastCastPaidsCriteria.equals(criteria))
                {
                    collCastPaids = CastPaidPeer.doSelect(criteria);
                }
            }
        }
        lastCastPaidsCriteria = criteria;

        return collCastPaids;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPaids(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPaid> getCastPaids(Connection con) throws TorqueException
    {
        if (collCastPaids == null)
        {
            collCastPaids = getCastPaids(new Criteria(10), con);
        }
        return collCastPaids;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPaids from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPaid> getCastPaids(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastPaids == null)
        {
            if (isNew())
            {
               collCastPaids = new ArrayList<CastPaid>();
            }
            else
            {
                 criteria.add(CastPaidPeer.CAST_ID, getId());
                 collCastPaids = CastPaidPeer.doSelect(criteria, con);
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
                 criteria.add(CastPaidPeer.CAST_ID, getId());
                 if (!lastCastPaidsCriteria.equals(criteria))
                 {
                     collCastPaids = CastPaidPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastPaidsCriteria = criteria;

         return collCastPaids;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastPaids from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastPaid> getCastPaidsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastPaids == null)
        {
            if (isNew())
            {
               collCastPaids = new ArrayList<CastPaid>();
            }
            else
            {
                criteria.add(CastPaidPeer.CAST_ID, getId());
                collCastPaids = CastPaidPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPaidPeer.CAST_ID, getId());
            if (!lastCastPaidsCriteria.equals(criteria))
            {
                collCastPaids = CastPaidPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastPaidsCriteria = criteria;

        return collCastPaids;
    }





    /**
     * Collection to store aggregation of collCastPrds
     */
    protected List<CastPrd> collCastPrds;

    /**
     * Temporary storage of collCastPrds to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastPrds()
    {
        if (collCastPrds == null)
        {
            collCastPrds = new ArrayList<CastPrd>();
        }
    }


    /**
     * Method called to associate a CastPrd object to this object
     * through the CastPrd foreign key attribute
     *
     * @param l CastPrd
     * @throws TorqueException
     */
    public void addCastPrd(CastPrd l) throws TorqueException
    {
        getCastPrds().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastPrd object to this object
     * through the CastPrd foreign key attribute using connection.
     *
     * @param l CastPrd
     * @throws TorqueException
     */
    public void addCastPrd(CastPrd l, Connection con) throws TorqueException
    {
        getCastPrds(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastPrds
     */
    private Criteria lastCastPrdsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPrds(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastPrd> getCastPrds()
        throws TorqueException
    {
        if (collCastPrds == null)
        {
            collCastPrds = getCastPrds(new Criteria(10));
        }
        return collCastPrds;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPrds from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastPrd> getCastPrds(Criteria criteria) throws TorqueException
    {
        if (collCastPrds == null)
        {
            if (isNew())
            {
               collCastPrds = new ArrayList<CastPrd>();
            }
            else
            {
                criteria.add(CastPrdPeer.CAST_ID, getId() );
                collCastPrds = CastPrdPeer.doSelect(criteria);
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
                criteria.add(CastPrdPeer.CAST_ID, getId());
                if (!lastCastPrdsCriteria.equals(criteria))
                {
                    collCastPrds = CastPrdPeer.doSelect(criteria);
                }
            }
        }
        lastCastPrdsCriteria = criteria;

        return collCastPrds;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastPrds(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPrd> getCastPrds(Connection con) throws TorqueException
    {
        if (collCastPrds == null)
        {
            collCastPrds = getCastPrds(new Criteria(10), con);
        }
        return collCastPrds;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastPrds from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastPrd> getCastPrds(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastPrds == null)
        {
            if (isNew())
            {
               collCastPrds = new ArrayList<CastPrd>();
            }
            else
            {
                 criteria.add(CastPrdPeer.CAST_ID, getId());
                 collCastPrds = CastPrdPeer.doSelect(criteria, con);
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
                 criteria.add(CastPrdPeer.CAST_ID, getId());
                 if (!lastCastPrdsCriteria.equals(criteria))
                 {
                     collCastPrds = CastPrdPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastPrdsCriteria = criteria;

         return collCastPrds;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastPrds from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastPrd> getCastPrdsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastPrds == null)
        {
            if (isNew())
            {
               collCastPrds = new ArrayList<CastPrd>();
            }
            else
            {
                criteria.add(CastPrdPeer.CAST_ID, getId());
                collCastPrds = CastPrdPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastPrdPeer.CAST_ID, getId());
            if (!lastCastPrdsCriteria.equals(criteria))
            {
                collCastPrds = CastPrdPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastPrdsCriteria = criteria;

        return collCastPrds;
    }





    /**
     * Collection to store aggregation of collCastTags
     */
    protected List<CastTag> collCastTags;

    /**
     * Temporary storage of collCastTags to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastTags()
    {
        if (collCastTags == null)
        {
            collCastTags = new ArrayList<CastTag>();
        }
    }


    /**
     * Method called to associate a CastTag object to this object
     * through the CastTag foreign key attribute
     *
     * @param l CastTag
     * @throws TorqueException
     */
    public void addCastTag(CastTag l) throws TorqueException
    {
        getCastTags().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastTag object to this object
     * through the CastTag foreign key attribute using connection.
     *
     * @param l CastTag
     * @throws TorqueException
     */
    public void addCastTag(CastTag l, Connection con) throws TorqueException
    {
        getCastTags(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastTags
     */
    private Criteria lastCastTagsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastTags(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastTag> getCastTags()
        throws TorqueException
    {
        if (collCastTags == null)
        {
            collCastTags = getCastTags(new Criteria(10));
        }
        return collCastTags;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastTags from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastTag> getCastTags(Criteria criteria) throws TorqueException
    {
        if (collCastTags == null)
        {
            if (isNew())
            {
               collCastTags = new ArrayList<CastTag>();
            }
            else
            {
                criteria.add(CastTagPeer.CAST_ID, getId() );
                collCastTags = CastTagPeer.doSelect(criteria);
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
                criteria.add(CastTagPeer.CAST_ID, getId());
                if (!lastCastTagsCriteria.equals(criteria))
                {
                    collCastTags = CastTagPeer.doSelect(criteria);
                }
            }
        }
        lastCastTagsCriteria = criteria;

        return collCastTags;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastTags(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastTag> getCastTags(Connection con) throws TorqueException
    {
        if (collCastTags == null)
        {
            collCastTags = getCastTags(new Criteria(10), con);
        }
        return collCastTags;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastTags from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastTag> getCastTags(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastTags == null)
        {
            if (isNew())
            {
               collCastTags = new ArrayList<CastTag>();
            }
            else
            {
                 criteria.add(CastTagPeer.CAST_ID, getId());
                 collCastTags = CastTagPeer.doSelect(criteria, con);
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
                 criteria.add(CastTagPeer.CAST_ID, getId());
                 if (!lastCastTagsCriteria.equals(criteria))
                 {
                     collCastTags = CastTagPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastTagsCriteria = criteria;

         return collCastTags;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastTags from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastTag> getCastTagsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastTags == null)
        {
            if (isNew())
            {
               collCastTags = new ArrayList<CastTag>();
            }
            else
            {
                criteria.add(CastTagPeer.CAST_ID, getId());
                collCastTags = CastTagPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastTagPeer.CAST_ID, getId());
            if (!lastCastTagsCriteria.equals(criteria))
            {
                collCastTags = CastTagPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastTagsCriteria = criteria;

        return collCastTags;
    }





    /**
     * Collection to store aggregation of collCastEmbeds
     */
    protected List<CastEmbed> collCastEmbeds;

    /**
     * Temporary storage of collCastEmbeds to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastEmbeds()
    {
        if (collCastEmbeds == null)
        {
            collCastEmbeds = new ArrayList<CastEmbed>();
        }
    }


    /**
     * Method called to associate a CastEmbed object to this object
     * through the CastEmbed foreign key attribute
     *
     * @param l CastEmbed
     * @throws TorqueException
     */
    public void addCastEmbed(CastEmbed l) throws TorqueException
    {
        getCastEmbeds().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastEmbed object to this object
     * through the CastEmbed foreign key attribute using connection.
     *
     * @param l CastEmbed
     * @throws TorqueException
     */
    public void addCastEmbed(CastEmbed l, Connection con) throws TorqueException
    {
        getCastEmbeds(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastEmbeds
     */
    private Criteria lastCastEmbedsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastEmbeds(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastEmbed> getCastEmbeds()
        throws TorqueException
    {
        if (collCastEmbeds == null)
        {
            collCastEmbeds = getCastEmbeds(new Criteria(10));
        }
        return collCastEmbeds;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastEmbeds from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastEmbed> getCastEmbeds(Criteria criteria) throws TorqueException
    {
        if (collCastEmbeds == null)
        {
            if (isNew())
            {
               collCastEmbeds = new ArrayList<CastEmbed>();
            }
            else
            {
                criteria.add(CastEmbedPeer.CAST_ID, getId() );
                collCastEmbeds = CastEmbedPeer.doSelect(criteria);
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
                criteria.add(CastEmbedPeer.CAST_ID, getId());
                if (!lastCastEmbedsCriteria.equals(criteria))
                {
                    collCastEmbeds = CastEmbedPeer.doSelect(criteria);
                }
            }
        }
        lastCastEmbedsCriteria = criteria;

        return collCastEmbeds;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastEmbeds(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastEmbed> getCastEmbeds(Connection con) throws TorqueException
    {
        if (collCastEmbeds == null)
        {
            collCastEmbeds = getCastEmbeds(new Criteria(10), con);
        }
        return collCastEmbeds;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastEmbeds from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastEmbed> getCastEmbeds(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastEmbeds == null)
        {
            if (isNew())
            {
               collCastEmbeds = new ArrayList<CastEmbed>();
            }
            else
            {
                 criteria.add(CastEmbedPeer.CAST_ID, getId());
                 collCastEmbeds = CastEmbedPeer.doSelect(criteria, con);
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
                 criteria.add(CastEmbedPeer.CAST_ID, getId());
                 if (!lastCastEmbedsCriteria.equals(criteria))
                 {
                     collCastEmbeds = CastEmbedPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastEmbedsCriteria = criteria;

         return collCastEmbeds;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastEmbeds from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastEmbed> getCastEmbedsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastEmbeds == null)
        {
            if (isNew())
            {
               collCastEmbeds = new ArrayList<CastEmbed>();
            }
            else
            {
                criteria.add(CastEmbedPeer.CAST_ID, getId());
                collCastEmbeds = CastEmbedPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastEmbedPeer.CAST_ID, getId());
            if (!lastCastEmbedsCriteria.equals(criteria))
            {
                collCastEmbeds = CastEmbedPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastEmbedsCriteria = criteria;

        return collCastEmbeds;
    }





    /**
     * Collection to store aggregation of collCastDirections
     */
    protected List<CastDirection> collCastDirections;

    /**
     * Temporary storage of collCastDirections to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastDirections()
    {
        if (collCastDirections == null)
        {
            collCastDirections = new ArrayList<CastDirection>();
        }
    }


    /**
     * Method called to associate a CastDirection object to this object
     * through the CastDirection foreign key attribute
     *
     * @param l CastDirection
     * @throws TorqueException
     */
    public void addCastDirection(CastDirection l) throws TorqueException
    {
        getCastDirections().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastDirection object to this object
     * through the CastDirection foreign key attribute using connection.
     *
     * @param l CastDirection
     * @throws TorqueException
     */
    public void addCastDirection(CastDirection l, Connection con) throws TorqueException
    {
        getCastDirections(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastDirections
     */
    private Criteria lastCastDirectionsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastDirections(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastDirection> getCastDirections()
        throws TorqueException
    {
        if (collCastDirections == null)
        {
            collCastDirections = getCastDirections(new Criteria(10));
        }
        return collCastDirections;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastDirections from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastDirection> getCastDirections(Criteria criteria) throws TorqueException
    {
        if (collCastDirections == null)
        {
            if (isNew())
            {
               collCastDirections = new ArrayList<CastDirection>();
            }
            else
            {
                criteria.add(CastDirectionPeer.CAST_ID, getId() );
                collCastDirections = CastDirectionPeer.doSelect(criteria);
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
                criteria.add(CastDirectionPeer.CAST_ID, getId());
                if (!lastCastDirectionsCriteria.equals(criteria))
                {
                    collCastDirections = CastDirectionPeer.doSelect(criteria);
                }
            }
        }
        lastCastDirectionsCriteria = criteria;

        return collCastDirections;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastDirections(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastDirection> getCastDirections(Connection con) throws TorqueException
    {
        if (collCastDirections == null)
        {
            collCastDirections = getCastDirections(new Criteria(10), con);
        }
        return collCastDirections;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastDirections from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastDirection> getCastDirections(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastDirections == null)
        {
            if (isNew())
            {
               collCastDirections = new ArrayList<CastDirection>();
            }
            else
            {
                 criteria.add(CastDirectionPeer.CAST_ID, getId());
                 collCastDirections = CastDirectionPeer.doSelect(criteria, con);
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
                 criteria.add(CastDirectionPeer.CAST_ID, getId());
                 if (!lastCastDirectionsCriteria.equals(criteria))
                 {
                     collCastDirections = CastDirectionPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastDirectionsCriteria = criteria;

         return collCastDirections;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastDirections from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastDirection> getCastDirectionsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastDirections == null)
        {
            if (isNew())
            {
               collCastDirections = new ArrayList<CastDirection>();
            }
            else
            {
                criteria.add(CastDirectionPeer.CAST_ID, getId());
                collCastDirections = CastDirectionPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastDirectionPeer.CAST_ID, getId());
            if (!lastCastDirectionsCriteria.equals(criteria))
            {
                collCastDirections = CastDirectionPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastDirectionsCriteria = criteria;

        return collCastDirections;
    }





    /**
     * Collection to store aggregation of collCastVips
     */
    protected List<CastVip> collCastVips;

    /**
     * Temporary storage of collCastVips to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastVips()
    {
        if (collCastVips == null)
        {
            collCastVips = new ArrayList<CastVip>();
        }
    }


    /**
     * Method called to associate a CastVip object to this object
     * through the CastVip foreign key attribute
     *
     * @param l CastVip
     * @throws TorqueException
     */
    public void addCastVip(CastVip l) throws TorqueException
    {
        getCastVips().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastVip object to this object
     * through the CastVip foreign key attribute using connection.
     *
     * @param l CastVip
     * @throws TorqueException
     */
    public void addCastVip(CastVip l, Connection con) throws TorqueException
    {
        getCastVips(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastVips
     */
    private Criteria lastCastVipsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastVips(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastVip> getCastVips()
        throws TorqueException
    {
        if (collCastVips == null)
        {
            collCastVips = getCastVips(new Criteria(10));
        }
        return collCastVips;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastVips from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastVip> getCastVips(Criteria criteria) throws TorqueException
    {
        if (collCastVips == null)
        {
            if (isNew())
            {
               collCastVips = new ArrayList<CastVip>();
            }
            else
            {
                criteria.add(CastVipPeer.CAST_ID, getId() );
                collCastVips = CastVipPeer.doSelect(criteria);
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
                criteria.add(CastVipPeer.CAST_ID, getId());
                if (!lastCastVipsCriteria.equals(criteria))
                {
                    collCastVips = CastVipPeer.doSelect(criteria);
                }
            }
        }
        lastCastVipsCriteria = criteria;

        return collCastVips;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastVips(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastVip> getCastVips(Connection con) throws TorqueException
    {
        if (collCastVips == null)
        {
            collCastVips = getCastVips(new Criteria(10), con);
        }
        return collCastVips;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastVips from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastVip> getCastVips(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastVips == null)
        {
            if (isNew())
            {
               collCastVips = new ArrayList<CastVip>();
            }
            else
            {
                 criteria.add(CastVipPeer.CAST_ID, getId());
                 collCastVips = CastVipPeer.doSelect(criteria, con);
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
                 criteria.add(CastVipPeer.CAST_ID, getId());
                 if (!lastCastVipsCriteria.equals(criteria))
                 {
                     collCastVips = CastVipPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastVipsCriteria = criteria;

         return collCastVips;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastVips from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastVip> getCastVipsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastVips == null)
        {
            if (isNew())
            {
               collCastVips = new ArrayList<CastVip>();
            }
            else
            {
                criteria.add(CastVipPeer.CAST_ID, getId());
                collCastVips = CastVipPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastVipPeer.CAST_ID, getId());
            if (!lastCastVipsCriteria.equals(criteria))
            {
                collCastVips = CastVipPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastVipsCriteria = criteria;

        return collCastVips;
    }





    /**
     * Collection to store aggregation of collCastCpms
     */
    protected List<CastCpm> collCastCpms;

    /**
     * Temporary storage of collCastCpms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastCpms()
    {
        if (collCastCpms == null)
        {
            collCastCpms = new ArrayList<CastCpm>();
        }
    }


    /**
     * Method called to associate a CastCpm object to this object
     * through the CastCpm foreign key attribute
     *
     * @param l CastCpm
     * @throws TorqueException
     */
    public void addCastCpm(CastCpm l) throws TorqueException
    {
        getCastCpms().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastCpm object to this object
     * through the CastCpm foreign key attribute using connection.
     *
     * @param l CastCpm
     * @throws TorqueException
     */
    public void addCastCpm(CastCpm l, Connection con) throws TorqueException
    {
        getCastCpms(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastCpms
     */
    private Criteria lastCastCpmsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastCpms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastCpm> getCastCpms()
        throws TorqueException
    {
        if (collCastCpms == null)
        {
            collCastCpms = getCastCpms(new Criteria(10));
        }
        return collCastCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastCpms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastCpm> getCastCpms(Criteria criteria) throws TorqueException
    {
        if (collCastCpms == null)
        {
            if (isNew())
            {
               collCastCpms = new ArrayList<CastCpm>();
            }
            else
            {
                criteria.add(CastCpmPeer.CAST_ID, getId() );
                collCastCpms = CastCpmPeer.doSelect(criteria);
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
                criteria.add(CastCpmPeer.CAST_ID, getId());
                if (!lastCastCpmsCriteria.equals(criteria))
                {
                    collCastCpms = CastCpmPeer.doSelect(criteria);
                }
            }
        }
        lastCastCpmsCriteria = criteria;

        return collCastCpms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastCpms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastCpm> getCastCpms(Connection con) throws TorqueException
    {
        if (collCastCpms == null)
        {
            collCastCpms = getCastCpms(new Criteria(10), con);
        }
        return collCastCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastCpms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastCpm> getCastCpms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastCpms == null)
        {
            if (isNew())
            {
               collCastCpms = new ArrayList<CastCpm>();
            }
            else
            {
                 criteria.add(CastCpmPeer.CAST_ID, getId());
                 collCastCpms = CastCpmPeer.doSelect(criteria, con);
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
                 criteria.add(CastCpmPeer.CAST_ID, getId());
                 if (!lastCastCpmsCriteria.equals(criteria))
                 {
                     collCastCpms = CastCpmPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastCpmsCriteria = criteria;

         return collCastCpms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastCpms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastCpm> getCastCpmsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastCpms == null)
        {
            if (isNew())
            {
               collCastCpms = new ArrayList<CastCpm>();
            }
            else
            {
                criteria.add(CastCpmPeer.CAST_ID, getId());
                collCastCpms = CastCpmPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastCpmPeer.CAST_ID, getId());
            if (!lastCastCpmsCriteria.equals(criteria))
            {
                collCastCpms = CastCpmPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastCpmsCriteria = criteria;

        return collCastCpms;
    }





    /**
     * Collection to store aggregation of collHcastCpms
     */
    protected List<HcastCpm> collHcastCpms;

    /**
     * Temporary storage of collHcastCpms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initHcastCpms()
    {
        if (collHcastCpms == null)
        {
            collHcastCpms = new ArrayList<HcastCpm>();
        }
    }


    /**
     * Method called to associate a HcastCpm object to this object
     * through the HcastCpm foreign key attribute
     *
     * @param l HcastCpm
     * @throws TorqueException
     */
    public void addHcastCpm(HcastCpm l) throws TorqueException
    {
        getHcastCpms().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a HcastCpm object to this object
     * through the HcastCpm foreign key attribute using connection.
     *
     * @param l HcastCpm
     * @throws TorqueException
     */
    public void addHcastCpm(HcastCpm l, Connection con) throws TorqueException
    {
        getHcastCpms(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collHcastCpms
     */
    private Criteria lastHcastCpmsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getHcastCpms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<HcastCpm> getHcastCpms()
        throws TorqueException
    {
        if (collHcastCpms == null)
        {
            collHcastCpms = getHcastCpms(new Criteria(10));
        }
        return collHcastCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related HcastCpms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<HcastCpm> getHcastCpms(Criteria criteria) throws TorqueException
    {
        if (collHcastCpms == null)
        {
            if (isNew())
            {
               collHcastCpms = new ArrayList<HcastCpm>();
            }
            else
            {
                criteria.add(HcastCpmPeer.CAST_ID, getId() );
                collHcastCpms = HcastCpmPeer.doSelect(criteria);
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
                criteria.add(HcastCpmPeer.CAST_ID, getId());
                if (!lastHcastCpmsCriteria.equals(criteria))
                {
                    collHcastCpms = HcastCpmPeer.doSelect(criteria);
                }
            }
        }
        lastHcastCpmsCriteria = criteria;

        return collHcastCpms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getHcastCpms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<HcastCpm> getHcastCpms(Connection con) throws TorqueException
    {
        if (collHcastCpms == null)
        {
            collHcastCpms = getHcastCpms(new Criteria(10), con);
        }
        return collHcastCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related HcastCpms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<HcastCpm> getHcastCpms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collHcastCpms == null)
        {
            if (isNew())
            {
               collHcastCpms = new ArrayList<HcastCpm>();
            }
            else
            {
                 criteria.add(HcastCpmPeer.CAST_ID, getId());
                 collHcastCpms = HcastCpmPeer.doSelect(criteria, con);
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
                 criteria.add(HcastCpmPeer.CAST_ID, getId());
                 if (!lastHcastCpmsCriteria.equals(criteria))
                 {
                     collHcastCpms = HcastCpmPeer.doSelect(criteria, con);
                 }
             }
         }
         lastHcastCpmsCriteria = criteria;

         return collHcastCpms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related HcastCpms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<HcastCpm> getHcastCpmsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collHcastCpms == null)
        {
            if (isNew())
            {
               collHcastCpms = new ArrayList<HcastCpm>();
            }
            else
            {
                criteria.add(HcastCpmPeer.CAST_ID, getId());
                collHcastCpms = HcastCpmPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(HcastCpmPeer.CAST_ID, getId());
            if (!lastHcastCpmsCriteria.equals(criteria))
            {
                collHcastCpms = HcastCpmPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastHcastCpmsCriteria = criteria;

        return collHcastCpms;
    }





    /**
     * Collection to store aggregation of collVhcastCpms
     */
    protected List<VhcastCpm> collVhcastCpms;

    /**
     * Temporary storage of collVhcastCpms to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initVhcastCpms()
    {
        if (collVhcastCpms == null)
        {
            collVhcastCpms = new ArrayList<VhcastCpm>();
        }
    }


    /**
     * Method called to associate a VhcastCpm object to this object
     * through the VhcastCpm foreign key attribute
     *
     * @param l VhcastCpm
     * @throws TorqueException
     */
    public void addVhcastCpm(VhcastCpm l) throws TorqueException
    {
        getVhcastCpms().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a VhcastCpm object to this object
     * through the VhcastCpm foreign key attribute using connection.
     *
     * @param l VhcastCpm
     * @throws TorqueException
     */
    public void addVhcastCpm(VhcastCpm l, Connection con) throws TorqueException
    {
        getVhcastCpms(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collVhcastCpms
     */
    private Criteria lastVhcastCpmsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getVhcastCpms(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<VhcastCpm> getVhcastCpms()
        throws TorqueException
    {
        if (collVhcastCpms == null)
        {
            collVhcastCpms = getVhcastCpms(new Criteria(10));
        }
        return collVhcastCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related VhcastCpms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<VhcastCpm> getVhcastCpms(Criteria criteria) throws TorqueException
    {
        if (collVhcastCpms == null)
        {
            if (isNew())
            {
               collVhcastCpms = new ArrayList<VhcastCpm>();
            }
            else
            {
                criteria.add(VhcastCpmPeer.CAST_ID, getId() );
                collVhcastCpms = VhcastCpmPeer.doSelect(criteria);
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
                criteria.add(VhcastCpmPeer.CAST_ID, getId());
                if (!lastVhcastCpmsCriteria.equals(criteria))
                {
                    collVhcastCpms = VhcastCpmPeer.doSelect(criteria);
                }
            }
        }
        lastVhcastCpmsCriteria = criteria;

        return collVhcastCpms;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getVhcastCpms(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<VhcastCpm> getVhcastCpms(Connection con) throws TorqueException
    {
        if (collVhcastCpms == null)
        {
            collVhcastCpms = getVhcastCpms(new Criteria(10), con);
        }
        return collVhcastCpms;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related VhcastCpms from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<VhcastCpm> getVhcastCpms(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collVhcastCpms == null)
        {
            if (isNew())
            {
               collVhcastCpms = new ArrayList<VhcastCpm>();
            }
            else
            {
                 criteria.add(VhcastCpmPeer.CAST_ID, getId());
                 collVhcastCpms = VhcastCpmPeer.doSelect(criteria, con);
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
                 criteria.add(VhcastCpmPeer.CAST_ID, getId());
                 if (!lastVhcastCpmsCriteria.equals(criteria))
                 {
                     collVhcastCpms = VhcastCpmPeer.doSelect(criteria, con);
                 }
             }
         }
         lastVhcastCpmsCriteria = criteria;

         return collVhcastCpms;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related VhcastCpms from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<VhcastCpm> getVhcastCpmsJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collVhcastCpms == null)
        {
            if (isNew())
            {
               collVhcastCpms = new ArrayList<VhcastCpm>();
            }
            else
            {
                criteria.add(VhcastCpmPeer.CAST_ID, getId());
                collVhcastCpms = VhcastCpmPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(VhcastCpmPeer.CAST_ID, getId());
            if (!lastVhcastCpmsCriteria.equals(criteria))
            {
                collVhcastCpms = VhcastCpmPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastVhcastCpmsCriteria = criteria;

        return collVhcastCpms;
    }





    /**
     * Collection to store aggregation of collCastScenes
     */
    protected List<CastScene> collCastScenes;

    /**
     * Temporary storage of collCastScenes to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastScenes()
    {
        if (collCastScenes == null)
        {
            collCastScenes = new ArrayList<CastScene>();
        }
    }


    /**
     * Method called to associate a CastScene object to this object
     * through the CastScene foreign key attribute
     *
     * @param l CastScene
     * @throws TorqueException
     */
    public void addCastScene(CastScene l) throws TorqueException
    {
        getCastScenes().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastScene object to this object
     * through the CastScene foreign key attribute using connection.
     *
     * @param l CastScene
     * @throws TorqueException
     */
    public void addCastScene(CastScene l, Connection con) throws TorqueException
    {
        getCastScenes(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastScenes
     */
    private Criteria lastCastScenesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastScenes(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastScene> getCastScenes()
        throws TorqueException
    {
        if (collCastScenes == null)
        {
            collCastScenes = getCastScenes(new Criteria(10));
        }
        return collCastScenes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastScenes from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastScene> getCastScenes(Criteria criteria) throws TorqueException
    {
        if (collCastScenes == null)
        {
            if (isNew())
            {
               collCastScenes = new ArrayList<CastScene>();
            }
            else
            {
                criteria.add(CastScenePeer.CAST_ID, getId() );
                collCastScenes = CastScenePeer.doSelect(criteria);
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
                criteria.add(CastScenePeer.CAST_ID, getId());
                if (!lastCastScenesCriteria.equals(criteria))
                {
                    collCastScenes = CastScenePeer.doSelect(criteria);
                }
            }
        }
        lastCastScenesCriteria = criteria;

        return collCastScenes;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastScenes(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastScene> getCastScenes(Connection con) throws TorqueException
    {
        if (collCastScenes == null)
        {
            collCastScenes = getCastScenes(new Criteria(10), con);
        }
        return collCastScenes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastScenes from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastScene> getCastScenes(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastScenes == null)
        {
            if (isNew())
            {
               collCastScenes = new ArrayList<CastScene>();
            }
            else
            {
                 criteria.add(CastScenePeer.CAST_ID, getId());
                 collCastScenes = CastScenePeer.doSelect(criteria, con);
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
                 criteria.add(CastScenePeer.CAST_ID, getId());
                 if (!lastCastScenesCriteria.equals(criteria))
                 {
                     collCastScenes = CastScenePeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastScenesCriteria = criteria;

         return collCastScenes;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastScenes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastScene> getCastScenesJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastScenes == null)
        {
            if (isNew())
            {
               collCastScenes = new ArrayList<CastScene>();
            }
            else
            {
                criteria.add(CastScenePeer.CAST_ID, getId());
                collCastScenes = CastScenePeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastScenePeer.CAST_ID, getId());
            if (!lastCastScenesCriteria.equals(criteria))
            {
                collCastScenes = CastScenePeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastScenesCriteria = criteria;

        return collCastScenes;
    }





    /**
     * Collection to store aggregation of collCastGoodss
     */
    protected List<CastGoods> collCastGoodss;

    /**
     * Temporary storage of collCastGoodss to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCastGoodss()
    {
        if (collCastGoodss == null)
        {
            collCastGoodss = new ArrayList<CastGoods>();
        }
    }


    /**
     * Method called to associate a CastGoods object to this object
     * through the CastGoods foreign key attribute
     *
     * @param l CastGoods
     * @throws TorqueException
     */
    public void addCastGoods(CastGoods l) throws TorqueException
    {
        getCastGoodss().add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * Method called to associate a CastGoods object to this object
     * through the CastGoods foreign key attribute using connection.
     *
     * @param l CastGoods
     * @throws TorqueException
     */
    public void addCastGoods(CastGoods l, Connection con) throws TorqueException
    {
        getCastGoodss(con).add(l);
        l.setAdCast((AdCast) this);
    }

    /**
     * The criteria used to select the current contents of collCastGoodss
     */
    private Criteria lastCastGoodssCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastGoodss(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<CastGoods> getCastGoodss()
        throws TorqueException
    {
        if (collCastGoodss == null)
        {
            collCastGoodss = getCastGoodss(new Criteria(10));
        }
        return collCastGoodss;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastGoodss from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<CastGoods> getCastGoodss(Criteria criteria) throws TorqueException
    {
        if (collCastGoodss == null)
        {
            if (isNew())
            {
               collCastGoodss = new ArrayList<CastGoods>();
            }
            else
            {
                criteria.add(CastGoodsPeer.CAST_ID, getId() );
                collCastGoodss = CastGoodsPeer.doSelect(criteria);
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
                criteria.add(CastGoodsPeer.CAST_ID, getId());
                if (!lastCastGoodssCriteria.equals(criteria))
                {
                    collCastGoodss = CastGoodsPeer.doSelect(criteria);
                }
            }
        }
        lastCastGoodssCriteria = criteria;

        return collCastGoodss;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCastGoodss(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastGoods> getCastGoodss(Connection con) throws TorqueException
    {
        if (collCastGoodss == null)
        {
            collCastGoodss = getCastGoodss(new Criteria(10), con);
        }
        return collCastGoodss;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast has previously
     * been saved, it will retrieve related CastGoodss from storage.
     * If this AdCast is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<CastGoods> getCastGoodss(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCastGoodss == null)
        {
            if (isNew())
            {
               collCastGoodss = new ArrayList<CastGoods>();
            }
            else
            {
                 criteria.add(CastGoodsPeer.CAST_ID, getId());
                 collCastGoodss = CastGoodsPeer.doSelect(criteria, con);
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
                 criteria.add(CastGoodsPeer.CAST_ID, getId());
                 if (!lastCastGoodssCriteria.equals(criteria))
                 {
                     collCastGoodss = CastGoodsPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCastGoodssCriteria = criteria;

         return collCastGoodss;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this AdCast is new, it will return
     * an empty collection; or if this AdCast has previously
     * been saved, it will retrieve related CastGoodss from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in AdCast.
     */
    protected List<CastGoods> getCastGoodssJoinAdCast(Criteria criteria)
        throws TorqueException
    {
        if (collCastGoodss == null)
        {
            if (isNew())
            {
               collCastGoodss = new ArrayList<CastGoods>();
            }
            else
            {
                criteria.add(CastGoodsPeer.CAST_ID, getId());
                collCastGoodss = CastGoodsPeer.doSelectJoinAdCast(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CastGoodsPeer.CAST_ID, getId());
            if (!lastCastGoodssCriteria.equals(criteria))
            {
                collCastGoodss = CastGoodsPeer.doSelectJoinAdCast(criteria);
            }
        }
        lastCastGoodssCriteria = criteria;

        return collCastGoodss;
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
            fieldNames.add("OrderId");
            fieldNames.add("CustomerId");
            fieldNames.add("ProductId");
            fieldNames.add("Name");
            fieldNames.add("AdTypeId");
            fieldNames.add("DirectWay");
            fieldNames.add("CastWay");
            fieldNames.add("InteractEffect");
            fieldNames.add("IsCopyright");
            fieldNames.add("Price");
            fieldNames.add("SpeedType");
            fieldNames.add("TypePriority");
            fieldNames.add("ProductPriority");
            fieldNames.add("VipPriority");
            fieldNames.add("OrderPriority");
            fieldNames.add("CustomPriority");
            fieldNames.add("CustomNumPriority");
            fieldNames.add("CampPriority");
            fieldNames.add("AreaPriority");
            fieldNames.add("ChannelPriority");
            fieldNames.add("PlatformPriority");
            fieldNames.add("UserPriority");
            fieldNames.add("KeywordPriority");
            fieldNames.add("VideogroupPriority");
            fieldNames.add("RoPriority");
            fieldNames.add("SowType");
            fieldNames.add("RateM");
            fieldNames.add("Rates");
            fieldNames.add("Threshold");
            fieldNames.add("RtbType");
            fieldNames.add("UpdateTime");
            fieldNames.add("StartDate");
            fieldNames.add("EndDate");
            fieldNames.add("Rtbid");
            fieldNames.add("IdeaShowType");
            fieldNames.add("MainCastId");
            fieldNames.add("IsBak");
            fieldNames.add("DspId");
            fieldNames.add("DealId");
            fieldNames.add("SkipTime");
            fieldNames.add("DirectType");
            fieldNames.add("PdbType");
            fieldNames.add("DangerIpWeight");
            fieldNames.add("ChargeType");
            fieldNames.add("IsAiidTa");
            fieldNames.add("Status");
            fieldNames.add("Mutex");
            fieldNames.add("ChargeTime");
            fieldNames.add("ResourceType");
            fieldNames.add("Outside");
            fieldNames.add("Pbak");
            fieldNames.add("IsArea");
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
        if (name.equals("OrderId"))
        {
            return new Integer(getOrderId());
        }
        if (name.equals("CustomerId"))
        {
            return new Integer(getCustomerId());
        }
        if (name.equals("ProductId"))
        {
            return new Integer(getProductId());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("AdTypeId"))
        {
            return new Integer(getAdTypeId());
        }
        if (name.equals("DirectWay"))
        {
            return getDirectWay();
        }
        if (name.equals("CastWay"))
        {
            return getCastWay();
        }
        if (name.equals("InteractEffect"))
        {
            return new Integer(getInteractEffect());
        }
        if (name.equals("IsCopyright"))
        {
            return new Integer(getIsCopyright());
        }
        if (name.equals("Price"))
        {
            return new Double(getPrice());
        }
        if (name.equals("SpeedType"))
        {
            return new Integer(getSpeedType());
        }
        if (name.equals("TypePriority"))
        {
            return new Integer(getTypePriority());
        }
        if (name.equals("ProductPriority"))
        {
            return new Integer(getProductPriority());
        }
        if (name.equals("VipPriority"))
        {
            return new Integer(getVipPriority());
        }
        if (name.equals("OrderPriority"))
        {
            return new Integer(getOrderPriority());
        }
        if (name.equals("CustomPriority"))
        {
            return new Integer(getCustomPriority());
        }
        if (name.equals("CustomNumPriority"))
        {
            return new Integer(getCustomNumPriority());
        }
        if (name.equals("CampPriority"))
        {
            return new Integer(getCampPriority());
        }
        if (name.equals("AreaPriority"))
        {
            return new Integer(getAreaPriority());
        }
        if (name.equals("ChannelPriority"))
        {
            return new Integer(getChannelPriority());
        }
        if (name.equals("PlatformPriority"))
        {
            return new Integer(getPlatformPriority());
        }
        if (name.equals("UserPriority"))
        {
            return new Integer(getUserPriority());
        }
        if (name.equals("KeywordPriority"))
        {
            return new Integer(getKeywordPriority());
        }
        if (name.equals("VideogroupPriority"))
        {
            return new Integer(getVideogroupPriority());
        }
        if (name.equals("RoPriority"))
        {
            return new Integer(getRoPriority());
        }
        if (name.equals("SowType"))
        {
            return new Integer(getSowType());
        }
        if (name.equals("RateM"))
        {
            return new Integer(getRateM());
        }
        if (name.equals("Rates"))
        {
            return new Integer(getRates());
        }
        if (name.equals("Threshold"))
        {
            return new Double(getThreshold());
        }
        if (name.equals("RtbType"))
        {
            return new Integer(getRtbType());
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        if (name.equals("StartDate"))
        {
            return getStartDate();
        }
        if (name.equals("EndDate"))
        {
            return getEndDate();
        }
        if (name.equals("Rtbid"))
        {
            return new Integer(getRtbid());
        }
        if (name.equals("IdeaShowType"))
        {
            return new Integer(getIdeaShowType());
        }
        if (name.equals("MainCastId"))
        {
            return new Integer(getMainCastId());
        }
        if (name.equals("IsBak"))
        {
            return new Integer(getIsBak());
        }
        if (name.equals("DspId"))
        {
            return getDspId();
        }
        if (name.equals("DealId"))
        {
            return getDealId();
        }
        if (name.equals("SkipTime"))
        {
            return new Integer(getSkipTime());
        }
        if (name.equals("DirectType"))
        {
            return new Integer(getDirectType());
        }
        if (name.equals("PdbType"))
        {
            return new Integer(getPdbType());
        }
        if (name.equals("DangerIpWeight"))
        {
            return new Integer(getDangerIpWeight());
        }
        if (name.equals("ChargeType"))
        {
            return new Integer(getChargeType());
        }
        if (name.equals("IsAiidTa"))
        {
            return new Integer(getIsAiidTa());
        }
        if (name.equals("Status"))
        {
            return new Integer(getStatus());
        }
        if (name.equals("Mutex"))
        {
            return new Integer(getMutex());
        }
        if (name.equals("ChargeTime"))
        {
            return new Integer(getChargeTime());
        }
        if (name.equals("ResourceType"))
        {
            return getResourceType();
        }
        if (name.equals("Outside"))
        {
            return new Integer(getOutside());
        }
        if (name.equals("Pbak"))
        {
            return new Integer(getPbak());
        }
        if (name.equals("IsArea"))
        {
            return new Integer(getIsArea());
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
        if (name.equals("OrderId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setOrderId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CustomerId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCustomerId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ProductId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setProductId(((Integer) value).intValue());
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
        if (name.equals("AdTypeId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAdTypeId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DirectWay"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDirectWay((String) value);
            return true;
        }
        if (name.equals("CastWay"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCastWay((String) value);
            return true;
        }
        if (name.equals("InteractEffect"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setInteractEffect(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IsCopyright"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsCopyright(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Price"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setPrice(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("SpeedType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSpeedType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("TypePriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTypePriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ProductPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setProductPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("VipPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setVipPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("OrderPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setOrderPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CustomPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCustomPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CustomNumPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCustomNumPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CampPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCampPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("AreaPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAreaPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ChannelPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setChannelPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("PlatformPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPlatformPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("UserPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setUserPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("KeywordPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setKeywordPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("VideogroupPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setVideogroupPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("RoPriority"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRoPriority(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SowType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSowType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("RateM"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRateM(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Rates"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRates(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Threshold"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setThreshold(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("RtbType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRtbType(((Integer) value).intValue());
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
        if (name.equals("StartDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStartDate((Date) value);
            return true;
        }
        if (name.equals("EndDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEndDate((Date) value);
            return true;
        }
        if (name.equals("Rtbid"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRtbid(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IdeaShowType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIdeaShowType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MainCastId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMainCastId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IsBak"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsBak(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DspId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDspId((String) value);
            return true;
        }
        if (name.equals("DealId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDealId((String) value);
            return true;
        }
        if (name.equals("SkipTime"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSkipTime(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DirectType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDirectType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("PdbType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPdbType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DangerIpWeight"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDangerIpWeight(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ChargeType"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setChargeType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IsAiidTa"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsAiidTa(((Integer) value).intValue());
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
        if (name.equals("Mutex"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMutex(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ChargeTime"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setChargeTime(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ResourceType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setResourceType((String) value);
            return true;
        }
        if (name.equals("Outside"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setOutside(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Pbak"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPbak(((Integer) value).intValue());
            return true;
        }
        if (name.equals("IsArea"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setIsArea(((Integer) value).intValue());
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
        if (name.equals(AdCastPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(AdCastPeer.ORDER_ID))
        {
            return new Integer(getOrderId());
        }
        if (name.equals(AdCastPeer.CUSTOMER_ID))
        {
            return new Integer(getCustomerId());
        }
        if (name.equals(AdCastPeer.PRODUCT_ID))
        {
            return new Integer(getProductId());
        }
        if (name.equals(AdCastPeer.NAME))
        {
            return getName();
        }
        if (name.equals(AdCastPeer.AD_TYPE_ID))
        {
            return new Integer(getAdTypeId());
        }
        if (name.equals(AdCastPeer.DIRECT_WAY))
        {
            return getDirectWay();
        }
        if (name.equals(AdCastPeer.CAST_WAY))
        {
            return getCastWay();
        }
        if (name.equals(AdCastPeer.INTERACT_EFFECT))
        {
            return new Integer(getInteractEffect());
        }
        if (name.equals(AdCastPeer.IS_COPYRIGHT))
        {
            return new Integer(getIsCopyright());
        }
        if (name.equals(AdCastPeer.PRICE))
        {
            return new Double(getPrice());
        }
        if (name.equals(AdCastPeer.SPEED_TYPE))
        {
            return new Integer(getSpeedType());
        }
        if (name.equals(AdCastPeer.TYPE_PRIORITY))
        {
            return new Integer(getTypePriority());
        }
        if (name.equals(AdCastPeer.PRODUCT_PRIORITY))
        {
            return new Integer(getProductPriority());
        }
        if (name.equals(AdCastPeer.VIP_PRIORITY))
        {
            return new Integer(getVipPriority());
        }
        if (name.equals(AdCastPeer.ORDER_PRIORITY))
        {
            return new Integer(getOrderPriority());
        }
        if (name.equals(AdCastPeer.CUSTOM_PRIORITY))
        {
            return new Integer(getCustomPriority());
        }
        if (name.equals(AdCastPeer.CUSTOM_NUM_PRIORITY))
        {
            return new Integer(getCustomNumPriority());
        }
        if (name.equals(AdCastPeer.CAMP_PRIORITY))
        {
            return new Integer(getCampPriority());
        }
        if (name.equals(AdCastPeer.AREA_PRIORITY))
        {
            return new Integer(getAreaPriority());
        }
        if (name.equals(AdCastPeer.CHANNEL_PRIORITY))
        {
            return new Integer(getChannelPriority());
        }
        if (name.equals(AdCastPeer.PLATFORM_PRIORITY))
        {
            return new Integer(getPlatformPriority());
        }
        if (name.equals(AdCastPeer.USER_PRIORITY))
        {
            return new Integer(getUserPriority());
        }
        if (name.equals(AdCastPeer.KEYWORD_PRIORITY))
        {
            return new Integer(getKeywordPriority());
        }
        if (name.equals(AdCastPeer.VIDEOGROUP_PRIORITY))
        {
            return new Integer(getVideogroupPriority());
        }
        if (name.equals(AdCastPeer.RO_PRIORITY))
        {
            return new Integer(getRoPriority());
        }
        if (name.equals(AdCastPeer.SOW_TYPE))
        {
            return new Integer(getSowType());
        }
        if (name.equals(AdCastPeer.RATE_M))
        {
            return new Integer(getRateM());
        }
        if (name.equals(AdCastPeer.RATES))
        {
            return new Integer(getRates());
        }
        if (name.equals(AdCastPeer.THRESHOLD))
        {
            return new Double(getThreshold());
        }
        if (name.equals(AdCastPeer.RTB_TYPE))
        {
            return new Integer(getRtbType());
        }
        if (name.equals(AdCastPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        if (name.equals(AdCastPeer.START_DATE))
        {
            return getStartDate();
        }
        if (name.equals(AdCastPeer.END_DATE))
        {
            return getEndDate();
        }
        if (name.equals(AdCastPeer.RTBID))
        {
            return new Integer(getRtbid());
        }
        if (name.equals(AdCastPeer.IDEA_SHOW_TYPE))
        {
            return new Integer(getIdeaShowType());
        }
        if (name.equals(AdCastPeer.MAIN_CAST_ID))
        {
            return new Integer(getMainCastId());
        }
        if (name.equals(AdCastPeer.IS_BAK))
        {
            return new Integer(getIsBak());
        }
        if (name.equals(AdCastPeer.DSP_ID))
        {
            return getDspId();
        }
        if (name.equals(AdCastPeer.DEAL_ID))
        {
            return getDealId();
        }
        if (name.equals(AdCastPeer.SKIP_TIME))
        {
            return new Integer(getSkipTime());
        }
        if (name.equals(AdCastPeer.DIRECT_TYPE))
        {
            return new Integer(getDirectType());
        }
        if (name.equals(AdCastPeer.PDB_TYPE))
        {
            return new Integer(getPdbType());
        }
        if (name.equals(AdCastPeer.DANGER_IP_WEIGHT))
        {
            return new Integer(getDangerIpWeight());
        }
        if (name.equals(AdCastPeer.CHARGE_TYPE))
        {
            return new Integer(getChargeType());
        }
        if (name.equals(AdCastPeer.IS_AIID_TA))
        {
            return new Integer(getIsAiidTa());
        }
        if (name.equals(AdCastPeer.STATUS))
        {
            return new Integer(getStatus());
        }
        if (name.equals(AdCastPeer.MUTEX))
        {
            return new Integer(getMutex());
        }
        if (name.equals(AdCastPeer.CHARGE_TIME))
        {
            return new Integer(getChargeTime());
        }
        if (name.equals(AdCastPeer.RESOURCE_TYPE))
        {
            return getResourceType();
        }
        if (name.equals(AdCastPeer.OUTSIDE))
        {
            return new Integer(getOutside());
        }
        if (name.equals(AdCastPeer.PBAK))
        {
            return new Integer(getPbak());
        }
        if (name.equals(AdCastPeer.IS_AREA))
        {
            return new Integer(getIsArea());
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
      if (AdCastPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (AdCastPeer.ORDER_ID.equals(name))
        {
            return setByName("OrderId", value);
        }
      if (AdCastPeer.CUSTOMER_ID.equals(name))
        {
            return setByName("CustomerId", value);
        }
      if (AdCastPeer.PRODUCT_ID.equals(name))
        {
            return setByName("ProductId", value);
        }
      if (AdCastPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (AdCastPeer.AD_TYPE_ID.equals(name))
        {
            return setByName("AdTypeId", value);
        }
      if (AdCastPeer.DIRECT_WAY.equals(name))
        {
            return setByName("DirectWay", value);
        }
      if (AdCastPeer.CAST_WAY.equals(name))
        {
            return setByName("CastWay", value);
        }
      if (AdCastPeer.INTERACT_EFFECT.equals(name))
        {
            return setByName("InteractEffect", value);
        }
      if (AdCastPeer.IS_COPYRIGHT.equals(name))
        {
            return setByName("IsCopyright", value);
        }
      if (AdCastPeer.PRICE.equals(name))
        {
            return setByName("Price", value);
        }
      if (AdCastPeer.SPEED_TYPE.equals(name))
        {
            return setByName("SpeedType", value);
        }
      if (AdCastPeer.TYPE_PRIORITY.equals(name))
        {
            return setByName("TypePriority", value);
        }
      if (AdCastPeer.PRODUCT_PRIORITY.equals(name))
        {
            return setByName("ProductPriority", value);
        }
      if (AdCastPeer.VIP_PRIORITY.equals(name))
        {
            return setByName("VipPriority", value);
        }
      if (AdCastPeer.ORDER_PRIORITY.equals(name))
        {
            return setByName("OrderPriority", value);
        }
      if (AdCastPeer.CUSTOM_PRIORITY.equals(name))
        {
            return setByName("CustomPriority", value);
        }
      if (AdCastPeer.CUSTOM_NUM_PRIORITY.equals(name))
        {
            return setByName("CustomNumPriority", value);
        }
      if (AdCastPeer.CAMP_PRIORITY.equals(name))
        {
            return setByName("CampPriority", value);
        }
      if (AdCastPeer.AREA_PRIORITY.equals(name))
        {
            return setByName("AreaPriority", value);
        }
      if (AdCastPeer.CHANNEL_PRIORITY.equals(name))
        {
            return setByName("ChannelPriority", value);
        }
      if (AdCastPeer.PLATFORM_PRIORITY.equals(name))
        {
            return setByName("PlatformPriority", value);
        }
      if (AdCastPeer.USER_PRIORITY.equals(name))
        {
            return setByName("UserPriority", value);
        }
      if (AdCastPeer.KEYWORD_PRIORITY.equals(name))
        {
            return setByName("KeywordPriority", value);
        }
      if (AdCastPeer.VIDEOGROUP_PRIORITY.equals(name))
        {
            return setByName("VideogroupPriority", value);
        }
      if (AdCastPeer.RO_PRIORITY.equals(name))
        {
            return setByName("RoPriority", value);
        }
      if (AdCastPeer.SOW_TYPE.equals(name))
        {
            return setByName("SowType", value);
        }
      if (AdCastPeer.RATE_M.equals(name))
        {
            return setByName("RateM", value);
        }
      if (AdCastPeer.RATES.equals(name))
        {
            return setByName("Rates", value);
        }
      if (AdCastPeer.THRESHOLD.equals(name))
        {
            return setByName("Threshold", value);
        }
      if (AdCastPeer.RTB_TYPE.equals(name))
        {
            return setByName("RtbType", value);
        }
      if (AdCastPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
      if (AdCastPeer.START_DATE.equals(name))
        {
            return setByName("StartDate", value);
        }
      if (AdCastPeer.END_DATE.equals(name))
        {
            return setByName("EndDate", value);
        }
      if (AdCastPeer.RTBID.equals(name))
        {
            return setByName("Rtbid", value);
        }
      if (AdCastPeer.IDEA_SHOW_TYPE.equals(name))
        {
            return setByName("IdeaShowType", value);
        }
      if (AdCastPeer.MAIN_CAST_ID.equals(name))
        {
            return setByName("MainCastId", value);
        }
      if (AdCastPeer.IS_BAK.equals(name))
        {
            return setByName("IsBak", value);
        }
      if (AdCastPeer.DSP_ID.equals(name))
        {
            return setByName("DspId", value);
        }
      if (AdCastPeer.DEAL_ID.equals(name))
        {
            return setByName("DealId", value);
        }
      if (AdCastPeer.SKIP_TIME.equals(name))
        {
            return setByName("SkipTime", value);
        }
      if (AdCastPeer.DIRECT_TYPE.equals(name))
        {
            return setByName("DirectType", value);
        }
      if (AdCastPeer.PDB_TYPE.equals(name))
        {
            return setByName("PdbType", value);
        }
      if (AdCastPeer.DANGER_IP_WEIGHT.equals(name))
        {
            return setByName("DangerIpWeight", value);
        }
      if (AdCastPeer.CHARGE_TYPE.equals(name))
        {
            return setByName("ChargeType", value);
        }
      if (AdCastPeer.IS_AIID_TA.equals(name))
        {
            return setByName("IsAiidTa", value);
        }
      if (AdCastPeer.STATUS.equals(name))
        {
            return setByName("Status", value);
        }
      if (AdCastPeer.MUTEX.equals(name))
        {
            return setByName("Mutex", value);
        }
      if (AdCastPeer.CHARGE_TIME.equals(name))
        {
            return setByName("ChargeTime", value);
        }
      if (AdCastPeer.RESOURCE_TYPE.equals(name))
        {
            return setByName("ResourceType", value);
        }
      if (AdCastPeer.OUTSIDE.equals(name))
        {
            return setByName("Outside", value);
        }
      if (AdCastPeer.PBAK.equals(name))
        {
            return setByName("Pbak", value);
        }
      if (AdCastPeer.IS_AREA.equals(name))
        {
            return setByName("IsArea", value);
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
            return new Integer(getOrderId());
        }
        if (pos == 2)
        {
            return new Integer(getCustomerId());
        }
        if (pos == 3)
        {
            return new Integer(getProductId());
        }
        if (pos == 4)
        {
            return getName();
        }
        if (pos == 5)
        {
            return new Integer(getAdTypeId());
        }
        if (pos == 6)
        {
            return getDirectWay();
        }
        if (pos == 7)
        {
            return getCastWay();
        }
        if (pos == 8)
        {
            return new Integer(getInteractEffect());
        }
        if (pos == 9)
        {
            return new Integer(getIsCopyright());
        }
        if (pos == 10)
        {
            return new Double(getPrice());
        }
        if (pos == 11)
        {
            return new Integer(getSpeedType());
        }
        if (pos == 12)
        {
            return new Integer(getTypePriority());
        }
        if (pos == 13)
        {
            return new Integer(getProductPriority());
        }
        if (pos == 14)
        {
            return new Integer(getVipPriority());
        }
        if (pos == 15)
        {
            return new Integer(getOrderPriority());
        }
        if (pos == 16)
        {
            return new Integer(getCustomPriority());
        }
        if (pos == 17)
        {
            return new Integer(getCustomNumPriority());
        }
        if (pos == 18)
        {
            return new Integer(getCampPriority());
        }
        if (pos == 19)
        {
            return new Integer(getAreaPriority());
        }
        if (pos == 20)
        {
            return new Integer(getChannelPriority());
        }
        if (pos == 21)
        {
            return new Integer(getPlatformPriority());
        }
        if (pos == 22)
        {
            return new Integer(getUserPriority());
        }
        if (pos == 23)
        {
            return new Integer(getKeywordPriority());
        }
        if (pos == 24)
        {
            return new Integer(getVideogroupPriority());
        }
        if (pos == 25)
        {
            return new Integer(getRoPriority());
        }
        if (pos == 26)
        {
            return new Integer(getSowType());
        }
        if (pos == 27)
        {
            return new Integer(getRateM());
        }
        if (pos == 28)
        {
            return new Integer(getRates());
        }
        if (pos == 29)
        {
            return new Double(getThreshold());
        }
        if (pos == 30)
        {
            return new Integer(getRtbType());
        }
        if (pos == 31)
        {
            return getUpdateTime();
        }
        if (pos == 32)
        {
            return getStartDate();
        }
        if (pos == 33)
        {
            return getEndDate();
        }
        if (pos == 34)
        {
            return new Integer(getRtbid());
        }
        if (pos == 35)
        {
            return new Integer(getIdeaShowType());
        }
        if (pos == 36)
        {
            return new Integer(getMainCastId());
        }
        if (pos == 37)
        {
            return new Integer(getIsBak());
        }
        if (pos == 38)
        {
            return getDspId();
        }
        if (pos == 39)
        {
            return getDealId();
        }
        if (pos == 40)
        {
            return new Integer(getSkipTime());
        }
        if (pos == 41)
        {
            return new Integer(getDirectType());
        }
        if (pos == 42)
        {
            return new Integer(getPdbType());
        }
        if (pos == 43)
        {
            return new Integer(getDangerIpWeight());
        }
        if (pos == 44)
        {
            return new Integer(getChargeType());
        }
        if (pos == 45)
        {
            return new Integer(getIsAiidTa());
        }
        if (pos == 46)
        {
            return new Integer(getStatus());
        }
        if (pos == 47)
        {
            return new Integer(getMutex());
        }
        if (pos == 48)
        {
            return new Integer(getChargeTime());
        }
        if (pos == 49)
        {
            return getResourceType();
        }
        if (pos == 50)
        {
            return new Integer(getOutside());
        }
        if (pos == 51)
        {
            return new Integer(getPbak());
        }
        if (pos == 52)
        {
            return new Integer(getIsArea());
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
            return setByName("OrderId", value);
        }
    if (position == 2)
        {
            return setByName("CustomerId", value);
        }
    if (position == 3)
        {
            return setByName("ProductId", value);
        }
    if (position == 4)
        {
            return setByName("Name", value);
        }
    if (position == 5)
        {
            return setByName("AdTypeId", value);
        }
    if (position == 6)
        {
            return setByName("DirectWay", value);
        }
    if (position == 7)
        {
            return setByName("CastWay", value);
        }
    if (position == 8)
        {
            return setByName("InteractEffect", value);
        }
    if (position == 9)
        {
            return setByName("IsCopyright", value);
        }
    if (position == 10)
        {
            return setByName("Price", value);
        }
    if (position == 11)
        {
            return setByName("SpeedType", value);
        }
    if (position == 12)
        {
            return setByName("TypePriority", value);
        }
    if (position == 13)
        {
            return setByName("ProductPriority", value);
        }
    if (position == 14)
        {
            return setByName("VipPriority", value);
        }
    if (position == 15)
        {
            return setByName("OrderPriority", value);
        }
    if (position == 16)
        {
            return setByName("CustomPriority", value);
        }
    if (position == 17)
        {
            return setByName("CustomNumPriority", value);
        }
    if (position == 18)
        {
            return setByName("CampPriority", value);
        }
    if (position == 19)
        {
            return setByName("AreaPriority", value);
        }
    if (position == 20)
        {
            return setByName("ChannelPriority", value);
        }
    if (position == 21)
        {
            return setByName("PlatformPriority", value);
        }
    if (position == 22)
        {
            return setByName("UserPriority", value);
        }
    if (position == 23)
        {
            return setByName("KeywordPriority", value);
        }
    if (position == 24)
        {
            return setByName("VideogroupPriority", value);
        }
    if (position == 25)
        {
            return setByName("RoPriority", value);
        }
    if (position == 26)
        {
            return setByName("SowType", value);
        }
    if (position == 27)
        {
            return setByName("RateM", value);
        }
    if (position == 28)
        {
            return setByName("Rates", value);
        }
    if (position == 29)
        {
            return setByName("Threshold", value);
        }
    if (position == 30)
        {
            return setByName("RtbType", value);
        }
    if (position == 31)
        {
            return setByName("UpdateTime", value);
        }
    if (position == 32)
        {
            return setByName("StartDate", value);
        }
    if (position == 33)
        {
            return setByName("EndDate", value);
        }
    if (position == 34)
        {
            return setByName("Rtbid", value);
        }
    if (position == 35)
        {
            return setByName("IdeaShowType", value);
        }
    if (position == 36)
        {
            return setByName("MainCastId", value);
        }
    if (position == 37)
        {
            return setByName("IsBak", value);
        }
    if (position == 38)
        {
            return setByName("DspId", value);
        }
    if (position == 39)
        {
            return setByName("DealId", value);
        }
    if (position == 40)
        {
            return setByName("SkipTime", value);
        }
    if (position == 41)
        {
            return setByName("DirectType", value);
        }
    if (position == 42)
        {
            return setByName("PdbType", value);
        }
    if (position == 43)
        {
            return setByName("DangerIpWeight", value);
        }
    if (position == 44)
        {
            return setByName("ChargeType", value);
        }
    if (position == 45)
        {
            return setByName("IsAiidTa", value);
        }
    if (position == 46)
        {
            return setByName("Status", value);
        }
    if (position == 47)
        {
            return setByName("Mutex", value);
        }
    if (position == 48)
        {
            return setByName("ChargeTime", value);
        }
    if (position == 49)
        {
            return setByName("ResourceType", value);
        }
    if (position == 50)
        {
            return setByName("Outside", value);
        }
    if (position == 51)
        {
            return setByName("Pbak", value);
        }
    if (position == 52)
        {
            return setByName("IsArea", value);
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
        save(AdCastPeer.DATABASE_NAME);
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
                    AdCastPeer.doInsert((AdCast) this, con);
                    setNew(false);
                }
                else
                {
                    AdCastPeer.doUpdate((AdCast) this, con);
                }
            }


            if (collCastChannels != null)
            {
                for (int i = 0; i < collCastChannels.size(); i++)
                {
                    ((CastChannel) collCastChannels.get(i)).save(con);
                }
            }

            if (collCastAreas != null)
            {
                for (int i = 0; i < collCastAreas.size(); i++)
                {
                    ((CastArea) collCastAreas.get(i)).save(con);
                }
            }

            if (collCastPlatforms != null)
            {
                for (int i = 0; i < collCastPlatforms.size(); i++)
                {
                    ((CastPlatform) collCastPlatforms.get(i)).save(con);
                }
            }

            if (collCastPositions != null)
            {
                for (int i = 0; i < collCastPositions.size(); i++)
                {
                    ((CastPosition) collCastPositions.get(i)).save(con);
                }
            }

            if (collCastHpositions != null)
            {
                for (int i = 0; i < collCastHpositions.size(); i++)
                {
                    ((CastHposition) collCastHpositions.get(i)).save(con);
                }
            }

            if (collCastVideogroups != null)
            {
                for (int i = 0; i < collCastVideogroups.size(); i++)
                {
                    ((CastVideogroup) collCastVideogroups.get(i)).save(con);
                }
            }

            if (collCastKeys != null)
            {
                for (int i = 0; i < collCastKeys.size(); i++)
                {
                    ((CastKey) collCastKeys.get(i)).save(con);
                }
            }

            if (collCastUsers != null)
            {
                for (int i = 0; i < collCastUsers.size(); i++)
                {
                    ((CastUser) collCastUsers.get(i)).save(con);
                }
            }

            if (collCastPartnerids != null)
            {
                for (int i = 0; i < collCastPartnerids.size(); i++)
                {
                    ((CastPartnerid) collCastPartnerids.get(i)).save(con);
                }
            }

            if (collCastPids != null)
            {
                for (int i = 0; i < collCastPids.size(); i++)
                {
                    ((CastPid) collCastPids.get(i)).save(con);
                }
            }

            if (collCastDqs != null)
            {
                for (int i = 0; i < collCastDqs.size(); i++)
                {
                    ((CastDq) collCastDqs.get(i)).save(con);
                }
            }

            if (collCastCampaigns != null)
            {
                for (int i = 0; i < collCastCampaigns.size(); i++)
                {
                    ((CastCampaign) collCastCampaigns.get(i)).save(con);
                }
            }

            if (collCastPaids != null)
            {
                for (int i = 0; i < collCastPaids.size(); i++)
                {
                    ((CastPaid) collCastPaids.get(i)).save(con);
                }
            }

            if (collCastPrds != null)
            {
                for (int i = 0; i < collCastPrds.size(); i++)
                {
                    ((CastPrd) collCastPrds.get(i)).save(con);
                }
            }

            if (collCastTags != null)
            {
                for (int i = 0; i < collCastTags.size(); i++)
                {
                    ((CastTag) collCastTags.get(i)).save(con);
                }
            }

            if (collCastEmbeds != null)
            {
                for (int i = 0; i < collCastEmbeds.size(); i++)
                {
                    ((CastEmbed) collCastEmbeds.get(i)).save(con);
                }
            }

            if (collCastDirections != null)
            {
                for (int i = 0; i < collCastDirections.size(); i++)
                {
                    ((CastDirection) collCastDirections.get(i)).save(con);
                }
            }

            if (collCastVips != null)
            {
                for (int i = 0; i < collCastVips.size(); i++)
                {
                    ((CastVip) collCastVips.get(i)).save(con);
                }
            }

            if (collCastCpms != null)
            {
                for (int i = 0; i < collCastCpms.size(); i++)
                {
                    ((CastCpm) collCastCpms.get(i)).save(con);
                }
            }

            if (collHcastCpms != null)
            {
                for (int i = 0; i < collHcastCpms.size(); i++)
                {
                    ((HcastCpm) collHcastCpms.get(i)).save(con);
                }
            }

            if (collVhcastCpms != null)
            {
                for (int i = 0; i < collVhcastCpms.size(); i++)
                {
                    ((VhcastCpm) collVhcastCpms.get(i)).save(con);
                }
            }

            if (collCastScenes != null)
            {
                for (int i = 0; i < collCastScenes.size(); i++)
                {
                    ((CastScene) collCastScenes.get(i)).save(con);
                }
            }

            if (collCastGoodss != null)
            {
                for (int i = 0; i < collCastGoodss.size(); i++)
                {
                    ((CastGoods) collCastGoodss.get(i)).save(con);
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
    public AdCast copy() throws TorqueException
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
    public AdCast copy(Connection con) throws TorqueException
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
    public AdCast copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new AdCast(), deepcopy);
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
    public AdCast copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new AdCast(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected AdCast copyInto(AdCast copyObj) throws TorqueException
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
    protected AdCast copyInto(AdCast copyObj, Connection con) throws TorqueException
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
    protected AdCast copyInto(AdCast copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setOrderId(orderId);
        copyObj.setCustomerId(customerId);
        copyObj.setProductId(productId);
        copyObj.setName(name);
        copyObj.setAdTypeId(adTypeId);
        copyObj.setDirectWay(directWay);
        copyObj.setCastWay(castWay);
        copyObj.setInteractEffect(interactEffect);
        copyObj.setIsCopyright(isCopyright);
        copyObj.setPrice(price);
        copyObj.setSpeedType(speedType);
        copyObj.setTypePriority(typePriority);
        copyObj.setProductPriority(productPriority);
        copyObj.setVipPriority(vipPriority);
        copyObj.setOrderPriority(orderPriority);
        copyObj.setCustomPriority(customPriority);
        copyObj.setCustomNumPriority(customNumPriority);
        copyObj.setCampPriority(campPriority);
        copyObj.setAreaPriority(areaPriority);
        copyObj.setChannelPriority(channelPriority);
        copyObj.setPlatformPriority(platformPriority);
        copyObj.setUserPriority(userPriority);
        copyObj.setKeywordPriority(keywordPriority);
        copyObj.setVideogroupPriority(videogroupPriority);
        copyObj.setRoPriority(roPriority);
        copyObj.setSowType(sowType);
        copyObj.setRateM(rateM);
        copyObj.setRates(rates);
        copyObj.setThreshold(threshold);
        copyObj.setRtbType(rtbType);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStartDate(startDate);
        copyObj.setEndDate(endDate);
        copyObj.setRtbid(rtbid);
        copyObj.setIdeaShowType(ideaShowType);
        copyObj.setMainCastId(mainCastId);
        copyObj.setIsBak(isBak);
        copyObj.setDspId(dspId);
        copyObj.setDealId(dealId);
        copyObj.setSkipTime(skipTime);
        copyObj.setDirectType(directType);
        copyObj.setPdbType(pdbType);
        copyObj.setDangerIpWeight(dangerIpWeight);
        copyObj.setChargeType(chargeType);
        copyObj.setIsAiidTa(isAiidTa);
        copyObj.setStatus(status);
        copyObj.setMutex(mutex);
        copyObj.setChargeTime(chargeTime);
        copyObj.setResourceType(resourceType);
        copyObj.setOutside(outside);
        copyObj.setPbak(pbak);
        copyObj.setIsArea(isArea);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastChannel> vCastChannels = getCastChannels();
        if (vCastChannels != null)
        {
            for (int i = 0; i < vCastChannels.size(); i++)
            {
                CastChannel obj =  vCastChannels.get(i);
                copyObj.addCastChannel(obj.copy());
            }
        }
        else
        {
            copyObj.collCastChannels = null;
        }


        List<CastArea> vCastAreas = getCastAreas();
        if (vCastAreas != null)
        {
            for (int i = 0; i < vCastAreas.size(); i++)
            {
                CastArea obj =  vCastAreas.get(i);
                copyObj.addCastArea(obj.copy());
            }
        }
        else
        {
            copyObj.collCastAreas = null;
        }


        List<CastPlatform> vCastPlatforms = getCastPlatforms();
        if (vCastPlatforms != null)
        {
            for (int i = 0; i < vCastPlatforms.size(); i++)
            {
                CastPlatform obj =  vCastPlatforms.get(i);
                copyObj.addCastPlatform(obj.copy());
            }
        }
        else
        {
            copyObj.collCastPlatforms = null;
        }


        List<CastPosition> vCastPositions = getCastPositions();
        if (vCastPositions != null)
        {
            for (int i = 0; i < vCastPositions.size(); i++)
            {
                CastPosition obj =  vCastPositions.get(i);
                copyObj.addCastPosition(obj.copy());
            }
        }
        else
        {
            copyObj.collCastPositions = null;
        }


        List<CastHposition> vCastHpositions = getCastHpositions();
        if (vCastHpositions != null)
        {
            for (int i = 0; i < vCastHpositions.size(); i++)
            {
                CastHposition obj =  vCastHpositions.get(i);
                copyObj.addCastHposition(obj.copy());
            }
        }
        else
        {
            copyObj.collCastHpositions = null;
        }


        List<CastVideogroup> vCastVideogroups = getCastVideogroups();
        if (vCastVideogroups != null)
        {
            for (int i = 0; i < vCastVideogroups.size(); i++)
            {
                CastVideogroup obj =  vCastVideogroups.get(i);
                copyObj.addCastVideogroup(obj.copy());
            }
        }
        else
        {
            copyObj.collCastVideogroups = null;
        }


        List<CastKey> vCastKeys = getCastKeys();
        if (vCastKeys != null)
        {
            for (int i = 0; i < vCastKeys.size(); i++)
            {
                CastKey obj =  vCastKeys.get(i);
                copyObj.addCastKey(obj.copy());
            }
        }
        else
        {
            copyObj.collCastKeys = null;
        }


        List<CastUser> vCastUsers = getCastUsers();
        if (vCastUsers != null)
        {
            for (int i = 0; i < vCastUsers.size(); i++)
            {
                CastUser obj =  vCastUsers.get(i);
                copyObj.addCastUser(obj.copy());
            }
        }
        else
        {
            copyObj.collCastUsers = null;
        }


        List<CastPartnerid> vCastPartnerids = getCastPartnerids();
        if (vCastPartnerids != null)
        {
            for (int i = 0; i < vCastPartnerids.size(); i++)
            {
                CastPartnerid obj =  vCastPartnerids.get(i);
                copyObj.addCastPartnerid(obj.copy());
            }
        }
        else
        {
            copyObj.collCastPartnerids = null;
        }


        List<CastPid> vCastPids = getCastPids();
        if (vCastPids != null)
        {
            for (int i = 0; i < vCastPids.size(); i++)
            {
                CastPid obj =  vCastPids.get(i);
                copyObj.addCastPid(obj.copy());
            }
        }
        else
        {
            copyObj.collCastPids = null;
        }


        List<CastDq> vCastDqs = getCastDqs();
        if (vCastDqs != null)
        {
            for (int i = 0; i < vCastDqs.size(); i++)
            {
                CastDq obj =  vCastDqs.get(i);
                copyObj.addCastDq(obj.copy());
            }
        }
        else
        {
            copyObj.collCastDqs = null;
        }


        List<CastCampaign> vCastCampaigns = getCastCampaigns();
        if (vCastCampaigns != null)
        {
            for (int i = 0; i < vCastCampaigns.size(); i++)
            {
                CastCampaign obj =  vCastCampaigns.get(i);
                copyObj.addCastCampaign(obj.copy());
            }
        }
        else
        {
            copyObj.collCastCampaigns = null;
        }


        List<CastPaid> vCastPaids = getCastPaids();
        if (vCastPaids != null)
        {
            for (int i = 0; i < vCastPaids.size(); i++)
            {
                CastPaid obj =  vCastPaids.get(i);
                copyObj.addCastPaid(obj.copy());
            }
        }
        else
        {
            copyObj.collCastPaids = null;
        }


        List<CastPrd> vCastPrds = getCastPrds();
        if (vCastPrds != null)
        {
            for (int i = 0; i < vCastPrds.size(); i++)
            {
                CastPrd obj =  vCastPrds.get(i);
                copyObj.addCastPrd(obj.copy());
            }
        }
        else
        {
            copyObj.collCastPrds = null;
        }


        List<CastTag> vCastTags = getCastTags();
        if (vCastTags != null)
        {
            for (int i = 0; i < vCastTags.size(); i++)
            {
                CastTag obj =  vCastTags.get(i);
                copyObj.addCastTag(obj.copy());
            }
        }
        else
        {
            copyObj.collCastTags = null;
        }


        List<CastEmbed> vCastEmbeds = getCastEmbeds();
        if (vCastEmbeds != null)
        {
            for (int i = 0; i < vCastEmbeds.size(); i++)
            {
                CastEmbed obj =  vCastEmbeds.get(i);
                copyObj.addCastEmbed(obj.copy());
            }
        }
        else
        {
            copyObj.collCastEmbeds = null;
        }


        List<CastDirection> vCastDirections = getCastDirections();
        if (vCastDirections != null)
        {
            for (int i = 0; i < vCastDirections.size(); i++)
            {
                CastDirection obj =  vCastDirections.get(i);
                copyObj.addCastDirection(obj.copy());
            }
        }
        else
        {
            copyObj.collCastDirections = null;
        }


        List<CastVip> vCastVips = getCastVips();
        if (vCastVips != null)
        {
            for (int i = 0; i < vCastVips.size(); i++)
            {
                CastVip obj =  vCastVips.get(i);
                copyObj.addCastVip(obj.copy());
            }
        }
        else
        {
            copyObj.collCastVips = null;
        }


        List<CastCpm> vCastCpms = getCastCpms();
        if (vCastCpms != null)
        {
            for (int i = 0; i < vCastCpms.size(); i++)
            {
                CastCpm obj =  vCastCpms.get(i);
                copyObj.addCastCpm(obj.copy());
            }
        }
        else
        {
            copyObj.collCastCpms = null;
        }


        List<HcastCpm> vHcastCpms = getHcastCpms();
        if (vHcastCpms != null)
        {
            for (int i = 0; i < vHcastCpms.size(); i++)
            {
                HcastCpm obj =  vHcastCpms.get(i);
                copyObj.addHcastCpm(obj.copy());
            }
        }
        else
        {
            copyObj.collHcastCpms = null;
        }


        List<VhcastCpm> vVhcastCpms = getVhcastCpms();
        if (vVhcastCpms != null)
        {
            for (int i = 0; i < vVhcastCpms.size(); i++)
            {
                VhcastCpm obj =  vVhcastCpms.get(i);
                copyObj.addVhcastCpm(obj.copy());
            }
        }
        else
        {
            copyObj.collVhcastCpms = null;
        }


        List<CastScene> vCastScenes = getCastScenes();
        if (vCastScenes != null)
        {
            for (int i = 0; i < vCastScenes.size(); i++)
            {
                CastScene obj =  vCastScenes.get(i);
                copyObj.addCastScene(obj.copy());
            }
        }
        else
        {
            copyObj.collCastScenes = null;
        }


        List<CastGoods> vCastGoodss = getCastGoodss();
        if (vCastGoodss != null)
        {
            for (int i = 0; i < vCastGoodss.size(); i++)
            {
                CastGoods obj =  vCastGoodss.get(i);
                copyObj.addCastGoods(obj.copy());
            }
        }
        else
        {
            copyObj.collCastGoodss = null;
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
    protected AdCast copyInto(AdCast copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setOrderId(orderId);
        copyObj.setCustomerId(customerId);
        copyObj.setProductId(productId);
        copyObj.setName(name);
        copyObj.setAdTypeId(adTypeId);
        copyObj.setDirectWay(directWay);
        copyObj.setCastWay(castWay);
        copyObj.setInteractEffect(interactEffect);
        copyObj.setIsCopyright(isCopyright);
        copyObj.setPrice(price);
        copyObj.setSpeedType(speedType);
        copyObj.setTypePriority(typePriority);
        copyObj.setProductPriority(productPriority);
        copyObj.setVipPriority(vipPriority);
        copyObj.setOrderPriority(orderPriority);
        copyObj.setCustomPriority(customPriority);
        copyObj.setCustomNumPriority(customNumPriority);
        copyObj.setCampPriority(campPriority);
        copyObj.setAreaPriority(areaPriority);
        copyObj.setChannelPriority(channelPriority);
        copyObj.setPlatformPriority(platformPriority);
        copyObj.setUserPriority(userPriority);
        copyObj.setKeywordPriority(keywordPriority);
        copyObj.setVideogroupPriority(videogroupPriority);
        copyObj.setRoPriority(roPriority);
        copyObj.setSowType(sowType);
        copyObj.setRateM(rateM);
        copyObj.setRates(rates);
        copyObj.setThreshold(threshold);
        copyObj.setRtbType(rtbType);
        copyObj.setUpdateTime(updateTime);
        copyObj.setStartDate(startDate);
        copyObj.setEndDate(endDate);
        copyObj.setRtbid(rtbid);
        copyObj.setIdeaShowType(ideaShowType);
        copyObj.setMainCastId(mainCastId);
        copyObj.setIsBak(isBak);
        copyObj.setDspId(dspId);
        copyObj.setDealId(dealId);
        copyObj.setSkipTime(skipTime);
        copyObj.setDirectType(directType);
        copyObj.setPdbType(pdbType);
        copyObj.setDangerIpWeight(dangerIpWeight);
        copyObj.setChargeType(chargeType);
        copyObj.setIsAiidTa(isAiidTa);
        copyObj.setStatus(status);
        copyObj.setMutex(mutex);
        copyObj.setChargeTime(chargeTime);
        copyObj.setResourceType(resourceType);
        copyObj.setOutside(outside);
        copyObj.setPbak(pbak);
        copyObj.setIsArea(isArea);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List<CastChannel> vCastChannels = getCastChannels(con);
        if (vCastChannels != null)
        {
            for (int i = 0; i < vCastChannels.size(); i++)
            {
                CastChannel obj =  vCastChannels.get(i);
                copyObj.addCastChannel(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastChannels = null;
        }


        List<CastArea> vCastAreas = getCastAreas(con);
        if (vCastAreas != null)
        {
            for (int i = 0; i < vCastAreas.size(); i++)
            {
                CastArea obj =  vCastAreas.get(i);
                copyObj.addCastArea(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastAreas = null;
        }


        List<CastPlatform> vCastPlatforms = getCastPlatforms(con);
        if (vCastPlatforms != null)
        {
            for (int i = 0; i < vCastPlatforms.size(); i++)
            {
                CastPlatform obj =  vCastPlatforms.get(i);
                copyObj.addCastPlatform(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastPlatforms = null;
        }


        List<CastPosition> vCastPositions = getCastPositions(con);
        if (vCastPositions != null)
        {
            for (int i = 0; i < vCastPositions.size(); i++)
            {
                CastPosition obj =  vCastPositions.get(i);
                copyObj.addCastPosition(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastPositions = null;
        }


        List<CastHposition> vCastHpositions = getCastHpositions(con);
        if (vCastHpositions != null)
        {
            for (int i = 0; i < vCastHpositions.size(); i++)
            {
                CastHposition obj =  vCastHpositions.get(i);
                copyObj.addCastHposition(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastHpositions = null;
        }


        List<CastVideogroup> vCastVideogroups = getCastVideogroups(con);
        if (vCastVideogroups != null)
        {
            for (int i = 0; i < vCastVideogroups.size(); i++)
            {
                CastVideogroup obj =  vCastVideogroups.get(i);
                copyObj.addCastVideogroup(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastVideogroups = null;
        }


        List<CastKey> vCastKeys = getCastKeys(con);
        if (vCastKeys != null)
        {
            for (int i = 0; i < vCastKeys.size(); i++)
            {
                CastKey obj =  vCastKeys.get(i);
                copyObj.addCastKey(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastKeys = null;
        }


        List<CastUser> vCastUsers = getCastUsers(con);
        if (vCastUsers != null)
        {
            for (int i = 0; i < vCastUsers.size(); i++)
            {
                CastUser obj =  vCastUsers.get(i);
                copyObj.addCastUser(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastUsers = null;
        }


        List<CastPartnerid> vCastPartnerids = getCastPartnerids(con);
        if (vCastPartnerids != null)
        {
            for (int i = 0; i < vCastPartnerids.size(); i++)
            {
                CastPartnerid obj =  vCastPartnerids.get(i);
                copyObj.addCastPartnerid(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastPartnerids = null;
        }


        List<CastPid> vCastPids = getCastPids(con);
        if (vCastPids != null)
        {
            for (int i = 0; i < vCastPids.size(); i++)
            {
                CastPid obj =  vCastPids.get(i);
                copyObj.addCastPid(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastPids = null;
        }


        List<CastDq> vCastDqs = getCastDqs(con);
        if (vCastDqs != null)
        {
            for (int i = 0; i < vCastDqs.size(); i++)
            {
                CastDq obj =  vCastDqs.get(i);
                copyObj.addCastDq(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastDqs = null;
        }


        List<CastCampaign> vCastCampaigns = getCastCampaigns(con);
        if (vCastCampaigns != null)
        {
            for (int i = 0; i < vCastCampaigns.size(); i++)
            {
                CastCampaign obj =  vCastCampaigns.get(i);
                copyObj.addCastCampaign(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastCampaigns = null;
        }


        List<CastPaid> vCastPaids = getCastPaids(con);
        if (vCastPaids != null)
        {
            for (int i = 0; i < vCastPaids.size(); i++)
            {
                CastPaid obj =  vCastPaids.get(i);
                copyObj.addCastPaid(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastPaids = null;
        }


        List<CastPrd> vCastPrds = getCastPrds(con);
        if (vCastPrds != null)
        {
            for (int i = 0; i < vCastPrds.size(); i++)
            {
                CastPrd obj =  vCastPrds.get(i);
                copyObj.addCastPrd(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastPrds = null;
        }


        List<CastTag> vCastTags = getCastTags(con);
        if (vCastTags != null)
        {
            for (int i = 0; i < vCastTags.size(); i++)
            {
                CastTag obj =  vCastTags.get(i);
                copyObj.addCastTag(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastTags = null;
        }


        List<CastEmbed> vCastEmbeds = getCastEmbeds(con);
        if (vCastEmbeds != null)
        {
            for (int i = 0; i < vCastEmbeds.size(); i++)
            {
                CastEmbed obj =  vCastEmbeds.get(i);
                copyObj.addCastEmbed(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastEmbeds = null;
        }


        List<CastDirection> vCastDirections = getCastDirections(con);
        if (vCastDirections != null)
        {
            for (int i = 0; i < vCastDirections.size(); i++)
            {
                CastDirection obj =  vCastDirections.get(i);
                copyObj.addCastDirection(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastDirections = null;
        }


        List<CastVip> vCastVips = getCastVips(con);
        if (vCastVips != null)
        {
            for (int i = 0; i < vCastVips.size(); i++)
            {
                CastVip obj =  vCastVips.get(i);
                copyObj.addCastVip(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastVips = null;
        }


        List<CastCpm> vCastCpms = getCastCpms(con);
        if (vCastCpms != null)
        {
            for (int i = 0; i < vCastCpms.size(); i++)
            {
                CastCpm obj =  vCastCpms.get(i);
                copyObj.addCastCpm(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastCpms = null;
        }


        List<HcastCpm> vHcastCpms = getHcastCpms(con);
        if (vHcastCpms != null)
        {
            for (int i = 0; i < vHcastCpms.size(); i++)
            {
                HcastCpm obj =  vHcastCpms.get(i);
                copyObj.addHcastCpm(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collHcastCpms = null;
        }


        List<VhcastCpm> vVhcastCpms = getVhcastCpms(con);
        if (vVhcastCpms != null)
        {
            for (int i = 0; i < vVhcastCpms.size(); i++)
            {
                VhcastCpm obj =  vVhcastCpms.get(i);
                copyObj.addVhcastCpm(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collVhcastCpms = null;
        }


        List<CastScene> vCastScenes = getCastScenes(con);
        if (vCastScenes != null)
        {
            for (int i = 0; i < vCastScenes.size(); i++)
            {
                CastScene obj =  vCastScenes.get(i);
                copyObj.addCastScene(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastScenes = null;
        }


        List<CastGoods> vCastGoodss = getCastGoodss(con);
        if (vCastGoodss != null)
        {
            for (int i = 0; i < vCastGoodss.size(); i++)
            {
                CastGoods obj =  vCastGoodss.get(i);
                copyObj.addCastGoods(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCastGoodss = null;
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
    public AdCastPeer getPeer()
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
        return AdCastPeer.getTableMap();
    }

  
    /**
     * Creates a AdCastBean with the contents of this object
     * This also creates beans for cached related objects, if they exist
     * @return a AdCastBean with the contents of this object
     */
    public AdCastBean getBean()
    {
        return getBean(new IdentityMap());
    }

    /**
     * Creates a AdCastBean with the contents of this object
     * intended for internal use only
     * @param createdBeans a IdentityMap which maps objects
     *        to already created beans
     * @return a AdCastBean with the contents of this object
     */
    public AdCastBean getBean(IdentityMap createdBeans)
    {
        AdCastBean result = (AdCastBean) createdBeans.get(this);
        if (result != null ) {
            // we have already created a bean for this object, return it
            return result;
        }
        // no bean exists for this object; create a new one
        result = new AdCastBean();
        createdBeans.put(this, result);

        result.setId(getId());
        result.setOrderId(getOrderId());
        result.setCustomerId(getCustomerId());
        result.setProductId(getProductId());
        result.setName(getName());
        result.setAdTypeId(getAdTypeId());
        result.setDirectWay(getDirectWay());
        result.setCastWay(getCastWay());
        result.setInteractEffect(getInteractEffect());
        result.setIsCopyright(getIsCopyright());
        result.setPrice(getPrice());
        result.setSpeedType(getSpeedType());
        result.setTypePriority(getTypePriority());
        result.setProductPriority(getProductPriority());
        result.setVipPriority(getVipPriority());
        result.setOrderPriority(getOrderPriority());
        result.setCustomPriority(getCustomPriority());
        result.setCustomNumPriority(getCustomNumPriority());
        result.setCampPriority(getCampPriority());
        result.setAreaPriority(getAreaPriority());
        result.setChannelPriority(getChannelPriority());
        result.setPlatformPriority(getPlatformPriority());
        result.setUserPriority(getUserPriority());
        result.setKeywordPriority(getKeywordPriority());
        result.setVideogroupPriority(getVideogroupPriority());
        result.setRoPriority(getRoPriority());
        result.setSowType(getSowType());
        result.setRateM(getRateM());
        result.setRates(getRates());
        result.setThreshold(getThreshold());
        result.setRtbType(getRtbType());
        result.setUpdateTime(getUpdateTime());
        result.setStartDate(getStartDate());
        result.setEndDate(getEndDate());
        result.setRtbid(getRtbid());
        result.setIdeaShowType(getIdeaShowType());
        result.setMainCastId(getMainCastId());
        result.setIsBak(getIsBak());
        result.setDspId(getDspId());
        result.setDealId(getDealId());
        result.setSkipTime(getSkipTime());
        result.setDirectType(getDirectType());
        result.setPdbType(getPdbType());
        result.setDangerIpWeight(getDangerIpWeight());
        result.setChargeType(getChargeType());
        result.setIsAiidTa(getIsAiidTa());
        result.setStatus(getStatus());
        result.setMutex(getMutex());
        result.setChargeTime(getChargeTime());
        result.setResourceType(getResourceType());
        result.setOutside(getOutside());
        result.setPbak(getPbak());
        result.setIsArea(getIsArea());



        if (collCastChannels != null)
        {
            List<CastChannelBean> relatedBeans = new ArrayList<CastChannelBean>(collCastChannels.size());
            for (Iterator<CastChannel> collCastChannelsIt = collCastChannels.iterator(); collCastChannelsIt.hasNext(); )
            {
                CastChannel related = (CastChannel) collCastChannelsIt.next();
                CastChannelBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastChannelBeans(relatedBeans);
        }


        if (collCastAreas != null)
        {
            List<CastAreaBean> relatedBeans = new ArrayList<CastAreaBean>(collCastAreas.size());
            for (Iterator<CastArea> collCastAreasIt = collCastAreas.iterator(); collCastAreasIt.hasNext(); )
            {
                CastArea related = (CastArea) collCastAreasIt.next();
                CastAreaBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastAreaBeans(relatedBeans);
        }


        if (collCastPlatforms != null)
        {
            List<CastPlatformBean> relatedBeans = new ArrayList<CastPlatformBean>(collCastPlatforms.size());
            for (Iterator<CastPlatform> collCastPlatformsIt = collCastPlatforms.iterator(); collCastPlatformsIt.hasNext(); )
            {
                CastPlatform related = (CastPlatform) collCastPlatformsIt.next();
                CastPlatformBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastPlatformBeans(relatedBeans);
        }


        if (collCastPositions != null)
        {
            List<CastPositionBean> relatedBeans = new ArrayList<CastPositionBean>(collCastPositions.size());
            for (Iterator<CastPosition> collCastPositionsIt = collCastPositions.iterator(); collCastPositionsIt.hasNext(); )
            {
                CastPosition related = (CastPosition) collCastPositionsIt.next();
                CastPositionBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastPositionBeans(relatedBeans);
        }


        if (collCastHpositions != null)
        {
            List<CastHpositionBean> relatedBeans = new ArrayList<CastHpositionBean>(collCastHpositions.size());
            for (Iterator<CastHposition> collCastHpositionsIt = collCastHpositions.iterator(); collCastHpositionsIt.hasNext(); )
            {
                CastHposition related = (CastHposition) collCastHpositionsIt.next();
                CastHpositionBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastHpositionBeans(relatedBeans);
        }


        if (collCastVideogroups != null)
        {
            List<CastVideogroupBean> relatedBeans = new ArrayList<CastVideogroupBean>(collCastVideogroups.size());
            for (Iterator<CastVideogroup> collCastVideogroupsIt = collCastVideogroups.iterator(); collCastVideogroupsIt.hasNext(); )
            {
                CastVideogroup related = (CastVideogroup) collCastVideogroupsIt.next();
                CastVideogroupBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastVideogroupBeans(relatedBeans);
        }


        if (collCastKeys != null)
        {
            List<CastKeyBean> relatedBeans = new ArrayList<CastKeyBean>(collCastKeys.size());
            for (Iterator<CastKey> collCastKeysIt = collCastKeys.iterator(); collCastKeysIt.hasNext(); )
            {
                CastKey related = (CastKey) collCastKeysIt.next();
                CastKeyBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastKeyBeans(relatedBeans);
        }


        if (collCastUsers != null)
        {
            List<CastUserBean> relatedBeans = new ArrayList<CastUserBean>(collCastUsers.size());
            for (Iterator<CastUser> collCastUsersIt = collCastUsers.iterator(); collCastUsersIt.hasNext(); )
            {
                CastUser related = (CastUser) collCastUsersIt.next();
                CastUserBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastUserBeans(relatedBeans);
        }


        if (collCastPartnerids != null)
        {
            List<CastPartneridBean> relatedBeans = new ArrayList<CastPartneridBean>(collCastPartnerids.size());
            for (Iterator<CastPartnerid> collCastPartneridsIt = collCastPartnerids.iterator(); collCastPartneridsIt.hasNext(); )
            {
                CastPartnerid related = (CastPartnerid) collCastPartneridsIt.next();
                CastPartneridBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastPartneridBeans(relatedBeans);
        }


        if (collCastPids != null)
        {
            List<CastPidBean> relatedBeans = new ArrayList<CastPidBean>(collCastPids.size());
            for (Iterator<CastPid> collCastPidsIt = collCastPids.iterator(); collCastPidsIt.hasNext(); )
            {
                CastPid related = (CastPid) collCastPidsIt.next();
                CastPidBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastPidBeans(relatedBeans);
        }


        if (collCastDqs != null)
        {
            List<CastDqBean> relatedBeans = new ArrayList<CastDqBean>(collCastDqs.size());
            for (Iterator<CastDq> collCastDqsIt = collCastDqs.iterator(); collCastDqsIt.hasNext(); )
            {
                CastDq related = (CastDq) collCastDqsIt.next();
                CastDqBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastDqBeans(relatedBeans);
        }


        if (collCastCampaigns != null)
        {
            List<CastCampaignBean> relatedBeans = new ArrayList<CastCampaignBean>(collCastCampaigns.size());
            for (Iterator<CastCampaign> collCastCampaignsIt = collCastCampaigns.iterator(); collCastCampaignsIt.hasNext(); )
            {
                CastCampaign related = (CastCampaign) collCastCampaignsIt.next();
                CastCampaignBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastCampaignBeans(relatedBeans);
        }


        if (collCastPaids != null)
        {
            List<CastPaidBean> relatedBeans = new ArrayList<CastPaidBean>(collCastPaids.size());
            for (Iterator<CastPaid> collCastPaidsIt = collCastPaids.iterator(); collCastPaidsIt.hasNext(); )
            {
                CastPaid related = (CastPaid) collCastPaidsIt.next();
                CastPaidBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastPaidBeans(relatedBeans);
        }


        if (collCastPrds != null)
        {
            List<CastPrdBean> relatedBeans = new ArrayList<CastPrdBean>(collCastPrds.size());
            for (Iterator<CastPrd> collCastPrdsIt = collCastPrds.iterator(); collCastPrdsIt.hasNext(); )
            {
                CastPrd related = (CastPrd) collCastPrdsIt.next();
                CastPrdBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastPrdBeans(relatedBeans);
        }


        if (collCastTags != null)
        {
            List<CastTagBean> relatedBeans = new ArrayList<CastTagBean>(collCastTags.size());
            for (Iterator<CastTag> collCastTagsIt = collCastTags.iterator(); collCastTagsIt.hasNext(); )
            {
                CastTag related = (CastTag) collCastTagsIt.next();
                CastTagBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastTagBeans(relatedBeans);
        }


        if (collCastEmbeds != null)
        {
            List<CastEmbedBean> relatedBeans = new ArrayList<CastEmbedBean>(collCastEmbeds.size());
            for (Iterator<CastEmbed> collCastEmbedsIt = collCastEmbeds.iterator(); collCastEmbedsIt.hasNext(); )
            {
                CastEmbed related = (CastEmbed) collCastEmbedsIt.next();
                CastEmbedBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastEmbedBeans(relatedBeans);
        }


        if (collCastDirections != null)
        {
            List<CastDirectionBean> relatedBeans = new ArrayList<CastDirectionBean>(collCastDirections.size());
            for (Iterator<CastDirection> collCastDirectionsIt = collCastDirections.iterator(); collCastDirectionsIt.hasNext(); )
            {
                CastDirection related = (CastDirection) collCastDirectionsIt.next();
                CastDirectionBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastDirectionBeans(relatedBeans);
        }


        if (collCastVips != null)
        {
            List<CastVipBean> relatedBeans = new ArrayList<CastVipBean>(collCastVips.size());
            for (Iterator<CastVip> collCastVipsIt = collCastVips.iterator(); collCastVipsIt.hasNext(); )
            {
                CastVip related = (CastVip) collCastVipsIt.next();
                CastVipBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastVipBeans(relatedBeans);
        }


        if (collCastCpms != null)
        {
            List<CastCpmBean> relatedBeans = new ArrayList<CastCpmBean>(collCastCpms.size());
            for (Iterator<CastCpm> collCastCpmsIt = collCastCpms.iterator(); collCastCpmsIt.hasNext(); )
            {
                CastCpm related = (CastCpm) collCastCpmsIt.next();
                CastCpmBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastCpmBeans(relatedBeans);
        }


        if (collHcastCpms != null)
        {
            List<HcastCpmBean> relatedBeans = new ArrayList<HcastCpmBean>(collHcastCpms.size());
            for (Iterator<HcastCpm> collHcastCpmsIt = collHcastCpms.iterator(); collHcastCpmsIt.hasNext(); )
            {
                HcastCpm related = (HcastCpm) collHcastCpmsIt.next();
                HcastCpmBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setHcastCpmBeans(relatedBeans);
        }


        if (collVhcastCpms != null)
        {
            List<VhcastCpmBean> relatedBeans = new ArrayList<VhcastCpmBean>(collVhcastCpms.size());
            for (Iterator<VhcastCpm> collVhcastCpmsIt = collVhcastCpms.iterator(); collVhcastCpmsIt.hasNext(); )
            {
                VhcastCpm related = (VhcastCpm) collVhcastCpmsIt.next();
                VhcastCpmBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setVhcastCpmBeans(relatedBeans);
        }


        if (collCastScenes != null)
        {
            List<CastSceneBean> relatedBeans = new ArrayList<CastSceneBean>(collCastScenes.size());
            for (Iterator<CastScene> collCastScenesIt = collCastScenes.iterator(); collCastScenesIt.hasNext(); )
            {
                CastScene related = (CastScene) collCastScenesIt.next();
                CastSceneBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastSceneBeans(relatedBeans);
        }


        if (collCastGoodss != null)
        {
            List<CastGoodsBean> relatedBeans = new ArrayList<CastGoodsBean>(collCastGoodss.size());
            for (Iterator<CastGoods> collCastGoodssIt = collCastGoodss.iterator(); collCastGoodssIt.hasNext(); )
            {
                CastGoods related = (CastGoods) collCastGoodssIt.next();
                CastGoodsBean relatedBean = related.getBean(createdBeans);
                relatedBeans.add(relatedBean);
            }
            result.setCastGoodsBeans(relatedBeans);
        }




        if (aAdType != null)
        {
            AdTypeBean relatedBean = aAdType.getBean(createdBeans);
            result.setAdTypeBean(relatedBean);
        }



        if (aAdOrder != null)
        {
            AdOrderBean relatedBean = aAdOrder.getBean(createdBeans);
            result.setAdOrderBean(relatedBean);
        }
        result.setModified(isModified());
        result.setNew(isNew());
        return result;
    }

    /**
     * Creates an instance of AdCast with the contents
     * of a AdCastBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed
     * @param bean the AdCastBean which contents are used to create
     *        the resulting class
     * @return an instance of AdCast with the contents of bean
     */
    public static AdCast createAdCast(AdCastBean bean)
        throws TorqueException
    {
        return createAdCast(bean, new IdentityMap());
    }

    /**
     * Creates an instance of AdCast with the contents
     * of a AdCastBean.
     * This behaviour could have also been achieved using a constructor,
     * however as this class is abstract no constructors are allowed.
     *
     * This method is intended for internal use only.
     * @param bean the AdCastBean which contents are used to create
     *        the resulting class
     * @param createdObjects a IdentityMap which maps beans
     *        to already created objects
     * @return an instance of AdCast with the contents of bean
     */

    public static AdCast createAdCast(AdCastBean bean, IdentityMap createdObjects)
        throws TorqueException
    {
        AdCast result = (AdCast) createdObjects.get(bean);
        if (result != null)
        {
            // we already have an object for the bean, return it
            return result;
        }
        result = new AdCast();
        createdObjects.put(bean, result);

        result.setId(bean.getId());
        result.setOrderId(bean.getOrderId());
        result.setCustomerId(bean.getCustomerId());
        result.setProductId(bean.getProductId());
        result.setName(bean.getName());
        result.setAdTypeId(bean.getAdTypeId());
        result.setDirectWay(bean.getDirectWay());
        result.setCastWay(bean.getCastWay());
        result.setInteractEffect(bean.getInteractEffect());
        result.setIsCopyright(bean.getIsCopyright());
        result.setPrice(bean.getPrice());
        result.setSpeedType(bean.getSpeedType());
        result.setTypePriority(bean.getTypePriority());
        result.setProductPriority(bean.getProductPriority());
        result.setVipPriority(bean.getVipPriority());
        result.setOrderPriority(bean.getOrderPriority());
        result.setCustomPriority(bean.getCustomPriority());
        result.setCustomNumPriority(bean.getCustomNumPriority());
        result.setCampPriority(bean.getCampPriority());
        result.setAreaPriority(bean.getAreaPriority());
        result.setChannelPriority(bean.getChannelPriority());
        result.setPlatformPriority(bean.getPlatformPriority());
        result.setUserPriority(bean.getUserPriority());
        result.setKeywordPriority(bean.getKeywordPriority());
        result.setVideogroupPriority(bean.getVideogroupPriority());
        result.setRoPriority(bean.getRoPriority());
        result.setSowType(bean.getSowType());
        result.setRateM(bean.getRateM());
        result.setRates(bean.getRates());
        result.setThreshold(bean.getThreshold());
        result.setRtbType(bean.getRtbType());
        result.setUpdateTime(bean.getUpdateTime());
        result.setStartDate(bean.getStartDate());
        result.setEndDate(bean.getEndDate());
        result.setRtbid(bean.getRtbid());
        result.setIdeaShowType(bean.getIdeaShowType());
        result.setMainCastId(bean.getMainCastId());
        result.setIsBak(bean.getIsBak());
        result.setDspId(bean.getDspId());
        result.setDealId(bean.getDealId());
        result.setSkipTime(bean.getSkipTime());
        result.setDirectType(bean.getDirectType());
        result.setPdbType(bean.getPdbType());
        result.setDangerIpWeight(bean.getDangerIpWeight());
        result.setChargeType(bean.getChargeType());
        result.setIsAiidTa(bean.getIsAiidTa());
        result.setStatus(bean.getStatus());
        result.setMutex(bean.getMutex());
        result.setChargeTime(bean.getChargeTime());
        result.setResourceType(bean.getResourceType());
        result.setOutside(bean.getOutside());
        result.setPbak(bean.getPbak());
        result.setIsArea(bean.getIsArea());



        {
            List<CastChannelBean> relatedBeans = bean.getCastChannelBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastChannelBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastChannelBean relatedBean =  relatedBeansIt.next();
                    CastChannel related = CastChannel.createCastChannel(relatedBean, createdObjects);
                    result.addCastChannelFromBean(related);
                }
            }
        }


        {
            List<CastAreaBean> relatedBeans = bean.getCastAreaBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastAreaBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastAreaBean relatedBean =  relatedBeansIt.next();
                    CastArea related = CastArea.createCastArea(relatedBean, createdObjects);
                    result.addCastAreaFromBean(related);
                }
            }
        }


        {
            List<CastPlatformBean> relatedBeans = bean.getCastPlatformBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastPlatformBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastPlatformBean relatedBean =  relatedBeansIt.next();
                    CastPlatform related = CastPlatform.createCastPlatform(relatedBean, createdObjects);
                    result.addCastPlatformFromBean(related);
                }
            }
        }


        {
            List<CastPositionBean> relatedBeans = bean.getCastPositionBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastPositionBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastPositionBean relatedBean =  relatedBeansIt.next();
                    CastPosition related = CastPosition.createCastPosition(relatedBean, createdObjects);
                    result.addCastPositionFromBean(related);
                }
            }
        }


        {
            List<CastHpositionBean> relatedBeans = bean.getCastHpositionBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastHpositionBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastHpositionBean relatedBean =  relatedBeansIt.next();
                    CastHposition related = CastHposition.createCastHposition(relatedBean, createdObjects);
                    result.addCastHpositionFromBean(related);
                }
            }
        }


        {
            List<CastVideogroupBean> relatedBeans = bean.getCastVideogroupBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastVideogroupBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastVideogroupBean relatedBean =  relatedBeansIt.next();
                    CastVideogroup related = CastVideogroup.createCastVideogroup(relatedBean, createdObjects);
                    result.addCastVideogroupFromBean(related);
                }
            }
        }


        {
            List<CastKeyBean> relatedBeans = bean.getCastKeyBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastKeyBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastKeyBean relatedBean =  relatedBeansIt.next();
                    CastKey related = CastKey.createCastKey(relatedBean, createdObjects);
                    result.addCastKeyFromBean(related);
                }
            }
        }


        {
            List<CastUserBean> relatedBeans = bean.getCastUserBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastUserBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastUserBean relatedBean =  relatedBeansIt.next();
                    CastUser related = CastUser.createCastUser(relatedBean, createdObjects);
                    result.addCastUserFromBean(related);
                }
            }
        }


        {
            List<CastPartneridBean> relatedBeans = bean.getCastPartneridBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastPartneridBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastPartneridBean relatedBean =  relatedBeansIt.next();
                    CastPartnerid related = CastPartnerid.createCastPartnerid(relatedBean, createdObjects);
                    result.addCastPartneridFromBean(related);
                }
            }
        }


        {
            List<CastPidBean> relatedBeans = bean.getCastPidBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastPidBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastPidBean relatedBean =  relatedBeansIt.next();
                    CastPid related = CastPid.createCastPid(relatedBean, createdObjects);
                    result.addCastPidFromBean(related);
                }
            }
        }


        {
            List<CastDqBean> relatedBeans = bean.getCastDqBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastDqBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastDqBean relatedBean =  relatedBeansIt.next();
                    CastDq related = CastDq.createCastDq(relatedBean, createdObjects);
                    result.addCastDqFromBean(related);
                }
            }
        }


        {
            List<CastCampaignBean> relatedBeans = bean.getCastCampaignBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastCampaignBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastCampaignBean relatedBean =  relatedBeansIt.next();
                    CastCampaign related = CastCampaign.createCastCampaign(relatedBean, createdObjects);
                    result.addCastCampaignFromBean(related);
                }
            }
        }


        {
            List<CastPaidBean> relatedBeans = bean.getCastPaidBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastPaidBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastPaidBean relatedBean =  relatedBeansIt.next();
                    CastPaid related = CastPaid.createCastPaid(relatedBean, createdObjects);
                    result.addCastPaidFromBean(related);
                }
            }
        }


        {
            List<CastPrdBean> relatedBeans = bean.getCastPrdBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastPrdBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastPrdBean relatedBean =  relatedBeansIt.next();
                    CastPrd related = CastPrd.createCastPrd(relatedBean, createdObjects);
                    result.addCastPrdFromBean(related);
                }
            }
        }


        {
            List<CastTagBean> relatedBeans = bean.getCastTagBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastTagBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastTagBean relatedBean =  relatedBeansIt.next();
                    CastTag related = CastTag.createCastTag(relatedBean, createdObjects);
                    result.addCastTagFromBean(related);
                }
            }
        }


        {
            List<CastEmbedBean> relatedBeans = bean.getCastEmbedBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastEmbedBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastEmbedBean relatedBean =  relatedBeansIt.next();
                    CastEmbed related = CastEmbed.createCastEmbed(relatedBean, createdObjects);
                    result.addCastEmbedFromBean(related);
                }
            }
        }


        {
            List<CastDirectionBean> relatedBeans = bean.getCastDirectionBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastDirectionBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastDirectionBean relatedBean =  relatedBeansIt.next();
                    CastDirection related = CastDirection.createCastDirection(relatedBean, createdObjects);
                    result.addCastDirectionFromBean(related);
                }
            }
        }


        {
            List<CastVipBean> relatedBeans = bean.getCastVipBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastVipBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastVipBean relatedBean =  relatedBeansIt.next();
                    CastVip related = CastVip.createCastVip(relatedBean, createdObjects);
                    result.addCastVipFromBean(related);
                }
            }
        }


        {
            List<CastCpmBean> relatedBeans = bean.getCastCpmBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastCpmBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastCpmBean relatedBean =  relatedBeansIt.next();
                    CastCpm related = CastCpm.createCastCpm(relatedBean, createdObjects);
                    result.addCastCpmFromBean(related);
                }
            }
        }


        {
            List<HcastCpmBean> relatedBeans = bean.getHcastCpmBeans();
            if (relatedBeans != null)
            {
                for (Iterator<HcastCpmBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    HcastCpmBean relatedBean =  relatedBeansIt.next();
                    HcastCpm related = HcastCpm.createHcastCpm(relatedBean, createdObjects);
                    result.addHcastCpmFromBean(related);
                }
            }
        }


        {
            List<VhcastCpmBean> relatedBeans = bean.getVhcastCpmBeans();
            if (relatedBeans != null)
            {
                for (Iterator<VhcastCpmBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    VhcastCpmBean relatedBean =  relatedBeansIt.next();
                    VhcastCpm related = VhcastCpm.createVhcastCpm(relatedBean, createdObjects);
                    result.addVhcastCpmFromBean(related);
                }
            }
        }


        {
            List<CastSceneBean> relatedBeans = bean.getCastSceneBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastSceneBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastSceneBean relatedBean =  relatedBeansIt.next();
                    CastScene related = CastScene.createCastScene(relatedBean, createdObjects);
                    result.addCastSceneFromBean(related);
                }
            }
        }


        {
            List<CastGoodsBean> relatedBeans = bean.getCastGoodsBeans();
            if (relatedBeans != null)
            {
                for (Iterator<CastGoodsBean> relatedBeansIt = relatedBeans.iterator(); relatedBeansIt.hasNext(); )
                {
                    CastGoodsBean relatedBean =  relatedBeansIt.next();
                    CastGoods related = CastGoods.createCastGoods(relatedBean, createdObjects);
                    result.addCastGoodsFromBean(related);
                }
            }
        }




        {
            AdTypeBean relatedBean = bean.getAdTypeBean();
            if (relatedBean != null)
            {
                AdType relatedObject = AdType.createAdType(relatedBean, createdObjects);
                result.setAdType(relatedObject);
            }
        }



        {
            AdOrderBean relatedBean = bean.getAdOrderBean();
            if (relatedBean != null)
            {
                AdOrder relatedObject = AdOrder.createAdOrder(relatedBean, createdObjects);
                result.setAdOrder(relatedObject);
            }
        }
    result.setModified(bean.isModified());
    result.setNew(bean.isNew());
      return result;
    }



    /**
     * Method called to associate a CastChannel object to this object.
     * through the CastChannel foreign key attribute
     *
     * @param toAdd CastChannel
     */
    protected void addCastChannelFromBean(CastChannel toAdd)
    {
        initCastChannels();
        collCastChannels.add(toAdd);
    }


    /**
     * Method called to associate a CastArea object to this object.
     * through the CastArea foreign key attribute
     *
     * @param toAdd CastArea
     */
    protected void addCastAreaFromBean(CastArea toAdd)
    {
        initCastAreas();
        collCastAreas.add(toAdd);
    }


    /**
     * Method called to associate a CastPlatform object to this object.
     * through the CastPlatform foreign key attribute
     *
     * @param toAdd CastPlatform
     */
    protected void addCastPlatformFromBean(CastPlatform toAdd)
    {
        initCastPlatforms();
        collCastPlatforms.add(toAdd);
    }


    /**
     * Method called to associate a CastPosition object to this object.
     * through the CastPosition foreign key attribute
     *
     * @param toAdd CastPosition
     */
    protected void addCastPositionFromBean(CastPosition toAdd)
    {
        initCastPositions();
        collCastPositions.add(toAdd);
    }


    /**
     * Method called to associate a CastHposition object to this object.
     * through the CastHposition foreign key attribute
     *
     * @param toAdd CastHposition
     */
    protected void addCastHpositionFromBean(CastHposition toAdd)
    {
        initCastHpositions();
        collCastHpositions.add(toAdd);
    }


    /**
     * Method called to associate a CastVideogroup object to this object.
     * through the CastVideogroup foreign key attribute
     *
     * @param toAdd CastVideogroup
     */
    protected void addCastVideogroupFromBean(CastVideogroup toAdd)
    {
        initCastVideogroups();
        collCastVideogroups.add(toAdd);
    }


    /**
     * Method called to associate a CastKey object to this object.
     * through the CastKey foreign key attribute
     *
     * @param toAdd CastKey
     */
    protected void addCastKeyFromBean(CastKey toAdd)
    {
        initCastKeys();
        collCastKeys.add(toAdd);
    }


    /**
     * Method called to associate a CastUser object to this object.
     * through the CastUser foreign key attribute
     *
     * @param toAdd CastUser
     */
    protected void addCastUserFromBean(CastUser toAdd)
    {
        initCastUsers();
        collCastUsers.add(toAdd);
    }


    /**
     * Method called to associate a CastPartnerid object to this object.
     * through the CastPartnerid foreign key attribute
     *
     * @param toAdd CastPartnerid
     */
    protected void addCastPartneridFromBean(CastPartnerid toAdd)
    {
        initCastPartnerids();
        collCastPartnerids.add(toAdd);
    }


    /**
     * Method called to associate a CastPid object to this object.
     * through the CastPid foreign key attribute
     *
     * @param toAdd CastPid
     */
    protected void addCastPidFromBean(CastPid toAdd)
    {
        initCastPids();
        collCastPids.add(toAdd);
    }


    /**
     * Method called to associate a CastDq object to this object.
     * through the CastDq foreign key attribute
     *
     * @param toAdd CastDq
     */
    protected void addCastDqFromBean(CastDq toAdd)
    {
        initCastDqs();
        collCastDqs.add(toAdd);
    }


    /**
     * Method called to associate a CastCampaign object to this object.
     * through the CastCampaign foreign key attribute
     *
     * @param toAdd CastCampaign
     */
    protected void addCastCampaignFromBean(CastCampaign toAdd)
    {
        initCastCampaigns();
        collCastCampaigns.add(toAdd);
    }


    /**
     * Method called to associate a CastPaid object to this object.
     * through the CastPaid foreign key attribute
     *
     * @param toAdd CastPaid
     */
    protected void addCastPaidFromBean(CastPaid toAdd)
    {
        initCastPaids();
        collCastPaids.add(toAdd);
    }


    /**
     * Method called to associate a CastPrd object to this object.
     * through the CastPrd foreign key attribute
     *
     * @param toAdd CastPrd
     */
    protected void addCastPrdFromBean(CastPrd toAdd)
    {
        initCastPrds();
        collCastPrds.add(toAdd);
    }


    /**
     * Method called to associate a CastTag object to this object.
     * through the CastTag foreign key attribute
     *
     * @param toAdd CastTag
     */
    protected void addCastTagFromBean(CastTag toAdd)
    {
        initCastTags();
        collCastTags.add(toAdd);
    }


    /**
     * Method called to associate a CastEmbed object to this object.
     * through the CastEmbed foreign key attribute
     *
     * @param toAdd CastEmbed
     */
    protected void addCastEmbedFromBean(CastEmbed toAdd)
    {
        initCastEmbeds();
        collCastEmbeds.add(toAdd);
    }


    /**
     * Method called to associate a CastDirection object to this object.
     * through the CastDirection foreign key attribute
     *
     * @param toAdd CastDirection
     */
    protected void addCastDirectionFromBean(CastDirection toAdd)
    {
        initCastDirections();
        collCastDirections.add(toAdd);
    }


    /**
     * Method called to associate a CastVip object to this object.
     * through the CastVip foreign key attribute
     *
     * @param toAdd CastVip
     */
    protected void addCastVipFromBean(CastVip toAdd)
    {
        initCastVips();
        collCastVips.add(toAdd);
    }


    /**
     * Method called to associate a CastCpm object to this object.
     * through the CastCpm foreign key attribute
     *
     * @param toAdd CastCpm
     */
    protected void addCastCpmFromBean(CastCpm toAdd)
    {
        initCastCpms();
        collCastCpms.add(toAdd);
    }


    /**
     * Method called to associate a HcastCpm object to this object.
     * through the HcastCpm foreign key attribute
     *
     * @param toAdd HcastCpm
     */
    protected void addHcastCpmFromBean(HcastCpm toAdd)
    {
        initHcastCpms();
        collHcastCpms.add(toAdd);
    }


    /**
     * Method called to associate a VhcastCpm object to this object.
     * through the VhcastCpm foreign key attribute
     *
     * @param toAdd VhcastCpm
     */
    protected void addVhcastCpmFromBean(VhcastCpm toAdd)
    {
        initVhcastCpms();
        collVhcastCpms.add(toAdd);
    }


    /**
     * Method called to associate a CastScene object to this object.
     * through the CastScene foreign key attribute
     *
     * @param toAdd CastScene
     */
    protected void addCastSceneFromBean(CastScene toAdd)
    {
        initCastScenes();
        collCastScenes.add(toAdd);
    }


    /**
     * Method called to associate a CastGoods object to this object.
     * through the CastGoods foreign key attribute
     *
     * @param toAdd CastGoods
     */
    protected void addCastGoodsFromBean(CastGoods toAdd)
    {
        initCastGoodss();
        collCastGoodss.add(toAdd);
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("AdCast:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("OrderId = ")
           .append(getOrderId())
           .append("\n");
        str.append("CustomerId = ")
           .append(getCustomerId())
           .append("\n");
        str.append("ProductId = ")
           .append(getProductId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("AdTypeId = ")
           .append(getAdTypeId())
           .append("\n");
        str.append("DirectWay = ")
           .append(getDirectWay())
           .append("\n");
        str.append("CastWay = ")
           .append(getCastWay())
           .append("\n");
        str.append("InteractEffect = ")
           .append(getInteractEffect())
           .append("\n");
        str.append("IsCopyright = ")
           .append(getIsCopyright())
           .append("\n");
        str.append("Price = ")
           .append(getPrice())
           .append("\n");
        str.append("SpeedType = ")
           .append(getSpeedType())
           .append("\n");
        str.append("TypePriority = ")
           .append(getTypePriority())
           .append("\n");
        str.append("ProductPriority = ")
           .append(getProductPriority())
           .append("\n");
        str.append("VipPriority = ")
           .append(getVipPriority())
           .append("\n");
        str.append("OrderPriority = ")
           .append(getOrderPriority())
           .append("\n");
        str.append("CustomPriority = ")
           .append(getCustomPriority())
           .append("\n");
        str.append("CustomNumPriority = ")
           .append(getCustomNumPriority())
           .append("\n");
        str.append("CampPriority = ")
           .append(getCampPriority())
           .append("\n");
        str.append("AreaPriority = ")
           .append(getAreaPriority())
           .append("\n");
        str.append("ChannelPriority = ")
           .append(getChannelPriority())
           .append("\n");
        str.append("PlatformPriority = ")
           .append(getPlatformPriority())
           .append("\n");
        str.append("UserPriority = ")
           .append(getUserPriority())
           .append("\n");
        str.append("KeywordPriority = ")
           .append(getKeywordPriority())
           .append("\n");
        str.append("VideogroupPriority = ")
           .append(getVideogroupPriority())
           .append("\n");
        str.append("RoPriority = ")
           .append(getRoPriority())
           .append("\n");
        str.append("SowType = ")
           .append(getSowType())
           .append("\n");
        str.append("RateM = ")
           .append(getRateM())
           .append("\n");
        str.append("Rates = ")
           .append(getRates())
           .append("\n");
        str.append("Threshold = ")
           .append(getThreshold())
           .append("\n");
        str.append("RtbType = ")
           .append(getRtbType())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        str.append("StartDate = ")
           .append(getStartDate())
           .append("\n");
        str.append("EndDate = ")
           .append(getEndDate())
           .append("\n");
        str.append("Rtbid = ")
           .append(getRtbid())
           .append("\n");
        str.append("IdeaShowType = ")
           .append(getIdeaShowType())
           .append("\n");
        str.append("MainCastId = ")
           .append(getMainCastId())
           .append("\n");
        str.append("IsBak = ")
           .append(getIsBak())
           .append("\n");
        str.append("DspId = ")
           .append(getDspId())
           .append("\n");
        str.append("DealId = ")
           .append(getDealId())
           .append("\n");
        str.append("SkipTime = ")
           .append(getSkipTime())
           .append("\n");
        str.append("DirectType = ")
           .append(getDirectType())
           .append("\n");
        str.append("PdbType = ")
           .append(getPdbType())
           .append("\n");
        str.append("DangerIpWeight = ")
           .append(getDangerIpWeight())
           .append("\n");
        str.append("ChargeType = ")
           .append(getChargeType())
           .append("\n");
        str.append("IsAiidTa = ")
           .append(getIsAiidTa())
           .append("\n");
        str.append("Status = ")
           .append(getStatus())
           .append("\n");
        str.append("Mutex = ")
           .append(getMutex())
           .append("\n");
        str.append("ChargeTime = ")
           .append(getChargeTime())
           .append("\n");
        str.append("ResourceType = ")
           .append(getResourceType())
           .append("\n");
        str.append("Outside = ")
           .append(getOutside())
           .append("\n");
        str.append("Pbak = ")
           .append(getPbak())
           .append("\n");
        str.append("IsArea = ")
           .append(getIsArea())
           .append("\n");
        return(str.toString());
    }
}
