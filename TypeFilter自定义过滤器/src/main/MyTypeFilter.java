package main;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义扫描过滤规则
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * 以扫描类为例，返回true：Bean注册成功；false：Bean未注册。
     *
     * @param metadataReader        当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前正在扫描类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前正在扫描类的资源信息，如class路径等。
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("className: " + className);
        return className.contains("Service");
    }
    //测试打印结果：
    //className: main.Main
    //className: main.MyTypeFilter
    //className: main.entities.AccountInfo
    //className: main.repository.AccountInfoRepository
    //className: main.repository.impl.AccountInfoRepositoryImpl
    //className: main.service.AccountInfoService
    //className: main.service.impl.AccountInfoServiceImpl
}
