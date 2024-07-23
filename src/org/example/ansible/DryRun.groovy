package org.example.ansible
def call(String path) {
    stage('Dry run') {
        script {
                echo "Checking your ansible role";
                sh "ansible-playbook ${path} --check"
        }
    }
}
