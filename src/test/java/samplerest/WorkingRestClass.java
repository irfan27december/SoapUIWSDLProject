package samplerest;

import java.io.IOException;
import java.net.URL;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class WorkingRestClass {
	WsdlProject project;
	String projectFile = "C:\\Users\\irfan\\SoapProjects\\Working-REST-Project-soapui-project.xml";

	@BeforeClass
	public void beforeClass() {
		try{
			project = new WsdlProject( projectFile ,"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void soapUIRestTestRunner() throws XmlException, IOException, SoapUIException {
		try{
			TestSuite testSuite = project.getTestSuiteByName( "Service Endpoint TestSuite" ); 
			System.out.println("Suite name  is   "+testSuite);
			TestCase testCase = testSuite.getTestCaseByName( "Resource List Users TestCase" );
			System.out.println("TC name  is   "+testCase);
			TestRunner runner = testCase.run( new PropertiesMap(), false ); 
			Assert.assertEquals( runner.getStatus(), Status.FINISHED); 
			Assert.assertEquals("Michael", "Michael", "Actual matches expected");
		}
		catch(Exception e){
			Assert.assertTrue(false);
		}
	}
}
