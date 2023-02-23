package Project_Mav;

import org.testng.annotations.Test;

public class GroupTest {
  @Test (groups="Smoke",priority=0)
  public void testcase1() 
  {
	  System.out.println("First Smoke testing");
  }
  @Test(groups="Regression",priority=1)
  public void testcase2()
  {
	  System.out.println("first regression testing");
  }
  @Test(groups="Smoke",priority=2)
  public void testcase3()
  {
	  System.out.println("Second Smoke Testing");
  }
 
}
//can run only Smoke tests if in xml file give Smoke