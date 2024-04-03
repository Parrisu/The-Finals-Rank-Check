package com.parrisu.finals.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class ContestantTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Contestant contestant;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAFinals");
	}
 
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		contestant = em.find(Contestant.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		contestant = null;
	}

	@Test
	void test_Contestant_entity_mapping() {
		assertNotNull(contestant);
		assertEquals("Parrisu#5321", contestant.getName());
		assertEquals(1990, contestant.getRank());
		assertEquals(429, contestant.getChanges());
		assertEquals(17, contestant.getLeagueNumber());
		assertEquals("Diamond 4", contestant.getLeague());
		assertEquals("Parrisu", contestant.getSteamName());
		assertNull(contestant.getXboxName());
		assertNull(contestant.getPsnName());
		assertEquals(0, contestant.getCashouts());


	}

	@Test
	void test_Contestant_Rank_Changes_mapping() {
		assertNotNull(contestant);
		assertTrue(contestant.getManyChanges().size() >= 1);
	}


}
