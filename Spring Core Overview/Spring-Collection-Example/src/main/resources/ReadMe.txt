Spring examples to show you how to inject values into collections type (List, Set, Map, and Properties). 4 major collection types are supported :

    List – <list/>
    Set – <set/>
    Map – <map/>
    Properties – <props/>
    
    
    
    
    public class Customer 
{
	private List<Object> lists;
	private Set<Object> sets;
	private Map<Object, Object> maps;
	private Properties pros;
 
	//...
}
    
    
    <beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
 
	<bean id="CustomerBean" class="com.mkyong.common.Customer">
 
		<!-- java.util.List -->
		<property name="lists">
			<list>
				<value>1</value>
				<ref bean="PersonBean" />
				<bean class="com.mkyong.common.Person">
					<property name="name" value="mkyongList" />
					<property name="address" value="address" />
					<property name="age" value="28" />
				</bean>
			</list>
		</property>
 
		<!-- java.util.Set -->
		<property name="sets">
			<set>
				<value>1</value>
				<ref bean="PersonBean" />
				<bean class="com.mkyong.common.Person">
					<property name="name" value="mkyongSet" />
					<property name="address" value="address" />
					<property name="age" value="28" />
				</bean>
			</set>
		</property>
 
		<!-- java.util.Map -->
		<property name="maps">
			<map>
				<entry key="Key 1" value="1" />
				<entry key="Key 2" value-ref="PersonBean" />
				<entry key="Key 3">
					<bean class="com.mkyong.common.Person">
						<property name="name" value="mkyongMap" />
						<property name="address" value="address" />
						<property name="age" value="28" />
					</bean>
				</entry>
			</map>
		</property>
 
		<!-- java.util.Properties -->
		<property name="pros">
			<props>
				<prop key="admin">admin@nospam.com</prop>
				<prop key="support">support@nospam.com</prop>
			</props>
		</property>
 
	</bean>
 
	<bean id="PersonBean" class="com.mkyong.common.Person">
		<property name="name" value="mkyong1" />
		<property name="address" value="address 1" />
		<property name="age" value="28" />
	</bean>
 
</beans>