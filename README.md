# spring+mybatis+pagehelper实现分页
## 1 数据库表创建及导入数据
**建表**

    drop table if exists Payment_Info;
    /*==============================================================*/
    /* Table: PaymentInfo                                           */
    /*==============================================================*/
    create table Payment_Info
    (
       Id                   int not null auto_increment,
       AcceptId             varchar(32) not null,
       TransNo              varchar(32) not null,
       Status               int not null,
       CreatTime            varchar(8) not null,
       Extend               varchar(32),
       primary key (Id)
    );

**插入数据**

    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000001", "T000001", 0, "20190323","72334");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000002", "T000002", 0, "20190323","723se34");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000003", "T000003", 0, "20190323","72fsds334");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000004", "T000004", 0, "20190323","72fff334");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000005", "T000005", 0, "20190324","72334err");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000006", "T000006", 0, "20190324","723eee34");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000007", "T000007", 0, "20190323","72334");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000008", "T000008", 0, "20190323","723se34");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000009", "T000009", 0, "20190323","72fsds334");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000010", "T000010", 1, "20190323","72fff334");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000011", "T000011", 1, "20190324","72334err");
    insert into Payment_Info (AcceptId,TransNo,Status,CreatTime,Extend) values ("A000012", "T000012", 1, "20190324","723eee34");
    commit;

## 2 idea创建maven+spring+mybatis项目
**运行环境jdk1.8，可见项目内容**
## 3 使用mybatis-generator生成实体类和Mapper映射文件以及接口
### 3.1 pom文件引入所需插件

	<!-- 与pluginManagement 同一级，否则在idea右侧Plugins无法显示 -->
	<plugins>
	    <plugin>
	        <groupId>org.mybatis.generator</groupId>
	        <artifactId>mybatis-generator-maven-plugin</artifactId>
	        <version>1.3.2</version>
	        <configuration>
	            <!--配置文件的位置-->
	            <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
	            <verbose>true</verbose>
	            <overwrite>true</overwrite>
	        </configuration>
	        <executions>
	            <execution>
	                <id>Generate MyBatis Artifacts</id>
	                <goals>
	                    <goal>generate</goal>
	                </goals>
	            </execution>
	        </executions>
	        <dependencies>
	            <dependency>
	                <groupId>org.mybatis.generator</groupId>
	                <artifactId>mybatis-generator-core</artifactId>
	                <version>1.3.2</version>
	            </dependency>
	        </dependencies>
	    </plugin>
	</plugins>

### 3.2 添加generatorConfig.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE generatorConfiguration
            PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
            "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd"> 
    <generatorConfiguration>
        <!--mysql 连接数据库jar 这里选择自己本地位置-->
        <classPathEntry location="D:\Repositories\Maven\mysql\mysql-connector-java\5.1.38\mysql-connector-java-5.1.38.jar" />
        <context id="testTables" targetRuntime="MyBatis3">
            <commentGenerator>
                <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
                <property name="suppressAllComments" value="true" />
            </commentGenerator>
            <!--数据库连接的信息：驱动类、连接地址、用户名、密码 -->
            <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                            connectionURL="jdbc:mysql://127.0.0.1/mjs" userId="root"
                            password="">
            </jdbcConnection>
            <!-- 默认false，把JDBC DECIMAL 和 NUMERIC 类型解析为 Integer，为 true时把JDBC DECIMAL 和
               NUMERIC 类型解析为java.math.BigDecimal -->
            <javaTypeResolver>
                <property name="forceBigDecimals" value="false" />
            </javaTypeResolver>
            <!-- targetProject:生成PO类的位置 -->
            <javaModelGenerator targetPackage="com.mjs.study.entity.pojo"
                                targetProject="src/main/java">
                <!-- enableSubPackages:是否让schema作为包的后缀 -->
                <property name="enableSubPackages" value="false" />
                <!-- 从数据库返回的值被清理前后的空格 -->
                <property name="trimStrings" value="true" />
            </javaModelGenerator>
            <!-- targetProject:mapper映射文件生成的位置
               如果maven工程只是单独的一个工程，targetProject="src/main/java"
               若果maven工程是分模块的工程，targetProject="所属模块的名称"，例如：
               targetProject="ecps-manager-mapper"，下同-->
            <sqlMapGenerator targetPackage="entity.xml"
                             targetProject="src/main/resources">
                <!-- enableSubPackages:是否让schema作为包的后缀 -->
                <property name="enableSubPackages" value="false" />
            </sqlMapGenerator>
            <!-- targetPackage：mapper接口生成的位置 -->
            <javaClientGenerator type="XMLMAPPER"
                                 targetPackage="com.mjs.study.entity.mapper"
                                 targetProject="src/main/java">
                <!-- enableSubPackages:是否让schema作为包的后缀 -->
                <property name="enableSubPackages" value="false" />
            </javaClientGenerator>
            <!-- 指定数据库表 -->
            <table schema="" tableName="Payment_Info">
                <!--<property name="useActualColumnNames" value="true" />-->
            </table>
        </context>
    </generatorConfiguration>
