package joe

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class TestSpec extends Specification implements DomainUnitTest<Test> {


    def cleanup() {
    }

    @Unroll("Test #nb")
    void testSave() {
        when:
        for (int cpt = 0; cpt < nb; cpt++) {
            new Test(name: 'myName').save(flush: true)
        }

        then:
        Test.count() == expected

        where:
        nb | expected
        1  | 1
        2  | 2

    }
}
