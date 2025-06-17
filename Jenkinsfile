pipeline {
    agent any // Agent domyślny, na którym NIE MA narzędzi Dockera

    tools {
        jdk 'JDK17'
        maven 'M3'
    }

    stages {
        stage('Build Backend') {
            // Ten etap działa na agencie domyślnym, bo ma JDK i Maven
            steps {
                echo 'Building the backend...'
                dir('backend') {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Build Frontend') {
            // Ten etap też działa na agencje domyślnym
            steps {
                echo 'Building the frontend...'
            }
        }

        // --- TO JEST KLUCZOWE ROZWIĄZANIE ---
        stage('Deploy with Docker Compose') {
            // Ten etap uruchomi się w NOWYM, TYMCZASOWYM kontenerze
            agent {
                // Używamy oficjalnego obrazu Docker, który ma w sobie komendy `docker` i `docker compose`
                docker { image 'docker:26.1.4' }
            }
            steps {
                echo 'Deploying the application...'
                // Ta komenda wykona się wewnątrz kontenera 'docker:26.1.4' i będzie działać
                sh 'docker compose up -d --build'
            }
        }
    }
}
// Uwaga: Ten Jenkinsfile używa Mavena wewnątrz kontenera Jenkinsa. Może być konieczne skonfigurowanie go w Tools -> Global Tool Configuration w Jenkinsie. Prostszym podejściem na start jest budowanie pliku .jar lokalnie, a Jenkinsfile będzie tylko orkiestrował docker-compose. Powyższy przykład jest bardziej "produkcyjny".