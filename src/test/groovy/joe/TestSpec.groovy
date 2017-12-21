package joe

import grails.testing.gorm.DataTest
import org.grails.datastore.mapping.core.connections.ConnectionSource
import org.grails.datastore.mapping.simple.SimpleMapDatastore
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TestSpec extends Specification implements DataTest {

    @Shared @AutoCleanup SimpleMapDatastore dataStore = new SimpleMapDatastore([ConnectionSource.DEFAULT, "myDataSource"], Test)

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
        2  | 3

    }
}

