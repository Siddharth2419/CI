package org.mygurukulam.ansible
def call(String path) {
    stage('ansible-lint') {
        script {
            echo "Running ansible-lint on your main file ${path}";
            sh "ansible-lint ${path}"
        }
    }
}
