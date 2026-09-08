package dio.proposal_managemnet.proposal.application.List;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Factory {
    private final Map<AccessScope, Strategy> strategies;

    public Factory(List<Strategy> strategies, Map<AccessScope, Strategy> strategies1) {
        this.strategies = strategies
                .stream()
                .collect(
                        Collectors.toMap(
                                Strategy::getScope,
                                Function.identity()));
    }
    public Strategy getStrategy(AccessScope scope) {
        return strategies.get(scope);
    }
}
