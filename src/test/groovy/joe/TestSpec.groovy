package joe

import grails.gorm.transactions.Transactional
import grails.testing.gorm.DomainUnitTest
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.support.ConfigurableConversionService
import spock.lang.Specification

class TestSpec extends Specification implements DomainUnitTest<Test> {

    static{
        System.setProperty("grails.gorm.connections", "myDataSource")
    }

    @Override
    Closure doWithSpring() {
        return {
            ConfigurableConversionService conversionService = application.mainContext.getEnvironment().getConversionService()
            conversionService.addConverter(new Converter<String, Map>() {
                @Override
                Map convert(String source) {
                    source.split(",").collectEntries({
                        [(it):it]
                    })
                }
            })
        }
    }

    void testSave() {
        when:
        def bean = new Test(name: 'myName')
        bean.save(flush:true)

        then:
        Test.count() > 0


    }

    void testConstraintsProperties(){
        expect:
        Test.constrainedProperties
    }

    void testValidate() {
        when:
        def bean = new Test()

        then:
        !bean.validate()
    }

    void testValidateWithClosure() {
        when:
        def bean = new Test()
        def validate
        Test.withTransaction{
            validate = bean.validate()
        }
        then:
        !validate
    }

    @Transactional(connection = 'myDataSource')
    void testValidateWithTransactional() {
        when:
        def bean = new Test()

        then:
        !bean.validate()
    }

}

