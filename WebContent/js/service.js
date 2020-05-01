

/**
 * @name WeeklyNewsPerformanceTableFactory
 * @desc this factory will populate Weekly News Performance with data when it have returned with success
 */

AppModule
        .factory('appFactory', ['$http', 'API_URL', function ( $http, API_URL) {

                /**
                 * @namespace CookiesParamGetter
                 * @desc get parametres from cookies to be used on services url
                 * @param {String} $cookies.get('currentLanguage');
                 *  
                 */
        
                return {
                    request: $http.get("/donManagement/api/dons/getAll")
                };
            }]);