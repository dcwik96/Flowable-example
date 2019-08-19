package pl.flowable.example.rezerwacjawakacji.executionListener;

import lombok.extern.java.Log;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Service;

@Log
@Service
public class ELEndProcessEndEvent implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) {
        log.info("Koniec procesu");
    }
}
