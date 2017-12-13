package joe

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Unroll

class TestSpec extends HibernateSpec implements DomainUnitTest<Test> {


    def cleanup() {
    }

    @Unroll("Test #nb")
    void testSave() {
        when:
        for(cpt in nb) {
            new Test(name: 'myName').save(flush: true)
        }

        then:
        Test.count() ==expected

        where:
        nb | expected
        1  | 1
        2  | 2

    }
}
