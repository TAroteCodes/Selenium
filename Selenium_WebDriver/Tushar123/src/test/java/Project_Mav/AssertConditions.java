package Project_Mav;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AssertConditions {
  @Test(priority=0)
  public void Name() 
  {
	  AssertJUnit.assertEquals("tushar", "tushar"); //compairing both strings and check is that same or not
	  System.out.println("this is first case");
  }
  @Test(priority=1,dependsOnMethods = "Name")   //if name is pass then only these case run 
  public void Name1()
  {
	  System.out.println("this is my second case");
  }
  @Test(priority=2)
  public void Name2()
  {
	  System.out.println("this is my third case");
  }
}
