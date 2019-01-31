### 1.讲下servlet的执行流程。

Servlet的执行流程也就是servlet的生命周期，当服务器启动的时候生命周期开始，然后通过init()《启动顺序根据web.xml里的startup-on-load来确定加载顺序》

方法初始化servlet，再根据不同请求调用doGet或doPost方法，最后再通过destroy()方法进行销毁。

### 2.Get和Post的区别

在页面提交数据时，get的数据大小有限制4k，post没有限制，get请求提交的数据会在地址栏显示，post不显示，所以post比get安全.

### 3.有三台服务器，如果在一台服务器上登陆了这个用户，其他两台就不能再登陆这个用户，使用session共享，你是怎么做的。

把所有的session的数据保存到Mysql服务器上，所有Web服务器都来这台Mysql服务器来获取Session数据。

### 4.写一个自定义标签要继承什么类

SimpleTagSupport，一般调用doTag方法

或者实现SimpleTag接口

### 5.Jsp如何处理json

在 jsp 中处理 JSON，通常需要配套使用 JQuery 控件，并且导入一些 Common jar
包。使用 JQuery 控件是因为它能有效的解析并且展示 JSON 数据，

导入Common 则是因为 Java 中的对象并不是纯粹的数据，需要通过这些 Jar
包的处理使之转化成真实数据。

### 6.如何处理Servlet的线程不安全问题

1.最简单的就是不使用字段变量,2.使用final修饰变量,3.线程安全就是多线程操作同一个对象不会有问题，线程同步一般来保护线程安全，

所以可以在Servlet的线程里面加上同步方法或同步块。（Synchronized）可以保证在同一时间只有一个线程访问，（使用同步块会导致性能变差，最好不去使用实例变量）

### 7.Jsp的重定向和转发的流程有什么区别

重定向是客户端行为，转发是服务器端行为

重定向时服务器产生两次请求，转发产生一次请求，重定向时可以转发到项目以外的任何网址，转发只能在当前项目里转发

重定向会导致request对象信息丢失。转发则不会

转发的url不会变,request.getRequestDispatch().forward()

重定向的url会改变,response.getRedirect().sendRedirect();

