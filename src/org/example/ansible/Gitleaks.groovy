package org.example.ansible
def call(String path) {
    stage('CredScanning') {
        script {
            sh "gitleaks detect --report-path gitleaks-report.json"
        }
    }
}
