package joe

import grails.testing.gorm.DomainUnitTest
import org.grails.datastore.mapping.core.AbstractDatastore
import org.grails.datastore.mapping.simple.SimpleMapDatastore
import spock.lang.Specification

class TestSpec extends Specification implements DomainUnitTest<Test> {

    def setup() {
    }

    def cleanup() {
    }

    void "test save"() {
        setup:
        new Test(name: 'myName').save(flush: true)

        expect:
        Test.count() > 0
    }

	@Override
	AbstractDatastore getDataStore() {
		return new SimpleMapDatastore(['myDataSource'], Test)
	}
}