### 3.2 通过插件生成Mapper.java、Mapper.xml、POJO
**  通过idea右方的Maven Projects，选择项目对应的Plugins，右键执行mybatis-generator：generate即可，此处略**
## 4 实现分页
** pagehelper的实现方式，详细参考https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md。**

**项目使用第二种方式进行调用，具体代码如下所示：**
**Controller层**
    package com.mjs.study.action;
    
    import com.github.pagehelper.PageInfo;
    import com.mjs.study.service.IPaymentInfoService;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;
    
    /**
     * @Description 订单信息控制层
     * @ClassName PaymentInfoController
     * @Author Administrator
     * @Data 2019/9/18 2:44
     * @Version 1.0
     */
    @Controller
    @RequestMapping("/paymentInfo")
    public class PaymentInfoController {
        private static final Logger logger = LoggerFactory.getLogger(PaymentInfoController.class);
        @Autowired
        private IPaymentInfoService paymentInfoService;
        @RequestMapping(value = "/search", method = RequestMethod.GET)
        @ResponseBody
        public PageInfo getPaymentInfos(@RequestParam(required = false) String status,
                                                     @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                     @RequestParam(required = false, defaultValue = "5") Integer pageSize){
            logger.debug("订单信息控制层");
            return paymentInfoService.getPaymentInfos(status, pageNum, pageSize);
        }
    }
** service实现层(忽略接口层代码)**
    package com.mjs.study.service.impl;
    
    import com.github.pagehelper.PageHelper;
    import com.github.pagehelper.PageInfo;
    import com.mjs.study.entity.mapper.PaymentInfoMapper;
    import com.mjs.study.entity.pojo.PaymentInfo;
    import com.mjs.study.entity.pojo.PaymentInfoExample;
    import com.mjs.study.service.IPaymentInfoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    import java.util.List;
    
    /**
     * @Description 订单信息实现层
     * @ClassName PaymentInfoServiceImpl
     * @Author Administrator
     * @Data 2019/9/18 18:33
     * @Version 1.0
     */
    @Service
    public class PaymentInfoServiceImpl implements IPaymentInfoService{
        @Autowired
        private PaymentInfoMapper paymentInfoMapper;
        /**
         * 查询订单信息
         * @param status 订单状态
         * @param pageNum
         * @param pageSize
         * @return
         */
        @Override
        public PageInfo getPaymentInfos(String status, Integer pageNum, Integer pageSize) {
            pageNum = pageNum == null ? 1 : pageNum;
            pageSize = pageSize == null ? 10 : pageSize;
            PageHelper.startPage(pageNum, pageSize);
            PaymentInfoExample example = new PaymentInfoExample();
            example.createCriteria().andStatusEqualTo(Integer.valueOf(status));
            List<PaymentInfo> list = paymentInfoMapper.selectByExample(example);
            return new PageInfo(list);
        }
    }
