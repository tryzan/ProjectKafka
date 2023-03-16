package com.unittestdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UnitTestDemoApplicationTests {

	@Test
	void contextLoads() {
		List<String> nama = new ArrayList<>(Arrays.asList("putra", "wicaksana"));
		Assertions.assertEquals(true,nama.contains("wicaksana"));
	}

}
