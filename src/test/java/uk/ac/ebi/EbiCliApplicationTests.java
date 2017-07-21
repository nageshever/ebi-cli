package uk.ac.ebi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EbiCliApplicationTests {



	@Autowired
	Main main;

	@Test (expected = Exception.class)
	public void contextLoads() throws Exception{
		main.returnOrderedAccessionNumbers(null);
	}

	@Test
	public void specialCharacter() throws Exception{
		assertEquals("A00000, A0001, ABCDEFG1, DRR2110012, ERR000111-ERR000113, ERR000115-ERR000116, ERR100114," +
						" ERR200000001-ERR200000003, SRR211001",

				main.returnOrderedAccessionNumbers("A00000,A0001,ERR000111,ERR000112,ERR000113,ERR000115,ERR000116," +
						"ERR100114,ERR200000001,ERR200000002,ERR200000003,DRR2110012,SRR211001,ABCDEFG1,234uoidfn"
				));
	}

	@Test
	public void greenPath() throws Exception{
		assertEquals("A00000, A0001, ABCDEFG1, DRR2110012, ERR000111-ERR000113, ERR000115-ERR000116, ERR100114," +
						" ERR200000001-ERR200000003, SRR211001",

				main.returnOrderedAccessionNumbers("A00000,A0001,ERR000111,ERR000112,ERR000113,ERR000115,ERR000116," +
						"ERR100114,ERR200000001,ERR200000002,ERR200000003,DRR2110012,SRR211001,ABCDEFG1"
				));
	}

}
