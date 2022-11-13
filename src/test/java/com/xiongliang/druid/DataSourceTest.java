package com.xiongliang.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Before;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author 六月
 * @Date 2022/11/13 18:25
 * @Version 1.0
 * druid 数据源初始化 流程测试
 */
public class DataSourceTest {

    private DruidDataSource dataSource;

    @Before
    public void initDruidDataSource() {
        this.dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("xiongliang");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Shanghai");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    @Test
    public void getDataSourceTest() {
        try (DruidPooledConnection connection = dataSource.getConnection()) {
            Connection con = connection.getConnection();
            CallableStatement callableStatement = con.prepareCall("select 1");
            long result = callableStatement.getLong(1);
            System.out.println(result);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getDataSource2Test() {
        DruidDataSource dataSource = new DruidDataSource();
    }

}
