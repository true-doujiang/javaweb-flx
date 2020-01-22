			1、Servlet简介
Servlet是sun公司提供的一门用于开发动态web资源的技术。

Sun公司在其API中提供了一个servlet接口，
用户若想用发一个动态web资源(即开发一个Java程序向浏览器输出数据)，需要完成以下2个步骤：
1、编写一个Java类，实现servlet接口。
2、把开发好的Java类部署到web服务器中。

提示：按照一种约定俗成的称呼习惯，通常我们也把实现了servlet接口的java程序，称之为Servlet。

			2、Servlet接口实现类

Servlet接口SUN公司定义了两个默认实现类，分别为：GenericServlet、HttpServlet。

HttpServlet指能够处理HTTP请求的servlet，它在原有Servlet接口上添加了一些与HTTP协议处理方法，
它比Servlet接口的功能更为强大。因此开发人员在编写Servlet时，通常应继承这个类，而避免直接去实现Servlet接口。

HttpServlet在实现Servlet接口时，覆写了service方法，该方法体内的代码会自动判断用户的请求方式，
如为GET请求，则调用HttpServlet的doGet方法，
如为Post请求，则调用doPost方法。
因此，开发人员在编写Servlet时，通常只需要覆写doGet或doPost方法，而不要去覆写service方法。

阅读HttpServlet API文档


			3、Servlet的一些细节(1).....(7)
具体看PPT

(4)Servlet是一个供其他Java程序（Servlet引擎）调用的Java类，它不能独立运行，
它的运行完全由Servlet引擎来控制和调度。
PS: Servlet引擎就是调用Servlet的程序，可以理解为服务器。

(6)
如果某个Servlet的映射路径仅仅为一个正斜杠（/），那么这个Servlet就成为当前Web应用程序的缺省Servlet。
凡是在web.xml文件中找不到匹配的<servlet-mapping>元素的URL，它们的访问请求都将交给缺省Servlet处理，也就是说，缺省Servlet用于处理所有其他Servlet都不处理的访问请求。
在<tomcat的安装目录>\conf\web.xml文件中，注册了一个名称为org.apache.catalina.servlets.DefaultServlet的Servlet，并将这个Servlet设置为了缺省Servlet。
当访问Tomcat服务器中的某个静态HTML文件和图片时，实际上是在访问这个缺省Servlet。
PS: 自己最好不好配缺省的，因为会覆盖tomcat的


			4、ServletConfig对象
在Servlet的配置文件中，可以使用一个或多个<init-param>标签为servlet配置一些初始化参数。

当Servlet配置了初始化参数后，web容器在创建servlet实例对象时，会自动将这些初始化参数封装到ServletConfig对象中，
并在调用Servlet的init方法时，将ServletConfig对象传递给Servlet。
进而，程序员通过ServletConfig对象就可以得到当前servlet的初始化参数信息。

思考: 阅读ServletConfig API，并举例说明该对象的作用：
			获得字符集编码
			获得数据库连接信息
			获得配置文件，查看struts案例的web.xml文件


			5、ServletContext对象(接口)

WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用。
（生命周期：启动服务器就创建该对象,关闭服务器时销毁）

ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
可以通过ServletConfig.getServletContext方法获得ServletContext对象。

由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯。
ServletContext对象通常也被称之为context域对象。

