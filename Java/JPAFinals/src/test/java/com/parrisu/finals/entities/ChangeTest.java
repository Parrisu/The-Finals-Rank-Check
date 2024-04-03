package com.parrisu.finals.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Month;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class ChangeTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Change change;

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
		change = em.find(Change.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		change = null;
	}

	@Test
	void test_Contestant_entity_mapping() {
		assertNotNull(change);
		assertEquals(2458, change.getRank());
		assertEquals(34, change.getChange());
		assertEquals(30, change.getUpdate_date().getDayOfMonth());
		assertEquals(Month.MARCH, change.getUpdate_date().getMonth());
		assertEquals(2024, change.getUpdate_date().getYear());

	}

	@Test
	void test_Change_Contestant_mapping() {
		assertNotNull(change);
		assertEquals("Parrisu#5321", change.getContestant().getName());
	}


}
