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

        assert KMP_Custom.KMPSearch(pattern1.trim(), description1.trim()) == true

        assert KMP_Custom.KMPSearch(pattern2.trim(), description2.trim()) == true

        assert KMP_Custom.KMPSearch(pattern3.trim(), description3.trim()) == true

        assert KMP_Custom.KMPSearch(pattern4.trim(), description4.trim()) == false

        assert KMP_Custom.KMPSearch(pattern5.trim(), description5.trim()) == false

        assert KMP_Custom.KMPSearch(pattern6.trim(), description6.trim()) == true

        assert KMP_Custom.KMPSearch(pattern7.trim(), description7.trim()) == false

        when:
        KMP_Custom.KMPSearch(pattern7.trim(), description7.trim())
        then:
        KMP_Custom.KMPSearch(pattern7.trim(), description7.trim()) == false
    }
