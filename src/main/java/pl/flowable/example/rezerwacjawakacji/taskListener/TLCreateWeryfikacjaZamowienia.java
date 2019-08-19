package pl.flowable.example.rezerwacjawakacji.taskListener;

import lombok.extern.java.Log;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Service;

@Log
@Service
public class TLCreateWeryfikacjaZamowienia implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        log.info("Proces trafil do pracownika w celu weryfikacji");
    }
}
