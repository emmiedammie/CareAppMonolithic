package com.auth0.careappmonolithic;

import com.auth0.careappmonolithic.CareAppMonoApp;
import com.auth0.careappmonolithic.config.AsyncSyncConfiguration;
import com.auth0.careappmonolithic.config.EmbeddedKafka;
import com.auth0.careappmonolithic.config.EmbeddedSQL;
import com.auth0.careappmonolithic.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { CareAppMonoApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedKafka
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
