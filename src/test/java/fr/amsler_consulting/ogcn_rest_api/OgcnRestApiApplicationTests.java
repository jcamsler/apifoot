package fr.amsler_consulting.ogcn_rest_api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import fr.amsler_consulting.ogcn_rest_api.model.Team;

import java.io.IOException;
import java.util.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class OgcnRestApiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void checkHelloTest() {
		assertTrue(restTemplate.getForObject("/api/teams/hello",
				String.class).contains("hello"));
	}

	@Test
	void checkLowestBudgetTeam() throws IOException {
		Team[] tabTeam = restTemplate.getForObject("/api/teams?size=30",
				Team[].class);

		List<Team> arraylistTeam = Arrays.asList(tabTeam);
		arraylistTeam.sort(new Comparator<Team>() {
			@Override
			public int compare(Team t1, Team t2) {
				return t1.getBudget().compareTo(t2.getBudget());
			}
		});

		Team lowestBudgetTeam = arraylistTeam.get(0);

		assertTrue(lowestBudgetTeam.getAcronym().equals("HAC"));
	}
}
