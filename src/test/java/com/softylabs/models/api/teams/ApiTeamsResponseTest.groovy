package com.softylabs.models.api.teams


import spock.lang.Specification

class ApiTeamsResponseTest extends Specification {
    def "try to build ApiTeamsResponse"() {
        given:
        List<List<TeamFromAPI>> list = new ArrayList<>()
        list.add(new ArrayList<TeamFromAPI>())
        list.get(0).add(new TeamFromAPI())

        TeamsResponse response = new TeamsResponse()
        response.setResults(1)
        response.setStandings(list)

        ApiTeamsResponse apiTeamsResponse = new ApiTeamsResponse()
        apiTeamsResponse.setTeamsResponse(response)

        expect:
        apiTeamsResponse.getTeamsResponse().getResults() == 1
        apiTeamsResponse.getTeamsResponse().getStandings().size() == 1
    }
}
