package grails.test.mixin

import grails.test.mixin.web.GroovyPageUnitTestMixin
import spock.lang.Issue
import spock.lang.Specification


@TestMixin(GroovyPageUnitTestMixin)
class GroovyPageUnitTestMixinWithCustomViewDirSpec extends Specification {

    static doWithConfig(c) {
        def customViewDir = new File('.', 'src/test/resources/customviews')
        c.grails.gsp.view.dir = customViewDir.absolutePath
    }
    
    @Issue('GRAILS=11543')
    void 'test something'() {
        when:
        def result = render(template: '/demo/myTemplate')
        
        then:
        result == 'this is a custom template'
    }
}