package org.themoviedb;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SuppressWarnings("PMD.TestClassWithoutTestCases")
@SpringBootTest(classes = Application.class)
public class BaseTest extends AbstractTestNGSpringContextTests {
}
