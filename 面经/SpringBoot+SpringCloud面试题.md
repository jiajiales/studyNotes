
### SpringBoot

**1、什么是 Spring Boot？**   
Spring Boot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。
更多 Spring Boot 详细介绍请看这篇文章《什么是Spring Boot?》。
**2、为什么要用 Spring Boot？**   
Spring Boot 优点非常多，如：   
   
独立运行   
简化配置   
自动配置   
无代码生成和XML配置   
应用监控   
上手容易   
...

Spring Boot 集这么多优点于一身，还有理由不使用它呢？   
**3、Spring Boot 的核心配置文件有哪几个？它们的区别是什么？**   
Spring Boot 的核心配置文件是 application 和 bootstrap 配置文件。   
application 配置文件这个容易理解，主要用于 Spring Boot 项目的自动化配置。   
bootstrap 配置文件有以下几个应用场景。   
   
使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；
一些固定的不能被覆盖的属性；
一些加密/解密的场景；

具体请看这篇文章《Spring Boot 核心配置文件详解》。   
**4、Spring Boot 的配置文件有哪几种格式？它们有什么区别？**     
.properties 和 .yml，它们的区别主要是书写格式不同。 
```java
1).properties
app.user.name = javastack

2).yml
app:
  user:
    name: javastack
```
另外，.yml 格式不支持 @PropertySource 注解导入配置。   
**5、Spring Boot 的核心注解是哪个？它主要由哪几个注解组成的？**   
启动类上面的注解是@SpringBootApplication，它也是 Spring Boot 的核心注解，主要组合包含了以下 3 个注解：   
@SpringBootConfiguration：组合了 @Configuration 注解，实现配置文件的功能。   
@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })。   
@ComponentScan：Spring组件扫描。   
**6、开启 Spring Boot 特性有哪几种方式？**   
1）继承spring-boot-starter-parent项目    
2）导入spring-boot-dependencies项目依赖     
具体请参考这篇文章《Spring Boot开启的2种方式》。   
**7、Spring Boot 需要独立的容器运行吗？**    
可以不需要，内置了 Tomcat/ Jetty 等容器。   
**8、运行 Spring Boot 有哪几种方式？**   
1）打包用命令或者放到容器中运行   
2）用 Maven/ Gradle 插件运行   
3）直接执行 main 方法运行   
**9、Spring Boot 自动配置原理是什么？**   
注解 @EnableAutoConfiguration, @Configuration, @ConditionalOnClass 就是自动配置的核心，首先它得是一个配置文件，其次根据类路径下是否有这个类去自动配置。
具体看这篇文章《Spring Boot自动配置原理、实战》。   
**10、Spring Boot 的目录结构是怎样的？**
```java
cn
 +- javastack
     +- MyApplication.java
     |
     +- customer
     |   +- Customer.java
     |   +- CustomerController.java
     |   +- CustomerService.java
     |   +- CustomerRepository.java
     |
     +- order
         +- Order.java
         +- OrderController.java
         +- OrderService.java
         +- OrderRepository.java
```   
这个目录结构是主流及推荐的做法，而在主入口类上加上 @SpringBootApplication 注解来开启 Spring Boot 的各项能力，如自动配置、组件扫描等。具体看这篇文章《Spring Boot 主类及目录结构介绍》。   
**11、你如何理解 Spring Boot 中的 Starters？**   
Starters可以理解为启动器，它包含了一系列可以集成到应用里面的依赖包，你可以一站式集成 Spring 及其他技术，而不需要到处找示例代码和依赖包。如你想使用 Spring JPA 访问数据库，只要加入 spring-boot-starter-data-jpa 启动器依赖就能使用了。   
Starters包含了许多项目中需要用到的依赖，它们能快速持续的运行，都是一系列得到支持的管理传递性依赖。具体请看这篇文章《Spring Boot Starters启动器》。
   
**12、如何在 Spring Boot 启动的时候运行一些特定的代码？**   
可以实现接口 ApplicationRunner 或者 CommandLineRunner，这两个接口实现方式一样，它们都只提供了一个 run 方法，具体请看这篇文章《Spring Boot Runner启动器》。
**13、Spring Boot 有哪几种读取配置的方式？**   
Spring Boot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationProperties 来绑定变量，具体请看这篇文章《Spring Boot读取配置的几种方式》。
**14、Spring Boot 支持哪些日志框架？推荐和默认的日志框架是哪个？**   
Spring Boot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，Spring Boot 将使用 Logback 作为默认日志框架，具体请看这篇文章《Spring Boot日志集成》。   
**15、SpringBoot 实现热部署有哪几种方式？**   
主要有两种方式：   
   
Spring Loaded   
   
Spring-boot-devtools   
   
