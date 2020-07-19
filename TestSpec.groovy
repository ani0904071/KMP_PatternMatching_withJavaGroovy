def "test patternMatching"() {

        String pattern1 = 'abcd'
        String description1 = 'testabcdtest'

        String pattern2 = 'PARKEERVERGUNNING'
        String description2 = '/TRTP/IDEAL/IBAN/BIC/BNGHNL2G/NAME/GEMEENTE DEN HAAG/REMI/ ' +
                'PARKEERVERGUNNING BEWONERS/BEZOE DEN'

        String pattern3 = '20268'
        String description3 = '0670059720268 testPARKEERVERGUNNINGtest BEWONERS/BEZOE DEN HAAG/EREF/04-03-2019 18:12'

        String pattern4 = '20268'
        String description4 = 'testPARKEERVERGUNNINGtest BEWONERS/BEZOE DEN HAAG/EREF/04-03-2019 18:12'

        String pattern5 = ''
        String description5 = 'testPARKEERVERGUNNINGtest BEWONERS/BEZOE'

        String pattern6 = 'BEWONERS/BEZOE'
        String description6 = 'testPARKEERVERGUNNINGtest BEWONERS/BEZOE'

        String pattern7 = 'BEZOE'
        String description7 = 'ZOE'

        assert service.hasPaymentMatch(pattern1, description1) == true

        assert service.hasPaymentMatch(pattern2, description2) == true

        assert service.hasPaymentMatch(pattern3, description3) == true

        assert service.hasPaymentMatch(pattern4, description4) == false

        assert service.hasPaymentMatch(pattern5, description5) == false

        assert service.hasPaymentMatch(pattern6, description6) == true

        assert service.hasPaymentMatch(pattern7, description7) == false

        when:
        service.hasPaymentMatch(pattern7, description7)
        then:
        service.hasPaymentMatch(pattern7, description7) == false
    }
