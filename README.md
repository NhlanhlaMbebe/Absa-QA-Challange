### Please ensure you check all files before adding to branch/commit.
## Overview

##This is a guide on how to Use the selenium Framework that has been built and Constructed by Nhlanhla Mbebe for Absa QA challage
###This page also assumes that your PC has been fully configured in-terms of required package installations which are mentioned below
*   Java SDK and JDK have all been properly installed and configured in-terms of proper User Environment variables [JAVA_HOME]
*   An IDE - Intelijj/Eclipse has been installed
*   Valid Maven installation AND config in-terms of proper User Environment variables [MAVEN_HOME /M2_HOME]please follow this link for stepsRemember to add a settings file under the M2 folder within the user's profile folder]
*   Selenium UI with chrome compatible version [Recommended Firefox 35 and selenium 3.2.x]
*   Install Git for Windows and set the SSL feature to off as per below link recommendations

# Usage
*   Within InteliJ, Navigate to the terminal
*   On the terminal type the command "mvn clean install"
*   The project will automatically run.

#             Or

*  Within intelij, Navigate to the Maven panel and expand The Absa profile
*  Click and expand life cycle
*  Click on "Clean"
*  Click on "Install"
*  The project will automatically run.

### Where to find test data
*   Navigate to src >> main >> resources >> test data folder

### Where to find test results
*   On the base of the project an automated folder will be created on every run with outputData_{and the date at which the project was ran}
*   An HTML report will be created with the test results and screenshots will also be in the same folder