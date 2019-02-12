Redis

**教学导航**

| **教学目标** |   |
|--------------|---|
| **教学方法** |   |

Redis简介
=========


redis面试题：https://www.cnblogs.com/jasontec/p/9699242.html
### 关于关系型数据库和nosql数据库

>   关系型数据库是基于关系表的数据库，最终会将数据持久化到磁盘上，而nosql数据
>   库是基于特殊的结构，并将数据存储到内存的数据库。从性能上而言，nosql数据库
>   要优于关系型数据库，从安全性上而言关系型数据库要优于nosql数据库，所以在实
>   际开发中一个项目中nosql和关系型数据库会一起使用，达到性能和安全性的双保证。

### 为什么要使用Redis

### redis在Linux上的安装

1.  安装redis编译的c环境，yum install gcc-c++

2.  将redis-2.6.16.tar.gz上传到Linux系统中

3.  解压到/usr/local下 tar -xvf redis-2.6.16.tar.gz -C /usr/local

4.  进入redis-2.6.16目录 使用make命令编译redis

5.  在redis-2.6.16目录中 使用make PREFIX=/usr/local/redis install命令安装
    redis到/usr/local/redis中

6.  拷贝redis-2.6.16中的redis.conf到安装目录redis中

7.  启动redis 在bin下执行命令redis-server redis.conf

8.  如需远程连接redis，需配置redis端口6379在linux防火墙中开发

>   /sbin/iptables -I INPUT -p tcp --dport 6379 -j ACCEPT

>   /etc/rc.d/init.d/iptables save

![](media/37168456521de2f12b6616af58929fc4.png)

启动后看到如上欢迎页面，但此窗口不能关闭，窗口关闭就认为redis也关闭了(类
似Tomcat通过bin下的startup.bat的方式)

解决方案：可以通过修改配置文件 配置redis后台启动，即服务器启动了但不会
穿件控制台窗口

将redis.conf文件中的daemonize从false修改成true表示后台启动

使用命令查看6379端口是否启动ps -ef \| grep redis

![](media/c7bdc26e311ca4aad1c8f0dbbde470cf.png)

使用java去操作Redis
===================

Redis的常用命令
===============

>   redis是一种高级的key-value的存储系统

>   其中的key是字符串类型，尽可能满足如下几点：

1.  key不要太长，最好不要操作1024个字节，这不仅会消耗内存还会降低查找 效率

2.  key不要太短，如果太短会降低key的可读性

3.  在项目中，key最好有一个统一的命名规范（根据企业的需求）

>   其中value 支持五种数据类型：

1.  字符串型 string

2.  字符串列表 lists

3.  字符串集合 sets

4.  有序字符串集合 sorted sets

5.  哈希类型 hashs

>   我们对Redis的学习，主要是对数据的存储，下面将来学习各种Redis的数据类型的
>   存储操作：

### 存储字符串string

>   字符串类型是Redis中最为基础的数据存储类型，它在Redis中是二进制安全的，这
>   便意味着该类型可以接受任何格式的数据，如JPEG图像数据或Json对象描述信息等。
>   在Redis中字符串类型的Value最多可以容纳的数据长度是512M

![](media/d719e7ea50fbb0ddd14a95366cb28382.png)

1.  **set key value**：设定key持有指定的字符串value，如果该key存在则进行覆盖
    操作。总是返回”OK”

2.  **get key**：获取key的value。如果与该key关联的value不是String类型，redis
    将返回错误信息，因为get命令只能用于获取String value；如果该key不存在，返
    回null。

![](media/122f9d8b0eb285eb9b9adcce1830fb55.png)

1.  **getset key value**：先获取该key的值，然后在设置该key的值。

![](media/f235bea179383cbf7acba3331c2539bc.png)

>   4）**incr key**：将指定的key的value原子性的递增1.如果该key不存在，其初始值
>   为0，在incr之后其值为1。如果value的值不能转成整型，如hello，该操作将执
>   行失败并返回相应的错误信息。

>   5）**decr key**：将指定的key的value原子性的递减1.如果该key不存在，其初始值
>   为0，在incr之后其值为-1。如果value的值不能转成整型，如hello，该操作将执
>   行失败并返回相应的错误信息。

![](media/550c428204f4d04aa54544d301edf00d.png)

>   6）**incrby key increment**：将指定的key的value原子性增加increment，如果该
>   key不存在，器初始值为0，在incrby之后，该值为increment。如果该值不能转成
>   整型，如hello则失败并返回错误信息

