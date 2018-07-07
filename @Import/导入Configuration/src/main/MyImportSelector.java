package main;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入选择器
 * 1.实现ImportSelector接口
 * 2.在@Import({Red.class, Blue.class, MyImportSelector.class})中声明
 *
 * 注意：
 * EnvironmentAware
 * BeanFactoryAware
 * BeanClassLoaderAware
 * ResourceLoaderAware
 * 可以通过实现以上四个接口得到Environment等四个对象。
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"main.entities.Green", "main.entities.Black"};
    }
}
