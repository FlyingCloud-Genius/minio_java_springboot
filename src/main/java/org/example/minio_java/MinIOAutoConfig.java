package org.example.minio_java;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Filename: MinIOAutoConfig
 * @Auther: Cloud
 * @Create: 2020 - 08 - 20
 * @Description:
 **/

public class MinIOAutoConfig implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String type = context.getEnvironment().getProperty("jd.storagetype");
        return "minio".equals(type.toLowerCase());
    }
}
