package org.isetn;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScolA7ApplicationTests {

	@Autowired
	FormationRepository formRep;
	
	@Test
	public void test() {
		System.out.println(formRep.findByEtudiant(31L));
	}
}