### 4.1 postman返回结果
**访问http://localhost:8080/sty/paymentInfo/search.action?status=0&pageNum=2&pageSize=5.**
**返回数据,如下所示**

    {
        "total": 9,
        "list": [
            {
                "id": 6,
                "acceptid": "A000006",
                "transno": "T000006",
                "status": 0,
                "creattime": "20190324",
                "extend": "723eee34"
            },
            {
                "id": 7,
                "acceptid": "A000007",
                "transno": "T000007",
                "status": 0,
                "creattime": "20190323",
                "extend": "72334"
            },
            {
                "id": 8,
                "acceptid": "A000008",
                "transno": "T000008",
                "status": 0,
                "creattime": "20190323",
                "extend": "723se34"
            },
            {
                "id": 9,
                "acceptid": "A000009",
                "transno": "T000009",
                "status": 0,
                "creattime": "20190323",
                "extend": "72fsds334"
            }
        ],
        "pageNum": 2,
        "pageSize": 5,
        "size": 4,
        "startRow": 6,
        "endRow": 9,
        "pages": 2,
        "prePage": 1,
        "nextPage": 0,
        "isFirstPage": false,
        "isLastPage": true,
        "hasPreviousPage": true,
        "hasNextPage": false,
        "navigatePages": 8,
        "navigatepageNums": [
            1,
            2
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 2
    }
## 5 扩展（联表查询如何分页）
### 5.1 建表插入数据
**首先建立退款表，脚本如下所示：**

    drop table if exists Refund_Info;
    /*==============================================================*/
    /* Table: PaymentInfo                                           */
    /*==============================================================*/
    create table Refund_Info
    (
       Id                   int not null auto_increment,
       TransNo              varchar(32) not null,
       Amt                  decimal(10,2) not null,
       Status               int not null,
       CreatTime            varchar(8) not null,
       Extend               varchar(32),
       primary key (Id)
    ); 
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000001", 10.1, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000002", 10.1, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000003", 10.1, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.1, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.2, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.3, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.4, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.5, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.6, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.7, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.8, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.9, 1, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.8, 2, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.9, 3, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.8, 4, "20190324","723eee34");
    insert into Refund_Info (TransNo,Amt,Status,CreatTime,Extend) values ("T000012", 10.9, 5, "20190324","723eee34");
    commit;

** 需要实现以下功能**

    select distinct
            p.id as PId,
            p.AcceptId,
            p.TransNo,
            p.status AS PStatus,
            p.creatTime AS PCreatTime,
            p.extend AS PExtend,
            r.id AS RID,
            r.Amt,
            r.status AS RStatus,
            r.creatTime AS RCreatTime,
            r.extend AS RExtend
            from
            Payment_Info p, Refund_Info r
            where p.TransNo=r.TransNo

### 5.2 定义实体类、Mapper文件及Mapper接口
**RefundInfo使用mybatis generator生成器生成。**
**关联表实体类：**
    package com.mjs.study.entity.pojo;
    
    import java.util.List;
    
    /**
     * @Description 订单对应的退款记录
     * @ClassName PaymentRefundInfo
     * @Author Administrator
     * @Data 2019/9/19 8:59
     * @Version 1.0
     */
    public class PaymentRefundInfo extends PaymentInfo{
        private List<RefundInfo> lists;
    
        public List<RefundInfo> getLists() {
            return lists;
        }
    
        public void setLists(List<RefundInfo> lists) {
            this.lists = lists;
        }
    }

**mapper xml文件**

    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
    <mapper namespace="com.mjs.study.entity.mapper.PaymentRefundInfoMapper" >
        <resultMap id="paymentRefundMap" type="com.mjs.study.entity.pojo.PaymentRefundInfo">
            <id column="PId" property="id" jdbcType="INTEGER" />
            <result column="AcceptId" property="acceptid" jdbcType="VARCHAR" />
            <result column="TransNo" property="transno" jdbcType="VARCHAR" />
            <result column="PStatus" property="status" jdbcType="INTEGER" />
            <result column="PCreatTime" property="creattime" jdbcType="VARCHAR" />
            <result column="PExtend" property="extend" jdbcType="VARCHAR" />
            <collection property="lists" ofType="com.mjs.study.entity.pojo.RefundInfo">
                <id column="RID" property="id" jdbcType="INTEGER" />
                <result column="TransNo" property="transno" jdbcType="VARCHAR" />
                <result column="Amt" property="amt" jdbcType="DECIMAL" />
                <result column="RStatus" property="status" jdbcType="INTEGER" />
                <result column="RCreatTime" property="creattime" jdbcType="VARCHAR" />
                <result column="RExtend" property="extend" jdbcType="VARCHAR" />
            </collection>
        </resultMap>
        <select id="findPaymentRefundList" resultMap="paymentRefundMap">
            select distinct
            p.id as PId,
            p.AcceptId,
            p.TransNo,
            p.status AS PStatus,
            p.creatTime AS PCreatTime,
            p.extend AS PExtend,
            r.id AS RID,
            r.Amt,
            r.status AS RStatus,
            r.creatTime AS RCreatTime,
            r.extend AS RExtend
            from
            Payment_Info p, Refund_Info r
            where p.TransNo=r.TransNo
        </select>
    </mapper>

**关联表Mapper接口：**
    package com.mjs.study.entity.mapper;
    
    import com.mjs.study.entity.pojo.PaymentRefundInfo;
    
    import java.util.List;
    
    /**
     * @Description 订单退款信息关联查询
     * @ClassName PaymentRefundInfoMapper
     * @Author Administrator
     * @Data 2019/9/19 9:29
     * @Version 1.0
     */
    public interface PaymentRefundInfoMapper {
        List<PaymentRefundInfo> findPaymentRefundList();
    }
    
    
    service层代码：
    @Override
    public PageInfo findPaymentRefundList(String status, Integer pageNum, Integer pageSize){
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<PaymentRefundInfo> list = paymentRefundInfoMapper.findPaymentRefundList();
        return new PageInfo(list);
    }

### 5.3 查询结果
**此处分页存在问题，total总数是不对的，建议先查主表，再查关联表。主要是为了实现联表查询的功能**

    {
        "total": 16,
        "list": [
            {
                "id": 12,
                "acceptid": "A000012",
                "transno": "T000012",
                "status": 1,
                "creattime": "20190324",
                "extend": "723eee34",
                "lists": [
                    {
                        "id": 1,
                        "transno": "T000012",
                        "amt": 10.10,
                        "status": 1,
                        "creattime": "20190324",
                        "extend": "723eee34"
                    },
                    {
                        "id": 2,
                        "transno": "T000012",
                        "amt": 10.20,
                        "status": 1,
                        "creattime": "20190324",
                        "extend": "723eee34"
                    },
                    {
                        "id": 3,
                        "transno": "T000012",
                        "amt": 10.30,
                        "status": 1,
                        "creattime": "20190324",
                        "extend": "723eee34"
                    },
                    {
                        "id": 4,
                        "transno": "T000012",
                        "amt": 10.40,
                        "status": 1,
                        "creattime": "20190324",
                        "extend": "723eee34"
                    },
                    {
                        "id": 5,
                        "transno": "T000012",
                        "amt": 10.50,
                        "status": 1,
                        "creattime": "20190324",
                        "extend": "723eee34"
                    }
                ]
            }
        ],
        "pageNum": 1,
        "pageSize": 5,
        "size": 1,
        "startRow": 1,
        "endRow": 1,
        "pages": 4,
        "prePage": 0,
        "nextPage": 2,
        "isFirstPage": true,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "navigatePages": 8,
        "navigatepageNums": [
            1,
            2,
            3,
            4
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 4
    }
	
	