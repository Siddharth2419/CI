package org.example.ansible
def call(String path) {
    stage('Ansible syntax-check') {
        script {
            echo "Checking the syntax of your ansible role";
            sh "ansible-playbook ${path} --syntax-check"
        }
    }
}
