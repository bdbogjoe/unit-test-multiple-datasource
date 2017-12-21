package joe

import grails.gorm.transactions.Transactional
import grails.testing.gorm.DataTest
import org.grails.datastore.mapping.core.connections.ConnectionSource
import org.grails.datastore.mapping.simple.SimpleMapDatastore
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TestSpec extends Specification implements DataTest {

    @Shared
    @AutoCleanup
    SimpleMapDatastore dataStore = new SimpleMapDatastore([ConnectionSource.DEFAULT, "myDataSource"], Test)


    void testSave() {
        when:
        def bean = new Test(name: 'myName')

        then:
        bean.validate()
        and:
        bean.save()
        and:
        Test.count() > 0


    }

    void testValidate() {
        when:
        def bean = new Test()

        then:
        !bean.validate()
    }
}