>   7）**decrby key decrement**：将指定的key的value原子性减少decrement，如果
>   该key不存在，器初始值为0，在decrby之后，该值为decrement。如果该值不能
>   转成整型，如hello则失败并返回错误信息

![](media/09a5661b72a8d30fe1aaa56947a0ba24.png)

![](media/ad6001d7f725828dd13223f512d98ea4.png)

>   8）**append key value**：如果该key存在，则在原有的value后追加该值；如果该
>   key 不存在，则重新创建一个key/value

### 存储lists类型

>   在Redis中，List类型是按照插入顺序排序的字符串链表。和数据结构中的普通链表
>   一样，我们可以在其头部(left)和尾部(right)添加新的元素。在插入时，如果该键并不
>   存在，Redis将为该键创建一个新的链表。与此相反，如果链表中所有的元素均被移
>   除，那么该键也将会被从数据库中删除。List中可以包含的最大元素数量是
>   4294967295。

从元素插入和删除的效率视角来看，如果我们是在链表的两头插入或删除元素，这将
会是非常高效的操作，即使链表中已经存储了百万条记录，该操作也可以在常量时间
内完成。然而需要说明的是，如果元素插入或删除操作是作用于链表中间，那将会是
非常低效的。相信对于有良好数据结构基础的开发者而言，这一点并不难理解。

![](media/a95668510b8f0b7d098dc493b9a06fd0.png)

1.  **lpush key value1 value2...**：在指定的key所关联的list的头部插入所有的
    values，如果该key不存在，该命令在插入的之前创建一个与该key关联的空链
    表，之后再向该链表的头部插入数据。插入成功，返回元素的个数。

2.  **rpush key value1、value2…**：在该list的尾部添加元素

3.  **lrange key start end**：获取链表中从start到end的元素的值，start、end可
    为负数，若为-1则表示链表尾部的元素，-2则表示倒数第二个，依次类推…

![](media/c817bb72ebb9a912fc98728fd2555703.png)

1.  **lpushx key value**：仅当参数中指定的key存在时（如果与key管理的list中没
    有值时，则该key是不存在的）在指定的key所关联的list的头部插入value。

>   5）**rpushx key value**：在该list的尾部添加元素

![](media/f4168cd95ab247bffb96c7f4e53ca49c.png)

>   6）**lpop key**：返回并弹出指定的key关联的链表中的第一个元素，即头部元素。

>   7）**rpop key**：从尾部弹出元素。

![](media/55bf55e5817df95473e372562a0c6f6d.png)

![](media/8ed2b9e5d38588b65001722cba9e596f.png)

>   8）**rpoplpush resource destination**：将链表中的尾部元素弹出并添加到头部

>   9）**llen key**：返回指定的key关联的链表中的元素的数量。

![](media/d828c877fc1d70d29c2e2874af7d3fb7.png)

>   10）**lset key index
>   value**：设置链表中的index的脚标的元素值，0代表链表的头元
>   素，-1代表链表的尾元素。

![](media/e12c33b42ab106d631e248ee90c0bb05.png)

>   11）**lrem key count
>   value**：删除count个值为value的元素，如果count大于0，从头向尾遍历并删除count个值为value的元素，如果count小于0，则从尾向头遍历并删除。如果count等于0，则删除链表中所有等于value的元素。

![](media/3bdb15c54c9a766fb7a9607efea446b3.png)

>   12）**linsert key before\|after pivot
>   value**：在pivot元素前或者后插入value这个 元素。

![](media/d3fbb6c9ed79291ca94214f2a67d00ff.png)

### 存储sets类型

>   在Redis中，我们可以将Set类型看作为没有排序的字符集合，和List类型一样，我
>   们也可以在该类型的数据值上执行添加、删除或判断某一元素是否存在等操作。需要
>   说明的是，这些操作的时间是常量时间。Set可包含的最大元素数是4294967295。

>   和List类型不同的是，Set集合中不允许出现重复的元素。和List类型相比，Set类
>   型在功能上还存在着一个非常重要的特性，即在服务器端完成多个Sets之间的聚合计
>   算操作，如unions、intersections和differences。由于这些操作均在服务端完成，
>   因此效率极高，而且也节省了大量的网络IO开销

![](media/a95668510b8f0b7d098dc493b9a06fd0.png)

>   1）sadd key value1、value2…：向set中添加数据，如果该key的值已有则不会
>   重复添加

>   2）smembers key：获取set中所有的成员

>   3）scard key：获取set中成员的数量

![](media/a41c3bb595584719ad1f9a1f02ff08cd.png)

>   4）sismember key member：判断参数中指定的成员是否在该set中，1表示存
>   在，0表示不存在或者该key本身就不存在

