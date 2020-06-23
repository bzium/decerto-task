package plagodzinski.decertotask.infrastructure;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

@Service
public class DbNumberSource implements NumberSource<BigDecimal> {

    public static final String SELECT_RANDOM_QUERY = "SELECT RANDOM()";
    private final EntityManager entityManager;

    public DbNumberSource(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public BigDecimal random() {
        final Query query = entityManager.createNativeQuery(SELECT_RANDOM_QUERY);
        final double randomNum = (Double) query.getSingleResult();
        return BigDecimal.valueOf(randomNum);

    }
}
