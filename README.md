  # TaskFoRSynack
**provide this command to run test on your device (you should be in the same directory)**<br />
*mvn clean site -Dtest=TestLabriary; open ./target/site/allure-maven-plugin.html*<br />
^Notes: If report is empty with your default browser, try to use FireFox browser to open this report<br />
Also, Video record of tests is above <br />
 ## Short description of tests<br />
>1.logInPageHappyPath - Login into the system with correct credentials, and in SecureAreaPege test verifies if all object in place (that means test is on the correct page and user is successfully  registered)<br />
>2.logInPageErrorHandling - Test for error handling for Log In page, test is checking if the error message is correct <br />
>3.moveMouseHover- Test which moves mouse hover each element and then taking text from each user <br />
>4. dynamicContnt- Test which is grabbing text from each 'User description' then refreshes the page and then again grabs text from 'User description' and in the end verified if text from the first time is not the same with text from second <br />
>5. notificationMessageTestForNegativeMessag - Test which is clicking on the 'Click On' button until message will be negative<br />
>6. notificationMessageTestForPositiveMessage- Test which is clicking on the 'Click On' button until message will be positive<br />
>7. disappearingElements- Test which is refreshing page (max 10 times) and checking if all elements are present if any of them is disappeared Test Fail (in our case Test always fail)<br />
I'm afraid that I didn't understand tasks correctly, please let me know if I need to change something !!!!!!<br />