详细解释看[这里](http://192.168.6.208:8090/pages/viewpage.action?pageId=360938)

### 8.Jsp和Servlet的区别

Jsp的可读性强，容易看得懂，并且Jsp在最后会编译成Servlet

servlet容易调试,但是生成html页面工作量大

### 10.Jsp可以操作窗口吗？

Jsp不能够直接调用窗口，只能先生成打开窗口的js，再由js调用窗口

### 11.Session的主要几个方法的区别

Session不能通过new创建，需要通过调用getSession()或者getSession(true)方法创建，getSession()是自动创建session，

getSession(true)是强制创建session，setAttribute()方法可以用于传值，getAttribute()可以用于取值

（第一次创建session的时候，就是访问第一次一个jsp页面\<这个页面的page指令
没有设置session=false\>）

销毁session调用invalidate方法

通过setMaxInactiveInterval()可以设定session的生存时间(web.xml可以设置session的生存时间)

### 12.Jsp的九大内置对象，三大指令，七大动作的具体功能

#### JSP九大内置对象:

pageContext ：只对当前jsp页面有效，里面封装了基本的request和session的对象
Request ：对当前请求进行封装

Session ：浏览器会话对象，浏览器范围内有效Application
：应用程序对象，对整个web工程都有效

Out ：页面打印对象，在jsp页面打印字符串

Response ：返回服务器端信息给用户

Config ：单个servlet的配置对象，相当于servletConfig对象

Page ：当前页面对象，也就是this

Exception ：错误页面的exception对象，如果指定的是错误页面，这个就是异常对象

#### 三大指令：

Page ：指令是针对当前页面的指令

Include ：用于指定如何包含另一个页面

Taglib ：用于定义和指定自定义标签

#### 七大动作：

Forward执行页面跳转，将请求的处理转发到另一个页面

Param ：用于传递参数

Include ：用于动态引入一个jsp页面

Plugin ：用于下载javaBean或applet到客户端执行

useBean ：使用javaBean

setProperty ：修改javaBean实例的属性值

getProperty ：获取javaBean实例的属性值

### 13.获取页面的元素的值有几种方式，分别说一下

request.getParameter() 返回客户端的请求参数的值

request.getParameterNames() 返回所有可用属性名的枚举

request.getParameterValues() 返回包含参数的所有值的数组

### 14.Servlet和JavaScript的区别， 它们分别是什么作用

一个是服务端，一个是客户端

Servlet是独立于平台和协议的服务器端的Java应用程序，可以动态生成Web页面，并采用响应--请求的模式提供Web服务

JavaScript是一种解释性语言，用于向html页面提供交互行为，通常被直接嵌入在html页面中

Servlet是Java语言编写的web应用

Js是基于html上的一种解释语言

### 15.Jsp的执行原理

客户端发出请求(request)，Jsp引擎将jsp页面翻译成Servlet的java源文件，在Tomcat(Servlet容器)中将源文件编译成class文件，并加载到内存中执行，

把结果返回(response)给客户端。

### 16.HTML和Servlet的异同

不同： Html是静态，servlet是动态 html页面由服务器直接返回，
servlet是用来处理客户请求，并返回html页面
,Servlet需要服务器调用servlet方法生成动态html页面，且需要在web.xml中配置url路径

### 17.会话跟踪有哪些，他们的区别是什么

Cookie，session和application， Cookie是http对象，客户端与服务端都可以操纵

cookie是在客户端保持状态，session是在服务器端保持状态，由于cookie是保存在客户端本地的，所以数据很容易被窃取，当访问量很多时，

使用session则会降低服务器的性能，application的作用域是整个工程里只有一个，可以在不同浏览器之间共享数据，所有人都可以共享，

因此application也是不安全的,[Cookie和Session的区别](http://192.168.6.208:8090/pages/viewpage.action?pageId=360927)

### 18.说说Jsp的隐藏对象有哪些

Request,out,response , pageContext , session , application , config , page ,
exception，也即jsp的九大内置对象

### 19.request ，response，session 和 application是怎么用的

Request是客户端向服务端发送请求

Response是服务端对客户端请求做出响应

Session在servlet中不能直接使用，需要通过getSession()创建，如果没有设定它的生命周期，或者通过invildate()方法销毁，关闭浏览器session就会消失

Application不能直接创建，存在于服务器的内存中，由服务器创建和销毁

### 20.为什么在session少放对象

因为session底层是由cookie实现的，当客户端的cookie被禁用后，session也会失效，且应尽量少向session中保存信息，session的数据保存在服务器端，

当有大量session时，会降低服务器的性能

### 21.怎么判断浏览器是否支持Cookie

可以使用javaScript的方法navigator.cookieEnabled判断浏览器是否支持cookie

### 22.Request和Session的取值区别，以及出现乱码的解决方式（不能在java代码中设置）

Request可以通过getAttribute()方法直接取值，也可通过getParameter()取值

Session需要通过request.getSession().getAttribute()才能取值

Request是针对一次请求，Session是针对整个会话

在页面通过contentType，pageEncoding，content设置编码格式，必须要一致

### 24.Jsp页面跳转

Jsp页面跳转有两种方式，forward和redirect（转发和重定向）

### 25.说出Jsp内置对象以及方法.

##### Request：客户端发送请求

getParameter() 得到前台传入的参数值

setCharacterEncoding(String arg0)：设置编码格式

getCharacterEncoding()：获取编码格式

getRequestDispatcher(String path)：返回一个RequestDispatcher对象

##### Response：服务器端返回信息给用户

setAttribute("name",Object
obj)：设置名字为name的request参数的值，该值是由Object类型的obj指定

getAttribute("name")：返回name属性值

getAttributeNames()：返回所有可用属性名的枚举

setCharacterEncoding(String charset)：设置编码格式

getCharacterEncoding()：获取编码格式

sendRedirect(String location)：返回对包装的响应对象调用

##### pageContext：网页的属性是在这里管理的

setAttribute("name",Object
obj)：设置名字为name的request参数的值，该值是由Object类型的obj指定

getAttribute("name")：返回name属性值

getAttributeNames()：返回所有可用属性名的枚举

##### Session：与请求有关的会话期

setAttribute("name",Object
obj)：设置名字为name的request参数的值，该值是由Object类型的obj指定

getAttribute("name")：返回name属性值

getAttributeNames()：返回所有可用属性名的枚举

invalidate()：使当前会话失效

setMaxInactiveInterval()：指定在Servlet容器使此会话失效之前客户端请求之间的时间间隔，以秒为单位。负数时间指示会话永远不会超时

getMaxInactivelnterval()：返回servlet
容器在客户端访问之间将使此会话保持打开状态的最大时间间隔，以秒为单位。在此间隔之后，servlet
容器将使会话无效

##### Application：Servlet正在执行的内容

setAttribute("name",Object
obj)：设置名字为name的request参数的值，该值是由Object类型的obj指定

getAttribute("name")：返回name属性值

##### Out：用来传送回应的输出

print()：打印信息

println()：换行打印信息

##### Config：Servlet的构架部件

getInitParameter(String paramNarne)：从web.xml中获取指定名称的值
getInitParameterNames()：从web.xml中获取所有的名称

##### Page：JSP页面本身

Exception：针对错误网页，未捕捉的例外 getMessage()：返回异常的详细信息
getClass()：返回异常的名称

### 26.有几种方式将页面的值传到后台

可通过get或post将值传递到后台，也可通过Jsp里面的setAttribute()方法将值传递到后台

### 27.一个form表单的值如何获取

在Servlet中通过request.getParameter()方法可以获取表单的值或者是request.getParameterValuse();

### 29.Jsp中父页面中怎么拿到子页面的表单元素，不是拿值怎么拿

通过设置属性setAttribute()，通过getAttribute()拿值，getParameter()方法可以做到

### 31.404和500是什么意思

404 ：找不到url请求的路径，一般是工程名不对或者拼写错误

500 ：服务器内部错误，一般是服务器内部代码编写错误，也有可能是抛异常导致

### 32.写出5种JSTL常用标签

\<c:if\>，\<c:item\>，\<c:foreach\>，\<c:out\>，\<c:set\>

### 33.Jsp页面把一个元素隐藏的方法

通过使用属性hidden可以将元素隐藏

### 35.我们在web应用开发过程中经常遇到输出某种编码的字符，如ISO-8859-1，如何输出一个某种编码的字符串

如将ISO-8859-1输出为GBK格式的字符， 通过new String(byte[] bytes,String charset)
构造器设置编码构造一个新的String（new String("ISO-8859-1","GBK")）;

### 36.Jsp里有那些标签

jsp:include等

### 37.怎么判断用户请求时是第一次，如果客户端和服务端断开怎么连到上一次操作

通过session中的isNew()可以判断是否是新用户,可以用cookie来保存信息到客户端,可以连接到上一次操作

### 38.如果创建servlet实例不用构造方法，怎么创建一个servlet实例

Web容器会自动为servlet写一个无参的构造器，它使用class.forName("").newInstance()反射来创建servlet实例的

### 39.Servlet和过滤器的区别

##### Servlet：是用来处理客户端发送的请求，然后生成响应并将其传给server服务器，

最后服务器将响应返回给客户端

##### 过滤器：是用于 对servlet容器调用servlet的过程进行拦截

可以在servlet进行响应处理前后做一些特殊的处理,譬如权限,日志,编码等

### 40.说明一下jsp中\<jsp: include page..\>和\<%\@ include file%\>的区别

##### 动态导入

是行为元素、是在请求处理阶段引入的，引入执行页面或servlet所生成的应答文本

先编译，后包含,就是将每个jsp页面都单独转化成html页面，最后再将所有的html页面相加，如果有相同变量不会冲突

##### \<%\@ include file="" %\> 静态导入

是指令元素

是编译时包含，引入静态文本(html,jsp),在JSP页面被转化成servlet之前和它融和到一起。先包含，后编译

就是将多个jsp一起解析，最后再一起生成html页面，如果有相同变量会冲突

### 41. pageContext有什么作用

可以使用pageContext对象来设定属性，并指定属性的作用范围,提供了对JSP页面内所有的对象及名字空间的访问

### 42.Servlet是单例还是多例

是单例的，可以提高性能

### 43.拦截器(Filter)怎么执行的

首先初始化过滤器，然后服务器组织过滤器链，所有的请求都必须需要先通过过滤器链，

过滤器链是一个栈，遵循先进后出的原则
，所有的请求需要经过一个一个的过滤器，执行顺序要根据web.xml里配置的\<filter-mapping\>的位置前后执行，每个过滤器之间通过chain.doFilter连接，
最后抵达真正请求的资源，执行完后再从过滤器链退出
