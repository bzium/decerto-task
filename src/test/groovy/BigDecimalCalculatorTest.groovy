import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import plagodzinski.decertotask.DecertoTaskApplication
import plagodzinski.decertotask.domain.actions.ActionType
import plagodzinski.decertotask.domain.calculators.BigDecimalCalculator
import plagodzinski.decertotask.infrastructure.DbNumberSource
import plagodzinski.decertotask.infrastructure.JdkRandomSource
import spock.lang.Specification

@SpringBootTest(classes = DecertoTaskApplication.class)
class BigDecimalCalculatorTest extends Specification {


    @SpringBean
    private JdkRandomSource jdkRandomSource = Mock()

    @SpringBean
    private DbNumberSource randomOrgSource = Mock()

    @Autowired
    private BigDecimalCalculator calculator

    def "Check if calculator calculate correct data for ADD"() {
        given: "Set mocks"
            jdkRandomSource.random() >> 1.0
            randomOrgSource.random() >> 1.0
        when: "Execute calculate"
            def result = calculator.calculate(ActionType.ADD)
        then: "Operation return correct value"
            result == 2.0
    }


}