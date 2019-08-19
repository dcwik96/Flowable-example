package pl.flowable.example.rezerwacjawakacji.delegateExpression;

import lombok.extern.java.Log;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Log
@Service
public class STCofnijPlatnosc implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        log.info("Service task: Cofnij Platnosc");
    }
}
