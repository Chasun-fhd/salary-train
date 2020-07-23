package designpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * creator: fenghaidong
 * createdAt: 2020/7/23
 * description:
 **/
public class JDBC {

    public static void main(String[] args) throws Exception {
        //加载数据库驱动类到jvm
        Class.forName("com.mysql.jdbc.Driver");
        //DriverManager类加载时，通过jdk的SPI机制，将jdb驱动包 META-INF/services下的实现类加载到jvm中，作为候选实现类
        /**
         * SPI 机制其实与策略模式类似，其实 Java 中使用的一种技术实现，全称是 Service Provider Interface，
         * 即服务提供接口，一般用在开源框架研发领域。从代码接入的级别来看，策略模式还是在原有项目中进行代码修改，
         * 只不过它不会修改原有类中的代码，而是新建了一个类。而 SPI 机制则是不会修改原有项目中的代码，其会新建一个项目，
         * 最终以 Jar 包引入的方式代码（如jdbc驱动)。
         * 区别
         * 从设计思想来看：策略模式和 SPI 机制其思想是类似的，都是通过一定的设计隔离变化的部分，从而让原有部分更加稳定。
         * 从隔离级别来看：策略模式的隔离是类级别的隔离，而 SPI 机制是项目级别的隔离。
         * 从应用领域来看：策略模式更多用在业务代码书写，SPI 机制更多用于框架的设计。
         *
         */
        Connection conn = DriverManager.getConnection("", "", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from information");
        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + "\t"
                            + rs.getString(2) + "\t"
                            + rs.getString(3) + "\t"
                            + rs.getInt(4) + "\t"
                            + rs.getString(5) + "\t");
        }
    }
}
