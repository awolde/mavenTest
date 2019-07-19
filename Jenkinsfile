pipeline { 
    agent any  
    tools {
        maven 'maven'
        //jdk 'jdk8'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: "master", changelog: true, url: "https://github.com/awolde/mavenTest.git"
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
        }
        stage('Deploy') {
            steps {
                sh """ IMAGE=\$(ssh awolde@172.17.0.1 docker ps | grep httpbin | awk '{print \$NF}')
                    echo \$IMAGE
                    if [ \$IMAGE != '' ]; then
                        ssh awolde@172.17.0.1 docker kill \$IMAGE
                    fi
                    sleep 3
                    ssh awolde@172.17.0.1 docker run -p 8090:80 -d kennethreitz/httpbin """
                }
            }
        stage ('Notify') {
            steps {
                echo "Jira release closed"
                
            }
        }    
    }
}
