------------------	自定义标签入门          ------------------

1、编写一个实现tag接口的标签处理器类
2、在WEB-INF或WEB-INF下的子目录下新建tld文件，在tld文件中对标签处理器进行描述
	PS:tld文件的头可以到standard.jar的c.tld文件里去拷贝

3、在jsp页面中导入并使用自定义标签
<%@taglib uri="http://www.itcast.cn" prefix="itcast" %>

-------------------------------------------------------------------------
标签执行流程参考word里的执行流程图,也可以打开服务器查看使用这个标签翻译后的Servlet

Tag(接口)、Iterationtag(接口)、BodyTag(接口)==>TagSupport、BodyTagSupport(实现类)、查看PPT  关系一目了然


	自定义标签的扩展功能(重要)：
1、控制jsp页面某一部分内容是否执行。
2、控制整个jsp页面是否执行。
3、控制jsp页面内容重复执行。
4、修改jsp页面内容输出。


------------------	Tip： 简单标签   ------------------	strut框架的标签的用的就是上面的接口开发的，因为那个时候还没有jsp2.0
由于传统标签使用三个标签接口来完成不同的功能，显得过于繁琐，不利于标签技术的推广，
 SUN公司为降低标签技术的学习难度，在JSP 2.0中定义了一个更为简单、便于编写和调用的SimpleTag接口来实现标签的功能。
 实现SimpleTag接口的标签通常称为简单标签。简单标签共定义了5个方法：

 具体的看JSP的API
	setJspContext方法 	用于把JSP页面的pageContext对象传递给标签处理器对象
	setParent方法    		用于把父标签处理器对象传递给当前标签处理器对象
	getParent方法		用于获得当前标签的父标签处理器对象
	setJspBody方法		用于把代表标签体的JspFragment对象传递给标签处理器对象。

	doTag方法			用于完成所有的标签逻辑，包括输出、迭代、修改标签体内容等。
						在doTag方法中可以抛出javax.servlet.jsp.SkipPageException异常，
						用于通知WEB容器不再执行JSP页面中位于结束标记后面的内容，这等效于在传统标签的doEndTag方法中返回Tag.SKIP_PAGE常量的情况。



