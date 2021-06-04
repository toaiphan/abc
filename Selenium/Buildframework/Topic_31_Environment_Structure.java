package Buildframework;

public class Topic_31_Environment_Structure{

}

//Môi trường :
//-          Vẫn dung JDK 1.8.xx vì nó ổn định : trên 1 máy chỉ cài 1 version
//-          Eclipse cứ dung bản mới nhất : dung bản java developer( ko dung bản interprise vì nặng)
//-          Selenium,testng,firefox ,gecko driver ,chrome ,chromedriver ,chropath ,git scm, mới nhất
//-          test ng plugin 6.14.3
//-          bai hương dẫn có thể xem lại trang automationfc.com
//Structure : build khung trước
//-          Tao project: new -> java project ->ten : hybrid-pom-nopcommerce
//-          Tao cac source folder theo thu tu : testcases-2,testdata-3,actions-4,interfaces-5,resources-6,javaCore-1( chi de hoc, demo thoi, ko co trong du an that),JRE ở cuối cùng
//- Tao cac folder : libraries, browserDriver,downloadFiles,uploadFiles,reportHTML,autoITScript,drapAndDrop
//- trong source folder javacore : tao 2 package : basic và OOP
//Môi trường :
//-          Vẫn dung JDK 1.8.xx vì nó ổn định : trên 1 máy chỉ cài 1 version
//-          Eclipse cứ dung bản mới nhất : dung bản java developer( ko dung bản interprise vì nặng)
//-          Selenium,testng,firefox ,gecko driver ,chrome ,chromedriver ,chropath ,git scm, mới nhất
//-          test ng plugin 6.14.3
//-          bai hương dẫn có thể xem lại trang automationfc.com
//Structure : build khung trước
//-          Tao project: new -> java project ->ten : hybrid-pom-nopcommerce
//-          Tao cac source folder theo thu tu : testcases-2,testdata-3,actions-4,interfaces-5,resources-6,javaCore-1( chi de hoc, demo thoi, ko co trong du an that),JRE ở cuối cùng
//- Tao cac folder : libraries, browserDriver,downloadFiles,uploadFiles,reportHTML,autoITScript,drapAndDrop
//- trong source folder javacore : tao 2 package : basic và OOP
//- trong testcases: tao package facebook.web.users(ten cong ty.tenduan.ten chucnang), trong package đó tạo class Login.java,Register.java
//-trong testdata : tao package :facebook.web.users
//-actions tao cac package :commons (co cac class nhu AbstractPage,AbstractTest,GlobalConstants),pageObjects(co cac class nhu LoginPageObject,RegisterPageObject...),
//reportConfig(ReportNGListener,ExtendListener),retryConfig(RetryTestFailed)
// trong interfaces : tao package pageUIs , moi class ben pageobject se co 1 class trong pageUIS như LoginPageUI...

//tao file xml ( bang cach tao class testNG) ten file la: runNopCommerceTestcases.xml , name="Suite" doi thanh NopCommerce, testname="Run on Firefox"=>move qua resources
//trong resources: tao 1 so file :env.dev.properties ,env.testing.properties ,env.staging.properties,log4j.xml (can add <?xml)