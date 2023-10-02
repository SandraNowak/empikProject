package com.empikproject.domain.service;

import com.empikproject.domain.interfaces.GithubClient;
import com.empikproject.domain.mapper.UserMapper;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserServiceImpl}.
 */
public class UserServiceImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userServiceImpl'.
   */
  private static BeanInstanceSupplier<UserServiceImpl> getUserServiceImplInstanceSupplier() {
    return BeanInstanceSupplier.<UserServiceImpl>forConstructor(GithubClient.class, UserMapper.class, UserActivityService.class)
            .withGenerator((registeredBean, args) -> new UserServiceImpl(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'userServiceImpl'.
   */
  public static BeanDefinition getUserServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserServiceImpl.class);
    beanDefinition.setInstanceSupplier(getUserServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
