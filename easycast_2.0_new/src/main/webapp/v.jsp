<%@ page
	contentType="text/html;charset=gbk"
	import="java.util.*"
	import="java.awt.*"
	import="java.awt.image.*"
	import="javax.imageio.*"
	import="java.awt.RenderingHints.*"
	import="java.awt.geom.*"
%><%!
	static Random rand = new Random();
%><%
	response.setContentType("image/jpeg");
	response.addHeader("Pragma","no-cache");
	response.addHeader("Cache-Control","no-cache");

	String   az = "2345789ABCDEFGHJKLMNPQRSTUVWXYZacdefghijkmnpqrstuvwxyz";
	String[] fs = new String[]{
		"Arial","Batang","Georgia","Gulim","Gungsuh","Impact",
		"MingLiU","Sylfaen","Tahoma","Verdana","ËÎÌו","÷ÚÌו"
	};
	String vs = "";


	BufferedImage image = new BufferedImage(130,53,BufferedImage.TYPE_INT_RGB);
	Graphics2D g = (Graphics2D)image.getGraphics();
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

	g.setColor(new Color(0xF0F3F8)); 
	g.fillRect(0, 0, 130, 53); 

	int fi = rand.nextInt(fs.length);
	Font f = new Font(fs[fi],Font.PLAIN,32);

	g.setColor(new Color(rand.nextInt(150)+50,rand.nextInt(100)+50,rand.nextInt(150)+50));
	g.setFont(f);

	AffineTransform m = new AffineTransform();

	for(int i=0;i<4;i++)
	{
		m.setToIdentity();
		m.rotate((rand.nextInt(40)-20)*Math.PI/180,i*20+20,20+rand.nextInt(5));
		g.setTransform(m);
		char c = az.charAt(rand.nextInt(az.length()));
		vs += c;
		g.drawString(""+c,i*20+5,rand.nextInt(20)+20);
	}

	//g.setColor(new Color(rand.nextInt(100),rand.nextInt(100),rand.nextInt(100)));
	BasicStroke stroke = new BasicStroke(rand.nextInt(3)+2);
	g.setStroke(stroke);
	CubicCurve2D cc =
		new CubicCurve2D.Float(0,rand.nextInt(30)+15,40,rand.nextInt(50),80,rand.nextInt(30)+15,130,rand.nextInt(53));
	g.draw(cc);
	//g.setColor(new Color(rand.nextInt(100),rand.nextInt(100),rand.nextInt(100)));
	stroke = new BasicStroke(rand.nextInt(3)+2);
	g.setStroke(stroke);
	 cc =
		new CubicCurve2D.Float(0,rand.nextInt(30)+15,40,rand.nextInt(50),80,rand.nextInt(30)+15,130,rand.nextInt(53));
	g.draw(cc);

	//g.drawString(fs[fi],0,50);

	//session.setAttribute("validatenumber",vs);

	vs = vs.toLowerCase();

	long expire = System.currentTimeMillis() + 5*60*1000;

	String ip = com.youku.ad.mobile.caster.MCastUtils.getRemoteIp(request);

	String vck = expire + "_" + com.youku.ad.util.Util.md5(vs+"_"+ip+"_"+expire+"_"+com.youku.ad.castv2.virtualcity.VirtualCookie.virtualCitySecretKey);
	Cookie cookie=new Cookie("vsign", vck);
	cookie.setDomain(".atm.youku.com");
	cookie.setPath("/");
	cookie.setMaxAge(5 * 60);
	response.addCookie(cookie);		

	ImageIO.write(image, "png", response.getOutputStream()); 
%>