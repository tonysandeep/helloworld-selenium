pipeline {
    agent {
        label 'winagent'
    }
    stages {
        stage('checkout') {
            steps {
                echo 'checkout'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/tonysandeep/helloworld-selenium.git']]])
            }
        }
        stage('Build') {
            steps {
                echo 'Clean Build'
				bat '"C:\\Program Files (x86)\\Maven\\apache-maven-3.6.3\\bin\\mvn" sonar:sonar clean compile -Dtest=\\!TestRunner* -DfailIfNoTests=false -Dsonar.projectKey=employee_jdbc -Dsonar.host.url=http://35.200.239.255/ -Dsonar.login=aac7cc7809ddc82ce0070e3f74726c71216936b6' 

            }
        }
        stage('Package') {
            steps {
                echo 'Packaging'
                bat '"C:\\Program Files (x86)\\Maven\\apache-maven-3.6.3\\bin\\mvn" package -Dmaven.test.skip=true' 
            }
        }
        
        stage('Deploy') {
            steps { 
                bat '"C:\\Program Files (x86)\\cUrl\\bin\\curl.exe" --upload-file target\\hello-world-war-1.0.0-SNAPSHOT.war "http://tomcat:password@34.93.179.229:8081/manager/text/deploy?path=/winagenttest&update=true"'
                //sh 'curl --upload-file target/*.war "http://tomcat:password@35.200.184.59:8081/manager/text/deploy?path=/hello2&update=true"'
                //withCredentials([usernamePassword(credentialsId: 'nexusadmin', passwordVariable: 'pass', usernameVariable: 'user')]) {
                //    sh 'curl --upload-file target/hello-world-war-1.0.0-SNAPSHOT.war "http://${user}:${pass}@34.93.240.217:8082/manager/text/deploy?path=/hello&update=true"'
                //}
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
				bat '"C:\\Program Files (x86)\\Maven\\apache-maven-3.6.3\\bin\\mvn" test'
                //sh 'mvn test'
            }
        }
	    stage("publish to nexus") {
            steps {
                script {
                    // Read POM xml file using 'readMavenPom' step , this step 'readMavenPom' is included in: https://plugins.jenkins.io/pipeline-utility-steps
                    pom = readMavenPom file: "pom.xml";
                    // Find built artifact under target folder
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    // Print some info from the artifact found
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    // Extract the path from the File found
                    artifactPath = filesByGlob[0].path;
                    // Assign to a boolean response verifying If the artifact name exists
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                // Artifact generated such as .jar, .ear and .war files.
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging]//,
                                // Lets upload the pom.xml file for additional information for Transitive dependencies
                                /*[artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]*/
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }
    }
/*    tools {
        maven 'maven3.3.9'
        jdk 'openjdk8'
    } */
    environment {
        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "35.200.161.61:8081"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "maven-snapshots"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "nexusadmin"
    }
    
    post {
        always {
            echo 'JENKINS PIPELINE'
            /*cucumber buildStatus: 'UNSTABLE',
                failedFeaturesNumber: 1,
                failedScenariosNumber: 1,
                skippedStepsNumber: 1,
                failedStepsNumber: 1,
                classifications: [
                        [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                        [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                ],
                
               sortingMethod: 'ALPHABETICAL',
               trendsLimit: 100 */
        }
        success {
            echo 'JENKINS PIPELINE SUCCESSFUL'
        }
        failure {
            echo 'JENKINS PIPELINE FAILED'
        }
        unstable {
            echo 'JENKINS PIPELINE WAS MARKED AS UNSTABLE'
        }
        changed {
            echo 'JENKINS PIPELINE STATUS HAS CHANGED SINCE LAST EXECUTION'
        }
    }
}
