package com.empikproject;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link EmpikProjectApplication}.
 */
public class EmpikProjectApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'empikProjectApplication'.
   */
  public static BeanDefinition getEmpikProjectApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmpikProjectApplication.class);
    beanDefinition.setTargetType(EmpikProjectApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(EmpikProjectApplication.class);
    beanDefinition.setInstanceSupplier(EmpikProjectApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'commandLineRunner'.
   */
  private static BeanInstanceSupplier<CommandLineRunner> getCommandLineRunnerInstanceSupplier() {
    return BeanInstanceSupplier.<CommandLineRunner>forFactoryMethod(EmpikProjectApplication.class, "commandLineRunner", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EmpikProjectApplication.class).commandLineRunner(args.get(0)));
  }

  /**
   * Get the bean definition for 'commandLineRunner'.
   */
  public static BeanDefinition getCommandLineRunnerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(CommandLineRunner.class);
    beanDefinition.setInstanceSupplier(getCommandLineRunnerInstanceSupplier());
    return beanDefinition;
  }
}
