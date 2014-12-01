Transaction Management
======================

Declared a ‘TransactionInterceptor‘ bean, and a ‘HibernateTransactionManager‘ for the Hibernate transaction,
 and passing the necessary property.

<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
 
    <bean id="transactionInterceptor" 
       class="org.springframework.transaction.interceptor.TransactionInterceptor">
	<property name="transactionManager" ref="transactionManager" />
	<property name="transactionAttributes">
	   <props>
		<prop key="save">PROPAGATION_REQUIRED</prop>
	   </props>
	</property>
    </bean>
 
    <bean id="transactionManager" 
        class="org.springframework.orm.hibernate3.HibernateTransactionManager">
	  <property name="dataSource" ref="dataSource" />
	  <property name="sessionFactory" ref="sessionFactory" />
    </bean>
 
</beans>

Transaction Attributes
-----------------------

In transaction interceptor, you have to define which transaction’s attributes ‘propagation behavior‘ should 
be use. It means if a transactional ‘ProductBoImpl.save()‘ method is called another method ‘productQohBo.save()‘, 
how the transaction should be propagated? Should it continue to run within the existing transaction? or start
 a new transaction for its own.

There are 7 types of propagation supported by Spring :

    PROPAGATION_REQUIRED – Support a current transaction; create a new one if none exists.
    PROPAGATION_SUPPORTS – Support a current transaction; execute non-transactionally if none exists.
    PROPAGATION_MANDATORY – Support a current transaction; throw an exception if no current transaction exists.
    PROPAGATION_REQUIRES_NEW – Create a new transaction, suspending the current transaction if one exists.
    PROPAGATION_NOT_SUPPORTED – Do not support a current transaction; rather always execute non-transactionally.
    PROPAGATION_NEVER – Do not support a current transaction; throw an exception if a current transaction exists.
    PROPAGATION_NESTED – Execute within a nested transaction if a current transaction exists, behave like PROPAGATION_REQUIRED else.

********In most cases, you may just need to use the PROPAGATION_REQUIRED.

In addition, you have to define the method to support this transaction attributes as well. The method name is supported wild card format, a save* will match all method name start with save(…).
Transaction Manager

**********
In Hibernate transaction, you need to use HibernateTransactionManager. 
If you only deal with pure JDBC, use DataSourceTransactionManager; 
while JTA, use JtaTransactionManager.


4. Proxy Factory Bean

Create a new proxy factory bean for ProductBo, and set the ‘interceptorNames‘ property.

   <!-- Product business object -->
   <bean id="productBo" class="com.mkyong.product.bo.impl.ProductBoImpl" >
   	<property name="productDao" ref="productDao" />
   	<property name="productQohBo" ref="productQohBo" />
   </bean>
 
   <!-- Product Data Access Object -->
   <bean id="productDao" class="com.mkyong.product.dao.impl.ProductDaoImpl" >
   	<property name="sessionFactory" ref="sessionFactory"></property>
   </bean>
 
   <bean id="productBoProxy"
	class="org.springframework.aop.framework.ProxyFactoryBean">
	<property name="target" ref="productBo" />
	<property name="interceptorNames">
		<list>
			<value>transactionInterceptor</value>
		</list>
	</property>
  </bean>

Run it

    Product product = new Product();
    product.setProductCode("ABC");
    product.setProductDesc("This is product ABC");
 
    ProductBo productBo = (ProductBo)appContext.getBean("productBoProxy");
    productBo.save(product, 100);

Get your proxy bean ‘productBoProxy‘, and your save() method is support transactional now, 
any exceptions inside productBo.save() method will cause the whole transaction to rollback, 
no data will be insert into the database.