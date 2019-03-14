package wx.procedure.permission.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author harry
 */
@Configuration
public class TransactionConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean("transactionManager")
    public DataSourceTransactionManager configTransaction(){
        DataSourceTransactionManager transactionManager =
                new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
