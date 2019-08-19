package pl.flowable.example.rezerwacjawakacji.taskListener;

import lombok.extern.java.Log;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Service;

@Log
@Service
public class TLCompleteWeryfikacjaZamowienia implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        if (delegateTask.hasVariable("zatwierdzony")) {
            if (delegateTask.getVariable("zatwierdzony", Boolean.class)) {
                log.info("Pracownik zatwierdzil zamowienie");
            } else {
                log.info("Pracownik odrzucil zamowienie");
            }
        } else {
            throw new FlowableException("Brak zmiennej 'zatwierdzony'");
        }
    }
}
