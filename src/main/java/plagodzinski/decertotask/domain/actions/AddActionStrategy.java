package plagodzinski.decertotask.domain.actions;

import org.springframework.stereotype.Service;
import plagodzinski.decertotask.infrastructure.NumberSource;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AddActionStrategy implements ActionStrategy<BigDecimal> {

    private final List<NumberSource<BigDecimal>> numberSourceList;

    public AddActionStrategy(final List<NumberSource<BigDecimal>> numberSourceList) {
        this.numberSourceList = numberSourceList;
    }

    @Override
    public boolean accept(final ActionType actionType) {
        return actionType == ActionType.ADD;
    }

    @Override
    public BigDecimal calculate() {
        BigDecimal result = new BigDecimal("0.0");
        for(final NumberSource<BigDecimal> ns : numberSourceList) {
            result = result.add(ns.random());
        }
        return result;
    }
}