Spring-boot-devtools 使用方式可以参考这篇文章《Spring Boot实现热部署》。
**16、你如何理解 Spring Boot 配置加载顺序？**   
在 Spring Boot 里面，可以使用以下几种方式来加载配置。   
1）properties文件；
2）YAML文件；   
3）系统环境变量；   
4）命令行参数；   
等等……   
具体请看这篇文章《Spring Boot 配置加载顺序详解》。   
**17、Spring Boot 如何定义多套不同环境配置？**   
提供多套配置文件，如：
applcation.properties

application-dev.properties

application-test.properties

application-prod.properties

运行时指定具体的配置文件，具体请看这篇文章《Spring Boot Profile 不同环境配置》。   
**18、Spring Boot 可以兼容老 Spring 项目吗，如何做？**   
可以兼容，使用 @ImportResource 注解导入老 Spring 项目配置文件。   
**19、保护 Spring Boot 应用有哪些方法？**   

在生产中使用HTTPS   
使用Snyk检查你的依赖关系   
升级到最新版本   
启用CSRF保护   
使用内容安全策略防止XSS攻击   
...

更多请看这篇文章《10 种保护 Spring Boot 应用的绝佳方法》。   
**20、Spring Boot 2.X 有什么新特性？与 1.X 有什么区别？**

配置变更
JDK 版本升级
第三方类库升级
响应式 Spring 编程支持
HTTP/2 支持
配置属性绑定
更多改进与加强...

具体请看这篇文章《Spring Boot 2.x 新特性总结及迁移指南》。



### SpringCloud

#### 一.SpringCloud面试题口述    
**1.SpringCloud和Dubbo**   
SpringCloud和Dubbo都是现在主流的微服务架构    
SpringCloud是Apache旗下的Spring体系下的微服务解决方案    
Dubbo是阿里系的分布式服务治理框架    
从技术维度上,其实SpringCloud远远的超过Dubbo,Dubbo本身只是实现了服务治理,而SpringCloud现在以及有21个子项目以后还会更多    
所以其实很多人都会说Dubbo和SpringCloud是不公平的    
但是由于RPC以及注册中心元数据等原因,在技术选型的时候我们只能二者选其一,所以我们常常为用他俩来对比    
服务的调用方式Dubbo使用的是RPC远程调用,而SpringCloud使用的是 Rest API,其实更符合微服务官方的定义    
服务的注册中心来看,Dubbo使用了第三方的ZooKeeper作为其底层的注册中心,实现服务的注册和发现,SpringCloud使用Spring Cloud Netflix Eureka实现注册中心,当然SpringCloud也可以使用ZooKeeper实现,但一般我们不会这样做    
服务网关,Dubbo并没有本身的实现,只能通过其他第三方技术的整合,而SpringCloud有Zuul路由网关,作为路由服务器,进行消费者的请求分发,SpringCloud还支持断路器,与git完美集成分布式配置文件支持版本控制,事务总线实现配置文件的更新与服务自动装配等等一系列的微服务架构要素

**2.技术选型**     
目前国内的分布式系统选型主要还是Dubbo毕竟国产,而且国内工程师的技术熟练程度高,并且Dubbo在其他维度上的缺陷可以由其他第三方框架进行集成进行弥补    
而SpringCloud目前是国外比较流行,当然我觉得国内的市场也会慢慢的偏向SpringCloud,就连刘军作为Dubbo重启的负责人也发表过观点,Dubbo的发展方向是积极适应SpringCloud生态,并不是起冲突

**3.Rest和RPC对比**     
其实如果仔细阅读过微服务提出者马丁福勒的论文的话可以发现其定义的服务间通信机制就是Http Rest    
RPC最主要的缺陷就是服务提供方和调用方式之间依赖太强,我们需要为每一个微服务进行接口的定义,并通过持续继承发布,需要严格的版本控制才不会出现服务提供和调用之间因为版本不同而产生的冲突    
而REST是轻量级的接口,服务的提供和调用不存在代码之间的耦合,只是通过一个约定进行规范,但也有可能出现文档和接口不一致而导致的服务集成问题,但可以通过swagger工具整合,是代码和文档一体化解决,所以REST在分布式环境下比RPC更加灵活    
这也是为什么当当网的DubboX在对Dubbo的增强中增加了对REST的支持的原因

**4.文档质量和社区活跃度**     
SpringCloud社区活跃度远高于Dubbo,毕竟由于梁飞团队的原因导致Dubbo停止更新迭代五年,而中小型公司无法承担技术开发的成本导致Dubbo社区严重低落,而SpringCloud异军突起,迅速占领了微服务的市场,背靠Spring混的风生水起
Dubbo经过多年的积累文档相当成熟,对于微服务的架构体系各个公司也有稳定的现状

#### 二.SpringBoot和SpringCloud**      
SpringBoot是Spring推出用于解决传统框架配置文件冗余,装配组件繁杂的基于Maven的解决方案,旨在快速搭建单个微服务
而SpringCloud专注于解决各个微服务之间的协调与配置,服务之间的通信,熔断,负载均衡等
技术维度并相同,并且SpringCloud是依赖于SpringBoot的,而SpringBoot并不是依赖与SpringCloud,甚至还可以和Dubbo进行优秀的整合开发

