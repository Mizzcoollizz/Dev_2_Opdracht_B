Feature: JSON Message API Reports Test
    
    Scenario: get CityGis report
        Given I have an jsonObject with type "getReport" and reportType "CityGis" and unitId "999"
        When I ask the server to get the report
        Then it should anwer with a jsonObject with type "report" and reportType "CityGis" and an "city_gis_data" attribute

    Scenario: get Control Room report
        Given I have an jsonObject with type "getReport" and reportType "Control_Room" and unitId "999"
        When I ask the server to get the report
        Then it should anwer with a jsonObject with type "report" and reportType "Control_Room" and an "uncommon_times" attribute

    Scenario: get Connections report
            Given I have an jsonObject with type "getReport" and reportType "Connections" and unitId "999"
            When I ask the server to get the report
            Then it should anwer with a jsonObject with type "report" and reportType "Connections" and an "best_tcp_connections" attribute

    Scenario: get Authority report
               Given I have an jsonObject with type "getReport" and reportType "Authority" and unitId "999"
               When I ask the server to get the report
               Then it should anwer with a jsonObject with type "report" and reportType "Authority" and an "most_visited" attribute