>   5）srem key member1、member2…：删除set中指定的成员

![](media/1701297c2cd81dc7d0bda3721f10a301.png)

6）srandmember key：随机返回set中的一个成员

![](media/0b16524ef5e1db1fa4dba8226512454b.png)

>   7）sdiff sdiff key1 key2：返回key1与key2中相差的成员，而且与key的顺序有
>   关。即返回差集。

![](media/ffa48e0a498de079ab56848dda375900.png)

>   8）sdiffstore destination key1 key2：将key1、key2相差的成员存储在
>   destination上

![](media/b600dad7d4568d70d774422aef6d32d1.png)

>   9）sinter key[key1,key2…]：返回交集。

>   10）sinterstore destination key1 key2：将返回的交集存储在destination上

![](media/9a48658e5c6f7fe08177669386a8e7f1.png)

>   11）sunion key1、key2：返回并集。

![](media/8847e09f463cee91443b06034ad63748.png)

>   12）sunionstore destination key1 key2：将返回的并集存储在destination上

![](media/994d5312aeb7e2fab285748c1ed4dab6.png)

### 存储sortedset

>   Sorted-Sets和Sets类型极为相似，它们都是字符串的集合，都不允许重复的成员出
>   现在一个Set中。它们之间的主要差别是Sorted-Sets中的每一个成员都会有一个分
>   数(score)与之关联，Redis正是通过分数来为集合中的成员进行从小到大的排序。然
>   而需要额外指出的是，尽管Sorted-Sets中的成员必须是唯一的，但是分数(score)
>   却是可以重复的。

>   在Sorted-Set中添加、删除或更新一个成员都是非常快速的操作，其时间复杂度为
>   集合中成员数量的对数。由于Sorted-Sets中的成员在集合中的位置是有序的，因此，
>   即便是访问位于集合中部的成员也仍然是非常高效的。事实上，Redis所具有的这一
>   特征在很多其它类型的数据库中是很难实现的，换句话说，在该点上要想达到和Redis
>   同样的高效，在其它数据库中进行建模是非常困难的。

>   例如：游戏排名、微博热点话题等使用场景。

![](media/a95668510b8f0b7d098dc493b9a06fd0.png)

>   1）**zadd key score member score2 member2 …** ：将所有成员以及该成员的
>   分数存放到sorted-set中

>   2）**zcard key**：获取集合中的成员数量

![](media/a9531d6a0b55abcb785b42e3e226a429.png)

>   3）**zcount key min max**：获取分数在[min,max]之间的成员

>   zincrby key increment member：设置指定成员的增加的分数。

>   zrange key start end
>   [withscores]：获取集合中脚标为start-end的成员，[withscores]参数表明返回的成员包含其分数。

>   zrangebyscore key min max [withscores] [limit offset
>   count]：返回分数在[min,max]的成员并按照分数从低到高排序。[withscores]：显示分数；[limit
>   offset count]：offset，表明从脚标为offset的元素开始并返回count个成员。

>   zrank key member：返回成员在集合中的位置。

>   zrem key member[member…]：移除集合中指定的成员，可以指定多个成员。

>   zscore key member：返回指定成员的分数

### 存储hash

>   Redis中的Hashes类型可以看成具有String Key和String Value的map容器。所
>   以该类型非常适合于存储值对象的信息。如Username、Password和Age等。如果
>   Hash中包含很少的字段，那么该类型的数据也将仅占用很少的磁盘空间。每一个Hash
>   可以存储4294967295个键值对。

![](media/e8320268e156af3a42887d284af00fb1.png)



1）**hset key field value**：为指定的key设定field/value对（键值对）。

2）**hgetall key：**获取key中的所有filed-vaule

![](media/be52e27b0b7cb4e15cf9e125a268316f.png)

3）**hget key field**：返回指定的key中的field的值

![](media/347c176b3e916155debc4cd8494d9e42.png)

4）**hmset key fields**：设置key中的多个filed/value

5）**hmget key fileds**：获取key中的多个filed的值

6）**hexists key field**：判断指定的key中的filed是否存在

7）**hlen key**：获取key所包含的field的数量

8）**hincrby key field increment**：设置key中filed的值增加increment，如：age
增加20



Redis的通用操作(见pdf文档)
==========================

Redis的特性(见pdf文档)
======================

Redis的事务(见pdf文档)
======================

Redis的持久化(见pdf文档)
========================

总结：

1.  nosql

2.  redis安装----linux（重点）

3.  jedis（重点）

4.  redis的数据操作类型 5中 (了解) --- string和hash

5.  redis的其他
