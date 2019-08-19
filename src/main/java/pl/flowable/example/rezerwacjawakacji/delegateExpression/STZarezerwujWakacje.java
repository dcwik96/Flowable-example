package pl.flowable.example.rezerwacjawakacji.delegateExpression;

import lombok.extern.java.Log;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Log
@Service
public class STZarezerwujWakacje implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        log.info("Service task: Zarezerwuj Wakacje");

        if (execution.hasVariable("kierunekPodrozy")) {
            execution.setVariable("rejestracjaPoprawna", true);

        } else {
            System.out.println("Rejestracja niepoprawna - brak kierunku podrozy");
            execution.setVariable("rejestracjaPoprawna", false);
            execution.setVariable("informacja", "Rejestracja niepoprawna - brak kierunku podrozy");
        }
    }
}
