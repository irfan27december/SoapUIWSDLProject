package samplesoap;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;

public class SOAPInputGenerator {


	public static void test() throws Exception{
		WsdlProject project = new WsdlProject();
		WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, "http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx?WSDL");
		WsdlInterface wsdl = wsdls[0];
		for (Operation operation : wsdl.getOperationList()) {
			WsdlOperation wsdlOperation = (WsdlOperation) operation;
			System.out.println("OP:"+wsdlOperation.getName());
			System.out.println("Request:");
			System.out.println(wsdlOperation.createRequest(true));
			System.out.println("Response:");
			System.out.println(wsdlOperation.createResponse(true));
		}
	}
	public static void main(String[] args) throws Exception {
		//test();
		WsdlProject project = new WsdlProject("C:\\Users\\irfan\\SoapProjects\\CDYNESOAPProject-soapui-project.xml");
		
		TestSuite testSuite = project.getTestSuiteByName( "EmailVerNoTestEmailSoap TestSuite" ); 
		System.out.println("Suite name  is   "+testSuite);
		TestCase testCase = testSuite.getTestCaseByName( "ReturnCodes TestCase" );
		System.out.println("TC name  is   "+testCase);
		TestRunner runner = testCase.run( new PropertiesMap(), false ); 
		Assert.assertEquals( runner.getStatus(), Status.FINISHED); 
		
		//WsdlTestSuite suitename = project.getTestSuiteByName("EmailVerNoTestEmailSoap TestSuite");
		//System.out.println("Suite name  is   "+suitename);
		
		/*WsdlProject project = new WsdlProject();
		WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, "http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx?WSDL");
		WsdlInterface wsdl = wsdls[0];
		for (Operation operation : wsdl.getOperationList()) {
			WsdlOperation wsdlOperation = (WsdlOperation) operation;
			System.out.println("OP:"+wsdlOperation.getName());
			System.out.println("Request:");
			System.out.println(wsdlOperation.createRequest(true));
			System.out.println("Response:");
			System.out.println(wsdlOperation.createResponse(true));
		}*/
	}
}