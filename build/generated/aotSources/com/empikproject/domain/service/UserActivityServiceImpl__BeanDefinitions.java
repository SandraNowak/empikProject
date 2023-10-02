package com.empikproject.domain.service;

import com.empikproject.domain.interfaces.UserActivityRepository;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserActivityServiceImpl}.
 */
public class UserActivityServiceImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userActivityServiceImpl'.
   */
  private static BeanInstanceSupplier<UserActivityServiceImpl> getUserActivityServiceImplInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<UserActivityServiceImpl>forConstructor(UserActivityRepository.class)
            .withGenerator((registeredBean, args) -> new UserActivityServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'userActivityServiceImpl'.
   */
  public static BeanDefinition getUserActivityServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserActivityServiceImpl.class);
    beanDefinition.setInstanceSupplier(getUserActivityServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
