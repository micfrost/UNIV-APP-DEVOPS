pipeline {
    agent any

        tools {
        jdk 'JDK17'
        maven 'M3'
    }

    stages {
        stage('Build Backend') {
            steps {
                echo 'Building the backend...'
                dir('backend') {
                    // Budujemy aplikację Maven, żeby stworzyć plik .jar
                    sh 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Frontend') {
            steps {
                echo 'Building the frontend...'
                // Nie musimy tu nic robić, bo Dockerfile sam zbuduje front
            }
        }
        stage('Deploy with Docker Compose') {
            steps {
                echo 'Deploying the application...'
                // Uruchamiamy docker-compose, który zbuduje obrazy i uruchomi kontenery
                sh 'docker-compose up -d --build'
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
            // Sprzątanie po budowaniu, aby nie zostawiać "wiszących" obrazów
            sh 'docker image prune -f'
        }
    }
}
// Uwaga: Ten Jenkinsfile używa Mavena wewnątrz kontenera Jenkinsa. Może być konieczne skonfigurowanie go w Tools -> Global Tool Configuration w Jenkinsie. Prostszym podejściem na start jest budowanie pliku .jar lokalnie, a Jenkinsfile będzie tylko orkiestrował docker-compose. Powyższy przykład jest bardziej "produkcyjny".