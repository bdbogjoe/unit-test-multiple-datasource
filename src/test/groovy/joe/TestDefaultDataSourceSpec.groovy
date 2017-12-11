package joe

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestDefaultDataSourceSpec extends Specification implements DomainUnitTest<TestDefaultDataSource> {

    def setup() {
    }

    def cleanup() {
    }

    void "test save"() {
        setup:
        new TestDefaultDataSource(name: 'myName').save()

        expect:
        TestDefaultDataSource.count() > 0
    }
}
