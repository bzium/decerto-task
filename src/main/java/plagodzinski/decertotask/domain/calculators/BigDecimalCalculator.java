package plagodzinski.decertotask.domain.calculators;

import org.springframework.stereotype.Service;
import plagodzinski.decertotask.domain.actions.ActionStrategy;
import plagodzinski.decertotask.domain.actions.ActionType;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BigDecimalCalculator {
    private final List<ActionStrategy<BigDecimal>> actionStrategyList;


    public BigDecimalCalculator(final List<ActionStrategy<BigDecimal>> actionStrategyList) {
        this.actionStrategyList = actionStrategyList;
    }

    public BigDecimal calculate(final ActionType actionType) {
        return actionStrategyList
                .stream()
                .filter(item -> item.accept(actionType))
                .findFirst()
                .map(ActionStrategy::calculate)
                .orElseThrow(() -> new IllegalArgumentException("Not found strategy for " + actionType));
    }


}
