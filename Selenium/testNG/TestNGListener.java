package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
// cac ham nay on finish, on start,apply cho cac class trong package testNG
	//cac ham con lai apply cho cac test case
	@Override
	//sau khi chay xong thi lam gi
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//truoc khi chay thi am gi
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	// fail bao nhieu % thi lam gi ( it dung)
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// fai thi chup hinh va add vao report
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// skip thi lam gi
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// truoc khi start thi lam gi
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// sau kbhi thanh cong thi lam gi
		
	}
// class ke thua 1 class : extends
	// class thuc hien 1 interface : implements
}