总结:

SpringBoot专注于快速方便的开发单个个体的微服务    
SpringCloud是关注全局的微服务协调整理治理框架,整合并管理各个微服务,为各个微服务之间提供,配置管理,服务发现,断路器,路由,事件总线等集成服务    
SpringBoot不依赖于SpringCloud,SpringCloud依赖于SpringBoot,属于依赖关系    
SpringBoot专注于快速,方便的开发单个的微服务个体,SpringCloud关注全局的服务治理框架
#### 三.Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别      
1.ZooKeeper保证的是CP,Eureka保证的是AP    
ZooKeeper在选举期间注册服务瘫痪,虽然服务最终会恢复,但是选举期间不可用的    
Eureka各个节点是平等关系,只要有一台Eureka就可以保证服务可用,而查询到的数据并不是最新的    

自我保护机制会导致
    
Eureka不再从注册列表移除因长时间没收到心跳而应该过期的服务    
Eureka仍然能够接受新服务的注册和查询请求,但是不会被同步到其他节点(高可用)    
当网络稳定时,当前实例新的注册信息会被同步到其他节点中(最终一致性)    
Eureka可以很好的应对因网络故障导致部分节点失去联系的情况,而不会像ZooKeeper一样使得整个注册系统瘫痪    

2.ZooKeeper有Leader和Follower角色,Eureka各个节点平等    
3.ZooKeeper采用过半数存活原则,Eureka采用自我保护机制解决分区问题    
4.Eureka本质上是一个工程,而ZooKeeper只是一个进程    

#### 四.微服务之间是如何独立通讯的     
远程过程调用（Remote Procedure Invocation）    
也就是我们常说的服务的注册与发现    
直接通过远程过程调用来访问别的service。    
优点：    
简单，常见,因为没有中间件代理，系统更简单    
缺点：
只支持请求/响应的模式，不支持别的，比如通知、请求/异步响应、发布/订阅、发布/异步响应    
降低了可用性，因为客户端和服务端在请求过程中必须都是可用的    
二、消息
使用异步消息来做服务间通信。服务间通过消息管道来交换消息，从而通信。    
优点:    
把客户端和服务端解耦，更松耦合    
提高可用性，因为消息中间件缓存了消息，直到消费者可以消费    
支持很多通信机制比如通知、请求/异步响应、发布/订阅、发布/异步响应    
缺点:    
消息中间件有额外的复杂性       
**20.什么是服务熔断?什么是服务降级**      
在复杂的分布式系统中,微服务之间的相互调用,有可能出现各种各样的原因导致服务的阻塞,在高并发场景下,服务的阻塞意味着线程的阻塞,导致当前线程不可用,服务器的线程全部阻塞,导致服务器崩溃,由于服务之间的调用关系是同步的,会对整个微服务系统造成服务雪崩
    
为了解决某个微服务的调用响应时间过长或者不可用进而占用越来越多的系统资源引起雪崩效应就需要进行服务熔断和服务降级处理。    
    
所谓的服务熔断指的是某个服务故障或异常一起类似显示世界中的“保险丝"当某个异常条件被触发就直接熔断整个服务，而不是一直等到此服务超时。    
    
服务熔断就是相当于我们电闸的保险丝,一旦发生服务雪崩的,就会熔断整个服务,通过维护一个自己的线程池,当线程达到阈值的时候就启动服务降级,如果其他请求继续访问就直接返回fallback的默认值

**21.微服务的优缺点分别是什么?说下你在项目开发中碰到的坑**     
优点    
每一个服务足够内聚,代码容易理解    
开发效率提高,一个服务只做一件事    
微服务能够被小团队单独开发    
微服务是松耦合的,是有功能意义的服务    
可以用不同的语言开发,面向接口编程    
易于与第三方集成    
微服务只是业务逻辑的代码,不会和HTML,CSS或者其他界面组合    
开发中,两种开发模式    
前后端分离    
全栈工程师    
可以灵活搭配,连接公共库/连接独立库    
缺点    
分布式系统的负责性    
多服务运维难度,随着服务的增加,运维的压力也在增大
系统部署依赖    
服务间通信成本    
数据一致性    
系统集成测试    
性能监控    
**22.你所知道的微服务技术栈有哪些?请列举一二**     
多种技术的集合体    
我们在讨论一个分布式的微服务架构的话,需要哪些维度   

维度(SpringCloud)    
服务开发    
SpringBoot    
Spring    
SpringMVC    
服务配置与管理    
Netfilx公司的Archaiusm,阿里的Diamond    
服务注册与发现    
Eureka,ZooKeeper    
服务调用    
Rest,RPC,gRPC    
服务熔断器    
Hystrix    
服务负载均衡    
Ribbon,Nginx
服务接口调用    
Feign    
消息队列    
Kafka,RabbitMq,ActiveMq    
服务配置中心管理    
SpringCloudConfing    
服务路由(API网关)    
Zuul    
事件消息总线    
SpringCloud Bus

