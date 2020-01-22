本工程讲解顺序:
1、讲解cookie    cn.itcast.cookie
2、讲解session   cn.itcast.session
3、讲解购物案例        cn.itcast.shopping
4、讲解登录	   cn.itcast.login
5、讲解Token     cn.itcast.form
6、讲解验证码         cn.itcast.login2


1、服务器是如何做到一个session为一个浏览器的多次请求而服务
	1.1  服务器创建session出来后，会把 session的id号，以cookie的形式回写给客户机，这样，只要客户机的浏览器不关，再
		去访问服务器时，都会带着session 的id号去，服务器发现客户机带session id过来了，就会使用内存中与之对应的
		session为之服务

2、如何做到一个关闭浏览器后session还可以为再打开的浏览器服务
	2.1  服务器第一次创建session，程序员把session id号，手工以cookie的形式回送给浏览器，并设置cookie的有效期
		这样，即使用户的浏览器关了，再开新浏览器时，还会带着session id找服务器，服务器从而就可以用内存中与之对应的
		session为第二个浏览器窗口服务


3、如何做用户禁用cookie后，session还能为多次请求而服务
	3.1  把用户可能点的每一个超链接后面，都跟上用户的session id号


4、session对象的创建和销毁时机
	4.1 用户第一次request.getSession时
	4.2 session对象默认30分钟没有使用，则服务器会自动销毁session,
		4.2.1  用户在web.xml文件中手工配置session的失效时间
		4.2.2  用户可以手工调用session.invalidate方法，摧毁session


