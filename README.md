# qtm-QAF-MAVEN-example

This is automation project skeleton to start with using Gradle. Please refer [documentaion](https://qmetry.github.io/qaf/) for more help.


This is sample project with Gradle directory structure:
 
The 'config' directory contains testng.xml file, and is a place holder for configuration files.

The 'resources' directory contains all required resources including properties files and data files, and is a place holder for other resources.

The 'src' directory contains all java files and is a place holder for other java files.

The 'test-results' directory contains result files.

The 'scenarios' directory is the default place holder for all the scenario files. 

Note: This sample project uses chrome driver and it requires chrome driver binary.
You need to download and set webdriver.chrome.driver property in application.properties file with driver binary path.

Please refer https://qmetry.github.io/qaf/

## How to integrate QTM Maven Plugin?

- Step 1 Add QTM Maven Plugin to upload test-result files to QMetry Test Management.
To add QTM Maven Plugin in the project add following code in `pom.xml`
```
<pluginRepositories>
	<pluginRepository>
		<id>qmetry-test-management-maven-plugin-mvn-repo</id>
		<url>https://raw.github.com/qmetry/qmetry-test-management-maven-plugin/mvn-repo/</url>
		<snapshots>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		</snapshots>
	</pluginRepository>
</pluginRepositories>

<build>
	<plugins>
		<plugin>
			<groupId>com.qmetry</groupId>
			<artifactId>qmetry-test-management-maven-plugin</artifactId>
			<configuration>
				<url>https://testmanagement.qmetry.com/</url>
				<apikey>cwmtMmB6YXo7Sj0YEchpJYiZgt3nd8TZCmtsDwD</apikey>
				<filepath>/test-results</filepath>
				<format>qas/json</format>
				<project>Demo Project</project>
				<testsuite>GPT-TS-26</testsuite>
				<release>Demo Release</release>
				<cycle>Demo Cycle</cycle>
				<build>Demo Build</build>
				<platform>Chrome</platform>
			</configuration>
		</plugin>
	</plugins>
</build>
```
Please refer https://github.com/qmetry/qmetry-test-management-maven-plugin for more information

- Step 2 To run the project, from command prompt go to project home and run 
```
mvn test qtm:uploadresults
```

- Step 3 Response
```
[INFO] --- qmetry-test-management-maven-plugin:1.0.1:uploadresults (default-cli) @ qaf-blank-project-maven ---
[INFO] Format:qas/json
[INFO] File Path:D:/Maven Plugin/qtm-QAF-MAVEN-example/test-results/
[INFO] Project:Demo Project
[INFO] Release:Demo Release 
[INFO] Cycle:Demo Cycle
[INFO] Build:Demo Build
[INFO] Testsuite:GPT-TS-26
[INFO] Platform:Chrome
[INFO] Creating Zip file..........
[INFO] Created Zip File:D:/Maven Plugin/qtm-QAF-MAVEN-example/test-results/02_Nov_2018_01_38_PM/testresult.zip
[INFO] Uploading Test Results..........
[INFO] Test results uploaded successfully
[INFO] Response-->{"code":"CO.IMPORT_SCHEDULED","data":[{"testsuiteId":"GPT-TS-26","dropID":1407,"entityURL":"https://testmanagement.qmetry.com/#/test-suite/92558","buildID":7150,"id":28819,"platformID":4866}],"success":true}
```

- Step 4 View results in QMetry Test Management
To view result login to QMetry Test Management and go to this url `https://testmanagement.qmetry.com/#/test-suite/92558` 
![Test Results](img/qtm-result.png?raw=true "Title")