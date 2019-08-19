package pl.flowable.example.rezerwacjawakacji.configuration;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationProcess {
    private static final String BPMN_FILE = "processes/RezerwacjaWakacjiPrezentacja.bpmn20.xml";

    @Autowired
    ProcessEngine processEngine;

    @Bean(name = "repositoryService")
    RepositoryService repositoryService() {
        RepositoryService repositoryService = processEngine.getRepositoryService();

        repositoryService.createDeployment()
                .addClasspathResource(BPMN_FILE)
                .deploy()
                .getId();

        return repositoryService;
    }
}
