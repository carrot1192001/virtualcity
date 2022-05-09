<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试工具</title>
<link rel="shortcut icon" href="alimamalogo.jpg" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="../js/ajax/css/timePicker.css">
<script type="text/javascript" src="../js/ajax/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../js/ajax/jquery-timepicker.js"></script>
<style>
* {
	font-size: 12px;
	font-family: 宋体;
}

input, select {
	width: 100px;
}

.table1 {
	border-collapse: collapse;
	border: solid 1px #aaaaaa;
}

.table1 td {
	padding: 2px;
}

.c_os {
	background-color: #ffff99;
}

.c_tudou {
	background-color: #ffcc33;
}

.c_mb {
	background-color: #66ffff;
}

.c_subos {
	background-color: #ccff99;
}

.c_url {
	background-color: #cccccc;
}

.c_fob {
	background-color: #ffccff;
}

.zinput {
	position: absolute;
	width: 82px;
	border-right: none;
}

.zselect {
	
}
</style>
</head>

<body>
	<form id="frm1" onsubmit="return false;">
		<table class="table1" border=0>
			<tr style="border-bottom: solid 1px" class="c_url">
				<td class="c_url">广告类型</td>
				<td class="c_url"><select id="url0" onchange="reset_inputs()">
						<option value="vf">前贴</option>
						<option value="vb">后贴</option>
						<option value="vp">暂停</option>
						<option value="vo">中插</option>
						<option value="vc">角标</option>
						<option value="html">页面</option>
						<option value="vhtml">VHTML</option>
						<option value="mf">移动前贴</option>
						<option value="mo">移动中插</option>
						<option value="mb">移动后贴</option>
						<option value="mp">移动暂停</option>
						<option value="mc">移动角标</option>
						<option value="mi">移动开机图</option>
						<option value="feeds">信息流</option>
						
				</select></td>
				<td></td>
				<td></td>
				<td></td>
				<td><label><input type="checkbox" id="cls_out" checked
						style="width: 20px;">清除</label> 调用</td>
				<td><input type="text" id="get_count" value="1"></td>
				<td>次</td>
			</tr>
			<tr>
				<td>site</td>
				<td>p</td>
				<td>v视频ID</td>
				<td>vl视频时长</td>
				<td>td优酷正本视频</td>
				<td class="c_fob">ev入口营销</td>
				<td class="c_fob">rt</td>
				<td class="c_fob">ctu连播</td>
			</tr>
			<tr>
				<td><select id="site" name="site" onchange="reset_inputs()">
						<option id="site_youku" value="1">优酷</option>
						<option id="site_tudou" value="-1">土豆</option>
				</select></td>
				<td><input type="text" id="p" name="p" value="1" class="zinput">
					<select class="zselect" onchange="set_input(this)">
						<option value="1">1=前贴</option>
						<option value="2">2=后贴</option>
						<option value="3">3=中插</option>
						<option value="4">4=暂停</option>
						<option value="5">5=角标</option>
						<option value="7">7=移动前贴</option>
						<option value="8">8=移动中插</option>
						<option value="9">9=移动后贴</option>
						<option value="10">10=移动暂停</option>
						<option value="11">11=移动角标</option>
						<option value="12">12=移动开机图</option>
						<option value="863">优酷VHTML</option>
						<option value="101010">土豆VHTML</option>
				</select></td>
				<td><input type="text" id="vid" name="v" value="137006183"></td>
				<td><input type="text" name="vl" value="1200" class="zinput">
					<select class="zselect" onchange="set_input(this)">
						<option value="1200" selected>20分钟
						<option value="300">5分钟
						<option value="180">3分钟
						<option value="120">2分钟
						<option value="60">1分钟
						<option value="30">半分钟
				</select></td>
				<td><input type="text" name="td"></td>
				<td class="c_fob"><input type="text" name="ev"></td>
				<td class="c_fob"><input type="hidden" id="rt" name="rt">
					<select id="rt_sel">
						<option value="0">不屏蔽</option>
						<option value="1">屏蔽广告</option>
				</select></td>
				<td class="c_fob"><select name="ctu">
						<option value="0" selected>0=非连播
						<option value="1">1=连播
				</select></td>
			</tr>
			<tr>
				<td>vs接口版本</td>
				<td>ct一级分类</td>
				<td>cs二级分类</td>
				<td>paid</td>
				<td>sid</td>
				<td>fu全屏</td>
				<td class="c_fob">ps中插点序号</td>
				<td class="c_fob">pt中插时间点</td>
			</tr>
			<tr>
				<td><input type="text" name="vs" value="1.0"></td>
				<td><select name="ct">
						<option value="a">优酷资讯
						<option value="b">优酷原创
						<option value="c">优酷电影
						<option value="d">优酷电视剧
						<option value="e">优酷体育
						<option value="f">优酷音乐
						<option value="g">优酷游戏
						<option value="h">优酷动漫
						<option value="i">优酷女性
						<option value="j">优酷搞笑
						<option value="k">优酷自拍
						<option value="l">优酷广告
						<option value="m">优酷生活
						<option value="n">优酷汽车
						<option value="o">优酷科技
						<option value="p">优酷无分类
						<option value="q">优酷时尚
						<option value="r">优酷母婴
						<option value="s">优酷旅游
						<option value="t">优酷教育
						<option value="u">优酷娱乐
						<option value="v">优酷综艺
						<option value="w">优酷纪录片
						<option value="key">优酷关键字
						<option value="z">优酷其他
						<option value="zw">优酷站外
						<option value="wi">优酷老iPad
						<option value="1">土豆娱乐
						<option value="3">土豆乐活
						<option value="5">土豆搞笑
						<option value="9">土豆动画
						<option value="10">土豆游戏
						<option value="12">土豆商品
						<option value="14">土豆音乐
						<option value="15">土豆体育
						<option value="21">土豆科技
						<option value="22">土豆电影
						<option value="23">土豆其他
						<option value="24">土豆财富
						<option value="25">土豆教育
						<option value="26">土豆汽车
						<option value="27">土豆女性
						<option value="29">土豆热点
						<option value="30">土豆电视剧
						<option value="31">土豆综艺
						<option value="32">土豆风尚
						<option value="33">土豆美容
						<option value="34">土豆健康
						<option value="99">土豆原创
						<option value="35">土豆站外
						<option value="100">土豆分享
						<option value="104">土豆城市
						<option value="28">土豆纪录片
						<option value="shouye">首页精选
						<option value="discover">发现页
						<option value="discoverdark">关灯页
						<option value="kandian">看点页						
						<option value="playpage">播放页					
						<option value="chuilei">垂类频道
						
				</select></td>
				<td><input type="text" name="cs"></td>
				<td><select name="paid">
						<option value="0" selected>0=普通视频
						<option value="1">1=收费视频
				</select></td>
				<td><input type="text" name="sid" id="sid"></td>
				<td><select name="fu">
						<option value="0" selected>非全屏
						<option value="1">全屏
				</select></td>
				<td class="c_fob"><input type="text" name="ps" id="ps" value="0"></td>
				<td class="c_fob"><input type="text" name="pt" id="pt" value="0"></td>
			</tr>
			<tr>
				<td>wintype</td>
				<td>s节目</td>
				<td>u视频上传用户</td>
				<td>vip</td>
				<td>ac</td>
				<td>partnerid</td>
				<td>atm</td>
				<td>emb</td>
			</tr>
			<tr>
				<td><select id="wintype" name="wintype">
						<option value="index">首页焦点视频
						<option value="interior" selected>站内
						<option value="exterior">站外
						<option value="adshow">焦点视频
						<option value="BDskin">合作播放器
						<option value="mdevice">移动
						<option value="touch">touch
						<option value="xplayer_m3u8">xplayer_m3u8
				</select></td>
				<td><input type="text" id = "s" name="s" value="289836"></td>
				<td><input type="text" name="u" value="1234567" class="zinput">
					<select class="zselect" onchange="set_input(this)">
						<option value="1234567" selected>1234567
						<option value="4098051">4098051
						<option value="121819866">121819866
				</select></td>
				<td><select id ="vip" name="vip">
						<option value="0" selected>0=不是
						<option value="1">1=可能是
				</select></td>
				<td><input type="text" name="ac" value=""></td>
				<td><input type="text" name="partnerid" value="" class="zinput">
					<select class="zselect" onchange="set_input(this)">
						<option value="" selected>
						<option value="XMjAxNg==">XMjAxNg==
						<option value="XMjAyMA==">XMjAyMA==
						<option value="XMjAyOA==">XMjAyOA==
						<option value="XMjAzNg==">XMjAzNg==
						<option value="XMjAyNA==">XMjAyNA==
						<option value="XMjAzMg==">XMjAzMg==
						<option value="XMjA0MA==">XMjA0MA==
				</select></td>
				<td><input type="text" name="atm"></td>
				<td><input type="text" name="emb"></td>
			</tr>
			<tr>
				<td class="c_os">os系统</td>
				<td class="c_tudou">d豆单/专辑</td>
				<td class="c_tudou">tict黑白灰</td>
				<td class="c_tudou">uk用户令牌</td>
				<td class="c_tudou">tpa</td>
				<td class="c_tudou">prd=tvb</td>
				<td class="c_tudou">pw播放器尺寸</td>
				<td class="c_tudou">ph角标暂停用</td>
			</tr>
			<tr>
				<td class="c_os"><select id="os" name="os">
						<option value="Windows 7">Windows 7
						<option value="Windows 8">Windows 8
						<option value="Windows XP" selected>Windows XP
						<option value="ios">ios
						<option value="Android">Android
				</select></td>
				<td class="c_tudou"><input type="text" name="d"></td>
				<td class="c_tudou"><select name="tict">
						<option value="1">1=黑视频
						<option value="2">2=白视频
						<option value="3">3=灰视频
				</select></td>
				<td class="c_tudou"><input type="text" name="uk"></td>
				<td class="c_tudou"><input type="text" name="tpa"></td>
				<td class="c_tudou"><input type="text" name="prd"
					class="zinput"> <select class="zselect"
					onchange="set_input(this)">
						<option value="" selected>
						<option value="tvb">tvb
				</select></td>
				<td class="c_tudou"><input type="text" name="pw" value="640"></td>
				<td class="c_tudou"><input type="text" name="ph" value="520"></td>
			</tr>
			<tr>
				<td class="c_os c_subos c_mb">bt设备</td>
				<td class="c_mb">bd品牌</td>
				<td class="c_mb">guid</td>
				<td class="c_mb">ouid</td>
				<td class="c_mb">mac网卡地址</td>
				<td class="c_mb">net是否WIFI</td>
				<td class="c_mb">isp</td>
				<td class="c_mb">idfa</td>
			</tr>
			<tr>
				<td class="c_os c_subos c_mb"><select id="bt" name="bt">
						<option value="pad">pad
						<option value="phone" selected>phone
						<option value="tv">tv
						<option value="pc">pc
				</select></td>
				<td class="c_mb"><input type="text" name="bd"></td>
				<td class="c_mb"><input type="text" name="guid"></td>
				<td class="c_mb"><input type="text" name="ouid"></td>
				<td class="c_mb"><input type="text" name="mac"></td>
				<td class="c_mb"><input type="text" name="net" class="zinput">
					<select class="zselect" onchange="set_input(this)">
						<option value="" selected>
						<option value="1000">WIFI
				</select></td>
				<td class="c_mb"><input type="text" name="isp"></td>
				<td class="c_mb"><input type="text" name="idfa"></td>
			</tr>
			<tr>
				<td class="c_os c_subos c_mb">App/Web</td>
				<td class="c_mb">avs客户端版本号</td>
				<td class="c_mb">ip</td>
				<td class="c_mb">pid移动品牌</td>
				<td class="c_mb">noqt不出前贴</td>
				<td class="c_mb">px开机图尺寸</td>
				<td class="">rst视频种类</td>
				<td class="">dq视频清析度</td>
			</tr>
			<tr>
				<td class="c_os c_subos c_mb"><select id="aw" name="aw"
					onchange="reset_inputs()">
						<option value="a" selected>app
						<option value="w">web
				</select></td>
				<td class="c_mb"><input type="text" name="avs"></td>
				<td class="c_mb"><input type="text" name="ip"></td>
				<td class="c_mb"><input type="text" name="pid"></td>
				<td class="c_mb"><select name="noqt">
						<option value="0" selected>0-可出前贴
						<option value="1">1-不出前贴
				</select></td>
				<td class="c_mb"><input type="text" name="px" value="480*800"
					class="zinput"> <select class="zselect"
					onchange="set_input(this)">
						<option value="480*800">480*800</option>
						<option value="640*940">640*940</option>
						<option value="640*1116">640*1116</option>
						<option value="768*1004">768*1004</option>
						<option value="1024*748">1024*748</option>
						<option value="1024*600">1024*600</option>
						<option value="800*1280">800*1280</option>
						<option value="1280*800">1280*800</option>
				</select></td>
				<td class=""><input type="text" id="rst" name="rst" value="flv"
					class="zinput"> <select id ="rst_type" class="zselect"
					onchange="set_input(this)">
						<option value="flv" selected>flv
						<option value="hd2">hd2
						<option value="m3u8">m3u8
						<option value="3gphd">3gphd
						<option value="img,h5">img,h5(角标)
						<option value="img">img
						<option value="video">video
						<option value="img,video">img,video(信息流)
				</select></td>
				<td class=""><input type="text" name="dq" value="flv"
					class="zinput"> <select class="zselect"
					onchange="set_input(this)">
						<option value="flv" selected>flv
						<option value="mp4">mp4
						<option value="hd2">hd2
						<option value="auto">auto
				</select></td>
			</tr>
			<tr>
				<td>union</td>
				<td>callback</td>
				<td>adext预览素材</td>
				<td>k关键字</td>
				<td>渠道号</td>
				<td>vit</td>
				<td>feeds广告位</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" name="union"></td>
				<td><input type="text" id="callback" name="callback"></td>
				<td><input type="text" name="adext"></td>
				<td><input type="text" name="k"></td>
				<td><input type="text" name="ccode" value="0502"></td>
				<td class=""><input type="text" name="vit" value="2"
					class="zinput"> <select id ="vit" class="zselect" 
					onchange="set_input(this)">
						<option value="0" >未知
						<option value="1">未传
						<option value="2" selected>正片
						<option value="3">预告片
						<option value="4">花絮
						<option value="5">普通视频
						<option value="6">资讯
						<option value="7">MV
						<option value="8">首映式
						<option value="9">伪正片(videotype新增未告知的均按未知处理)	
				</select></td>
				<td class=""><input type="text" name="feeds_shua" value="1522090"
					class="zinput"> <select id ="feeds_shua" class="zselect" 
					onchange="set_input(this)">
						<option value="1522090" selected>首页第一刷
						<option value="1522091">首页第二刷
						<option value="1522136">首页第三刷
						<option value="1522137">首页第四刷
						<option value="1522138">首页第五刷
						<option value="1522139">首页第六刷
						<option value="1522140">首页第七刷
						<option value="1522141">首页第八刷
						<option value="1522080">看点页第一刷
						<option value="1522081">看点页第二刷
						<option value="1522084">发现页第一刷
						<option value="1522085">发现页第二刷
						<option value="1522082">播放页第一刷
						<option value="1522083">播放页第二刷
						<option value="1522128">关灯页第一刷
						<option value="1522129">关灯页第二刷
						<option value="1522126">垂类(军事)第一刷
						<option value="1522127">垂类(军事)第二刷
						
				</select></td>
				<td><input type="button" value="生成链接" onclick="show_url()"></td>
			</tr>
		</table>
	</form>

	<div style="width: 840px; text-align: right">
		<input id="url1" name="url1" type="text" style="width: 840px;"><br> <a
			id="link1" target="_blank">打开链接</a>
	</div>
	
	<div style="width: 840px; text-align: right">
                               投放时间段：<input type="text" id="timePicker_starttime" name="1" value = "00:00"> -
         <input type="text" id="timePicker_endtime" name="2" value="23:59" >
	</div>

	<div id="div_video"
		style="position: fixed; left: 20px; top: 20px; display: none; width: 640px; background-color: #ffffff; border: solid 1px blue; text-align: center">
		<div style="text-align: right; background-color: #33ccff">
			<a href="javascript:void(0)"
				style="color: white; text-decoration: none;"
				onclick="close_video();return false;">关闭</a>
		</div>
		<script>
			function getFlashHtml(mv, id, w, h, wmode, vars, style) {
				if (window.ActiveXObject)
					return '<object id="'+id+'" style="'+style+'" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,115,0" width="'+w+'" height="'+h+'" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" ><param name="movie" value="'+mv+'" /><param name="FlashVars" value="'+vars+'" /><param name="wmode" value="'+wmode+'" /><param name="allowScriptAccess" value="always" /><param name="allowFullScreen" value="true" /></object>';
				return '<embed id="'
						+ id
						+ '" name="'
						+ id
						+ '" style="'
						+ style
						+ '" width="'
						+ w
						+ '" height="'
						+ h
						+ '" src="'
						+ mv
						+ '" wmode="'
						+ wmode
						+ '" allowFullScreen="true" allowScriptAccess="always" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" FlashVars="'
						+ vars
						+ '" type="application/x-shockwave-flash"></embed>';
			};
			document.write(getFlashHtml("simpleplayer.swf", "video1", 640, 360,
					"opaque", "", ""));
		</script>
	</div>

	<div id="output"></div>


	<script>
		var need_callback = {};
		var isweb = true;

		var domain = "http://val.atm.youku.com/";

		$(function() {
			reset_inputs();
			if (location.href.indexOf("http://") != 0) {
				isweb = false;
				$("#callback").val("func")
			} else {
				//domain = location.href.substring(0, location.href.indexOf("/",8) + 0);
				domain = "http://11.163.164.4/";
			}
		});

		function reset_inputs() {
			var url = $("#url0").val();
			var site = $("#site").val();

			if (url == 'html' && (site == '1' || site == '-1')) {
				$("#site_youku").val("");
				$("#site_tudou").val("tudou");
			} else if (site == '' || site == 'tudou') {
				$("#site_youku").val("1");
				$("#site_tudou").val("-1");
			}
			if (site == "")
				site = 1;
			if (site == "tudou")
				site = -1;

			var aw = $("#aw").val();

			if (p_val[url]) {
				$("#p").val(p_val[url]);
			} else {
				$("#p").val("");
			}
			if (url == "vhtml") {
				$("#p").val(site == 1 ? "863" : "101010");
			}
			if (url.length == 2 && url.indexOf("m") == 0) {
				$("#wintype").val("mdevice");
				var os = $("#os").val();
				if (os != "ios" && os != "Android") {
					$("#os").val("ios");
				}
			} else {
				$("#wintype").val("interior");
				var os = $("#os").val();
				if (os == "ios" || os == "Android") {
					$("#os").val("windows XP");
				}
			}
			
			if(url == 'feeds'){
				$("#os").val("ios");
				$("#bt").val("phone");				
				$("#wintype").val("mdevice");				
				$("#rst_type").val("img,video");
				$("#rst").val("img,video");
			}
			
			if(url == 'vc' || url == 'mc'){
				$("#rst_type").val("img,h5");
				$("#rst").val("img,h5");
			}
			
			if(url == 'mf'){
				$("#vid").val("28008737");
				$("#s").val("18988");
				$("#rst").val("flv");
			}

			var inputs = $("#frm1")[0].getElementsByTagName("*");
			//alert("total tags are :" + inputs.length);
			var j = cols_index[url];
			//alert("j is :" + j);
			for (var i = 0; i < inputs.length; i++) {
				var o = inputs[i];
				if (o.tagName != "INPUT" && o.tagName != "SELECT")
					continue;
				var n = o.getAttribute("name") || o.getAttribute("id");
				//alert("n is :" + n);
				if (n && cols[n]) {
					//alert("cols[n] is :" +  cols[n]);
					var f = cols[n][j];
					//alert("cols[n][j] is:" + cols[n][j]);
					if (f) {
						if (pf[n] && pf[n] != site) {
							f = 0;
						}
						if ((n == 'ip' || n == 'avs') && aw != 'a') {
							f = 0;
						}
					}
					if (f) {
						o.disabled = false;
						o.style.backgroundColor = "white";
					} else {
						o.disabled = true;
						o.style.backgroundColor = "gray";
					}
				}
			}
		}

		function set_input(sel) {
			var o = sel;
			while (o.previousSibling) {
				o = o.previousSibling;
				if (o.tagName == "INPUT") {
					o.value = sel.value;
					return;
				}
			}
		}

		function show_url() {
			
			var ssp_pos = "";
			
			var ssp_config = "";
			
			var vip = "";
			
			var ssp_kanInfo = "";
			
			var u = $("#url0").val();
			var feeds_shua = $("#feeds_shua").val();
			//alert(feeds_shua);

			var site = $("#site").val();
			if (u == "/vf" && site == 1) {
				setRT();
			}
			
			var os = $("#os").val();
			var bt = $("#bt").val();
			var aw = $("#aw").val();
			var vip = $("#vip").val();
			
				
			if (u == 'mf' && site == 1 && os == 'ios' && bt == 'phone' && aw == 'a') {
				ssp_pos = "&ssp_pos=60006,60030,60054,60078,60102,60126,60150,60174,60996,61057";
			}
			
			//<option value="1522090" selected>首页第一刷
            //<option value="1522091">首页第二刷
            //<option value="1522080">看点页第一刷
            //<option value="1522081">看点页第二刷
            //<option value="1522084">发现页第一刷
            //<option value="1522085">发现页第二刷
            //<option value="1522082">播放页第一刷
            //<option value="1522083">播放页第二刷
            //<option value="1522128">关灯页第一刷
            //<option value="1522129">关灯页第二刷
            //<option value="1522126">垂类(军事)第一刷
            //<option value="1522127">垂类(军事)第二刷

			//工具生成参数；
			///http://11.163.164.4/adv?site=1&v=137006183&vl=1200&td=&ev=&rt=&ctu=0&vs=1.0&ct=a&cs=&paid=0&sid=1&fu=0&ps=0&pt=0&wintype=interior&s=289836&u=1234567&vip=0&ac=&partnerid=&atm=&emb=&os=ios&d=&bt=phone&bd=&guid=&ouid=&mac=&net=&isp=&idfa=&aw=a&avs=&ip=&pid=&noqt=0&px=480*800&rst=img%2Cvideo&dq=flv&union=&callback=&adext=&k=&ccode=0502&p=1522080&ssp_pos=61387,61388,61433&ups_vip=0&ssp_noad=0&ssp_kanInfo=1
			
			//服务端抓取参数：
			///adv?ipver=&pid=64b6847e992c4c45&net=1000&ssp_noad=0&use_https=0&isvert=0&site=1&idfa=A1F93DBC-4359-4B27-88E1-DC4EF98E52F6&dprm=3000&feedtype=2&isp=%E4%B8%AD%E5%9B%BD%E8%81%94%E9%80%9A_46001&ssp_close=1&utdid=WEeEzBjhlT0DAB%2BfFyG13puN&bucket_path=&iptype=0&ssp_kanInfo=1&ps=6&ssp_pos=61433%2C61388%2C61387&vs=1.0&ssp_ml=0&ssp_mc=3&bd=apple&aliaid=&ssp_cl=0&reqid=0befa45100000ed85b62d15d00000b0a&flowmark=&v=&sver=1.0.34&ua=Youku%3B7.4.0.1%3BiOS%3B11.4.1%3BiPhone9%2C2&_login=0&ip=106.11.34.15&_sign=f04c3da200e03a25e8e25760b800286376e159dc&cs=kandian&vip=0&flowfrom=feedserver&dvh=2208&ssp_traffic=0&ct=kandian&mdl=iPhone9%2C2&aidif=dd09acf6a6f13ed23da6f1b13a2b2dbc&bt=phone&stoken=&dvw=1242&guid=7066707c5bdc38af1621eaf94a6fe779&os=ios&rst=img%2Cvideo&ouid=63665a4c3285293f53f70bddd31873393ff22e50&aw=a&osv=11.4.1&avs=7.4.0.1&p=1522080
			if(u == 'feeds' && site == 1 && bt == 'phone' && aw == 'a'){
				if(os == 'ios'){
					if(feeds_shua == '1522090'){
						ssp_pos = "&ssp_pos=61327,61328";
					}
					if(feeds_shua == '1522091'){
						ssp_pos = "&ssp_pos=61329,61330,";
					}
					if(feeds_shua == '1522080'){
						ssp_pos = "&ssp_pos=61387,61388,61433";
					}
					if(feeds_shua == '1522081'){
						ssp_pos = "&ssp_pos=61389,61395,61426,61434";
					}
					if(feeds_shua == '1522084'){
						ssp_pos = "&ssp_pos=61342,61343,61435,";
					}
					if(feeds_shua == '1522085'){
						ssp_pos = "&ssp_pos=61344,61393,61427";
					}
					if(feeds_shua == '1522082'){
						ssp_pos = "&ssp_pos=61326,61331,61438,61439";
					}
					if(feeds_shua == '1522083'){
						ssp_pos = "&ssp_pos=61332,61333,61428";
					}
					if(feeds_shua == '1522128'){
						ssp_pos = "&ssp_pos=61446";
					}
					if(feeds_shua == '1522129'){
						ssp_pos = "&ssp_pos=61447";
					}
					if(feeds_shua == '1522126'){
						ssp_pos = "&ssp_pos=61442,61443";
					}
					if(feeds_shua == '1522127'){
						ssp_pos = "&ssp_pos=61449";
					}
				}
				
				if(os == 'Android'){
					if(feeds_shua == '1522090'){
						ssp_pos = "&ssp_pos=61334,61335,61352,61436,61444,61445";
					}
					if(feeds_shua == '1522091'){
						ssp_pos = "&ssp_pos=61329,61330,";
					}
					if(feeds_shua == '1522080'){
						ssp_pos = "&ssp_pos=61387,61388,61433";
					}
					if(feeds_shua == '1522081'){
						ssp_pos = "&ssp_pos=61389,61395,61426,61434";
					}
					if(feeds_shua == '1522084'){
						ssp_pos = "&ssp_pos=61342,61343,61435,";
					}
					if(feeds_shua == '1522085'){
						ssp_pos = "&ssp_pos=61344,61393,61427";
					}
					if(feeds_shua == '1522082'){
						ssp_pos = "&ssp_pos=61326,61331,61438,61439";
					}
					if(feeds_shua == '1522083'){
						ssp_pos = "&ssp_pos=61332,61333,61428";
					}
					if(feeds_shua == '1522128'){
						ssp_pos = "&ssp_pos=61446";
					}
					if(feeds_shua == '1522129'){
						ssp_pos = "&ssp_pos=61447";
					}
					if(feeds_shua == '1522126'){
						ssp_pos = "&ssp_pos=61451";
					}
					if(feeds_shua == '1522127'){
						ssp_pos = "&ssp_pos=61452";
					}
				}
			}
            
            if(u == 'mc' && site == 1 && bt == 'phone' && os == 'ios' && aw == 'a'){
            	var ps = $("#ps").val();
            	var vit_value = $("#vit").val();
            	if(ps == '0'){
            		
            		if(vit_value == '2'){
            			ssp_pos = "&ssp_pos=60212";
            		}
            		
            		if(vit_value == '3' || vit_value == '4'){
            			ssp_pos = "&ssp_pos=60935";
            		}           			
            	}
            	if(ps=='1'){
        			ssp_pos = "&ssp_pos=60217";           			
        	    }
            	
            	if(ps=='2'){
        			ssp_pos = "&ssp_pos=60222";           			
        	    }
            	
            	if(ps=='3'){
        			ssp_pos = "&ssp_pos=60227";           			
        	    }
            }
            
            if(u == 'mc' && site == 1 && bt == 'phone' && os == 'Android' && aw == 'a'){
            	var ps = $("#ps").val();
            	var vit_value = $("#vit").val();
            	if(ps == '0'){
            		
            		if(vit_value == '2'){
            			ssp_pos = "&ssp_pos=60213";
            		}
            		
            		if(vit_value == '3' || vit_value == '4'){
            			ssp_pos = "&ssp_pos=60936";
            		}           			
            	}
            	if(ps=='1'){
        			ssp_pos = "&ssp_pos=60218";           			
        	    }
            	
            	if(ps=='2'){
        			ssp_pos = "&ssp_pos=60223";           			
        	    }
            	
            	if(ps=='3'){
        			ssp_pos = "&ssp_pos=60228";           			
        	    }
            }
            
            
            
            if(u == 'feeds'){
            	ssp_kanInfo = "&ssp_kanInfo=1";
            }
			
			//广告时长，个数规则todo,默认使用ssp时长规则
			if (u == 'vf' || u == 'vb' || u == 'vo' || u == 'mf' || u == 'mo' || u == 'mb'){
				ssp_config = '&ssp_cl=1&ssp_mc=4&ssp_ml=64';
			}
			
			if(vip == 0){
				vip = '&ups_vip=0';
			}
			
			//atm服务端给吐出广告
			var ssp_noad = '&ssp_noad=0';

			var url = domain + "adv?" + $("#frm1").serialize() + ssp_pos + ssp_config + vip + ssp_noad + ssp_kanInfo;
			//alert("我是警告框！！")
			var referrer = "http://v.youku.com";
            var afterUrl = url.replace(/feeds_shua/g, "p");
			$("#url1").val(afterUrl);
			$("#link1")[0].href = afterUrl;
			$("#link2")[0].href = "debug.jsp?url=" + encodeURIComponent(afterUrl) + "&referrer=" + encodeURIComponent(referrer);

			var test_count = parseInt($("#get_count").val());
			if (!test_count)
				test_count = 1;

			if ($("#cls_out")[0].checked) {
				$("#output").html("");
			}

			if (u == "/html" || u == "/vhtml")
				test_html(url);
			else
				test_url(url, test_count);
		}

		function getJSON(url, func) {
			var cb = $("#callback").val();
			if (cb) {
				var sc = document.createElement("script");
				window[cb] = function(r) {
					func(r);
					sc.parentNode.removeChild(sc);
					window[cb] = null;
				};
				sc.src = url;
				document.getElementsByTagName("head")[0].appendChild(sc);
			} else {
				url = url.substring(url.indexOf("/", 8), url.length);
				$.getJSON(url, func);
			}
		}

		function getScript(url) {
			var sc = document.createElement("script");
			sc.src = url;
			document.getElementsByTagName("head")[0].appendChild(sc);
		}

		function test_url(url, count) {
			getJSON(
					url,
					function(r) {
						if (!r) {
							$("#output").append("<div>return is null</div>");
						} else {
							var s = "<div style='width:800px;border-bottom:solid 1px gray;'>&nbsp;</div>";
							s += "P=" + (r.P ? r.P : "") + "<br>";
							if (r.SEED) {
								s += "SEED size=" + r.SEED.length + "<br>";
								for (var i = 0; i < r.SEED.length; i++) {
									var v = r.SEED[i];
									if (v.SUS) {
										for (var j = 0; j < v.SUS.length; j++) {
											var su = v.SUS[j];
											if (su.U)
												s += lnk_div("SUS", su.U);
										}
									}
									if (v.SUE) {
										for (var j = 0; j < v.SUE.length; j++) {
											var su = v.SUE[j];
											if (su.U)
												s += lnk_div("SUE", su.U);
										}
									}
									s += "<br>";
								}
							} else {
								s += "SEED is null<br>";
							}
							if (r.JS) {
								s += "JS size=" + r.JS.length + "<br>";
								for (var i = 0; i < r.JS.length; i++) {
									var v = r.JS[i];
									var atmsu = v.SUS[0].U;
									var ca = atmsu.substring(atmsu
											.indexOf("&ca=") + 4, atmsu
											.indexOf("&",
													atmsu.indexOf("&ca=") + 4));
									var ie = atmsu.substring(atmsu
											.indexOf("&ie=") + 4, atmsu
											.indexOf("&",
													atmsu.indexOf("&ie=") + 4));
									s += "<div style='color:red'>ie="
											+ parseInt(ie) + " ca="
											+ parseInt(ca) + " at=" + v.AT
											+ " al=" + v.AL + "</div>";
								}
								for (var i = 0; i < r.JS.length; i++) {
									var v = r.JS[i];
									if (v.SUS) {
										for (var j = 0; j < v.SUS.length; j++) {
											var su = v.SUS[j];
											if (su.U)
												s += lnk_div("SUS", su.U);
										}
									}
									if (v.SUE) {
										for (var j = 0; j < v.SUE.length; j++) {
											var su = v.SUE[j];
											if (su.U)
												s += lnk_div("SUE", su.U);
										}
									}
									if (v.SU) {
										for (var j = 0; j < v.SU.length; j++) {
											var su = v.SU[j];
											if (su.U)
												s += lnk_div("SU", su.U);
										}
									}
									if (v.CU) {
										s += lnk_div("CU", v.CU);
									}
									s += "<br>";
								}
							} else {
								s += "JS is null<br>";
							}
							if (r.VAL) {
								s += "VAL size=" + r.VAL.length + "<br>";
								for (var i = 0; i < r.VAL.length; i++) {
									var v = r.VAL[i];
									var atmsu = v.SUS[0].U;
									var ca = atmsu.substring(atmsu
											.indexOf("&ca=") + 4, atmsu
											.indexOf("&",
													atmsu.indexOf("&ca=") + 4));
									var ie = atmsu.substring(atmsu
											.indexOf("&ie=") + 4, atmsu
											.indexOf("&",
													atmsu.indexOf("&ie=") + 4));
									var sdk = v.SDKID;
									s += "<div style='color:red'>ie="
											+ parseInt(ie) + " ca="
											+ parseInt(ca) + " at=" + v.AT
											+ " al=" + v.AL
											+ (sdk ? " SDK=" + sdk : "")
											+ "</div>";
								}
								for (var i = 0; i < r.VAL.length; i++) {
									var v = r.VAL[i];
									var rs = v.RS;
									var w = v.W;
									var h = v.H;
									var ext = get_extname(rs);
									if (ext) {
										if (({
											jpg : 1,
											png : 1,
											gif : 1
										})[ext]) {
											s += "<img src='"+rs+"'>";
										} else if (ext == "swf") {
											s += getFlashHtml(rs, "", w, h, "",
													"");
										}
										s += "<br>";
									}
									if (v.RS) {
										s += lnk_div("RS", v.RS);
									}
									if (v.SUS) {
										for (var j = 0; j < v.SUS.length; j++) {
											var su = v.SUS[j];
											if (su.U)
												s += lnk_div("SUS", su.U);
										}
									}
									if (v.SUE) {
										for (var j = 0; j < v.SUE.length; j++) {
											var su = v.SUE[j];
											if (su.U)
												s += lnk_div("SUE", su.U);
										}
									}
									if (v.SU) {
										for (var j = 0; j < v.SU.length; j++) {
											var su = v.SU[j];
											if (su.U)
												s += lnk_div("SU", su.U);
										}
									}
									if (v.CU) {
										s += lnk_div("CU", v.CU);
									}
									s += "<br>";
								}
							} else {
								s += "VAL is null<br>";
							}

							s += "<div style='color:green'>" + document.cookie
									+ "</div>";

							$("#output").append("<div>" + s + "</div>");
						}
						if (--count > 0)
							test_url(url, count);
					});
		}

		function get_extname(url) {
			if (!url)
				return "";
			if (url.indexOf("http://f.youku.com/player/getFlvPath/") == 0)
				return "flv";
			if (url.indexOf("#") > 0)
				url = url.substring(0, url.indexOf("#"));
			if (url.indexOf("?") > 0)
				url = url.substring(0, url.indexOf("?"));
			if (url.indexOf("http://"))
				url = url.substring(7, url.length);
			if (url.indexOf("/") > 0)
				url = url.substring(url.indexOf("/") + 1, url.length);
			if (url.lastIndexOf(".") > 0)
				return url.substring(url.lastIndexOf(".") + 1, url.length);
			return "";
		}

		function test_html(url) {
			var h = "<div style='width:800px;border-bottom:solid 1px gray;'>&nbsp;</div>";
			var pp = $("#p").val();
			if (!pp)
				return;
			pp = pp.split(",");
			for (var i = 0; i < pp.length; i++) {
				var old = document.getElementById("ab_" + pp[i]);
				if (old) {
					old.removeAttribute("id");
				}
				h += "<div id='ab_"+pp[i]+"' style='width:800px;'></div>";
			}
			$("#output").append(h);
			getScript(url);
		}

		function lnk_div(name, url) {
			var t = name;
			while (t.length < 3)
				t += " ";
			t += "= <input type=text style='border:solid 1px gray; width:800px' value='"+url + "'>"
					+ (name == "CU" ? " <a target=_blank href='"+url+"'>open</a>"
							: "")
					+ (isweb && name == "RS" && get_extname(url) == "flv" ? " <a href='javascript:void(0)' onclick='show_video(\""
							+ url + "\");return false;'>play</a>"
							: "") + "<br>";
			if (location.href.indexOf("http://") == 0
					&& url.indexOf(".atm.youku.com/") > 0 && name != "CU")
				$.get(url.substring(url.indexOf("/", 8), url.length));
			return t;
		}

		function base64enc(s) {
			var r = [], i = 0, j = 0, n = s.length, z = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
					.split("");
			;
			for (; i < n; i += 3) {
				var a = s.charCodeAt(i), b = i + 1 < n ? s.charCodeAt(i + 1)
						: 0, c = i + 2 < n ? s.charCodeAt(i + 2) : 0;
				r[j++] = z[a >> 2];
				r[j++] = z[((a & 3) << 4) | (b >> 4)];
				r[j++] = i + 1 < n ? z[((b & 15) << 2) | (c >> 6)] : "=";
				r[j++] = i + 2 < n ? z[c & 63] : "=";
			}
			return r.join("");
		}
		function base64dec(s) {
			var r = [], i, j, n = s.length, z = {}, w = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
					.split("");
			for (i = 0; i < 64; i++)
				z[w[i]] = i;
			for (i = 0, j = 0; i < n; i += 4) {
				r[j++] = String.fromCharCode(z[s.charAt(i)] << 2
						| ((z[s.charAt(i + 1)] >> 4) & 3));
				if (s.charAt(i + 2) != "=")
					r[j++] = String.fromCharCode((z[s.charAt(i + 1)] & 15) << 4
							| ((z[s.charAt(i + 2)] >> 2) & 15));
				if (s.charAt(i + 3) != "=")
					r[j++] = String.fromCharCode((z[s.charAt(i + 2)] & 3) << 6
							| (z[s.charAt(i + 3)] & 63));
			}
			return r.join("");
		}

		function setRT() {
			$("#rt").val(
					base64enc($("#rt_sel").val() + "|" + (new Date().getTime())
							+ "|X" + base64enc("" + $("#vid").val() * 4)));
		}

		var err_count = 0;
		function show_video(rs) {
			if (!isweb)
				return;
			$("#div_video").show();
			setTimeout(function() {
				try {
					console.log("rs=" + rs);
					$("#video1")[0].play_video(rs);
				} catch (e) {
					if (err_count++ < 10)
						show_video(rs);
					else
						err_count = 0;
				}
			}, 200);
		}
		function close_video() {
			$("#div_video").hide();
			$("#video1")[0].stop_video();
		}

		function play_video_onstop() {
			close_video();
		}

		//http://wiki.1verge.net/das:ad:apiargs

		var cols_index = {
			vf : 0,
			vb : 1,
			vo : 2,
			vp : 3,
			vc : 4,
			mf : 5,
			mo : 6,
			mb : 7,
			mp : 8,
			mc : 9,
			mi : 10,
			vhtml : 11,
			html : 12,
			feeds : 13
		};
		var cols = {
			site : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1],
			p : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 ],
			ps : [ 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0 ,1],
			pt : [ 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 ,0],
			vl : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 ,0],
			fu : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 ,0],
			ctu : [ 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 ,0],
			ct : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 ,1],
			cs : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 ,1],
			d : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 ,0],
			paid : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,0 ],
			s : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 ,1],
			sid : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 ,1],
			td : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 ,0],
			v : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 ,1],
			vip : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 ,1],
			wintype : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,1 ],
			atm : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 ,0],
			emb : [ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 ,0],
			k : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 ,0],
			partnerid : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			tpa : [ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,1 ],
			u : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1,1 ],
			tict : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0,1 ],
			ac : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			os : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			vs : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			prd : [ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,0],
			uk : [ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,1 ],
			bd : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			bt : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			aw : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			guid : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			ip : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			net : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			ouid : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			isp : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			mac : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			rst : [ 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0,1 ],
			dq : [ 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0,1 ],
			avs : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			pw : [ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,1 ],
			ph : [ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,1 ],
			px : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,1 ],
			ev : [ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ],
			rt : [ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0],
			adext : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1],
			union : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,0 ],
			noqt : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,0 ],
			pid : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			idfa : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0,1 ],
			callback : [ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,0 ],
			rt_sel : [ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ],
			vit : [ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0,0 ],
		    feeds_shua : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,1 ]
		
		};

		var pf = {
			ev : 1,
			td : 1,
			rt : 1,
			pw : -1,
			ph : -1,
			prd : -1,
			uk : -1,
			tict : -1,
			tpa : -1
		}

		var p_val = {
			vf : 1,
			vb : 2,
			vo : 3,
			vp : 4,
			vc : 5,
			vhtml : 863,
			mf : 7,
			mo : 8,
			mb : 9,
			mp : 10,
			mc : 11,
			mi : 12
		}

		/*

		 */
	</script>
	
    <script>
    function randomString(len) {
       len = len || 32;
       var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
       var maxPos = $chars.length;
       var pwd = '';
       for(i = 0; i<len;i++){
    	   pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
       }
       return pwd;   	
    }
    document.getElementById("sid").value = randomString(11);
    </script>
    
    <script>
	$().ready(function(e) {
		$("#timePicker_starttime").hunterTimePicker();
		$("#timePicker_endtime").hunterTimePicker();
	});
    </script>

</body>
</html>