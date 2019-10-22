package samplesoap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;

public class soapuitest {

	WsdlProject project;
	String projectFile = "C://Users//irfan//SoapProjects//BankBLZService-soapui-project.xml";
	
	//String projectFile = "C://Users//irfan//SoapProjects//www-thomas-bayer-soapui-project-NEW.xml";
	

	@BeforeClass
	public void beforeClass() {
		try{
			project = new WsdlProject( projectFile ,"");
			System.out.println("WSDL Project xml file  is  "+projectFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority=1)
	public void TestSoapXML1() {
		try{
			TestSuite testSuite = project.getTestSuiteByName( "TestSuite 1" ); 
			System.out.println("Test suite name is "+testSuite);
			TestCase testCase = testSuite.getTestCaseByName( "TestCase 1" );
			TestRunner runner = testCase.run( new PropertiesMap(), false ); 
			Assert.assertEquals( runner.getStatus(), Status.FINISHED); 
			Assert.assertEquals("Berlin", "Berlin");
			//Assert.assertEquals("10591", "10591");			
		}
		catch(Exception e){
			Assert.assertTrue(false);
		}
	}
	
	/*
	@Test(priority=2)
	public void TestSoapXML2() {
		try{
			TestSuite testSuite = project.getTestSuiteByName( "BLZServiceSOAP12Binding TestSuite" ); 
			System.out.println("Test suite name is"+testSuite);
			TestCase testCase = testSuite.getTestCaseByName( "getBank TestCase" );
			TestRunner runner = testCase.run( new PropertiesMap(), false ); 
			Assert.assertEquals( runner.getStatus(), Status.FINISHED); 
			Assert.assertEquals("Hamburg", "Hamburg");
			Assert.assertEquals("22772", "22772");			
		}
		catch(Exception e){
			Assert.assertTrue(false);
		}
	}
	
*/
/*	@Test(priority=0)
	public void mia(){
		SoapUITestCaseRunner soapUITestCaseRunner = new SoapUITestCaseRunner();
		soapUITestCaseRunner.setProjectFile("C://ME//soapUI//www-thomas-bayer-soapui-project-NEW.xml");
		try {
			//call run method to execute all test of project.
			soapUITestCaseRunner.run();
			soapUITestCaseRunner.getAssertionResults().containsValue("Berlin");
		} catch (Exception e) {                                                          
			e.printStackTrace();
		}
	}*/


}

