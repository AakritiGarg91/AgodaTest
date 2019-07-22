# AgodaTest

AgodaTest/src/main/java/agodaTest/agoda/ChangePasswordClass.java : Includes all conditiond which need to verify for password check.
It has ChangePassword(oldPassword: String, newPassword: String) which is calling all helper functions.

AgodaTest/src/test/java/agodaTest/agoda/ChangePasswordTest.java : Includes 21 testcases with comments what we are testing in that testCase.

If we want to add new test scenario, include it in testData() function in ChangePasswordTest.java

Condition: password is not similar to old password < 80% match 

We have function MatchOldPassword(String oldPassword , String newPassword) which is return true and false.

Please open the project in eclipse. Pom.xml will fetch all your dependencies.

Steps to execute:
1. Open ChangePasswordTest.java
2. right click and Run As TestNGTest

AgodaTest/test-output/emailable-report.html : Report of the testcases.


 
