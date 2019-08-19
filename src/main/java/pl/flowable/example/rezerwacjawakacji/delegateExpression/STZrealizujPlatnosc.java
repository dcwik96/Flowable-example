package pl.flowable.example.rezerwacjawakacji.delegateExpression;

import lombok.extern.java.Log;
import org.flowable.engine.delegate.BpmnError;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Log
@Service
public class STZrealizujPlatnosc implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        log.info("Service task: Zrealizuj Platnosc");
        if (execution.getVariable("numerKonta").equals("PoprawnyNumerKonta")) {
            System.out.println("-> Realizuje platnosc");
        } else {
            execution.setVariable("informacja", "Platnosc nie mogla zostac zrealizowana - zly numer konta");
            throw new BpmnError("BladKonta");
        }

    }
}
