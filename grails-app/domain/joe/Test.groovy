package joe

import grails.util.Holders

class Test {

    String name

    static mapping = {
        datasource Holders.config.yourDataSourceName
    }

    static constraints = {
    }
}
