pipleline{
    agent any
    triggers{
        pollSCM('* * * * *')
    }
    stages{
        stage("Compile"){
            steps{
                sh "./gradlew compileJava"
            }
        }
        stage("Unit test"){
            steps{
                sh "./gradlew test"
            }
        }
        stage("Code coverage"){
            steps{
                sh "./gradlew jacocoTestReport"
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }//if anyone commits code that is not well-covered with tests, the build will fail
        stage("Code coverage"){
            steps{
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: "JaCoCo Report"
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }//this stage copies the generated jaCoCo report to the Jenkins output
        stage("static code analysis"){
            steps{
                sh "./gradlew checkstyleMain"
                publishHTML (target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: "Checkstyle Report"
                ])
            }
        }//if anyone commits a file with a public class without Javadoc, the build will fail
    }

}