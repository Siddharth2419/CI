package org.example.ansible

class Gitleaks {
    void call() {
        sh './gitleaks detect -r CredScanReport'
    }
}
