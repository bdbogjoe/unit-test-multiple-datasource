package joe

import grails.gorm.transactions.Transactional
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestDefaultDataSourceSpec extends Specification implements DomainUnitTest<TestDefaultDataSource> {

    def setup() {
    }

    def cleanup() {
    }

    void testSave() {
        when:
        def bean = new TestDefaultDataSource(name: 'myName')

        then:
        bean.validate()
        and:
        bean.save()
        and:
        TestDefaultDataSource.count() > 0
    }

    void testValidate() {
        when:
        def bean = new TestDefaultDataSource()

        then:
        !bean.validate()
    }
}
