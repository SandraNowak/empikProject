package com.empikproject.persistance;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserActivityRepositoryImpl}.
 */
public class UserActivityRepositoryImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'userActivityRepositoryImpl'.
   */
  public static BeanDefinition getUserActivityRepositoryImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserActivityRepositoryImpl.class);
    beanDefinition.setInstanceSupplier(UserActivityRepositoryImpl::new);
    return beanDefinition;
  }
}
