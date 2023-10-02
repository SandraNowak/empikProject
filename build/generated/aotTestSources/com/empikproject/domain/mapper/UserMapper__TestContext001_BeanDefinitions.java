package com.empikproject.domain.mapper;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserMapper}.
 */
public class UserMapper__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'userMapper'.
   */
  public static BeanDefinition getUserMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserMapper.class);
    beanDefinition.setInstanceSupplier(UserMapper::new);
    return beanDefinition;
  }
}
