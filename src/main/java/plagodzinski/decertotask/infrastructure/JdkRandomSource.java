package plagodzinski.decertotask.infrastructure;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class JdkRandomSource implements NumberSource<BigDecimal> {
    @Override
    public BigDecimal random() {
        return BigDecimal.valueOf(Math.random());
    }
}
