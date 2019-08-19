package pl.flowable.example.rezerwacjawakacji.controller;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.flowable.example.rezerwacjawakacji.model.RequestModel;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProcessControler {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/startProcess")
    String startProcess() {
        System.out.println("*****");
        final ProcessInstance processInstance = runtimeService.startProcessInstanceByMessage("startProcessName");
        System.out.println("*****");

        return processInstance.getId();
    }

    @PostMapping("/startProcessWithVariable")
    String startProcessWithVariable(@RequestBody RequestModel model) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("kierunekPodrozy", model.getKierunekPodrozy());
        variables.put("numerKonta", model.getNumerKonta());

        System.out.println("*****");
        final ProcessInstance processInstance = runtimeService.startProcessInstanceByMessage("startProcessName", variables);
        System.out.println("*****");

        return processInstance.getId();
    }
}
