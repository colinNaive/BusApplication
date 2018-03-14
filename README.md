公司级的app肯定包含多个业务，比如淘宝的“天猫超市”、“聚划算‘、”天猫精选“、”天猫直播“、”品牌汇“，这些背后都是一个业务链，也都肯定是不同的业务部门负责的。

一般情况下，不同业务部门的代码肯定在不同的module下，那么不同module下的页面如果需要通信该怎么实现？难道要在module之间相互依赖？为了解耦各个module，业务间通信常常需要bus。为什么要解耦？

（1）试想，如果仅仅因为module间通信需要，就把一个module依赖另外一个module，那么岂不是编译自己module时，也需要把依赖的module也编译一遍？对于Android工程，多编译一个module要多花多少时间呀！！

（2）而且，如果依赖另外一个module，那这个module的开发人员如果把bug提交到了库中，我们这个module也就无法编译了。



为了说明Bus通信原理，我写了一个demo来辅助讲解。

【一】先看下工程结构：



该工程包含4个module：

【1】app module为一个空module，是整个工程的主module，其他module都是它的作为library。从可扩展性和代码健壮性考虑，这个module一般不写任何逻辑，不过需要注意的是，其manifest文件里要声明所有工程中的Activity。

【2】business module是一个公共module，所有的业务module都需要依赖这个module。这个module下一般存放一些工具类或封装好的一些组件，是整个工程的核心module。如果没有这个module，那每个module需要的工具类或者组件，都需要写一遍，不利于项目后续的扩展性。

【3】module1，module2，module3.......这些module就是业务module了，比如淘宝的“天猫超市”，“聚划算”，“品牌汇”等肯定就是一个一个的业务的module。



【二】Bus通信原理

Bus通信原理总结来说，可以归纳为两个词：多态+反射。多态是指每个module都继承一个抽象类BusObject，在需要通信时一律调BusObject的抽闲方法，那么其实调用的是具体实现类的相应方法。反射是指在没有依赖其他module，但想调到其他module的时，可以通过反射拿到类的实例，然后调用相应的方法。

这个类是一个抽象类，每个BU的都需要有一个BusObject类的子类。



这个类是bus的管理类，实际操作类是 实现”BusOBjectProvider“接口的实现类。



接下来就是BusObjectProvider接口和其实现类





可以看到实际拿到各个BU的BusObject实例是通过反射来实现的。



附上demo(点击即可下载)，有任何问题都可以邮件联系我zhshan@ctrip.com

