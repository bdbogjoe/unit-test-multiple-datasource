package joe

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestSpec extends Specification implements DomainUnitTest<Test> {

    Closure doWithConfig() {{ config ->
        config.yourDataSourceName = "DEFAULT"
    }}

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        setup:
        new Test(name: 'myName').save()

        expect:
        Test.count() > 0
    }
}
